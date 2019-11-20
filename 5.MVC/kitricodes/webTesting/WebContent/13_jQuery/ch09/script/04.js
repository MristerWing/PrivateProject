$(() => {
    $.ajax({
        url: "04_JOSN.txt",
        type: "get",
        dataType: "json",
        success: data => {
            console.log(data);
            var memberList = data.member;

            $(memberList).each(i => {
                var member = memberList[i];
                console.log(member.stdNumber, member.stdName, member.score);
                var arr = [...member];
                var span = arr.map(x => "<span>" + x + "&nbsp;&nbsp;" + "</span>");

                $("#resultDisplay").html(span);
            });
        },
        error(xhr, status, error) {
            console.log(xhr, status, error);
        }
    });
});
