$(document).ready(() => {
    $("#coffee")
        .next()
        .css("color", "springgreen");
    $("#coffee")
        .prev()
        .css("color", "pink");

    $("#strawberry")
        .nextAll()
        .css("color", "springgreen");
    $("#strawberry")
        .prevAll()
        .css("color", "pink");

    $("#citrus")
        .siblings()
        .css("color", "skyblue");
    $("#citrus")
        .siblings("#tomato")
        .css("fontSize", "20px");
});
