function updateToServer(bunho, root) {
    url = root + "/reply/replyUpdate.do";
    var params = "bunho=" + bunho;

    sendRequest("GET", url, () => updateFromServer(root), params);
}

function updateFromServer(root) {
    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
        var replyData = xmlhttp.responseText.split(",");
        var bunho = replyData[0].trim();
        var line_reply = replyData[1].trim();
        var id = "reply" + bunho;
        var selectedDiv = document.getElementById(id);

        var inputUpdateText = document.createElement("input");
        inputUpdateText.type = "text";
        inputUpdateText.value = line_reply;

        var inputUpdateButton = document.createElement("input");
        inputUpdateButton.type = "button";
        inputUpdateButton.value = "수정";
        inputUpdateButton.onclick = () => {
            var updateLineReply = inputUpdateText.value;
            var url = root + "/reply/replyUpdateOk.do";
            var params = "bunho=" + bunho + "&line_reply=" + updateLineReply;
            sendRequest("GET", url, updateOkFromServer, params);
        };

        var div = document.createElement('div');
        div.id = "inputUpdate";
        div.appendChild(inputUpdateText);
        div.appendChild(inputUpdateButton);
        selectedDiv.appendChild(div);
    }
}

function updateOkFromServer() {
    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
        var replyData = xmlhttp.responseText.split(",");
        var bunho = replyData[0].trim();
        var line_reply = replyData[1].trim();
        var id = "reply" + bunho;
        var selectedDiv = document.getElementById(id);

        var newLabel = document.createElement("label");
        newLabel.className = "cssReply";
        newLabel.innerHTML = line_reply;

        var oldLabel = selectedDiv.getElementsByTagName("label");
        selectedDiv.replaceChild(newLabel, oldLabel[1]);

        var removeInputUpdateDiv = document.getElementById("inputUpdate");
        selectedDiv.removeChild(removeInputUpdateDiv);
    }
}
