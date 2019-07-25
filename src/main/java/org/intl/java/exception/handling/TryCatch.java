package org.intl.java.exception.handling;

public class TryCatch {

	public static void main(String[] a) {
		TryCatch obj = new TryCatch();
		obj.exceptionHandling();
	}

	public int exceptionHandling() {
		try {
			System.out.println(10 / 0);
		} catch (ArithmeticException e) {
			System.out.println(e);
		}
		return -1;
	}
}
