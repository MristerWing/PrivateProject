function sub() {
    var myForm = document.getElementById("myForm");
    var input = myForm.getElementsByTagName("input");

    var msg = document.getElementById("msg");
    var str;

    //태그를 생성하여 체크된 값이면 이미지를 출력한다. 이때 "'를 주의하여 작성하여야한다.
    for(let i =0;i<input.length;i++) {
        if(input[i].checked) {
            msg.innerHTML = "<img width='150' height='200' src='../images/" + input[i].value + ".jpg' />";
            str = input[i].value;
        }
    }
    
    var div = document.getElementById("text");
    div.innerHTML = str;
    div.style.color = "red";
    div.style.fontSize = "24px";
    
    
    
}