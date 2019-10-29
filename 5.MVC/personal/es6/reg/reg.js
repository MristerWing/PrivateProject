const input = "As I was going to Saint Ives";

console.log(input.startsWith("As"));
console.log(input.endsWith("Ives"));
console.log(input.startsWith("going", 9));

//3글자 이상, 대소문자를 구분하지 않음
const re = /\w{3,}/ig;

//문자열의 메소드를 사용
console.log(input.match(re));
console.log(input.search(re));

//정규식의 메소드를 사용
console.log(re.exec(input));
console.log(re.exec(input));
console.log(re.exec(input));
console.log(re.exec(input));
console.log(re.exec(input));
console.log(re.exec(input));

//정규식 리터럴 그대로 사용
console.log(/\w{3}/ig.test(input));

