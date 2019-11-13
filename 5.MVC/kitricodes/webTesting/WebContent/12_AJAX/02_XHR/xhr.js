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

function startRequest() {
    var createForm = document.getElementById("createForm");
    var id = createForm.id.value;
    var password = createForm.password.value;
    var postData = "id=" + id + "&password=" + password;

    // console.log(id, password);
    createXHR();
    // xmlhttp.open("get", "server.jsp?id=" + id + "&password=" + password, true);
    xmlhttp.open("post", "server.jsp", true);
    xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xmlhttp.send(postData);
    xmlhttp.onreadystatechange = resultProcess;
}

function resultProcess() {
    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
        var disp = document.getElementById('resultDisp');
        var span = document.createElement('span');
        span.style.color = 'red';
        span.innerHTML = xmlhttp.responseText;
        disp.appendChild(span);

        console.log(xmlhttp.responseText);
    }
}
