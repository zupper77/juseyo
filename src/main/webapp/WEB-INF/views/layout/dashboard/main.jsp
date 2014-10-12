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
                    <link rel="stylesheet" type="text/css" href="/resources/css/guide_01.css">
                    <script type="text/javascript">
                        <!--
                        $(document).ready(function(){
                            var nowCate = getPage();

                            if(nowCate=='rental_01.do'){
                                $("#4-1-title").attr("src","/resources/images/left/4_1_on.gif");
                                menuOnProc("4-1-title");
                            }
                            if(nowCate=='rental_02.do'){
                                $("#4-2-title").attr("src","/resources/images/left/4_2_on.gif");
                                menuOnProc("4-2-title");
                            }
                            if(nowCate=='rental_03.do'){
                                $("#4-3-title").attr("src","/resources/images/left/4_3_on.gif");
                                menuOnProc("4-3-title");
                            }
                            if(nowCate=='rental_04.do'){
                                $("#4-4-title").attr("src","/resources/images/left/4_4_on.gif");
                                menuOnProc("4-4-title");
                            }
                            if(nowCate=='rental_05.do'){
                                $("#4-5-title").attr("src","/resources/images/left/4_5_on.gif");
                                menuOnProc("4-5-title");
                            }
                            if(nowCate=='rental_07.do'){
                                $("#4-7-title").attr("src","/resources/images/left/4_7_on.gif");
                                menuOnProc("4-7-title");
                            }
                        });


                        //-->
                    </script>
                    <div class="menu">
                        <a href="/kor/rental/rental_01.do"><img src="/resources/images/left/4_1_on.gif" id="4-1-title" alt="금융 렌탈" class="hoverimgg"></a>
                        <a href="/kor/rental/rental_02.do"><img src="/resources/images/left/4_2.gif" id="4-2-title" alt="계측기 렌탈" class="hoverimgg"></a>
                        <a href="/kor/rental/rental_03.do"><img src="/resources/images/left/4_3.gif" id="4-3-title" alt="OA 렌탈" class="hoverimgg"></a>
                        <!--  a href="/kor/rental/rental_04.do"><img src="/resources/images/left/4_4.gif" id="4-4-title" alt="웰빙 렌탈" class="hoverimgg" /></a-->
                        <!--  a href="/kor/rental/rental_05.do"><img src="/resources/images/left/4_5.gif" id="4-5-title" alt="건설장비 렌탈" class="hoverimgg" /></a -->
                        <!-- <a href="/kor/rental/rental_06.do"><img src="/resources/images/left/4_6.gif" alt="자료실" class="hoverimgg" /></a> -->
                        <a href="/kor/rental/rental_07.do"><img src="/resources/images/left/4_7.gif" id="4-7-title" alt="일반렌탈 지점안내" class="hoverimgg"></a>
                    </div>

                    <div class="long_ban"><a href="/kor/long/long_03.do"><img src="/resources/images/left/long_ban.gif" alt="장기렌터카 견적신청"></a>
                        <a href="/kor/short/carshare.do"><img src="/resources/images/left/long_ban02.gif" alt="카쉐어링(그린카) 바로가기"></a>
                        <a href="/kor/long/long_bizcare.do"><img src="/resources/images/left/long_ban01.gif" alt="장기렌터카 비즈케어"></a>
                    </div>

                    <!-- <div class="quick">
                        <a href="#" onclick="openbox();return false;"><img src="/resources/images/left/quick_1.gif" alt="간편예약" class="hoverimgg"/></a>
                        <a href="/kor/short/rentalFree0.do"><img src="/resources/images/left/quick_2.gif" alt="요금안내" class="hoverimgg"/></a>
                        <a href="/kor/cs/cs_area.do"><img src="/resources/images/left/quick_3.gif" alt="지점안내" class="hoverimgg"/></a>
                        <a href="/kor/info/eventlist.do?rentID=3011&pg=8"><img src="/resources/images/left/quick_4.gif" alt="이벤트" class="hoverimgg"/></a>
                        <a href="/kor/cs/cs_01.do"><img src="/resources/images/left/quick_5.gif" alt="고객센터" class="hoverimgg"/></a>
                        <a href="/kor/used/info/01.do"><img src="/resources/images/left/quick_6.gif" alt="중고차판매" class="hoverimgg"/></a>
                    </div> --> <!-- 잠시 주석 -->
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