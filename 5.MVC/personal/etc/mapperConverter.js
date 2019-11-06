const str = "fileName path fileSize";

const a = str.split(" ");
const aLength = a.length;
const converter = a.reduce((s, x) => s + "#{" + x + "}" + ", ", "");

console.log(converter);