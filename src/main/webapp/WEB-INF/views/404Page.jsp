<%--
  Created by IntelliJ IDEA.
  User: FilinViacheslav
  Date: 01.03.2018
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>404-Page not found</title>
    <c:url var="style" value="/resources/css/notFoundStyle.css"/>
    <link rel="stylesheet" href="${style}"/>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<div class="main w3l">
    <h1>404</h1>
    <h3>"Sorry! Page not be found"</h3>
</div>
</body>
</html>