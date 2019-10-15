package page;
import page.init.date0830.SportCar;;

public class Quiz0830 {
	
	public void p18208(int[][] arr) {
		int cnt = 0;
		int sum = 0;
		double avg;
		
		
		for(int i = 0;i < arr.length;i++) {
			for(int index : arr[i]) {
				sum += index;
				cnt ++;
			}
		}
		
		avg = (double)sum / (double)cnt;
		
		System.out.println("sum is " + sum);
		System.out.println("avg is " + avg);
		
	}

	public static void main(String[] args) {
		/*
		 * Quiz0830 q = new Quiz0830();
		 * 
		 * int[][] arr = {{95, 86}, {83, 92, 96}, {78, 83, 93, 87, 88}};
		 * 
		 * q.p18208(arr);
		 */
		
		SportCar car = new SportCar("Diablo");
		
		car.turnOnOff("on");
		car.accel();
		car.accel();
		car.accel();
		car.accel();
		car.accel();
		car.accel();
		car.accel();
		car.accel();
		car.accel();
		car.accel();
		car.accel();
		car.accel();
		car.accel();
		car.accel();
		car.accel();
		car.chargeGas(0);
		car.chargeGas(5);
		car.printSpeed();
		car.accel();
		car.stop();
		car.accel();
		car.chargeGas(100);
		car.boost();
		car.printSpeed();
		car.currentGas = 10;
		car.accel();
		car.turnOnOff("off");

	}

}
