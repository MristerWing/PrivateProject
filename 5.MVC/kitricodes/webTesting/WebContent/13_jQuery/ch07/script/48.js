$(() => {
    $("button")
        .eq(0)
        .click(() => {
            $("img")
                .eq(0)
                .hide();
            $("button")
                .eq(0)
                .css("display", "none");
        });
    $("button")
        .eq(1)
        .click(() => {
            $("img")
                .eq(0)
                .show();
            $("button")
                .eq(0)
                .css("display", "inline");
        });

    $("button")
        .eq(2)
        .click(() => {
            $("img")
                .eq(1)
                .hide("slow");
            $("button")
                .eq(2)
                .css("display", "none");
        });
    $("button")
        .eq(3)
        .click(() => {
            $("img")
                .eq(1)
                .show("5000");
            $("button")
                .eq(2)
                .css("display", "inline");
        });
});
