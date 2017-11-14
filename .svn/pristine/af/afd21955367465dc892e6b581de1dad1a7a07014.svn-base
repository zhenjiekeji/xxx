<%@page import="com.uk.sec.framework.ectable.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>

<head>
    <%@ include file="/commons/meta.jsp" %>
    <link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel="stylesheet" />
    <title><%=EctableColumn.TABLE_ALIAS%> 维护</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="container">
	<div class="positionPanel">
		<em></em>当前位置>><%=EctableColumn.TABLE_ALIAS%> 维护
	</div>
	<div class="queryPanel">
		<form action="<c:url value="/framework/ectable/EctableColumn/list.do"/>" method="post">
		<div class="queryPanelHead">搜索</div>
		<div class="queryPanelBody">
    		<table class="queryTable" cellpadding="0" cellspacing="0">
        		<tr>
            		<td class="tdLabel">
                    	<%=EctableColumn.ALIAS_NAME%>
            		</td>
            		<td>
                		<input value="${pageRequest.filters.name}"  name="s_name"  />
            		</td>
            		<td class="tdLabel">
                    	<%=EctableColumn.ALIAS_UNIQUE_NAME%>
            		</td>
            		<td>
                		<input value="${pageRequest.filters.uniqueName}"  name="s_uniqueName"  />
            		</td>
            		<td class="tdLabel">
                    	<%=EctableColumn.ALIAS_DESCRIPTION%>
            		</td>
            		<td>
                		<input value="${pageRequest.filters.description}"  name="s_description"  />
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
		<form action="<c:url value="/framework/ectable/EctableColumn/create.do"/>" method="post">
		<table cellpadding="0" cellspacing="0">
			<tr>
				<td>
    				<input type="submit" class="createBtn" value="新增" />
    				<input type="button" class="deleteBtn" value="删除" onclick="batchDelete('${ctx}/framework/ectable/EctableColumn/delete.do','items',document.forms.EctableColumn_list)" />
    			</td>
    		</tr>
    	</table>
    	</form>
	</div>
	<div class="dataGridPanel">
	<ec:table items='page.result' var="item" method="post"
    retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
    action="${ctx}/framework/ectable/EctableColumn/list.do" autoIncludeParameters="true" tableId="EctableColumn_list" state="notifyToPersist">
    	<ec:exportXls fileName="export.xls" tooltip="导出"/>
    	<ec:row>
        	<ec:column property="选择" title="<input type='checkbox' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="3%" viewsAllowed="html">
            	<input type="checkbox" name="items" value="id=${item.id}&"/>
        	</ec:column>
        	<ec:column alias="ectableColumn_name" property="name"  title="<%=EctableColumn.ALIAS_NAME%>"/>
        	<ec:column alias="ectableColumn_uniqueName" property="uniqueName"  title="<%=EctableColumn.ALIAS_UNIQUE_NAME%>"/>
        	<ec:column alias="ectableColumn_description" property="description"  title="<%=EctableColumn.ALIAS_DESCRIPTION%>"/>
        	<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
            	<a href="${ctx}/framework/ectable/EctableColumn/show.do?id=${item.id}&" class="btn_grid_link_show"><em></em>查看</a>&nbsp;&nbsp;&nbsp;
            	<a href="${ctx}/framework/ectable/EctableColumn/edit.do?id=${item.id}&" class="btn_grid_link_edit"><em></em>修改</a>&nbsp;&nbsp;&nbsp;
            	<a href="${ctx}/framework/ectable/EctableColumn/deleteById.do?id=${item.id}&" class="btn_grid_link_delete" onclick="return deleteConfirm();"><em></em>删除</a>
        	</ec:column>
    	</ec:row>
	</ec:table>
	</div>
</div>
</body>

</html>