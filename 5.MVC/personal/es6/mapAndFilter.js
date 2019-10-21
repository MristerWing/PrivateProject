//map
console.log("---map---");
const cart = [{name: "Widget", price: 9.95}, {name: "Gadget", price: 22.95}];
const names = cart.map(x => x.name);
const prices = cart.map(x => x.price);
const disCountPrices = prices.map(x => x * 0.8);

console.log(names, prices, disCountPrices);

const items = ["Java", "JavaScript"];
const years = [1995, 1996];
const language = items.map((x, i) => ({name: x, year: years[i]}));

console.log(language[0].name, language[1].name);