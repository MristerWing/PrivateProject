function toServer(root) {
    console.log(root);

    var url = root + "/json/jsonObject.do";

    sendRequest("GET", url, fromServer, null);
}

function fromServer() {
    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
        console.log(xmlhttp.responseText);

        var jsonObject = JSON.parse(xmlhttp.responseText);

        spanBunho = document.createElement("span");
        spanBunho.innerHTML = jsonObject.bunho;

        spanName = document.createElement("span");
        spanName.innerHTML = jsonObject.name;

        spanAverage = document.createElement("span");
        spanAverage.innerHTML = jsonObject.average;

        var disp = document.getElementById("disp");
        disp.appendChild(spanBunho);
        disp.appendChild(spanName);
        disp.appendChild(spanAverage);

    }
}