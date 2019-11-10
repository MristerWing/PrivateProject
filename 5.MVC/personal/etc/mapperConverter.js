const str = "id startDate endDate title attendee loc explan";

const a = str.split(" ");
const converter = a.reduce((s, x) => s + "#{" + x + "}" + ", ", "");

console.log(converter);