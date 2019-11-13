function sub() {
    //var app = document.getElementById("app");
    var nodes = getAllChildNodes(document.body);

    var div = document.createElement("div");
    var span = document.createElement("span");

    span.innerHTML = nodes;
    div.appendChild(span);
    document.body.appendChild(div);
}

function getAllChildNodes(node) {
    var result = "<p>";
    var nodeChildLength = node.childNodes.length;
    var child = node.childNodes;

    if (nodeChildLength == 1) {
        if (child[0].nodeType == 1) {
            return getAllChildNodes(node.childNodes[0]);
        } else {
            return child[0].nodeValue;
        }
    } else if (nodeChildLength > 1) {
        for (var i = 0; i < nodeChildLength; i++) {
            if (child[i].nodeType == 1) {
                //console.log(node.childNodes[i]);
                result += getAllChildNodes(child[i]) + "</p><p>";
            }
        }
    }

    return result;
}
