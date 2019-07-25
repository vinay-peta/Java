package org.intl.java.exception.handling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TryFromJava7 {

	public static void main(String[] a) {

	}

	/**
	 * closing of object(which implements AutoCloseable) is not required; It will be done automatically;
	 */
	public void objectCreationInTry() {
		try (BufferedReader reader = new BufferedReader(new FileReader(new File("")))) {

		} catch (IOException e) {

		}
	}

	public void multipleObjectsCreationInTry() {
		try (BufferedReader reader = new BufferedReader(new FileReader(new File("")));
				FileWriter writer = new FileWriter("")) {

		} catch (IOException|ArithmeticException e) {

		}
	}
}
