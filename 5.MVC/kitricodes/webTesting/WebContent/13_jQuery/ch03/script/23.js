$(document).ready(() => {
    $("#btn").click(() => {
        if ($("#id").val() == "") {
            alert("id를 입력해 주세요.");
            $("#id").focus();
            return;
        } else if ($("#name").val() == "") {
            alert("이름을 입력해 주세요.");
            $("#name").focus();
            return;
        }

        var radioStr = $("input[name='gender']:checked").val();
        if (radioStr == null) {
            alert("성별을 체크해 주세요");
            return;
        }

        var checkStr = "";
        $("input[name='hobby']:checked").each((i, e) => {
            //checkStr += e.value + ", ";
            checkStr += $(e).val() + ", ";
        });

        /* $("input[name='hobby']:checked").each(function() {
            checkStr += $(this).val() + ", ";
        }); */

        $("input[name='hobbyResult']").val(checkStr);

        console.log(checkStr);

        if (checkStr == "") {
            alert("취미를 체크해 주세요");
            return;
        }

        $("#form").submit();
    });
});
