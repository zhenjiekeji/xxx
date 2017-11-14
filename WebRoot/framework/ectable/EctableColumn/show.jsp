<%@page import="com.uk.sec.framework.ectable.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/commons/meta.jsp" %>
    <title><%=EctableColumn.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="container">
	<div class="positionPanel">
		<em></em>当前位置>><%=EctableColumn.TABLE_ALIAS%>信息<a href="javascript:void(0)" onclick="window.history.go(-1)" class="back"></a>
	</div>
	<div class="formPanel">
		<form action="${ctx}/framework/ectable/EctableColumn/list.do" method="post" theme="simple">
		<div class="formPanelHead">
			<ul>
				<li>信息</li>
			</ul>
		</div>
		<div class="formPanelBody">
			<table class="formTable" cellpadding="0" cellspacing="0">
        		<tr>
            		<td class="tdLabel"><%=EctableColumn.ALIAS_NAME%>：</td>
            		<td><s:property value="%{model.name}" /></td>
        		</tr>
        		<tr>
            		<td class="tdLabel"><%=EctableColumn.ALIAS_UNIQUE_NAME%>：</td>
            		<td><s:property value="%{model.uniqueName}" /></td>
        		</tr>
        		<tr>
            		<td class="tdLabel"><%=EctableColumn.ALIAS_DESCRIPTION%>：</td>
            		<td><s:property value="%{model.description}" /></td>
        		</tr>
    		</table>
    	</div>
    	<div class="formPanelFoot">
    		<table cellpadding="0" cellspacing="0">
    			<tr>
    				<td>
    					<input type="button" value="返回列表" onclick="window.location='${ctx}/framework/ectable/EctableColumn/list.do'"/>
    					<input type="button" value="后退" onclick="history.back();"/>
    				</td>
    			</tr>
    		</table>
    	</div>
   			<s:hidden name="id" id="id" value="%{model.id}"/>
		</form>
	</div>
</div>
</body>
</html>