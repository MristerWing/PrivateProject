function sub() {
    var aDiv = document.createElement("div");
    var bDiv = document.createElement("div");
    
    var aSpan1 = document.createElement('span');
    aSpan1.innerHTML = '가';
    var aSpan2 = document.createElement('span');
    aSpan2.innerHTML = '나';
    var aSpan3 = document.createElement('span');
    aSpan3.innerHTML = '다';

    var bSpan1 = document.createElement('span');
    bSpan1.innerHTML = 'A';
    var bSpan2 = document.createElement('span');
    bSpan2.innerHTML = 'B';
    var bSpan3 = document.createElement('span');
    bSpan3.innerHTML = 'C';

    aDiv.appendChild(aSpan1);
    aDiv.appendChild(aSpan2);
    aDiv.appendChild(aSpan3);

    bDiv.appendChild(bSpan1);
    bDiv.appendChild(bSpan2);
    bDiv.appendChild(bSpan3);

    var disp = document.getElementById('disp');
    
    disp.appendChild(aDiv);
    disp.appendChild(bDiv);
}
