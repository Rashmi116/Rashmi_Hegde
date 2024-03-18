package com.junglebook;

import com.junglebook.animal.Animal;
import com.junglebook.animal.Pet;
import com.junglebook.animal.canine.Dog;
import com.junglebook.animal.feline.Cat;
import com.junglebook.animal.feline.Tiger;

public class TestAnimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Animal a=new Animal();
		//Dog a=new Dog();
		//Cat b=new Cat("Kim","Black");
		//a.name="Dog";
		//a.color="Black";
		//Animal a=new Tiger("Jimmi","Black");
		Animal[] ani = new Animal[4];
		ani[0]=new Dog("jim","white");
		ani[1]=new Cat("tom","white");
		ani[2]=new Tiger("jerry","white");
		ani[3]=new Dog("cannie","grey");
		for(Animal a:ani) {
			a.makeNoise();
			a.sleep();
			
			Pet[] arr=new Pet[4];
			arr[0]=new Dog("jim","white");
			arr[1]=new Cat("tom","white");
			arr[2]=new Cat("jerry","white");
			arr[3]=new Dog("cannie","grey");
			for(Pet a1:arr) {
				a1.play();
				a1.beFriendly();
		}
		//a.makeNoise();
		//a.sleep();
		//b.makeNoise();
		//b.sleep();
			Pet p=new Pet() {//anonymous inner class

				@Override
				public void play() {
					// TODO Auto-generated method stub
					System.out.println("playing inside anonymous inner class");
					
				}

				@Override
				public void beFriendly() {
					// TODO Auto-generated method stub
					System.out.println("friendly inside anonymous inner class");
					
				}
				
			};
			p.play();
			Animal a1=new Animal() {

				@Override
				public void makeNoise() {
					System.out.println(" inside anonymous child class animal");
					
					
				}
				
			};
			a1.makeNoise();
			

	}

}
}