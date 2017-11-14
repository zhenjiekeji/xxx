<%@ page pageEncoding="UTF-8" language="java" %>
<%@ include file="/commons/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<title></title>
<%@ include file="/commons/meta.jsp" %>
</head>
<body>
<table class="fullScreen"><tr><td>
<div class="OperateResultPanel">
    <div class="OperateResultIMG"><em class="imgFailure"></em></div>
	<div class="OperateResult">
    	<p><s:property value="successMessage" /></p>
	</div>
	<div class="OperateResultPanelFoot"><input type="button" value="确定" onclick="window.location.href='${ctx}<s:property value="returnPath" />';" class="BtnInput" /></div>
</div>
</td></tr></table>
</body>
</html>