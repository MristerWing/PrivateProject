$(() => {
    $("#btn").click(() => {
        var id = $("#id").val();
        var password = $("#password").val();
        var sendData = "id=" + id + "&password=" + password;

        $.ajax({
            url: "03_idCheck.jsp",
            type: "post",
            data: sendData,
            dataType: "text",
            contextType: "application/x-www-form-urlencoded:charset=utf-8",
            success: data => {
                $("#resultDisplay").html(data);
            },
            error(xhr, status, error) {
                console.log(xhr, status, error);
            }
        });
    });
});
