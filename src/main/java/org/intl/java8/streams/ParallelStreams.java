package org.intl.java8.streams;

import java.util.stream.Stream;

public class ParallelStreams {

	public static void main(String[] a){
		System.out.println(getSum());
	}
	
	public static long getSum(){
		return Stream.iterate(0, i->i+1).limit(1000).parallel().reduce(0,(i,j)->i+j);
	}
}
