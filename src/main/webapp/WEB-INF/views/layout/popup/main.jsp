<html xmlns="http://www.w3.org/1999/xhtml"><head>
    <title>KT금호렌터카</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <meta http-equiv="Cache-Control" content="no-cache">

    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
    <link rel="stylesheet" href="/include/css/default.css" type="text/css" media="screen">
    <link rel="stylesheet" href="/include/css/themes/base/ui.all.css" type="text/css" media="screen">

    <script type="text/javascript" async="" src="https://stats.g.doubleclick.net/dc.js"></script><script type="text/javascript" src="/resources/js/jquery-1.6.1.min.js"></script>
    <script type="text/javascript" src="/resources/js/jquery.rotate.js"></script>
    <script type="text/javascript" src="/resources/js/common.js"></script>
    <script type="text/javascript" src="/resources/js/utils.js"></script>
    <script type="text/javascript" src="/include/js/ui.core.js"></script>
    <script type="text/javascript" src="/include/js/ui.datepicker.js"></script>
    <script type="text/javascript" src="/include/js/ui.datepicker-ko.js"></script>
    <script type="text/javascript" src="/include/js/default.js"></script>

    <script language="JavaScript">
        var EchoID = "ktrental";
        var EchoGoodNm = "";
        var EchoAmount = "";
        var EchoUIP = "";
        var EchoTarget = "";
        var EchoLogSend = "Y";
        var EchoCV = "";
        var EchoPN = "";
    </script>
    <script language="JavaScript" src="/resources/js/EchoScriptV2.js"></script>


    <script type="text/javascript">
        function goGuestReservList(usrName,usrPhoneNo,reservNo){
            $("#usrNameEdit").val(usrName);
            $("#usrPhoneNoEdit").val(usrPhoneNo);
            $("#reservNoEdit").val(reservNo);
            $("form#reservEditFrm").submit();
            openbox();
        }
        $(document).ready(function(){
            var aa = $(".wrapbody").innerHeight();
            var bb = $(".wrapbody").innerWidth();
            var screenWidth = screen.width;

            var resbox = $(".resbox").innerHeight();
            if(aa > resbox){
                $(".resbox").css("height",""+aa+"px");
            }else{
                return;
            }
            $(".select").append("<img src='/include/img/ico/ico_down.png' class='ico_select' />");
            $(".select").attr("active","off");
            $(".select").click(function(){
                var evt = $(this).attr("name");
                var at = $(this).attr("active");
                if(at == "off"){
                    $(this).attr("active","on");
                    $(".ico_select").attr("src","/include/img/ico/ico_down.png");
                    $(this).children('.ico_select').attr("src","/include/img/ico/ico_up.png");
                    var sw = $(this).width();
                    var sl = $(this).position().left+52;
                    var sl01 = $(this).position().left+57;

                    var st = $(this).offset().top+18;
                    $(".selectbox").slideDown(100);
                    if(evt == "evt"){
                        $(".selectbox").css({"width":""+sw+"px", "left":""+sl01+"px", "top":""+st+"px"});
                    }else{
                        $(".selectbox").css({"width":""+sw+"px", "left":""+sl+"px", "top":""+st+"px"});
                    }

                }else if(at == "on"){
                    $(".select").attr("active","off");
                    $(".ico_select").attr("src","/include/img/ico/ico_down.png");
                    $(".selectbox").slideUp(100);
                }
            });
            $(".selectbox ul li").click(function(){
                $(".select").attr("active","off");
                $(".ico_select").attr("src","/include/img/ico/ico_down.png");
                $(".selectbox").slideUp(100);
            });

        });
    </script>
    <script type="text/javascript">

        var _gaq = _gaq || [];
        _gaq.push(['_setAccount', 'UA-36855540-1']);
        _gaq.push(['_setDomainName', 'ktkumhorent.com']);
        _gaq.push(['_setAllowLinker', true]);
        _gaq.push(['_trackPageview']);

        (function() {
            var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
            ga.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'stats.g.doubleclick.net/dc.js';
            var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
        })();

    </script>
