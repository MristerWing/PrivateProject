// make a card deck!
const cards = [];
for(let suit of['H', 'C', 'D', 'S'])
    for(let value=1; value <= 13; value++)
    cards.push({suit, value});

// value가 2인 카드
cards.filter(c => c.value === 2);

// diamond
cards.filter(c => c.suit === 'D');

// 킹, 퀸, 주니어
cards.filter(c => c.value > 10);

// 하트의 킹, 퀸 주니어
cards.filter(c => c.value > 10 && c.suit === 'H');

//카드덱을 문자열로 표현
function cardToString(c) {
    const suits = {'H': '\u2665', 'C': '\u2663', 'D': '\u2666', 'S': '\u2660'};
    const values = {1: 'A', 11: 'J', 12: 'Q', 13: 'K'};
    //cardToString을 호출할 때마다 매번 값을 만드는 건 그리 효율적인 방법은 아니다. 해결해보자
    for(let i = 2; i <= 10; i++) values[i] = i;
    return values[c.value] + suits[c.suit];
}

console.log(cards.filter(c => c.value === 2).map(cardToString));
console.log(cards.filter(c => c.value > 10 && c.suit === 'H').map(cardToString));