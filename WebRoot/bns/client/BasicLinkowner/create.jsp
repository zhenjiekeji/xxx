<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>营改增管理系统</title>
<base href="${ctx}/bns/client/" />

<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/jquery.inputbox.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="../../scripts/jquery-easyui-1.3.6/themes/default/easyui.css" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/jquery.inputbox.js"></script>
<script type="text/javascript" src="js/jquery.reveal.js"></script>
<script type="text/javascript" src="../../scripts/jquery-easyui-1.3.6/jquery.easyui.min.js"></script>

<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/additional-methods.js"></script>
<script type="text/javascript" src="js/jquery.metadata.js"></script>
<script type="text/javascript" src="js/messages_cn.js"></script>

<script src="js/laydate/laydate.js"></script>
<script type="text/javascript" src="js/js.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>

</head>

<body>
	<%@ include file="../head.jsp"%>

	<div class="nrv">
		<div class="nrvs">
			<%@ include file="../left.jsp"%>
			<div class="neir">
				<input type="hidden" name="menuId" id="menuId"
					value="<s:property value='menuId'/>">
					<div style="float: left">
						<form action="BasicLinkowner/save.do" method="post" name="frm"
							id="frm">
							<input type="hidden" name="pkId" id="pkId"
								value="<s:property value='model.pkId'/>">
								<table id="addBaseInfo" width="940" border="0" align="center"
									cellpadding="0" cellspacing="0"
									style="border: 1px solid #BFC2CA; border-bottom: none; font-family: 微软雅黑; font-size: 14px; margin-top: 20px; display: none"
									class="scxxa">
									<tr>
										<td height="40" colspan="3" align="left" bgcolor="#FFFFFF"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"
											class="numbers"><strong>基本信息</strong></td>
										<td height="40" align="right" bgcolor="#FFFFFF"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px"
											class="add_opt">
											<div class="demand_add">
												<span style="cursor: pointer" title="保存" id="saveBase"><img
													src="images/filesave.png" align="absmiddle" /> 保存</span>
											</div>
										</td>
									</tr>
									<tr>
										<td width="210" align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span
											class="red">*</span> 管理处名称：</td>
										<td height="40" align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<input name="loName" id="loName" class="shuru" type="text"
											size="20" value="<s:property value="model.loName" />" /> <label
											class="red" id="loName_error"><s:fielderror>
													<s:param>loName</s:param>
												</s:fielderror></label>
										</td>
										<td width="210" align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA"><span
											class="red">*</span> 联系人姓名：</td>
										<td height="40" align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<input name="loContact" id="loContact" class="shuru"
											type="text" size="20"
											value="<s:property value="model.loContact" />" /> <label
											class="red" id="loContact_error"><s:fielderror>
													<s:param>loContact</s:param>
												</s:fielderror></label>
										</td>
									</tr>
									<tr>
										<%-- <td align="right" bgcolor="#F8F8F8"
									style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span
									class="red">*</span> <span style="cursor: pointer"
									class="add_umore" title="添加首要联系人"><img
										src="images/add.gif" align="absmiddle" /></span> 首要联系人：</td>
								<td width="303" height="40" align="left"
									style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"><input
									type="text" class="shuru" name="firstContact"
									id="firstContact1"
									value="<s:property value="ukClientVo.firstContact[0]" />" /> <span
									class="red" id="firstContact_error"><s:fielderror>
											<s:param>firstContact</s:param>
										</s:fielderror></span></td> --%>
										<td width="210" align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span
											class="red">*</span> 联系电话：</td>
										<td height="40" align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<input name="loTel" id="loTel" class="shuru" type="text"
											size="20" value="<s:property value="model.loTel" />" /> <label
											class="red" id="loTel_error"><s:fielderror>
													<s:param>loTel</s:param>
												</s:fielderror></label>
										</td>
										<td width="210" align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA"><span
											class="red">*</span> 地址：</td>
										<td width="304" align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"><input
											type="text" name="loAddress" id="loAddress"
											class="shuru phonezl" size="30"
											value="<s:property value="model.loAddress" />" /><label
											class="red" id="loAddress_error"><s:fielderror>
													<s:param>loAddress</s:param>
												</s:fielderror></label></td>
									</tr>
									<tr>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA">开户行：</td>
										<td height="40" align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"><input
											class="shuru" name="loBank" id="loBank" type="text" size="20"
											value="<s:property value="model.loBank" />" /> <span
											class="red" id="loBank_error"><s:fielderror>
													<s:param>loBank</s:param>
												</s:fielderror></span></td>
										<td width="210" align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA">开户行地址：</td>
										<td width="304" align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"><input
											type="text" name="loBankadd" id="loBankadd"
											class="shuru phonezl" size="30"
											value="<s:property value="model.loBankadd" />" /></td>
									</tr>
									<tr>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA">开户行账号：</td>
										<td height="40" align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<input type="text" name="loBankaccount" id="loBankaccount"
											class="shuru phonezl" size="20"
											value="<s:property value="model.loBankaccount" />" />
										</td>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA">纳税人识别号：</td>
										<td align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<input type="text" name="loTaxpayerCodeentification"
											id="loTaxpayerCodeentification" class="shuru phonezl"
											size="20"
											value="<s:property value="model.loTaxpayerCodeentification" />" />
										</td>
									</tr>
									<tr>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA">统一社会信用代码：</td>
										<td height="40" align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<input type="text" name="loCreditcode" id="loCreditcode"
											class="shuru phonezl" size="20"
											value="<s:property value="model.loCreditcode" />" />
										</td>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA">法定代表人：</td>
										<td align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<input type="text" name="loRepresentative"
											id="loRepresentative" class="shuru phonezl" size="20"
											value="<s:property value="model.loRepresentative" />" />
										</td>
									</tr>
									<tr>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA">管理处老编码：</td>
										<td height="40" align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<input type="text" name="oldCode" id="oldCode"
											class="shuru phonezl" size="20"
											value="<s:property value="model.oldCode" />" />
										</td>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA">管理处新编码：</td>
										<td align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<input type="text" name="loCode"
											id="loCode" class="shuru phonezl" size="20"
											value="<s:property value="model.loCode" />" />
										</td>
									</tr>
									<tr>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA">备注：</td>
										<td height="40" colspan="3" align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<input name="remarks" id="remarks" class="shuru" type="text"
											size="50" value="<s:property value="model.remarks" />" /> <span
											class="red" id="remarks_error"><s:fielderror>
													<s:param>remarks</s:param>
												</s:fielderror></span>
										</td>
									</tr>
								</table>
								<table id="showBaseInfo" width="940" border="0" align="center"
									cellpadding="0" cellspacing="0"
									style="border: 1px solid #BFC2CA; border-bottom: none; font-family: 微软雅黑; font-size: 14px; margin-top: 20px; display: none">
									<tr>
										<td height="40" colspan="3" align="left" bgcolor="#FFFFFF"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"
											class="numbers"><strong>基本信息</strong></td>
										<td height="40" align="right" bgcolor="#FFFFFF"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px"
											class="add_opt">
											<div class="demand_add">
												<span style="cursor: pointer" id="showBase" title="修改基本信息"><img
													src="images/pencil.png" align="absmiddle" /> 修改</span>&nbsp;&nbsp;
												<c:if test="${model.pkId !=''}">
													<span style="cursor: pointer" id="deleteBase"
														title="删除基本信息"><img src="images/cancel.png"
														align="absmiddle" /> 删除</span>
												</c:if>
											</div>
										</td>
									</tr>
									<tr>
										<td width="210" align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span
											class="red">*</span> 管理处名称：</td>
										<td height="40" align="left" id="showLoName"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"><s:property
												value="model.loName" /></td>
										<td width="210" align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA"><span
											class="red">*</span> 联系人姓名：</td>
										<td height="40" align="left" id="showLoContact"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<s:property value="model.loContact" />
										</td>
									</tr>
									<tr>
										<td width="210" align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span
											class="red">*</span> 联系电话：</td>
										<td height="40" align="left" id="showLoTel"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<s:property value="model.loTel" />
										</td>
										<td width="210" align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA"><span
											class="red">*</span> 地址：</td>
										<td width="304" align="left" id="showLoAddress"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"><s:property
												value="model.loAddress" /></td>
									</tr>
									<tr>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA">开户行：</td>
										<td height="40" align="left" id="showLoBank"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"><s:property
												value="model.loBank" /></td>
										<td width="210" align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA">开户行地址：</td>
										<td width="304" align="left" id="showLoBankadd"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"><s:property
												value="model.loBankadd" /></td>
									</tr>
									<tr>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA">开户行账号：</td>
										<td height="40" align="left" id="showLoBankaccount"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<s:property value="model.loBankaccount" />
										</td>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA">纳税人识别号：</td>
										<td align="left" id="showLoTaxpayerCodeentification"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<s:property value="model.loTaxpayerCodeentification" />
										</td>
									</tr>
									<tr>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA">统一社会信用代码：</td>
										<td height="40" align="left" id="showLoCreditcode"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<s:property value="model.loCreditcode" />
										</td>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA">法定代表人：</td>
										<td align="left" id="showLoRepresentative"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<s:property value="model.loRepresentative" />
										</td>
									</tr>
									<tr>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA">备注：</td>
										<td height="40" colspan="3" align="left" id="showRemarks"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<s:property value="model.remarks" />
										</td>
									</tr>
								</table> <input type="hidden" name="liPkId" id="liPkId"
								value="<s:property value='model.basicLinkinvestor.pkId'/>">
									<table id="addDeptInfo" width="940" border="0" align="center"
										cellpadding="0" cellspacing="0"
										style="border: 1px solid #BFC2CA; border-bottom: none; font-family: 微软雅黑; font-size: 14px; margin-top: 20px; display: none"
										class="scxxa">
										<tr>
											<td height="40" colspan="3" align="left" bgcolor="#FFFFFF"
												style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"
												class="numbers"><strong>上级单位</strong></td>
											<td height="40" align="right" bgcolor="#FFFFFF"
												style="border-bottom: 1px solid #BFC2CA; padding-right: 10px"
												class="add_opt">
												<div class="demand_add">
													<span style="cursor: pointer" title="保存" id="saveDept"><img
														src="images/filesave.png" align="absmiddle" /> 保存</span>
												</div>
											</td>
										</tr>
										<tr>
											<td width="210" align="right" bgcolor="#F8F8F8"
												style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span
												class="red">*</span> 上级单位编码：</td>
											<td height="40" align="left"
												style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
												<input name="liCode" id="liCode" class="shuru" type="text"
												size="20"
												value="<s:property value="model.basicLinkinvestor.liCode" />" />
												<label class="red" id="liCode_error"><s:fielderror>
														<s:param>liCode</s:param>
													</s:fielderror></label>
											</td>
											<td width="210" align="right" bgcolor="#F8F8F8"
												style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA"><span
												class="red">*</span> 上级单位全称：</td>
											<td height="40" align="left"
												style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
												<input name="liName" id="liName" class="shuru" type="text"
												size="20"
												value="<s:property value="model.basicLinkinvestor.liName" />" />
												<label class="red" id="liName_error"><s:fielderror>
														<s:param>liName</s:param>
													</s:fielderror></label>
											</td>
										</tr>
									</table>
									<table id="showDeptInfo" width="940" border="0" align="center"
										cellpadding="0" cellspacing="0"
										style="border: 1px solid #BFC2CA; border-bottom: none; font-family: 微软雅黑; font-size: 14px; margin-top: 20px; display: none"
										class="scxxa">
										<tr>
											<td height="40" colspan="3" align="left" bgcolor="#FFFFFF"
												style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"
												class="numbers"><strong>上级单位</strong></td>
											<td height="40" align="right" bgcolor="#FFFFFF"
												style="border-bottom: 1px solid #BFC2CA; padding-right: 10px"
												class="add_opt">
												<div class="demand_add">
													<span style="cursor: pointer" id="showDept" title="修改上级单位"><img
														src="images/pencil.png" align="absmiddle" /> 修改</span>&nbsp;&nbsp;
													<c:if test="${model.basicLinkinvestor.pkId !=''}">
													<span style="cursor: pointer" id="deleteDept"
														title="删除上级单位"><img src="images/cancel.png"
														align="absmiddle" /> 删除</span>
													</c:if>
												</div>
											</td>
										</tr>
										<tr>
											<td width="210" align="right" bgcolor="#F8F8F8"
												style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span
												class="red">*</span> 上级单位编码：</td>
											<td height="40" align="left" id="showLiCode"
												style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"><s:property
													value="model.basicLinkinvestor.liCode" /></td>
											<td width="210" align="right" bgcolor="#F8F8F8"
												style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA"><span
												class="red">*</span> 上级单位全称：</td>
											<td width="304" height="40" align="left" id="showLiName"
												style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
												<s:property value="model.basicLinkinvestor.liName" />
											</td>
										</tr>
									</table>
									<div class="fatie" id="fatie">
										<div class="options"></div>
									</div> <!-- <a href="javascript:void(0);" value="1" class="submit"><button
											class="enters">保存</button></a> -->
						</form>
					</div>
			</div>
		</div>
		<%@ include file="../foot.jsp"%>
		<%@ include file="create_add.jsp"%>
	</div>
