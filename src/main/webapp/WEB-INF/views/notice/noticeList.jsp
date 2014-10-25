<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Library -->
<script type="text/javascript" src="/resources/js/notice/noticeList.js"></script>

<form id="schForm" method="post">
    <input type="hidden" name="schStartDate" id="schStartDate" >
    <input type="hidden" name="schEndDate" id="schEndDate" >

    <!-- tblWrap -->
    <div class="tb001">
        <!-- tblVertical01 -->
        <table class="tb001">
            <caption></caption>
            <colgroup>
                <col style="width:15%;">
                <col style="width:35%;">
                <col style="width:15%;">
                <col style="width:35%;">
            </colgroup>

            <tbody>
            <tr>
                <th scope="row">일자</th>
                <td colspan="3">
                    <div class="styled">
                        <select name="schDateType" id="schDateType" class="btnSelect110">
                            <option value="도착일">도착일</option>
                            <option value="수령일">수령일</option>
                        </select>
                    </div>
                    <a href="#" class="btnTypeSw" id="todayBtn">오늘</a>
                    <a href="#" class="btnTypeSw" id="weekBtn">1주일</a>
                    <a href="#" class="btnTypeSw" id="oneMonthBtn">1개월</a>
                    <a href="#" class="btnTypeSw" id="threeMonthBtn">3개월</a>
                    <div style="display:none;" class='startDate' id="schStartDate"></div> ~
                    <div style="display:none;" class='endDate' id="schEndDate"></div>
                </td>
            </tr>
            <tr>
                <th scope="row">수령여부</th>
                <td colspan="3">
                    <label class="inputRadio"><input type="radio" name="schIsReceipt" value="" checked>전체</label>
                    <label class="inputRadio"><input type="radio" name="schIsReceipt" value="y">수령</label>
                    <label class="inputRadio"><input type="radio" name="schIsReceipt" value="n">미수령</label>
                </td>
            </tr>
            <tr>
                <th scope="row">분류</th>
                <td>
                    <label class="inputCheck"><input type="checkbox" name="schPostType" value="" checked>전체</label>
                    <label class="inputCheck"><input type="checkbox" name="schPostType" value="택배">택배</label>
                    <label class="inputCheck"><input type="checkbox" name="schPostType" value="등기">등기</label>
                </td>
                <th scope="row">택배사</th>
                <td>
                    <!-- selectList -->
                    <div class="styled">
                        <select name="schPostCompany" id="schPostCompany" class="btnSelect250">
                            <option value="">전체</option>
                            <c:forEach items="${pstCompanyList}" var="company">
                                <option value="${company.companyId}">${company.companyNm}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <!-- //selectList -->
                </td>
            </tr>
            <tr>
                <th scope="row">수령인</th>
                <td colspan="3">
                    <input type="text" class="normal typeFull" name="schReceiptNm" id="schReceiptNm">
                </td>
            </tr>
            </tbody>
        </table>
        <!-- tblVertical01 -->
    </div>
    <div class="btnArea alignRight">
        <a href="#" class="btnTypeSg" id="schBtn">검색</a>
    </div>
</form>

<div class="util">
    <div class="info">
        <p>총 <strong><span id="totalCount"></span></strong>개의 수취물 : 미수령 충 <strong>1000</strong>개, 수령 총 <strong>1000</strong>개</p>
    </div>
    <div class="btnArea posRight">
        <a href="#" class="btnTypeSw hasIco btnDownload02">엑셀다운</a>
        <!--a href="#" class="btnTypeMw hasIco btnDownload02">??????</a-->
    </div>
</div>
<!-- tblWrap -->
<div class="tblWrap">
    <!-- tblHorizon01 -->
    <table class="tblHorizon01">
        <caption>수취물 현황 리스트</caption>
        <colgroup>
            <col style="width:20%;">
            <col style="width:12%;">
            <col style="width:15%;">
            <col style="width:8%;">
            <col style="width:*;">
            <col style="width:15%;">
            <col style="width:15%;">
        </colgroup>
        <thead>
        <tr>
            <th scope="col">조직</th>
            <th scope="col">수령자</th>
            <th scope="col">사번</th>
            <th scope="col">분류</th>
            <th scope="col">택배사</th>
            <th scope="col">도착일</th>
            <th scope="col">수령일</th>
        </tr>
        </thead>
        <tbody id="posteceiptListArea">

        </tbody>
    </table>
    <!-- //tblHorizon01 -->
</div>
<!-- //tblWrap -->

<!-- paginate -->
<div class="paginate" id="pagingArea">
</div>
<!-- //paginate -->