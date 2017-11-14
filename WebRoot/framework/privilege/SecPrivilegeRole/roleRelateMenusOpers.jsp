<%@page import="com.uk.sec.privilege.framework.privilege.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<rapid:override name="head">
    <title><%=SecPrivilegeRole.TABLE_ALIAS%> 信息</title>
    <link rel="stylesheet" href="${ctx}/scripts/JQueryZTreeV3.1/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="${ctx}/scripts/JQueryZTreeV3.1/js/jquery.ztree.core-3.1.js"></script>
	<script type="text/javascript" src="${ctx}/scripts/JQueryZTreeV3.1/js/jquery.ztree.excheck-3.1.js"></script>
	<script  src="${ctx}/scripts/JQueryZTreeV3.1/exSelect_config.js"></script>    
    <script type="text/javascript">
		window.onload=function(){
			//菜单树样式设置
			var settingMenu = {
	   			check : {
					enable : true,
					chkboxType : {
						"Y" : "ps",
                        "N" : "s"
					}
				},
				view : {
					dblClickExpand : false,
					showLine : false
				},
				data : {
					simpleData : {
						enable : true
					}
				}
			};		
			//ajax获取菜单树
			function getMenuTreeAjax() {
				var zTreeMenuObj;
				var zNodesMenu;
				$.ajax({
					type : "post",
					url : "${ctx}/framework/privilege/SecPrivilegeRole/zTreeMenuOrder.do",
					dataType : "json",
					data : {
						roleId : $("#roleId").val()
					},
					async : false,
					cache : false,
					success : function(data) {
						zNodesMenu = data;
					},
					error : function() {
						alert("Ajax请求数据失败!");
					}
				});
				zTreeMenuObj = $.fn.zTree.init($("#zTreeMenuOrder"), settingMenu,zNodesMenu);
			}
		    //展开菜单树当前选中节点及其所有上级节点
			function expandNodesMenu() {
				var zTreeMenuObj = $.fn.zTree.getZTreeObj("zTreeMenuOrder");
				var selectNodesArray = zTreeMenuObj.getCheckedNodes(true);
				var selectNodesLength = selectNodesArray.length;
				for ( var i = 0; i < selectNodesLength; i++) {
					var selectNode = selectNodesArray[i];
					zTreeMenuObj.expandNode(selectNode, true, true, true);
					zTreeMenuObj.selectNode(selectNode);
				}
			}
			//ztree初始化
			getMenuTreeAjax(); 
			//ztree展开当前选中节点及其所有上级节点
			expandNodesMenu();	
		};
		//当前角色所关联菜单的id赋值
		function setRoleRelateMenuId(){
			var zTreeMenuObj = $.fn.zTree.getZTreeObj("zTreeMenuOrder");
			var selectNodesArray = zTreeMenuObj.getCheckedNodes(true);
			var selectNodesLength = selectNodesArray.length;
			var selectedItems = ""; //参数值的指定格式为id@@@id@@@id,后台处理时应按照此格式解析
			for ( var i = 0; i < selectNodesLength; i++) {
				selectedItems += selectNodesArray[i].id;
				if (i != selectNodesLength - 1) {
					selectedItems += "@@@";
				}
			}
			$("#menuIdOperation").val(selectedItems);
			return true;
		}    	
    </script>
</rapid:override>
<rapid:override name="container">
	<input type="hidden" id="contentPath" value="${ctx}"/>
	<div class="positionPanel">
		<em></em>>>系统管理>>角色管理<a href="javascript:void(0)" onclick="window.history.go(-1)" class="back"></a>
	</div>
	<div class="formPanel">
		<form id="relateMenusForm" action="${ctx}/framework/privilege/SecPrivilegeRole/assignRoleMenuOperation.do" method="post">
			<s:hidden id="roleId" name="roleId" value="%{model.roleId}"/>
			<div class="formPanelHead">
				<ul>
					<li>关联菜单</li>
				</ul>
			</div>
			<div class="formPanelBody">
				<table class="formTable" cellpadding="0" cellspacing="0">
					<tr>
						<td class="tdLabel" width="20%"><%=SecPrivilegeRole.ALIAS_ROLE_NAME%>：</td>
						<td><s:property value="%{model.roleName}"/></td>
					</tr>
					<tr>
						<td class="tdLabel">关联菜单：</td>
						<td>
							<input type="hidden" id="menuIdOperation" name="menuIdOperation"/> 
							<ul id="zTreeMenuOrder" class="ztree"></ul>
						</td>					
				</table>				
	    	</div>
	    	<div class="formPanelFoot">
		  		<input id="relateMenusSubmitButton" type="submit" value="提交" onclick="return setRoleRelateMenuId(); "/>
		  		<input id="returnRoleList" type="button" value="返回列表" onclick="window.location='${ctx}/framework/privilege/SecPrivilegeRole/list.do'"/>
	    	</div>
		</form>
	</div>
</rapid:override>
<%@ include file="/base.jsp"  %>
