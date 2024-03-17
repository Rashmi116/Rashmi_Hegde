package com.wiley.oop;

public abstract class Shape {
	public double height;
	public double base;
	
	 public Shape(double height, double base) {
		super();
		this.height = height;
		this.base = base;
	}

	public abstract  void  area();

}
