<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.uk.sec.privilege.framework.privilege.model.*" %>
<%@ include file="/commons/taglibs.jsp" %>
<rapid:override name="head">
    <title><%=SecBasDicItem.TABLE_ALIAS%>编辑</title>
    <script type="text/javascript" src="scripts/privilege/dicItemManage.js"></script>
</rapid:override>
<rapid:override name="container">
	<div class="positionPanel">
		<em></em>当前位置>><%=SecBasDicItem.TABLE_ALIAS%>编辑<a href="javascript:void(0)" onclick="window.history.go(-1)" class="back"></a>
	</div>
	<div class="formPanel">
	<form id="itemForm" action="${ctx}/framework/privilege/SecBasDicItem/update.do" method="post">
		<div class="formPanelHead">
			<ul>
				<li>编辑</li>
			</ul>
		</div>
		<div class="formPanelBody">
			<table class="formTable" cellpadding="0" cellspacing="0">
				<s:hidden id="dicId" name="dicId" />
				<input type="hidden" id="groupId" name="groupId" value="${DicGroupId}"/>
				<input type="hidden" id="itemFlag" name="itemFlag" value="1"/>
    <tr>
		<td><font color="red">*</font>字典项名称</td>
		<td><input type="text" id="itemName" name="itemName" value="${model.itemName}"/></td>
    </tr>
    <tr>
		<td>字典组</td>
		<td><input disabled="disabled" type="text" id="groupName" name="groupName" value="${DicGroupName}"/></td>
    </tr>
    <tr>
		<td>字典项描述</td>
		<td>
		<textarea id="itemDescription" name="itemDescription" rows="8" cols="100">${model.itemDescription}</textarea>
		</td>
		<!-- <input type="text" id="itemDescription" name="itemDescription" value="${model.itemDescription}"/> -->
    </tr>
    		</table>
    	</div>
    	<div class="formPanelFoot">
    		<table cellpadding="0" cellspacing="0">
    			<tr>
    				<td>
    					<input id="submitButton" name="submitButton" type="submit" value="提交" />
    					<input type="button" value="返回列表" onclick="window.location='${ctx}/framework/privilege/SecBasDicItem/list.do?groupId=${DicGroupId}'"/>
    					<input type="button" value="后退" onclick="history.back();"/>
    				</td>
    			</tr>
    		</table>
    	</div>
	</form>
	</div>
</rapid:override>
<%@ include file="/base.jsp"  %>