const bruce = {name: "bruce"};
const madeline = {name: "Madeline"};

//이 함수는 어떤 객체에도 연결되지 않았지만 this를 사용함
function greet() {
    return `Hello, ${this.name}!`;
}

console.log(greet()); //this는 어디에도 묶이지 않음
console.log(greet.call(bruce));    
console.log(greet.call(madeline));

function update(brithYear, occupation) {
    this.brithYear = brithYear;
    this.occupation = occupation;
}

update.call(bruce, 1949, "singer");
update.call(madeline, 1942, "acterss");

console.log(bruce.name, bruce.brithYear, bruce.occupation);
console.log(madeline.name, madeline.brithYear, madeline.occupation);

update.apply(bruce, [1955, "actor"]);
update.apply(madeline, [1918, "writer"]);

console.log(bruce.name, bruce.brithYear, bruce.occupation);
console.log(madeline.name, madeline.brithYear, madeline.occupation);

const arr = [2, 3, -5, 15, 7];

console.log(Math.min.apply(null, arr), Math.max.apply(null, arr));
console.log(Math.min(...arr), Math.max(...arr));

//bind는 영구히 바꿈
const updateBruce = update.bind(bruce);

updateBruce(1904, "actor");
console.log(bruce.name, bruce.brithYear, bruce.occupation);
updateBruce.call(madeline, 1274, "king");
console.log(bruce.name, bruce.brithYear, bruce.occupation);
console.log(madeline.name, madeline.brithYear, madeline.occupation);

const updateBruce1949 = update.bind(bruce, 1949);
updateBruce1949("singer, songwriter");
console.log(bruce.name, bruce.brithYear, bruce.occupation);
