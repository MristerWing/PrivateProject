$(() => {
    $(".left").click(function() {
        $("#box").animate(
            {
                left: "0px"
            },
            1000,
            "swing",
            function() {
                console.log("left");
            }
        );
    });

    $(".right").click(function() {
        $("#box").animate(
            {
                left: "800px"
            },
            1000,
            "linear",
            function() {
                console.log("right");
            }
        );
    });
});
