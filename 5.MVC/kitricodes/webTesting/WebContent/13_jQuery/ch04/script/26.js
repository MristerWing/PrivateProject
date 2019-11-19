$(document).ready(() => {
    $("#first>p").append("일등품질 일등서비스 복체");
    $("#first>p").append("<h3>일등품질 일등서비스 복체</h3>");

    // 부모 => 자식으로 붙이기
    $("ul").append("<li style='color:red'>잡채만두</li>");
    $("ul").prepend("<li style='color:red'>찐만두</li>");

    $("<li style='color:#1DDB16'>납작만두</li>").appendTo("ul");
    $("<li style='color:#1DDB16'>고기만두</li>").prependTo("ul");

    // 형제에게 붙이기
    $("ul").after("<h3 style='color:#FF7373'>순대</h3>");
    $("ul").before("<h3 style='color:#FF7373'>쌀 떡볶이</h3>");

    $("<h3 style='color:blue'>내장순대</h3>").insertAfter("ul");
    $("<h3 style='color:blue'>밀 떡볶이</h3>").insertBefore("ul");
});

var first = document.getElementById("first");
//.inerHTML("<h4>HELLO!!</h4>");
//var p = first.childNodes[0];

console.log(first);
