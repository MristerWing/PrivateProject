function chk(obj) {
    if (obj.job.value == "") {
        alert("직업을 선택해 주세요.");
        obj.job.focus();
        return false;
    }

    if(obj.interest.value == "") {
        alert("관심분야를 선택해 주세요.");
        obj.interest.focus();
        return false;
    }

}