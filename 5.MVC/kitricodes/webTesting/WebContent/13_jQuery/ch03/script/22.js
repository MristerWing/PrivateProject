$(document).ready(() => {
    $("input[type='text']").val("값을 입력하세요.");
    $("input[type='text']").attr("style", "color:red");
    $("input[type='text']").click(e => {
        e.target.value = "";
    });

    $("#btn").click(() => {
        var email = $("input[name='email']").val();
        var id = $("input[name='email']").attr("id");
        console.log(email, id);
    });
});
