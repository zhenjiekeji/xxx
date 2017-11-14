<%@page import="com.uk.sec.privilege.framework.privilege.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<rapid:override name="head">
    <title>字典项维护</title>
    <script type="text/javascript">
    jQuery(function($){
		var groudId = "<s:property value='#request.pageRequest.filters.groupId'/>";
		if(groudId=="" || groudId == null || groudId=="''"){
			$("#createBtn").attr('disabled','disabled');
		}
	});
    </script>
    <script type="text/javascript" src="scripts/privilege/dicItemManage.js"></script>
    <link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel="stylesheet" />
</rapid:override>
<rapid:override name="container">
	<div class="positionPanel">
		<em></em>当前位置>>字典项维护
	</div>
	<div class="queryPanel">
		<form action="${ctx}/framework/privilege/SecBasDicItem/list.do?groupId=${DicGroupId}" method="post">
		<div class="queryPanelHead">搜索</div>
		<div class="queryPanelBody">

    		<table class="queryTable" cellpadding="0" cellspacing="0">
        		<tr>
            		<td>
                    	字典项名称
            		</td>
            		<td>
                		<input type="text" value="<s:property value='#request.pageRequest.filters.itemName'/>" id="itemName" name="s_itemName"  />
            		</td>
				<td>
    				<input type="submit" class="queryBtn" value="查询" />
    				<input type="button" onclick="clearInput();" class="clearBtn" value="重置" />
    			</td>
        		</tr>
    		</table>
		</div>

		</form>
	</div>
	<div class="toolbarPanel">
	<input type="hidden" id="maxOrder" name="maxOrder" value="${maxItemOrder}">
	<input type="hidden" id="minOrder" name="minOrder" value="${minItemOrder}">
		<form action="<c:url value="/framework/privilege/SecBasDicItem/create.do"/>" method="post">
		<table cellpadding="0" cellspacing="0">
			<tr>
				<td>
				    <input type="hidden" id="groupId" name="groupId" value="${DicGroupId}" />
    				<input id="createBtn" type="submit" class="createBtn" value="新增" />
    				<input type="button" class="deleteBtn" value="删除" onclick="batchDelete('${ctx}/framework/privilege/SecBasDicItem/delete.do','items',document.forms.SecBasDicItem_list)" />
    			</td>
    		</tr>
    	</table>
    	</form>
	</div>
	<div class="dataGridPanel">
	<ec:table items='page.result' var="item" method="post"
    retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
    action="${ctx}/framework/privilege/SecBasDicItem/list.do" autoIncludeParameters="true" tableId="SecBasDicItem_list" state="notifyToPersist">
    	<ec:exportXls fileName="export.xls" tooltip="导出"/>
    	<ec:row>
        	<ec:column property="选择" title="<input type='checkbox' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="3%" viewsAllowed="html">
            	<input type="checkbox" name="items" value="dicId=${item.dicId}&"/>
        	</ec:column>
        	<ec:column width="5%" property ="rowCount" cell ="rowCount" sortable ="false" title ="序号" />
        	<ec:column width="14%" alias="itemName" property="itemName"  title="<%=SecBasDicItem.ALIAS_ITEM_NAME%>"/>
        	<ec:column width="37%" alias="itemDescription" property="itemDescription"  title="<%=SecBasDicItem.ALIAS_ITEM_DESCRIPTION%>">
        	<div title="${item.itemDescription}">${item.itemDescription}</div>
        	</ec:column>
        	<ec:column width="14%" alias="groupId" sortable="false"  title="字典组">
        	      <div title="${DicGroupName}">${DicGroupName}</div>
        	</ec:column>
        	<ec:column width="30%" property="操作" title="操作" sortable="false" viewsAllowed="html">
            	<a href="${ctx}/framework/privilege/SecBasDicItem/show.do?dicId=${item.dicId}&groupId=${DicGroupId}" class="btn_grid_link_show"><em></em>查看</a>&nbsp;&nbsp;&nbsp;
            	<a href="${ctx}/framework/privilege/SecBasDicItem/orderUp.do?dicId=${item.dicId}&groupId=${DicGroupId}" onclick="return isTop('${item.itemOrder}');" class="btn_grid_link_move"><em></em>上移</a>&nbsp;&nbsp;&nbsp;
            	<a href="${ctx}/framework/privilege/SecBasDicItem/orderDown.do?dicId=${item.dicId}&groupId=${DicGroupId}" onclick="return isBottom('${item.itemOrder}');" class="btn_grid_link_move"><em></em>下移</a>&nbsp;&nbsp;&nbsp;
            	<a href="${ctx}/framework/privilege/SecBasDicItem/edit.do?dicId=${item.dicId}&groupId=${DicGroupId}" class="btn_grid_link_edit"><em></em>修改</a>&nbsp;&nbsp;&nbsp;
            	<a href="${ctx}/framework/privilege/SecBasDicItem/deleteById.do?dicId=${item.dicId}&groupId=${DicGroupId}" class="btn_grid_link_deleteRow" onclick="return deleteConfirm();"><em></em>删除</a>
        	</ec:column>
    	</ec:row>
	</ec:table>
	</div>
</rapid:override>
<%@ include file="/base.jsp"  %>