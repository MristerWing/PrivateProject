function toServer(root) {
    // var url = "http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=109";
    var url = root + "/pXML.do";
    sendRequest("GET", url, fromServer, null);
}

function fromServer() {
    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
        var xmlDoc = xmlhttp.responseXML;
        var location = xmlDoc.getElementsByTagName("location");
        var disp = document.getElementById("disp");

        for (var i = 0; i < location.length; i++) {
            var city = location[i].getElementsByTagName("city");
            var data = location[i].getElementsByTagName("data");
            var div = document.createElement("div");
            let a = city[0].childNodes[0].nodeValue;
            
            // city
            var pCity = document.createElement("p");
            pCity.innerHTML = city[0].childNodes[0].nodeValue;
            pCity.role = "button";
            pCity.onclick = () => {
                alert(a + pCity.childNodes[0].nodeValue);
            };
            div.appendChild(pCity);

            // time
            var tmEf = data[0].getElementsByTagName("tmEf");
            var spanTmEf = document.createElement("span");
            spanTmEf.innerHTML = tmEf[0].childNodes[0].nodeValue + "&nbsp;&nbsp;";
            div.appendChild(spanTmEf);

            // werther
            var wf = data[0].getElementsByTagName("wf");
            var spanWf = spanTmEf.cloneNode();
            spanWf.innerHTML = wf[0].childNodes[0].nodeValue;
            div.appendChild(spanWf);

            disp.appendChild(div);
        } // i Loop end
    }
}
