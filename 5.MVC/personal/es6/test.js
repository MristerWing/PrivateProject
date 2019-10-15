'use strict';
//es6 블록 스코프 변수 선언
const sentences = [
    {subject: 'JavaScript', verb: 'is', object: 'great'},
    {subject: 'Elephants', verb: 'are', object: 'large'},
];

//es6 기능: 객체 분해
function say({subject, verb, object}) {
    //es6 기능: 템플릿 문자열
    //아래 사용한 것은 따옴표가 아니라 백틱(`), 즉
    //키보드의 탭 바로 위에 있는 문자열이다.

    console.log(`${subject} ${verb} ${object}`);
}

//es6기능: for..of
for (let s of sentences) {
    say(s);
}

const multiline = `line1
line2
line3`;

console.log(multiline);

const obj = {};

obj.color = "yellow";

obj["not an identifier"] = 3;
obj["not an identifier"];
obj["color"];

const SIZE = Symbol();
obj[SIZE] = 8;
obj[SIZE];

console.log(obj.color, obj["not an identifier"], obj[SIZE]);