function sub() {
   var data = document.getElementById('data');
   var disp = document.getElementById('disp');
   var span;
   var child;

   for(var i = 0;i < data.childNodes.length;i++) {
       if(data.childNodes[i].nodeType == 1) {
           span = document.createElement('span');
           child = data.childNodes[i];
           span.innerHTML = child.childNodes[0].nodeValue + '<br>';
           disp.appendChild(span);
       }
   }
}
