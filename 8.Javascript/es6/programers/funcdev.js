function solution(progresses, speeds) {
	var answer = [];
	let qeue = new Array();
	let loop = 0;

	// 개발 상황 큐 생성
	for (let i = 0; i < progresses.length; i++) {
		loop = 0;
		while (progresses[i] < 100) {
			progresses[i] += speeds[i];
			loop++;
		}
		qeue.push(loop);
	}

	// 배포 갯수 확인
	let firstProgresses = qeue.shift();
	let complete = 1;

	while (qeue.length > 0) {
		let data = qeue.shift();
		if (firstProgresses >= data) complete++;
		else {
			answer.push(complete);
			complete = 1;
			firstProgresses = data;
		}
	}
	answer.push(complete);

	return answer;
}

console.log(solution([93, 30, 55], [1, 30, 5]));
