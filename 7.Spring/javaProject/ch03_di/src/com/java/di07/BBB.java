package com.java.di07;

public class BBB {
	private int x;
	private int y;

	public BBB() {
	}

	public BBB(int x, int y) {
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
		return "BBB [x=" + x + ", y=" + y + "]";
	}

}
