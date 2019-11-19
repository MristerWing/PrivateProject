var main = document.getElementById("main");
$(document).ready(() => {
    $("#main>div")
        .not("middle")
        .css("backgroundColor", "pink");
    $("#main")
        .find("div")
        .not("#sub")
        .css("fontSize", "25px");

    $("#main>p")
        .slice(1, 3)
        .css("backgroundColor", "blue");
});

console.log(main);
