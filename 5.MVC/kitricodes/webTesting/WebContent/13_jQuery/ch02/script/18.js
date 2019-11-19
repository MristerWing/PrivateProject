$(document).ready(() => {
    $("#btn").click(() => {
        $("div:hidden").show();
    });

    $("div:visible").click(e => {
        $(e.target).css("background", "yellow");
    });
});
