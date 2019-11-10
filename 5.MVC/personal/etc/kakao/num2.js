function solution(s) {
    var answer = [];
    var treg = /{+|}+/g;

    var arr = s.split('},');
    arr = arr.map(a => a.replace(treg, ''));
    arr.sort((a, b) => a.length - b.length);
    for (var i = 0; i < arr.length; i++) {
        if (arr[i].length != 1) {
            var str = arr[i].split(',');
            for (var j = 0; j < str.length; j++) {
                answer.push(str[j]);
            }
        } else {
            answer.push(arr[i]);
        }
    }

    answer = [...new Set(answer)];

    console.log(arr);

    for (var k = 0; k < answer.length; k++) {
        answer[k] = parseInt(answer[k]);
    }

    return answer;
}

var s = '{{1,2,3},{2,1},{1,2,4,3},{2}}';

console.log(solution(s));
