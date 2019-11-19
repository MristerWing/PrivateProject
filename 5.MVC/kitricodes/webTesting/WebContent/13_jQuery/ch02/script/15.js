$(document).ready(() => {
    $("p:even").css("color", "red");
    $("p:first").css("color", "blue");
    $("p:last").css("color", "pink");
    $("p:eq(2)").css("color", "yellow");

    $(".first>li:even").css("color", "red");
    $(".first>li:odd").css("color", "blue");

    $(".second>li:first").css("color", "red");
    $(".second>li:last").css("color", "blue");
    $(".second>li:eq(2)").css("color", "yellow");

    $(".third>li:gt(2)").css("color", "green");
    $(".third>li:lt(2)").css("color", "skyblue");
    $(".third>li:not(:eq(2))").css("fontWeight", "bold");
});
