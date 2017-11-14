<%@ page pageEncoding="UTF-8" language="java"%>

	<div class="function">
	
		<a href="UkClientInfo/create.do" class="kfinc">
			<dd class="suser_add"></dd>
			<dt>添加新客户</dt>
		</a>
	
		<a href="UkClientInfo/listToday.do" class="kfinc" >
			<dd class="suser_new">${todayNumber }</dd>
			<dt>新增客户数</dt>
		</a>
		
		<a href="UkClientInfo/listSearch.do" class="kfinc" style="border-right:none">
			<dd class="suser_sou"></dd>
			<dt>查找客户</dt>
		</a>
	
	</div>
	<div class="web_message">
		<a href="UkClientFlowInfo/list.do">
			<dd class="UkClientFlowInfo/list.do">${flowNumber }</dd>
			<dt>未读信息</dt>
		</a>
	</div>