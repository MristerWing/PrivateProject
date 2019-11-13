var xmlhttp = null;

function createXHR() {
  if (window.XMLHttpRequest) {
    // code for modern browsers
    xmlhttp = new XMLHttpRequest();
  } else {
    // code for old IE browsers
    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
  }
}

function sendRequest(method, url, callback, parama) {
  var httpMethod = method.toUpperCase();

  if (httpMethod != "GET" && httpMethod != "POST") {
    httpMethod = "GET";
  }

  var httpParama = (parama == null || parama == "") ? null : parama;
  var httpUrl = url;
  if (httpMethod == "GET" && httpParama != null) {
    httpUrl = "?" + httpParama;
  }

  createXHR();

  xmlhttp.open(httpMethod, httpUrl, true);
  xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
  xmlhttp.send(httpMethod == "POST" ? httpParama : null);
  xmlhttp.onreadystatechange = callback;
}

function toServer() {
  sendRequest("GET", "server.txt", fromServer, null);
}

function fromServer() {
  if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
    console.log(xmlhttp.responseText);
  }
  
}
