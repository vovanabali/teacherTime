<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags/page" %>
<tag:html title="Нагрузка" bodyClass="">
    <!-- button -->
    <div class="button">
        <span class="line"></span>
        <span class="line"></span>
        <span class="line"></span>
    </div>
    <!-- navbar menu -->
    <tag:navBar/>
    <!-- content -->
    <div class='content home'>
        <div class="wrapper">
            <h1>Главная</h1>
        </div>
    </div>
    <div class='content tables'>
        <div class="wrapper">
            <div class="container" id="cnt-tabs">
                <div class="tabs">
                </div>
                <div class="container-footer">
                </div>
            </div>
        </div>
    </div>
    <div class='content settings'>
        <div class="wrapper">
            <h1>Настройки</h1>
        </div>
    </div>
    <div class='content adminPanel'>
        <div class="wrapper">
            <div class="cnt-adminPanel" id="id-adminPanel">
            </div>
        </div>
    </div>
</tag:html>