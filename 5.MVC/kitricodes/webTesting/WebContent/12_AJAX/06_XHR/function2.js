function toServer() {
    sendRequest("get", "json02.txt", fromServer, null);
}

function fromServer() {
    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
        console.log(xmlhttp.responseText);
        var obj = JSON.parse(xmlhttp.responseText);
        console.log(obj.toString());

        var div = document.createElement('div');

        for (var i = 0; i < obj.member.length; i++) {
            var ulNode = document.createElement('ul');
            var numberLiNode = document.createElement('li');
            numberLiNode.innerHTML = obj.member[i].studentNumber;
            var nameLiNode = document.createElement('li');
            nameLiNode.innerHTML = obj.member[i].studentName;

            var scoreLiNode = document.createElement('li');
            scoreLiNode.innerHTML = obj.member[i].score;

            ulNode.appendChild(numberLiNode);
            ulNode.appendChild(nameLiNode);
            ulNode.appendChild(scoreLiNode);
            div.appendChild(ulNode);
        }

        document.body.appendChild(div);
    }
}