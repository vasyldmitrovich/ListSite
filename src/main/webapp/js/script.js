const requestURL = 'http://localhost:8080/ListSite/jsonResponse';
const xhr = new XMLHttpRequest();
xhr.open('GET', requestURL);
xhr.onreadystatechange = function() {
    if (xhr.readyState !== 4 || xhr.status !== 200) {
        return;
    }
    const response = xhr.responseText;
    console.log(response);
    document.getElementById("demo1").innerHTML = response;
}
xhr.send();




