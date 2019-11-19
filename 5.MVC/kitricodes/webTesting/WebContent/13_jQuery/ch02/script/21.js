$(document).ready(() => {
    $("ul:has(li)").css({
        backgroundColor: "#9AB92E",
        border: "1px solid #05184D"
    });

    $("li:empty").text("Hello jQuery!");
    $("li:parent").css("color", "white");
});
