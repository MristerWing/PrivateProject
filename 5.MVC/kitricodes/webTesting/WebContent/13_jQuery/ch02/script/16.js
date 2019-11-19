$(document).ready(() => {
    /*  $("#content a:first").click(() => {
        $(".theme *").css("backgroundColor", "white");
        $(".theme_1>li:eq(2)").css("backgroundColor", "lightgreen");
        $(".theme_2>li:eq(0)").css("backgroundColor", "lightgreen");
        $(".theme_3>li:eq(1)").css("backgroundColor", "lightgreen");
    });
    $("#content a:last").click(() => {
        $(".theme *").css("backgroundColor", "white");
        $(".theme_4>li:eq(0)").css("backgroundColor", "lightgreen");
        $(".theme_4>li:eq(2)").css("backgroundColor", "lightgreen");
    }); */
    $("#content a:first").click(() => {
        $(".theme *").removeClass("theme_hot");
        $(".theme_1>li:eq(2)").addClass("theme_hot");
        $(".theme_2>li:eq(0)").addClass("theme_hot");
        $(".theme_3>li:eq(1)").addClass("theme_hot");
    });
    $("#content a:last").click(() => {
        $(".theme *").removeClass("theme_hot");
        $(".theme_4>li:eq(0)").addClass("theme_hot");
        $(".theme_4>li:eq(2)").addClass("theme_hot");
    });
});
