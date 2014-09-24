<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%
	response.setHeader("Cache-Control", "no-store");

	String gnb = request.getParameter("gnb");
	if(gnb == null){
		gnb = "0";
	}
%>
<!DOCTYPE HTML>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<meta name="description" content="위메프 GOS">
<meta name="keywords" content="위메프 GOS">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="favicon.png">
<title>위메프 GOS</title>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/ui.menu.js"></script>
<script>
	var gnb = "<%=gnb%>";
	$(window).load(function(){
		setGnbHiddenObject();
	});
</script>
</head>
<body>
	<div id="wrap">
		<!-- container -->
		<div id="container">
        	<tiles:insertAttribute name="menu"/>
			<!-- contentsWrap -->
			<div id="contentsWrap" class="fluid">
				<!-- header -->
				<div class="header">
					<tiles:insertAttribute name="header"/>
				</div>
				<!-- //header -->

				<!-- contents -->
				<div class="contents">
	    			<tiles:insertAttribute name="body"/>
				</div>
				<!-- //contents -->
			</div>
			<!-- //contentsWrap -->
				    			
	    	<tiles:insertAttribute name="footer"/>
		</div>
		<!-- //container -->
	</div>
	<img src="${pageContext.request.contextPath}/img/loading.gif" alt="" class="loading">
</body>

</html>