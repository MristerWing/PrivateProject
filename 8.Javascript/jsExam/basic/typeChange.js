const numStr = "33.3";
const num = Number(numStr); //이행은 숫자값을 만듬
                            //Number 객체의 인스턴스가 아님.
console.log(num);

//문자값은 무시, 미 기재시 10진수로 인식
const a = parseInt("16 volts", 10);
const b = parseInt("3a", 16);
const c = parseFloat("15.5kph");

console.log(a, b, c);

//Date
const d = new Date(); //현재 날짜
const ts = d.valueOf(); //UTC 1970년 1월 1일 자정으로부터 몇 밀리초가 지났는지 나타내는 숫자

console.log(d);
console.log(ts);