function sub() {
	var app = document.getElementById("app");
	var nodes = getAllChildNodes(app);
    
    var div = document.createElement('div');
    var span = document.createElement('span');

    span.innerHTML = nodes;
    div.appendChild(span);
    document.body.appendChild(div);
}

function getAllChildNodes(node) {
	var result = '';

	if (node.childNodes.length == 1) {
		if (node.nodeType == 1) {
			return node.childNodes[0].nodeValue; 
		} else {
			return '';
		}
	} else if (node.childNodes.length > 1) {
        for (var i = 0; i < node.childNodes.length; i++) {
            if (node.childNodes[i].nodeType == 1) {
				//console.log(node.childNodes[i]);
				result += getAllChildNodes(node.childNodes[i]);
			}
		}
	}
	
	return result;
}
