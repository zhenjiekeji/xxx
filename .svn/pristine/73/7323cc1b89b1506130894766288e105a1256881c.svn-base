<%@ page pageEncoding="UTF-8" language="java" import="java.util.*"%>
<%@ include file="/commons/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@ include file="/commons/meta.jsp" %>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
    <style>body{overflow:hidden;}</style>
</head>

<body>
	<div class="headPanel">
		<div class="logo">
			<div class="logoImg"></div>
		</div>
	    <div class="navigation">
            <c:forEach items="${sessionScope.user_view.userData.topDisplayMenu}" var="menu" varStatus="s">
 					<a href="menuTree.jsp?channel=${menu.menuVieworder}" target="leftFrame">
 						<img src="images/icons/${menu.menuDescription}.png" />${menu.menuTitle}
 					</a>
		    </c:forEach>
            <a href="loginOut.do" target="_parent"><img src="images/icons/button_blue_ffw.png" />退出</a>
	    </div>
	    <div class="userBar">欢迎&nbsp;&nbsp;${sessionScope.user_view.userData.deptName}&nbsp;&nbsp;${sessionScope.user_view.userInfo.userName}
	    </div>
	</div>
</body>
</html>
