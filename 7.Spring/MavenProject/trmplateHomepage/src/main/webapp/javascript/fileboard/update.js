function boardForm(obj, pwd) {
    if(obj.password.value != pwd) {
        alert("비밀번호가 다릅니다. 확인해 주세요!");
        obj.password.focus();
        return false;
    }
}