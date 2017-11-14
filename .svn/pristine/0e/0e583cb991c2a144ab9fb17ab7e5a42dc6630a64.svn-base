<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.uk.sec.bns.client.model.*"%>
<%@ include file="/commons/taglibs.jsp"%>
<!-- 查看资料 -->
<div id="myModal" class="reveal-modal examine"></div>

<div id="demand">
	<dl class="demand_dl" style="display: none" id="demandNUMBERID">
		<table width="940" border="0" align="center" cellpadding="0"
			cellspacing="0"
			style="border: 1px solid #BFC2CA; border-bottom: none; font-family: 微软雅黑; font-size: 14px; margin-top: 20px">
			<tr>
				<td height="40" colspan="2" align="left" bgcolor="#FFFFFF"
					style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"
					class="numbers"><strong>收费站信息<em>1</em></strong></td>
				<td height="40" width="250px" align="right" bgcolor="#FFFFFF"
					style="border-bottom: 1px solid #BFC2CA;" class="add_opt">
					<div class="demand_add">
						<span style="cursor: pointer" class="add_jcxx" title="添加本组信息"><img
							src="images/add.gif" align="absmiddle" /> 增加本组信息</span>&nbsp;&nbsp;
					</div>
					<div class="demand_del" style="display: none">
						<span style="cursor: pointer" class="add_jcxx" title="删除本组信息"><a
							href="javascript:void(0);" style=""><img
								src="images/remmod.gif" align="absmiddle"> 删除本组信息</a></span>
					</div>
				</td>
				<td style="border-bottom: 1px solid #BFC2CA;" >
									<div>
							<span style="cursor: pointer" title="保存" id="saveStation"><img
					src="images/filesave.png" align="absmiddle" /> 保存</span>
					</div>
				</td>
			</tr>
			<s:if test="basicTollstations.size != 0">
			<s:iterator value="basicTollstations">
			<input type="hidden" name="basicTollStationPkIdlistnum" id="basicTollStationPkIdlistnum" value="<s:property value="pkId" />">	
			<tr>
				<td align="right" width="200" bgcolor="#F8F8F8"
					style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span class="red">*</span>收费站老编号：</td>
				<td height="40" align="left"
					style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
					<input name="basicTollstations[listnum].tsCode" id="basicTollstations[listnum].tsCode" value="<s:property value="tsCode" />" class="shuru" type="text" size="20" /><label
									class="red" id="tsCode_error"><s:fielderror>
											<s:param>tsCode</s:param>
										</s:fielderror></label>
				</td>
				<td align="right" bgcolor="#F8F8F8"
					style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span class="red">*</span>收费站名称：</td>
				<td height="40" align="left"
					style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"><input
					name="basicTollstations[listnum].tsName" id="basicTollstations[listnum].tsName" value="<s:property value="tsName" />" class="shuru" type="text" size="20" /><label
									class="red" id="tsName_error"><s:fielderror>
											<s:param>tsName</s:param>
										</s:fielderror></label></td>
			</tr>
			</s:iterator>
     		</s:if>
     		<s:else>							
			<tr>
				<td align="right" width="200" bgcolor="#F8F8F8"
					style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span class="red">*</span>收费站老编号：</td>
				<td height="40" align="left"
					style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
					<input name="basicTollstations[listnum].tsCode" id="basicTollstations[listnum].tsCode" value="<s:property value="tsCode" />" class="shuru" type="text" size="20" /><label
									class="red" id="tsCode_error"><s:fielderror>
											<s:param>tsCode</s:param>
										</s:fielderror></label>
				</td>
				<td align="right" width="100" bgcolor="#F8F8F8"
					style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-left: 1px solid #BFC2CA; border-right: 1px solid #BFC2CA"><span class="red">*</span>收费站名称：</td>
				<td height="40" align="left"
					style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"><input
					name="basicTollstations[listnum].tsName" id="basicTollstations[listnum].tsName" value="<s:property value="tsName" />" class="shuru" type="text" size="20" /><label
									class="red" id="tsName_error"><s:fielderror>
											<s:param>tsName</s:param>
										</s:fielderror></label></td>
			</tr>
     		</s:else>
		</table>
	</dl>
</div>
<div id="demandNew">
	<dl class="demand_dl" style="display: none" id="demandNUMBERID">
		<table width="940" border="0" align="center" cellpadding="0"
			cellspacing="0"
			style="border: 1px solid #BFC2CA; border-bottom: none; font-family: 微软雅黑; font-size: 14px; margin-top: 20px">
			<tr>
				<td height="40" colspan="2" align="left" bgcolor="#FFFFFF"
					style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"
					class="numbers"><strong>收费站信息<em>1</em></strong></td>
				<td height="40" width="250px" align="right" bgcolor="#FFFFFF"
					style="border-bottom: 1px solid #BFC2CA;" class="add_opt">
					<div class="demand_add">
						<span style="cursor: pointer" class="add_jcxx" title="添加本组信息"><img
							src="images/add.gif" align="absmiddle" /> 增加本组信息</span>&nbsp;&nbsp;
					</div>
					<div class="demand_del" style="display: none">
						<span style="cursor: pointer" class="add_jcxx" title="删除本组信息"><a
							href="javascript:void(0);" style=""><img
								src="images/remmod.gif" align="absmiddle"> 删除本组信息</a></span>
					</div>
				</td>
				<td style="border-bottom: 1px solid #BFC2CA;" >
									<div>
							<span style="cursor: pointer" title="保存" id="saveStation"><img
					src="images/filesave.png" align="absmiddle" /> 保存</span>
					</div>
				</td>
			</tr>						
			<tr>
				<td align="right" width="200" bgcolor="#F8F8F8"
					style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span class="red">*</span>收费站老编号：</td>
				<td height="40" align="left"
					style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
					<input name="basicTollstations[listnum].tsCode" id="basicTollstations[listnum].tsCode" value="<s:property value="tsCode" />" class="shuru" type="text" size="20" /><label
									class="red" id="tsCode_error"><s:fielderror>
											<s:param>tsCode</s:param>
										</s:fielderror></label>
				</td>
				<td align="right" width="100" bgcolor="#F8F8F8"
					style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-left: 1px solid #BFC2CA; border-right: 1px solid #BFC2CA"><span class="red">*</span>收费站名称：</td>
				<td height="40" align="left"
					style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"><input
					name="basicTollstations[listnum].tsName" id="basicTollstations[listnum].tsName" value="<s:property value="tsName" />" class="shuru" type="text" size="20" /><label
									class="red" id="tsName_error"><s:fielderror>
											<s:param>tsName</s:param>
										</s:fielderror></label></td>
			</tr>
		</table>
	</dl>
</div>