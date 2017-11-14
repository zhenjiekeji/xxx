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
<link rel="stylesheet" type="text/css"
	href="../../scripts/jquery-easyui-1.3.6/themes/default/easyui.css" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/jquery.inputbox.js"></script>
<script type="text/javascript" src="js/jquery.reveal.js"></script>
<script type="text/javascript"
	src="../../scripts/jquery-easyui-1.3.6/jquery.easyui.min.js"></script>

<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/additional-methods.js"></script>
<script type="text/javascript" src="js/jquery.metadata.js"></script>
<script type="text/javascript" src="js/messages_cn.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>

<script src="js/laydate/laydate.js"></script>
<script type="text/javascript" src="js/js.js"></script>

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
						<form action="BasicSection/save.do" method="post" name="frm"
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
											class="red">*</span> 路段老编号：</td>
										<td height="40" align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<input name="oldCode" id="oldCode" class="shuru" type="text"
											size="20" value="<s:property value="model.oldCode" />" /> <label
											class="red" id="oldCode_error"><s:fielderror>
													<s:param>oldCode</s:param>
												</s:fielderror></label>
										</td>
										<td width="210" align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA"><span
											class="red">*</span> 收费路段名称：</td>
										<td height="40" align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<input name="seName" id="seName" class="shuru" type="text"
											size="20" value="<s:property value="model.seName" />" /> <label
											class="red" id="seName_error"><s:fielderror>
													<s:param>seName</s:param>
												</s:fielderror></label>
										</td>
									</tr>
									<tr>
										<td width="210" align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span
											class="red">*</span> 所属收费公路编号：</td>
										<td height="40" align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<select name="seTollroadCode" id="seTollroadCode">
												<option value="1" <s:if test="seTollroadCode==1">selected</s:if>>共建省界站</option>
												<option value="2" <s:if test="seTollroadCode==2">selected</s:if>>分建省界站</option>
												<option value="3" <s:if test="seTollroadCode==3">selected</s:if>>非省界主线站</option>
												<option value="4" <s:if test="seTollroadCode==4">selected</s:if>>匝道站</option>
										</select> <label class="red" id="seTollroadCode_error"><s:fielderror>
													<s:param>seTollroadCode</s:param>
												</s:fielderror></label>
										</td>
										<td width="210" align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA">
											所属收费公路名称：</td>
										<td width="304" align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"><input
											type="text" name="seTollroadname" id="seTollroadname"
											class="shuru phonezl" size="30"
											value="<s:property value="model.seTollroadname" />" /><label
											class="red" id="seTollroadname_error"><s:fielderror>
													<s:param>seLength</s:param>
												</s:fielderror></label></td>
									</tr>
									<tr>
										<td width="210" align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span
											class="red">*</span> 路段性质：</td>
										<td height="40" align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<select name="seType" id="seType">
												<option value="1" <s:if test="seType==1">selected</s:if>>共建省界站</option>
												<option value="2" <s:if test="seType==2">selected</s:if>>分建省界站</option>
												<option value="3" <s:if test="seType==3">selected</s:if>>非省界主线站</option>
												<option value="4" <s:if test="seType==4">selected</s:if>>匝道站</option>
										</select> <label class="red" id="seType_error"><s:fielderror>
													<s:param>seType</s:param>
												</s:fielderror></label>
										</td>
										<td width="210" align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA">
											里程(单位:米)：</td>
										<td width="304" align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"><input
											type="text" name="seLength" id="seLength"
											class="shuru phonezl" size="30"
											value="<s:property value="model.seLength" />" /><label
											class="red" id="seLength_error"><s:fielderror>
													<s:param>seLength</s:param>
												</s:fielderror></label></td>
									</tr>
									<tr>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA">起始计费位置：</td>
										<td height="40" align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"><input
											class="shuru" name="seStartsite" id="seStartsite" type="text"
											size="20" value="<s:property value="model.seStartsite" />" />
											<span class="red" id="seStartsite_error"><s:fielderror>
													<s:param>seStartsite</s:param>
												</s:fielderror></span></td>
										<td width="210" align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA">起始计费位置经度：</td>
										<td width="304" align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"><input
											type="text" name="seStartlng" id="seStartlng"
											class="shuru phonezl" size="30"
											value="<s:property value="model.seStartlng" />" /></td>
									</tr>
									<tr>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA">起始计费位置纬度：</td>
										<td height="40" align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<input type="text" name="seStartlat" id="seStartlat"
											class="shuru phonezl" size="20"
											value="<s:property value="model.seStartlat" />" />
										</td>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA">起始计费位置桩号：</td>
										<td align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<input type="text" name="seStartstakenum"
											id="seStartstakenum" class="shuru phonezl" size="20"
											value="<s:property value="model.seStartstakenum" />" />
										</td>
									</tr>
									<tr>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA">终止计费位置：</td>
										<td height="40" align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<input type="text" name="seEndsite" id="seEndsite"
											class="shuru phonezl" size="20"
											value="<s:property value="model.seEndsite" />" />
										</td>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA">终止计费位置经度：</td>
										<td align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<input type="text" name="seEndlng" id="seEndlng"
											class="shuru phonezl" size="20"
											value="<s:property value="model.seEndlng" />" />
										</td>
									</tr>
									<tr>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA">终止计费位置纬度：</td>
										<td height="40" align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<input type="text" name="seEndlat" id="seEndlat"
											class="shuru phonezl" size="20"
											value="<s:property value="model.seEndlat" />" />
										</td>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA">终止计费位置桩号：</td>
										<td align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<input type="text" name="seEndstakenum" id="seEndstakenum"
											class="shuru phonezl" size="20"
											value="<s:property value="model.seEndstakenum" />" />
										</td>
									</tr>
									<tr>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA">是否纳税：</td>
										<td height="40" align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<select name="seTax" id="seTax">
												<option value="1" <s:if test="seTax==1">selected</s:if>>是</option>
												<option value="2" <s:if test="seTax==2">selected</s:if>>否</option>
										</select>
										</td>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA">路段收费方式：</td>
										<td align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<select name="seChargetype" id="seChargetype">
												<option value="1"
													<s:if test="seChargetype==1">selected</s:if>>开放式</option>
												<option value="2"
													<s:if test="seChargetype==2">selected</s:if>>封闭式</option>
												<option value="2"
													<s:if test="seChargetype==2">selected</s:if>>均一制</option>
										</select>
										</td>
									</tr>
									<tr>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA">重合收费公路编号：</td>
										<td height="40" align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<input type="text" name="seTollroads" id="seTollroads"
											class="shuru phonezl" size="20"
											value="<s:property value="model.seTollroads" />" />
										</td>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA">开工时间：</td>
										<td align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<input type="text" name="seBuilttime" id="seBuilttime"
											class="easyui-datebox"
											value="<s:property value="model.seBuilttime" />" />
										</td>
									</tr>
									<tr>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA">通车时间：</td>
										<td height="40" align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<input type="text" name="seStarttime" id="seStarttime"
											class="easyui-datebox"
											value="<s:property value="model.seStarttime" />" />
										</td>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA">停止收费时间：</td>
										<td align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<input type="text" name="seEndtime" id="seEndtime"
											class="easyui-datebox"
											value="<s:property value="model.seEndtime" />" />
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
											class="red">*</span> 路段老编号：</td>
										<td height="40" align="left" id="showOldCode"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<s:property value="model.oldCode" />
										</td>
										<td width="210" align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA"><span
											class="red">*</span> 收费路段名称：</td>
										<td height="40" align="left" id="showSeName"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<s:property value="model.seName" />
										</td>
									</tr>
									<tr>
										<td width="210" align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span
											class="red">*</span> 路段性质：</td>
										<td height="40" align="left" id="showTsType"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<s:property value="model.tsType" />
										</td>
										<td width="210" align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA">
											里程(单位:米)：</td>
										<td width="304" align="left" id="showSeLength"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"><s:property
												value="model.seLength" /></td>
									</tr>
									<tr>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA">起始计费位置：</td>
										<td height="40" align="left" id="showSeStartsite"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"><s:property
												value="model.seStartsite" /></td>
										<td width="210" align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA">起始计费位置经度：</td>
										<td width="304" align="left" id="showSeStartlng"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"><s:property
												value="model.seStartlng" /></td>
									</tr>
									<tr>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA">起始计费位置纬度：</td>
										<td height="40" align="left" id="showSeStartlng"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<s:property value="model.seStartlat" />
										</td>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA">起始计费位置桩号：</td>
										<td align="left" id="showSeStartstakenum"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<s:property value="model.seStartstakenum" />
										</td>
									</tr>
									<tr>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA">终止计费位置：</td>
										<td height="40" align="left" id="showSeEndsite"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<s:property value="model.seEndsite" />
										</td>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA">终止计费位置经度：</td>
										<td align="left" id="showSeEndlng"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<s:property value="model.seEndlng" />
										</td>
									</tr>
									<tr>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA">终止计费位置纬度：</td>
										<td height="40" align="left" id="showSeEndlat"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<s:property value="model.seEndlat" />
										</td>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA">终止计费位置桩号：</td>
										<td align="left" id="showSeEndstakenum"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<s:property value="model.seEndstakenum" />
										</td>
									</tr>
									<tr>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA">是否纳税：</td>
										<td height="40" align="left" id="showSeTax"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<s:property value="model.seTax" />
										</td>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA">路段收费方式：</td>
										<td align="left" id="showSeChargetype"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<s:property value="model.seChargetype" />
										</td>
									</tr>
									<tr>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA">重合收费公路编号：</td>
										<td height="40" align="left" id="showSeTollroads"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<s:property value="model.seTollroads" />
										</td>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA">开工时间：</td>
										<td align="left" id="showSeBuilttime"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<s:property value="model.seBuilttime" />
										</td>
									</tr>
									<tr>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA">通车时间：</td>
										<td height="40" align="left" id="showSeStarttime"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<s:property value="model.seStarttime" />
										</td>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA">停止收费时间：</td>
										<td align="left" id="showSeEndtime"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<s:property value="model.seEndtime" />
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
								</table>
							<div class="fatie" id="fatie">
								<div class="options"></div>
							</div>
							<!-- <a href="javascript:void(0);" value="1" class="submit"><button
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
											b = demandHTML
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
						//保存管理处基本信息
						$("#saveBase")
								.click(
										function() {
											var pkId = $("#pkId").val();
											var menuId = $("#menuId").val();
											var oldCode = $("#oldCode").val();
											if (oldCode == ""
													|| oldCode == null) {
												alert("路段老编号不允许为空!");
												return;
											}
											var seName = $("#seName").val();
											if (seName == "" || seName == null) {
												alert("收费路段名称不允许为空!");
												return;
											}
											var seType = $("#seType").val();
											var seTax = $("#seTax").val();
											var seChargetype = $("#seChargetype").val();
											if (seType == "" || seType == null) {
												alert("路段性质不允许为空!");
												return;
											}
											if (seTax == "" || seTax == null) {
												alert("是否纳税不允许为空!");
												return;
											}
											if (seChargetype == ""
													|| seChargetype == null) {
												alert("路段收费方式不允许为空!");
												return;
											}
											var seLength = $("#seLength").val();
											var seStartsite = $("#seStartsite")
													.val();
											var seStartlng = $("#seStartlng")
													.val();
											var seStartlat = $("#seStartlat")
													.val();
											var seStartstakenum = $(
													"#seStartstakenum").val();
											var seEndlng = $("#seEndlng").val();
											var seEndlat = $("#seEndlat").val();
											var seBuilttime = $("#seBuilttime")
													.val();
											var seStarttime = $("#seStarttime")
													.val();
											var seEndtime = $("#seEndtime")
													.val();
											var remarks = $("#remarks").val();
											var basicSection = {
												"model.pkId" : pkId,
												"model.menuId" : menuId,
												"model.oldCode" : oldCode,
												"model.seName" : seName,
												"model.seType" : seType,
												"model.seTax" : seTax,
												"model.seChargetype" : seChargetype,
												"model.seLength" : seLength,
												"model.seStartsite" : seStartsite,
												"model.seStartlng" : seStartlng,
												"model.seStartlat" : seStartlat,
												"model.seStartstakenum" : seStartstakenum,
												"model.seEndlng" : seEndlng,
												"model.seEndlat" : seEndlat,
												"model.seBuilttime" : seBuilttime,
												"model.seStarttime" : seStarttime,
												"model.seEndtime" : seEndtime,
												"model.remarks" : remarks
											};
											$.ajax({
												type : "POST",
												url : "BasicSection/saveByAjax.do",
												dataType : "json",
												data : basicSection,
												async : false,
												cache : false,
												success : function(res) {
													if (res.result != "fail") {
														alert("添加成功");
														$("#pkId").val(res.result);
														//重新加载基本信息
														$("#showBaseInfo").show();
														$("#addBaseInfo").hide();
														$("#showSeName").html(seName);
														$("#showSeType").html(seType);
														$("#showSeTax").html(seTax);
														$("#showSeChargetype").html(seChargetype);
														$("#showSeLength").html(seLength);
														$("#showSeStartsite").html(seStartsite);
														$("#showSeStartlng").html(seStartlng);
														$("#showSeStartlat").html(seStartlat);
														$("#showSeStartstakenum").html(seStartstakenum);
														$("#showSeEndlng").html(seEndlng);
														$("#showSeEndlat").html(seEndlat);
														$("#showSeBuilttime").html(seBuilttime);
														$("#showSeStarttime").html(seStarttime);
														$("#showSeEndtime").html(seEndtime);
														$("#showRemarks").html(remarks);
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
								url : "BasicSection/deleteByAjax.do",
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

						//保存收费站信息
						$("#saveStation").click(function() {
								if ($("#pkId").val() == "") {
									alert("请先添加基本信息");
									return;
								}
								//Ajax调用处理
								var array = [];
								var fatie = $("#fatie");
								var option = fatie.find("table");
								var flg = false;
								option.each(function(index, val) {
									var stationPkId = $("#basicTollStationPkId"+index).val();
									var txt = "";
									$(this).find("tr:gt(0)").each(function(sx,val) {
											var tdArr = $(this).children();
											if (sx == 2) {
												if (tdArr.eq(1).find('select').val() == "") {
													flg = true;
												}
												txt += tdArr.eq(1).find('select').val()+ ",";//收入金额
											} else {
												if (tdArr.eq(1).find('input').val() == "") {
														flg = true;
												}
												txt += tdArr.eq(1).find('input').val()+ ",";//收入金额
											}
								});
								var txtArr = txt.split(",");
								var temp = {
									"pkId":stationPkId,
									"tsCode" : txtArr[0],
									"tsName" : txtArr[1],
									"tsType" : Number(txtArr[2])
								};
								array.push(temp);
							});
											if (flg == true) {
												alert("必填项不允许为空");
												return;
											}
											var basicTollroads = JSON.stringify(array);
											$.ajax({
												type : "POST",
												url : "BasicSection/saveTollstation.do?menuId="+ $("#menuId").val()+ "&pkId="+ $("#pkId").val(),
												dataType : "json",
												data : {
													"jsonarray" : basicTollroads
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
						//var tree = $("#tree");
						//$("#tree").tree("expand");  //展开点击的文本的子节点
						//alert(tree);
						//$('#'+menuCss).css("background", '#FF8000');
					});
</script>