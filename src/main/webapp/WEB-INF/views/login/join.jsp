<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
회원가입

<div class="mem01">
<!-- 회원가입 -->
<h4 class="tit fleft"><img src="/resources/images/member/join_sub_01.gif" alt="회원가입 할인혜택"></h4>

<p class="clear"></p>

<p><img src="/resources/images/member/join_pic_01.gif" alt="회원가입 할인혜택"></p>

<div class="dline"></div>
<!-- 이용약관 -->

<!-- 내국인 외국인 선택 버튼 추가 140305-->
<div class="j_select mt20">
    <ul>
        <li><b>가입 구분</b></li>
        <li><input type="radio" name="NationDiv" value="1" onclick="changeTd(2);changeNation(1);" checked="checked">&nbsp;내국인
        </li>
        <li><input type="radio" name="NationDiv" value="3" onclick="changeTd(1);changeNation(2);">&nbsp;외국인</li>
    </ul>
</div>
<div class="clear"></div>
<!-- 내국인 외국인 선택 버튼 추가 끝 -->


<h4 class="tit fleft mt20 mb10"><img src="/resources/images/member/login_sub_02.gif" alt="이용약관"></h4>

<p class="clear"></p>
<iframe src="/etcs/_policy.html" scrolling="yes" marginwidth="0" marginheight="0" frameborder="0" vspace="0" hspace="0"
        class="ifr"></iframe>
<p align="center" class="mt10">
    <label for="agreeChkOk"><input type="radio" name="agreeChk" id="agreeChkOk">&nbsp;동의합니다.</label> <label
        for="agreeChkNo"><input type="radio" name="agreeChk" id="agreeChkNo">&nbsp;동의하지 않습니다.</label>
</p>


<!-- 개인정보처리방침에 대한 동의 -->
<h4 class="tit fleft mt30 mb10"><img src="/resources/images/member/login_sub_txt_01.gif" alt="개인정보 수집∙이용 동의"></h4>
<!-- 이미지 이미 변경 -->
<p class="clear"></p>

<p style="padding-right:45px; margin-bottom:10px;">
    <!--120608‘KT금호렌터카㈜’는 (이하 ‘회사’는) 고객님의 개인정보를 중요시하며, 정보통신망 이용촉진 및 정보보호에 관한 법률을 준수하고 있습니다.-->주식회사 케이티렌탈은 kt금호렌터카 회원가입
    서비스 제공을 위한 개인정보 수집·이용을 위하여, 「개인정보보호법」 제15조 등 법령에 따라 귀하의 동의를 받고자 합니다.<br>
    <b>필요한 최소한의 정보(필수사항) 외의 개인정보 수집·이용에는 동의하지 아니할 수 있습니다.</b></p><!-- 텍스트 변경 -->
<iframe src="/etcs/_privacy01.html" scrolling="yes" marginwidth="0" marginheight="0" frameborder="0" vspace="0" hspace="0" class="ifr"></iframe>


<!-- 140305 레이아웃 변경 ================= -->

<ul class="checked_box mt20">
    <li>
        <p align="center" class="mt10 lineh18">위와 같이 개인정보를 수집∙이용하는 것에 동의합니다.<br>
            * 필수 사항 수집∙이용 (필수)
        </p>

        <p align="center" class="lineh18">
            <label for="agreeChk1Ok"><input type="radio" name="agreeChk1" id="agreeChk1Ok">&nbsp;동의합니다.</label> <label
                for="agreeChk1No"><input type="radio" name="agreeChk1" id="agreeChk1No">&nbsp;동의하지 않습니다.</label>
        </p>

        <p align="center" class="mt10 lineh18">* 선택 사항 수집∙이용 (선택)</p>

        <p align="center" class="mt10 lineh18">
            <label for="agreeChk2Ok"><input type="radio" name="agreeChk2" id="agreeChk2Ok">&nbsp;동의합니다.</label> <label
                for="agreeChk2No"><input type="radio" name="agreeChk2" id="agreeChk2No">&nbsp;동의하지 않습니다.</label>
        </p>

    </li>
    <li>
        <p align="center" class="mt10">위와 같이 고유식별정보를 수집∙이용하는 것에 동의합니다.</p>

        <!-- 외국인일 경우 노툴 내국인 x   -->
        <p align="center" class="mt10 fr1" style="display: none;">* 외국인의 고유식별정보(여권번호) 수집∙이용 (필수)</p>

        <p align="center" class="mt10 lineh18 fr1" style="display: none;">
            <label for="agreeChk3Ok"><input type="radio" name="agreeChk3" id="agreeChk3Ok">&nbsp;동의합니다.</label> <label
                for="agreeChk3No"><input type="radio" name="agreeChk3" id="agreeChk3No">&nbsp;동의하지 않습니다.</label>
            <!-- 외국인일 경우 노툴 내국인 x  끝 -->

        </p>

        <p align="center" class="mt10 lineh18">* 고유식별정보(운전면허번호) 수집∙이용 (선택)</p>

        <p align="center" class="mt10 mb10 lineh18">
            <label for="agreeChk3Ok"><input type="radio" name="agreeChk4" id="agreeChk4Ok">&nbsp;동의합니다.</label> <label
                for="agreeChk3No"><input type="radio" name="agreeChk4" id="agreeChk3No">&nbsp;동의하지 않습니다.</label>
        </p>
    </li>
