package com.java.di07;

public class AAA {
	private int x;
	private int y;

	public AAA() {
	}

	public AAA(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "AAA [x=" + x + ", y=" + y + "]";
	}

}
