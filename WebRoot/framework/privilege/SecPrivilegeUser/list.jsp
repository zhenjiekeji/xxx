<%@page import="com.uk.sec.privilege.framework.privilege.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<rapid:override name="head">
    <title><%=SecPrivilegeUser.TABLE_ALIAS%> 维护</title>
    <link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel="stylesheet" />
    <script type="text/javascript">
    	//查看
    	function show(param){
    		var action = "${ctx}/framework/privilege/SecPrivilegeUser/show.do";
    		var paraJson = {
				"loginId" : param
			};
			var object=OperObject.createNewObject(action,paraJson);
			operationFunction(object);
    	}
    	//修改
    	function edit(param){
    		var action = "${ctx}/framework/privilege/SecPrivilegeUser/edit.do";
    		var paraJson = {
				"loginId" : param
			};
			var object=OperObject.createNewObject(action,paraJson);
			operationFunction(object);
    	}
    	//删除
    	function deleteRow(param){
    		if(!confirm('确定执行[删除]操作，删除用户及其所有关联权限？')){
    			return false;
    		};
    		var action = "${ctx}/framework/privilege/SecPrivilegeUser/deleteById.do";
    		var paraJson = {
				"loginId" : param
			};
			var object=OperObject.createNewObject(action,paraJson);
			operationFunction(object);
    	}
    	//关联角色
    	function userRelateRoles(param){
    		var action = "${ctx}/framework/privilege/SecPrivilegeUser/userRelateRoles.do";
    		var paraJson = {
				"loginId" : param
			};
			var object=OperObject.createNewObject(action,paraJson);
			operationFunction(object);
    	}
    	//新增
    	function create(){
    		var action = "${ctx}/framework/privilege/SecPrivilegeUser/create.do";
			var object=OperObject.createNewObject(action);
			operationFunction(object);
    	}
    	//批量删除
    	function batchRemove(){
    		batchUserDelete("${ctx}/framework/privilege/SecPrivilegeUser/delete.do","items",document.forms.SecPrivilegeUser_list);
    	}
     	//导入用户
    	function importUsersFromCIQ(){
    		var action = "${ctx}/framework/ukinterface/SysDeptInfo/importDepartsFromCIQ.do";
			var object=OperObject.createNewObject(action);
			operationFunction(object);
    	}
		/**
		*删除多条用户
		*/
		function batchUserDelete(action,checkboxName,form){
		    if (!hasOneChecked(checkboxName)){
		            alert('请选择要操作的对象！');
		            return;
		    }
		    if (confirm('确定执行[删除]操作，删除用户及其所有关联权限？')){
		        form.action = action;
		        form.submit();
		    }
		}        	
    </script>
