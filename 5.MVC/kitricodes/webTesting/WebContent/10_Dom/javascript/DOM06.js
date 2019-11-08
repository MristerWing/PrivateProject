function sub() {
    var arr = new Array();

    var div = document.getElementsByTagName("div");
    arr.push("노드 이름: " + div[0].nodeName);
    arr.push("노드 값: " + div[0].nodeValue);
    arr.push("자식 노드 이름: " + div[0].childNodes[0].nodeName);
    arr.push("자식 노드 값: " + div[0].childNodes[0].nodeValue);

    var span = div[1].getElementsByTagName("span");
    arr.push("span 갯수: " + span.length);
    // 바로 아래의 코드는 enter값또한 자식으로 받아 들여서 작동한다. 
    // 이는 브라우저 마다 다르게 작동하여 작성시 주의가 필요하다.
    arr.push("span 갯수: " + div[1].childNodes.length);

    alert(arr.join("\n"));
}