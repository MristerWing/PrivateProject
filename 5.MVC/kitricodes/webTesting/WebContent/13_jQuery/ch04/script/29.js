$(document).ready(() => {
    $("#content>li:first").click(() => {
        $("h2").replaceWith("<p class='festival'>봄여름 축제안내</p>");
        $("<h2> class='가을겨울축제안내'</h2>").replaceAll(".theme b:eq(1)");
    });
});
