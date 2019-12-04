function registerForm(obj) {
    // alert("ok");
    // String textFilter = ['!'+ '@', '#', '$', '%', '^', '&', '*', '?', '~',
    // '`',];
    var nameReg = /[가-힣]+/;
    var idReg = /\w+|\d+/g;
    var resReg1 = /^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))/;
    var resReg2 = /^[1-4][0-9]{6}$/;
    var elements = obj.elements;
    var str = "";

    //obj.zipcode.value = obj.zipcodeView.value;

    for (var i = 0; i < elements.length; i++) {
        if (elements[i].type == "text" && elements[i].value == "") {
            alert("값을 입력해 주세요.");
            elements[i].focus();
            return false;
        }
    }
    if (!idReg.test(obj.id.value) || obj.id.value.length > 13) {
        alert("id는 숫자와 영문으로만 가능하며 13자리를 초과할 수 없습니다.");
        obj.id.focus();
        return false;
    } else if (obj.isIdChk.value != "chk") {
        alert("id중복확인을 해주세요.");
        obj.isIdChk.focus();
        return false;
    } else if (obj.password.value != obj.pwd_chk.value) {
        alert("비밀번호를 다시 확인하여 주세요.");
        obj.password.focus();
        return false;
    } else if (
        !nameReg.test(obj.name.value) ||
        obj.name.value.length < 2 ||
        obj.name.value.length > 5
    ) {
        alert("이름은 한글만, 2글자 미만, 5글자 이상 입력해주셔야 합니다.");
        obj.name.focus();
        return false;
    } /*else if (!resReg1.test(obj.jumin1.value)) {
        alert("주민번호 앞자리를 확인해 주세요.");
        obj.jumin1.focus();
        return false;
    } else if (!resReg2.test(obj.jumin2.value)) {
        alert("주민번호 뒷자리를 확인해 주세요.");
        obj.jumin2.focus();
        return false;
    }*/ else if (obj.job.value == "") {
        alert("직업을 선택하여 주세요.");
        return false;
    } else if (obj.mailing.value == "") {
        alert("메일 수신여부를 확인해 주세요.");
        return false;
    }

    var isChk = false;
    for (var i = 0; i < obj.interestValue.length; i++) {
        if (obj.interestValue[i].checked) {
            isChk = true;
            str += obj.interestValue[i].value + ",";
        }
    }

    if (!isChk) {
        alert("관심분야를 하나이상 체크해 주세요!");
        return false;
    } else {
        obj.interest.value = str;
    }
}

function idCheck(obj, root) {
    if (obj.id.value == "") {
        alert("아이디를 반드시 입력하세요.");
        obj.id.foucs();
        return false;
    }

    var url = root + "/member/idCheck.do?id=" + obj.id.value;
    // alert(url);

    open(url, "", "width=400, height=200, scrollbars=yes");
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
