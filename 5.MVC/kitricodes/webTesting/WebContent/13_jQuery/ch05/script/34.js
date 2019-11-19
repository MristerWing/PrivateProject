$(document).ready(() => {
    var arr = [...$("#melon").parent()];

    $("#melon")
        .parents()
        .each((i, e) => {
            arr.push(e.tagName);
        });
    console.log(arr);
});
