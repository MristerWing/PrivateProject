$(document).ready(() => {
    $("input:eq(0)")
        .val("아이디를 입력하세요")
        .css("color", "red");
    $("input:eq(1)")
        .val("이름을 입력하세요")
        .css("color", "red");

    $("input[type='text']").focus(e => {
        $(e.target)
            .val("")
            .css("color", "black");
    });

    $("input[type='text']").blur(e => {
        if ($(e.target).val() == "") {
            $(e.target)
                .val(
                    ($(e.target).attr("name") == "id" ? "아이디" : "이름") +
                        "를 입력하세요"
                )
                .css("color", "red");
        }
    });

    $("input[type='button']").click(() => {
        $("input[type='text']").each((i, e) => {
            console.log(i, $(e).val());
            if (
                $(e).val() ==
                ($(e.target).attr("name") == "id" ? "아이디" : "이름") +
                    "를 입력하세요"
            ) {
                alert("A");
                return;
            }
        });
        $("form").submit();
    });
});
