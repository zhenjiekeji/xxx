<%@page import="com.uk.sec.privilege.framework.privilege.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<rapid:override name="head">
    <title><%=SecPrivilegeMenu.TABLE_ALIAS%> 编辑</title>
	<script type="text/javascript" src="scripts/privilege/menuManage.js"></script>
	<script type="text/javascript">
		//文档加载完毕
		window.onload=function(){
			if($("#menuIsleaf").val()==0) {
				$("#menuUrlTr").hide();
				$("#menuUrlTr input").attr("disabled","disabled");
			} else {
				$("#menuUrlTr").show();
				$("#menuUrlTr input").removeAttr("disabled");
			}
		};
	</script>
</rapid:override>
<rapid:override name="container">
	<div class="positionPanel">
		<em></em>当前位置>><%=SecPrivilegeMenu.TABLE_ALIAS%> 编辑<a href="javascript:void(0)" onclick="window.history.go(-1)" class="back"></a>
	</div>
	<div class="formPanel">
		<form id="menuForm" action="${ctx}/framework/privilege/SecPrivilegeMenu/update.do" method="post">
			<s:hidden id="menuId" name="menuId" value="%{model.menuId}"/>
			<div class="formPanelHead">
				<ul>
					<li>编辑</li>
				</ul>
			</div>
			<div class="formPanelBody">
				<table class="formTable" cellpadding="0" cellspacing="0">
					<tr>
					    <td class="rowHead"><font class="red">*</font><%=SecPrivilegeMenu.ALIAS_MENU_TITLE%>：</td>
					    <td>
					    	<input type="text" id="menuTitle" name="menuTitle" value="<s:property value='%{model.menuTitle}'/>"/>
					    </td>
				  	</tr>
					<tr>
					    <td class="rowHead">显示顺序：</td>
					    <td>
					    	<s:property value="%{model.menuVieworder}"/>
					    </td>
				  	</tr>
					<%-- <tr>
					    <td class="rowHead">是否叶子节点：</td>
					    <td>
					    	<s:set name="isLeaf" value="model.menuIsleaf"/>
					    	<select id="menuIsleaf" name="menuIsleaf" style="width: 50px">
								<option value="1" <s:if test="#isLeaf == 1">
					    			selected</s:if>
					    		>是</option>
								<option value="0" <s:if test="#isLeaf == 0">
					    			selected</s:if>
					    		>否</option>
					    	</select>
					    </td>
				  	</tr> --%>
					<tr id="menuUrlTr">
					    <td class="rowHead">
					    	<font class="red">*</font><%=SecPrivilegeMenu.ALIAS_MENU_URL%>：
					    </td>
					    <td>
							<input type="text" id="menuUrl" name="menuUrl" style="width: 320px" value="<s:property value='%{model.menuUrl}'/>"/>
					    </td>
				  	</tr>
				  	<tr>
					    <td class="rowHead"><%=SecPrivilegeMenu.ALIAS_MENU_DESCRIPTION%>：</td>
					    <td>
					    	<textarea id="menuDescription" name="menuDescription" rows="8" cols="100"><s:property value="%{model.menuDescription}"/></textarea>
					    </td>
				  	</tr>
	    		</table>
	    	</div>
	    	<div class="formPanelFoot">
	    		<table cellpadding="0" cellspacing="0">
	    			<tr>
	    				<td>
	    					<input id="submitButton" name="submitButton" type="submit" value="提交" />
	    					<input type="button" value="返回列表" onclick="window.location='${ctx}/framework/privilege/SecPrivilegeMenu/list.do'"/>
	    					<input type="button" value="后退" onclick="history.back();"/>
	    				</td>
	    			</tr>
	    		</table>
	    	</div>
		</form>
	</div>
</rapid:override>
<%@ include file="/base.jsp"  %>