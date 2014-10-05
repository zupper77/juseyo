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
<tiles:insertAttribute name="body"/>
</body>
</html>