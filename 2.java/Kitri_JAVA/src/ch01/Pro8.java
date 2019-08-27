package ch01;

public class Pro8 {
	public static void main (String[] arg) {
		char ch = 'z';
		boolean b = (((ch >= 'A' && ch <= 'Z')||(ch >= 'a' && ch <= 'z'))||(ch >= '0'&&ch <= '9')); 
		
		System.out.println(b);
	}
}
