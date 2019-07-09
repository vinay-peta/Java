package org.intl.java8.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Check for other streams
 * @author U6062618
 *
 */
public class IntStreamPT {

	public static void main(String[] a) {
		IntStreamPT obj = new IntStreamPT();
		obj.getPythogoreanTriplets().forEach(arr -> System.out.println(arr[0] + " " + arr[1] + " " + arr[2]));
	}

	public List<Integer[]> getPythogoreanTriplets() {
		return IntStream.rangeClosed(1, 100).boxed()
				.flatMap(a -> IntStream.rangeClosed(a, 100).filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
						.mapToObj(b -> new Integer[] { a, b, (int) Math.sqrt(a * a + b * b) }))
				.limit(10).collect(Collectors.toList());
	}
}