</head>
<body><div id="cboxOverlay" style="display: none;"></div><div id="colorbox" class="" style="padding-bottom: 57px; padding-right: 28px; display: none;"><div id="cboxWrapper"><div><div id="cboxTopLeft" style="float: left;"></div><div id="cboxTopCenter" style="float: left;"></div><div id="cboxTopRight" style="float: left;"></div></div><div style="clear: left;"><div id="cboxMiddleLeft" style="float: left;"></div><div id="cboxContent" style="float: left;"><div id="cboxLoadedContent" class="" style="width: 0px; height: 0px; overflow: hidden;"></div><div id="cboxLoadingOverlay" class=""></div><div id="cboxLoadingGraphic" class=""></div><div id="cboxTitle" class=""></div><div id="cboxCurrent" class=""></div><div id="cboxNext" class=""></div><div id="cboxPrevious" class=""></div><div id="cboxSlideshow" class=""></div><div id="cboxClose" class=""></div></div><div id="cboxMiddleRight" style="float: left;"></div></div><div style="clear: left;"><div id="cboxBottomLeft" style="float: left;"></div><div id="cboxBottomCenter" style="float: left;"></div><div id="cboxBottomRight" style="float: left;"></div></div></div><div style="position: absolute; width: 9999px; visibility: hidden; display: none;"></div></div>
<!-- wrap -->
<div id="wrap" class="bg1" style="height: 1197px;">
<div class="wrapbody">
<!-- headerwrap -->
<div id="headerwrap">
    <!-- header -->


    <script>
        function getCookie( name ){
            var nameOfCookie = name + "=";
            var x = 0;
            while ( x <= document.cookie.length ) {
                var y = (x+nameOfCookie.length);
                if ( document.cookie.substring( x, y ) == nameOfCookie ) {
                    if ( (endOfCookie=document.cookie.indexOf( ";", y )) == -1 ) endOfCookie = document.cookie.length;
                    return unescape( document.cookie.substring( y, endOfCookie ) );
                }
                x = document.cookie.indexOf( " ", x ) + 1;
                if ( x == 0 ) break;
            }
            return "";
        }
        if ( getCookie( "mobile" ) != "done" ){
            var mobileKeyWords = new Array('iPhone', 'iPod', 'iPad', 'BlackBerry', 'Android', 'Windows CE', 'LG', 'MOT', 'SAMSUNG', 'SonyEricsson');
            for (var word in mobileKeyWords){
                if (navigator.userAgent.match(mobileKeyWords[word]) != null){
                    location.href = "http://m.ktkumhorent.com";
                    break;
                }
            }
        }
    </script>
    <div id="header" class="main">
        <!-- main_v -->
        <div id="main_v">
            <script type="text/javascript">
                var imgLink = new Array("https://www.ktkumhorent.com/kor/info/promotion01.do?rentID=3041&pg=8","https://www.ktkumhorent.com/kor/info/viewer.do?rentID=90212&bDiv=notice&pageno=1&mode=&sitem=&stext=&idx=43963");
            </script>
            <script type="text/javascript" src="/resources/js/jquery.galleriffic.js"></script>
            <script type="text/javascript" src="/resources/js/jquery.opacityrollover.js"></script>
            <!-- galleriffic -->
            <div id="galleriffic">
                <div id="gallery" class="content" style="display: block;">
                    <div class="slideshow-container">
                        <div id="slideshow" class="slideshow"><span class="image-wrapper current" style="opacity: 1;"><a class="advance-link" rel="history" href="#3" onclick="location.href='https://www.ktkumhorent.com/kor/info/promotion01.do?rentID=3041&amp;pg=8'">&nbsp;<img alt="undefined" src="/upfiles/mainImg/1388376000782_mainVisual_fall.jpg"></a></span></div>
                    </div>
                </div>
                <div id="thumbs" class="navigation" style="opacity: 1;"><div class="top pagination"></div>
                    <ul class="thumbs">

                        <li class="selected" style="opacity: 1;">
                            <a class="thumb" href="#1" rel="history">
                                <img src="https://www.ktkumhorent.com/upfiles/mainImg/1388376000782_mainVisual_thumb.jpg">
                            </a>
                        </li>

                        <li class="" style="opacity: 0.4;">
                            <a class="thumb" href="#2" rel="history">
                                <img src="https://www.ktkumhorent.com/upfiles/mainImg/1387969200301_mainVisual_thumb.gif">
                            </a>
                        </li>

                    </ul>
                    <div class="bottom pagination"></div></div>
            </div>
            <script type="text/javascript">
                jQuery(document).ready(function($) {
                    $('div.content').css('display', 'block');

                    var onMouseOutOpacity = 0.4;
                    $('#thumbs ul.thumbs li').opacityrollover({
                        mouseOutOpacity:   onMouseOutOpacity,
                        mouseOverOpacity:  1.0,
                        fadeSpeed:         'fast',
                        exemptionSelector: '.selected'
                    });

                    var gallery = $('#thumbs').galleriffic({
                        delay:                     7000,
                        numThumbs:                 15,
                        preloadAhead:              10,
                        enableTopPager:            true,
                        enableBottomPager:         true,
                        maxPagesToShow:            7,
                        imageContainerSel:         '#slideshow',
                        controlsContainerSel:      '#controls',
                        captionContainerSel:       '#caption',
                        loadingContainerSel:       '#loading',
                        renderSSControls:          true,
                        renderNavControls:         true,
                        enableHistory:             false,
                        autoStart:                 true,
                        syncTransitions:           true,
                        defaultTransitionDuration: 900,
                        onSlideChange:             function(prevIndex, nextIndex) {
                            this.find('ul.thumbs').children()
                                    .eq(prevIndex).fadeTo('fast', onMouseOutOpacity).end()
                                    .eq(nextIndex).fadeTo('fast', 1.0);

                        },
                        onPageTransitionOut:       function(callback) {
                            this.fadeTo('fast', 0.0, callback);
                        },
                        onPageTransitionIn:        function() {
                            this.fadeTo('fast', 1.0);
                        }
                    });
                });
            </script>
            <!-- /galleriffic -->
        </div>
        <!-- /main_v -->
        <h1><img src="/resources/images/logo.png" alt="logo"></h1>
        <!-- <div class="ptype">


                    <img src="/resources/images/ptype_1_on.png" alt="개인" /><img src="/resources/images/ptype_line.gif" class="ml10 mr10"/><a href="main_com.do"><img src="/resources/images/ptype_2.png" alt="법인" class="hoverimg"/></a>



        </div> -->
        <!-- top_link -->
        <div class="top_link">
            <!--
            <a href="#"><img src="/resources/images/tlink_1.png" alt="로그아웃" class="hoverimg" /></a> l
            <a href="#"><img src="/resources/images/tlink_2.png" alt="정보수정" class="hoverimg" /></a> l
            -->

            <a href="/kor/member/login.do"><img src="/resources/images/tlink_3.png" alt="로그인" class="hoverimg"></a> l
            <a href="/kor/member/joinProvis.do"><img src="/resources/images/tlink_4.png" alt="회원가입" class="hoverimg"></a> l
            <a href="#" onclick="window.open('/kor/pop/login02.do','login02','statusbar=no,titlebar=no,scrollbar=no,width=700,height=325');return false;"><img src="/resources/images/tlink_5.png" alt="예약확인·수정" class="hoverimg"></a> l


            <a href="/kor/etc/sitemap.do"><img src="/resources/images/tlink_6.png" alt="사이트맵" class="hoverimg"></a>
            <a href="/eng/main.do" target="_blank"><img src="/resources/images/tlink_eng.png" alt="ENGLISH" class="hoverimg ml15"></a>
        </div>
        <!-- /top_link -->
        <!-- nav -->
        <div id="nav">
            <a href="/kor/short/rentalGuide0.do"><img src="/resources/images/nav_1.png" alt="단기렌터카" class="hoverimg"></a>
            <a href="/kor/long/long_guide_01.do"><img src="/resources/images/nav_2.png" alt="장기렌터카" class="hoverimg"></a>
            <a href="/kor/used/r2bList.do"><img src="/resources/images/nav_3.png" alt="중고차" class="hoverimg"></a>
            <a href="/kor/rental/rental_01.do"><img src="/resources/images/nav_4.png" alt="일반장비" class="hoverimg"></a>
            <a href="/kor/info/list.do?rentID=9021&amp;pg=0&amp;bDiv=notice"><img src="/resources/images/nav_5.png" alt="정보채널" class="hoverimg"></a>
            <a href="/kor/cs/cs_area.do"><img src="/resources/images/nav_6.png" alt="고객센터" class="hoverimg"></a>
        </div>
        <!-- /nav -->
    </div>
    <!-- /header -->
