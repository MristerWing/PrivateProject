$(() => {
    $(".leftbtn").click(() => {
        $("#leftimage").animate({ marginLeft: "-210px" }, 1000);
    });
    $(".rightbtn").click(() => {
        $("#leftimage").animate({ marginLeft: "0px" }, 1000);
    });
});
