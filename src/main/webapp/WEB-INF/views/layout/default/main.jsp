<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE HTML>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
    <meta name="description" content="<tiles:insertAttribute name="title"/>">
    <meta name="keywords" content="<tiles:insertAttribute name="title"/>">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><tiles:insertAttribute name="title"/></title>
    <%@ include file="/WEB-INF/views/common/include.jsp" %>
</head>
<body>
<!-- wrap -->
<div id="wrap" class="bg1" style="height: 1197px;">
    <div class="wrapbody">
        <!--Header-->
        <div id="headerwrap" class="person main">
            <div id="header" class="main">
                <tiles:insertAttribute name="header"/>
            </div>
        </div>
        <div id="containerwrap" class="sub">
            <!-- container -->
            <div id="container" class="sub">
                <div id="lnb">
                    <link rel="stylesheet" type="text/css" href="/resources/css/sub.css">
                    <script type="text/javascript">
                        $(document).ready(function(){

                        });
                    </script>
                    <div class="menu">
                        <a href="/kor/rental/rental_01.do">서브메뉴_001</a>
                        <a href="/kor/rental/rental_02.do">서브메뉴_002</a>
                        <a href="/kor/rental/rental_03.do">서브메뉴_003</a>
                        <a href="/kor/rental/rental_07.do">서브메뉴_004</a>
                    </div>
                    <div class="long_ban">
                        <a href="/kor/long/long_03.do">서브하단메뉴_001</a><br/>
                        <a href="/kor/short/carshare.do">서브하단메뉴_002</a><br/>
                        <a href="/kor/long/long_bizcare.do">서브하단메뉴_003</a>
                    </div>
                </div>
                <div id="contents">
                    <div class="cont_top">
                        <tiles:insertAttribute name="bodyTop"/>
                    </div>
                    <tiles:insertAttribute name="body"/>
                </div>
            </div>
        </div>
        <div id="shadow"></div>
        <div id="wrap_re">
            <div class="resarea" style="display: block;">
                <div class="openbox" style="height: 1736px;">
                    <tiles:insertAttribute name="menu"/>
                </div>
            </div>
        </div>
        <div id="footerwrap">
            <div id="footer">
                <tiles:insertAttribute name="footer"/>
            </div>
        </div>
    </div>
</div>
</div>
<%--<img src="${pageContext.request.contextPath}/img/loading.gif" alt="" class="loading">--%>
</body>
</html>