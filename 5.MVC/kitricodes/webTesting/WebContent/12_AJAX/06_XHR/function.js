function toServer() {
    sendRequest("get", "json01.txt", fromServer, null);
}

function fromServer() {
    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
        console.log(xmlhttp.responseText);
        var obj = JSON.parse(xmlhttp.responseText);
        console.log(obj.name, obj.age, obj.ki);

        var ulNode = document.createElement('ul');
        var nameLiNode = document.createElement('li');
        nameLiNode.innerHTML = obj.name;

        var ageLiNode = document.createElement('li');
        ageLiNode.innerHTML = obj.age;

        var kiLiNode = document.createElement('li');
        kiLiNode.innerHTML = obj.ki;

        var div = document.createElement('div');
        ulNode.appendChild(nameLiNode);
        ulNode.appendChild(ageLiNode);
        ulNode.appendChild(kiLiNode);
        div.appendChild(ulNode);
        document.body.appendChild(div);

    }
}