</ul>
<div class="clear"></div>

<!-- 140305 레이아웃 변경 ================= 끝-->

<h4 class="tit fleft mt30 mb10"><img src="/resources/images/member/login_sub_txt_02.gif"
                                     alt="마케팅∙광고∙홍보 등 활용을 위한 개인정보 수집∙이용∙제공 동의"></h4><!-- 이미지폰트 추가 -->
<p class="clear"></p>

<p class="clear"></p>

<p style="padding-right:45px; margin-bottom:10px;">주식회사 케이티렌탈은 마케팅·광고·홍보 등 활용을 위한 개인정보 수집·이용·제공을 위하여, 「개인정보보호법」 제15조 등
    법령에 따라 귀하의 동의를 받고자 합니다.<br>단, 동의하지 않으셔도 회원가입은 가능합니다.</p>
<iframe src="/etcs/_privacy02.html" scrolling="yes" marginwidth="0" marginheight="0" frameborder="0" vspace="0"
        hspace="0" class="ifr"></iframe>
<p align="center" class="mt10 mb10">
    <label for="agreeChk4Ok"><input type="radio" name="agreeChk5" id="agreeChk5Ok">&nbsp;동의합니다.</label> <label
        for="agreeChk4No"><input type="radio" name="agreeChk5" id="agreeChk4No">&nbsp;동의하지 않습니다.</label>
</p>

<iframe src="/etcs/_privacy03.html" scrolling="yes" marginwidth="0" marginheight="0" frameborder="0" vspace="0"
        hspace="0" class="ifr"></iframe>
<p align="center" class="mt10 mb10">
    <label for="agreeChk5Ok"><input type="radio" name="agreeChk6" id="agreeChk6Ok">&nbsp;동의합니다.</label> <label
        for="agreeChk5No"><input type="radio" name="agreeChk6" id="agreeChk5No">&nbsp;동의하지 않습니다.</label>
</p>


<!-- 내용 수정 끝  140303 ===========================================================================  -->


<!-- 본인확인 -->
<h4 class="tit fleft">
    <img src="/resources/images/member/login_sub_04.gif" alt="본인확인"></h4>

<p class="clear"></p>
<ul class="tab fr2">
    <li><a href="javascript:changeTd(2);"><img src="/resources/images/member/idpw_tab_01_on.gif" id="ipin_tab"
                                               alt="아이핀 인증"></a></li>
    <li><a href="javascript:changeTd(3);"><img src="/resources/images/member/idpw_tab_02.gif" id="phone_tab"
                                               alt="휴대폰 인증"></a></li>
</ul>

<div class="confirm_tb">
<table width="500px">
<colgroup>
    <col width="138px">
    <col width="*">
</colgroup>
<tbody>
<tr>
<td valign="top" style="padding-left:10px;display:none;" id="ssn_td">
<div id="korpeople" style="display:none">
    <span class="vm mr10"><img src="/resources/images/member/mem01_t221.gif" class="vm mr10" alt="한글이름"><input
            type="text" name="cust_name" maxlength="10" class="ins wSize66"></span>
    <img src="/resources/images/member/mem01_t01.gif" class="vm mr10" alt="주민등록번호">
    <input type="text" name="cust_code1" maxlength="6" onkeypress="FunNumeric();" onkeyup="moveFocus('1');"
           class="ins wSize105"> <span class="fsmall">-</span>
    <input type="password" name="cust_code2" class="ins wSize105" maxlength="7" onkeypress="FunNumeric();">

    <p class="tb_text mt10 mb5"><input type="checkbox" id="agreeJuminInfo" name="agreeJuminInfo">주민등록번호 처리에 동의합니다.</p>

    <p class="tf11 fcsblue mt5 mb15" style="font-size:11px;">1991년 5월 23일 이전에 출생하신 분들은 회원가입 하실 수 없습니다.</p>
    <!-- <p class="tb_text mt15">아이핀인증으로 가입하신 경우에는 <span class="fcsblue">아이핀(I-PIN)으로 찾기</span>를 이용해 주세요. </p> -->
    <p class="tb_text">주민등록번호 및 외국인 등록번호는 실명인증 조회용으로 사용한 후 저장되지 않고 바로 폐기합니다.</p>
