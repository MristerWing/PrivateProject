function toServer(root) {
    console.log(root);

    var url = root + "/json/jsonArray.do";

    $.ajax({
        type: "get",
        url: url,
        dataType: "text",
        success: fromServer
    });
}

function fromServer(response) {
    var jsonArray = JSON.parse(response);
    for (var json of jsonArray) {
        $("#disp").append(
            "<div>" +
                "<span>" +
                json.bunho +
                "&nbsp;&nbsp;</span>" +
                "<span>" +
                json.line_reply +
                "</span>" +
                "</div>"
        );
    }
}
