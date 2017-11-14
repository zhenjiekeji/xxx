
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <%@ include file="/commons/meta.jsp" %>
    <title><%=EctableColumnDetail.TABLE_ALIAS%>新增</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/framework/ectable/EctableColumnDetail/save.do" method="post">
    <input id="submitButton" name="submitButton" type="submit" value="提交" />
    <input type="button" value="返回列表" onclick="window.location='${ctx}/framework/ectable/EctableColumnDetail/list.do'"/>
    <input type="button" value="后退" onclick="history.back();"/>

    <table class="formTable">
    <%@ include file="form_include.jsp" %>
    </table>
</s:form>

<script>

    new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
        var finalResult = result;

        //在这里添加自定义验证

        return disableSubmit(finalResult,'submitButton');
    }});
</script>

</body>
</html>