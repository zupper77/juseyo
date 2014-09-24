package com.juseyo.commons.lib.resolver.excel;

import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;
 
public class MappingExcelDownload extends AbstractExcelView {
 
 @SuppressWarnings("unchecked")
 @Override
 protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest req, HttpServletResponse res) throws Exception {
  
     String ExcelName = (String) model.get("ExcelName");
     
     List<String> ColName = (List<String>) model.get("ColName");
     List<String[]> ColValue = (List<String[]>) model.get("ColValue");
     
     res.setContentType("Application/Msexcel");
     res.setHeader("Content-Disposition", "Attachment; Filename="+ ExcelName + ".xls");
                

    HSSFSheet Sheet = workbook.createSheet(ExcelName); 
    
    // 상단 메뉴명 생성
    HSSFRow MenuRow = Sheet.createRow(0);
    for (int i = 0; i < ColName.size();i++) {
        HSSFCell Cell = MenuRow.createCell(i);
        Cell.setCellValue(new HSSFRichTextString(ColName.get(i)));
    }   
    
    for ( int i = 0; i < ColValue.size(); i++) {
        
        HSSFRow Row = Sheet.createRow(i + 1);
        
        for ( int j = 0; j < ColValue.get(i).length; j++) {
            HSSFCell Cell = Row.createCell(j);
            Cell.setCellValue(new HSSFRichTextString(ColValue.get(i)[j]));
        }
        
    }
    
 }
 
  
 private HSSFSheet createFirstSheet(HSSFWorkbook workbook){
  HSSFSheet sheet = workbook.createSheet();
  workbook.setSheetName(0, "테스트");
  sheet.setColumnWidth(1, 256*30);
  return sheet;
 }
 
 private void createColumnLabel(HSSFSheet sheet){
  HSSFRow firstRow = sheet.createRow(0);
  
  HSSFCell cell = firstRow.createCell(0);
  cell.setCellValue("순위");
  
  cell = firstRow.createCell(1);
  cell.setCellValue("페이지");
 }
 
 private void createPageRow(HSSFSheet sheet, List<String> menuList, int rowNum){
  HSSFRow row = sheet.createRow(rowNum + 1);
  
  HSSFCell cell = row.createCell(0);
  cell.setCellValue(rowNum + 1);
  
  cell = row.createCell(1);
  cell.setCellValue(menuList.get(rowNum)); 
 }
}