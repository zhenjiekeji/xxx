<%@page import="com.uk.sec.privilege.framework.privilege.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<rapid:override name="head">
    <title><%=SecPrivilegeUser.TABLE_ALIAS%> 信息</title>
</rapid:override>
<rapid:override name="container">
	<div class="positionPanel">
		<em></em>当前位置>><%=SecPrivilegeUser.TABLE_ALIAS%> 信息<a href="javascript:void(0)" onclick="window.history.go(-1)" class="back"></a>
	</div>
	<div class="formPanel">
		<form action="${ctx}/framework/privilege/SecPrivilegeUser/list.do" method="post" theme="simple">
			<s:hidden name="loginId" id="loginId" value="%{model.loginId}"/>
			<div class="formPanelHead">
				<ul>
					<li>信息</li>
				</ul>
			</div>
			<div class="formPanelBody">
				<table class="formTable" cellpadding="0" cellspacing="0">
					  <tr>
					    <td class="tdLabel" width="20%">
					    	<%=SecPrivilegeUser.ALIAS_LOGIN_NAME%>：
					    </td>
					    <td width="30%">
					    	<s:property value="%{model.loginName}"/>
					    </td>
					    <td class="tdLabel" width="20%">
					    	<%=SecPrivilegeUser.ALIAS_USER_NAME%>：
					    </td>
					    <td>
					     	<s:property value="%{model.userName}"/>
						</td>
					  </tr>
					  <tr>
						<td class="tdLabel">
					    	<%=SecPrivilegeUser.ALIAS_USER_EMAIL%>：
					    </td>
					    <td>
					    	<s:property value="%{model.userEmail}"/>
					    </td>
					    <td class="tdLabel">
					    	<%=SecPrivilegeUser.ALIAS_USER_MOBILEPHONE%>：
					    </td>
					    <td>
					    	<s:property value="%{model.userMobilephone}"/>
					    </td>
					  </tr>
					  <tr>
					   	<td class="tdLabel">
					    	<%=SecPrivilegeUser.ALIAS_CREATE_TIME%>：
					    </td>
					    <td>
					    	<s:property value="%{model.createTimeString}"/>
					    </td>
					    <td class="tdLabel">
					    	<%=SecPrivilegeUser.ALIAS_USER_PHONE%>：
					    </td>
					    <td>
					    	<s:property value="%{model.userPhone}"/>
					    </td>
					  </tr>
	    		</table>
	    	</div>
	    	<div class="formPanelFoot">
	    		<table cellpadding="0" cellspacing="0">
	    			<tr>
	    				<td>
	    					<input type="button" value="返回列表" onclick="window.location='${ctx}/framework/privilege/SecPrivilegeUser/list.do'"/>
	    				</td>
	    			</tr>
	    		</table>
	    	</div>
		</form>
	</div>
</rapid:override>
<%@ include file="/base.jsp"  %>