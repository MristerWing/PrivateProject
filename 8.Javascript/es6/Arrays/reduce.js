//reduce의 매개변수의 첫번째 요소는 누적(값이 저장되는 부분)이며, 두번째 요소는 배열의 index값이 된다.

const arr = [5, 7, 2, 4];
const sum = arr.reduce((a, x) => (a += x), 0);

console.log(arr, sum);

//누적값이 undefind라면 인덱스의 첫번째 값이 누적값의 시작값이 된다.
const sum2 = arr.reduce((a, x) => (a += x));

console.log(sum2);

//객체 또한 누적값으로 이용할 수 있다.
const words = [
  "Beachball",
  "Rodeo",
  "Angel",
  "Aardvark",
  "Xylophone",
  "November",
  "Chocolate"
];

const alphabetical = words.reduce((a, x) => {
  if (!a[x[0]]) a[x[0]] = [];
  a[x[0]].push(x);
  return a;
}, {});

for (let index in alphabetical) {
  console.log(index);
}

console.log(alphabetical);

// reduce 통계
// 도널드 커누스의 분산 계산을 위한 알고리즘
const data = [3.3, 5, 7.2, 12, 4, 6, 10.3];
const stats = data.reduce(
  (a, x) => {
    a.N++;
    let delta = x - a.mean;
    a.mean += delta / a.N;
    a.M2 += delta * (x - a.mean);
    return a;
  },
  { N: 0, mean: 0, M2: 0 }
);

if (stats.N > 2) {
  stats.variance = stats.M2 / (stats.N - 1);
  stats.stdev = Math.sqrt(stats.variance);
}

console.log(stats.variance + " | " + stats.stdev);

const words2 = [
  "Beachball",
  "Rodeo",
  "Angel",
  "Aardvark",
  "Xylophone",
  "November",
  "Chocolate",
  "Papaya",
  "Uniform",
  "Joker",
  "Clover",
  "Bail"
];

const longWords = words2
  .reduce((a, w) => w.length > 6 ? a + " " + w : a, "")
  .trim();
const filterAndJoin = words2
  .filter(w => w.length > 6)
  .join(" ")
  .trim();
console.log(longWords);
console.log(filterAndJoin);
