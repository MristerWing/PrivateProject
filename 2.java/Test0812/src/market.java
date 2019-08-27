import java.util.Arrays;

public class market {

	static int sockMerchant(int n, int[] ar) {

		int compare = 0;
		int count = 0;

		do {
			count = 0;
			for (int i = 1; i < n; i++) {
				if (ar[i - 1] > ar[i]) {
					int tmp = ar[i];
					ar[i] = ar[i - 1];
					ar[i - 1] = tmp;
					count++;
				}
			}
		} while (count != 0);

		for (int j = 1; j < n; j++) {
			int temp = ar[j - 1];
			if (temp == ar[j]) {
				compare++;
				j++;
			}
		}
		return compare;
	}

	static int countingValleys(int n, String s) {
		int mount = 0;
		int count = 0;
		boolean state = false;

		for (int i = 0; i < n; i++) {
			String loc = s.substring(i, i + 1);
			if (loc.equals("U")) {
				mount++;
				state = true;
			} else if (loc.equals("D")) {
				mount--;
				state = false;
			}
			if (state && mount == 0)
				count++;
		}

		return count;
	}

	static long repeatedString(String s, long n) {
		int count = 0;
//        int docLoop = 0;
		long addStringCount;
		long result;
		long isMOD;
		// long addString = n - s.length();
		String letter = "a";

		if (s.length() == 1 && s.equals(letter)) {
			return n;
		} else {
			/*
			 * for(long j = 0;j < n;j++) { if(docLoop >= s.length()) docLoop = 0; String doc
			 * = s.substring(docLoop, docLoop + 1); if(letter.equals(doc)) count++;
			 * docLoop++; }
			 */
			for (int i = 0; i < s.length(); i++) {
				String doc = s.substring(i, i + 1);
				if (letter.equals(doc))
					count++;
			}
			if (count == 0)
				return count;
			addStringCount = n / s.length();
			isMOD = n % s.length();
			result = addStringCount * count;
			if (isMOD != 0) {
				for (int j = 0; j < isMOD; j++) {
					String doc = s.substring(j, j + 1);
					if (letter.equals(doc))
						result++;
				}
			}
		}
		return result;
	}

	static long aVeryBigSum(long[] ar) {
		String[] st = new String[ar.length];
		long[] frontAr = new long[ar.length];
		long[] backAr = new long[ar.length];
		long sumFront = 0;
		long sumBack = 0;
		long result;
		String tmp;
		String tp = "";

		for (int i = 0; i < ar.length; i++) {
			st[i] = Long.toString(ar[i]);
			frontAr[i] = Long.parseLong(st[i].substring(0, 5));
			backAr[i] = Long.parseLong(st[i].substring(5, st[i].length()));

			System.out.println("f: " + Long.toString(frontAr[i]));
			System.out.println("b:" + Long.toString(backAr[i]));

			sumFront += frontAr[i];
			sumBack += backAr[i];
		}

		// System.out.println("1: " + Long.toString(sumFront));
		// System.out.println("2:" + Long.toString(sumBack));

		if (sumBack / 1000000 != 0) {
			long upper = sumBack / 1000000;
			sumBack -= upper * 1000000;
			sumFront += upper;
		}

		for (int j = 0; j < 5 - Long.toString(sumBack).length(); j++) {
			tp += '0';
		}

		tmp = Long.toString(sumFront).concat(tp.concat(Long.toString(sumBack)));

		System.out.println(tmp);

		result = Long.parseLong(tmp);

		return result;

	}

	public static String[] solution(String[] record) {
		String[] answer;
		String[][] userList = new String[record.length][2];
		String[] indexSelect = new String[3];
		int size = 0;
		int loop = 0;
		
		for (String index : record) {
			indexSelect = index.split(" ");
			switch (indexSelect[0]) {
			case "Enter":
				for(int k = 0;k < userList.length;k++) {
					if(userList[k][0] == null) {
						userList[k][0] = indexSelect[1]; // uid
						userList[k][1] = indexSelect[2]; // name
						size++;
						break;
					}
				}
				break;
			case "Leave":
				for (int j = 0;j < userList.length;j++) {
					if (userList[j] != null && indexSelect[1].equals(userList[j][0])) {
						userList[j][0] = null;
						userList[j][1] = null;
						size++;
						break;
					}
				}
				break;
			case "Change":
				for (int i = 0;i < userList.length;i++) {
					if (userList[i] != null && indexSelect[1].equals(userList[i][0])) {
						userList[i][1] = indexSelect[2];
						break;
					}
				}
				break;
			}
			loop++;
		}
		
		answer = new String[size];

		loop = 0;
		
		for (String index : record) {
			indexSelect = index.split(" ");
			switch (indexSelect[0]) {
			case "Enter":
				for(String[] enter : userList) {
					if(enter != null && indexSelect[1].equals(enter[0]))
						answer[loop] = enter[1].concat("´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.");
				}
				break;
			case "Leave":
				for (int j = 0; j < userList.length; j++) {
					if (userList[j] != null && indexSelect[1].equals(userList[j][0])) {
						answer[loop] = userList[j][1].concat("´ÔÀÌ ³ª°¬½À´Ï´Ù.");
						break;
					}
				}
				break;
			}

			loop++;
		}
		 
		return answer;
	}

	public static void main(String[] args) {
//		int n = 8;
//		int[] ar = { 1, 1, 3, 1, 2, 1, 3, 3, 3, 3 };

//		String s = "UDDDUDUU";

		String s = "aab";

		long n = 882787;

//		long result = repeatedString(s, n);

		/*
		 * long ar[] = {1001458909, 1004570889, 1007019111, 1003302837, 1002514638,
		 * 1006431461, 1002575010, 1007514041, 1007548981, 1004402249};
		 */

//		long result = aVeryBigSum(ar);

//		int result = countingValleys(n, s);

//		int result = sockMerchant(n, ar);

//		System.out.println("" + result);

//		System.out.println(Long.toString(result));

		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };

		System.out.println(Arrays.toString(solution(record)));

		/*
		 * double a = 3.0 / 6.0;
		 * 
		 * String b = "abc";
		 * 
		 * b = b.substring(0,3);
		 * 
		 * System.out.println(b);
		 */
	}
}
