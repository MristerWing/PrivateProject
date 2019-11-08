function checkForm() {
    /* var createform = document.getElementById("createForm");

    if(createForm.name.value == "") {
        alert("이름입력");
        createForm.name.focus();
        return false;
    } */

    /* var isSelected = false;
    for(let i = 0;form.fruit.length;i++) {

    }

    // 작동안함
    var form = document.getElementsByTagName("form");
    var input = form[0].getElementByTagName("input");

    if(input[0].value == "") {
        alert("이름입력");
        input[0].focus();
        return false;
    } */
	
    var name = document.getElementById("name");
    var siteURL = document.getElementById("siteURL");

    if(name.value == "") {
        alert("name");
        name.focus();
        return false;
    }

    // name으로 값 가져오기
    var fruit = document.getElementsByName("fruit");
    alert(fruit.length);

    // class로 뽑아오기
    var interest = document.getElementsByClassName("interest");
    alert(interest.length);
}