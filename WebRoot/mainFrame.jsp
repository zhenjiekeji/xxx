<%@ page pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="/commons/taglibs.jsp" %>
<title></title>
</head>

<frameset rows="114,*,30" cols="*" framespacing="0" frameborder="no" border="0">

  <frame src="${ctx}/head.jsp" name="topFrame" id="topFrame" title="页头" />
  <frameset rows="*" cols= "200,9,*"  framespacing="0" frameborder="no" border="0" id="middlezone">
		  <frame src="${ctx}/menuTree.jsp?channel=${user_view.userData.topDisplayMenu[0].menuVieworder}" name="leftFrame" noresize="noresize" id="leftFrame" title="左侧导航栏" />
		  <frame src="${ctx}/f5.htm" name="middlezone" id="middlezone" title="middlezone" />
		  <frame src="${ctx}/base.jsp" name="mainFrame" id="mainFrame" title="mainFrame"/>

  </frameset>

  <frame src="${ctx }/foot.jsp" name="bottomFrame" scrolling="no" noresize="noresize" id="bottomFrame" title="页脚" />

</frameset>
<noframes>
<body>
</body>
</noframes>
</html>