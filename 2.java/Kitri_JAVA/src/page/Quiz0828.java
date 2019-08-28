package page;

import java.util.InputMismatchException;
import java.util.Scanner;
import utils.*;

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

	public static void main(String[] args) {
		LambdaPractice lp;
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

		lp = () -> {
			int[] arr = new int[9];
			
			for(int i =0;i < 9;i++) {
				arr[i] = 2 * (i + 1);
				System.out.println(2 + " X " + (i + 1) + " = " + (2 * (i + 1)));
			}
		};
		lp.method();
	}

}
