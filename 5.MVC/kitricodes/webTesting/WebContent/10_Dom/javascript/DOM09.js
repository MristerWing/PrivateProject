function sub() {
    var firstSon = document.getElementById('firstSon');
    var father = document.getElementById('father');
    var grandfather = document.getElementById('grandfather');
    
    // id
    console.log(firstSon.childNodes[0].nodeValue);
    
    // for ver, father
    for(var i = 0;i < father.childNodes.length;i++) {
        if(father.childNodes[i].nodeType == 1) {
            console.log(father.childNodes[i].childNodes[0].nodeValue);
            break;
        }
    }

    // grandfather
    var gDiv =grandfather.getElementsByTagName('div');
    var gSpan = gDiv[0].getElementsByTagName('span');
    
    console.log(gSpan[0].childNodes[0].nodeValue);

    // brother
    arr = new Array();
    console.log('형제');

    var dauthger = document.getElementById('dauther');
    var oldBrother = dauthger.previousSibling;
    var youngBrother = dauthger.nextSibling;

    arr.push(oldBrother.nodeType);
    arr.push(youngBrother.nodeType);

    console.log(arr.join('\n'));

}


