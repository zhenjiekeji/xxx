<%@ page pageEncoding="UTF-8" language="java"%>
<!DOCTYPE HTML>
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/taglibs.jsp" %>
<%@ include file="/commons/meta.jsp" %>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
	<script type="text/javascript">
	    $(document).ready(function(){
			var channel=request('channel');

			var agentWorkId=request('agentWorkId');

			if(channel){
				var see="ul[channel='"+channel+"']";
				$(see).show().children("li").first().attr("class","sel");
				if(!agentWorkId){
					$(see).show().find("a").filter("a[target='mainFrame']")[0].click();
					$(see).show().find("a").filter("a[target='mainFrame']").eq(0).attr("class","sel");
				}else{
					$("#"+agentWorkId).attr("class","sel");
				}
			}
			$(".sideNav ul:visible a").live("click",function(){
				if($(this).siblings("ul").length !=0){
					$(this).siblings("ul").slideToggle("fast");
				}
				else{
					$(".sel").removeClass("sel")
					$(this).attr("class","sel")
				}
			});
		});
	</script>
</head>

<body style="background:#f3f3f3;">
<div class="sideNav">
<!-- <div class="menuIcon"></div> -->

<c:forEach items="${sessionScope.user_view.userData.secondLevelMenus}" var="topmenu" varStatus="s1">
<ul channel="${topmenu.key}">
	<c:forEach items="${topmenu.value}" var="secondMenu" varStatus="s2">
	<c:choose>
		<c:when test="${secondMenu.menuHaveson}">
			<c:forEach items="${sessionScope.user_view.userData.thirdLevelMenus}" var="thirdMenu" varStatus="s3">
				<c:choose>
					<c:when test="${thirdMenu.key==secondMenu.menuId}">
						<li><a href="javascript:void(0)">${secondMenu.menuTitle}</a>
						<ul>
						<c:forEach items="${thirdMenu.value}" var="thirdSonmenu" varStatus="s4">
		            		<li><a id="${thirdSonmenu.menuId}" href="${thirdSonmenu.menuUrl}?menuId=${thirdSonmenu.menuId}" target="mainFrame">${thirdSonmenu.menuTitle}</a></li>
		            	</c:forEach>
		            	</ul>
						</li>
					</c:when>
				</c:choose>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<li><a id="${secondMenu.menuId}" href="${secondMenu.menuUrl}?menuId=${secondMenu.menuId}" target="mainFrame">${secondMenu.menuTitle}</a></li>
		</c:otherwise>
	</c:choose>
	</c:forEach>
</ul>
</c:forEach>
</div>
</body>
</html>
