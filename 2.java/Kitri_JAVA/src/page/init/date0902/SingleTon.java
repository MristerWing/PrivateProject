package page.init.date0902;

public class Singleton {
	
	private Singleton() {}
	//private static Singleton sing = new Singleton();
	
	/* Initialization on demand holder idiom (holder에 의한 초기화)
	 * class안에 class(Holder)를 두어서 JVM의 ClassLoder매커니즘과 Class가 로드되는
	 * 시점을 이용한 방법 */
	
	/*
	 * 멀티 스레드에서 안전한 Singleton class, instance 생성방법이다.
	 * JVM의 class초기화 과정에서 보장되는 원자적 특성을 이용하여 
	 * 싱글턴의 초기화 문제에 대한 책임을 JVM에 떠넘기는 방법.
	 * Holder 안에 선언된 instance가 static이기 때문에 class 로딩시점에
	 * 한번만 호출될 것이며, final을 사용하여 다시 값이 할당되지 않도록 하는 방법
	 */
	private static class LazyHolder {
		private static final Singleton INSTANCE = new Singleton(); 
	}
	
	public static Singleton getInstance() {
		return LazyHolder.INSTANCE;
	}
}
