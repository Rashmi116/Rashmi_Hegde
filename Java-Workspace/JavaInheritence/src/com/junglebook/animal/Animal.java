package com.junglebook.animal;

public abstract class Animal { //can not be instantiated
	protected String name;
	public String color;
	
	public Animal() {
		System.out.println("inside default construtor of animal");
	}
	public Animal(String name,String color) {
		System.out.println("inside  parametrized construtor of animal");
		this.name=name;
		this.color=color;
		
	}
	
	
	
	 public abstract void makeNoise();//this method should be overridden in the child class
		
		
	
	
	public void sleep() {
		System.out.println(this.name+"  is sleeping");
		
	}

}
