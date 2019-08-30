package page;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import utils.printLine;

public class Quiz0828 {

	public void Quiz5() {
		// 136p 5
		for (int x = 0; x <= 10; x++) {
			for (int y = 0; y <= 10; y++) {
				if ((4 * x) + (5 * y) == 60)
					System.out.println("4 * " + x + "(x) + " + "5 * " + y + "(y) = " + ((4 * x) + (5 * y)));
			}
		}
		printLine.l();
	}
	

	@FunctionalInterface
	public interface LambdaPractice {
		public void method();
	}
	
	@FunctionalInterface
	public interface LambdaSwap {
		public int[] method(int[] arr);
	}

	public static void main(String[] args) {
		LambdaPractice lp;
		LambdaSwap swap;
		Scanner in = new Scanner(System.in);
		Quiz0828 q = new Quiz0828();
		
		

		// 136p
		// q.Quiz5();

		// 가위바위보
		lp = () -> {
			int quiz = (int) (Math.random() * 3);
			int input;
			boolean win = false;

			System.out.print("가위바위보 입니다. 0:가위 1: 바위 2:보");

			do {
				input = in.nextInt();

				if (input == quiz) {
					System.out.println("비겼습니다.");
				} else if (input > 2 || input < 0) {
					System.out.println("잘못된 값 입니다.");
				} else if (((input - quiz) + 3) % 3 == 1) {
					System.out.println("이겼습니다.");
					win = true;
				} else {
					System.out.println("졌습니다.");
				}
			} while (!win);

			printLine.l();
			in.close();
		};
		// lp.method();

//		20고개 1 ~ 100까지 값을 냄 기회5번
		lp = () -> {
			int quiz = (int) (Math.random() * 100 + 1);
			int input;
			int count = 0;

			System.out.println(quiz + "스무고개, 1 ~ 100사이의 값을 맞추세요.(기회5번)");

			while (count < 5) {

				try {
					input = in.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("숫자가 아닙니다.");
					in.nextLine();
					continue;
				}

				if (input == quiz) {
					System.out.println("정답!");
					break;
				} else if (input <= 0 || input > 100) {
					System.out.println("값은 1 ~ 100사이의 값입니다. 다시 입력하세요");
					continue;
				} else if (input > quiz) {
					System.out.println("값이 더 낮아요.");
				} else if (input < quiz) {
					System.out.println("값이 더 높아요.");
				}
				count++;
			}

			if (count >= 4) {
				System.out.println("기회를 전부 다 쓰셨습니다. 다음기회에...");
			} else {
				System.out.println("답은 " + quiz);
			}

			in.close();

		};
		//lp.method();
		
		//reverse lambda
		swap = arr -> {
			
			for(int j = 0;j < (arr.length - 1) / 2;j++) {
				int tmp = arr[Math.abs(j - (arr.length - 1))];
				arr[Math.abs(j - (arr.length - 1))] = arr[j];
				arr[j] = tmp;
			}
			
			return arr;
		};
		
//		배열1
		lp = () -> {
			int[] arr = new int[9];
			
			int sum = 0;
			double avg = 0.0;
			int max = 0;
			int min = 0;
			
			for(int i =0;i < 9;i++) {
				arr[i] = 2 * (i + 1);
				
				
				if(i == 0) min = arr[i];
				
				sum += arr[i];
				if(min > arr[i]) min = arr[i];
				if(max < arr[i]) max = arr[i];
				
				System.out.println(2 + " X " + (i + 1) + " = " + (2 * (i + 1)));
			}
			
			System.out.println("sum is " + sum);
			avg = (double)sum / 9.0;
			System.out.println("avg is " + avg);
			System.out.println("max is " + max);
			System.out.println("min is " + min);
			
			System.out.println(Arrays.toString(swap.method(arr)));
			
		};
		lp.method();
		
//		배열1 reverse
		lp = () -> {
			int[] arr = new int[9];
			
			for(int i = 8;i >= 0;i--) {
				arr[Math.abs(i - (arr.length - 1))] = 2 * (i + 1);
				System.out.println(2 + " X " + (i + 1) + " = " + (2 * (i + 1)));
			}
			
			System.out.println(Arrays.toString(arr));
		};
		
//		lp.method();
	}

}
