const requestURL = 'http://localhost:8080/ListSite/jsonResponse';
const xhr = new XMLHttpRequest();
xhr.open('GET', requestURL);
xhr.onreadystatechange = function() {
    if (xhr.readyState !== 4 || xhr.status !== 200) {
        return;
    }
    const response = xhr.responseText;
    var arrObjects  = JSON.parse(response);
    var result;
    for (var i=0; i < arrObjects.length; i++) {
        result += arrObjects[i].dateAndTime+"<br>";
        document.getElementById("demo").innerHTML = result;
    }
    document.getElementById("demo1").innerHTML = response;
}
xhr.send();




