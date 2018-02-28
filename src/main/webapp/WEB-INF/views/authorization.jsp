<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags/page" %>
<tag:html title="Авторизация" bodyClass="body-authorization">
    <div id="line">
        <div class="circle-right" id="rightHandle"></div>
        <div class="circle-left active show" id="leftHandle"></div>
    </div>
    <div id="line-section">
        <section id="cnt-line1">
            <h1><spring:message code="Autorization.autLabel"/></h1>
            <form method="post" action="login" class="login">
                <p>
                    <label for="login"><spring:message code="User.login"/>:</label>
                    <input type="text" name="username" id="login">
                </p>
                <p>
                    <label for="password"><spring:message code="User.password"/>:</label>
                    <input type="password" name="password" id="password">
                </p>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <p class="login-submit">
                    <button type="submit" class="login-button"><spring:message code="Autorization.SingIn"/></button>
                </p>
                <p class="forgot-password"><a href="#"><spring:message code="Autorization.missPas"/></a></p>
            </form>
        </section>
        <section id="cnt-line2">
            <h1><spring:message code="Autorization.registr"/></h1>
            <form method="post" action="" class="registr">
                <p>
                    <label for="name"><spring:message code="SendAuthQuery.fio"/>:</label>
                    <input type="text" name="name" id="name">
                </p>
                <p>
                    <label for="mail"><spring:message code="SendAuthQuery.mail"/>:</label>
                    <input type="text" name="mail" id="mail">
                </p>
                <p class="registr-submit">
                    <button type="submit" class="registr-button"><spring:message code="SendAuthQuery.send"/></button>
                </p>
            </form>
        </section>
        <c:if test="${error}">
            <div class="error">
                <p><spring:message code="bedAutentification"/></p>
            </div>
        </c:if>
    </div>
</tag:html>