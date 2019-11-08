function sub() {
    var arr = new Array();

    var melon = document.getElementById("melon");
    arr.push(melon.nodeName + " / " + melon.nodeValue);
    arr.push(melon.childNodes.length);

    for (var i = 0; i < melon.childNodes.length; i++) {
        arr.push(melon.childNodes[i].nodeName);
    }

    var span = melon.getElementsByTagName("span");

    for (var i = 0; i < span.length; i++) {
        arr.push(span[i].childNodes[0].nodeValue);
    }

    alert(arr.join("\n"));
}

function fun() {
    var arr = new Array();

    var apple = document.getElementById("apple");
    var appleChild = apple.childNodes;

    for (var i = 0; i < appleChild.length; i++) {
        arr.push(appleChild[i].nodeName);
        //arr.push(appleChild[i].nodeValue);
        arr.push(appleChild[i].nodeType);

        // NodeType =  1. 태그(요소), 2. 속성, 3. 텍스트
    }

    for(var i = 0; i < appleChild.length; i++) {
        if(appleChild[i].nodeType == 1) {
            arr.push(appleChild[i].childNodes[0].nodeValue);
        }
    }

    alert(arr.join("\n"));
}
