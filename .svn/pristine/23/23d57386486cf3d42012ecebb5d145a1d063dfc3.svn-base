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
				<td height="40" colspan="3" align="left" bgcolor="#FFFFFF"
					style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"
					class="numbers"><strong>收费广场信息<em>1</em></strong></td>
				<td height="40" align="right" bgcolor="#FFFFFF"
					style="border-bottom: 1px solid #BFC2CA; padding-right: 10px" class="add_opt">
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
				<td width="50px">
									<div>
							<span style="cursor: pointer" title="保存" id="savePlaza"><img
					src="images/filesave.png" align="absmiddle" /> 保存</span>
					</div>
				</td>
			</tr>
			<s:if test="basicTollplazas.size != 0">
			<s:iterator value="basicTollplazas">
			<input type="hidden" name="basicTollPlazaPkIdlistnum" id="basicTollPlazaPkIdlistnum" value="<s:property value="pkId" />">	
			<tr>
				<td align="right" width="186" bgcolor="#F8F8F8"
					style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span class="red">*</span>收费广场老编号：</td>
				<td height="40" colspan="3" align="left"
					style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
					<input name="basicTollplazas[listnum].oldCode" id="basicTollplazas[listnum].oldCode" value="<s:property value="oldCode" />" class="shuru" type="text" size="50" /><label
									class="red" id="oldCode_error"><s:fielderror>
											<s:param>oldCode</s:param>
										</s:fielderror></label>
				</td>
			</tr>
			<tr>
				<td align="right" bgcolor="#F8F8F8"
					style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span class="red">*</span>收费广场名称：</td>
				<td height="40" colspan="3" align="left"
					style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"><input
					name="basicTollplazas[listnum].tpName" id="basicTollplazas[listnum].tpName" value="<s:property value="tpName" />" class="shuru" type="text" size="50" /><label
									class="red" id="tpName_error"><s:fielderror>
											<s:param>tpName</s:param>
										</s:fielderror></label></td>
			</tr>
			<tr>
				<td align="right" bgcolor="#F8F8F8"
					style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span class="red">*</span>收费广场类型：</td>
				<td height="40" colspan="3" align="left"
					style="border-bottom: 1px solid #BFC2CA; padding: 10px"><select
					name="basicTollplazas[listnum].tpPlazatype" id="basicTollplazas[listnum].tpPlazatype" >
						<option value="1" <s:if test="tpPlazatype==1">selected</s:if>>主线</option>
						<option value="2" <s:if test="tpPlazatype==2">selected</s:if>>匝道</option>
				</select><label
									class="red" id="tpPlazatype_error"><s:fielderror>
											<s:param>tpPlazatype</s:param>
										</s:fielderror></label></td>
			</tr>
			</s:iterator>
     		</s:if>
     		<s:else>							
			<tr>
				<td align="right" width="186" bgcolor="#F8F8F8"
					style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span class="red">*</span>收费广场老编号：</td>
				<td height="40" colspan="3" align="left"
					style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
					<input name="basicTollplazas[listnum].oldCode" id="basicTollplazas[listnum].oldCode" value="<s:property value="oldCode" />" class="shuru" type="text" size="50" /><label
									class="red" id="oldCode_error"><s:fielderror>
											<s:param>oldCode</s:param>
										</s:fielderror></label>
				</td>
			</tr>
			<tr>
				<td align="right" bgcolor="#F8F8F8"
					style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span class="red">*</span>收费广场名称：</td>
				<td height="40" colspan="3" align="left"
					style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"><input
					name="basicTollplazas[listnum].tpName" id="basicTollplazas[listnum].tpName" value="<s:property value="tpName" />" class="shuru" type="text" size="50" /><label
									class="red" id="tpName_error"><s:fielderror>
											<s:param>tpName</s:param>
										</s:fielderror></label></td>
			</tr>
			<tr>
				<td align="right" bgcolor="#F8F8F8"
					style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span class="red">*</span>收费广场类型：</td>
				<td height="40" colspan="3" align="left"
					style="border-bottom: 1px solid #BFC2CA; padding: 10px"><select
					name="basicTollplazas[listnum].tpPlazatype" id="basicTollplazas[listnum].tpPlazatype" >
						<option value="1" <s:if test="tpPlazatype==1">selected</s:if>>主线</option>
						<option value="2" <s:if test="tpPlazatype==2">selected</s:if>>匝道</option>
				</select><label
									class="red" id="tpPlazatype_error"><s:fielderror>
											<s:param>tpPlazatype</s:param>
										</s:fielderror></label></td>
			</tr>
     		</s:else>
		</table>
	</dl>
</div>