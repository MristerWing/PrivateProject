function sub() {
    var divNode = document.createElement("div");
    var str = "banana";
    var num = 3;

    for (var i = 0; i < 3; i++) {
        var inputNode = document.createElement("input");
        /*
         * inputNode.type = "button"; inputNode.value = "click" + (i + 1);
         * inputNode.onclick = xyz;
         */

        inputNode.setAttribute("value", "click" + (i + 1));
        inputNode.setAttribute("type", "button");
        // inputNode.setAttribute("onclick", "xyz()");
        // inputNode.setAttribute("onclick", "abc(" + num + ")");

        inputNode.onclick = () => abc(str);

        divNode.appendChild(inputNode);
    }

    document.body.appendChild(divNode);
}

function abc(str) {
    console.log(str);
}

function xyz() {
    console.log("t");
}
