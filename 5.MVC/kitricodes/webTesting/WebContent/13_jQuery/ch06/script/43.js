$(document).ready(() => {
    $("#menu1").click(e => {
        $(".theme_3").append("<li style='color:red'>천리포수목원 걷기축제</li>");
        $(e.target).unbind("click");
    });

    $("#menu2").one("click", () => {
        $(".theme_1").append("<li style='color:blue'>장미축제</li>");
    });
});
