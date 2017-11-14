<%@page import="com.uk.sec.framework.ectable.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <%@ include file="/commons/meta.jsp" %>
    <title><%=EctableColumnDetail.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/framework/ectable/EctableColumnDetail/list.do" method="post" theme="simple">
    <input type="button" value="返回列表" onclick="window.location='${ctx}/framework/ectable/EctableColumnDetail/list.do'"/>
    <input type="button" value="后退" onclick="history.back();"/>

    <s:hidden name="id" id="id" value="%{model.id}"/>

    <table class="formTable">
        <tr>
            <td class="tdLabel"><%=EctableColumnDetail.ALIAS_COLUMN_NAME%></td>
            <td><s:property value="%{model.columnName}" /></td>
        </tr>
        <tr>
            <td class="tdLabel"><%=EctableColumnDetail.ALIAS_ORDER_NUM%></td>
            <td><s:property value="%{model.orderNum}" /></td>
        </tr>
        <tr>
            <td class="tdLabel"><%=EctableColumnDetail.ALIAS_SHOW_STATUS%></td>
            <td><s:property value="%{model.showStatus}" /></td>
        </tr>
        <tr>
            <td class="tdLabel"><%=EctableColumnDetail.ALIAS_USER_ID%></td>
            <td><s:property value="%{model.userId}" /></td>
        </tr>
        <tr>
            <td class="tdLabel"><%=EctableColumnDetail.ALIAS_VIEW_TYPE%></td>
            <td><s:property value="%{model.viewType}" /></td>
        </tr>
        <tr>
            <td class="tdLabel"><%=EctableColumnDetail.ALIAS_DISPLAY_NAME%></td>
            <td><s:property value="%{model.displayName}" /></td>
        </tr>
        <tr>
            <td class="tdLabel"><%=EctableColumnDetail.ALIAS_ECTABLE_COLUMN_ID%></td>
            <td><s:property value="%{model.ectableColumnId}" /></td>
        </tr>
    </table>
</s:form>

</body>

</html>