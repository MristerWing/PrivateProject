function test() {
    var app1 = document.getElementById("test1");
    var app2 = document.getElementById("test2");

    app1.innerHTML = "태그1";
    var span = app2.getElementsByTagName("span");
    span[0].innerHTML = "태그2";
    span[1].innerHTML = "태그2";
    span[2].innerHTML = "태그2";

}

function abc() {
    var test3 = document.getElementById("test3");
    test3.innerHTML = "APPLE";
    test3.align = "left";
    test3.style.color = "red";
}