$(() => {
    $("#btn").click(() => {
        var id = $("#id").val();
        var password = $("#password").val();
        var sendData = "id=" + id + "&password=" + password;
        
        console.log(sendData);

        $.ajax({
            url: "03_idCheck.jsp?" + sendData,
            type: "get",
            dataType: "text",
            success: data => {
                $("#resultDisplay").html(data);
            },
            error(xhr, status, error) {
                console.log(xhr, status, error);
            }
        });
    });
});
