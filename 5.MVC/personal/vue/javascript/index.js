var app = new Vue({
    el: '#app',
    data: {
        message: new Date()
    }
});

let app2 = new Vue({
    el: '#app-2',
    data: {
        message: '이 페이지는' + new Date() + ' 에 로드 되었습니다.'
    }
});