</body>
</html>
<script type="text/javascript">
	$(document)
			.ready(
					function() {//选项增减控制
						var menuCss = "<s:property value='#request.menuId'/>";
						var demandHTML = $('#demand').html();
						var fatie = $("#fatie");
						var option = fatie.find(".options dl");
						var j = option.length + 1;
						add(j);
						function list_again() {//选项重新排序
							option.each(function() {
								var i = $(this).index();
								$(this).find("em").html(i + 1);
							});
						}
						fatie
								.find(".add_opt span")
								.click(
										function() {//增加选项
											j = option.length + 2;
										    var demandNewHTML = $("#demandNew").html();
											b = demandNewHTML
													.replace(
															eval("/NUMBERID/gi"),
															j)
													.replace(
															eval("/listnum/gi"),
															option.length);
											fatie.find(".options").append(b);
											$("#demand" + j + "").show();
											$("#demand" + j + " .demand_del")
													.show();
											$("#demand" + j + " .demand_add")
													.hide();
											option = fatie.find(".options dl");
											list_again();
										});
						option.find("a").live(
								"click",
								function() {//删除选项
									$(this).parent().parent().parent().parent()
											.parent().parent().parent()
											.remove();
									list_again();
								});
						//初始化基础信息1
						function add(j) {
							var b = demandHTML.replace(eval("/NUMBERID/gi"), j)
									.replace(eval("/listnum/gi"), j - 1);
							$(".options").append(b);
							$("#demand" + j + "").show();
							$("#demand" + j + " .demand_del").hide();
							$("#demand" + j + " .demand_add").show();
							$("#demand" + j + " .demand_add").show();
							option = fatie.find(".options dl");
							list_again();
						}
						//初始化页面内容
						$("#addBase").click(function() {
							$("#showBaseInfo").show();
							$("#addBaseInfo").hide();

						});
						$("#showBase").click(function() {
							$("#addBaseInfo").show();
							$("#showBaseInfo").hide();
						});
						if ($("#pkId").val() != "")
							$("#showBaseInfo").show();
						else
							$("#addBaseInfo").show();
						$("#addDept").click(function() {
							$("#showDeptInfo").show();
							$("#addDeptInfo").hide();
						});
						$("#showDept").click(function() {
							$("#addDeptInfo").show();
							$("#showDeptInfo").hide();
						});
						if ($("#liCode").val() != "")
							$("#showDeptInfo").show();
						else
							$("#addDeptInfo").show();
						//保存管理处基本信息
						$("#saveBase")
								.click(
										function() {
											var pkId = $("#pkId").val();
											var menuId = $("#menuId").val();
											var loName = $("#loName").val();
											if (loName == "" || loName == null) {
												alert("管理处名称不允许为空!");
												return;
											}
											var loContact = $("#loContact")
													.val();
											if (loContact == ""
													|| loContact == null) {
												alert("联系人不允许为空!");
												return;
											}
											var loTel = $("#loTel").val();
											if (loTel == "" || loTel == null) {
												alert("联系电话不允许为空!");
												return;
											}
											var loAddress = $("#loAddress")
													.val();
											if (loAddress == ""
													|| loAddress == null) {
												alert("地址不允许为空!");
												return;
											}
											var loBank = $("#loBank").val();
											var loBankadd = $("#loBankadd")
													.val();
											var loBankaccount = $(
													"#loBankaccount").val();
											var loTaxpayerCodeentification = $(
													"#loTaxpayerCodeentification")
													.val();
											var loCreditcode = $(
													"#loCreditcode").val();
											var loRepresentative = $(
													"#loRepresentative").val();
											var remarks = $("#remarks").val();
											var basicLinkowner = {
												"model.pkId" : pkId,
												"model.menuId" : menuId,
												"model.loName" : loName,
												"model.loContact" : loContact,
												"model.loTel" : loTel,
												"model.loAddress" : loAddress,
												"model.loBank" : loBank,
												"model.loBankadd" : loBankadd,
												"model.loBankaccount" : loBankaccount,
												"model.loTaxpayerCodeentification" : loTaxpayerCodeentification,
												"model.loCreditcode" : loCreditcode,
												"model.loRepresentative" : loRepresentative,
												"model.remarks" : remarks
											};
											//Ajax调用处理
											$
													.ajax({
														type : "POST",
														url : "BasicLinkowner/saveByAjax.do?menuId="+menuId,
														dataType : "json",
														data : basicLinkowner,
														async : false,
														cache : false,
														success : function(res) {
															if (res.result != "fail") {
																alert("添加成功");
																$("#pkId")
																		.val(
																				res.result);
																//重新加载基本信息
																$(
																		"#showBaseInfo")
																		.show();
																$(
																		"#addBaseInfo")
																		.hide();
																$("#showLoName")
																		.html(
																				loName);
																$(
																		"#showLoContact")
																		.html(
																				loContact);
																$("#showLoTel")
																		.html(
																				loTel);
																$(
																		"#showLoAddress")
																		.html(
																				loAddress);
																$("#showLoBank")
																		.html(
																				loBank);
																$(
																		"#showLoBankadd")
																		.html(
																				loBankadd);
																$(
																		"#showLoBankaccount")
																		.html(
																				loBankaccount);
																$(
																		"#showLoTaxpayerCodeentification")
																		.html(
																				loTaxpayerCodeentification);
																$(
																		"#showLoCreditcode")
																		.html(
																				loCreditcode);
																$(
																		"#showLoRepresentative")
																		.html(
																				loRepresentative);
																$(
																		"#showRemarks")
																		.html(
																				remarks);
															}
														},
														error : function() {
															alert("添加失败");
														}
													});
										});
						//删除基本信息
						$("#deleteBase").click(function() {
							//Ajax调用处理
							$.ajax({
								type : "POST",
								url : "BasicLinkowner/deleteByAjax.do",
								dataType : "json",
								data : {
									"pkId" : $("#pkId").val()
								},
								async : false,
								cache : false,
								success : function(res) {
									if (res.result != "fail") {
										alert("删除成功");
										$("#pkId").val("");
										$("#showBaseInfo").hide();
										$("#addBaseInfo").show();
									}
								},
								error : function() {
									alert("删除失败");
								}
							});
						});
						//保存上级单位信息
						$("#saveDept")
								.click(
										function() {
											var liPkId = $("#liPkId").val();
											var liCode = $("#liCode").val();
											if (liCode == "" || liCode == null) {
												alert("上级单位编码不允许为空!");
												return;
											}
											var liName = $("#liName").val();
											if (liName == "" || liName == null) {
												alert("上级单位名称不允许为空!");
												return;
											}
											var basicLinkinvestor = {
												"basicLinkinvestor.liCode" : liCode,
												"basicLinkinvestor.liName" : liName
											};
											//Ajax调用处理
											$.ajax({
														type : "POST",
														url : "BasicLinkowner/saveDeptByAjax.do?liPkId="+liPkId+"&pkId="+$("#pkId").val(),
														dataType : "json",
														data : basicLinkinvestor,
														async : false,
														cache : false,
														success : function(res) {
															if (res.result != "fail") {
																alert("添加成功");
																$("#liPkId")
																		.val(
																				res.result);
																//重新加载基本信息
																$(
																		"#showDeptInfo")
																		.show();
																$(
																		"#addDeptInfo")
																		.hide();
																$("#showLiCode")
																		.html(
																				liCode);
																$("#showLiName")
																		.html(
																				liName);
															}
														},
														error : function() {
															alert("添加失败");
														}
													});
										});
						
						//保存路段信息
						$("#saveSection").click(function(){
							if($("#pkId").val() == "") {
								alert("请先添加基本信息以及上级单位信息");
								return;
							}
							//Ajax调用处理
							var array = [];
							var fatie = $("#fatie");
							var option = fatie.find("table tr:gt(0)");
							var flg = false;
							option.each(function(index, val) {
									//var i = $(this).index();	
									var sectionPkId = $("#basicSectionPkId"+index).val();
							        var tdArr = $(this).children();
							        var trName = tdArr.eq(1).find('input').val();
							        var startNum = tdArr.eq(3).find('input').val();
							        var endNum = tdArr.eq(5).find('input').val();
							        if(trName =="" || startNum =="" || endNum==""){
							        	flg = true;
							        	return;
							        }
									var temp = {"pkId":sectionPkId,"trName":trName,"seStartstakenum":startNum,"seEndstakenum":endNum};
									array.push(temp);	 
							});
							if(flg == true){
								alert("必填项不允许为空");
								return;
							}
							var basicSections=JSON.stringify(array);
							$.ajax({
								type : "POST",
								url : "BasicLinkowner/saveSection.do?menuId="+$("#menuId").val()+"&pkId="+$("#pkId").val(),
								dataType : "json",
								data : {
									"jsonarray" : basicSections
								},
								success : function(res) {
									if (res.result != "fail") {
										alert("添加成功");
									}
								},
								error : function() {
									alert("添加失败");
								}
							});
						});
						$('#'+menuCss).css("background", '#FF8000');
					});
</script>