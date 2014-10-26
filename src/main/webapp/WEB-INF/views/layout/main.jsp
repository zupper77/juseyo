<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE HTML>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="description" content="JUSEYO">
<meta name="keywords" content="JUSEYO">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="favicon.png">
<title><tiles:getAsString name="title"/></title>

<%@ include file="/WEB-INF/views/common/include.jsp"%>

</head>
<body>
	<tiles:insertAttribute name="body"/>
</body>
</html>


