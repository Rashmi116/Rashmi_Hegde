package com.junglebook.animal.canine;

import com.junglebook.animal.Animal;
import com.junglebook.animal.Pet;

public class Dog extends Animal implements Pet {
	public Dog() {
		this("Jimmy","black");
		System.out.println("inside default construtor of dog");
	}
	
	public Dog(String name,String color) {
		super(name,color);
		System.out.println("inside parameterized construtor of dog");
		//this.name=name;
		//this.color=color;
	}
	public void makeNoise() {
		System.out.println((this.name)+" is barking");
		
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println(this.name+" jumping");
		
	}

	@Override
	public void beFriendly() {
		// TODO Auto-generated method stub
		System.out.println(this.name+" waving his tail");
		
	}

}
