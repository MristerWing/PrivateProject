$(document).ready(() => {
    $("#sel").change(e => {
        $("#img").attr("src", e.target.value);
    });
});