</div>
<!-- <div id="outpeople" style="display:none;">
<img src="/resources/images/member/mem01_t01_8.gif" class="vm mr10" alt="여권번호" /> <input type="text" name="cust_code3" maxlength="13" class="ins wSize225" onkeypress="javascript:this.value=this.value.toUpperCase();" onchange="javascript:this.value=this.value.toUpperCase();">
<p class="tf11 fcsblue mt10" style="font-size:11px;">1991년 5월 23일 이전에 출생하신 분들은 회원 가입 하실 수 없습니다.</p>
</div> -->


<!-- 외국인일 경우 노출 ===================================================================== 140305 -->
<div id="outpeople" style="display:none;">
<div id="outpeople">
<!-- Country Code : -->
국가 :
<select id="countryCode" name="countryCode">
<option value="0" selected="selected">선택해주세요.</option>

<option value="IO">Brit.Ind.Oc.Ter</option>

<option value="GH">가나</option>

<option value="GA">가봉</option>

<option value="GY">가이아나</option>

<option value="GM">감비아</option>

<option value="GP">과들루프</option>

<option value="GT">과테말라</option>

<option value="GU">괌</option>

<option value="GD">그레나다</option>

<option value="GE">그루지야</option>

<option value="GR">그리스</option>

<option value="GL">그린란드</option>

<option value="GN">기니</option>

<option value="GW">기니비사우</option>

<option value="NA">나미비아</option>

<option value="NR">나우루</option>

<option value="NG">나이지리아</option>

<option value="AQ">남극 대륙</option>

<option value="NL">네덜란드</option>

<option value="NP">네팔</option>

<option value="NO">노르웨이</option>

<option value="NF">노퍽 섬</option>

<option value="NZ">뉴질랜드</option>

<option value="NC">뉴칼레도니아</option>

<option value="NU">니우에</option>

<option value="NE">니제르</option>

<option value="NI">니카라과</option>

<option value="TW">대만</option>

<option value="DK">덴마크</option>

<option value="DM">도미니카</option>

<option value="DO">도미니카 공화국</option>

<option value="DE">독일</option>

<option value="TL">동티모르</option>

<option value="TP">동티모르</option>

<option value="LA">라오스</option>

<option value="LR">라이베리아</option>

<option value="LV">라트비아</option>

<option value="RU">러시아</option>

<option value="LB">레바논</option>

<option value="LS">레소토</option>

<option value="RO">루마니아</option>

<option value="LU">룩셈부르크</option>

<option value="RW">르완다</option>

<option value="LY">리비아</option>

<option value="RE">리유니언 섬</option>

<option value="LT">리투아니아</option>

<option value="LI">리히텐슈타인</option>

<option value="MG">마다가스카르</option>

<option value="MQ">마르티니크</option>

<option value="MH">마셜 제도</option>

<option value="YT">마요트</option>

<option value="MR">마우레타니아</option>

<option value="MO">마카오</option>

<option value="MK">마케도니아</option>

<option value="MW">말라위</option>

<option value="MY">말레이시아</option>

<option value="ML">말리</option>

<option value="MX">멕시코</option>

<option value="MC">모나코</option>

<option value="MA">모로코</option>

<option value="MU">모리셔스</option>

<option value="MZ">모잠비크</option>

<option value="MS">몬트세라트</option>

<option value="MD">몰도바</option>

<option value="MV">몰디브</option>

<option value="MT">몰타</option>

<option value="MN">몽골</option>

<option value="US">미국</option>

<option value="AS">미국령 사모아</option>

<option value="MM">미얀마</option>

<option value="FM">미크로네시아</option>

<option value="VU">바누아투</option>

<option value="BH">바레인</option>

