<%@page import="com.uk.sec.framework.ectable.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

    <s:hidden id="id" name="id" />
<!-- ONGL access static field: @package.class@field or @vs@field -->

    <s:textfield label="%{@vs@ALIAS_NAME}" key="name" value="%{model.name}" cssClass="" required="false" />


    <s:textfield label="%{@vs@ALIAS_UNIQUE_NAME}" key="uniqueName" value="%{model.uniqueName}" cssClass="" required="false" />


    <s:textfield label="%{@vs@ALIAS_DESCRIPTION}" key="description" value="%{model.description}" cssClass="" required="false" />

