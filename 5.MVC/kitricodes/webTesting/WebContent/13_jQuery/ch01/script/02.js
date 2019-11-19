var jquery = new jQuery(document); // 선택자 혹은 자바스크립트 객체

// ready = body onload
jquery.ready(() => {
    console.log("start");
});

new jQuery(document).ready(() => {
    console.log("jQuery Start!!");
});

$(document).ready(() => {
    var name = "json";
    console.log(`this is $ jqurey ${name}`);
});
