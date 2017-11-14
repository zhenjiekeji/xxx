<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<rapid:override name="head">
    <title>编辑字典组</title>
</rapid:override>
<rapid:override name="container">
<script type="text/javascript" src="scripts/privilege/dicGroupManage.js"></script>
	<div class="positionPanel">
		<em></em>当前位置>>编辑字典组<a href="javascript:void(0)" onclick="window.history.go(-1)" class="back"></a>
	</div>
	<div class="formPanel">
	<form id="groupForm" action="${ctx}/framework/privilege/SecBasDicGroup/update.do" method="post">
			<s:hidden id="groupId" name="groupId" value="%{model.groupId}"/>
			<div class="formPanelHead">
				<ul>
					<li>编辑</li>
				</ul>
			</div>
			<div class="formPanelBody">
				<table class="formTable" cellpadding="0" cellspacing="0">
					<tr>
					    <td class="rowHead"><font class="red">*</font>字典组名称：</td>
					    <td>
					    	<input type="text" id="groupName" name="groupName" value="<s:property value='%{model.groupName}'/>"/>
					    </td>
				  	</tr>
					<tr>
					    <td class="rowHead">显示顺序：</td>
					    <td>
					    	<s:property value="%{model.groupVieworder}"/>
					    </td>
				  	</tr>
				  	<tr>
					    <td class="rowHead">字典组描述：</td>
					    <td>
					    	<textarea id="groupDescription" name="groupDescription" rows="8" cols="100"><s:property value="%{model.groupDescription}"/></textarea>
					    </td>
				  	</tr>
	    		</table>
	    	</div>
	    	<div class="formPanelFoot">
	    		<table cellpadding="0" cellspacing="0">
	    			<tr>
	    				<td>
	    					<input id="submitButton" name="submitButton" type="submit" value="提交" />
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
