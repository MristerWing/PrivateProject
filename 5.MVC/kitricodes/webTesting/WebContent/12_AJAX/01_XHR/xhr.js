var xmlhttp = null;

function startRequest() {
    // console.log("call");
    // XMLHttpRequest Object create

    if (window.XMLHttpRequest) {
        // code for modern browsers
        xmlhttp = new XMLHttpRequest();
    } else {
        // code for old IE browsers
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.open("get", "server.txt", true);
    xmlhttp.send();

    // 모든 응답이 이루어 지면 함수를 호출
    xmlhttp.onreadystatechange = resultProcess;
}

function resultProcess() {
    //console.log(xmlhttp.readyState + "," + xmlhttp.status);

    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
        //console.log(xmlhttp.responseText);

        var resultDisp = document.getElementById("resultDisp");
        resultDisp.innerHTML = xmlhttp.responseText;
    }
}
