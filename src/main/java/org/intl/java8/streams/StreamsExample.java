package org.intl.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Hello to streams
 * @author U6062618
 *
 */
public class StreamsExample {

	public static void main(String[] args) {
		StreamsExample obj = new StreamsExample();
		List<Dish> dishes = obj.getDishes();
		
		//streams
		System.out.println(obj.getLowCalorieDishNamesUsingLegacyWay(dishes, 410));
		System.out.println(obj.getLowCalorieDishNamesUsingStreams(dishes, 410));
		System.out.println(obj.skipAndLimit(dishes, 410));

		// map
		obj.flatMapGetUniqueChars(new String[] { "Hello", "Check" }).forEach(d -> System.out.print(d));
		System.out.println();
		obj.mapSquareOfNumber(new int[] { 1, 2, 4, 5, 6 }).forEach(i -> System.out.print(i + " "));
		System.out.println();
		obj.flatMapgetCombinations(Arrays.asList(1, 2, 3), Arrays.asList(4, 5))
				.forEach(i -> System.out.print("(" + i[0] + "," + i[1] + ") ,"));
		System.out.println();
		
		//match
		System.out.println(obj.anyDishabove(dishes, 999));
		System.out.println(obj.allDishesbelow(dishes, 5));
		
		// find (Optional<T>)
		obj.findAnyDishAbove(dishes, 5).ifPresent(d->System.out.println(d.getName()));
		
		// reduce
		System.out.println("Reduce :"+obj.reduceFindMax(Arrays.asList(1,5, 8, 9, 7)));
	}

	public int reduceFindMax(List<Integer> list){
		return list.stream().reduce(0,Integer::max);
	}
	
	
	/**
	 * short-circuiting: need not to process the whole stream
	 * @param dishes
	 * @param calories
	 * @return
	 */
	public boolean anyDishabove(List<Dish> dishes, int calories){
		return dishes.stream().anyMatch(d->d.getCalories()>calories);
	}
	public boolean allDishesbelow(List<Dish> dishes, int calories){
		return dishes.stream().allMatch(d->d.getCalories()<calories);
	}
	
	public Optional<Dish> findAnyDishAbove(List<Dish> dishes, int calories){
		return dishes.stream().filter(d->d.getCalories()>calories).findAny();
	}
	
	public List<String> getLowCalorieDishNamesUsingLegacyWay(List<Dish> dishes, int calories) {
		List<Dish> lowCalorieDishes = new ArrayList<Dish>();
		for (Dish dish : dishes) {
			if (dish.getCalories() < calories)
				lowCalorieDishes.add(dish);
		}

		Collections.sort(lowCalorieDishes, (Dish o1, Dish o2) -> {
			return Integer.compare(o1.getCalories(), o2.getCalories());
		});
		List<String> lowCalorieDishNames = new ArrayList<String>();
		for (Dish dish : lowCalorieDishes)
			lowCalorieDishNames.add(dish.getName());

		return lowCalorieDishNames;
	}

	public List<String> getLowCalorieDishNamesUsingStreams(List<Dish> dishes, int calories) {

		return dishes.stream().filter(d -> d.getCalories() < calories).sorted(Comparator.comparing(Dish::getCalories))
				.map(Dish::getName).collect(Collectors.toList());
	}

	/**
	 * limit(n) returns a stream with 'n' objects where as skip(n) will skip
	 * first 'n' objects
	 * 
	 * @param dishes
	 * @param calories
	 * @return
	 */
	public List<String> skipAndLimit(List<Dish> dishes, int calories) {

		return dishes.stream().filter(d -> d.getCalories() < calories).limit(3).map(d -> d.getName())
				.collect(Collectors.toList());
	}

	/**
	 * flatMap method lets you replace each value of a stream with another
	 * stream and then concatenates all the generated streams into a single
	 * stream.
	 * 
	 * @param arr
	 * @return
	 */
	public List<String> flatMapGetUniqueChars(String[] arr) {
		return Arrays.stream(arr).map(s -> s.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
	}

	/**
	 * get all combinations whose sum is divisible by 3
	 * @param l1
	 * @param l2
	 * @return
	 */
	public List<Integer[]> flatMapgetCombinations(List<Integer> l1, List<Integer> l2) {
		return l1.stream().flatMap(i -> l2.stream().filter(j -> (i + j) % 3 == 0).map(j -> new Integer[] { i, j }))
				.collect(Collectors.toList());
	}

	public List<Integer> mapSquareOfNumber(int[] arr) {
		return Arrays.stream(arr).mapToObj(i -> i * i).collect(Collectors.toList());
	}

	private static class Dish {
		private int calories;
		private String name;

		public Dish(String name, int calories) {
			this.calories = calories;
			this.name = name;
		}

		public int getCalories() {
			return calories;
		}

		public void setCalories(int calories) {
			this.calories = calories;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	public List<Dish> getDishes() {
		List<Dish> list = new LinkedList<Dish>();
		list.add(new Dish("Biriyani", 1000));
		list.add(new Dish("Sandwich", 500));
		list.add(new Dish("Chocolate", 50));
		list.add(new Dish("Tea", 25));
		list.add(new Dish("Milk", 100));
		list.add(new Dish("Maagi", 300));
		list.add(new Dish("Roll", 700));
		list.add(new Dish("Soup", 400));
		return list;
	}
}
