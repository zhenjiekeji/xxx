<%@page import="com.uk.sec.privilege.framework.privilege.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

    <s:hidden id="groupId" name="groupId" />
<!-- ONGL access static field: @package.class@field or @vs@field -->

    <s:textfield label="%{@vs@ALIAS_GROUP_NAME}" key="groupName" value="%{model.groupName}" cssClass="" required="false" />


    <s:textfield label="%{@vs@ALIAS_GROUP_DESCRIPTION}" key="groupDescription" value="%{model.groupDescription}" cssClass="" required="false" />


    <s:textfield label="%{@vs@ALIAS_PARENT_ID}" key="parentId" value="%{model.parentId}" cssClass="" required="false" />


    <s:textfield label="%{@vs@ALIAS_GROUP_VIEWORDER}" key="groupVieworder" value="%{model.groupVieworder}" cssClass="required " required="true" />


    <s:textfield label="%{@vs@ALIAS_GROUP_FLAG}" key="groupFlag" value="%{model.groupFlag}" cssClass="required validate-integer max-value-32767" required="true" />

