//Get json array from server on this url
const requestURL = 'http://srv:8080/ListSite/jsonResponse';
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
        document.getElementById("demo").innerHTML = response;
}
xhr.send();




