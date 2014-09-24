package com.juseyo.commons.lib.paging;

/**
 * @breif   페이징 처리를 위한 클래스
 * @author  개발지원3팀/최홍석
 * @version 1.0.0
 * @date    생성: 2014-04-14
 * @date    수정: 2014-04-14
 * @remark
 *  페이징을 처리하는 클래스는 PageParam를 상속받아 처리한다.
 *  pageSize: 하단 페이지네이션 사이즈 (default: 10)
 *  listSize: item갯수 (default: 20)
 */
public class PageParam {

    /**
     * 페이지(RequestParameter문자열)
     */
    private Integer page = 1;

    /**
     * 페이지사이즈, 하단 페이지 최대사이즈(Default 10)
     */
    private int pageSize = PageHolder.DEFAULT_PAGESIZE;

    /**
     * 리스트 사이즈, 데이터 아이템 갯수
     */
    private int listSize = PageHolder.DEFAULT_LISTSIZE;


    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        if (page == null) {
            this.page = 1;
        } else {
            this.page = page;
        }
    }

	public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getListSize() {
        return listSize;
    }

    public void setListSize(int listSize) {
        this.listSize = listSize;
    }

    public int getFetchScale() {
        return (page - 1) * listSize;
    }
}
