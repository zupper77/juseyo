/**
 * @file 파일명
 * @brief   간단한 설명 
 * @author  팀/파트 명
 * @author  작성자
 * @date    생성: 생성일 (yyyy-mm-dd)
 * @date    최종수정: 최종 수정일 (yyyy-mm-dd)
 */
package com.juseyo.commons.lib.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFPictureData;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFShape;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @brief  클래스 이름
 * @author  팀/파트/이름
 * @version 버전 (n.n) - 레드마인의 일감 버전 기준
 * @date    생성: 생성일 (yyyy-mm-dd)
 * @date    최종수정: 생성일 (yyyy-mm-dd)
 * @remark 
 */
@Repository("ExcelUtil")
public class ExcelUtil {
    private static final Logger logger = LoggerFactory.getLogger(ExcelUtil.class);
    
    private StringBuilder out;
    private SimpleDateFormat sdf;
    private HSSFWorkbook book;
    private HSSFPalette palette;
    private FormulaEvaluator evaluator;
    private short colIndex;
    private int rowIndex, mergeStart, mergeEnd;
    // Row -> Column -> Pictures
    private Map<Integer, Map<Short, List<HSSFPictureData>>> pix = new HashMap<Integer, Map<Short, List<HSSFPictureData>>>();
    
    
    /**
     * @brief 메서드 설명 
     * @details 상세 설명
     * @param  파라미터명 파라미터 설명
     * @return 리턴 타입 (리턴이 없으면 생략)
     */
    public String getExcelToHTML(String filepath, String filename) throws IOException {
        out = new StringBuilder(65536);
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        if(filepath == null || filepath.equals("") || filename == null || filename.equals("")){
            return "";
        }
        
        InputStream in = new FileInputStream(filepath + filename);
        
        // 파일 추가. 2007 이후 버전은 제공 되지 않음.
        book = new HSSFWorkbook(in);
        palette = book.getCustomPalette();
        evaluator = book.getCreationHelper().createFormulaEvaluator();
        
        for (int i = 0; i < book.getNumberOfSheets(); ++i) {
            table(book.getSheetAt(i));
        }
        
        return out.toString();
    }
    
