package com.wiley;

import java.util.Optional;

public class OptionalDemo {

	public static void main(String[] args) {
		/*
		 * Optional is now a part of Java 8 library as a solution to NullPointerExceptions, discouraging codebase pollution with null checks 
  		   and encouraging developers to write cleaner code.
  		   Optional is just a container: it can hold a value of some type T or just be null.
		 */
		Optional<String> fname=Optional.of("rashmi");
		System.out.println("fname is set? "+fname.isPresent());
		System.out.println( "First Name: " + fname.orElseGet( () -> "[none]" ) );
		System.out.println( fname.map( s -> "Hey " + s  ).orElse( "Hey Stranger!" ) );
		
		Optional< String > lname = Optional.ofNullable(null);
		System.out.println("lname is set? "+lname.isPresent());
		System.out.println( "last Name: " + lname.orElseGet( () -> "[none]" ) );
		System.out.println( lname.map( s -> "Hey " + s  ).orElse( "Hey Stranger!" ) );
	}

}
