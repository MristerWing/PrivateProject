package ch03;

public class Pro1 {

	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50};
		int sum = 0;
		
		for(int index : arr)
			sum += index;
		
		System.out.println("sum = " + sum);
	}

}
