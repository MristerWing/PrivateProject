function writeToServer(root) {
    var writeReply = document.getElementById("writeReply").value;
    console.log(writeReply);

    var params = "writeReply=" + writeReply;
    var url = root + "/reply/replyWrite.do"
    sendRequest("POST", url, () => writeFromServer(root), params);
}

function writeFromServer(root) {
    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
        var replyData = xmlhttp.responseText.split(",");
        var listAllDiv = document.getElementById("listAllDiv");
        var bunho = replyData[0].trim();
        var reply = replyData[1].trim();

        document.getElementById("writeReply").value = "";

        var labelBunho = document.createElement("label");
        labelBunho.className = "cssBunho";
        labelBunho.innerHTML = bunho;

        var labelReply = document.createElement("label");
        labelReply.className = "cssReply";
        labelReply.innerHTML = reply;

        var aDelete = document.createElement("a");
        aDelete.href = "javascript:deleteToServer('" + bunho + "', '" + root + "')";
        aDelete.innerHTML = "삭제&nbsp;";


        var aUpdate = document.createElement("a");
        aUpdate.href = "javascript:updateToServer('" + bunho + "', '" + root + "')";
        aUpdate.innerHTML = "수정";

        var spanUpDel = document.createElement("span");
        spanUpDel.className = "cssUpDel";
        spanUpDel.appendChild(aDelete);
        spanUpDel.appendChild(aUpdate);

        var divNode = document.createElement("div");
        divNode.id = "reply" + bunho;
        divNode.className = "replyDiv";
        divNode.appendChild(labelBunho);
        divNode.appendChild(labelReply);
        divNode.appendChild(spanUpDel);

        listAllDiv.insertBefore(divNode, listAllDiv.childNodes[0]);
    }
}
