function registerCheck(form) {
    var nameReg = /[가-힣]+/;
    var idReg = /\w+|\d+/g;
    var elements = form.elements;
    
    for (var i = 0; i < elements.length; i++) {
		if (elements[i].type == 'text'&&elements[i].value == "") {
			alert("값을 입력해 주세요.");
			elements[i].focus();
			return false;
		}
	}

    if(!idReg.test(form.ID.value)||form.ID.value.length > 13) {
		alert("id는 숫자와 영문으로만 가능하며 13자리를 초과할 수 없습니다.");
		form.ID.focus();
		return false;
	}
	else if (form.isCheckedID.value != "check") {
		alert("id중복확인을 해주세요.");
		form.isCheckedID.focus();
		return false;
	}
	else if (form.password.value != form.checkPassword.value) {
		alert("비밀번호를 다시 확인하여 주세요.");
		form.password.focus();
		return false;
    } 
    else if(form.password.value.length < 8) {
        alert("비밀번호는 8글자 이상이어야 합니다.");
		form.password.focus();
		return false;
    }
    else if(!idReg.test(form.password.value)||form.password.value.length > 13) {
		alert("비밀번호는 숫자와 영문으로만 가능하며 13자리를 초과할 수 없습니다.");
		form.password.focus();
		return false;
	}
	else if (!nameReg.test(form.name.value)
		|| (form.name.value.length < 2 || form.name.value.length > 5)) {
		alert("이름은 한글만, 2글자 미만, 5글자 이상 입력해주셔야 합니다.");
		form.name.focus();
		return false;
    }
    
}

function checkId(form, root) {
    if(form.ID.value == "") {
        alert('아이디를 반드시 입력해 주세요');
        form.ID.focus();
        return false;
    }

    let url = root + "/consumer/idCheck.do?ID=" + form.ID.value;
    open(url, "", "width=400, heigth=200, scrollbars=yes");
    
    console.log(form.isCheckedID.value);
}