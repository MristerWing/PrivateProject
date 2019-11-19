$(document).ready(() => {
    $("#btn").click(() => {
        //$(".img_may").prepend($("img:last"));

        var arr = [];
        $(".img_may>img").each(function() {
            arr.push($(this).attr("src"));
        });

        $(".img_may>img:first").attr("src", arr[2]);
        $(".img_may>img:eq(1)").attr("src", arr[0]);
        $(".img_may>img:last").attr("src", arr[1]);
    });
});
