function registerForm(obj) {
	// alert("ok");
	// String textFilter = ['!'+ '@', '#', '$', '%', '^', '&', '*', '?', '~',
	// '`',];
	var nameReg = /[가-힣]+/;
	var idReg = /\w+|\d+/g;
	var elements = obj.elements;
	var str = "";

	//obj.zipcode.value = obj.zipcodeView.value;

	for (var i = 0; i < elements.length; i++) {
		if (elements[i].type == 'text'&&elements[i].value == "") {
			alert("값을 입력해 주세요.");
			elements[i].focus();
			return false;
		}
	}

	if(!idReg.test(obj.id.value)||obj.id.value.length > 13) {
		alert("id는 숫자와 영문으로만 가능하며 13자리를 초과할 수 없습니다.");
		obj.id.focus();
		return false;
	}
	else if (obj.password.value != obj.pwd_chk.value) {
		alert("비밀번호를 다시 확인하여 주세요.");
		obj.password.focus();
		return false;
	} 
	else if (!nameReg.test(obj.name.value)
		|| (obj.name.value.length < 2 || obj.name.value.length > 5)) {
		alert("이름은 한글만, 2글자 미만, 5글자 이상 입력해주셔야 합니다.");
		obj.name.focus();
		return false;
	}
	else if(obj.job.value=="") {
		alert("직업을 선택하여 주세요.");
		return false;
	}
	else if(obj.mailing.value=="") {
		alert("메일 수신여부를 확인해 주세요.");
		return false;
	}
	
	var isChk = false;
	for(var i = 0;i < obj.interestValue.length;i++) {
		if(obj.interestValue[i].checked) {
			isChk = true;
			str += obj.interestValue[i].value+",";
		}
	}		

	if(!isChk) {
		alert("관심분야를 하나이상 체크해 주세요!");
		return false;
	}else {
		obj.interest.value = str;
	}

}

function zipcodeRead(root) {
	var url = root + "/member/zipcode.do";
	//alert(url);

	open(url, "", "width=500, height=500, scrollbars=yes");
}

function sendAddress(zipcode, sido, gugun, dong, ri, bunji) {
	var address = sido + gugun + dong + ri + bunji;
	//alert(zipcode + ", " + address);

	opener.createForm.zipcode.value = zipcode;
	opener.createForm.zipcodeView.value = zipcode;
	opener.createForm.address.value = address;

	self.close();
}

function setValues(obj, job, mailing, interest) {
    
	//alert(obj.interestValue[0].checked);
	
    var interestIndex = interest.split(",");
    //var interestIndex = interest;
    
    //alert(interest);

    obj.job.value = job;
    obj.mailing.value = mailing;

    for(var i = 0;i < obj.interestValue.length;i++) {
        for(var j = 0;j < interestIndex.length;j++) {
            if(obj.interestValue[i].value == interestIndex[j])
                obj.interestValue[i].checked = true;
        }
    } 
    
}