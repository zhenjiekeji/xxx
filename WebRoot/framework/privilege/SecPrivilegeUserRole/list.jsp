<%@page import="com.uk.sec.privilege.framework.privilege.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<rapid:override name="head">
    <title><%=SecPrivilegeUserRole.TABLE_ALIAS%> 维护</title>
    <link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel="stylesheet" />
</rapid:override>
<rapid:override name="container">
	<div class="positionPanel">
		<em></em>当前位置>><%=SecPrivilegeUserRole.TABLE_ALIAS%> 维护
	</div>
	<div class="queryPanel">
		<form action="<c:url value="/framework/privilege/SecPrivilegeUserRole/list.do"/>" method="post">
		<div class="queryPanelHead">搜索</div>
		<div class="queryPanelBody">
    		<table class="queryTable" cellpadding="0" cellspacing="0">
        		<tr>
            		<td class="tdLabel">
                    	<%=SecPrivilegeUserRole.ALIAS_LOGIN_ID%>
            		</td>
            		<td>
                		<input value="${pageRequest.filters.loginId}"  name="s_loginId"  />
            		</td>
            		<td class="tdLabel">
                    	<%=SecPrivilegeUserRole.ALIAS_ROLE_ID%>
            		</td>
            		<td>
                		<input value="${pageRequest.filters.roleId}"  name="s_roleId"  />
            		</td>
        		</tr>
    		</table>
		</div>
		<div class="queryPanelFoot">
		<table cellpadding="0" cellspacing="0">
			<tr>
				<td>
    				<input type="submit" class="queryBtn" value="查询" />
    				<input type="reset" class="clearBtn" value="重置" />
    			</td>
    		</tr>
    	</table>
		</div>
		</form>
	</div>
	<div class="toolbarPanel">
		<form action="<c:url value="/framework/privilege/SecPrivilegeUserRole/create.do"/>" method="post">
		<table cellpadding="0" cellspacing="0">
			<tr>
				<td>
    				<input type="submit" class="createBtn" value="新增" />
    				<input type="button" class="deleteBtn" value="删除" onclick="batchDelete('${ctx}/framework/privilege/SecPrivilegeUserRole/delete.do','items',document.forms.SecPrivilegeUserRole_list)" />
    			</td>
    		</tr>
    	</table>
    	</form>
	</div>
	<div class="dataGridPanel">
	<ec:table items='page.result' var="item" method="post"
    retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
    action="${ctx}/framework/privilege/SecPrivilegeUserRole/list.do" autoIncludeParameters="true" tableId="SecPrivilegeUserRole_list" state="notifyToPersist">
    	<ec:exportXls fileName="export.xls" tooltip="导出"/>
    	<ec:row>
        	<ec:column property="选择" title="<input type='checkbox' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="3%" viewsAllowed="html">
            	<input type="checkbox" name="items" value="userRoleId=${item.userRoleId}&"/>
        	</ec:column>
        	<ec:column alias="secPrivilegeUserRole_loginId" property="loginId"  title="<%=SecPrivilegeUserRole.ALIAS_LOGIN_ID%>"/>
        	<ec:column alias="secPrivilegeUserRole_roleId" property="roleId"  title="<%=SecPrivilegeUserRole.ALIAS_ROLE_ID%>"/>
        	<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
            	<a href="${ctx}/framework/privilege/SecPrivilegeUserRole/show.do?userRoleId=${item.userRoleId}&" class="btn_grid_link_show"><em></em>查看</a>&nbsp;&nbsp;&nbsp;
            	<a href="${ctx}/framework/privilege/SecPrivilegeUserRole/edit.do?userRoleId=${item.userRoleId}&" class="btn_grid_link_edit"><em></em>修改</a>&nbsp;&nbsp;&nbsp;
            	<a href="${ctx}/framework/privilege/SecPrivilegeUserRole/deleteById.do?userRoleId=${item.userRoleId}&" class="btn_grid_link_delete" onclick="return deleteConfirm();"><em></em>删除</a>
        	</ec:column>
    	</ec:row>
	</ec:table>
	</div>

</rapid:override>


<%@ include file="/base.jsp"  %>