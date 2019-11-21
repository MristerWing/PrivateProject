function f(x) {
  return `in f: x=${x}`;
}

console.log(f(10)); //매개변수 해체

function getSentence({
  subject,
  verb,
  object
}) {
  return `${subject} ${verb} ${object}`;
}

const o = {
  subject: "I",
  verb: "love",
  object: "JavaScript"
};
console.log(getSentence(o));

function getSentenceAr([subject, verb, object]) {
  return `${subject} ${verb} ${object}`;
}

const arr = ["I", "am", "Ironman"];
console.log(getSentenceAr(arr)); //...을 이용해서 남는 매개변수를 이용하여 문자열을 합침

function addPrefix(prefix, ...words) {
  const prefixedWords = [];

  for (let i = 0; i < words.length; i++) {
    prefixedWords[i] = prefix + words[i];
  }

  return prefixedWords;
}

console.log(addPrefix("con", "verse", "vex")); //매개변수 기본값 지정

function def(a, b = "default", c = 3) {
  return `${a} - ${b} - ${c}`;
}

console.log(def(5, 6, 7));
console.log(def(5, 6));
console.log(def(5));
console.log(def()); //객체의 프로퍼티인 함수 (method)

const checkMethod = {
  name: "Wallce",
  //원시 값 프로퍼티
  bark: function () {
    return "woof!";
  } //함수 프로퍼티(매서드)

};
console.log(checkMethod.bark()); //this

const checkThis = {
  name: "Wallce",

  speak() {
    return `My name is ${this.name}!`;
  }

};
console.log(checkThis.speak());
const speak = checkThis.speak; //true; 두 변수는 같든 함수를 가르킨다.

console.log(speak === checkThis.speak); //true

console.log(speak()); //unfined
//중첩함수 this처리법, 다른 변수에 this를 할당해서 처리

const toManyThis = {
  name: 'Julie',
  greetBackwards: function () {
    const self = this; //this를 할당

    function getReverseName() {
      let nameBackwards = "";

      for (let i = self.name.length - 1; i >= 0; i--) {
        nameBackwards += self.name[i];
      }

      return nameBackwards;
    }

    return `${getReverseName()} si eman ym ,ollH`;
  }
};
console.log(toManyThis.greetBackwards());