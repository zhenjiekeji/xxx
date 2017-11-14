<%@page import="com.uk.sec.framework.ectable.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <%@ include file="/commons/meta.jsp" %>
    <link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
    <title><%=EctableColumnDetail.TABLE_ALIAS%> 维护</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
<form action="<c:url value="/framework/ectable/EctableColumnDetail/list.do"/>" method="post" style="display: inline;">
<fieldset>
    <legend>搜索</legend>
    <table>
        <tr>
            <td class="tdLabel">
                    <%=EctableColumnDetail.ALIAS_COLUMN_NAME%>
            </td>
            <td>
                <input value="${pageRequest.filters.columnName}"  name="s_columnName"  />
            </td>
            <td class="tdLabel">
                    <%=EctableColumnDetail.ALIAS_ORDER_NUM%>
            </td>
            <td>
                <input value="${pageRequest.filters.orderNum}"  name="s_orderNum"  />
            </td>
            <td class="tdLabel">
                    <%=EctableColumnDetail.ALIAS_SHOW_STATUS%>
            </td>
            <td>
                <input value="${pageRequest.filters.showStatus}"  name="s_showStatus"  />
            </td>
            <td class="tdLabel">
                    <%=EctableColumnDetail.ALIAS_USER_ID%>
            </td>
            <td>
                <input value="${pageRequest.filters.userId}"  name="s_userId"  />
            </td>
        </tr>
        <tr>
            <td class="tdLabel">
                    <%=EctableColumnDetail.ALIAS_VIEW_TYPE%>
            </td>
            <td>
                <input value="${pageRequest.filters.viewType}"  name="s_viewType"  />
            </td>
            <td class="tdLabel">
                    <%=EctableColumnDetail.ALIAS_DISPLAY_NAME%>
            </td>
            <td>
                <input value="${pageRequest.filters.displayName}"  name="s_displayName"  />
            </td>
            <td class="tdLabel">
                    <%=EctableColumnDetail.ALIAS_ECTABLE_COLUMN_ID%>
            </td>
            <td>
                <input value="${pageRequest.filters.ectableColumnId}"  name="s_ectableColumnId"  />
            </td>
        </tr>
    </table>
</fieldset>
<div class="handleControl">
    <input type="submit" class="stdButton" style="width:80px" value="查询" onclick="getReferenceForm(this).action='${ctx}/framework/ectable/EctableColumnDetail/list.do'"/>
    <input type="submit" class="stdButton" style="width:80px" value="新增" onclick="getReferenceForm(this).action='${ctx}/framework/ectable/EctableColumnDetail/create.do'"/>
    <input type="button" class="stdButton" style="width:80px" value="删除" onclick="batchDelete('${ctx}/framework/ectable/EctableColumnDetail/delete.do','items',document.forms.ec)"/>
<div>
</form>
</div>

<ec:table items='page.result' var="item" method="get"
    retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
    action="${ctx}/framework/ectable/EctableColumnDetail/list.do" autoIncludeParameters="true" tableId="ecd_list" state="persist">
    <ec:exportXls fileName="export.xls" tooltip="导出"/>
    <ec:row>
        <ec:column property="选择" title="<input type='checkbox' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="3%" viewsAllowed="html">
            <input type="checkbox" name="items" value="id=${item.id}&"/>
        </ec:column>
        <ec:column alias="ecd_columnName" property="columnName"  title="<%=EctableColumnDetail.ALIAS_COLUMN_NAME%>"/>
        <ec:column alias="ecd_orderNum" property="orderNum"  title="<%=EctableColumnDetail.ALIAS_ORDER_NUM%>"/>
        <ec:column alias="ecd_showStatus" property="showStatus"  title="<%=EctableColumnDetail.ALIAS_SHOW_STATUS%>"/>
        <ec:column alias="ecd_userId" property="userId"  title="<%=EctableColumnDetail.ALIAS_USER_ID%>"/>
        <ec:column alias="ecd_viewType" property="viewType"  title="<%=EctableColumnDetail.ALIAS_VIEW_TYPE%>"/>
        <ec:column alias="ecd_displayName" property="displayName"  title="<%=EctableColumnDetail.ALIAS_DISPLAY_NAME%>"/>
        <ec:column alias="ecd_ectableColumnId" property="ectableColumnId"  title="<%=EctableColumnDetail.ALIAS_ECTABLE_COLUMN_ID%>"/>
        <ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
            <a href="${ctx}/framework/ectable/EctableColumnDetail/show.do?id=${item.id}&">查看</a>&nbsp;&nbsp;&nbsp;
            <a href="${ctx}/framework/ectable/EctableColumnDetail/edit.do?id=${item.id}&">修改</a>
        </ec:column>
    </ec:row>
</ec:table>

</body>

</html>

