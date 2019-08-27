package privatePractice;

public class LambdaPractice {
	
	
	@FunctionalInterface
	public interface MyFunctionInterfaceReturn {
//		public void method();
		public int method(int x, int y);
	}

	public static void main(String[] args) {
		MyFunctionInterfaceReturn fiR;
		
		/*
		 * fi = () -> { String str = "method call"; System.out.println(str); };
		 * fi.method();
		 * 
		 * fi = () -> { System.out.println("method call2"); }; fi.method();
		 * 
		 * fi = () -> System.out.println("method call3"); fi.method();
		 */

		/*
		 * //���ٴ� �Լ��� ������ �ͻ�. ���� ȣ���� �ؾ��� //���� fi = (x) -> { int result = x * 5;
		 * System.out.println(result + ""); }; //ȣ�� fi.method(2);
		 * 
		 * fi = x -> System.out.println(x *5 + ""); fi.method(2);
		 */
		
		fiR = (x, y) -> {
			int result = x + y;
			return result;
		};
		System.out.println("" + fiR.method(2, 6));
		
		fiR = (x, y) -> {return x + y;};
		System.out.println("" + fiR.method(3, 6));
		
		fiR = (x, y) -> x + y;
		System.out.println("" + fiR.method(3, 5));
		
		UsingThis using = new UsingThis();
		UsingThis.Inner inner = using.new Inner();
		inner.method();

	}

}
