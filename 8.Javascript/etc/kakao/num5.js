function solution(stones, k) {
    var answer = 0;
    var jump = 0;
    var count = 0;

    for (var i = 0; i < stones.length; i++) {
        if (stones[i] == k) {
            jump = i;
            count++;

            if (k != 0) {
                while (jump > 0) {
                    if (stones[--jump] - k <= 0) {
                        count++;
                        if(count === k) {
                            answer = count;
                            break;
                        }
                    } else {
                        count = 0;
                        break;
                    }
                }
                
            }
        }
    }

    return answer;
}

var stones = [2, 4, 5, 3, 2, 1, 4, 2, 3, 1];
var k = 3;

console.log(solution(stones, k));
