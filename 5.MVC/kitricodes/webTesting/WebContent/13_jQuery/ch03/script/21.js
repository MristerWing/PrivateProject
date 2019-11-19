$(document).ready(() => {
    $("span[id]").addClass("spotlight");
    $("span[id='simpletext1']").addClass("redtext");
    $("span[id != 'simpletext1']").addClass("bluetext");

    $("span[id ^= 'complex']").addClass("largetext");
    $("span[id $= 'text1']").addClass("italctext");
    $("span[id *= 'text']").addClass("box");
});
