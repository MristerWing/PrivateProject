function sub() {
    var arr = new Array();

    var divNode = document.createElement("div");
    // setter
    divNode.align = "center";
    divNode.style.color = "blue";
    divNode.innerHTML = "Hello!!";
    arr.push(divNode.align);

    var div = document.createElement("div");
    div.setAttribute("align", "right");
    div.setAttribute("style", "color:red");
    div.innerHTML = "World!";
    arr.push(div.align);

    console.log(arr.join("\n"));

    // getter
    document.body.appendChild(divNode);
    document.body.appendChild(div);
}
