package com.juseyo.commons.lib.paging;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;

import com.juseyo.commons.lib.paging.PageHolder;

/**
 * @breif   페이징 처리를 위한 클래스
 * @author  개발지원3팀/최홍석
 * @version 1.0.0
 * @date    생성: 2014-04-14
 * @date    수정: 2014-04-14
 * @remark
 */
@SuppressWarnings("serial")
public class PaginationTag extends TagSupport {
    
    /**
     * PageHolder 리퀘스트 스쿠프 이름 
     */
    private String name;

    private PageHolder pageHolder;

    /**
     * 페이지 파라매터이름
     */
    private String pageParam = "page";

    /**
     * page(defult:1)
     */
    private int page = 1;

    /**
     * 페이지 파라매터 명 리스트(, 로 구분)
     */
    private String parameters;

    /**
     * 이동할 url
     */
    private String url;

    /**
     * 템플릿 이름 
     */
    private String template = "default";

    /**
     * ?? 
     */
    private String bookmark = "";

    @Override
    public int doStartTag() throws JspTagException {
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspTagException {
        try {
            this.pageHolder = (PageHolder) lookup(pageContext, name, "request");
            if (pageHolder == null) {
                return SKIP_BODY;
            }

            Map<String, Object> pageInfo = new HashMap<String, Object>();

            pageInfo.put("totalPage", this.pageHolder.getTotalPages());
            pageInfo.put("totalCount", this.pageHolder.getTotalRows());

            this.page = this.pageHolder.getCurrentPage();
            pageInfo.put("currentPage", page);

            String separator = (url.indexOf("?") >= 0) ? "&" : "?";
            pageInfo.put("separator", separator);

            String paramString = makeParamString(pageContext.getRequest());
            pageInfo.put("paramString", paramString);

            String contextPath = ((HttpServletRequest) pageContext.getRequest()).getContextPath();
            if (this.url.startsWith("/") && StringUtils.equals(contextPath, "/") == false) {
                pageInfo.put("url", contextPath + url);
                pageInfo.put("contextPath", contextPath);
            } else {
                pageInfo.put("url", url);
            }

            pageInfo.put("bookmark", bookmark);

            pageInfo.put("pageParam", this.pageParam);

            int startPage = ((int) Math.ceil((double) page / (double) this.pageHolder.getPageSize()) - 1) * this.pageHolder.getPageSize() + 1;
            pageInfo.put("startPage", startPage);

            List<Integer> pages = new ArrayList<Integer>(this.pageHolder.getPageSize());

            int i = 0;
            for (i = startPage; i < startPage + this.pageHolder.getPageSize(); i++) {
                if (i <= this.pageHolder.getTotalPages()) {
                    pages.add(new Integer(i));
                } else {
                    break;
                }
            }

            pageInfo.put("pages", pages);
            pageInfo.put("nextScalePage", i);
            pageInfo.put("previousScalePage", startPage - this.pageHolder.getPageSize());
            pageContext.getRequest().setAttribute("pageInfo", pageInfo);
            ImportResponseWrapper wrapper = new ImportResponseWrapper((HttpServletResponse) pageContext.getResponse());
            pageContext.getRequest().getRequestDispatcher("/WEB-INF/pagingTemplate/" + this.template + ".jsp").include(pageContext.getRequest(), wrapper);
            pageContext.getOut().print(wrapper.getString());
        } catch (Exception e) {
            throw new JspTagException(e);
        }

        return EVAL_PAGE;
    }

    protected Object lookup(PageContext pageContext, String name, String scope) throws JspTagException {
        Object bean = null;
        if (scope == null) {
            bean = pageContext.findAttribute(name);
        } else if (scope.equalsIgnoreCase("page")) {
            bean = pageContext.getAttribute(name, PageContext.PAGE_SCOPE);
        } else if (scope.equalsIgnoreCase("request")) {
            bean = pageContext.getAttribute(name, PageContext.REQUEST_SCOPE);
        } else if (scope.equalsIgnoreCase("session")) {
            bean = pageContext.getAttribute(name, PageContext.SESSION_SCOPE);
        } else if (scope.equalsIgnoreCase("application")) {
            bean = pageContext.getAttribute(name, PageContext.APPLICATION_SCOPE);
        } else {
            JspTagException e = new JspTagException("Invalid scope " + scope);
            throw e;
        }
        return (bean);
    }

    private String makeParamString(ServletRequest request) {
        StringBuilder queryString = new StringBuilder();

        if (StringUtils.isEmpty(this.parameters)) {
            return "";
        }

        StringTokenizer tokenizer = new StringTokenizer(this.parameters, ",");
        while (tokenizer.hasMoreTokens()) {
            String parameterName = StringUtils.trim(tokenizer.nextToken());
            String[] value = request.getParameterValues(parameterName);
            for (int i = 0; value != null && i < value.length; i++) {
                if (parameterName.equals(this.pageParam)) {
                    continue;
                }
                if (value[i] != null) {
                    try {
                        queryString.append("&" + parameterName + "=" + URLEncoder.encode(value[i], "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        queryString.append("&" + parameterName + "=");
                    }
                } else {
                    queryString.append("&" + parameterName + "=");
                }
            }
        }

        return queryString.toString();
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public void setName(String string) {
        name = string;
    }

    public void setPageParam(String pageParam) {
        this.pageParam = pageParam;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public void setBookmark(String bookmark) {
        this.bookmark = bookmark;
    }

    private class ImportResponseWrapper extends HttpServletResponseWrapper {

        public static final String DEFAULT_ENCODING = "ISO-8859-1";

        /** The Writer we convey. */
        private final StringWriter sw = new StringWriter();

        /** A buffer, alternatively, to accumulate bytes. */
        private final ByteArrayOutputStream bos = new ByteArrayOutputStream();

        /** A ServletOutputStream we convey, tied to this Writer. */
        private final ServletOutputStream sos = new ServletOutputStream() {
            @Override
            public void write(int b) {
                bos.write(b);
            }
        };

        /** 'True' if getWriter() was called; false otherwise. */
        private boolean isWriterUsed;

        /** 'True if getOutputStream() was called; false otherwise. */
        private boolean isStreamUsed;

        /** The HTTP status set by the target. */
        private int status = 200;

        // ************************************************************
        // Constructor and methods
        /** Constructs a new ImportResponseWrapper. */
        public ImportResponseWrapper(HttpServletResponse response) {
            super(response);
        }

        /** Returns a Writer designed to buffer the output. */
        @Override
        public PrintWriter getWriter() {
            if (isStreamUsed) {
                throw new RuntimeException("import illegal stream");
            }
            isWriterUsed = true;
            return new PrintWriter(sw);
        }

        /** Returns a ServletOutputStream designed to buffer the output. */
        @Override
        public ServletOutputStream getOutputStream() {
            if (isWriterUsed) {
                throw new RuntimeException("import_illegal writer");
            }
            isStreamUsed = true;
            return sos;
        }

        /** Has no effect. */
        @Override
        public void setContentType(String x) {
            // ignore
        }

        /** Has no effect. */
        @Override
        public void setLocale(Locale x) {
            // ignore
        }

        @Override
        public void setStatus(int status) {
            this.status = status;
        }

        @SuppressWarnings("unused")
        public int getStatus() {
            return status;
        }

        /**
         * Retrieves the buffered output, using the containing tag's
         * 'charEncoding' attribute, or the tag's default encoding, <b>if
         * necessary</b>.
         */
        // not simply toString() because we need to throw
        // UnsupportedEncodingException
        public String getString() throws UnsupportedEncodingException {
            if (isWriterUsed) {
                return sw.toString();
            } else if (isStreamUsed) {
                return bos.toString(DEFAULT_ENCODING);
            } else {
                return "";
            }
        }
    }
}
