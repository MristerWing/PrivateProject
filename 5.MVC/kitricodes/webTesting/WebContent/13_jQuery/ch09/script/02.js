$(() => {
    $.ajax({
        url: "02_str.txt",
        type: "get",
        dataType: "text",
        success: (data, textStatus, jqXHR) => {
            console.log(textStatus, jqXHR);
            $("#resultDisplay").text(data);
        },
        error: (xhr, status, error) => {
            console.log(xhr, status, error);
        }
    });
});
