$(document).ready(() => {
    $("#main>p")
        .first()
        .css("backgroundColor", "pink");

    $("#main>p")
        .last()
        .css("backgroundColor", "yellow");

    $("#main>p")
        .eq(2)
        .css("backgroundColor", "blue");

    $("#main")
        .find("p")
        .eq(1)
        .css("backgroundColor", "green");
});

console.log(document.getElementsByTagName("p"));
