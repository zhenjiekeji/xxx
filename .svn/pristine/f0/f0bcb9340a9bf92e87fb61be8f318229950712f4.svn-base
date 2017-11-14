<%@page import="com.uk.sec.privilege.framework.privilege.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<rapid:override name="head">
    <title><%=SecPrivilegeMenu.TABLE_ALIAS%> 信息</title>
</rapid:override>
<rapid:override name="container">
	<div class="positionPanel">
		<em></em>>>系统管理>>菜单管理<a href="javascript:void(0)" onclick="window.history.go(-1)" class="back"></a>
	</div>
	<div class="formPanel">
		<form id="relateOperationsForm" action="${ctx}/framework/privilege/SecPrivilegeMenu/saveMenuRelateOperations.do" method="post">
			<s:hidden id="menuId" name="menuId" value="%{model.menuId}"/>
			<div class="formPanelHead">
				<ul>
					<li>关联操作</li>
				</ul>
			</div>
			<div class="formPanelBody">
				<div id="menuTitle" style="width:100%;font-weight:bold;"><%=SecPrivilegeMenu.ALIAS_MENU_TITLE%>：<s:property value="%{model.menuTitle}"/></div>
				<table id="relateOperationsTable" class="formTable" style="width:50%;margin-left:auto;margin-right:auto;">
					<s:iterator value="allOperationList" id="secBasOperation" status="status">			<%--一行4列 --%>
						<s:if test="#status.getIndex()%5 == 0">
							<tr>
						</s:if>
								<td>
									<input type="checkbox" name="operationId" value="<s:property value='#secBasOperation.itemId'/>"
										<s:iterator value="menuOperationList" id="menuOperation" status="status">	<%--迭代菜单关联的操作,如果该菜单关联了相应的操作,则该操作被选中 --%>
				                        	<s:if test="#secBasOperation.itemId==#menuOperation.itemId">
											  checked="checked"
											</s:if>
										</s:iterator>
									/>&nbsp;&nbsp;<s:property value="#secBasOperation.itemDescription"/>
								</td>
						<s:if test="#status.getIndex()%5 == 4">
							</tr>
						</s:if>
						<s:if test="#status.isLast()">
							</tr>
						</s:if>
					</s:iterator>
	    		</table>
	    	</div>
	    	<div class="formPanelFoot">
		  		<input id="selectAllButton" type="button" value="全选"/>
		  		<input id="submitButton" type="submit" value="提交"/>
		  		<input type="button" value="返回列表" onclick="window.location='${ctx}/framework/privilege/SecPrivilegeMenu/list.do'"/>
	    	</div>
		</form>
	</div>
</rapid:override>
<%@ include file="/base.jsp"  %>