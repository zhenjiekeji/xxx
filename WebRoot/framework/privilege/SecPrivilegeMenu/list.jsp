<%@page import="com.uk.sec.privilege.framework.privilege.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<rapid:override name="head">
    <title><%=SecPrivilegeMenu.TABLE_ALIAS%> 维护</title>
    <link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" href="scripts/JQueryZTreeV3.1/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="scripts/JQueryZTreeV3.1/js/jquery.ztree.core-3.1.js"></script>
	<script type="text/javascript" src="scripts/JQueryZTreeV3.1/js/jquery.ztree.excheck-3.1.js"></script>
	<script type="text/javascript" src="scripts/JQueryZTreeV3.1/js/jquery.ztree.exedit-3.1.js"></script>
    <script type="text/javascript" src="scripts/privilege/menuManage.js"></script>
    <script type="text/javascript">
		jQuery(function($){
			var zTreeMenu,setting;
			var setting = {
				view: {
					selectedMulti: false
				},
	            edit: {
	                enable: true,
	                showRemoveBtn: false,
	                showRenameBtn: false,
	                drag:{
	                    isCopy:false,
	                    isMove:true
	                }
	            },
	            data: {
	                simpleData: {
	                    enable: true
	                },
	                keep: {
	                    leaf:true,
	                    parent: true
	                }
	            },
				callback: {
                	beforeDrop:beforeDrop,	//父子节点均不能拖拽到最外面
                	onDrop: zTreeOnDrop,
					onClick: zTreeOnClick
				}
			};
			$.ajax({
		        type:"post",
		        url: $("#contentPath").val()+"/framework/privilegeJson/zTreeMenuOrder.do",
		        dataType:"json",
		        async: false,
		        cache:false,
		        success: function (data) {
					zTreeMenu=data;
				},
		        error: function () {
		        	alert("Ajax请求数据失败!");
		        }
			});
			$.fn.zTree.init($("#menuTree"), setting, zTreeMenu);
		});
    </script>
    <style>
		.contentList{
			width:100%;
		}
		.contentList .treeList{
			width:20%;
			height:500px;
			float:left;
			border:1px solid #a4bed4;
			overflow:auto;
		}
		.contentList .treeDetail{
			width:79%;
			float:right;
		}
    </style>
</rapid:override>
<rapid:override name="container">
	<input type="hidden" id="contentPath" value="${ctx}"/>
	<div class="positionPanel">
		<em></em>
		<input type="button" id="submitZtreeButton" value="提交菜单"/>&nbsp;&nbsp;
		<input type="button" id="addLowerLevelButton" value="添加下级"/>&nbsp;&nbsp;
		<input type="button" id="editMenuButton" value="修改菜单"/>&nbsp;&nbsp;
		<input type="button" id="deleteMenuButton" value="删除菜单"/>&nbsp;&nbsp;
		<%-- 
		<input type="button" id="relateOperationButton" value="关联操作"/>&nbsp;&nbsp;
		--%>
	</div>
	<div class="contentList">
		<div class="treeList">
			<ul id="menuTree" class="ztree"></ul>
		</div>
		<div class="formPanel treeDetail">
			<div class="formPanelHead">
				<ul>
					<li>信息</li>
				</ul>
			</div>
			<div class="formPanelBody">
				<table class="formTable" cellpadding="0" cellspacing="0">
					  <tr>
					    <td class="rowHead"><%=SecPrivilegeMenu.ALIAS_MENU_TITLE%>：</td>
					    <td></td>
					  </tr>
					  <tr>
					    <td class="rowHead">显示顺序：</td>
					    <td></td>
					  </tr>
					  <tr>
					    <td class="rowHead"><%=SecPrivilegeMenu.ALIAS_MENU_URL%>：</td>
					    <td></td>
					  </tr>
					  <tr>
					    <td class="rowHead"><%=SecPrivilegeMenu.ALIAS_MENU_DESCRIPTION%>：</td>
					    <td>
					    	<textarea id="menuDescription" readonly="readonly" name="menuDescription" rows="8" cols="80"></textarea>
					    </td>
					  </tr>
	    		</table>
	    	</div>
		</div>
	</div>
</rapid:override>
<%@ include file="/base.jsp"%>