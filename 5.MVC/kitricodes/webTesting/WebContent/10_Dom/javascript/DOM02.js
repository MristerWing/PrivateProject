function test() {
    var font = document.getElementsByTagName("font");
    var span = font[0].getElementsByTagName("span");
    span[0].innerHTML = "HELLO";
    span[1].innerHTML = "WORLD!";
}