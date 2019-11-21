//공백 문자 찾기 /s
const stuff = 'hight:   9\n' + 'medium:    5\n' + 'low:   2\n';
const levels = stuff.match(/:\s*[0-9]/g); // *는 숫자는 상관없으며 없어도된다는 의미

console.log(levels); //전화번호 파싱

const messyPhone = '(505) 555-1515';
const neatPhone = messyPhone.replace(/\D/g, '');
console.log(neatPhone); //requried 필드(공백이 아닌 글자가 최소한 하나는 있어야 하는 필드) 검사

const field = ' something   ';
const valid = /\S/.test(field);
console.log(valid);