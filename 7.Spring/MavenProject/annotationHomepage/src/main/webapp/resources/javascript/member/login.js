function chkId(obj) {
    var idReg = /\w+|\d+/g;
    if(!idReg.test(obj.id.value)||obj.id.value.length > 13) {
		alert("id는 숫자와 영문으로만 가능하며 13자리를 초과할 수 없습니다.");
		obj.id.focus();
		return false;
	}
}