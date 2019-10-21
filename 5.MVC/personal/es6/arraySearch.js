const o = {name: "jerry"};
const arr = [1, 5, "a", o, true, 5, [1, 2], "9"];

console.log(arr.indexOf(5));
console.log(arr.lastIndexOf(5));
console.log(arr.indexOf("a"));
console.log(arr.lastIndexOf("a"));
console.log(arr.indexOf({name: "Jerry"}));
console.log(arr.indexOf(o));

console.log("---findIndex---");
const arrf = [{id: 5, name: "Judith"}, {id: 7, name: "Francis"}];
console.log(arrf.findIndex(o => o.id === 5));
console.log(arrf.findIndex(o => o.name === "Francis"));
console.log(arrf.findIndex(o => o === 3));

//조건이 안맞으면 unfinded반환
console.log("---find---");
console.log(arrf.find(o => o.id === 5));
console.log(arrf.find(o => o.id === 2));

//특정 인덱스보다 뒤에 있는 제곱수 찾기
console.log("---응용---");
const arrMulti = [1, 17, 16, 5, 4, 16, 10, 3, 49];
console.log(arrMulti.find((x, i) => i > 2 && Number.isInteger(Math.sqrt(x)))); //Math.sqrt = 제곱근을 반환