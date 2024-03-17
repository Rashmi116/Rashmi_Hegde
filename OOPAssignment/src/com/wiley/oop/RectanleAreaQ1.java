package com.wiley.oop;
import com.wiley.oop.Shape;


class Triangle extends Shape{
	
	public Triangle(double height, double base) {
		super(height, base);
		// TODO Auto-generated constructor stub
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	
	

	@Override
	public void area() {
		double area=height*base;
		
	}
}

public class RectanleAreaQ1 extends Shape {

	
	public RectanleAreaQ1(double height, double base) {
		super(height, base);
		// TODO Auto-generated constructor stub
	}
	public double getWidth() {
		return base;
	}
	public void setWidth(double base) {
		this.base = base;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	public void perimeter(double base,double height) {
		double perimeter=2*(base+height);
		System.out.println(perimeter);
	}
	public void area() {
		// TODO Auto-generated method stub
		double area=base*height;
	}

	

}
