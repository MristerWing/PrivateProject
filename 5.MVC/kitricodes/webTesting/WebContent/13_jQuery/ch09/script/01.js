$(() => {
    // XML, JSON(TEXT)
    $("#menu1").click(() => {
        $.ajax({
            url: "01_menu.html",
            type: "get",
            dataType: "html",
            success: toServer
        });
    });

    function toServer(data) {
        $("#message1").html(data);
    }

    // 익명함수 사용가능
    $("#menu2").click(() => {
        $.ajax({
            url: "01_menu.html",
            type: "get",
            datatype: "html",
            success: data => {
                $("#message2").html($(data).children("ul>li"));
            }
        });
    });
});
