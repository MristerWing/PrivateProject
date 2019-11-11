function sub() {
    // brother
    arr = new Array();

    var dauthger = document.getElementById('dauther');
    var oldBrother = dauthger.previousSibling;
    var oldValue = getPreviousSibling(oldBrother);

    var youngBrother = dauthger.nextSibling;
    var youngValue = getNextSibling(youngBrother);
    arr.push(oldValue);
    arr.push(youngValue);

    console.log(arr.join('\n'));

}

function getPreviousSibling(node) {
    if (node.nodeType == 1) {
        return node.childNodes[0].nodeValue;
    } else if (node.nodeType == 3) {
        return getPreviousSibling(node.previousSibling);
    }
}

function getNextSibling(node) {
    if (node.nodeType == 1) {
        return node.childNodes[0].nodeValue;
    } else if (node.nodeType == 3) {
        return getPreviousSibling(node.nextSibling);
    }
}


