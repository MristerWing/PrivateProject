$(document).ready(() => {
    var strHTML = $("#first").html();
    var strText = $("#first").text();

    var arr = [strHTML, strText];
    console.log(arr.join("\n"));

    var str = "<h2>HELLO!!</h2>";
    $("#second").html(str);
    $("#third").text(str);
});
