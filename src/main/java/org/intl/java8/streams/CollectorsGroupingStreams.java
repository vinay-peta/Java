package org.intl.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import oracle.net.aso.s;

/**
 * In collectors check for groupBy, partioningBy,  
 * @author U6062618
 *
 */
public class CollectorsGroupingStreams {

	public static void main(String[] a) {
		List<Student> listOfStudents = getStudents();
		groupByGender(listOfStudents).forEach((s, l) -> {
			System.out.print(s + "->");
			l.forEach(st -> System.out.print(st.name + ","));
		});
		System.out.println();
		groupByGenderCount(listOfStudents).forEach((s, l) -> System.out.print(s + " " + l + ";"));
		System.out.println();
		partionByGender(listOfStudents);
	}

	public static Map<String, List<Student>> groupByGender(List<Student> list) {
		return list.stream().collect(Collectors.groupingBy(Student::getGender));
	}

	public static Map<String, Long> groupByGenderCount(List<Student> list) {
		return list.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.counting()));
	}

	public static Map<Boolean, List<Student>> partionByGender(List<Student> list) {
		return list.stream().collect(Collectors.partitioningBy(Student::isMale));
	}

	public static List<Student> getStudents() {
		Student s1 = new Student("vinay", "M", 23);
		Student s2 = new Student("chaitu", "F", 25);
		Student s3 = new Student("sai", "F", 21);
		Student s4 = new Student("vinu", "F", 23);
		Student s5 = new Student("pandu", "M", 19);
		Student s6 = new Student("lishi", "F", 9);
		return Arrays.asList(s1, s2, s3, s4, s5, s6);
	}

	private static class Student {
		private String name;
		private String gender;
		private int age;

		public Student(String name, String gender, int age) {
			this.name = name;
			this.gender = gender;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public boolean isMale() {
			return gender == "M" ? true : false;
		}

	}
}
