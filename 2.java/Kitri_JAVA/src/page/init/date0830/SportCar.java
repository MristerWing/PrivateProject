package page.init.date0830;

/*시동걸어야감, 메이커 정해짐 가스게이지 정해짐
생성자로 차이름받음
gas없으면 멈춤

var
boolean Power
String carName
String maker
int MaxSpeed = 300
int CurrentSpeed
int maxGas = 200
int currentGas 


method()
turnOnOff(String)
accel 호출시 speed+20 gas-10
stop speed -10
chargeGas(int gas) 단, 가스가 넘치치 않게
printSpeed*/

public class SportCar {

	boolean power = false;
	String carName;
	String maker = "Lamborghini";
	int maxSpeed = 300;
	int currentSpeed = 0;
	int maxGas = 200;
	public int currentGas = 0;

	public SportCar(String inName) {
		this.carName = inName;
	}

	// 소문자로만 값을 받습니다.
	public void turnOnOff(String key) {
		if (key.equals("on")) {
			this.currentGas = this.maxGas;
			power = true;
			System.out.println("시동을 켰습니다. 현제 기름: " + currentGas);
		} else if (key.equals("off")) {
			if (!power) {
				System.out.println("시동이 꺼져있습니다. 시동을 키세요");
			} else {
				power = false;
				System.out.println("시동을 껐습니다.");
			}
		} else {
			System.out.println("올바른 값이 아닙니다.");
		}
	}

	// speed+20 gas-10
	public void accel() {
		if (power) {
			this.currentGas -= 10;
			if (currentSpeed >= maxSpeed)
				System.out.println("이미 최대 속력에 도달해 있습니다.");
			else if (currentGas <= 0) {
				System.out.println("기름이 다 떨어졌습니다. 시동을 종료합니다.");
				power = false;
			} else {
				this.currentSpeed += 20;
			}
		} else {
			System.out.println("시동이 꺼져있습니다. 시동을 키세요");
		}

	}

//	speed -10
	public void stop() {
		if (power) {
			if (currentSpeed > 0) {
				System.out.println("정지합니다.");
				currentSpeed = 0;
			} else {
				System.out.println("이미 정지상태 입니다.");
			}
		} else {
			System.out.println("시동이 꺼져있습니다. 시동을 키세요");
		}
	}

//	단, 가스가 넘치치 않게
	public void chargeGas(int gas) {
		if (power) {
			if (gas <= 0) {
				System.out.println("들어오는 값이 0이거나 0이하 입니다.");
			} else if (currentGas < maxGas && currentGas + gas < maxGas) {
				currentGas += gas;
			} else if (currentGas == maxGas && currentGas + gas > maxGas) {
				System.out.println("기름이 이미 다 차거나 넘치는 량입니다. 더 충전할 수 없습니다.");
			}
		} else {
			System.out.println("시동이 꺼져있습니다. 시동을 키세요");
		}
	}

	public void printSpeed() {
		if (power) {
			System.out.println("Speed: " + this.currentSpeed);
		} else {
			System.out.println("시동이 꺼져있습니다. 시동을 키세요");
		}

	}
	
	//Boost Thread 처리
	public void boost() {
		if (power) {
			if(currentGas <= 50) {
				System.out.println("현재 기름양이 너무 작아 부스터를 킬수가 없습니다.");
			}else {
				this.printSpeed();
				int tmp = currentSpeed;
				currentSpeed = maxSpeed;
				currentGas -= 50;
				System.out.println("부스터를 사용합니다.");
				try {
					for(int i = 1;i <= 5;i++) {
						System.out.print("부스터 지속 시간: " + i + "초 ");
						this.printSpeed();
						Thread.sleep(1000);
					}
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					currentSpeed = tmp;
					System.out.print("부스터를 종료합니다. ");
					this.printSpeed();
				}
				
			}
		} else {
			System.out.println("시동이 꺼져있습니다. 시동을 키세요");
		}
	}

}
