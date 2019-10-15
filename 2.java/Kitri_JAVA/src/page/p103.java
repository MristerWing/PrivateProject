package page;

public class p103 {

	public static void main(String[] args) {

		// 4
		System.out.println("------------------------04---------------------");
		int pencils = 534;
		int students = 30;

		int pencilsPerStudent = (pencils / students);
		System.out.println(pencilsPerStudent);

		int pencilsLeft = (pencils % students);
		System.out.println(pencilsLeft);

		// 5
		System.out.println("------------------------05---------------------");
		int value = 356;
		System.out.println((value / 100) * 100);

		// 6
		System.out.println("------------------------06---------------------");
		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;
		double area = ((((double) lengthTop + (double) lengthBottom) * (double) height) / 2);
		System.out.println(area);

		// 7
		System.out.println("------------------------07---------------------");
		int x = 10;
		int y = 5;

		System.out.println((x > 7) && (y <= 5));
		System.out.println((x % 3 == 2) || (y % 2 != 1));
		
//		extra
		System.out.println("------------------------ex---------------------");
		int input = 10000;
		int price = 3610;
		int output = input - price;
		
		System.out.println("거스름돈-");
		System.out.println("결과: " + output);
		System.out.println("5000원권: " + output / 5000);
		output -= 5000;
		System.out.println("1000원권: " + output / 1000);
		output -= (output / 1000) * 1000;
		System.out.println("500원권: " + output/ 500);
		output -= (output / 500) * 500;
		System.out.println("100원권: " + output / 100);
		output -= (output / 100) * 100;
		System.out.println("50원권: " + output / 50);
		output -= (output / 50) * 50;
		System.out.println("10원권: " + output / 10);
	}

}
