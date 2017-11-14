<%@page import="com.uk.sec.privilege.framework.privilege.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<rapid:override name="head">
    <title><%=SecPrivilegeRole.TABLE_ALIAS%> 维护</title>
    <link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel="stylesheet" />
    <script type="text/javascript" src="scripts/privilege/roleManage.js"></script>
    <script type="text/javascript">
       	//文档加载完毕
		window.onload=function(){
			if($("#errorMessage").val()!=""){
			     alert($("#errorMessage").val());
			}
		};
    	//查看
    	function show(param){
    		var action = "${ctx}/framework/privilege/SecPrivilegeRole/show.do";
    		var paraJson = {
				"roleId" : param
			};
			var object=OperObject.createNewObject(action,paraJson);
			operationFunction(object);
    	}
    	//修改
    	function edit(param){
    		var action = "${ctx}/framework/privilege/SecPrivilegeRole/edit.do";
    		var paraJson = {
				"roleId" : param
			};
			var object=OperObject.createNewObject(action,paraJson);
			operationFunction(object);
    	}
    	//删除
    	function deleteRow(param){
    		if(!confirm('确定执行[删除]操作，删除角色及其所有关联用户、菜单？')){
    			return false;
    		};
    		var action = "${ctx}/framework/privilege/SecPrivilegeRole/deleteById.do";
    		var paraJson = {
				"roleId" : param
			};
			var object=OperObject.createNewObject(action,paraJson);
			operationFunction(object);
    	}
    	//关联菜单
    	function roleRelateMenusOpers(param){
    		var action = "${ctx}/framework/privilege/SecPrivilegeRole/roleRelateMenusOpers.do";
    		var paraJson = {
				"roleId" : param
			};
			var object=OperObject.createNewObject(action,paraJson);
			operationFunction(object);
    	}
    	//新增
    	function create(){
    		var action = "${ctx}/framework/privilege/SecPrivilegeRole/create.do";
			var object=OperObject.createNewObject(action);
			operationFunction(object);
    	}
    	//批量删除
    	function batchRemove(){
    		batchRoleDelete("${ctx}/framework/privilege/SecPrivilegeRole/delete.do","items",document.forms.SecPrivilegeRole_list);
    	}
    </script>
</rapid:override>
<rapid:override name="container">
	<input type="hidden" value="${errorMessage}" id="errorMessage" />
	<input type="hidden" id="contentPath" value="${ctx}"/>
	<div class="positionPanel">
		<em></em>当前位置>><%=SecPrivilegeRole.TABLE_ALIAS%> 维护
	</div>
	<s:set name="create" value="create" />
	<s:set name="batchRemove" value="batchRemove" />
	<div class="queryPanel">
		<form action="<c:url value="/framework/privilege/SecPrivilegeRole/list.do"/>" method="post">
			<div class="queryPanelHead">搜索</div>
			<div class="queryPanelBody">
	    		<table class="queryTable" cellpadding="0" cellspacing="0">
					<tr>
					  <td>
				  	  	<%=SecPrivilegeRole.ALIAS_ROLE_NAME%>：
				  	  	<input type="text" name="s_roleName" value="<s:property value='#request.pageRequest.filters.roleName'/>"/>
				  	  </td>
				  	  <td align="right">
				  	  	<input type="submit" value="查询" />
				  	  	<input type="reset" class="clearBtn" value="重置" />
					  </td>
					</tr>
	    		</table>
			</div>
		</form>
	</div>
	<div class="toolbarPanel">
		<form action="<c:url value="/framework/privilege/SecPrivilegeRole/create.do"/>" method="post">
		<table cellpadding="0" cellspacing="0">
			<tr>
				<td>
				<%-- 
					<s:iterator value="#session.user_view.userData.get('roleMenuOperList')" var="secBasOperation" status="status">
						<s:if test="#secBasOperation.itemName == #create || #secBasOperation.itemName == #batchRemove">
							<input type="button" class="<s:property value='#secBasOperation.itemName'/>Btn"
							onclick="<s:property value='#secBasOperation.itemName'/>()" value="<s:property value='#secBasOperation.itemDescription'/>"/>
						</s:if>
					</s:iterator>
				--%>
					<input type="button" class="createBtn" onclick="create()" value="添加"/>					
					<input type="button" class="batchRemoveBtn" onclick="batchRemove()" value="批量删除"/>
    			</td>
    		</tr>
    	</table>
    	</form>
	</div>
	<div class="dataGridPanel">
		<ec:table items='page.result' var="item" method="post"
	    retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	    action="${ctx}/framework/privilege/SecPrivilegeRole/list.do" autoIncludeParameters="true" tableId="SecPrivilegeRole_list" state="notifyToPersist">
	    	<ec:exportXls fileName="export.xls" tooltip="导出"/>
	    	<ec:row>
	        	<ec:column property="选择" style="text-align:center;" title="<input type='checkbox' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="30" viewsAllowed="html">
	           		<c:if test="${item.roleLevel != 1}">
		            	<input type="checkbox" name="items" value="roleId=${item.roleId}&"/>
		            </c:if>
	        	</ec:column>
		        <ec:column property="roleName"  title="<%=SecPrivilegeRole.ALIAS_ROLE_NAME%>" />
		        <ec:column property="roleDescription"  title="<%=SecPrivilegeRole.ALIAS_ROLE_DESCRIPTION%>">
					<div class="operInfo">${item.roleDescription}</div>
		        </ec:column>
	        	<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html" width="240">
	        		<%-- 
	        		<c:if test="${item.roleLevel != 1}">
						<s:iterator value="#session.user_view.userData.get('roleMenuOperList')" var="secBasOperation" status="status">
							<s:if test="#secBasOperation.itemName != #create && #secBasOperation.itemName != #batchRemove">
								<a class="btn_grid_link_<s:property value='#secBasOperation.itemName'/>" onclick="return <s:property value='#secBasOperation.itemName'/>('${item.roleId}');">
									<em></em><s:property value="#secBasOperation.itemDescription"/>
								</a>
							</s:if>
						</s:iterator>
		            </c:if>
		            --%>
						<a class="btn_grid_link_show" onclick="return show('${item.roleId}');"><em></em>查看</a>
		                <a class="btn_grid_link_edit" onclick="return edit('${item.roleId}');"><em></em>修改</a>
		                <a class="btn_grid_link_deleteRow" onclick="return deleteRow('${item.roleId}');"><em></em>删除</a>						
						<a class="btn_grid_link_roleRelateMenusOpers" onclick="return roleRelateMenusOpers('${item.roleId}');"><em></em>关联菜单</a>			            
	        	</ec:column>
	    	</ec:row>
		</ec:table>
	</div>
</rapid:override>
<%@ include file="/base.jsp"  %>