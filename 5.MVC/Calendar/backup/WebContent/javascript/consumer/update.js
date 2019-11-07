function updateCheck(form) {
	for (var i = 0; i < elements.length; i++) {
		if (elements[i].type == 'text'&&elements[i].value == "") {
			alert("값을 입력해 주세요.");
			elements[i].focus();
			return false;
		}
	}
	
	if (form.password.value != form.checkPassword.value) {
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
}