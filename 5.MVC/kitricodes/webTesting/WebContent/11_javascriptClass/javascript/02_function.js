function result() {
    var number = document.getElementById("number");
    var oper = document.getElementById("oper");
    var value = document.getElementById("value");

    console.log(number.value, oper.value, value.value);

    //var y = new Yonsan(number.value, oper.value, value.value);

    var y = new Calculator(number.value, oper.value, value.value);

    var result = document.getElementById("result");
    //result.innerHTML = y.calculator();
    result.innerHTML = y.getResult();
}
