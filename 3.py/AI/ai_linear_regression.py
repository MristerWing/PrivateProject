#선형회귀 분석
'''x = [[54, 1],
     [82, 1],
     [45, 1],
     [67, 1],
     [60, 1]
]

y = [166, 174, 146, 172, 170]'''

inFp = None #파일포인터
inStr = "" #파일의 줄을 읽어올 변수
count = -1 #카운터, 라인을 읽음
temp = [] #파일 읽을때 파싱을 위한 임시변수
x = [] #x, 
y = [] #y, 

inFp = open("C:\PythonCode\data1.txt", "r") #파일 포인터를 읽음

while True :
	inStr = inFp.readline() #파일의 줄을 읽음
	if not inStr : #만약 읽을 줄이 없으면
		break #멈춤
	inStr = inStr.replace("\n", "") #라인을 읽어서 마지막의 \n을 없엠
	temp = inStr.split("\t") #\t로 라인을 구분하여 데이터를 저장(엑셀의 데이터 나누기)
	if count >= 0 :
		x.append([int(temp[0]), 1]) #첫번째 데이터를 읽어들임
		y.append(int(temp[1])) #두번째 데이터를 읽어들임
	count += 1
	
inFp.close() #파일 닫기

avg_x = 0.0 #x의 평균
sum_x = 0.0 #x의 합
avg_y = 0.0 #y의 평균
sum_y = 0.0 #y의 합
sum_xy = 0.0 #편차곱
sum_x_var = 0.0 #x의 편차제곱

for i in range(5):
    sum_x += x[i][0] #x값의 합을 구함
    sum_y += y[i] #y값의 합을 구함

avg_x = sum_x / 5 #x의 평균을 구함
avg_y = sum_y / 5 #y의 평균을 구함

for i in range(5):
    sum_xy += (x[i][0]-avg_x)*(y[i]-avg_y) #x의 절편과 y의 절편을 구하여 xy편차곱을 구함
    sum_x_var += (x[i][0]-avg_x)*(x[i][0]-avg_x) #의 편차제곱을 구함

print("%.1f %.1f %.1f %.1f" %(avg_x, avg_y, sum_xy, sum_x_var)) #x,y의 평균, 편차곱, x의 편차제곱을 표기

a = sum_xy / sum_x_var #회귀선의 기울기를 구함
b = avg_y - a*avg_x #회귀선의 Y절편을 구함

print("y = %.1fx +"%a, "%.1f"%b) #출력

x1 = float(input("your weight: ")) #X의 값을 받아 예측을 실시
ey = a * x1 + b #회귀선의 Y편편 * 회귀선의 기울기 * 원하는 값
print("W = %.1fx"%x1, "H = %.1f"%ey)

input()