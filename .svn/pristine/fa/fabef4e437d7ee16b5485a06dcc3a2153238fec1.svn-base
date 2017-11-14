<%@page import="com.uk.sec.privilege.framework.privilege.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<rapid:override name="head">
    <title><%=SecBasDicGroup.TABLE_ALIAS%>信息</title>
</rapid:override>
<rapid:override name="container">
	<div class="positionPanel">
		<em></em>当前位置>><%=SecBasDicGroup.TABLE_ALIAS%>信息<a href="javascript:void(0)" onclick="window.history.go(-1)" class="back"></a>
	</div>
	<div class="formPanel">
		<form action="${ctx}/framework/privilege/SecBasDicGroup/list.do" method="post" theme="simple">
		<div class="formPanelHead">
			<ul>
				<li>信息</li>
			</ul>
		</div>
		<div class="formPanelBody">
			<table class="formTable" cellpadding="0" cellspacing="0">
        		<tr>
            		<td class="tdLabel"><%=SecBasDicGroup.ALIAS_GROUP_NAME%>：</td>
            		<td><s:property value="%{model.groupName}" /></td>
        		</tr>
        		<tr>
            		<td class="tdLabel"><%=SecBasDicGroup.ALIAS_GROUP_DESCRIPTION%>：</td>
            		<td><s:property value="%{model.groupDescription}" /></td>
        		</tr>
        		<tr>
            		<td class="tdLabel"><%=SecBasDicGroup.ALIAS_PARENT_ID%>：</td>
            		<td><s:property value="%{model.parentId}" /></td>
        		</tr>
        		<tr>
            		<td class="tdLabel"><%=SecBasDicGroup.ALIAS_GROUP_VIEWORDER%>：</td>
            		<td><s:property value="%{model.groupVieworder}" /></td>
        		</tr>
        		<tr>
            		<td class="tdLabel"><%=SecBasDicGroup.ALIAS_GROUP_FLAG%>：</td>
            		<td><s:property value="%{model.groupFlag}" /></td>
        		</tr>
    		</table>
    	</div>
    	<div class="formPanelFoot">
    		<table cellpadding="0" cellspacing="0">
    			<tr>
    				<td>
    					<input type="button" value="返回列表" onclick="window.location='${ctx}/framework/privilege/SecBasDicGroup/list.do'"/>
    					<input type="button" value="后退" onclick="history.back();"/>
    				</td>
    			</tr>
    		</table>
    	</div>
   			<s:hidden name="groupId" id="groupId" value="%{model.groupId}"/>
		</form>
	</div>
</rapid:override>
<%@ include file="/base.jsp"  %>