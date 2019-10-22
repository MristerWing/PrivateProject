var oper = ["+", "-", "*", "x", "X", "/"];

function check(form) {
    if (form.su.value == "") {
        alert("첫번째수를 입력하세요!");
        focus(form.su);
        return false;
    }
    else if (form.bunho.value == "") {
        alert("부호를 입력하세요!");
        focus(form.bunho);
        return false;
    }
    else if (form.value.value == "") {
        alert("두번째수를 입력하세요!");
        focus(form.value);
        return false;
    }

    if(isNaN(form.su.value) || isNaN(form.value.value)) {
         alert("수는 숫자만 입력할 수 있습니다.");
         return false;
     }

    var chkOper = false;

    for (var i = 0;i < oper.length;i++) {
        if (form.bunho.value == oper[i]) {
            chkOper = true;
            break;
        }
    }

    if (!chkOper) {
        alert("정해진 부호만 입력해 주세요.");
        return false;
    }

    if (form.bunho.value == "/" && (form.value.value == 0 || form.su.value == 0)) {
        alert("0으로는 나눌 수 없습니다.");
        return false;
    }
}