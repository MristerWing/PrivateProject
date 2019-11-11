function sub() {
   var divNode = document.createElement('div');

   var spanNode = document.createElement('span');
   spanNode.innerHTML = 'Hello!';

   var bNode = document.createElement('b');
   bNode.innerHTML= 'Hello';

   divNode.appendChild(spanNode);
   divNode.appendChild(document.createElement('br'));
   divNode.appendChild(bNode);

   document.body.appendChild(divNode);
   var fontNode = document.createElement('font');
   fontNode.innerHTML = 'STUDY@!!!!!';

   divNode.replaceChild(fontNode, spanNode);

}
