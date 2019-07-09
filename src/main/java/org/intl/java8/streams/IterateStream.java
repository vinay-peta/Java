package org.intl.java8.streams;

import java.util.stream.Stream;

/**
 * check for iterating
 * @author U6062618
 *
 */
public class IterateStream {

	public static void main(String[] a) {
		IterateStream obj = new IterateStream();
		obj.printFibonaciTuplesIterative();
		obj.printRandomGenerate();
	}

	public void printFibonaciTuplesIterative() {
		Stream.iterate(new int[] { 0, 1 }, arr -> new int[] { arr[1], arr[0] + arr[1] }).limit(10)
				.forEach(t -> System.out.println(t[0] + " " + t[1]));
	}

	public void printRandomGenerate() {
		Stream.generate(Math::random).limit(10).forEach(i -> System.out.println(i));
	}
}
