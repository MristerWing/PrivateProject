function printDom(node, prefix) {
  console.log(prefix + node.nodeName);

  for (let i = 0; i < node.childNodes.length; i++) {
    printDom(node.childNodes[i], prefix + '\t');
  }
}

printDom(document, '');
console.log(document.getElementById('content'));
const callouts = document.getElementsByClassName('callout');
console.log(callouts);
const paragraphs = document.getElementsByTagName('p');
const rPar = [...paragraphs];
console.log(paragraphs);
console.log(rPar);