function toServer() {
  var inputText = document.getElementById("msg").value;
  console.log(inputText);
  var params = "msg=" + inputText;

  sendRequest("get", "server.jsp", fromServer, params);
}

function fromServer() {
  if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
    var disp = document.getElementById('disp');
    disp.innerHTML = xmlhttp.responseText;
  }
}