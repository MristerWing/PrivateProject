package ch03;

public class Pro2 {

	public static void main(String[] args) {
		int[][] arr = { { 5, 5, 5, 5, 5 }, { 10, 10, 10, 10, 10 }, { 20, 20, 20, 20, 20 }, { 30, 30, 30, 30, 30 } };

		int total = 0;
		float average = 0;
		
		for(int[] index1: arr)
			for(int index2: index1) 
				total += index2;
		
		average = (float)total / ((float)arr.length * (float)arr[0].length);
				
		System.out.println("total = " + total);
		System.out.println("average = " + average);

	}

}
