$(document).ready(() => {
    $("div:eq(0)").click(() => {
        var str = $("div:eq(0)").text();

        $("#disp").html("<div>" + str + "</div>");
    });

    $("div")
        .eq(0)
        .mouseover(() => {
            $("div")
                .eq(0)
                .css("color", "red");
        });

    $("div")
        .eq(0)
        .mouseout(() => {
            $("div")
                .eq(0)
                .css("color", "blue");
        });

    $("#hh").hover(
        function() {
            $(this).css("color", "skyblue");
        },
        e => {
            $(e.target).css("color", "pink");
        }
    );

    $("div")
        .eq(0)
        .bind({
            mouseover: () => {
                $("div")
                    .eq(0)
                    .css("color", "red");
            },
            mouseout: () => {
                $("div")
                    .eq(0)
                    .css("color", "blue");
            },
            click: () => {
                $("div")
                    .eq(0)
                    .text(
                        $("div")
                            .eq(0)
                            .text() + "a"
                    );
            }
        });
});
