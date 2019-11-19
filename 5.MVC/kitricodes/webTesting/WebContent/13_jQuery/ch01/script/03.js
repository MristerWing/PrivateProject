var jQueryDocument = new jQuery(document);
jQueryDocument.ready(disp);

function disp() {
    /* var a = new jQuery("*");
    a.addClass("redtext");

    var b = new jQuery("span");
    b.addClass("italictext");

    var c = new jQuery("div");
    c.addClass("boldtext");

    var d = new jQuery("span, div");
    d.addClass("backgroundtext"); */

    $(document).ready(() => {
        $("*").addClass("redtext");
        $("span").addClass("italictext");
        $("div").addClass("boldtext");
        $("span, div").addClass("backgroundtext");
    });
}
