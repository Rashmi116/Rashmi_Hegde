package com.wileyedge.defaultandstatic;

public interface Writable2 {


	default void write1() {
		System.out.println("this is default write1() inside writable2 interface");
		
	}
	static void pqr() {
		System.out.println("this is static pqr() inside writable2 interface");
		
	}
}
