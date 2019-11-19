$(document).ready(() => {
    $("#btn").click(e => {
        var n = Math.ceil(Math.random() * 3);
        $(".img_may").append("<img src='../../images/" + n + ".jpg' />");
    });
});
