$(document).ready(() => {
    $("a:first").click(() => {
        $("h2")
            .append($("span:eq(0)"))
            .clone();
    });

    $("a:last").click(() => {
        $("h1").append($("span:eq(1)"));
    });
});
