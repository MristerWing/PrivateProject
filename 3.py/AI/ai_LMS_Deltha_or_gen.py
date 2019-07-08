##신경세포모델링 or 패턴, 일반테스트(제너럴 테스트)추가##
import math
x = [[1, 0, 0],
	[1, 0 , 1],
	[1, 1, 0],
	[1, 1, 1]
] #패턴(첫 차원은 바이어스를 위해 만들어둔것)

w = [0.02, 0.03, 0.02] #웨이트, 작은 값을 랜덤하게 넣는다
t = [0, 1, 1, 1] #타겟, 희망값
y = [0.0, 0.0, 0.0, 0.0] #결과값, 정답
xt = [0.0, 0.0, 0.0] #패턴
yt = 0.0 #결과값

alpha = 0.01 #학습률
error = 0.0 #에러
epoch = 0
old_tss = 0.0

print("Self Test:")
while(True):
	sum_of_error = 0.0 #에러의 합 tss total square sum
	for ptn in range(4): #패턴을 루프
		wated_sum = 0.0
		
		for i in range(3): #sum을 구한다(3개), 웨이트 * 입력값
			wated_sum += w[i] * x[ptn][i]
		
		#웨이트의 값이 0보다 크면 1 아니면 0, 계단함수 생성		
		if (wated_sum > 0): y[ptn] = 1.0 / (1.0 + math.exp(-wated_sum)) 
		else: y[ptn] = 0.0
		
		error = t[ptn] - y[ptn] #에러를 구한다. 타겟 - y(결과)
		#print("er: %.2f" %error)
		sum_of_error += error * error #에러의 합을 구한다. 에러값은 총량을 구하기 위해 제곱을 하여 절대값을 구한다.
		
		for i in range(3): #웨이트를 바꾼다 old웨이트 + 알파(학습률) * 에러 * 인풋(패턴)
			w[i] = w[i] + alpha * error * x[ptn][i]
	
	##웨이트와 결과값을 출력##
	print("epoch:", epoch + 1) #사이클의 횟수
	print("W:", end = "") #W의 값
	for i in range(0, 3, 1):	
		print("%.1f "%w[i], end = "")
	print("\nY:", end = "") #Y의 값
	for i in range(0, 4, 1):	
		print("%.4f "%y[i], end = "")
	print("\nsum of error(TSS): %.4f" %sum_of_error) #에러의 합
	if(epoch > 0 and old_tss - sum_of_error <= 0.00001): break #에러의 합이 0이면 정지
	epoch += 1 #사이클 횟수 증가
	old_tss = sum_of_error

print("Gen Test") #일반화 테스트
for i in range(10): #패턴은 초기화
	for j in range(10):
		xt[0] = 1.0
		xt[1] = i / 10
		xt[2] = j / 10
		wated_sum = 0.0
		for k in range(3): #sum을 구한다(3개), 웨이트 * 입력값
			wated_sum += w[k] * xt[k]
		#웨이트의 값이 0보다 크면 1 아니면 0, 계단함수 생성
		if (wated_sum > 0): yt = 1.0 
		#yt = 1.0 / (1.0 + math.exp(-wated_sum))
		else: yt = 0.0
		print("(%.1f	%.1f)	%.1f" %(i/10, j/10, yt))
		
input()
	
#일반화능력: 0.02 와 0.03이 or 연산을 하여 어떠한 값이 나올 것인지를 알아내는것. 값은 0이 나와야 한다
#셀프테스트: 지정된 값을 넣어서 테스트를 실행
#일반화 테스트: 아날로그 세상이라고 가정하여 패턴값을 0~1.0이라는 범위로 지정하여 테스트를 수행하는 것 일반화에서는 epoch대신에 입력의 몇번째 속성으로 수행.