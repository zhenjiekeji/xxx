<%@page import="com.uk.sec.privilege.framework.privilege.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<rapid:override name="head">
    <title><%=SecPrivilegeUser.TABLE_ALIAS%> 新增</title>
    <!-- <link rel="stylesheet" href="${ctx}/scripts/JQueryZTreeV3.1/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="${ctx}/scripts/JQueryZTreeV3.1/js/jquery.ztree.core-3.1.js"></script>
	<script type="text/javascript" src="${ctx}/scripts/JQueryZTreeV3.1/js/jquery.ztree.excheck-3.1.js"></script>
	<script  src="${ctx}/scripts/JQueryZTreeV3.1/exSelect_config.js"></script>    
    <script type="text/javascript" src="scripts/privilege/userManage.js"></script> -->
</rapid:override>
<rapid:override name="container">
	<input type="hidden" id="contentPath" value="${ctx}"/>
	<div class="positionPanel">
		<em></em>当前位置>><%=SecPrivilegeUser.TABLE_ALIAS%> 新增<a href="javascript:void(0)" onclick="window.history.go(-1)" class="back"></a>
	</div>
	<div class="formPanel">
		<form id="addUserForm" action="${ctx}/framework/privilege/SecPrivilegeUser/save.do" method="post">
			<div class="formPanelHead">
				<ul>
					<li>新增</li>
				</ul>
			</div>
			<div class="formPanelBody">
				<table class="formTable" cellpadding="0" cellspacing="0">
	 				<tr>
					    <td class="tdLabel" width="20%">
					    	<font class="red">*</font><%=SecPrivilegeUser.ALIAS_LOGIN_NAME%>：
					    </td>
					    <td width="30%">
					    	<input type="text" id="loginName" name="loginName"/>
					    </td>
						<td class="tdLabel" width="20%">
					    	<font class="red">*</font><%=SecPrivilegeUser.ALIAS_USER_NAME%>：
					    </td>
					    <td>
					    	<input type="text" id="userName" name="userName"/>
					    </td>
				  	</tr>
				  	<tr>
					    <td class="tdLabel">
					    	<font class="red">*</font><%=SecPrivilegeUser.ALIAS_PASSWD%>：
					    </td>
					    <td>
					    	<input type="password" id="passwd" name="passwd"/>
						</td>
					    <td class="tdLabel">
					    	<%=SecPrivilegeUser.ALIAS_USER_MOBILEPHONE%>：
					    </td>
					    <td>
					    	<input type="text" id="userMobilephone" name="userMobilephone"/>
					    </td>
				  	</tr>
				 	<tr>
					    <td class="tdLabel">
					    	<font class="red">*</font>重复密码：
					    </td>
					     <td>
					    	<input type="password" id="repasswd" name="repasswd"/>
					    </td>
					    <td class="tdLabel">
					    	<%=SecPrivilegeUser.ALIAS_USER_PHONE%>：
					    </td>
					    <td>
					    	<input type="text" id="userPhone" name="userPhone"/>
					    </td>
				  	</tr>
				  	<tr>
				  		<td class="tdLabel">
					    	<%=SecPrivilegeUser.ALIAS_USER_EMAIL%>：
					    </td>
					    <td>
					    	<input type="text" id="userEmail" name="userEmail"/>
					    </td>
				  	</tr>
	   			</table>
	    	</div>
	    	<div class="formPanelFoot">
	    		<table cellpadding="0" cellspacing="0">
	    			<tr>
	    				<td>
	    					<input id="submitButton" name="submitButton" type="submit" value="提交" />
	    					<input type="button" value="返回列表" onclick="window.location='${ctx}/framework/privilege/SecPrivilegeUser/list.do'" />
	    				</td>
	    			</tr>
	    		</table>
	    	</div>
		</form>
    </div>
</rapid:override>
<%@ include file="/base.jsp"  %>