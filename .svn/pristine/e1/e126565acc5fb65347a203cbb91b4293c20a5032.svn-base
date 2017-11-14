<%@page import="com.uk.sec.framework.ectable.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/commons/meta.jsp" %>
    <title><%=EctableColumn.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="container">
	<div class="positionPanel">
		<em></em>当前位置>><%=EctableColumn.TABLE_ALIAS%>查询<a href="javascript:void(0)" onclick="window.history.go(-1)" class="back"></a>
	</div>
	<div class="formPanel">
		<form action="${ctx}/framework/ectable/EctableColumn/list.do" method="post">
		<div class="formPanelHead">
			<ul>
				<li>查询</li>
			</ul>
		</div>
		<div class="formPanelBody">
			<table class="formTable" cellpadding="0" cellspacing="0">
        		<tr>
           			<td class="tdLabel"><%=EctableColumn.ALIAS_NAME%>：</td>
           			<td>
                		<input  type="text" name="s_name" size="30" maxlength="100" class=""/>
           			</td>
        		</tr>
        		<tr>
           			<td class="tdLabel"><%=EctableColumn.ALIAS_UNIQUE_NAME%>：</td>
           			<td>
                		<input  type="text" name="s_uniqueName" size="30" maxlength="100" class=""/>
           			</td>
        		</tr>
        		<tr>
           			<td class="tdLabel"><%=EctableColumn.ALIAS_DESCRIPTION%>：</td>
           			<td>
                		<input  type="text" name="s_description" size="30" maxlength="200" class=""/>
           			</td>
        		</tr>
    		</table>
    	</div>
    	<div class="formPanelFoot">
    		<table cellpadding="0" cellspacing="0">
    			<tr>
    				<td>
    					<input type="submit" value="提交" onclick="return new Validation(document.forms[0]).validate();"/>
    					<input type="button" value="返回列表" onclick="window.location='${ctx}/framework/ectable/EctableColumn/list.do'"/>
    					<input type="button" value="后退" onclick="history.back();"/>
    				</td>
    			</tr>
    		</table>
    	</div>
		</form>
	</div>
</div>
</body>

</html>