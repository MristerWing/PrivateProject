package com.java.di03;

public class CC {
	private AA aa;
	private BB bb;
	
	public CC() {}

	public CC(AA aa) {
		this.aa = aa;
	}

	public void setBb(BB bb) {
		this.bb = bb;
	}

	@Override
	public String toString() {
		return "CC [aa=" + aa + ", bb=" + bb + "]";
	}
	
}
