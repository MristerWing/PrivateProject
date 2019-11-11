function sub() {
    var divNode = document.createElement("div");

    divNode.align = "center";

    for (var i = 0; i < 10; i++) {
        var spanNode = document.createElement("span");
        spanNode.innerHTML = "text" + (i + 1);

        var brNode = document.createElement("br");
        divNode.appendChild(spanNode);
        divNode.appendChild(brNode);
        divNode.removeChild(brNode);
    }
    document.body.appendChild(divNode);
}

function fun() {
   var aLabel = document.getElementById('aLabel');
   // document.body.removeChild(document.getElementById(aLabel));
   
   aLabel.remove();
}