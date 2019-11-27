function deleteToServer(bunho, root) {
    url = root + "/reply/replyDelete.do";
    var params = "bunho=" + bunho;

    sendRequest("GET", url, deleteFromServer, params);
}

function deleteFromServer() {
    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
        var bunho = xmlhttp.responseText;
        var id = "reply" + bunho;
        var replyDiv = document.getElementById('listAllDiv');
        var deleteDiv = document.getElementById(id);
        console.log(id);
        console.log(deleteDiv);

        replyDiv.removeChild(deleteDiv);
    }
}