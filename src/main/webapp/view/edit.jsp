<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">

    <style>
        body {
            background-color: #faf9df;
        }
        header {
            text-align: center;
            width: auto;
        }
        .tableFull {
            background-color: #cddef6;
        }
        table {
            width: 100%;
        }
        table, th, td {
            border: 3px solid black;
        }
        td, th, tr {
            text-align: center;
        }



        .fieldDate {
            width: 5%;
        }
        .fieldComposition {
            width: 10%;
        }
        .fieldNumber {
            width: 5%;
        }
        .fieldProceedingsNumber {
            width: 5%;
        }
        .fieldParties {
            width: 35%;
        }
        .fieldGist {
            width: auto;
        }
        .fieldForm {
            width: 5%;
        }
        .fieldBox {
            width: 3%;
        }

    </style>
    <title>Список справ</title>
</head>
<body>
<header>
    <h1>Список справ призначених до розгляду</h1>
</header>
<div class="tableFull">
    <div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner" id="dataTableAndCarousel">

        </div>
    </div>
</div>
<br>
<a href="/">To next page "index.html"</a>
<br>
<a href="/jsonResponse">jsonResponse</a>
<br>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
        crossorigin="anonymous"></script>

<script>
    //Get json array from server on this url
    const requestURL = 'http://srv:8080/jsonResponse';
    const xhr = new XMLHttpRequest();
    xhr.open('GET', requestURL);
    xhr.onreadystatechange = function() {
        if (xhr.readyState !== 4 || xhr.status !== 200) {
            return;
        }
        //Set this json to constant
        const response = xhr.responseText;

        //After that parse Json and write on site in table
        const arrObjects = JSON.parse(response);
        var lengthObjects = arrObjects.length;
        var rowsOnPage = 7;//How many rows must to be on one pages
        var count = 0;
        var countPages = 0;//How mane pages we will have in the end, that need for build carousel
        do {
            count += rowsOnPage;
            countPages++;
        } while (lengthObjects > count);

        var finish = listPagesOfCarousel(arrObjects,countPages,rowsOnPage);
        document.getElementById("dataTableAndCarousel").innerHTML = finish;

        //That block for page index.html but on this page do not work that
        const tableRef = document.getElementById('test').getElementsByTagName('tbody')[0];
        for (let i=0; i < arrObjects.length; i++) {
            tableRef.insertRow().innerHTML = "<tr>" +
                "<td>" + arrObjects[i].dateAndTime + "</td>" +
                "<td>" + arrObjects[i].judges + "</td>" +
                "<td>" + arrObjects[i].caseNumber + "</td>" +
                "<td>" + arrObjects[i].proceedingsNumber + "</td>" +
                "<td>" + arrObjects[i].claimantDefendant + "</td>" +
                "<td>" + arrObjects[i].gistClaim + "</td>" +
                "<td>" + arrObjects[i].courtroom + "</td>" +
                "</tr>";
        }
    }
    xhr.send();

    function listPagesOfCarousel (arr, howManyCycles, rowsOnPage) {
        var result = "";
        var count = 0;
        var tempVariable = "";
        var tempHowManyCycles = howManyCycles;

        while (tempHowManyCycles !=0) {
            if (tempHowManyCycles == howManyCycles) {
                tempVariable = headFirstPageCarouselAndTable();
                for ( let i=count; i<count+rowsOnPage; i++) {
                    tempVariable += rowInTable(arr,i);
                }
                tempVariable += futCarouselAndTable();
                count += rowsOnPage;
                result += tempVariable;
            }
            else if (tempHowManyCycles < howManyCycles && count+rowsOnPage < arr.length) {
                tempVariable = headCarouselAndTable();
                for ( let j=count; j<count+rowsOnPage; j++) {
                    tempVariable += rowInTable(arr,j);
                }
                tempVariable += futCarouselAndTable();
                count += rowsOnPage;
                result += tempVariable;
            } else {
                tempVariable = headCarouselAndTable();
                for ( let k=count; k<arr.length; k++) {
                    tempVariable += rowInTable(arr,k);
                }
                tempVariable += futCarouselAndTable();
                count += rowsOnPage;
                result += tempVariable;
            }
            tempHowManyCycles--;
        }
        return result;
    }
    function rowInTable(arr, index) {
        return "<tr>" +
            "<td>" + arr[index].dateAndTime + "</td>" +
            "<td>" + arr[index].judges + "</td>" +
            "<td>" + arr[index].caseNumber + "</td>" +
            "<td>" + arr[index].proceedingsNumber + "</td>" +
            "<td>" + arr[index].claimantDefendant + "</td>" +
            "<td>" + arr[index].gistClaim + "</td>" +
            "<td>" + arr[index].courtroom + "</td>" +
            "</tr>";
    }
    function headFirstPageCarouselAndTable() {
        return "<div class=\"carousel-item active\" data-bs-interval=\"10000\">\n" +
            "                <table class=\"test\">\n" +
            "                    <tr>\n" +
            "                        <th class=\"fieldDate\">Дата/Час</th>\n" +
            "                        <th class=\"fieldComposition\">Склад суду</th>\n" +
            "                        <th class=\"fieldNumber\">Номер справи</th>\n" +
            "                        <th class=\"fieldProceedingsNumber\">Номер провадження</th>\n" +
            "                        <th class=\"fieldParties\">Сторони по справі</th>\n" +
            "                        <th class=\"fieldGist\">Суть позову</th>\n" +
            "                        <th class=\"fieldBox\">Зал судових засідань</th>\n" +
            "                    </tr>";
    }
    function headCarouselAndTable() {
        return "<div class=\"carousel-item\" data-bs-interval=\"10000\">\n" +
            "                <table class=\"test\">\n" +
            "                    <tr>\n" +
            "                        <th class=\"fieldDate\">Дата/Час</th>\n" +
            "                        <th class=\"fieldComposition\">Склад суду</th>\n" +
            "                        <th class=\"fieldNumber\">Номер справи</th>\n" +
            "                        <th class=\"fieldProceedingsNumber\">Номер провадження</th>\n" +
            "                        <th class=\"fieldParties\">Сторони по справі</th>\n" +
            "                        <th class=\"fieldGist\">Суть позову</th>\n" +
            "                        <th class=\"fieldBox\">Зал судових засідань</th>\n" +
            "                    </tr>";
    }
    function futCarouselAndTable() {
        return "</table>\n" +
            "            </div>";
    }

    // const createClock = setInterval(f,1000)
    // function f(){
    //     console.log("set int");
    // }


</script>
</html>
