function toServer(root) {
    var form = document.getElementById("createForm");
    var selectText = form.departmentName.value;
    var url = root + "/sawon/listOk.do";

    if (selectText != "부서를 선택하세요.") {
        console.log(selectText);
        var params = "departmentName=" + selectText;
        sendRequest("POST", url, fromServer, params);
    }
}

function fromServer() {
    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
        //console.log(xmlhttp.responseText);
        var resultDisplay = document.getElementById('resultDisplay');
        resultDisplay.innerHTML = xmlhttp.responseText;
    }
}