</div>
<!-- /headerwrap -->
<!-- containerwrap -->
<div id="containerwrap">


<script type="text/javascript" src="/resources/js/jquery.rotate.js"></script>

<script type="text/javascript">
    //현재 위치 및 스크립트 링크 베이스 변수 :: left.jsp 에서 컨버팅 됨.
    var nowDep1 = "";
    var nowDep2 = "";
    var nowDep3 = "";
</script>
<script language="JavaScript">
    //<!--
    function setCookie( name, value, expiredays ){
        var todayDate = new Date();
        todayDate.setDate( todayDate.getDate() + expiredays );
        document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + todayDate.toGMTString() + ";"
    }
    function getCookie( name ){
        var nameOfCookie = name + "=";
        var x = 0;
        while ( x <= document.cookie.length ) {
            var y = (x+nameOfCookie.length);
            if ( document.cookie.substring( x, y ) == nameOfCookie ) {
                if ( (endOfCookie=document.cookie.indexOf( ";", y )) == -1 ) endOfCookie = document.cookie.length;
                return unescape( document.cookie.substring( y, endOfCookie ) );
            }
            x = document.cookie.indexOf( " ", x ) + 1;
            if ( x == 0 ) break;
        }
        return "";
    }
    //첫번째 새창띄우기 시작
    //if ( getCookie( "pop_140612" ) != "done" ){
    //	noticeWindow = window.open('/event_kumhorent/pop_140612/pop_summer.html','pop_140612','toolbar=no,location=no,directories=no,status=no,menubar=no,scrolling=no,scrollbars=no,resizable=no,width=650,height=580,top=50px,left=50px');
    //}
    //if ( getCookie( "pop_140805" ) != "done" ){
    //	noticeWindow2 = window.open('/event_kumhorent/pop_140805/pop_notice.html','pop_140805','toolbar=no,location=no,directories=no,status=no,menubar=no,scrolling=no,scrollbars=no,resizable=no,width=330,height=375,top=50p,left=50px');
    //}
    //if ( getCookie( "pop_140819" ) != "done" ){
    //	noticeWindow3 = window.open('/event_kumhorent/pop_140819/pop_notice.html','pop_140819','toolbar=no,location=no,directories=no,status=no,menubar=no,scrolling=no,scrollbars=no,resizable=no,width=330,height=375,top=50px,left=50px');
    //}

    //