    /**
     * @brief 메서드 설명 
     * @details 상세 설명
     * @param  파라미터명 파라미터 설명
     * @return 리턴 타입 (리턴이 없으면 생략)
     */
    private void table(final HSSFSheet sheet) {
        if (sheet == null) return;
        
        if (sheet.getDrawingPatriarch() != null) {
            final List<HSSFShape> shapes = sheet.getDrawingPatriarch().getChildren();
            
            for (int i = 0; i < shapes.size(); ++i) {
                if (shapes.get(i) instanceof HSSFPicture) {
                    try {
                        // Gain access to private field anchor.
                        final HSSFShape pic = shapes.get(i);
                        final Field f = HSSFShape.class.getDeclaredField("anchor");
                        f.setAccessible(true);
                        final HSSFClientAnchor anchor = (HSSFClientAnchor) f.get(pic);
                        
                        // Store picture cell row, column and picture data.
                        if (!pix.containsKey(anchor.getRow1())) {
                            pix.put(anchor.getRow1(), new HashMap<Short, List<HSSFPictureData>>());
                        }
                        if (!pix.get(anchor.getRow1()).containsKey(anchor.getCol1())) {
                            pix.get(anchor.getRow1()).put(anchor.getCol1(),new ArrayList<HSSFPictureData>());
                        }
                        pix.get(anchor.getRow1()).get(anchor.getCol1()).add(book.getAllPictures().get(((HSSFPicture) pic).getPictureIndex()));
                    } 
                    catch (final Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        out.append("<table cellspacing='0' style='border-spacing:0; border-collapse:collapse;'>\n");
        for (rowIndex = 0; rowIndex < sheet.getPhysicalNumberOfRows(); ++rowIndex) {
            tr(sheet.getRow(rowIndex));
        }
        out.append("</table>\n");
    }

    /**
     * @brief 메서드 설명 
     * @details 상세 설명
     * @param  파라미터명 파라미터 설명
     * @return 리턴 타입 (리턴이 없으면 생략)
     */
    private void tr(final HSSFRow row) {
        if (row == null) return;

        out.append("<tr ");
        // Find merged cells in current row.
        for (int i = 0; i < row.getSheet().getNumMergedRegions(); ++i) {
            final CellRangeAddress merge = row.getSheet().getMergedRegion(i);
            if (rowIndex >= merge.getFirstRow() && rowIndex <= merge.getLastRow()) {
                mergeStart = merge.getFirstColumn();
                mergeEnd = merge.getLastColumn();
                break;
            }
        }
        out.append("style='");
        if (row.getHeight() != -1) {
            out.append("height: ")
            .append(Math.round(row.getHeight() / 20.0 * 1.33333))
            .append("px; ");
        }
        out.append("'>\n");
        for (colIndex = 0; colIndex < row.getLastCellNum(); ++colIndex) {
            td(row.getCell(colIndex));
        }
        out.append("</tr>\n");
    }

    /**
     * @brief 메서드 설명 
     * @details 상세 설명
     * @param  파라미터명 파라미터 설명
     * @return 리턴 타입 (리턴이 없으면 생략)
     */
    private void td(final HSSFCell cell) {
        int colspan = 1;
        if (colIndex == mergeStart) {
            // First cell in the merging region - set colspan.
            colspan = mergeEnd - mergeStart + 1;
        } 
        else if (colIndex == mergeEnd) {
            // Last cell in the merging region - no more skipped cells.
            mergeStart = -1;
            mergeEnd = -1;
            return;
        } 
        else if (mergeStart != -1 && mergeEnd != -1 && colIndex > mergeStart && colIndex < mergeEnd) {
            // Within the merging region - skip the cell.
            return;
        }
        
        out.append("<td ");
        if (colspan > 1) {
            out.append("colspan='")
            .append(colspan)
            .append("' ");
        }
        
        if (cell == null) {
            out.append("/>\n");
            return;
        }
        
        out.append("style='");
        final HSSFCellStyle style = cell.getCellStyle();
        
        // Text alignment
        switch (style.getAlignment()) {
            case CellStyle.ALIGN_LEFT:
                out.append("text-align: left; ");
                break;
            case CellStyle.ALIGN_RIGHT:
                out.append("text-align: right; ");
                break;
            case CellStyle.ALIGN_CENTER:
                out.append("text-align: center; ");
                break;
            default:
                break;
        }
        
        // Font style, size and weight
        final HSSFFont font = style.getFont(book);
        if (font.getBoldweight() == HSSFFont.BOLDWEIGHT_BOLD) {
            out.append("font-weight: bold; ");
        }
        
        if (font.getItalic()) {
            out.append("font-style: italic; ");
        }
        
        if (font.getUnderline() != HSSFFont.U_NONE) {
            out.append("text-decoration: underline; ");
        }
        
        out.append("font-size: ").append(Math.floor(font.getFontHeightInPoints() * 0.8)).append("pt; ");
        
        // Cell background and font colours
        final short[] backRGB = style.getFillForegroundColorColor().getTriplet();
        final HSSFColor foreColor = palette.getColor(font.getColor());
        
        if (foreColor != null) {
            final short[] foreRGB = foreColor.getTriplet();
            if (foreRGB[0] != 0 || foreRGB[1] != 0 || foreRGB[2] != 0) {
                out.append("color: rgb(")
                    .append(foreRGB[0])
                    .append(',')
                    .append(foreRGB[1])
                    .append(',')
                    .append(foreRGB[2])
                    .append(");");
            }
        }
        if (backRGB[0] != 0 || backRGB[1] != 0 || backRGB[2] != 0) {
            out.append("background-color: rgb(")
                .append(backRGB[0])
                .append(',')
                .append(backRGB[1])
                .append(',')
                .append(backRGB[2])
                .append(");");
        }
        // Border
        if (style.getBorderTop() != HSSFCellStyle.BORDER_NONE) {
            out.append("border-top-style: solid; ");
        }
        
        if (style.getBorderRight() != HSSFCellStyle.BORDER_NONE) {
            out.append("border-right-style: solid; ");
        }
        
        if (style.getBorderBottom() != HSSFCellStyle.BORDER_NONE) {
            out.append("border-bottom-style: solid; ");
        }
        
        if (style.getBorderLeft() != HSSFCellStyle.BORDER_NONE) {
            out.append("border-left-style: solid; ");
        }
        out.append("'>");
        
        String val = "";
        try {
            switch (cell.getCellType()) {
                case HSSFCell.CELL_TYPE_STRING:
                    val = cell.getStringCellValue();
                    break;
                case HSSFCell.CELL_TYPE_NUMERIC:
                    // POI does not distinguish between integer and double, thus:
                    final double original = cell.getNumericCellValue(),
                    rounded = Math.round(original);
                    if (Math.abs(rounded - original) < 0.00000000000000001) {
                        val = String.valueOf((int) rounded);
                    } 
                    else {
                        val = String.valueOf(original);
                    }
                    break;
                case HSSFCell.CELL_TYPE_FORMULA:
                    final CellValue cv = evaluator.evaluate(cell);
                    
                    switch (cv.getCellType()) {
                        case Cell.CELL_TYPE_BOOLEAN:
                            out.append(cv.getBooleanValue());
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            out.append(cv.getNumberValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            out.append(cv.getStringValue());
                            break;
                        case Cell.CELL_TYPE_BLANK:
                            break;
                        case Cell.CELL_TYPE_ERROR:
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    // Neither string or number? Could be a date.
                    try {
                        val = sdf.format(cell.getDateCellValue());
                    } 
                    catch (final Exception e1) {}
                    break;
            }
        } 
        catch (final Exception e) {
            val = e.getMessage();
        }
        
        if ("null".equals(val)) {
            val = "";
        }
        
        if (pix.containsKey(rowIndex)) {
            if (pix.get(rowIndex).containsKey(colIndex)) {
                for (final HSSFPictureData pic : pix.get(rowIndex).get(colIndex)) {
                    out.append("<img alt='Image in Excel sheet' src='data:");
                    out.append(pic.getMimeType());
                    out.append(";base64,");
                    
                    try {
                        out.append(new String(Base64.encodeBase64(pic.getData()), "UTF-8"));
                    } 
                    catch (final UnsupportedEncodingException e) {
                        throw new RuntimeException(e);
                    }
                    out.append("'/>");
                }
            }
        }
        out.append(val);
        out.append("</td>\n");
    }
}