class Person {
    constructor(name) {
        this.name = name;
        this.id = Person.nextId++;
    }
}
Person.nextId = 0;
const jamie = new Person("Jamie");
const juliet = new Person("Juliet");
const peter = new Person("Peter");
const jay = new Person("Jay");

const arr = [jamie, juliet, peter, jay];

//option1: ID를 직접 비교하는 방법
console.log(arr.find(p => p.id === juliet.id)); //juliet객체

//option2: this 매개변수를 이용하는 방법
console.log(arr.find(function (p) {
    return p.id === this.id
}, juliet));