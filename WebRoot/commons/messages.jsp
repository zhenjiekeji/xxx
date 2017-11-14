<%@ include file="/commons/taglibs.jsp" %>
<c:if test="${flash.success != null||flash.info != null||flash.error != null}">
<script>
	function clearFlash(){
		$(".flash_success").fadeOut("slow");
		window.clearTimeout(clearFlashTimer);
	}
	var clearFlashTimer = window.setTimeout(clearFlash,1000);
</script>
</c:if>
<%-- Success Messages --%>
<c:if test="${flash.success != null}">
	<div class="flash_success">
		<div class="message">${flash.success}</div>
	</div>
</c:if>

<%-- Error Messages --%>
<c:if test="${flash.error != null}">
	<div class="flash_error">
		<div class="message">${flash.error}</div>
	</div>
</c:if>

<%-- Info Messages --%>
<c:if test="${flash.info != null}">
	<div class="flash_info">
		<div class="message">${flash.info}</div>
	</div>
</c:if>