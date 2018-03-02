<%--
  Created by IntelliJ IDEA.
  User: FilinViacheslav
  Date: 28.02.2018
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ attribute name="title" required="true" %>
<%@ attribute name="bodyClass" type="java.lang.String" description="String" required="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags/page" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>${title}</title>
    <link rel='stylesheet prefetch'
          href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>
    <spring:url value="/resources/css/style.css" var="style"/>
    <security:authorize access="isAnonymous()">
        <spring:url value="/resources/css/style_av.css" var="style"/>
    </security:authorize>
    <link rel="stylesheet" href="${style}">
</head>
<body class="${bodyClass}">
<jsp:doBody/>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
<spring:url value="/resources/js/index.js" var="indexJs"/>
<script src="${indexJs}"></script>
<script src="https://cdn.jsdelivr.net/npm/vue"></script>
<script src="https://cdn.jsdelivr.net/npm/vue-resource@1.4.0"></script>
</body>
</html>
