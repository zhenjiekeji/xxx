<%@page import="com.uk.sec.privilege.framework.privilege.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<rapid:override name="head">
    <title><%=SecBasDicItem.TABLE_ALIAS%>信息</title>
</rapid:override>
<rapid:override name="container">
	<div class="positionPanel">
		<em></em>当前位置>>字典项信息<a href="javascript:void(0)" onclick="window.history.go(-1)" class="back"></a>
	</div>
	<div class="formPanel">
		<form action="${ctx}/framework/privilege/SecBasDicItem/list.do" method="post" theme="simple">
		<div class="formPanelHead">
			<ul>
				<li>字典项信息</li>
			</ul>
		</div>
		<div class="formPanelBody">
			<table class="formTable" cellpadding="0" cellspacing="0">

        		<tr>
            		<td width="10%">字典项名称：</td>
            		<td><s:property value="%{model.itemName}" /></td>
            	</tr>
            	<tr>
            		<td width="10%">字典组：</td>
            		<td><s:property value="%{#request.DicGroupName}" /></td>
            	</tr>
            	<tr>
            		<td width="10%">字典项描述：</td>
            		<td>
            		<textarea id="groupDescription" name="groupDescription" rows="8" cols="100"><s:property value="%{model.itemDescription}" /></textarea>
            		</td>
        		</tr>
    		</table>
    	</div>
    	<div class="formPanelFoot">
    		<table cellpadding="0" cellspacing="0">
    			<tr>
    				<td>
    					<input type="button" value="返回列表" onclick="window.location='${ctx}/framework/privilege/SecBasDicItem/list.do?groupId=${DicGroupId}'"/>
    					<input type="button" value="后退" onclick="history.back();"/>
    				</td>
    			</tr>
    		</table>
    	</div>
   			<s:hidden name="dicId" id="dicId" value="%{model.dicId}"/>
		</form>
	</div>
</rapid:override>
<%@ include file="/base.jsp"  %>