<option value="BB">바베이도스</option>

<option value="VA">바티칸</option>

<option value="BS">바하마</option>

<option value="BD">방글라데시</option>

<option value="BM">버뮤다</option>

<option value="BJ">베냉</option>

<option value="VE">베네수엘라</option>

<option value="VN">베트남</option>

<option value="BE">벨기에</option>

<option value="BY">벨로루시</option>

<option value="BZ">벨리즈</option>

<option value="BW">보츠와나</option>

<option value="BO">볼리비아</option>

<option value="BI">부룬디</option>

<option value="BF">부르키나파소</option>

<option value="BV">부베이 섬</option>

<option value="BT">부탄</option>

<option value="MP">북마리아나 제도</option>

<option value="KP">북한</option>

<option value="BG">불가리아</option>

<option value="BR">브라질</option>

<option value="BN">브루나이</option>

<option value="WS">사모아</option>

<option value="SA">사우디아라비아</option>

<option value="SM">산마리노</option>

<option value="ST">상투메 프린시페</option>

<option value="EH">서사하라</option>

<option value="SN">세네갈</option>

<option value="SC">세이셸</option>

<option value="LC">세인트 루시아</option>

<option value="VC">세인트 빈센트</option>

<option value="SH">세인트 헬레나</option>

<option value="SO">소말리아</option>

<option value="UM">소수 외부 제도</option>

<option value="SB">솔로몬 제도</option>

<option value="SD">수단</option>

<option value="SR">수리남</option>

<option value="LK">스리랑카</option>

<option value="SJ">스발바르</option>

<option value="SZ">스와질란드</option>

<option value="SE">스웨덴</option>

<option value="CH">스위스</option>

<option value="ES">스페인</option>

<option value="SK">슬로바키아</option>

<option value="SI">슬로베니아</option>

<option value="SY">시리아</option>

<option value="SL">시에라리온</option>

<option value="SG">싱가포르</option>

<option value="AE">아랍에미리트</option>

<option value="AW">아루바</option>

<option value="AM">아르메니아</option>

<option value="AR">아르헨티나</option>

<option value="IS">아이슬란드</option>

<option value="HT">아이티</option>

<option value="IE">아일랜드</option>

<option value="AZ">아제르바이잔</option>

<option value="AF">아프가니스탄</option>

<option value="AD">안도라</option>

<option value="AL">알바니아</option>

<option value="DZ">알제리</option>

<option value="AO">앙골라</option>

<option value="AG">앤티가 바부다</option>

<option value="AI">앵귈라</option>

<option value="ER">에리트레아</option>

<option value="EE">에스토니아</option>

<option value="EC">에콰도르</option>

<option value="ET">에티오피아</option>

<option value="SV">엘살바도르</option>

<option value="GB">영국</option>

<option value="YE">예멘</option>

<option value="OM">오만</option>

<option value="AU">오스트레일리아</option>

<option value="AT">오스트리아</option>

<option value="HN">온두라스</option>

<option value="JO">요르단</option>

<option value="UG">우간다</option>

<option value="UY">우르과이</option>

<option value="UZ">우즈베키스탄</option>

<option value="UA">우크라이나</option>

<option value="WF">월리스 푸투나</option>

<option value="EU">유럽연합</option>

<option value="IQ">이라크</option>

<option value="IR">이란</option>

<option value="IL">이스라엘</option>

<option value="EG">이집트</option>

<option value="IT">이탈리아</option>

<option value="IN">인도</option>

<option value="ID">인도네시아</option>

<option value="JP">일본</option>

<option value="JM">자메이카</option>

<option value="ZM">잠비아</option>

<option value="GQ">적도 기니</option>

<option value="OR">주황색</option>

<option value="CN">중국</option>

<option value="DJ">지부티</option>

<option value="GI">지브롤터</option>

<option value="ZW">짐바브웨</option>

<option value="TD">차드</option>

<option value="CZ">체코</option>

<option value="CL">칠레</option>

<option value="CM">카메룬</option>

<option value="CV">카보베르데</option>

<option value="KZ">카자흐스탄</option>

<option value="QA">카타르</option>

<option value="KH">캄보디아</option>

<option value="CA">캐나다</option>

<option value="KE">케냐</option>

<option value="KY">케이맨 제도</option>

<option value="KM">코모로</option>

<option value="CR">코스타리카</option>

<option value="CC">코코넛 섬</option>

<option value="CI">코트디부아르</option>

