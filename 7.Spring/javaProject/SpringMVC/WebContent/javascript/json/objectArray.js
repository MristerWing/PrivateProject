function toServer(root) {
    console.log(root);

    var url = root + "/json/jsonObjectArray.do";

    sendRequest("GET", url, fromServer, null);
}

function fromServer() {
    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
        var disp = document.getElementById("disp");

        var jsonObjectArray = JSON.parse(xmlhttp.responseText);
        var bunho = jsonObjectArray.bunho;
        var name = jsonObjectArray.name;
        var average = jsonObjectArray.average;

        var divMaps = document.createElement('div');

        var spanBunho = document.createElement('span');
        spanBunho.innerHTML = bunho + "&nbsp;&nbsp;";
        divMaps.appendChild(spanBunho);

        var spanName = spanBunho.cloneNode();
        spanName.innerHTML = name + "&nbsp;&nbsp;";
        divMaps.appendChild(spanName);

        var spanAverage = spanBunho.cloneNode();
        spanAverage.innerHTML = average;
        divMaps.appendChild(spanAverage);

        disp.appendChild(divMaps);

        var reply = jsonObjectArray.reply;
        for (var index of reply) {
            var divList = divMaps.cloneNode();

            var spanReplyBunho = spanBunho.cloneNode();
            spanReplyBunho.innerHTML = index.bunho + "&nbsp;&nbsp;";
            divList.appendChild(spanReplyBunho);

            var spanReplyLineReply = spanBunho.cloneNode();
            spanReplyLineReply.innerHTML = index.line_reply;
            divList.appendChild(spanReplyLineReply);

            disp.appendChild(divList);
        }
    }
}