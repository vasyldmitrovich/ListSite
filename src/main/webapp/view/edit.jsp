<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <title>Список справ</title>
</head>
<body>
<header>
    <h1>Список справ призначених до розгляду</h1>
</header>
<div class="tableFull">
    <table id="test">
        <tr>
            <th id="fieldDate">Дата/Час</th>
            <th id="fieldComposition">Склад суду</th>
            <th id="fieldNumber">Номер справи</th>
            <th id="fieldProceedingsNumber">Номер провадження</th>
            <th id="fieldParties">Сторони по справі</th>
            <th id="fieldGist">Суть позову</th>
            <th id="fieldBox">Зал судових засідань</th>
        </tr>
        <tbody>
<%--        There will be data from server--%>
        </tbody>
        </tr>

    </table>

<%--    <div id="demo">There will be demo data</div>--%>
</div>
<br>
<a href="/ind">To next page "index.html"</a>

<br>
<a href="/jsonResponse">jsonResponse</a>
</body>
<script src="/js/jquery-3.6.0.min.js"></script>
<script src="/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="/js/script.js"></script>
</html>
