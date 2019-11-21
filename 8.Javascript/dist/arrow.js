//const f1 = function() { return "hello";}
//or
const f1 = () => "hello!";

console.log(f1()); //const f2 = function (name) { return `Hello, ${name}!` };
//or

const f2 = name => `Hello, ${name}!`;

console.log(f2("DDA")); //const f3 = function(a, b) {return a + b};
//or

const f3 = (a, b) => a + b;

console.log(f3(3, 6));
const o = {
  name: 'Julie',
  greetBackwards: function () {
    const getReverseName = () => {
      let nameBackwards = '';

      for (let i = this.name.length - 1; i >= 0; i--) {
        nameBackwards += this.name[i];
      }

      return nameBackwards;
    };

    return `${getReverseName()} si eman ym, ollH`;
  }
};
console.log(o.greetBackwards());