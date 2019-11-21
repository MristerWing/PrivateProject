let arr = [1, 2, 3];
console.log("---pop, push---");
arr.push(4);
console.log(arr);
arr.pop();
console.log(arr);
arr.unshift(0);
console.log(arr);
arr.shift();
console.log(arr);
console.log("---concat---");
console.log(arr.concat(4, 5, 6), arr);
console.log(arr.concat([4, 5, 6]), arr);
console.log(arr.concat([4, 5], 6), arr);
console.log(arr.concat([4, [5, 6]]), arr); //음수는 배열의 끝에서 부터 시작

console.log("---slice---");
arr.push(4, 5);
console.log(arr.slice(3));
console.log(arr.slice(2, 5));
console.log(arr.slice(-2));
console.log(arr.slice(1, -2));
console.log(arr.slice(-2, -1));
console.log("---splice---");
const arr2 = [1, 5, 7];
console.log(arr2);
arr2.splice(1, 0, 2, 3, 4);
console.log(arr2);
arr2.splice(5, 0, 6);
console.log(arr2);
arr2.splice(1, 2);
console.log(arr2);
arr2.splice(2, 1, 'a', 'b');
console.log(arr2); //es6에서 도입

console.log("---copyWithin---");
const arr3 = [1, 2, 3, 4];
arr3.copyWithin(1, 2);
console.log(arr3);
arr3.copyWithin(2, 0, 2);
console.log(arr3);
arr3.copyWithin(0, -3, -1);
console.log(arr3); //es6에서 도입

console.log("---fill---");
const arr4 = new Array(5).fill(1);
arr4.fill("a");
console.log(arr4);
arr4.fill("b", 1);
console.log(arr4);
arr4.fill("c", 2, 4);
console.log(arr4);
arr4.fill(5.5, -4);
console.log(arr4);
arr4.fill(0, -3, -1);
console.log(arr4);
console.log("---reverse---");
arr.reverse();
console.log(arr);
console.log("---sort---");
arr.sort();
console.log(arr); //객체 정렬

const arrObj = [{
  name: "Suzanne"
}, {
  name: "Jim"
}, {
  name: "Trevor"
}, {
  name: "Amanda"
}]; //can't sort

arrObj.sort(); //foreach, 배열의 요소를 탐색

arrObj.forEach(element => {
  console.log(element.name);
});
console.log("------(a, b) => a.name > b.name-----");
arrObj.sort((a, b) => a.name > b.name);
arrObj.forEach(element => {
  console.log(element.name);
});
console.log("------(a, b) => a.name[1] < b.name[1]-----");
arrObj.sort((a, b) => a.name[1] < b.name[1]);
arrObj.forEach(element => {
  console.log(element.name);
});