const str = 'orange yellow green blue indigo violet';

const a = str.split(' ');
const converter = a.reduce((s, x) => s + "'" + x + "'" + ', ', '');

console.log(converter);
