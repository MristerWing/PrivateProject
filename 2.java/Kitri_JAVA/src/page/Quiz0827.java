package page;

import java.util.Iterator;

import utils.*;

public class Quiz0827 {
	
	public static void main(String[] args) {
		int jumsu = (int) (Math.random() * 100 + 1);

		System.out.println("" + jumsu);

		switch (jumsu / 10) {
		case 10:
			System.out.println('A');
			break;
		case 9:
			System.out.println('A');
			break;
		case 8:
			System.out.println('B');
			break;
		case 7:
			System.out.println('C');
			break;
		case 6:
			System.out.println('D');
			break;
		default:
			System.out.println('F');
			break;

		}

		printLine.l();

		int sum = 0;

		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
				sum += i;
			}
		}

		System.out.println("\n" + sum);

		printLine.l();

		int loop = 1;

		while (loop <= 100) {
			if (loop % 2 != 0)
				System.out.print(loop + " ");
			loop++;
		}

		System.out.println("");

		printLine.l();

		for (int i = 1; i <= 9; i++) {
			for (int j = 2; j <= 9; j++) {
				if (j - i != 1)
					System.out.print(j + " X " + i + " = " + i * j + "\t");
				else
					System.out.print("\t\t");
			}
			System.out.println("");
		}

		printLine.l();

		int cal = 1;

		for (int i = 0; i < 10; i++) {
			if (i <= 4)
				for (int j = i; j >= 0; j--) {
					System.out.print("*");
				}
			else {
				for (int j = i - cal; j >= 1; j--) {
					System.out.print("*");
				}
			}
			if (i >= 5)
				cal += 2;
			System.out.println("");
		}

		printLine.l();
		
		String blink = "     ";

		for (int i = 4; i >= 0; i--) {
			System.out.print(blink);
			for (int j = 5; j > i; j--) {
				System.out.print("*");
			}
			System.out.println("");
			blink = blink.substring(0, i);
		}

		printLine.l();
		
		int x = 15;
		int xgc = 0;
		int y = 20;
		int ygc = 0;
		int cm = 0;
		int loopw = 1;
		
		/*
		 * for(int i = 1;i < x;i++) { if(x % i == 0) xgc = i; }
		 * 
		 * for(int i = 1;i < y;i++) { if(y % i == 0) ygc = i; }
		 */
		
		while(loopw <= x && loopw <= y) {
			if(x % loopw == 0&&loopw != x) xgc = loopw;
			if(y % loopw == 0&&loopw != y) ygc = loopw;
			
			if(xgc == ygc) cm = ygc;
			
			loopw++;
		}
		
		System.out.println("x�� �ִ�����" + xgc);
		System.out.println("y�� �ִ�����" + ygc);
		System.out.println("�ּҰ����" + cm);
		
		printLine.l();
		
		
		System.out.println("" + 1 / 10);
		
		printLine.l();
		
		
		/*
		 * int num1 = (int) (Math.random() * 6 + 1); int num2 = 0; int num3 = 0; boolean
		 * overN1 = true; boolean overN2 = true; boolean overN3 = true;
		 * 
		 * do { num2 = (int) (Math.random() * 6 + 1); if (num1 != num2) { overN1 =
		 * false; } else continue; num3 = (int) (Math.random() * 6 + 1); if (num1 !=
		 * num3) { overN2 = false; } else { overN1 = true; continue; } if (num2 != num3)
		 * overN3 = false; else { overN1 = true; overN2 = true; } } while (overN1 &&
		 * overN2 && overN3);
		 * 
		 * 
		 * System.out.println("n1: " + num1 + " n2: " + num2 + " n3: " + num3);
		 */
		 
		
		
		
		int num1 = (int) (Math.random() * 45 + 1);
		int num2 = 0;
		int num3 = 0;

		do {
			num2 = (int) (Math.random() * 45 + 1);
			num3 = (int) (Math.random() * 45 + 1);
		} while (num1 == num2 || num1 == num3 || num2 == num3);

		System.out.println("n1: " + num1 + " n2: " + num2 + " n3: " + num3);
		 
		
		printLine.l();
		
		
	}

}