</script>
<!-- container -->
<div id="container">
    <div id="main" class="person">
        <!-- notice -->
        <div class="notice">
            <!-- s: 130530 수정 -->
            <img src="/resources/images/main_notice_tit.jpg" alt="notice&amp;news" class="fleft mr5">
            <!-- e: 130530 수정 -->
            <span id="upButton" class="cursoron fleft" style="margin-top:0px;"><img src="/resources/images/btn_up.gif" alt="up" class="vm"></span>
            <span id="downButton" class="cursoron fleft" style="margin-top:0px;"><img src="/resources/images/btn_down.gif" alt="down" class="vm"></span>
            <div id="area-roatation">
                <div class="containterWrap" style="overflow: hidden; position: relative; width: 386px; height: 17px;">
                    <div class="containterWrap" style="overflow: hidden; position: relative; width: 350px; height: 16px;"><ul id="roate-top" style="position: absolute; left: 0px; top: 0px;">









                        <li><a href="/kor/info/viewer.do?rentID=90212&amp;bDiv=notice&amp;pageno=1&amp;mode=&amp;sitem=&amp;stext=&amp;idx=43982"><span class="date">2014.09.17</span> 홈페이지 서비스 일시 중단 안내</a></li><li><a href="/kor/info/viewer.do?rentID=90212&amp;bDiv=notice&amp;pageno=1&amp;mode=&amp;sitem=&amp;stext=&amp;idx=43981"><span class="date">2014.09.12</span> 개인정보 처리방침 개정에 대한 공지</a></li><li><a href="/kor/info/viewer.do?rentID=90212&amp;bDiv=notice&amp;pageno=1&amp;mode=&amp;sitem=&amp;stext=&amp;idx=43980"><span class="date">2014.09.01</span> 제주 오토하우스 업계 최초 무인대여기 도입 안내 공지문</a></li><li><a href="/kor/info/viewer.do?rentID=90212&amp;bDiv=notice&amp;pageno=1&amp;mode=&amp;sitem=&amp;stext=&amp;idx=43979"><span class="date">2014.08.19</span> 홈페이지 서비스 일시 중단 안내 공지</a></li><li><a href="/kor/info/viewer.do?rentID=90212&amp;bDiv=notice&amp;pageno=1&amp;mode=&amp;sitem=&amp;stext=&amp;idx=43983"><span class="date">2014.09.29</span> 카카오톡 상담 서비스 오픈 안내</a></li>

                    </ul></div>
                </div>
            </div>
            <script type="text/javascript">
                $(document).ready(function(){
                    $("#area-roatation #roate-top").rotate({
                        'duration' : '5000',
                        'interval' : '5000',
                        'prevButton' : '#upButton',
                        'nextButton' : '#downButton',
                        'movement'  : 'top',
                        'autoStart' : true
                    });
                });
            </script>
            <script type="text/javascript" src="/resources/js/jquery-1.6.1.min.js"></script>
            <script type="text/javascript" src="/resources/js/jquery.rotate.js"></script>
        </div>
        <!-- /notice -->
        <!-- 20130620 banner추가 s -->
        <!-- <div class="banner" style="position:absolute;top:308px;right:140px"><a href="http://www.ktcommerce.co.kr" target="_blank"><img src="/resources/images/ktcommerce.gif" alt="banner" /></a></div> -->
        <!-- 20130620 banner추가 e -->
        <div class="sns">
            <a href="http://blog.naver.com/kt_kumho/" target="_blank"><img src="/resources/images/main_sns_b.gif" alt=""></a><img src="http://www.ktkumhorent.com/resources/images/main_sns_line.gif"><a href="http://www.facebook.com/ktkumhosns" target="_blank"><img src="http://www.ktkumhorent.com/resources/images/main_sns_f.gif" alt="페이스북"></a><img src="http://www.ktkumhorent.com/resources/images/main_sns_line.gif"><a href="http://twitter.com/#!/kt_kumho" target="_blank"><img src="http://www.ktkumhorent.com/resources/images/main_sns_t.gif" alt="트위터"></a>
        </div>
        <!-- 단기렌터카 안내 -->
        <div class="more2">
            <a href="/kor/long/long_guide_01.do" alt="장기렌탈안내"><img src="/resources/images/main_person_more1_ui.jpg" alt=""></a>
        </div>
        <a href="/kor/short/carshare.do" alt="그린카" class="more1"><img src="/resources/images/main_person_green_ui.jpg" alt=""></a>
        <!-- 장기렌터카 안내 -->

        <!-- 일반렌탈, 이용후기, 차종안내, 수입차 프로모션, -->
        <div class="more_group">
            <style>
                /*#slides2 { position:relative; top:0; left:0; }*/
                #slides2 .slides_container { width:489px; overflow:hidden; position:relative; margin:0 0 0 40px; }
                #slides2 .slides_container a { width:489px; height:102px; display:block; }
                #slides2 .slides_container a img { display:block; }
                #slides2 .next { position:absolute; top:39px; left:531px; padding: 10px}
                #slides2 .prev { position:absolute; top:39px; left:6px; padding:10px }
                #slides2 .pagination { display:none; }
            </style>
            <script src="/resources/js/slides.min.jquery.js"></script>
            <script>
                $(function(){
                    $('#slides2').slides({
                        play: 5000,
                        pause: 2500,
                        hoverPause: true
                    });
                });
            </script>
            <div id="slides2">
                <div class="slides_container" style="overflow: hidden; position: relative; display: block;">
                    <!-- s: 130530 수정 -->
                    <div class="slides_control" style="position: relative; width: 1467px; height: 102px; left: -489px;"><a href="#" style="position: absolute; top: 0px; left: 489px; z-index: 5; display: block;"><img src="/resources/images/main_person_more3_ui.jpg" border="0" usemap="#slide2_1"></a><a href="#" style="position: absolute; top: 0px; left: 489px; z-index: 0; display: none;"><img src="/resources/images/main_person_more4_ui.jpg" border="0" usemap="#slide2_2"></a></div>
                    <!-- e: 130530 수정 -->

                </div>
                <map name="slide2_1">
                    <area shape="rect" coords="0,0,253,102" href="/kor/rental/rental_01.do" alt="일반렌탈 상품">
                    <!-- s: 130531 수정 -->
                    <area shape="rect" coords="254,0,489,102" href="/kor/info/viewer.do?rentID=90512&amp;bDiv=tour_a&amp;pageno=1&amp;mode=&amp;sitem=&amp;stext=&amp;idx=43895" alt="추천 여행지">
                    <!-- e: 130531 수정 -->
                </map>
                <map name="slide2_2">
                    <area shape="rect" coords="0,0,253,102" href="/kor/short/rentalGuide0.do" alt="차종안내">
                    <area shape="rect" coords="254,0,489,102" href="/kor/used/autoaution.do" alt="오토옥션">
                </map>
                <a href="#" class="prev"><img src="/resources/images/btn_prev_ui.gif"></a>
                <a href="#" class="next"><img src="/resources/images/btn_next_ui.gif"></a>
                <ul class="pagination"><li class="current"><a href="#0">1</a></li><li class=""><a href="#1">2</a></li></ul></div>
        </div>
        <!-- event -->
        <div class="event_tit"><img src="http://www.ktkumhorent.com/resources/images/main_event_tit.gif" alt="event"></div>
        <div class="event">
            <a href="/kor/info/eventlist.do?rentID=3011&amp;pg=8"><img src="http://www.ktkumhorent.com/resources/images/main_hot.png" class="hot"></a>
            <a href="/kor/info/eventlist.do?rentID=3011&amp;type=1"><img src="http://www.ktkumhorent.com/resources/images/main_event_branch.png" class="branch"></a>
            <style type="text/css">
                #slides { position:relative; top:0; left:0; }
                #slides .slides_container { width:440px; overflow:hidden; position:relative; }
                #slides .slides_container a { width:398px; height:205px; display:block; }
                #slides .slides_container a img { display:block; }
                #slides .next { position:absolute; top:11px; left:176px; z-index:20; }
                #slides .prev { position:absolute; top:11px; left:160px; z-index:20; }
                #slides .pagination { display:none; }
            </style>
            <script src="/resources/js/slides.min.jquery.js"></script>
            <script>
                $(function(){
                    $('#slides').slides({
                        play: 5000,
                        pause: 2500,
                        hoverPause: true
                    });
                });
            </script>
            <div id="slides">
                <div class="slides_container" style="overflow: hidden; position: relative; display: block;">

                    <div class="slides_control" style="position: relative; width: 1194px; height: 205px; left: -408.299342253842px;"><a href="/kor/info/eventviewer.do?rentID=30112&amp;pageno=1&amp;mode=&amp;sitem=&amp;stext=&amp;seq=738" style="position: absolute; top: 0px; left: 398px; z-index: 0; display: none;"><img src="http://www.ktkumhorent.com/upfiles/writeImg/event/1388365200820_new_main_banner.jpg"></a><a href="/kor/info/eventviewer.do?rentID=30112&amp;pageno=1&amp;mode=&amp;sitem=&amp;stext=&amp;seq=737" style="position: absolute; top: 0px; left: 398px; z-index: 0; display: none;"><img src="http://www.ktkumhorent.com/upfiles/writeImg/event/1388365200481_new_main_banner.jpg"></a><a href="/kor/info/eventviewer.do?rentID=30112&amp;pageno=1&amp;mode=&amp;sitem=&amp;stext=&amp;seq=736" style="position: absolute; top: 0px; left: 398px; z-index: 5; display: block;"><img src="http://www.ktkumhorent.com/upfiles/writeImg/event/1388365200728_new_main_banner.jpg"></a><a href="/kor/info/eventviewer.do?rentID=30112&amp;pageno=1&amp;mode=&amp;sitem=&amp;stext=&amp;seq=735" style="position: absolute; top: 0px; left: 796px; z-index: 0; display: block;"><img src="http://www.ktkumhorent.com/upfiles/writeImg/event/1388365200125_new_main_banner.jpg"></a><a href="/kor/info/eventviewer.do?rentID=30112&amp;pageno=1&amp;mode=&amp;sitem=&amp;stext=&amp;seq=734" style="position: absolute; top: 0px; left: 398px; z-index: 0; display: none;"><img src="http://www.ktkumhorent.com/upfiles/writeImg/event/1388361600308_new_main_banner.jpg"></a><a href="/kor/info/eventviewer.do?rentID=30112&amp;pageno=1&amp;mode=&amp;sitem=&amp;stext=&amp;seq=733" style="position: absolute; top: 0px; left: 398px; z-index: 0; display: none;"><img src="http://www.ktkumhorent.com/upfiles/writeImg/event/1388376000394_new_main_banner.jpg"></a><a href="/kor/info/eventviewer.do?rentID=30112&amp;pageno=1&amp;mode=&amp;sitem=&amp;stext=&amp;seq=732" style="position: absolute; top: 0px; left: 398px; z-index: 0; display: none;"><img src="http://www.ktkumhorent.com/upfiles/writeImg/event/1388361600513_new_main_banner.jpg"></a><a href="/kor/info/eventviewer.do?rentID=30112&amp;pageno=1&amp;mode=&amp;sitem=&amp;stext=&amp;seq=731" style="position: absolute; top: 0px; left: 398px; z-index: 0; display: none;"><img src="http://www.ktkumhorent.com/upfiles/writeImg/event/138834000010_new_main_banner.jpg"></a><a href="/kor/info/eventviewer.do?rentID=30112&amp;pageno=1&amp;mode=&amp;sitem=&amp;stext=&amp;seq=730" style="position: absolute; top: 0px; left: 398px; z-index: 0; display: none;"><img src="http://www.ktkumhorent.com/upfiles/writeImg/event/1388336400590_new_main_banner.jpg"></a><a href="/kor/info/eventviewer.do?rentID=30112&amp;pageno=1&amp;mode=&amp;sitem=&amp;stext=&amp;seq=729" style="position: absolute; top: 0px; left: 398px; z-index: 0; display: none;"><img src="http://www.ktkumhorent.com/upfiles/writeImg/event/1388361600807_new_main_banner.jpg"></a><a href="/kor/info/eventviewer.do?rentID=30112&amp;pageno=1&amp;mode=&amp;sitem=&amp;stext=&amp;seq=728" style="position: absolute; top: 0px; left: 398px; z-index: 0; display: none;"><img src="http://www.ktkumhorent.com/upfiles/writeImg/event/1388336400440_new_main_banner.jpg"></a><a href="/kor/info/eventviewer.do?rentID=30112&amp;pageno=1&amp;mode=&amp;sitem=&amp;stext=&amp;seq=718" style="position: absolute; top: 0px; left: 398px; z-index: 0; display: none;"><img src="http://www.ktkumhorent.com/upfiles/writeImg/event/1388124000827_new_main_banner.jpg"></a><a href="/kor/info/eventviewer.do?rentID=30112&amp;pageno=1&amp;mode=&amp;sitem=&amp;stext=&amp;seq=632" style="position: absolute; top: 0px; left: 398px; z-index: 0; display: none;"><img src="http://www.ktkumhorent.com/upfiles/writeImg/event/1387983600262_new_main_banner.jpg"></a></div>

























                    <!-- <a href="/kor/info/eventviewer.do?rentID=30112&pageno=1&mode=&sitem=&stext=&seq=601"><img src="/resources/images/event_banner_ex.jpg" /></a> -->
                </div>
                <a href="#" class="prev"><img src="http://www.ktkumhorent.com/resources/images/main_prev.gif"></a>
                <a href="#" class="next"><img src="http://www.ktkumhorent.com/resources/images/main_next.gif"></a>
                <ul class="pagination"><li class=""><a href="#0">1</a></li><li class=""><a href="#1">2</a></li><li class=""><a href="#2">3</a></li><li class="current"><a href="#3">4</a></li><li class=""><a href="#4">5</a></li><li class=""><a href="#5">6</a></li><li class=""><a href="#6">7</a></li><li class=""><a href="#7">8</a></li><li class=""><a href="#8">9</a></li><li class=""><a href="#9">10</a></li><li class=""><a href="#10">11</a></li><li class=""><a href="#11">12</a></li><li class=""><a href="#12">13</a></li></ul></div>
        </div>
    </div>
