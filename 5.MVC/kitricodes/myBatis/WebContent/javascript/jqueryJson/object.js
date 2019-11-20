function toServer(root) {
    console.log(root);

    var url = root + "/json/jsonObject.do";
    $.ajax({
        type: "get",
        url: url,
        dataType: "text",
        success: fromServer
    });
}

function fromServer(response) {
    console.log(response);

    var jsonObject = JSON.parse(response);

    $("#disp").append(
        "<span>" +
            jsonObject.bunho +
            "</span>" +
            "<span>" +
            jsonObject.name +
            "</span>" +
            "<span>" +
            jsonObject.average +
            "</span>"
    );
}
