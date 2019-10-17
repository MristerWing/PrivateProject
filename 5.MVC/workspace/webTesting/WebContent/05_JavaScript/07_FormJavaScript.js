function checkForm(obj) {
    var data = "";

    if (obj.name.value === "") {
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