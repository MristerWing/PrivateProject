###군집화###
#import numpy as np

inFp = None
inStr = ""
count = -1
temp = []
d = [] #읽어들인 데이터
#clsulter = 8

###파일 읽어들이는 부분###
inFp = open("C:\PythonCode\LearnData.txt", "r")

while True :
	inStr = inFp.readline()
	if not inStr :
		break
	inStr = inStr.replace("\n", "")
	temp = inStr.split("\t")
	if count >= 0 :
		d.append([int(temp[0]), float(temp[1]), float(temp[2]), float(temp[3]), float(temp[4]), 1])
	count += 1
	
inFp.close()
###파일 읽기 끝###

#data = np.array(d, dtype = float)

'''def myDist(p1, p2, dim) :
	dist = 0.0
	for i in range(dim) :
		dist += (p1[i] - p2[i]) * (p1[i] - p2[i])
	return dist'''

def myMin(key, r1, r2, r3, r4, r5, r6, r7, r8) : #데이터들과 각 대표군집간의 거리를 구하고 라벨링하는 함수
	dit = [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]
	#각 대표군집들의 데이터값과 데이터의 데이터값들의 거리를 비교한후 저장(사용하는 데이터: 1,2,3)
	dit[0] = (key[1] - r1[1]) * (key[1] - r1[1]) + (key[2] - r1[2]) * (key[2] - r1[2]) + (key[3] - r1[3]) * (key[3] - r1[3])
	dit[1] = (key[1] - r2[1]) * (key[1] - r2[1]) + (key[2] - r2[2]) * (key[2] - r2[2]) + (key[3] - r2[3]) * (key[3] - r2[3])
	dit[2] = (key[1] - r3[1]) * (key[1] - r3[1]) + (key[2] - r3[2]) * (key[2] - r3[2]) + (key[3] - r3[3]) * (key[3] - r3[3])
	dit[3] = (key[1] - r4[1]) * (key[1] - r4[1]) + (key[2] - r4[2]) * (key[2] - r4[2]) + (key[3] - r4[3]) * (key[3] - r4[3])
	dit[4] = (key[1] - r5[1]) * (key[1] - r5[1]) + (key[2] - r5[2]) * (key[2] - r5[2]) + (key[3] - r5[3]) * (key[3] - r5[3])
	dit[5] = (key[1] - r6[1]) * (key[1] - r6[1]) + (key[2] - r6[2]) * (key[2] - r6[2]) + (key[3] - r6[3]) * (key[3] - r6[3])
	dit[6] = (key[1] - r7[1]) * (key[1] - r7[1]) + (key[2] - r7[2]) * (key[2] - r7[2]) + (key[3] - r7[3]) * (key[3] - r7[3])
	dit[7] = (key[1] - r8[1]) * (key[1] - r8[1]) + (key[2] - r8[2]) * (key[2] - r8[2]) + (key[3] - r8[3]) * (key[3] - r8[3])
	min = dit[0] #각 대표군집간의 거리의 최소값을 구하기위해 min을 첫 데이터로 임시지정
	gr = 0 #라벨링값
	'''if(dist1 < dist2) :
		return (1, dist1, dist2)
	else :
		return (2, dist1, dist2)'''
	for i in range(clsulter) : #최솟값을 구하여 리턴
		if(min > dit[i]) :
			min = dit[i]
			gr = i+1 #라벨링
	if(gr == 0) : gr = 1 #만약 gr값이 변화가 없다면 임의로 넣은 처음 값이 최솟값이므로 데이터가 최솟값이므로 1군집으로 라벨링
	return (gr, dit[0], dit[1], dit[2], dit[3], dit[4], dit[5], dit[6], dit[7]) #라벨링 하여 리턴
'''def myMin(key, r1, r2) :
	dist1 = MyDist(key, r1)
	dist2 = MyDist(key, r2)
	if(dist1 < dist2) :
		return (1, dist1, dist2)
	else :
		return (2, dist1, dist2)'''

def myAvg(gr, adata) : #군집의 평균점을 구하여 기준군집을 재구성(그룹핑)
	sum = [0, 0, 0]
	avg = [0, 0, 0, 0, 0]
	clCount = 0 #미사용 변수?
	for i in range(count) :
		#print(gr, adata[i][5])
		if(adata[i][5] == gr) : #구하려는 데이터가 같은 군집이면
			#print(adata[i][1], adata[i][2], adata[i][3])
			#각 데이터들의 합을 구함
			sum[0] += adata[i][1] 
			sum[1] += adata[i][2]
			sum[2] += adata[i][3]
			clCount += 1
	avg[0] = adata[0][0] #미사용 데이터 값, 허수
	#각 데이터의 평균을 구하여 리턴
	avg[1] = sum[0] / clCount
	avg[2] = sum[1] / clCount
	avg[3] = sum[2] / clCount
	avg[4] = adata[0][4]#미사용 데이터 값
	return(avg)
	#print(clCount, sum[0])

###대표군집을 선언###	
m1 = d[0]
m2 = d[count - 1]
m3 = d[count//2]
m4 = d[count - 3]
m5 = d[count//2 + 1]
m6 = d[count//2 - 1]
m7 = d[count//2 + 2]
m8 = d[count//2 - 2]

###사이클(이포크)실시###
for epoch in range(10) :
	print("epoch", epoch+1) #이포크의 사이클을 알림
	###각 대표군집을 출력###
	print("m1:", "%.2f"%m1[1], "%.2f"%m1[2], "%.2f"%m1[3], "m2:", "%.2f"%m2[1], "%.2f"%m2[2], "%.2f"%m2[3])
	print("m3:", "%.2f"%m3[1], "%.2f"%m3[2], "%.2f"%m3[3], "m4:", "%.2f"%m4[1], "%.2f"%m4[2], "%.2f"%m4[3])
	print("m5:", "%.2f"%m5[1], "%.2f"%m5[2], "%.2f"%m5[3], "m6:", "%.2f"%m6[1], "%.2f"%m6[2], "%.2f"%m6[3])
	print("m7:", "%.2f"%m7[1], "%.2f"%m7[2], "%.2f"%m7[3], "m8:", "%.2f"%m8[1], "%.2f"%m8[2], "%.2f"%m8[3])
	for i in range(count) : #읽어온 라인 수 만큼
		min_i, d1, d2, d3, d4, d5, d6, d7, d8 = myMin(d[i], m1, m2, m3, m4, m5, m6, m7, m8) #각 대표군집과 데이터의 거리를 계산
		d[i][5] = min_i #나온 데이터를 토대로 라벨링
		print("%d"%min_i, "%.2f"%d1, "%.2f"%d2, "%.2f"%d3, "%.2f"%d4, "%.2f"%d5, "%.2f"%d6, "%.2f"%d7, "%.2f"%d8) #데이터 출력
		#print(min_i, d1, d2)
	#대표군집을 재구성
	m1 = myAvg(1, d)
	m2 = myAvg(2, d)
	m3 = myAvg(3, d)
	m4 = myAvg(4, d)
	m5 = myAvg(5, d)
	m6 = myAvg(6, d)
	m7 = myAvg(7, d)
	m8 = myAvg(8, d)
	

'''for i in range(count) :
	print(d[i][5])	'''
	

input()