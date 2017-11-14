<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>营改增应用平台管理系统</title>
</head>
<body>
	<script>
	  <%
	  		String errorLogRecord = (String)request.getAttribute("errorLogRecord");
	  		if(errorLogRecord!=null && !"".equals(errorLogRecord)){
	  %>
	  			alert("<%=errorLogRecord%>");
	  <%
	  		}
	  %>
		window.location.href="${ctx}/loginFrame.do";
	</script>
</body>
</html>
