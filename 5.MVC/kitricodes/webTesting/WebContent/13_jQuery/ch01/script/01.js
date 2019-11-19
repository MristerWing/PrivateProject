var jquery = new jQuery(document); // 선택자 혹은 자바스크립트 객체

// ready = body onload
jquery.ready(testFunc);

function testFunc() {
    var arr = [1, 2, 3];
    arr = arr.map(a => a + 5);

    console.log(arr);
}