</div>
<!-- /container -->
<!-- e: 130425 수정 -->


</div>
<!-- /containerwrap -->
<div id="footerwrap">
    <!-- footer -->


    <form name="reservEditFrm" id="reservEditFrm" method="post" action="/kor/reservation/check.do" target="reservFrame">
        <input type="hidden" name="usrName" id="usrNameEdit">
        <input type="hidden" name="usrPhoneNo" id="usrPhoneNoEdit">
        <input type="hidden" name="reservNo" id="reservNoEdit">
    </form>
    <div id="footer">
        <div><img src="/resources/images/footer_logo.gif" alt="로고"></div>
        <div class="menu">
            <a href="/kor/company/overview.do"><img src="/resources/images/fm_1.gif" alt="회사소개"></a> l
            <a href="/kor/etc/privacy.do"><img src="/resources/images/fm_2.gif" alt="개인정보취급방침"></a> l
            <a href="/kor/etc/guide.do"><img src="/resources/images/left/fm_6.gif" alt="영상정보처리"></a> l
            <a href="/kor/etc/policy.do"><img src="/resources/images/fm_3.gif" alt="이용약관"></a>  l
            <a href="/kor/company/sinmungo_01.do"><img src="/resources/images/fm_7.gif" alt="사이버신문고"></a>  l
            <a href="http://recruit.ktrental.com" target="_black"><img src="/resources/images/fm_9.gif" alt="인재채용"></a>  l <!-- 130531 인재채용 추가 -->
            <a href="#" onclick="window.open('/kor/pop/pop_email.do','pop_email','statusbar=no,titlebar=no,scrollbar=no,width=500,height=340');return false;"><img src="/resources/images/fm_4.gif" alt="무단이메일수집거부"></a>  l
            <a href="/kor/cs/cs_05.do"><img src="/resources/images/fm_5.gif" alt="Contack Us"></a> <!--   l
					<a href="http://www.ktkumhorent.com.vn/" target="_blank"><img src="/resources/images/fm_6.gif" alt="베트남 법인" /></a>-->
        </div>



        <div class="foot_con">
            <ul class="foot_first">
                <li class="first">(주)케이티렌탈</li>
                <li>대표이사 표현명</li>
                <li>사업자등록번호 214-87-79183</li>
                <li>통신판매업신고번호 : 제2010-경기안양-420호</li>
                <li class="last">경기도 안양시 동안구 전파로 88 신원비젼타워 8층</li>
            </ul>
            <div class="clear"></div>
            <p>서울본사:서울시 강남구 테헤란로 422 KT타워 6~9층</p>
            <ul class="foot_second">
                <li class="first"><span style="color:#dc0000;font-size:10px;font-family:Malgun Gothic;margin-top:2px">대표전화 1588-1230</span></li>
                <li style="color:#999">해외 82-2-797-8000</li>
                <li style="color:#999">FAX 02-3404-9795</li>
                <li class="last" style="color:#999">webmaster@ktrental.com</li>
            </ul>
            <div class="clear"></div>
            <ul class="foot_third">
                <li class="first">보험대차 연락처 및 일반상품렌탈 연락처</li>
                <li style="color:#999">보험대차 1588-4920</li>
                <li class="last" style="color:#999">일반상품렌탈 1577-5100+1</li>
            </ul>
            <div class="clear"></div>
            <p style="color:#999">COPYRIGHT ⓒ 2014 KTRENTAL CO.LTD.ALL RIGHT RESERVED</p>
        </div>
        <!--
        <div><img src="/resources/images/copyright.gif" /></div>




        -->
        <!-- 120620 추가--><div class="bizcf"><a href="http://www.ftc.go.kr/info/bizinfo/communicationList.jsp" target="_blank"><img src="/resources/images/btn_bizconfirm.gif"></a></div>
        <div class="family_site">
            <img src="/resources/images/family_site.gif" onclick="SwitchMenu('family_site_on')">
        </div>
        <!-- family_site_on -->
        <div id="family_site_on">
            <img src="/resources/images/btn_close.gif" alt="close" onclick="SwitchMenu('family_site_on')" class="close cursoron">
            <div><img src="/resources/images/family_site_on_tit.gif" alt="KT 그룹계열사"></div>
            <table class="tb007 mt35">
                <colgroup>
                    <col width="107">
                    <col width="70">
                </colgroup>
                <tbody><tr>
                    <td><a href="http://www.kt.com/" target="_black"><img src="/resources/images/family_site_1.gif" alt="KT"></a></td>
                    <td><a href="http://www.ever.co.kr/" target="_black"><img src="/resources/images/family_site_2.gif" alt="KT Tech"></a></td>
                </tr>
                <tr>
                    <td><a href="http://www.ktrental.com/" target="_black"><img src="/resources/images/family_site_3.gif" alt="KT Rental"></a></td>
                    <td><a href="http://www.telecop.co.kr/" target="_black"><img src="/resources/images/family_site_4.gif" alt="KT Telecop"></a></td>
                </tr>
                <tr>
                    <td><a href="http://www.ktdatasystems.com/" target="_black"><img src="/resources/images/family_site_5.gif" alt="KTDS"></a></td>
                    <td><a href="http://www.ktcapital.co.kr/" target="_black"><img src="/resources/images/family_site_6.gif" alt="KT Capital"></a></td>
                </tr>
                <tr>
                    <td><a href="http://www.kthcorp.com/" target="_black"><img src="/resources/images/family_site_7.gif" alt="KTH"></a></td>
                    <td><a href="http://www.sidus.net/" target="_black"><img src="/resources/images/family_site_8.gif" alt="Sidus FNH"></a></td>
                </tr>
                <tr>
                    <td><a href="http://www.ktpowertel.co.kr/" target="_black"><img src="/resources/images/family_site_9.gif" alt="KT Powertel"></a></td>
                    <td><a href="http://www.nasmedia.co.kr/" target="_black"><img src="/resources/images/family_site_10.gif" alt="nasmedia"></a></td>
                </tr>
                <tr>
                    <td><a href="http://www.ktlinkus.co.kr/" target="_black"><img src="/resources/images/family_site_11.gif" alt="KT Linkus"></a></td>
                    <td><a href="http://www.sofnics.com/include/main.asp"><img src="/resources/images/family_site_12.gif" alt="KT sofnics"></a></td>
                </tr>
                <tr>
                    <td><a href="http://www.ktsubmarine.co.kr/" target="_black"><img src="/resources/images/family_site_13.gif" alt="KT Submarine"></a></td>
                    <td><a href="http://www.ktfmusic.co.kr/" target="_black"><img src="/resources/images/family_site_14.gif" alt="KT MUSIC"></a></td>
                </tr>
                <tr>
                    <td><a href="http://www.ktn.co.kr/" target="_black"><img src="/resources/images/family_site_15.gif" alt="KT Networks"></a></td>
                    <td><a href="http://www.ktmns.com/" target="_black"><img src="/resources/images/family_site_16.gif" alt="KT M&amp;S"></a></td>
                </tr>
                <tr>
                    <td><a href="http://www.ktcommerce.co.kr/" target="_black"><img src="/resources/images/family_site_17.gif" alt="KT Commerce"></a></td>
                    <td><a href="http://www.ktis.co.kr/" target="_black"><img src="/resources/images/family_site_18.gif" alt="KT is"></a></td>
                </tr>
                <tr>
                    <td><a href="http://www.mhows.com/" target="_black"><img src="/resources/images/family_site_19.gif" alt="KT Mhows"></a></td>
                    <td><a href="http://www.ktcs.co.kr/" target="_black"><img src="/resources/images/family_site_20.gif" alt="KT cs"></a></td>
                </tr>
                </tbody></table>
        </div>
        <!-- /family_site_on -->
        <script> /*120914 수정*/
        function viewVeriSignInfo()
        {
            window.open('https://sealinfo.verisign.com/splash?form_file=fdf/splash.fdf&dn=www.ktkumhorent.com&lang=ko','viewVeriSignInfo','width=516, height=393,scrollbars=no,top=10,left=10');
        }
        </script>
        <!--120917 추가-->
        <link media="screen" rel="stylesheet" href="/resources/css/colorbox.css">
        <!--//120917 추가-->
        <!--120914 수정-->
        <div class="footer_banner">
            <a href="javascript:viewVeriSignInfo();" title="left1"><img src="/resources/images/footer_norton.gif"></a>
            <a class="example8 cboxElement" href="#"><img src="/resources/images/footer_banner.gif"></a>
        </div>
        <!--//120914 수정-->
    </div>
    <!--120917 수정-->
    <div style="display:none">
        <div id="inline_example1" style="padding:10px; background:#fff;">
            <div id="wrap">
                <!-- header -->
                <div>
                    <img src="/resources/images/title_01.jpg">
                </div>
                <!-- header -->
                <!-- container -->
                <div>
                    <img src="/resources/images/pop_contents.jpg">
                </div>
                <!-- //container -->
            </div>
        </div>
    </div>
    <!--//120917 수정-->
    <!--120917 추가-->
    <script src="/resources/js/jquery.colorbox.js"></script>
    <script>
        $(document).ready(function(){

            $(".example8").colorbox({width:"550px", inline:true, href:"#inline_example1", scrolling: false,opacity: 0.2});


            $("#click").click(function(){
                $('#click').css({"background-color":"#f00", "color":"#fff", "cursor":"inherit"}).text("Open this window again and this message will still be here.");
                return false;
            });
        });
    </script>
    <!--//120917 추가 -->


    <!-- /footer -->
