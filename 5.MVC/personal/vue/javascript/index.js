const days = moment().endOf('month').format("DD")

var app = new Vue({
    el: '#app',
    data: {
        message: days
    }
});

let app2 = new Vue({
    el: '#app-2',
    data: {
        message: '이 페이지는' + new Date() + ' 에 로드 되었습니다.'
    }
});

let app3 = new Vue({
    el: '#app-3',
    data: {
        seen: true
    }
});

let app4 = new Vue({
    el: '#app-4',
    data: {
        todos: [
            {text: 'JavaScript 배우기'},
            {text: 'Vue 배우기'},
            {text: '무언가 멋진 것을 만들기'}
        ]
    }
});