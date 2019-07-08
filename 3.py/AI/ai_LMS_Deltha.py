##신경세포 모델링, and 패턴##
x = [[1, 0, 0],
	[1, 0 , 1],
	[1, 1, 0],
	[1, 1, 1]
] #패턴

w = [0.02, 0.03, 0.02] #웨이트, 작은 값을 랜덤하게 넣는다
t = [0, 0, 0, 1] #타겟, 희망값
y = [0.0, 0.0, 0.0, 0.0] #결과값, 정답

alpha = 0.1 #학습률
error = 0.0 #에러

for epoch in range (10): #사이클을 루프
	for ptn in range(4): #패턴을 루프
		wated_sum = 0.0
		
		for i in range(3): #sum을 구한다(3개), 웨이트 * 입력값
			wated_sum += w[i] * x[ptn][i]
			
		if (wated_sum > 0): y[ptn] = 1.0 #웨이트의 값이 0보다 크면 1 아니면 0
		else: y[ptn] = 0.0
		
		error = t[ptn] - y[ptn] #에러를 구한다. 타겟 - y(결과)
		
		for i in range(3): #웨이트를 바꾼다 old웨이트 + 알파 * 에러 * 인풋
			w[i] = w[i] + alpha * error * x[ptn][i]
	
	##웨이트와 결과값을 출력##
	print("W:", end = "")
	for i in range(3):	
		print("%.1f"%w[i], end = "")
	print("\nY:", end = "")
	for i in range(3):	
		print("%.1f"%y[i], end = "")
	print("\n")