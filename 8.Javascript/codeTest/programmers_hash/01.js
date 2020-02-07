function solution(participant, completion) {
	var dic = completion.reduce(
		(obj, t) => ((obj[t] = obj[t] ? obj[t] + 1 : 1), obj),
		{}
	);
	console.log(dic);

	participant.sort();
	completion.sort();

	for (let i = 0; i < participant.length; i++) {
		if (i === participant.length - 1) return participant[i];
		else if (participant[i] !== completion[i]) {
			return participant[i];
		}
	}
}

console.log(solution(['leo', 'kiki', 'eden'], ['eden', 'kiki']));
