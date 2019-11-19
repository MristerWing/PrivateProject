$(document).ready(() => {
    $("a").click(() => {
        $("p").empty();
        $("p").text("hello world");

        $("p").remove();
    });
});
