function sub() {
    var formNode = document.createElement("form");
    formNode.setAttribute("id", "createForm");
    formNode.setAttribute("action", "#");
    formNode.setAttribute("method", "post");
    formNode.onsubmit = () => abc();

    var labelNode = document.createElement("label");
    labelNode.innerHTML = "이름";

    var nameInput = document.createElement("input");
    nameInput.type = "text";
    nameInput.name = "name";
    nameInput.size = "12";

    var brNode = document.createElement("br");

    var submitInput = document.createElement("input");
    submitInput.setAttribute("type", "submit");
    submitInput.setAttribute("value", "전송");

    formNode.appendChild(labelNode);
    formNode.appendChild(nameInput);
    formNode.appendChild(brNode);
    formNode.appendChild(submitInput);

    document.body.appendChild(formNode);
}

function abc() {
    var createForm = document.getElementById("createForm");
    if (createForm.name.value == "") {
        alert("plz input name");
        createForm.name.focus();
        return false;
    }
}
