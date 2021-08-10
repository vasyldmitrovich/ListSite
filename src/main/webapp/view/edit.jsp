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
    <table>
        <tr>
            <th id="fieldDate">Дата/Час</th>
            <th id="fieldComposition">Склад суду</th>
            <th id="fieldNumber">Номер справи</th>
            <th id="fieldProceedingsNumber">Номер провадження</th>
            <th id="fieldParties">Сторони по справі</th>
            <th id="fieldGist">Суть позову</th>
            <th id="fieldBox">Зал судових засідань</th>
        </tr>
        <tr>
            <td>29.07.2021 08:30</td>
            <td>Малєєв А.Ю.</td>
            <td>353/300/21</td>
            <td>313/300/21</td>
            <td>Правопорушник: Мороз Василь Васильович</td>
            <td>
                Керування транспортними засобами або суднами
                особами, які перебувають у стані алкогольного,
                наркотичного чи іншого сп'яніння або під впливом
                лікарських препаратів, що знижують їх увагу та
                швидкість реакції
            </td>
            <td>3</td>

        </tr>

    </table>
    <div class="mypanel" id="demo">There must be json data Укпаїна</div>
    <div id="demo1">this is demo1 Україна</div>
</div>
<br>
<a href="/ListSite/edit">To next page "edit page"</a>
<br>
<a href="/ListSite">To next page "ind page" (index.jsp)</a>
<br>
<a href="/ListSite/jsonResponse">jsonResponseУкраїна</a>
</body>
<script src="/js/jquery-3.6.0.min.js"></script>
<script src="/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="/js/script.js"></script>
</html>
