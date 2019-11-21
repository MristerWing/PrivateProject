const beer99 = "99 bottles of beer on the wall" + "take 1 down and pass it around-- " + "98ab bottles of beer on the wall.";
const match = beer99.match(/(?:[0-9]{2,4}[a-z]{2,4})/g);
console.log(match);
var idReg = /(?:[0-9][a-z]){2,13}/g;
const id = "12345678910absda asd 4532wqe";
console.log(id.match(idReg));
var resReg2 = /^[1-4][0-9]{6}$/;
console.log(resReg2.test("1234567789"));