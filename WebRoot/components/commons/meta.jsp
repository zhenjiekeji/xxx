<base href="${basePath}" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<%@page import="com.uk.sec.framework.util.SettingManager"%>

<!-- optional javascript: effects.js,jquery.js -->
    <link type="text/css" href="<%=SettingManager.getInstance().getCssLinkPath()%>" rel="stylesheet" />

<!-- jQuery library begin -->
	<link type="text/css" rel="stylesheet" href="scripts/jquery/base/jquery.ui.all.css" />
    <script type="text/javascript" src="scripts/jquery/jquery-1.4.2.js"></script>
    <script type="text/javascript" src="scripts/jquery/jquery.form.js"></script>
    <script type="text/javascript" src="scripts/jquery/jquery-ui.js"></script>
    <script type="text/javascript" src="scripts/jquery/jquery.bgiframe.js"></script>
    <script type="text/javascript" src="scripts/jquery/jquery.blockUI.js"></script>
<!-- jQuery library end -->

<!-- 导入jquery　validate插件 -->
	<script type="text/javascript" src="scripts/jquery/plugins/jquery.validate.js"></script>
	<script type="text/javascript" src="scripts/jquery/plugins/jquery.metadata.js"></script>
	<script type="text/javascript" src="scripts/jquery/plugins/jquery.validate.messages_cn.js"></script>
	<script type="text/javascript" src="scripts/validateUtil.js"></script>

    <script type="text/javascript" src="scripts/application.js"></script>
    <script type="text/javascript" src="scripts/common.js"></script>

<!-- dhtmlxCalendar library begin -->
	<link rel="stylesheet" type="text/css" href="scripts/dhtmlxCalendar/dhtmlxcalendar.css" />
	<link rel="stylesheet" type="text/css" href="scripts/dhtmlxCalendar/skins/dhtmlxcalendar_dhx_skyblue.css" />
	<script  type="text/javascript" src="scripts/dhtmlxCalendar/dhtmlxcalendar.js"></script>
	<script  type="text/javascript" src="scripts/dhtmlxCalendar/dhtmlxCalendar_start.js"></script>
<!-- dhtmlxCalendar library end -->

<!-- rapid-validation BEGIN
    <link type="text/css" href="scripts/rapid-validation/validation.css" rel="stylesheet" />
    <script type="text/javascript" src="scripts/rapid-validation/prototype_for_validation.js"></script>
    <script type="text/javascript" src="scripts/rapid-validation/validation_cn.js"></script>
<!-- rapid-validation END-->