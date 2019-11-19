$(() => {
    $(".big").click(() => {
        $("#box").animate(
            { width: "400px", height: "400px", opacity: 1 },
            { duration: 500 }
        );
    });

    $(".small").click(() => {
        $("#box").animate(
            { width: "50px", height: "50px", opacity: 0.1 },
            { duration: 1000 }
        );
    });

    $(".left").click(function() {
        $("#box").animate({ left: "0px" }, { duration: 1000 });
    });

    $(".right").click(function() {
        $("#box").animate({ left: "800px" }, { duration: 1000 });
    });
});
