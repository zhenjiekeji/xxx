<%@ page pageEncoding="UTF-8" language="java" import="java.util.*"%>

<div class="top">
	<div class="top_nrv">
		<div class="logo">营改增管理系统</div>
		<div class="users">
			<ul class="user_name01">
				<li class="user_class02">${sessionScope.user_view.userData.deptName}</li>
				<li class="user_nm">${sessionScope.user_view.userInfo.userName}</li>
			</ul>
			<a href="UkClientFlowInfo/list.do" class="mail"><div class="mail_nb">0</div></a>
			<a href="${ctx }/loginOut.do" target="_parent" class="login_out">退出</a>
		</div>
	</div>
</div>