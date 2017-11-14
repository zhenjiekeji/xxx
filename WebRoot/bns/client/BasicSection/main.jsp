<%@page import="com.uk.sec.bns.client.model.BasicLinkowner"%>
<%@page import="com.uk.sec.bns.client.service.BasicLinkownerManager"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>营改增系统</title>
<base href="${ctx}/bns/client/" />
<link rel="stylesheet" type="text/css" href="../../scripts/jquery-easyui-1.3.6/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="../../scripts/jquery-easyui-1.3.6/themes/icon.css" />
<script type="text/javascript" src="../../scripts/jquery-easyui-1.3.6/jquery.min.js"></script>
<script type="text/javascript" src="../../scripts/jquery-easyui-1.3.6/jquery.easyui.min.js"></script>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	$(document).ready(function() {
		$(".ok_show").click(function() {
			$(".search_show").show();
		});
	});
</script>
<script type="text/javascript" src="js/js.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
</head>

<body>
	<%@ include file="../head.jsp"%>

	<div class="nrv">
		<div class="nrvs">
			<%@ include file="../left.jsp"%>

			<div class="neir">

				<div class="bbs_title">
					<div title="欢迎使用" class="maindiv">
					<center><font size="20">欢迎使用河北高速营改增管理系统</font></center>
					</div>
				</div>
				<div class="tab_tops">
					<%@ include file="list_table.jsp"%>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../foot.jsp"%>

</body>
</html>

