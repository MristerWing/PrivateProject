function toServer(root) {
    console.log(root);

    var url = root + "/json/jsonObjectArray.do";

    $.ajax({
        type: "get",
        url: url,
        dataType: "text",
        success: fromServer
    });
}

function fromServer(response) {
    var jsonObjectArray = JSON.parse(response);
    var bunho = jsonObjectArray.bunho;
    var name = jsonObjectArray.name;
    var average = jsonObjectArray.average;

    $("#disp").append(
        "<div>" +
            "<label>" +
            bunho +
            "</label>" +
            "<label>" +
            name +
            "</label>" +
            "<label>" +
            average +
            "</label>" +
            "</div>"
    );

    var reply = jsonObjectArray.reply;
    for (var index of reply) {
        $("#disp").append(
            "<div>" +
                "<label>" +
                index.bunho +
                "</label>" +
                "<label>" +
                index.line_reply +
                "</label>" +
                "</div>"
        );
    }
}
