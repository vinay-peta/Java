package org.intl.java.exception.handling;

import java.io.FileNotFoundException;

public class Throw {

	public static void main(String[] a) {
		Throw obj = new Throw();
		try {
			obj.throwAnException();
		} catch (Exception e) {

		}
		System.out.println("hello");
	}

	public void throwAnException() throws FileNotFoundException {
		//throw new ArithmeticException("/ by zero"); // unchecked exception
		throw new FileNotFoundException(); // checked exception
	}
}
