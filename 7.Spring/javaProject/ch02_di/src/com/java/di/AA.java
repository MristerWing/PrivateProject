package com.java.di;

public class AA { // DI: 생성자, 프로퍼티만 데이터 접근 가능.(일반 함수 접근 불가능)
	private int a;
	private int b;

	public AA() {
		System.out.println("constrator");
	}

	public AA(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	@Override
	public String toString() {
		return "AA [a=" + a + ", b=" + b + "]";
	}

}
