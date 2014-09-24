package com.juseyo.commons.lib.paging;

/**
 * @breif   페이징 처리를 위한 클래스
 * @author  개발지원3팀/최홍석
 * @version 1.0.0
 * @date    생성: 2014-04-14
 * @date    수정: 2014-04-14
 * @remark
 */
public class PageHolder {

    public static int DEFAULT_LISTSIZE = 20;

    public static int DEFAULT_PAGESIZE = 10;

    //한페이지 게시물갯
    private int listSize = DEFAULT_LISTSIZE;
    
    //한화면에 보이는 페이지 갯수 
    private int pageSize = DEFAULT_PAGESIZE;

    //총 게시물수
    private final long totalRows;

    //현재페이지(클릭된)
    private final int currentPage;

    public PageHolder(long totalRows, int currentPage) {
        this.totalRows = totalRows;
        this.currentPage = currentPage;
    }

    public PageHolder(long totalRows, int currentPage, int listSize) {
        this.totalRows = totalRows; 
        this.currentPage = currentPage;
        this.listSize = listSize;
    }

    public PageHolder(long totalRows, int currentPage, int listSize, int pageSize) {
        this.totalRows = totalRows;
        this.currentPage = currentPage;
        this.listSize = listSize;
        this.pageSize = pageSize;
    }

    public int getStartNumber() {
        return (this.currentPage - 1) * this.listSize + 1;
    }

    public int getLastIndexNumber() {
        return (int) (this.totalRows - (this.getStartNumber() - 1));
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public int getLineSize() {
        return this.listSize;
    }

    public int getPageSize() {
        return this.pageSize;
    }
    
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalPages() {
        if (totalRows > 0 && currentPage > 0) {
            long totalPages = totalRows / listSize;
            if (totalRows % listSize > 0)
                totalPages++;
            return totalPages;
        }
        else {
            return 0;
        }
    }

    public long getTotalRows() {
        return this.totalRows;
    }

}
