var allRoot = "";

function writeToServer(root) {
    allRoot = root;
    var writeReply = $("#writeReply").val();

    var params = "writeReply=" + writeReply;
    var url = root + "/reply/replyWrite.do";

    console.log(params, url);

    $.ajax({
        type: "post",
        url: url,
        data: params,
        dataType: "text",
        contextType: "application/x-www-form-urlencoded:charset=utf-8",
        success: writeFromServer,
        error: (xhr, status, error) => {
            console.log(xhr, status, error);
        }
    });
}

function writeFromServer(data) {
    var replyData = data.split(",");
    var bunho = replyData[0].trim();
    var reply = replyData[1].trim();
    console.log("getWriteSever", data);

    var lineNumber =
        "<div id='reply" +
        bunho +
        "' class='replyDiv'>" +
        "<label class='cssBunho'>" +
        bunho +
        "</label>" +
        "<label class='cssReply'>" +
        reply +
        "</label>";

    var deleteLink = "javascript:deleteToServer('" + bunho + "','" + allRoot + "')";
    var updateLink = "javascript:updateToServer('" + bunho + "','" + allRoot + "')";

    var upDel =
        "<span class='cssUpdel'>" +
        "<a href=" +
        deleteLink +
        ">삭제&nbsp;" +
        "</a>" +
        "<a href=" +
        updateLink +
        ">수정" +
        "</a>" +
        "</span>" +
        "</div>";

    $("#listAllDiv").prepend(lineNumber + upDel);
}
