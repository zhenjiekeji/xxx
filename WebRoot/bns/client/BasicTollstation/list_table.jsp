<%@ page trimDirectiveWhitespaces="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.uk.sec.bns.client.model.*" %>
<%@ include file="/commons/taglibs.jsp" %>
<s:if test="#request.totalRows > 0">
	<%-- <ec:table items='page.result' var="item" method="post" width="940" border="0"
			retrieveRowsCallback="limit"
			sortRowsCallback="limit"
			filterRowsCallback="limit"
			rowsDisplayed="10"
			showExports="false"
			showStatusBar="false" 
			sortable="false"
			action="${ctx}/bns/client/UkClientInfo/list.do" autoIncludeParameters="true" tableId="UkClientInfo_list" state="notifyToPersist">
		<ec:row>
			<ec:column width="137" property="clientName" title="<%=UkClientInfo.ALIAS_CLIENT_NAME%>"/>
			<ec:column width="75" property="firstContact" title="<%=UkClientInfo.ALIAS_FIRST_CONTACT%>"><a href="UkClientInfo/show.do?id=${pageScope.item.clientId}">${pageScope.item.firstContact}</a></ec:column>
			<ec:column width="123" property="telephone" title="<%=UkClientInfo.ALIAS_TELEPHONE%>"/>
			<ec:column width="106" property="clientSector" title="<%=UkClientInfo.ALIAS_CLIENT_SECTOR%>"><s:property value="clientSectorMap[#attr.item.clientSector].itemName" /></ec:column>
			<ec:column width="122" property="clientOrigin" title="<%=UkClientInfo.ALIAS_CLIENT_ORIGIN%>"><s:property value="clientOriginMap[#attr.item.clientOrigin].itemName" /></ec:column>
			<ec:column width="70" property="clientType" title="<%=UkClientInfo.ALIAS_CLIENT_TYPE%>"><s:property value="clientTypeMap[#attr.item.clientType].itemName" /></ec:column>
			<ec:column width="73" property="clientDemandType" title="<%=UkClientInfo.ALIAS_CLIENT_DEMAND_TYPE%>"><s:property value="clientDemandTypeMap[#attr.item.clientDemandType].itemName" /></ec:column>
			<ec:column width="64" property="city" title="<%=UkClientInfo.ALIAS_CITY%>"/>
		</ec:row>
	</ec:table> --%>

	<table width="940" border="0" align="center" cellpadding="0" cellspacing="0" style="border:1px solid #BFC2CA;border-bottom:none;font-family:微软雅黑;font-size:14px">
		<tr>
			<td width="143" align="left" bgcolor="#F8F8F8" style="border-bottom:1px solid #BFC2CA;padding-left:10px"><strong>客户名称</strong></td>
			<td width="78" align="center" bgcolor="#F8F8F8" style="border-bottom:1px solid #BFC2CA"><strong>首要联系人</strong></td>
			<td width="118" align="center" bgcolor="#F8F8F8" style="border-bottom:1px solid #BFC2CA"><strong>联系电话</strong></td>
			<td width="109" height="40" align="center" bgcolor="#F8F8F8" style="border-bottom:1px solid #BFC2CA"><strong>客户行业</strong></td>
			<td width="108" align="center" bgcolor="#F8F8F8" style="border-bottom:1px solid #BFC2CA"><strong>信息来源</strong></td>
			<td width="88" align="center" bgcolor="#F8F8F8" style="border-bottom:1px solid #BFC2CA"><strong>客户类型</strong></td>
			<td width="61" align="center" bgcolor="#F8F8F8" style="border-bottom:1px solid #BFC2CA"><strong>租/售</strong></td>
			<td width="82" align="center" bgcolor="#F8F8F8" style="border-bottom:1px solid #BFC2CA"><strong>客服组</strong></td>
			<td width="74" align="center" bgcolor="#F8F8F8" style="border-bottom:1px solid #BFC2CA"><strong>录入人</strong></td>
			<td width="77" align="center" bgcolor="#F8F8F8" style="border-bottom:1px solid #BFC2CA"><strong>城市</strong></td>
		</tr>
		<s:iterator value="#request.page.result" status="status">
			<tr>
				<td style="border-bottom:1px solid #BFC2CA;padding-left:10px">${clientName }</td>
				<td align="center" style="border-bottom:1px solid #BFC2CA"><a href="UkClientInfo/show.do?id=${clientId }">${firstContact }</a></td>
				<td align="center" style="border-bottom:1px solid #BFC2CA">${telephone }</td>
				<td height="40" align="center" style="border-bottom:1px solid #BFC2CA">${clientSectorName }</td>
				<td align="center" style="border-bottom:1px solid #BFC2CA">${clientOrigin2Name }</td>
				<td align="center" style="border-bottom:1px solid #BFC2CA">${clientTypeName }</td>
				<td align="center" style="border-bottom:1px solid #BFC2CA">${clientDemandTypeName }</td>
				<td align="center" style="border-bottom:1px solid #BFC2CA">${addGroupName }</td>
				<td align="center" style="border-bottom:1px solid #BFC2CA">${addLoginName }</td>
				<td align="center" style="border-bottom:1px solid #BFC2CA">${provinceName }</td>
			</tr>
		</s:iterator>
	</table>
	<%@ include file="../list_page.jsp" %>
</s:if>