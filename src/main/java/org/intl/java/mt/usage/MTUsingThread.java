package org.intl.java.mt.usage;

public class MTUsingThread extends Thread {

	private int num;

	public void run() {
		System.out.println("Thread name :" + Thread.currentThread().getName() + " Num: " + num);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
