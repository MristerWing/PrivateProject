function solution(bridge_length, weight, truck_weights) {
	var answer = 0;
	let crossQeue = new Array();
	let indexNum = 1;
	let bridge_weight = 0;

	crossQeue.push({ weight: truck_weights[0], time: 0 });
	while (crossQeue.length > 0 || indexNum < truck_weights.length) {
		// 각 차량의 시간 증가
		crossQeue.forEach(e => {
			e.time++;
			if (e.time === bridge_length) {
				crossQeue.shift();
			}
		});

		// 다리 하중 계산
		bridge_weight = crossQeue
			.map(e => e.weight)
			.reduce((e1, e2) => (e1 += e2), 0);

		answer++;

		if (bridge_weight + truck_weights[indexNum] <= weight) {
			crossQeue.push({ weight: truck_weights[indexNum], time: 0 });
			indexNum++;
		}
	}

	return answer;
}

console.log(solution(100, 100, [10, 10, 10, 10, 10, 10, 10, 10, 10, 10]));
