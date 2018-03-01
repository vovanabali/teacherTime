<%--
  Created by IntelliJ IDEA.
  User: FilinViacheslav
  Date: 28.02.2018
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags/page" %>
<div class='menu'>
    <nav>
        <ul>
            <c:set var="isAnonimus" value="false"/>
            <security:authorize access="isAnonymous()">
                <c:set var="isAnonimus" value="true"/>
            </security:authorize>
            <li>
                <a href='#' data-class='home_is_visible'><spring:message code="NavBar.main"/></a>
            </li>
            <c:if test="${!isAnonimus}">
                <li>
                    <a href='#' data-class='tables_is_visible'><spring:message code="NavBar.doc"/></a>
                </li>
                <li>
                    <a href='#' data-class='settings_is_visible'><spring:message code="NavBar.settings"/></a>
                </li>
            </c:if>
            <security:authorize access="hasRole('ROLE_ADMIN')">
                <li>
                    <a href='#' data-class='adminPanel_is_visible'><spring:message code="NavBar.adminPage"/></a>
                </li>
            </security:authorize>
            <c:choose>
                <c:when test="${isAnonimus}">
                    <li>
                        <a href='/authorization' onclick="location.href='/authorization'"><spring:message code="NavBar.SingIn"/></a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li>
                        <a href='/exit' onclick="location.href='/exit'"><spring:message code="NavBar.logout"/></a>
                    </li>
                </c:otherwise>
            </c:choose>
        </ul>
    </nav>
</div>