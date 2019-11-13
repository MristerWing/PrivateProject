function toServer() {
    sendRequest("get", "json3.txt", fromServer, null);
}

function fromServer() {
    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
        var obj = JSON.parse(xmlhttp.responseText);
        var div = document.createElement('div');

        for (var i = 0; i < obj.name.length; i++) {
            var labelNode = document.createElement('label');
            labelNode.innerHTML = obj.name[i].name;

            var ulNode = document.createElement('ul');
            for (var j = 0; j < obj.name[i].models.length; j++) {
                var modelLiNode = document.createElement('li');
                modelLiNode.innerHTML = obj.name[i].models[j];
                ulNode.appendChild(modelLiNode);
            }

            div.appendChild(labelNode);
            div.appendChild(ulNode);
        }

        document.body.appendChild(div);
    }
}