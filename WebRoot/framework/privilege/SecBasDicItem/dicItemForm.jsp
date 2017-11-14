<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
	String path = request.getContextPath();
	String header= path+ "/framework/privilege/SecBasDicItem/header.jsp";
	String dicGroupTree = path+"/framework/privilege/SecBasDicGroup/showAllDicGroup.do?type=1";
	String dicItemList = path+"/framework/privilege/SecBasDicItem/list.do?groupId=''";
%>
<head>
    <%@ include file="/commons/meta.jsp" %>
    <link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel="stylesheet">
    <title>字典项管理</title>
</head>
<frameset rows="38,*" cols="*" framespacing="0" frameborder="no" border="0">
	<frame src="<%=header%>" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="页头"/>
	<frameset rows="*" cols="180,*" framespacing="0" frameborder="no" border="1" bordercolor="#99CCFF">
		<frame src="<%=dicGroupTree%>" id="leftFrame" name="leftFrame" noresize="noresize" title="leftFrame" />
		<frame src="<%=dicItemList%>" id="rightFrame" name="rightFrame" noresize="noresize" title="rightFrame" />
	</frameset>
</frameset>
<noframes>
<body>
</body>
</noframes>
</html>