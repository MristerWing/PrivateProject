package ch01;

public class Pro2 {
	public static void main(String[] arg) {
		int numOfApple = 123;
		int sizeOfBucket = 10;
		int numOfBucket = (numOfApple % sizeOfBucket != 0)?(numOfApple / sizeOfBucket) + 1:(numOfApple / sizeOfBucket);
		
		System.out.println("필요한 바구니의 수:" + numOfBucket);
	}
}
