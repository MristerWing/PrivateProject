$(document).ready(() => {
    // 오직 자식만 필터링
    $(".first:first-child").css("color", "red");
    $(".first>li:first").css("color", "blue");

    $(".first>li:nth-child(2)").css("color", "yellow");

    // 유일한 자식이 있는 것만 선택
    $("div b:only-child").css("color", "skyblue");
});
