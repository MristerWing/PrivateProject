###14 * 18###

import os

inStr = "" #파일의 줄을 읽어올 변수
outStr = "" #파일을 쓸 변수
count = 0 #카운터, 라인을 읽음
text_count = 0
temp = [] 
ar = ""
temp_data = ""
temp_bin = ""
fake_count = 0
temp_count = 0
file_num = 0

for file_num in range(0, 10):
	header = 0
	temp_sp = ""
	loop1 = 0
	loop2 = 1
	fake_count = 0
	count = 0
	h_count = 0
	ar = ""
	del temp[:]
	with open("%d.bmp" %file_num, "rb") as f: #파일 포인터를 읽음
		inStr = f.read(1) #파일의 줄을 읽음
		while inStr != b"":
			count += 1 #헤더확인을 위한 카운트
			if count > 10 and count < 15: header += int.from_bytes(inStr, byteorder='little')
			if count > 15 and count > header: #헤더가 전부 지나면 파일 추가
				temp_data = int.from_bytes(inStr, byteorder='little') #byte를 읽어서 int로 변환
				temp_bin = bin(temp_data).replace("0b", "")
				fake_count += 1
				temp_count = len(temp_bin)
				if(fake_count == 1 and temp_count != 8):
					for j in range(0, 8 - temp_count):
						ar += '0'
				elif(fake_count == 2): 
					if temp_count == 8:
						temp_bin = temp_bin[:6]
					else:
						for check_zero in range(temp_count - 1, 0, -1):
							if temp_bin[check_zero] == '0': temp_bin = temp_bin[:check_zero]
							else: break
						temp_count = len(temp_bin)
						for j in range(0, 6 - temp_count): ar += '0'
				if fake_count < 3:
					temp_bin = ar + temp_bin
					ar = ""
					temp.append(temp_bin)
				if fake_count == 4: fake_count = 0
			inStr = f.read(1)

	temp.reverse()
	while(loop2 < len(temp)):
		temp_sp = temp[loop1]
		temp[loop1] = temp[loop2]
		temp[loop2] = temp_sp
		print(temp[loop1], end ="")
		print(temp[loop2])
		loop1 += 2
		loop2 += 2
	
	text_count = 0
	with open("%d.txt" %file_num, "w") as f:#파일 포인터를 읽음
		for i in temp:
			for text in i:
				if(text_count == 14):
					f.writelines('\n')
					text_count = 0
				if str(text) == '0': f.writelines('1')
				elif str(text) == '1': f.writelines('0')
				text_count += 1

os.system("Pause")
