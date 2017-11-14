<%@ page pageEncoding="UTF-8" language="java" import="java.util.*"%>
<%@ include file="/commons/taglibs.jsp"%>
<link href="${ctx}/styles/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
body {margin-left: 0px;margin-top: 0px;margin-right: 0px;}
.topo {background-color:#FFF; background-image:url(images/topback.gif);background-position:top right;background-repeat: no-repeat;width:auto;height:60px;text-align:center;margin:0px auto}
#topn {float:left;width:960px;height:60px;margin:0px auto;}
#logo {float:left;background-image:url(images/logos.gif);width:227px;height:60px;float:left;margin:0px auto}
#logofont {float:left;margin:33px 0px 0px 20px;width:360px;height:18px;color:#1E5494;font-size:12px;line-height:18px;text-align:left}
#logofont a,a:link,a:visited,a:hover,a:active{font-size: 12px;text-decoration: none;color:#FF0000;}
#ss_01 {float:left;width:120px;height:22px;float:left;margin:0px 0px 0px 8px;text-align:center; font-size:12px;color:#223661;line-height:22px;font-weight:bold;padding-top:2px}
#ss_01 a,a:link,a:visited,a:hover,a:active{font-size: 12px;text-decoration: none;color:#000000;}
#ss_02 {float:left;width:120px;height:22px;float:left;margin:0px 0px 0px 8px;text-align:center; font-size:12px;color:#223661;line-height:22px;font-weight:bold;padding-top:2px}
#ss_02 a,a:link,a:visited,a:hover,a:active{font-size: 12px;text-decoration: none;color:#223661;}
.s1 {float:left;background-image:url(images/menu_03.gif);width:120px;height:22px;margin:0px 0px 0px 8px;text-align:center; font-size:12px;color:#223661;line-height:22px;font-weight:bold;padding-top:2px}
.s1 a,a:link,a:visited,a:hover,a:active{font-size: 12px;text-decoration: none;color:#000000;}
.s2 {float:left;background-image:url(images/menu_02.gif);width:120px;height:22px;margin:0px 0px 0px 8px;text-align:center; font-size:12px;color:#223661;line-height:22px;font-weight:bold;padding-top:2px}
.s2 a,a:link,a:visited,a:hover,a:active{font-size: 12px;text-decoration: none;color:#223661;}
#mtop {float:left;background-image:url(images/top_l.gif);width:168px;height:11px;font-size:0px;margin:0px auto}
#mjiao {float:left;background-image:url(images/top_jiao.gif);width:26px;height:11px;font-size:0px;margin-right:-10px;}
#mright {background-image:url(images/top_t.gif);width:auto;height:11px;margin:0px 0px 0px 10px;font-size:0px;}
-->
</style>
<link rel="stylesheet" type="text/css" href="${ctx}/bns/business/css/manhuaDate.1.0.css">
<div class="topo">
	<div class="top_nrv">
		<div class="logo">后台管理</div>
		<div class="users">
			<ul class="user_name01">
				<li class="user_class01">${sessionScope.user_view.userData.roleName}</li>
				<li class="user_nm">${sessionScope.user_view.userInfo.userName}</li>
			</ul>
			<a href="#" class="mail"><div class="mail_nb">0</div></a>
			<a href="loginOut.do" target="_parent" class="login_out">退出</a>
		</div>
	</div>
</div>