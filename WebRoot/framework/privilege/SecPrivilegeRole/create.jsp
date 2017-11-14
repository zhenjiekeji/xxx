<%@page import="com.uk.sec.privilege.framework.privilege.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<rapid:override name="head">
    <title><%=SecPrivilegeRole.TABLE_ALIAS%> 新增</title>
    <script type="text/javascript" src="scripts/privilege/roleManage.js"></script>
</rapid:override>
<rapid:override name="container">
	<input type="hidden" id="contentPath" value="${ctx}"/>
	<div class="positionPanel">
		<em></em>当前位置>><%=SecPrivilegeRole.TABLE_ALIAS%> 新增<a href="javascript:void(0)" onclick="window.history.go(-1)" class="back"></a>
	</div>
	<div class="formPanel">
		<form id="roleForm" action="${ctx}/framework/privilege/SecPrivilegeRole/save.do" method="post">
			<div class="formPanelHead">
				<ul>
					<li>新增</li>
				</ul>
			</div>
			<div class="formPanelBody">
				<table class="formTable" cellpadding="0" cellspacing="0">
			  		<tr>
					    <td class="tdLabel">
					    	<font class="red">*</font><%=SecPrivilegeRole.ALIAS_ROLE_NAME%>：
					    </td>
					    <td>
					    	<input type="text" id="roleName" name="roleName"/>
					    </td>
			  		</tr>
					<tr>
					    <td class="tdLabel">
					    	<%=SecPrivilegeRole.ALIAS_ROLE_DESCRIPTION%>：
					    </td>
					    <td>
					    	<textarea id="roleDescription" name="roleDescription" rows="8" cols="100" ></textarea>
					    </td>
					</tr>
	   			</table>
	    	</div>
	    	<div class="formPanelFoot">
	    		<table cellpadding="0" cellspacing="0">
	    			<tr>
	    				<td>
	    					<input id="submitButton" name="submitButton" type="submit" value="提交" />
	    					<input type="button" value="返回列表" onclick="window.location='${ctx}/framework/privilege/SecPrivilegeRole/list.do'" />
	    					<input type="button" value="后退" onclick="history.back();" />
	    				</td>
	    			</tr>
	    		</table>
	    	</div>
		</form>
    </div>
</rapid:override>
<%@ include file="/base.jsp"  %>