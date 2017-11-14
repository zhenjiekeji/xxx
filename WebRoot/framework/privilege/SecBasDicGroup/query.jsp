<%@page import="com.uk.sec.privilege.framework.privilege.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<rapid:override name="head">
    <title><%=SecBasDicGroup.TABLE_ALIAS%>查询</title>
</rapid:override>
<rapid:override name="container">
	<div class="positionPanel">
		<em></em>当前位置>><%=SecBasDicGroup.TABLE_ALIAS%>查询<a href="javascript:void(0)" onclick="window.history.go(-1)" class="back"></a>
	</div>
	<div class="formPanel">
		<form action="${ctx}/framework/privilege/SecBasDicGroup/list.do" method="post">
		<div class="formPanelHead">
			<ul>
				<li>查询</li>
			</ul>
		</div>
		<div class="formPanelBody">
			<table class="formTable" cellpadding="0" cellspacing="0">
        		<tr>
           			<td class="tdLabel"><%=SecBasDicGroup.ALIAS_GROUP_NAME%>：</td>
           			<td>
                		<input  type="text" name="s_groupName" size="30" maxlength="50" class=""/>
           			</td>
        		</tr>
        		<tr>
           			<td class="tdLabel"><%=SecBasDicGroup.ALIAS_GROUP_DESCRIPTION%>：</td>
           			<td>
                		<input  type="text" name="s_groupDescription" size="30" maxlength="1000" class=""/>
           			</td>
        		</tr>
        		<tr>
           			<td class="tdLabel"><%=SecBasDicGroup.ALIAS_PARENT_ID%>：</td>
           			<td>
                		<input  type="text" name="s_parentId" size="30" maxlength="32" class=""/>
           			</td>
        		</tr>
        		<tr>
           			<td class="tdLabel"><%=SecBasDicGroup.ALIAS_GROUP_VIEWORDER%>：</td>
           			<td>
                		<input  type="text" name="s_groupVieworder" size="30" maxlength="2000" class=""/>
           			</td>
        		</tr>
        		<tr>
           			<td class="tdLabel"><%=SecBasDicGroup.ALIAS_GROUP_FLAG%>：</td>
           			<td>
                		<input  type="text" name="s_groupFlag" size="30" maxlength="4" class="validate-integer max-value-32767"/>
           			</td>
        		</tr>
    		</table>
    	</div>
    	<div class="formPanelFoot">
    		<table cellpadding="0" cellspacing="0">
    			<tr>
    				<td>
    					<input type="submit" value="提交" onclick="return new Validation(document.forms[0]).validate();"/>
    					<input type="button" value="返回列表" onclick="window.location='${ctx}/framework/privilege/SecBasDicGroup/list.do'"/>
    					<input type="button" value="后退" onclick="history.back();"/>
    				</td>
    			</tr>
    		</table>
    	</div>
		</form>
	</div>
</rapid:override>
<%@ include file="/base.jsp"  %>