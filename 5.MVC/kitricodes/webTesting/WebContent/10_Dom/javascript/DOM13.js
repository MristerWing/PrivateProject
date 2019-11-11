function sub() {
    var form = document.getElementById('form');
    var div1 = document.createElement('div');
    var div2 = document.createElement('div');
    var div3 = document.createElement('div');
    var div4 = document.createElement('div');
    var div5 = document.createElement('div');
    var br = document.createElement('br');

    // input name
    var nameLabel = document.createElement('label');
    var nameInput = document.createElement('input');

    // select site
    var siteLabel = document.createElement('label');
    var siteSelect = document.createElement('select');
    var siteSelectOption1 = document.createElement('option');
    var siteSelectOption2 = document.createElement('option');
    var siteSelectOption3 = document.createElement('option');

    // radio fruit
    var fruitLabelTitle = document.createElement('label');
    var fruitLabel1 =  document.createElement('label');
    var fruitLabel2 =  document.createElement('label');
    var fruitLabel3 =  document.createElement('label');
    var fruitLabel4 =  document.createElement('label');
    var fruitRadio1 = document.createElement('input');
    var fruitRadio2 = document.createElement('input');
    var fruitRadio3 = document.createElement('input');
    var fruitRadio4 = document.createElement('input');
    
    // interest
    var interestLabelTitle = document.createElement('label');
    var interestLabel1 = document.createElement('label');
    var interestLabel2 = document.createElement('label');
    var interestLabel3 = document.createElement('label');
    var interestLabel4 = document.createElement('label');
    var interestCheckBox1 = document.createElement('input');
    var interestCheckBox2 = document.createElement('input');
    var interestCheckBox3 = document.createElement('input');
    var interestCheckBox4 = document.createElement('input');

    // submit reset
    var submit = document.createElement('input');
    var reset = document.createElement('input');

    // name
    nameLabel.innerHTML = '이름을 입력하세요. ';
    nameInput.type = 'text';
    nameInput.name = 'name';

    // site
    siteLabel.innerHTML = '이동할 사이트 선택'
    siteSelect.name = 'siteURL';
    siteSelectOption1.value = 'https://www.naver.com';
    siteSelectOption1.text =  'naver';
    siteSelectOption2.value = 'https://www.daum.net';
    siteSelectOption2.text =  'daum';
    siteSelectOption3.value = 'https://www.google.com';
    siteSelectOption3.text =  'google';

    // fruit
    fruitLabelTitle.innerHTML = '좋아하는 과일 선택';
    fruitLabel1.innerHTML = '바나나';
    fruitLabel2.innerHTML = '사과';
    fruitLabel3.innerHTML = '딸기';
    fruitLabel4.innerHTML = '파인애플';

    fruitRadio1.name = 'fruit';
    fruitRadio1.type = 'radio';
    fruitRadio1.value = '바나나';
    
    fruitRadio2.name = 'fruit';
    fruitRadio2.type = 'radio';
    fruitRadio2.value = '사과';
    
    fruitRadio3.name = 'fruit';
    fruitRadio3.type = 'radio';
    fruitRadio3.value = '딸기';
    
    fruitRadio4.name = 'fruit';
    fruitRadio4.type = 'radio';
    fruitRadio4.value = '파인애플';

    // interest
    interestLabelTitle.innerHTML = '관심사 체크';
    interestLabel1.innerHTML = '경제';
    interestLabel2.innerHTML = 'IT';
    interestLabel3.innerHTML = '미술';
    interestLabel4.innerHTML = '음악';

    interestCheckBox1.name = 'interest';
    interestCheckBox1.type = 'checkbox';
    interestCheckBox1.value = '경제';
    interestCheckBox2.name = 'interest';
    interestCheckBox2.type = 'checkbox';
    interestCheckBox2.value = 'IT';
    interestCheckBox3.name = 'interest';
    interestCheckBox3.type = 'checkbox';
    interestCheckBox3.value = '미술';
    interestCheckBox4.name = 'interest';
    interestCheckBox4.type = 'checkbox';
    interestCheckBox4.value = '음악';

    // submit, reset
    submit.type = 'submit';
    submit.value = '확인';
    reset.type = 'reset';
    reset.value = '취소';

    form.appendChild(div1);
    div1.appendChild(nameLabel);
    div1.appendChild(nameInput);
    div1.appendChild(br);
    div1.appendChild(br.cloneNode());

    form.appendChild(div2);
    div2.appendChild(siteLabel);
    div2.appendChild(siteSelect);
    siteSelect.appendChild(siteSelectOption1);
    siteSelect.appendChild(siteSelectOption2);
    siteSelect.appendChild(siteSelectOption3);
    div2.appendChild(br.cloneNode());
    div2.appendChild(br.cloneNode());

    form.appendChild(div3);
    div3.appendChild(fruitLabelTitle);
    div3.appendChild(br.cloneNode());
    div3.appendChild(br.cloneNode());
    div3.appendChild(fruitRadio1);
    div3.appendChild(fruitLabel1);
    div3.appendChild(fruitRadio2);
    div3.appendChild(fruitLabel2);
    div3.appendChild(fruitRadio3);
    div3.appendChild(fruitLabel3);
    div3.appendChild(fruitRadio4);
    div3.appendChild(fruitLabel4);
    div3.appendChild(br.cloneNode());
    div3.appendChild(br.cloneNode());
    
    form.appendChild(div4);
    div4.appendChild(interestLabelTitle);
    div4.appendChild(br.cloneNode());
    div4.appendChild(br.cloneNode());
    div4.appendChild(interestCheckBox1);
    div4.appendChild(interestLabel1);
    div4.appendChild(interestCheckBox2);
    div4.appendChild(interestLabel2);
    div4.appendChild(interestCheckBox3);
    div4.appendChild(interestLabel3);
    div4.appendChild(interestCheckBox4);
    div4.appendChild(interestLabel4);
    div4.appendChild(br.cloneNode());
    div4.appendChild(br.cloneNode());
    
    form.appendChild(div5);
    div5.appendChild(submit);
    div5.appendChild(reset);
    
    form.onsubmit=checkForm(form);
}

function checkForm(obj) {
    var data = "";
    
    console.log(obj);

    if (obj.name.value == "") {
        alert("이름을 입력하세요.");
        obj.name.focus();
        return false;
    } else {
        data += obj.name.value + ",";
    }

    if (obj.siteUrl.value === "") {
        alert("사이트를 선택하세요.");
        obj.siteUrl.focus();
        return false;
    } else {
        data += obj.siteUrl.value + ",";
    }

    var f_check = false;
    var i_check = false;
    for (var i = 0; i < obj.fruit.length; i++) {
        if (obj.fruit[i].checked) {
            f_check = true;
            data += obj.fruit[i].value + ",";
            break;
        }
    }

    /* for (var i = 0; i < obj.interset.length; i++) {
        if (obj.interset[i].checked) {
            data += obj.interset[i].value + ",";
            i_check = true;
        }
    } */

    var count = 0;

    for (var j = 0; j < obj.interset.length; j++) {
        if (obj.interset[j].checked) {
            count += 1;
            data += obj.interset[j].value + ",";
        }
    }

    if (!f_check) {
        alert("한개 이상의 항목은 반드시 선택하여야 합니다.");
        return false;
    }

    if (count == 0) {
        alert("한개 이상의 항목은 반드시 선택하여야 합니다.");
        return false;
    }

    alert(data);

    obj.result.value = data;

    //obj.action = obj.siteUrl.value;
}
