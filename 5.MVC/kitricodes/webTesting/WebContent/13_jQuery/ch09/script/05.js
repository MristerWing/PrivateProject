$(() => {
    $.ajax({
        url: "05_XML.xml",
        type: "get",
        dataType: "xml",
        success: data => {
            var studentList = [
                ...$(data)
                    .children()
                    .find("student")
            ];
            $(studentList).each((i, studnet) => {
                var child = $(studnet).children();
                console.log($(studnet));
                $(child).each((i, e) => {
                    $("#resultDisp").append("<p>" + $(e).text() + "</p>");
                    console.log($(e));
                });
            });
        },
        error(xhr, status, error) {
            console.log(xhr, status, error);
        }
    });
});
