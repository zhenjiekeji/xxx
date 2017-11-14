<%@page language="java" pageEncoding="UTF-8"%>
<%@include file="/commons/taglibs.jsp" %>

<div class="function">	
	<a href="ProjectInfo/add_project.do" class="xm_kfinc">
		<dd class="xm_add"></dd>
		<dt>添加新项目</dt>
	</a>

	<a href="ProjectInfo/kaifa_project.do" class="xm_kfinc">
		<dd class="xm_list"></dd>
		<dt>项目管理</dt>
	</a>

	<a href="ProjectInfo/project_search.do" class="xm_kfinc" style="border-right:none">
		<dd class="xm_sous"></dd>
		<dt>查询项目</dt>
	</a>
</div>
<div class="web_message">
	<a href="EventInfo/event.do">
		<dd class="suser_new">${count }</dd>
		<dt>未读信息</dt>
	</a>
</div>