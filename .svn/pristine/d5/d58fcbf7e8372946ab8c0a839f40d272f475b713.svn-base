<%@page import="com.uk.sec.framework.ectable.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <%@ include file="/commons/meta.jsp" %>
    <title><%=EctableColumnDetail.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/framework/ectable/EctableColumnDetail/list.do" method="post">
    <input type="submit" value="提交" onclick="return new Validation(document.forms[0]).validate();"/>
    <input type="button" value="返回列表" onclick="window.location='${ctx}/framework/ectable/EctableColumnDetail/list.do'"/>
    <input type="button" value="后退" onclick="history.back();"/>

    <table class="formTable">

        <tr bgcolor="#FFFFFF">
           <td class="tdLabel"><%=EctableColumnDetail.ALIAS_COLUMN_NAME%></td>
           <td>
                <input  type="text" name="s_columnName" size="30" maxlength="100" class=""/>
           </td>
        </tr>
        <tr bgcolor="#FFFFFF">
           <td class="tdLabel"><%=EctableColumnDetail.ALIAS_ORDER_NUM%></td>
           <td>
                <input  type="text" name="s_orderNum" size="30" maxlength="9" class="validate-integer max-value-2147483647"/>
           </td>
        </tr>
        <tr bgcolor="#FFFFFF">
           <td class="tdLabel"><%=EctableColumnDetail.ALIAS_SHOW_STATUS%></td>
           <td>
                <input  type="text" name="s_showStatus" size="30" maxlength="10" class="validate-integer "/>
           </td>
        </tr>
        <tr bgcolor="#FFFFFF">
           <td class="tdLabel"><%=EctableColumnDetail.ALIAS_USER_ID%></td>
           <td>
                <input  type="text" name="s_userId" size="30" maxlength="32" class=""/>
           </td>
        </tr>
        <tr bgcolor="#FFFFFF">
           <td class="tdLabel"><%=EctableColumnDetail.ALIAS_VIEW_TYPE%></td>
           <td>
                <input  type="text" name="s_viewType" size="30" maxlength="100" class=""/>
           </td>
        </tr>
        <tr bgcolor="#FFFFFF">
           <td class="tdLabel"><%=EctableColumnDetail.ALIAS_DISPLAY_NAME%></td>
           <td>
                <input  type="text" name="s_displayName" size="30" maxlength="100" class=""/>
           </td>
        </tr>
        <tr bgcolor="#FFFFFF">
           <td class="tdLabel"><%=EctableColumnDetail.ALIAS_ECTABLE_COLUMN_ID%></td>
           <td>
                <input  type="text" name="s_ectableColumnId" size="30" maxlength="32" class=""/>
           </td>
        </tr>

    </table>
</s:form>

</body>

</html>