function sub() {
    var divNode = document.createElement("div");
    divNode.align = "center";
    divNode.id = "apple";
    divNode.style.color = "red";
    divNode.innerHTML = "Hello World!!";

    //document.body.appendChild.appedChild(divNode);

    var spanNode = document.createElement('span');
    spanNode.id = 'banana';
    spanNode.style.color = 'blue';
    spanNode.innerHTML = 'Hello DOM!!';

    var spanNode2 = document.createElement('span');
    spanNode2.id = 'orange';
    spanNode2.style.color = 'orange';
    spanNode2.innerHTML = 'Hello Orange!!';
    
    var spanNode3 = document.createElement('span');
    spanNode3.id = 'react';
    spanNode3.style.color = '#678907';
    spanNode3.innerHTML = '리엑트 잘 하고 싶다..';
    
    var brNode = document.createElement('br');

    divNode.appendChild(brNode);
    divNode.appendChild(spanNode);
    divNode.appendChild(brNode);
    divNode.appendChild(spanNode2);
    divNode.appendChild(brNode);
    divNode.appendChild(spanNode3);
    document.body.appendChild(divNode);
}
