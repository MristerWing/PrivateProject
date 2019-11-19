$(() => {
    $("#fadeOut").click(() => {
        $("img").fadeOut("5000");
    });

    $("#fadeIn").click(() => {
        $("img").fadeIn("5000");
    });

    $("#fadeToggle").click(() => {
        $("img").fadeToggle("5000");
    });
});
