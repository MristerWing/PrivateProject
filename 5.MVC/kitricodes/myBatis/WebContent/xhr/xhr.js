var xmlhttp = null;

function createXHR() {
  if (window.XMLHttpRequest) {
    // code for modern browsers
    return new XMLHttpRequest();
  } else {
    // code for old IE browsers
    return new ActiveXObject("Microsoft.XMLHTTP");
  }
}

function sendRequest(method, url, callback, params) {
  var httpMethod = method.toUpperCase();

  if (httpMethod != "GET" && httpMethod != "POST") {
    httpMethod = "GET";
  }

  var httpParams = params == null || params == "" ? null : params;
  var httpUrl = url;
  if (httpMethod == "GET" && httpParams != null) {
    httpUrl += "?" + httpParams;
  }

  console.log(httpUrl);
  console.log(httpParams);

  xmlhttp = createXHR();

  xmlhttp.open(httpMethod, httpUrl, true);
  xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
  xmlhttp.send(httpMethod == "POST" ? httpParams : null);
  xmlhttp.onreadystatechange = callback;
}