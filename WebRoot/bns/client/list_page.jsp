<%@ page trimDirectiveWhitespaces="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.uk.sec.bns.client.model.*" %>
<%@ include file="/commons/taglibs.jsp" %>
<s:if test="#request.totalRows > 0">
	<div class="page">
		<form id="page_list"  action="${requestScope['javax.servlet.forward.request_uri']}#search"  method="post" >
			<s:if test="#parameters.size() <= 1">
				<input type="hidden"  name="ec_i"  value="<s:property value="ectableId" />" />
				<input type="hidden"  name="<s:property value="ectableId" />_crd"  value="" />
				<input type="hidden"  name="<s:property value="ectableId" />_p"  value="1" />
				<s:iterator value="#parameters" id="item" status="status">
					<s:if test="#item.key != 'notifyState'">
					<input type="hidden"  name="<s:property value="#item.key" />"  value="<s:property value="#item.value" />" />
					</s:if>
				</s:iterator>
			</s:if>
			<s:else>
				<s:iterator value="#parameters" id="item" status="status">
					<s:if test="#item.key != 'notifyState'">
					<input type="hidden"  name="<s:property value="#item.key" />"  value="<s:property value="#item.value" />" />
					</s:if>
				</s:iterator>
			</s:else>
			<s:if test="#request.page.thisPageNumber > 1">
				<a href="javascript:document.forms.page_list.<s:property value="ectableId" />_p.value='1';document.forms.page_list.setAttribute('action','${requestScope['javax.servlet.forward.request_uri']}#search');document.forms.page_list.setAttribute('method','post');document.forms.page_list.submit()">首页</a>
				<a href="javascript:document.forms.page_list.<s:property value="ectableId" />_p.value='<s:property value="#request.page.previousPageNumber" />';document.forms.page_list.setAttribute('action','${requestScope['javax.servlet.forward.request_uri']}#search');document.forms.page_list.setAttribute('method','post');document.forms.page_list.submit()">上一页</a>
			</s:if>
			<s:iterator value="#request.page.linkPageNumbers" id="m">
				<s:if test="#m == #request.page.thisPageNumber">
					<span>${m}</span>
				</s:if>
				<s:else>
					<a href="javascript:document.forms.page_list.<s:property value="ectableId" />_p.value='${m}';document.forms.page_list.setAttribute('action','${requestScope['javax.servlet.forward.request_uri']}#search');document.forms.page_list.setAttribute('method','post');document.forms.page_list.submit()">${m}</a>
				</s:else>
			</s:iterator>
			<s:if test="#request.page.thisPageNumber < #request.page.lastPageNumber">
				<a href="javascript:document.forms.page_list.<s:property value="ectableId" />_p.value='<s:property value="#request.page.nextPageNumber" />';document.forms.page_list.setAttribute('action','${requestScope['javax.servlet.forward.request_uri']}#search');document.forms.page_list.setAttribute('method','post');document.forms.page_list.submit()">下一页</a>
				<a href="javascript:document.forms.page_list.<s:property value="ectableId" />_p.value='<s:property value="#request.page.lastPageNumber" />';document.forms.page_list.setAttribute('action','${requestScope['javax.servlet.forward.request_uri']}#search');document.forms.page_list.setAttribute('method','post');document.forms.page_list.submit()">尾页</a>
			</s:if>
		</form>
	</div>
</s:if>