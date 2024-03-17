package com.wileyedge.methodinference;

import java.util.function.Supplier;

@FunctionalInterface
interface MySupplier<T>{
	T get(String name);
}

public class Car extends Vehicle {
	private String name;
	
	public Car(String name) {
		this.name=name;
	}
	
	public Car() {
		System.out.println("inside car constructor");
	}

	@Override
	public void drive() {
		
		System.out.println("driving car "+this.name);
	}
	
	public static Car create(Supplier<Car> sup) {
		return sup.get();
	}
	
	public static Car create1(MySupplier<Car> sup1,String name) {
		return sup1.get(name);
	}
	
	public static void doServicing(final Car car) {
		System.out.println("servicing is done "+car.toString());
	}
	
	public void follow(final Car another) {
		System.out.println("following the another "+another.toString());
	}
	
	public String toString() {
		return this.name;
	}
	

}
