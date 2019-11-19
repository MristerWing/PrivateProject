$(document).ready(() => {
    console.log(this);
    $("#one").one("click", () => {
        console.log(this);
        $(".menu").append("<li>여름 - 오이냉국</li>");
        $(".menu").append("<li>겨울 - 육개장</li>");
    });

    $(".menu").on("click", "li", () => {
        alert("국내산 식재료 사용");
    });

    $("#two").click(() => {
        $(".menu").off("click");
    });
});
