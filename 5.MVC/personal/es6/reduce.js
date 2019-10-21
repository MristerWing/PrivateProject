//reduce의 매개변수의 첫번째 요소는 누적(값이 저장되는 부분)이며, 두번째 요소는 배열의 index값이 된다.

const arr = [5, 7, 2, 4];
const sum = arr.reduce((a, x) => a += x, 0);

console.log(arr, sum);

//누적값이 undefind라면 인덱스의 첫번째 값이 누적값의 시작값이 된다.
const sum2 = arr.reduce((a, x) => a += x);

console.log(sum2);

//객체 또한 누적값으로 이용할 수 있다.
const words = ["Beachball", "Rodeo", "Angel", "Aardvark", "Xylophone", "November", "Chocolate"];

const alphabetical = words.reduce((a,x) => {
    if(!a[x[0]]) a[x[0]] = [];
    a[x[0]].push(x);
    return a;
}, {});

for(let index in alphabetical) {
    console.log(index);
}

console.log(alphabetical);