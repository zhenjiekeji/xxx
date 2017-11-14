<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%@ include file="/commons/meta.jsp" %>
    <link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="scripts/dchktree/dchktree.js"></script>
    <link type="text/css" href="styles/dchktree/dtree.css" rel="stylesheet"/>
    <title>字典组列表</title>
</head>
<body>
	<div class="dtree">
		<script type="text/javascript">
			var displayPosition = 'rightFrame';	/* 叶子节点显示位置 */
			/**
			 * 展示可编辑节点
			 * @param id_可编辑节点ID
			 * @return String_action地址
			 */
			function dispalyLeaf(id) {
				return "${ctx}/framework/privilege/SecBasDicItem/list.do?groupId="+id;
			}

			basePath = "${ctx}/images";

			var d = new dTree("d");	/* 生成一棵树 */
			d.add(0,-1,"字典组","","","","");	/* 根节点*/
				<s:iterator value="dicGroupList">
					<s:if test="null==parentId||parentId==''">
						d.add("<s:property value='groupId'/>",0,"<s:property value='groupName'/>",dispalyLeaf("<s:property value='groupId'/>"),"",displayPosition);
					</s:if>
					<s:else>
						d.add("<s:property value='groupId'/>","<s:property value='parentId'/>","<s:property value='groupName'/>",dispalyLeaf("<s:property value='groupId'/>"),"",displayPosition);
					</s:else>
				</s:iterator>
			document.write(d);
		</script>
	</div>
</body>

</html>

