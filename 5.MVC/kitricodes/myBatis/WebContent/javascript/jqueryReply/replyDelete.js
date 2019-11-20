function deleteToServer(bunho, root) {
    url = root + "/reply/replyDelete.do";
    var params = "bunho=" + bunho;

    $.ajax({
        type: "post",
        url: url,
        data: params,
        contextType: "application/x-www-form-urlencoded:charset=utf-8",
        success: deleteFromServer,
        error: (xhr, status, error) => {
            console.log(xhr, status, error);
        }
    });
}

function deleteFromServer(bunho) {
    var id = "#reply" + bunho;

    $(id).remove();
}
