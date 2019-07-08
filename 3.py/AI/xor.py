#신경세포 모델링 xor패턴, 3레이어(input, hidden, out)
#학습 - 셀프 테스트(w0, w1, w2, alpha 출력) - 일반화(별도 학습 필요 없이 w0, w1, w2값만 알면 된다.)
#net = sum 하위층 웨이트의 값은 2차원배열로 입력한다
from math import exp

inFp = None
inStr = ""
count = 0
upper = 0
old_tss = 0.0

x = [[],[],[]]
#x = [[1.0, 0.1, 0.1], [1.0, 0.1, 0.9], [1.0, 0.9, 0.1], [1.0, 0.9, 0.9]] #input node
t = [0.1, 0.9, 0.9, 0.1] #희망값
#x = [[1.0, 0.01, 0.01], [1.0, 0.01, 1.], [1.0, 1., 0.01], [1.0, 1., 1.]]
#t = [0.01, 1., 1., 0.01]
W = [[0.2, 0.1, 0.04], #히든레이어 - 인풋레이어의 웨이트
     [0.2, 0.03, 0.1],
     [0.04, 0.1, 0.2]]
Q = [0.2, 0.3, 0.01] #출력 레이어의 웨이트
y = [0.0, 0.0, 0.0] #midle node
error_L2 = [0.0, 0.0, 0.0] #레이어2의 에러
delta_L2 = [0.0, 0.0, 0.0] #레이어2의 델타값(미분값)
tss = 0.0 #에러의 합, total sum of squal
alpha = 0.9 #학습률
x1 = 0.0 #? 미사용
x2 = 0.0 #? 미사용
epoch = 1 #사이클값

inFp = open("C:\PythonCode\datax.txt", "r")

while True :
	inStr = inFp.readline()
	if not inStr :
		break
	inStr = inStr.replace("\n", "")
	x[count].append(int(inStr))
	upper += 1
	if upper % 3 == 0 :
		count += 1
	
inFp.close()

print(x)


def sigmoid(x): #시그모이드 함수
    fout = 1/(1 + exp(-x))
    return fout

#for epoch in range (10000):
while(True):
    tss = 0.0 #에러의 합을 초기화
    for p in range(3): #패턴만큼 루프
        
        # Feed-Forward Layer 1
        for j in range(3):
            y[j] = 0.0 #중간 노드 초기화
            for i in range(3):
                y[j] += W[j][i] * x[p][i] #중간값
            y[j] = sigmoid(y[j])
        # Feed-Forward Layer 2
        out = 0.0
        for i in range(3):
            out += Q[i] * y[i]
        out = sigmoid(out) #시그모이드값 구함


        # Error in OUTPUT Layer 에러 역전파 학습, EEP1 출력층에 대한 학습
        error_out = (t[p] - out) #에러값
        delta_out = error_out*out*(1-out) #미분값
        tss += error_out * error_out #에러의 합
        # Error in Layer 2
        for i in range(3):
            error_L2[i] = error_out * Q[i] #에러값
        for i in range(3):
            delta_L2[i] = error_L2[i]*y[i]*(1-y[i]) #델타값, 미분값

        # Change Weight Layer 2
        for i in range(3):
            Q[i] = Q[i] + alpha*delta_out*y[i] #미들 레이어의 웨이트
        # Change Weight Layer 1
        # 하위 레이어의 웨이트 값을 구한다.
        # EEP0, 입력층에 대한 학습
        # 하위 레이어의 에러값을 구한다. (상위 레이어의 에러값 * 상위 에러의 웨이트값)
        for j in range(3):
            for i in range(3):
               W[j][i] = W[j][i] + alpha*delta_L2[j]*x[p][i] #웨이트의 값 재구성
    print("epoch : %d, TSS: %f" %(epoch, tss))
    if tss <= 0.0000001: break
    epoch += 1



#End of Learning
for p in range(3):
    # Feed-Forward Layer 1
    for j in range(3):
        y[j] = 0.0
        for i in range(3):
            y[j] += W[j][i] * x[p][i]
        y[j] = sigmoid(y[j])
        # Feed-Forward Layer 2
    out = 0.0
    for i in range(3):
        out += Q[i] * y[i]
    out = sigmoid(out)

    print("%7.1f"%x[p][1], "%7.1f"%x[p][2], " : %7.1f"%out)
  
#결과 그래프는 말안장 모양이 나올수 있다
#일반적인 문제를 풀려면 값을 나눈뒤 나눠진 값을 구분하기 위한 레이어가 필요해진다. 그리하여 레이어를 2~3층이상으로 나누어 계산한다
#시험은 데이터입출력과 딥러닝 2층까지