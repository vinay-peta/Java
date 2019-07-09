package org.intl.java8.streams;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;

/**
 * basics of collectors
 * @author U6062618
 *
 */
public class Collectors {

	public static void main(String[] a){
		Collectors obj = new Collectors();
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("telugu",40);
		map.put("english", 35);
		map.put("maths", 100);
		System.out.println(obj.countingAbove36(map));
		System.out.println(obj.avgAbove36(map));
		System.out.println(obj.joinNames(map));
		System.out.println(obj.reduceAvg(map));
	}
	
	public long countingAbove36(Map<String,Integer> map){
		return map.entrySet().stream().filter(e->{return e.getValue()>36;}).collect(java.util.stream.Collectors.counting());
	}
	
	public double avgAbove36(Map<String,Integer> map){
		return map.entrySet().stream().filter((e)->{return e.getValue()>36;}).collect(java.util.stream.Collectors.averagingInt(Entry::getValue));
	}
	
	public String joinNames(Map<String,Integer> map){
		return map.entrySet().stream().map(e->e.getKey()).collect(java.util.stream.Collectors.joining(","));
	}
	
	public long reduceAvg(Map<String,Integer> map){
		return map.entrySet().stream().filter(e->e.getValue()>36).collect(java.util.stream.Collectors.reducing(0, Entry::getValue, (i,j)->i+j));
	}
	
	Function<Entry<String,Integer>,Integer> getVal = e->e.getValue();
}
