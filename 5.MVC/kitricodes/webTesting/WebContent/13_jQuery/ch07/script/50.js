$(() => {
    $("#slideUp").click(function() {
        $("div").slideUp();
    });
    $("#slideDown").click(function() {
        $("div").slideDown("slow");
    });
    $("#slideToggle").click(function() {
        $("div").slideToggle("slow");
    });
});
