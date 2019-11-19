$(document).ready(() => {
    $("#first").addClass("spotlight");
    $("#second").addClass("spotlight");
    $("#third").addClass("spotlight redtext");

    var arr = new Array();
    arr.push($("#first").text());
    arr.push($("#second").text());
    arr.push($("#third").text());

    console.log(arr.join("\n"));

    $("#third").removeClass("redtext");
});
