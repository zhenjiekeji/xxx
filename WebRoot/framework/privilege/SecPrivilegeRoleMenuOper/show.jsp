<%@page import="com.uk.sec.privilege.framework.privilege.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<rapid:override name="head">
    <title><%=SecPrivilegeRoleMenuOper.TABLE_ALIAS%>信息</title>
</rapid:override>
<rapid:override name="container">
	<div class="positionPanel">
		<em></em>当前位置>><%=SecPrivilegeRoleMenuOper.TABLE_ALIAS%>信息<a href="javascript:void(0)" onclick="window.history.go(-1)" class="back"></a>
	</div>
	<div class="formPanel">
		<form action="${ctx}/framework/privilege/SecPrivilegeRoleMenuOper/list.do" method="post" theme="simple">
		<div class="formPanelHead">
			<ul>
				<li>信息</li>
			</ul>
		</div>
		<div class="formPanelBody">
			<table class="formTable" cellpadding="0" cellspacing="0">
        		<tr>
            		<td class="tdLabel"><%=SecPrivilegeRoleMenuOper.ALIAS_ROLE_ID%>：</td>
            		<td><s:property value="%{model.roleId}" /></td>
        		</tr>
        		<tr>
            		<td class="tdLabel"><%=SecPrivilegeRoleMenuOper.ALIAS_MENU_ID%>：</td>
            		<td><s:property value="%{model.menuId}" /></td>
        		</tr>
        		<tr>
            		<td class="tdLabel"><%=SecPrivilegeRoleMenuOper.ALIAS_OPERATION_ID%>：</td>
            		<td><s:property value="%{model.operationId}" /></td>
        		</tr>
    		</table>
    	</div>
    	<div class="formPanelFoot">
    		<table cellpadding="0" cellspacing="0">
    			<tr>
    				<td>
    					<input type="button" value="返回列表" onclick="window.location='${ctx}/framework/privilege/SecPrivilegeRoleMenuOper/list.do'"/>
    					<input type="button" value="后退" onclick="history.back();"/>
    				</td>
    			</tr>
    		</table>
    	</div>
   			<s:hidden name="rmoId" id="rmoId" value="%{model.rmoId}"/>
		</form>
	</div>
</rapid:override>
<%@ include file="/base.jsp"  %>