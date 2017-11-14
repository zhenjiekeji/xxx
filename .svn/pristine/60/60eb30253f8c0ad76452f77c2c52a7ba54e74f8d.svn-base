<%@page import="com.uk.sec.privilege.framework.privilege.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<rapid:override name="head">
    <title><%=SecPrivilegeUser.TABLE_ALIAS%> 信息</title>
    <link rel="stylesheet" href="${ctx}/scripts/JQueryZTreeV3.1/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="${ctx}/scripts/JQueryZTreeV3.1/js/jquery.ztree.core-3.1.js"></script>
	<script type="text/javascript" src="${ctx}/scripts/JQueryZTreeV3.1/js/jquery.ztree.excheck-3.1.js"></script>
	<script  src="${ctx}/scripts/JQueryZTreeV3.1/exSelect_config.js"></script>    
    <script type="text/javascript" src="${ctx}/scripts/privilege/userManage.js"></script>
</rapid:override>
<rapid:override name="container">
	<input type="hidden" id="contentPath" value="${ctx}"/>
	<div class="positionPanel">
		<em></em>>>系统管理>>用户管理<a href="javascript:void(0)" onclick="window.history.go(-1)" class="back"></a>
	</div>
	<div class="formPanel">
		<form id="relateRolesForm" action="${ctx}/framework/privilege/SecPrivilegeUser/saveUserRelateRoles.do" method="post">
			<s:hidden id="loginId" name="loginId" value="%{model.loginId}"/>
			<div class="formPanelHead">
				<ul>
					<li>关联角色</li>
				</ul>
			</div>
			<div class="formPanelBody">
				<table id="relateAuthsTable" class="formTable">
						<tr>
							<td class="tdLabel" width="40%"><%=SecPrivilegeUser.ALIAS_USER_NAME%>：</td><td><s:property value="%{model.userName}"/></td>
						</tr>
						<%--<tr>
						 <td class="tdLabel">
					    	<font class="red">*</font>
					    </td>
					    <td>
							<input type="hidden" id="groupId" name="groupId"/> 
							<input id="userDeptTree" class="exSelect" readonly='readonly'/>&nbsp;<span class="red" id="secGroupShow"></span>
							<div class="menuContent">
								<ul id="zTreeDeptOrder" class="ztree"></ul>
							</div>
					    </td>
						</tr> --%>
						<tr>
							<td class="tdLabel" width="20%">用户角色：</td>
							<td>
								<s:iterator value="selectAllRoleList" id="secPrivilegeRole" status="status">
								<label>
								<input class="roleOption" type="radio" name="roleId" value="<s:property value='#secPrivilegeRole.roleId'/>"
									<s:iterator value="selectUserRoleList" id="selectUserRole" status="status">	<%--迭代用户关联的角色,如果该用户关联了相应的角色,则该角色被选中 --%>
			                        	<s:if test="#secPrivilegeRole.roleId==#selectUserRole.roleId">
										  checked="checked"
										</s:if>
									</s:iterator>
								/><s:property value="#secPrivilegeRole.roleName"/>
								</label>
								</s:iterator>
							</td>
						</tr>
	    		</table>
	    	</div>
	    	<div class="formPanelFoot">
		  		<input id="selectAllButton" type="button" value="全选"/>
		  		<input id="submitButton" type="submit" value="提交"/>
		  		<input type="button" value="返回列表" onclick="window.location='${ctx}/framework/privilege/SecPrivilegeUser/list.do'"/>
	    	</div>
		</form>
	</div>
</rapid:override>
<%@ include file="/base.jsp"  %>