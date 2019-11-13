var xmlhttp = null;

function createXHR() {
    if (window.XMLHttpRequest) {
        // code for modern browsers
        xmlhttp = new XMLHttpRequest();
    } else {
        // code for old IE browsers
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
}

function startRequest() {
    createXHR();
    // xmlhttp.open("get",
    // "http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=109",
    // true);
    xmlhttp.open("get", "mid-term-rss3.xml", true);
    xmlhttp.send();
    xmlhttp.onreadystatechange = resultProcess;
}

function resultProcess() {
    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
        var xmlDoc = xmlhttp.responseXML;
        // var studentList = xmlDoc.getElementsByTagName("student");

        /*
         * for (var i = 0; i < studentList.length; i++) { var childElement =
         * studentList[i].childNodes; var divNode =
         * document.createElement("div");
         *
         * for (var j = 0; j < childElement.length; j++) { if
         * (childElement[j].nodeType == 1) { var span =
         * document.createElement("span");
         *
         * span.innerHTML = childElement[j].childNodes[0].nodeValue;
         * divNode.appendChild(span); } document.body.appendChild(divNode); } }
         */

        // var father = xmlDoc.getElementsByTagName("body");
        // console.log(xmlDoc);
        var div = document.createElement("div");
        // console.log(xmlDoc.length);
        // var arr = new Array();
        // child(xmlDoc, arr);
        // div.innerHTML = arr.join("");
        // div.innerHTML = arr.join("");

        var result = getAllChildNodes(xmlDoc);
        div.innerHTML = result;
        document.body.appendChild(div);
    }
}

function child(node, arr) {
    for (var i = 0; i < node.childNodes.length; i++) {
        if (node.childNodes[i].childNodes.length == 0) {
            if (node.childNodes[i].nodeValue != null)
                arr.push(node.childNodes[i].nodeValue + "<br>");
        } else {
            child(node.childNodes[i], arr);
        }
    }
}

function getAllChildNodes(node) {
    var result = "<p>";
    var nodeChildLength = node.childNodes.length;
    var child = node.childNodes;

    if (node.nodeType == 3) {
        if (node.nodeValue != null) return node.nodeValue;
    } else {
        for (var i = 0; i < nodeChildLength; i++) {
            if (child[i].nodeType == 1) {
                console.log(node.childNodes[i]);
                result += getAllChildNodes(child[i]) + "</p><p>";
            }
        }
    }

    return result;
}
