$(() => {
    $("div").animate({ left: "400px", opacity: 0.5 }, 2000);
    $("div").animate({ top: "100px" }, 5000);
    $("div").slideUp(5000);
    $("div").slideDown(1000);
    $("div").animate({ left: "0px" }, 1000);
});
