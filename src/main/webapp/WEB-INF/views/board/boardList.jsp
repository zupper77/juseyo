<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<script type="text/javascript" src="/lib/smartEditor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script>
function test(){
	oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
	var chk = document.getElementById("ir1").value;
	alert(chk);
	}
</script>

<form>
<textarea name="ir1" id="ir1" rows="10" cols="100" style="width:766px; height:412px; display:none;"></textarea>
<a href="#" onclick="test();return null;">확인</a>
</form>


<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
oAppRef: oEditors,
elPlaceHolder: "ir1",
sSkinURI: "/lib/smartEditor/SmartEditor2Skin.html",
fCreator: "createSEditor2"
});
</script>