function toServer(root) {
    console.log(root);

    var url = root + "/json/jsonArray.do";

    sendRequest("GET", url, fromServer, null);
}

function fromServer() {
    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
        var jsonArray = JSON.parse(xmlhttp.responseText);
        for (var json of jsonArray) {
            var div = document.createElement("div");

            var span1 = document.createElement("span");
            span1.innerHTML = json.bunho + "&nbsp;&nbsp;";
            div.appendChild(span1);

            var span2 = span1.cloneNode();
            span2.innerHTML = json.line_reply;
            div.appendChild(span2);

            console.log(typeof span1, typeof span2);

            document.getElementById('disp').appendChild(div);
        }
    }
}