function solution(user_id, banned_id) {
    var answer = 0;
    var reg;

    var max = -1;
    var tmp = 0;

    user_id = [...new Set(user_id)];
    banned_id = [...new Set(banned_id)];

    for (var i = 0; i < banned_id.length; i++) {
        var s = banned_id[i].replace(/[*]/g, '.*');
        reg = new RegExp(s);
        for (var j = 0; j < user_id.length; j++) {
            if (reg.test(user_id[j]) && banned_id[i].length === user_id[j].length) {
                tmp++;
                console.log(user_id[j]);
            }
            if(tmp > max) {
                max = tmp;
                tmp = 0;
            }
        }
        
    }

    answer = max;

    return answer;
}

var arr = ["frodo", "fradi", "crodo", "abc123", "frodoc"];
var arr2 = ["fr*d*", "*rodo", "******", "******"];

console.log(solution(arr, arr2));
