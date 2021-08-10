<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
            <td>152/110/21</td>
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
</div>

<br>
<a href="/ListSite/edit">To next page "edit page"</a>
<br>
<a href="/ListSite/ind">To next page "ind page" (index.html)</a>
</body>
<script type="text/javascript" src="js/script.js"></script>
</html>
