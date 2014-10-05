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
        <div id="headerwrap" class="person header">
            <div id="header" calss="person main">
                <tiles:insertAttribute name="header"/>
            </div>
        </div>
        <div id="containerwrap" class="sub">
            <!-- container -->
            <div id="container" class="sub">
                <div class="cont_top">
                    <tiles:insertAttribute name="bodyTop"/>
                </div>
                <div id="contents">
                    <tiles:insertAttribute name="body"/>
                </div>
            </div>
        </div>
        <div id="shadow"></div>
        <div id="wrap_re">
            <div class="resarea" style="display: block;">
                <div class="openbox" style="height: 1736px;">
                    <p class="mv1">Button1</p>
                    <p class="im_1">Button2</p>
                    <p class="im_2">Button3</p>
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
<!-- /wrap -->

<%--<img src="${pageContext.request.contextPath}/img/loading.gif" alt="" class="loading">--%>
</body>

</html>