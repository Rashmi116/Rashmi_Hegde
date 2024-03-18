package com.wileyedge.defaultandstatic;

@FunctionalInterface
public interface Writable1 {
	
	void abc();
	
	default void write1() {
		System.out.println("this is default write1() inside writable interface");
		
	}
	default void write2() {
		System.out.println("this is default write2() inside writable interface");
		
	}
	static void pqr() {
		System.out.println("this is static pqr() inside writable interface");
		
	}

}
