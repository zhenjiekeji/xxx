<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="/commons/taglibs.jsp" %>
<!-- CSS -->
<link rel="stylesheet" href="${ctx}/assets/css/reset.css">
<link rel="stylesheet" href="${ctx}/assets/css/supersized.css">
<link rel="stylesheet" href="${ctx}/assets/css/style.css">
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
    <script src="assets/js/html5.js"></script>
<![endif]-->
<title>营改增应用平台管理系统</title>
<script type="text/javascript">
    //文档加载完毕
	window.onload=function(){
		if($("#errorMessage").val()!=""){
		     alert($("#errorMessage").val());
		}
	};
	jQuery(function($){
		if (top.location !== self.location) {
     			top.location = self.location;
  			}
	});
	function checkForm(){
		if($("#loginName").val()=="" || $("#passwd").val()==""){
			alert("用户名或密码不能为空！");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
     <div class="page-container">
         <h1><img src="${ctx}/assets/img/logos.png" /></h1>
         <h1>营改增应用平台管理系统</h1>
         <form id="loginForm" action="${ctx}/login.do" method="post" onsubmit="return checkForm();">
             <input type="hidden" value="${errorMessage}" id="errorMessage" />
             <input type="text" id="loginName" name="loginName" class="username" placeholder="请输入您的用户名！">
             <input type="password" id="passwd" name="passwd" class="password" placeholder="请输入您的用户密码！">
             <button type="submit" class="submit_button">登录</button>
             <div class="error"><span>+</span></div>
         </form>
     </div>
     <!-- Javascript -->
	<script src="${ctx}/assets/js/jquery-1.8.2.min.js" ></script>
	<script src="${ctx}/assets/js/supersized.3.2.7.min.js" ></script>
	<script src="${ctx}/assets/js/supersized-init.js" ></script>
	<script src="${ctx}/assets/js/scripts.js" ></script>
</body>
</html>