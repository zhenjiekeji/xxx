
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>

<head>
    <%@ include file="/commons/meta.jsp" %>
    <title><%=EctableColumn.TABLE_ALIAS%>新增</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="container">
	<div class="positionPanel">
		<em></em>当前位置>><%=EctableColumn.TABLE_ALIAS%>新增<a href="javascript:void(0)" onclick="window.history.go(-1)" class="back"></a>
	</div>
	<div class="formPanel">
		<form action="${ctx}/framework/ectable/EctableColumn/save.do" method="post">
		<div class="formPanelHead">
			<ul>
				<li>新增</li>
			</ul>
		</div>
		<div class="formPanelBody">
			<table class="formTable" cellpadding="0" cellspacing="0">
   				<%@ include file="form_include.jsp" %>
   			</table>
    	</div>
    	<div class="formPanelFoot">
    		<table cellpadding="0" cellspacing="0">
    			<tr>
    				<td>
    					<input id="submitButton" name="submitButton" type="submit" value="提交" />
    					<input type="button" value="返回列表" onclick="window.location='${ctx}/framework/ectable/EctableColumn/list.do'" />
    					<input type="button" value="后退" onclick="history.back();" />
    				</td>
    			</tr>
    		</table>
    	</div>
		</form>
    </div>
</div>
<script>

    new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
        var finalResult = result;

        //在这里添加自定义验证

        return disableSubmit(finalResult,'submitButton');
    }});
</script>

</body>
</html>