</div>
<!-- 예약 -->


<script type="text/javascript">
    //<!--
    function doResize(v)
    {
        $("#reservFrame,.resbox").css({
            height : v > $(document).height() ? v : $(document).height()
        });

        $("#wrap").css({
            height : v > $(document).height() ? v : $(document).height()
        });
    }
    //-->
</script>
<!--<div class="resarea" id="resarea">
	<div class="openbox"><img src="/include/img/btn/btn_open.png" id="openboximg" alt="열기" /></div>
	<div class="resbox" style="margin-left:0px;padding-left:0px;width:900px">
		<div class='res' id="res"  style="margin-left:0px;padding-left:0px;width:900px;">
			 <iframe id="reservFrame" name="reservFrame" src="/kor/reservation.do" frameborder="0" style="border:0px;width:900px;" onload="doResize(1100);"></iframe>
		</div>
	</div>
</div>-->

<div id="shadow"></div>
<div id="wrap_re">
    <!--s:121220 수정-->
    <style type="text/css">
        .openbox .mv1	{position: relative; top: 102px; left: 18px; }
        .openbox .mv1 a:hover {}
        .openbox .im_1{position: relative; top: 250px; left: 18px; }
        .openbox .im_2 {position: relative; top: 175px; left: 18px; }
        .openbox .im_3 {position: relative; top: 322px; left: 18px; }
        .openbox .im_4 {position: relative; top: 399px; left: 18px; }
        .openbox .im_5 {position: relative; top: 479px; left: 18px; }
    </style>
    <!--e:121220 수정-->
    <div class="resarea" style="display: block;">
        <div class="openbox" style="height: 1304px;">
            <!-- s:121121 수정 -->
            <p class="mv1"><img src="/include/img/btn/rsv.png" alt="열기" class="hoverimg"></p>
            <p class="im_2"><img src="/include/img/btn/jeju.png" alt="제주실시간 예약" class="hoverimg"></p>
            <p class="im_1"><a href="/kor/my/myRentList.do"><img src="/include/img/btn/edit.png" alt="예약 확인-수정" class="hoverimg"></a></p>
            <p class="im_3"><a href="/kor/info/eventlist.do?rentID=3011&amp;pg=8"><img src="/include/img/btn/event.png" alt="이벤트" class="hoverimg"></a></p>
            <p class="im_4"><a href="/kor/cs/cs_area.do"><img src="/include/img/btn/location.png" alt="지점안내" class="hoverimg"></a></p>
            <p class="im_5"><a href="/kor/cs/cs_06.do"><img src="/include/img/btn/contract.png" alt="계약서 조회" class="hoverimg"></a></p>
        </div>
        <!-- e:121121 수정 -->
        <div class="resbox" style="height: 1197px;">
            <iframe id="reservFrame" name="reservFrame" src="/kor/reservation.do" frameborder="0" style="border: 0px; width: 900px; height: 1197px;" onload="doResize(1100);"> </iframe>
            <div class="close">
                <img src="/include/img/btn/popup_close.gif" alt="닫기" class="mv2">
            </div>
        </div>
    </div>
