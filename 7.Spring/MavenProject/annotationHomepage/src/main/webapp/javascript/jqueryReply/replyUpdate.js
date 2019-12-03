var allRoot;

function updateToServer(bunho, root) {
    allRoot = root;
    url = root + "/reply/replyUpdate.do";
    var params = "bunho=" + bunho;
    $.ajax({
        type: "post",
        url: url,
        data: params,
        dataType: "text",
        contextType: "application/x-www-form-urlencoded:charset=utf-8",
        success: updateFromServer,
        error: (xhr, status, error) => {
            console.log(xhr, status, error);
        }
    });
}

function updateFromServer(data) {
    var replyData = data.split(",");
    var bunho = replyData[0].trim();
    var line_reply = replyData[1].trim();
    var id = "#reply" + bunho;

    console.log(id, line_reply, allRoot);

    $(id).append(
        "<div id='inputUpdate'>" +
            "<input type='text' value='" +
            line_reply +
            "' />" +
            "<input type='button' value='수정' />" +
            "</div>"
    );

    $("#inputUpdate")
        .children()
        .last()
        .click(() => {
            var updateLineReply = $("#inputUpdate")
                .children()
                .first()
                .val();
            var url = allRoot + "/reply/replyUpdateOk.do";
            var params = "bunho=" + bunho + "&line_reply=" + updateLineReply;
            $.ajax({
                type: "post",
                url: url,
                data: params,
                dataType: "text",
                contextType: "application/x-www-form-urlencoded:charset=utf-8",
                success: updateOkFromServer
            });
        });
}

function updateOkFromServer(data) {
    var replyData = data.split(",");
    var bunho = replyData[0].trim();
    var line_reply = replyData[1].trim();
    var id = "#reply" + bunho;
    
    console.log(data, "a");
    console.log($(id).eq(1));

    $(id)
        .children()
        .eq(1)
        .text(line_reply);
    $("#inputUpdate").remove();
}
