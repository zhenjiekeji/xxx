<%@page import="com.uk.sec.privilege.framework.privilege.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<rapid:override name="head">
    <title><%=SecPrivilegeMenu.TABLE_ALIAS%> 新增</title>
    <script type="text/javascript" src="scripts/privilege/menuManage.js"></script>
</rapid:override>
<rapid:override name="container">
	<div class="positionPanel">
		<em></em>当前位置>><%=SecPrivilegeMenu.TABLE_ALIAS%> 新增<a href="javascript:void(0)" onclick="window.history.go(-1)" class="back"></a>
	</div>
	<div class="formPanel">
		<form id="menuForm" action="${ctx}/framework/privilege/SecPrivilegeMenu/save.do" method="post">
			<s:hidden id="parentId" name="parentId" value="%{model.parentId}"/>
			<s:hidden id="menuVieworder" name="menuVieworder" value="%{model.menuVieworder}"/>
			<s:hidden id="menuFlag" name="menuFlag" value="%{model.menuFlag}"/>
			<div class="formPanelHead">
				<ul>
					<li>新增</li>
				</ul>
			</div>
			<div class="formPanelBody">
				<table class="formTable" cellpadding="0" cellspacing="0">
			  		<tr>
					    <td class="rowHead">
					    	<font class="red">*</font><%=SecPrivilegeMenu.ALIAS_MENU_TITLE%>：
					    </td>
					    <td>
					    	<input type="text" id="menuTitle" name="menuTitle"/>
					    </td>
			  		</tr>
					<tr>
					    <td class="rowHead">显示顺序：</td>
					    <td>
					    	<s:property value="%{model.menuVieworder}"/>
					    </td>
				  	</tr>
					<!-- <tr>
					    <td class="rowHead">是否叶子节点：</td>
					    <td>
					    	<select id="menuIsleaf" name="menuIsleaf" style="width: 50px">
								<option value="1" selected="selected">是</option>
								<option value="0">否</option>
					    	</select>
					    </td>
				  	</tr> -->
					<tr id="menuUrlTr">
					    <td class="rowHead">
					    	<font class="red">*</font><%=SecPrivilegeMenu.ALIAS_MENU_URL%>：
					    </td>
					    <td>
							<input type="text" id="menuUrl" name="menuUrl" style="width: 320px"/>
					    </td>
				  	</tr>
				  	<tr>
					    <td class="rowHead"><%=SecPrivilegeMenu.ALIAS_MENU_DESCRIPTION%>：</td>
					    <td>
					    	<textarea id="menuDescription" name="menuDescription" rows="8" cols="100"></textarea>
					    </td>
				  	</tr>
	   			</table>
	    	</div>
	    	<div class="formPanelFoot">
	    		<table cellpadding="0" cellspacing="0">
	    			<tr>
	    				<td>
	    					<input id="submitButton" name="submitButton" type="submit" value="提交" />
	    					<input type="button" value="返回列表" onclick="window.location='${ctx}/framework/privilege/SecPrivilegeMenu/list.do'" />
	    					<input type="button" value="后退" onclick="history.back();" />
	    				</td>
	    			</tr>
	    		</table>
	    	</div>
		</form>
    </div>
</rapid:override>
<%@ include file="/base.jsp"  %>