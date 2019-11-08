const str = "id password email findpassword name registerdate";

const a = str.split(" ");
const converter = a.reduce((s, x) => s + "#{" + x + "}" + ", ", "");

console.log(converter);