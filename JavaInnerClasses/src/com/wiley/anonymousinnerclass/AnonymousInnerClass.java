package com.wiley.anonymousinnerclass;

interface Pet{
	void play();
	void beFriendly();
}

abstract class Animal implements Pet{
	abstract public void makeNoise();
}

class Dog extends Animal{

	@Override
	public void makeNoise() {
	 System.out.println("dog is barking");
		
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("dog is playing");
		
	}

	@Override
	public void beFriendly() {
		// TODO Auto-generated method stub
		System.out.println("dog is befriendly");
		
	}
	
}
public class AnonymousInnerClass {

	public static void main(String[] args) {
		Animal a=new Dog();
		Pet p=new Dog();
		Animal a1=new Animal() {

			@Override
			public void play() {
				
				
			}

			@Override
			public void beFriendly() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void makeNoise() {
				// TODO Auto-generated method stub
				System.out.println("Tiger is roaring");
			}
			
		};
		Pet p2=new Pet() {

			@Override
			public void play() {
				
				System.out.println("cat is playing");
			}

			@Override
			public void beFriendly() {
				// TODO Auto-generated method stub
				System.out.println("cat is jumping");
				
			}
			
		};
		a1.makeNoise();
		p2.beFriendly();
		p2.play();
		

	}

}
