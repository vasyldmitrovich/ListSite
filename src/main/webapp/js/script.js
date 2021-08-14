//Get json array from server on this url
const requestURL = 'http://DT176:8080/jsonResponse';
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

