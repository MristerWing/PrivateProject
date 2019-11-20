package com.java.di03;

public class AA {
	private int x;
	private int y;
	
	public AA () {}

	public AA(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "AA [x=" + x + ", y=" + y + "]";
	}
	
}
