const html = 'HTML with <a href="/one/">one link</a>, and some javaScript.' + '<script src="stuff.js">';

// |: 대체를 뜻하는 메타 문자 i: 대소구분 x g:전체를 검색
/* 
area를 a보다 먼저쓴 이유: 정규표현식은 왼쪽에서 오른쪽으로 평가하기 때문에 a를 먼저 평가하면 area의 a 또한 평가하게된다.  
그러므로 큰것을 먼저 평가를 해야만한다. (area가아닌 rea를 평가하게됨)
*/

const matches1 = html.match(/area|a|link|script|source/ig); // 첫시도

console.log(matches1);

