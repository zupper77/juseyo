<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<link rel="stylesheet" href="/resources/css/menu.css">
<script src="/resources/js/menu.js"></script>
<h1><a href="/">logo</a></h1>
<!-- top_link -->
<div class="top_link">
    <a href="/login.do">로그인</a> l
    <a href="/join.do">회원가입</a> l
    <a href="/notice/noticeList.do">공지사항</a> l
    <a href="/sitemap.do">사이트맵</a>
</div>
<!-- /top_link -->
<!-- nav -->
<div id='cssmenu'>
    <ul>
        <li><a href='#'>수리/설치</a></li>
        <li class='active has-sub'><a href='#'>복구/복원</a>
            <ul>
                <li class='has-sub'><a href='#'>Product 1</a>
                    <ul>
                        <li><a href='#'>Sub Product</a></li>
                        <li><a href='#'>Sub Product</a></li>
                    </ul>
                </li>
                <li class='has-sub'><a href='#'>Product 2</a>
                    <ul>
                        <li><a href='#'>Sub Product</a></li>
                        <li><a href='#'>Sub Product</a></li>
                    </ul>
                </li>
            </ul>
        </li>
        <li><a href='#'>매입/판매</a></li>
    </ul>
</div>
<!-- /nav -->