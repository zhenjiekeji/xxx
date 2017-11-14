<%--
  Created by IntelliJ IDEA.
  User: zx
  Date: 2010-12-19
  Time: 11:07:28
  To change this template use File | Settings | File Templates.
--%>
<style>
<!--
div.left-part {
    float: left;
    width: 49%;
}

div.right-part {
    float: right;
    width: 49%;
}
-->
</style>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/commons/taglibs.jsp" %>


            <div class="left-part" style="height:250px; overflow:auto; width: 70%; border-right:1px solid #ccc;">
                <ul id="propSelectMenu" style="list-style:none; text-align:left;">
                    <s:iterator value="%{#request.ecdlist}">
                        <li style=" line-height:18px;">
                            <s:hidden name="ids" value="id=%{id}"/>
                            <s:checkbox name="columnShows" fieldValue="show=%{id}" value="%{showStatus}" cssClass="%{columnName}"/><s:property
                                value="displayName"/>
                            <s:hidden name="orderNums" value="order=%{orderNum}"/>
                        </li>
                    </s:iterator>

                </ul>
            </div>
            <div class="right-part" style="width: 29%;">
                <ul style="list-style:none; text-align:center;">
                    <li>
                        <button type="button" class="standard-button" id="moveTop">置顶</button>
                    </li>
                    <li>
                        <button type="button" class="standard-button" id="moveUp">上移</button>
                    </li>
                    <li>
                        <button type="button" class="standard-button" id="moveDown">下移</button>
                    </li>
                    <li>
                        <button type="button" class="standard-button" id="moveBottom">置底</button>
                    </li>
                </ul>
            </div>
