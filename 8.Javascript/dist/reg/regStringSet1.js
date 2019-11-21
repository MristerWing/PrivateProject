//글자 하나를 다른것으로 대체하는 방법을 간단하게 줄인것.
//문자열의 숫자 모두 찾기
const beer99 = "99 bottles of beer on the wall" + "take 1 down and pass it around-- " + "98bottles of beer on the wall.";
const matches = beer99.match(/0|1|2|3|4|5|6|7|8|9/g); //matches를 간략화

const m1 = beer99.match(/[0123456789]/g);
const m2 = beer99.match(/[0-9]/g); //모두 같은 결과가 반환된다

console.log(matches + "\t" + m1 + "\t" + m2); //범위를 결합

const match = beer99.match(/[\-0-9a-z.]/ig); // /[.a-z0-9\-]/ 도 같다.
//하이픈(-)은 이스케이프해야한다. 그렇지 않으면 범위를 표시하는 메타문자라고 간주함(닫는 대괄호 바로 앞에 쓰는 하이픈 제외)
//특정문자열 제외: ^

const notMatch = beer99.match(/[^\-0-9a-z.]/ig);
console.log(match);
console.log(notMatch);