<option value="CO">콜롬비아</option>

<option value="CG">콩고</option>

<option value="CD">콩고민주공화국</option>

<option value="CU">쿠바</option>

<option value="KW">쿠웨이트</option>

<option value="CK">쿡 제도</option>

<option value="HR">크로아티아</option>

<option value="CX">크리스마스 섬</option>

<option value="KG">키르기스스탄</option>

<option value="KI">키리바시</option>

<option value="CY">키프로스</option>

<option value="TJ">타지키스탄</option>

<option value="TZ">탄자니아</option>

<option value="TH">태국</option>

<option value="TR">터키</option>

<option value="TG">토고</option>

<option value="TK">토켈라우</option>

<option value="TO">통가</option>

<option value="TM">투르크메니스탄</option>

<option value="TV">투발루</option>

<option value="TN">튀니지</option>

<option value="PA">파나마</option>

<option value="PY">파라과이</option>

<option value="BL">파랑</option>

<option value="PK">파키스탄</option>

<option value="PG">파푸아뉴기니</option>

<option value="PW">팔라우</option>

<option value="PS">팔레스타인</option>

<option value="FO">페로 제도</option>

<option value="PE">페루</option>

<option value="PT">포르투갈</option>

<option value="FK">포클랜드 제도</option>

<option value="PL">폴란드</option>

<option value="PR">푸에르토리코</option>

<option value="FR">프랑스</option>

<option value="TF">프랑스남쪽영역</option>

<option value="GF">프랑스령 기아나</option>

<option value="FJ">피지</option>

<option value="FI">핀란드</option>

<option value="PH">필리핀</option>

<option value="PN">핏케언 제도</option>

<option value="KR">한국</option>

<option value="HU">헝가리</option>

<option value="HK">홍콩</option>

</select>
<br>
<br>
<img src="/resources/images/member/mem01_t01_8.gif" class="vm mr10" alt="여권번호"> <input type="text" name="cust_code3"
                                                                                       maxlength="13"
                                                                                       class="ins wSize225"
                                                                                       onkeypress="javascript:this.value=this.value.toUpperCase();"
                                                                                       onchange="javascript:this.value=this.value.toUpperCase();">
</div>
<!-- <p class="tf11 fcsblue mt10" style="font-size:11px;">1991년 5월 23일 이전에 출생하신 분들은 회원 가입 하실 수 없습니다.</p> -->
</div>
<!-- 외국인일 경우 노출 =====================================================================  끝-->
</td>
<!-- 내국인일 경우 노출 ===================================================================== 140305 -->
<td valign="top" style="padding-left:10px;" id="ipin_td">
    <img src="/resources/images/member/join_text_01.gif" class="vm mr10"
         alt="아이핀 인증을 통한 회원가입을 원하시면 아이핀 인증버튼을 눌러 회원가입을 진행해 주세요.">

    <p class="mt10"><a href="#this" onclick="certKCBIpin();"><img src="/resources/images/member/btn_join_04.gif"
                                                                  alt="아이핀으로 인증받기"></a></p>

    <p class="mt10"><a
            href="http://www.ok-name.co.kr/acs/on/personipin/ipin_personServiceIntro.jsp?menu_id=2&amp;sebmunu_id=1"
            target="_blank"><img src="/resources/images/member/btn_join_05.gif" alt="아이핀서비스란"></a></p>
</td>
<!-- 내국인일 경우 노출 =====================================================================  끝-->
<td valign="top" style="padding-left:10px;display:none;" id="phone_td">
    <img src="/resources/images/member/join_text_02.gif" class="vm mr10" alt="휴대폰 SMS 인증 후 회원가입이 가능합니다.">

    <p class="mt10"><a href="#this" onclick="hscertPop();"><img src="/resources/images/member/btn_sms.gif"
                                                                alt="휴대폰으로 인증받기"></a></p>
</td>
</tr>
</tbody>
</table>

</div>
<p class="mt10 mb5"><img src="/resources/images/member/pop_dot.gif" class="vm mr5" alt="">만 21세 미만이신 분은 회원에 가입할 수 없음을
    알려드립니다.</p>

<p class="mt5mb10"><img src="/resources/images/member/pop_dot.gif" class="vm mr5" alt="">모든 면허취득자는 회원가입이 가능하나 취득 후 운전경력이
    1년 이상인 회원만 차량대여가 가능합니다.</p>

<div class="dline"></div>
</div>