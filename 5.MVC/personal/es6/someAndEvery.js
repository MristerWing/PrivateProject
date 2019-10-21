console.log("---some---");
const arr = [5, 7, 12, 15, 17];
console.log(arr.some(x => x%2 === 0));
console.log(arr.some(x => Number.isInteger(Math.sqrt(x))));

console.log("---every---");
const arre = [4, 6, 16, 36];
console.log(arre.every(x => x% 2 === 0));
console.log(arre.every(x=> Number.isInteger(Math.sqrt(x))));