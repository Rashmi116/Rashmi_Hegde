package com.junglebook.animal.feline;

import com.junglebook.animal.Animal;
import com.junglebook.animal.Pet;

public class Cat extends Animal implements Pet {
	
	public Cat(String name,String color) {
		super(name,color);
	}
	public void makeNoise() {
		System.out.println(this.name+" meowing");
	}
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println(this.name+" is sitting on your lap");
	}
	@Override
	public void beFriendly() {
		// TODO Auto-generated method stub
		System.out.println(this.name+" is licking your hand");
		
	}
	

}
