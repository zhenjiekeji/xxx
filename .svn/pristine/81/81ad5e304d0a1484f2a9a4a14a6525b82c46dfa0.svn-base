<%@page import="com.uk.sec.privilege.framework.privilege.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<rapid:override name="head">
    <title><%=SecPrivilegeRole.TABLE_ALIAS%> 信息</title>
</rapid:override>
<rapid:override name="container">
	<div class="positionPanel">
		<em></em>当前位置>><%=SecPrivilegeRole.TABLE_ALIAS%> 信息<a href="javascript:void(0)" onclick="window.history.go(-1)" class="back"></a>
	</div>
	<div class="formPanel">
		<form action="${ctx}/framework/privilege/SecPrivilegeRole/list.do" method="post" theme="simple">
			<s:hidden name="roleId" id="roleId" value="%{model.roleId}"/>
			<div class="formPanelHead">
				<ul>
					<li>信息</li>
				</ul>
			</div>
			<div class="formPanelBody">
				<table class="formTable" cellpadding="0" cellspacing="0">
					  <tr>
					    <td class="tdLabel"><%=SecPrivilegeRole.ALIAS_ROLE_NAME%>：</td>
					    <td>
					    	<s:property value="%{model.roleName}"/>
					    </td>
					  </tr>
					  <tr>
					    <td class="tdLabel"><%=SecPrivilegeRole.ALIAS_ROLE_DESCRIPTION%>：</td>
					    <td>
					    	<textarea id="roleDescription" readonly="readonly" name="roleDescription" rows="8" cols="100"><s:property value="%{model.roleDescription}"/></textarea>
					    </td>
					  </tr>
	    		</table>
	    	</div>
	    	<div class="formPanelFoot">
	    		<table cellpadding="0" cellspacing="0">
	    			<tr>
	    				<td>
	    					<input type="button" value="返回列表" onclick="window.location='${ctx}/framework/privilege/SecPrivilegeRole/list.do'"/>
	    					<input type="button" value="后退" onclick="history.back();"/>
	    				</td>
	    			</tr>
	    		</table>
	    	</div>
		</form>
	</div>
</rapid:override>
<%@ include file="/base.jsp"  %>