$(document).ready(() => {
    $("#first")
        .children()
        .css("color", "red");

    var arr = [];
    $("#first")
        .children()
        .each((i, e) => {
            arr.push(i);
            arr.push(e.tagName);
            arr.push($(e).text());
        });

    console.log(arr.join("\n"));

    // 자식
    $("#first")
        .children("span")
        .css("fontSize", "20px");

    // 자손
    $("#first")
        .find("b")
        .css("border", "1px solid blue");
});