</rapid:override>
<rapid:override name="container">
	<input type="hidden" id="contentPath" value="${ctx}"/>
	<div class="positionPanel">
		<em></em>当前位置>><%=SecPrivilegeUser.TABLE_ALIAS%> 维护
	</div>
	<s:set name="create" value="create" />
	<s:set name="batchRemove" value="batchRemove" />
	<s:set name="importUsersFromCIQ" value="importUsersFromCIQ" />
	<div class="queryPanel">
		<form action="<c:url value="/framework/privilege/SecPrivilegeUser/list.do"/>" method="post">
			<div class="queryPanelHead">搜索</div>
			<div class="queryPanelBody">
	    		<table class="queryTable" cellpadding="0" cellspacing="0">
	        		<tr>
	            		<td>
	                    	<%=SecPrivilegeUser.ALIAS_LOGIN_NAME%>：
	                		<input value="<s:property value='#request.pageRequest.filters.loginName'/>"  name="s_loginName"/>
						</td>
						<td>
	                    	<%=SecPrivilegeUser.ALIAS_USER_NAME%>：
	            			<input value="<s:property value='#request.pageRequest.filters.userName'/>"  name="s_userName"/>
						</td>
						<td align="right">
	            			<input type="submit" class="queryBtn" value="查询" />
		    				<input type="reset" class="clearBtn" value="重置" />
	            		</td>
	        		</tr>
	    		</table>
			</div>
		</form>
	</div>
	<div class="toolbarPanel">
		<form action="<c:url value="/framework/privilege/SecPrivilegeUser/create.do"/>" method="post">
			<table cellpadding="0" cellspacing="0">
				<tr>
					<td>
					<%-- 
						<s:iterator value="#session.user_view.userData.get('roleMenuOperList')" var="secBasOperation" status="status">
							<s:if test="#secBasOperation.itemName == #create || #secBasOperation.itemName == #batchRemove || #secBasOperation.itemName == #importUsersFromCIQ">
								<input type="button" class="<s:property value='#secBasOperation.itemName'/>Btn"
								onclick="<s:property value='#secBasOperation.itemName'/>()" value="<s:property value='#secBasOperation.itemDescription'/>"/>
							</s:if>
						</s:iterator>
					--%>
						<input type="button" class="createBtn" onclick="create()" value="添加"/>					
						<input type="button" class="batchRemoveBtn" onclick="batchRemove()" value="批量删除"/>
						<input type="button" class="importUsersFromCIQBtn" onclick="importUsersFromCIQ()" value="导入用户"/>		
	    			</td>
	    		</tr>
	    	</table>
    	</form>
	</div>
	<div class="dataGridPanel">
		<ec:table items='page.result' var="item" method="post"
	    retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	    action="${ctx}/framework/privilege/SecPrivilegeUser/list.do" autoIncludeParameters="true" tableId="SecPrivilegeUser_list" state="notifyToPersist">
	    	<ec:exportXls fileName="export.xls" tooltip="导出"/>
	    	<ec:row>
	        	<ec:column width="25" property="选择" title="<input type='checkbox' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" viewsAllowed="html" style="text-align:center;">
	            	<c:if test="${item.loginName != 'admin'}">
		            	<input type="checkbox" name="items" value="loginId=${item.loginId}&"/>
		            </c:if>
	        	</ec:column>
		        <ec:column property="loginName"  title="<%=SecPrivilegeUser.ALIAS_LOGIN_NAME%>"/>
		        <ec:column property="userName"  title="<%=SecPrivilegeUser.ALIAS_USER_NAME%>"/>
		        <ec:column property="userEmail"  title="<%=SecPrivilegeUser.ALIAS_USER_EMAIL%>"/>
		        <ec:column property="userPhone"  title="<%=SecPrivilegeUser.ALIAS_USER_PHONE%>"/>
		        <ec:column property="userMobilephone"  title="<%=SecPrivilegeUser.ALIAS_USER_MOBILEPHONE%>"/>
				<ec:column property="createTime" value="${item.createTimeString}" title="<%=SecPrivilegeUser.ALIAS_CREATE_TIME%>"/>
	        	<ec:column width="240" property="操作" title="操作" sortable="false" viewsAllowed="html">
					<c:if test="${item.loginName != 'admin'}">
					<%-- 
						<s:iterator value="#session.user_view.userData.get('roleMenuOperList')" var="secBasOperation" status="status">
							<s:if test="#secBasOperation.itemName != #create && #secBasOperation.itemName != #batchRemove && #secBasOperation.itemName != #importUsersFromCIQ">
								<a class="btn_grid_link_<s:property value='#secBasOperation.itemName'/>" onclick="return <s:property value='#secBasOperation.itemName'/>('${item.loginId}');">
									<em></em><s:property value="#secBasOperation.itemDescription"/>
								</a>
							</s:if>
						</s:iterator>
					--%>
						<a class="btn_grid_link_show" onclick="return show('${item.loginId}');"><em></em>查看</a>
		                <a class="btn_grid_link_edit" onclick="return edit('${item.loginId}');"><em></em>修改</a>
		                <a class="btn_grid_link_deleteRow" onclick="return deleteRow('${item.loginId}');"><em></em>删除</a>						
						<a class="btn_grid_link_userRelateRoles" onclick="return userRelateRoles('${item.loginId}');"><em></em>关联角色</a>	
					</c:if>
	        	</ec:column>
	    	</ec:row>
		</ec:table>
	</div>
</rapid:override>
<%@ include file="/base.jsp"  %>