package com.java.di;

public class AA {	// DI: ������, ������Ƽ�� ������ ���� ����.(�Ϲ� �Լ� ���� �Ұ���)
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
