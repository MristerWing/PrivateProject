package ch04;

public class Pro4 {
	
	public static boolean isNumber(String str) {
		int index1 = 0;
		int index2 = 1;
		int isInt;
		
		if(str == null||str.equals("")) {
			return false;
		}
		while(true) {
			String s = str.substring(index1, index2);
			
			//예외처리 사용하여 String에서 Integer로 변환 실패시 false값 리턴
			try {
				isInt = Integer.parseInt(s);
			}catch(NumberFormatException e) {
				return false;
			}
			
			index1++;
			index2++;
			if(index2 > str.length()) break;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		String str = "123";
		System.out.println(str + "는 숫자입니까?" + isNumber(str));
		str = "1234o";
		System.out.println(str + "는 숫자입니까?" + isNumber(str));

	}

}
