$(() => {
	console.log("${a}");
   /* $.ajax({
        url: "${root}/" + "pXML.do",
        type: "get",
        dataType: "xml",
        success: data => {
            var location = $(data)
                .children()
                .find("location");

            $(location).each((i, e) => {
                var city = $(e)
                    .find("city")
                    .text();

                var wf = $($(e).find("wf")[0]).text();

                $("#disp").append("<p>" + city + "</p>");
                $("#disp").append("<p>" + wf + "</p>");
            });
        }
    });*/
});