</div>
<!-- 예약 -->

</div>
</div>
<!-- /wrap -->

<!-- *) 공통 분석스크립트  -->
<!-- AceCounter Log Gathering Script V.71.2013012101 -->
<script language="javascript">
    if(typeof EL_GUL == 'undefined'){
        var EL_GUL = 'dgc17.acecounter.com';var EL_GPT='8080'; var _AIMG = new Image(); var _bn=navigator.appName; var _PR = location.protocol=="https:"?"https://"+EL_GUL:"http://"+EL_GUL+":"+EL_GPT;if( _bn.indexOf("Netscape") > -1 || _bn=="Mozilla"){ setTimeout("_AIMG.src = _PR+'/?cookie';",1); } else{ _AIMG.src = _PR+'/?cookie'; };
        document.writeln("<scr"+"ipt language='javascript' src='/acecounter/acecounter_V70.js'></scr"+"ipt>");
    }
</script><script language="javascript" src="/acecounter/acecounter_V70.js"></script>

<noscript>&lt;img src='http://dgc17.acecounter.com:8080/?uid=BR1L38220010836&amp;je=n&amp;' border=0 width=0 height=0&gt;</noscript>
<!-- AceCounter Log Gathering Script End -->



<!-- Google Code for &#49324;&#51060;&#53944;&#48169;&#47928;&#51088; -->
<!-- Remarketing tags may not be associated with personally identifiable information or placed on pages related to sensitive categories. For instructions on adding this tag and more information on the above requirements, read the setup guide: google.com/ads/remarketingsetup -->
<script type="text/javascript">
    /* <![CDATA[ */
    var google_conversion_id = 1051075495;
    var google_conversion_label = "OtHkCL3avwYQp8eY9QM";
    var google_custom_params = window.google_tag_params;
    var google_remarketing_only = true;
    /* ]]> */
