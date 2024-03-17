package com.wileyedge.defaultandstatic;

public class WritableImpl implements Writable1,Writable2 {

	@Override
	public void abc() {
		System.out.println("this is overidden method inside writableimpl");

	}

	@Override
	public void write1() {
		// TODO Auto-generated method stub
		//Writable1.super.write1();
		System.out.println("this is overidden write1 inside writableimpl");
		
	}

	

}
