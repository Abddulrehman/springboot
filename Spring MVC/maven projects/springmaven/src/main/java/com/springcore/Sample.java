package com.springcore;

public class Sample {
	private int x;
	private SampleEx ob;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public SampleEx getOb() {
		return ob;
	}
	public void setOb(SampleEx ob) {
		this.ob = ob;
	}
	public Sample() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Sample [x=" + x + ", ob=" + ob + "]";
	}

}