</script>
<script type="text/javascript" src="//www.googleadservices.com/pagead/conversion.js">
</script><iframe name="google_conversion_frame" title="Google conversion frame" width="300" height="13" src="https://googleads.g.doubleclick.net/pagead/viewthroughconversion/1051075495/?random=1412436824849&amp;cv=7&amp;fst=1412436824849&amp;num=1&amp;fmt=1&amp;label=OtHkCL3avwYQp8eY9QM&amp;guid=ON&amp;u_h=1050&amp;u_w=1680&amp;u_ah=956&amp;u_aw=1680&amp;u_cd=24&amp;u_his=2&amp;u_tz=540&amp;u_java=true&amp;u_nplug=10&amp;u_nmime=50&amp;frm=0&amp;url=https%3A//www.ktkumhorent.com/main.do&amp;ref=https%3A//www.ktkumhorent.com/" frameborder="0" marginwidth="0" marginheight="0" vspace="0" hspace="0" allowtransparency="true" scrolling="no">&lt;img height="1" width="1" border="0" alt="" src="https://googleads.g.doubleclick.net/pagead/viewthroughconversion/1051075495/?frame=0&amp;random=1412436824849&amp;cv=7&amp;fst=1412436824849&amp;num=1&amp;fmt=1&amp;label=OtHkCL3avwYQp8eY9QM&amp;guid=ON&amp;u_h=1050&amp;u_w=1680&amp;u_ah=956&amp;u_aw=1680&amp;u_cd=24&amp;u_his=2&amp;u_tz=540&amp;u_java=true&amp;u_nplug=10&amp;u_nmime=50&amp;frm=0&amp;url=https%3A//www.ktkumhorent.com/main.do&amp;ref=https%3A//www.ktkumhorent.com/" /&gt;</iframe>
<noscript>
    &lt;div style="display:inline;"&gt;
    &lt;img height="1" width="1" style="border-style:none;" alt="" src="//googleads.g.doubleclick.net/pagead/viewthroughconversion/1051075495/?value=0&amp;amp;label=OtHkCL3avwYQp8eY9QM&amp;amp;guid=ON&amp;amp;script=0"/&gt;
    &lt;/div&gt;
</noscript>

<div id="ui-datepicker-div" class="ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all ui-helper-hidden-accessible"></div></body></html>