package org.intl.java8.streams.optional;

import java.util.Optional;

public class OptionalEx {

	public static void main(String[] a) {
		
		intro();
		
		Person person = new Person();
		Car car = new Car();
		Insurance ins = new Insurance();
		
		ins.setName(Optional.ofNullable(new String("Tata")));
		car.setInsurance(Optional.ofNullable(ins));
		person.setCar(Optional.ofNullable(car));
		
		System.out.println(getCarInsuranceName(Optional.of(person)).orElse("UnKnown"));
		person.setCar(Optional.ofNullable(null));
		System.out.println(getCarInsuranceName(Optional.of(person)).orElse("UnKnown"));
		
	}

	public static Optional<String> getCarInsuranceName(Optional<Person> person) {
		return person.flatMap(Person::getCar).flatMap(Car::getInsurance).flatMap(Insurance::getName);
	}

	public static void intro() {
		Car car = new Car();
		Car nullCar = null;
		Optional<Car> emptyCar = Optional.empty();
		Optional<Car> optCar = Optional.of(car);
		// if car is null it will throw an error
		Optional<Car> notNullCar = Optional.ofNullable(nullCar);
		// if car is null the optional object would be empty
		System.out.println(emptyCar + " " + optCar + " " + notNullCar);

	}
}

class Person {
	private Optional<Car> car;

	public Optional<Car> getCar() {
		return car;
	}

	public void setCar(Optional<Car> car) {
		this.car = car;
	}
}

class Car {
	private Optional<Insurance> insurance;

	public Optional<Insurance> getInsurance() {
		return insurance;
	}

	public void setInsurance(Optional<Insurance> insurance) {
		this.insurance = insurance;
	}
}

class Insurance {
	private Optional<String> name;

	public Optional<String> getName() {
		return name;
	}

	public void setName(Optional<String> name) {
		this.name = name;
	}
}