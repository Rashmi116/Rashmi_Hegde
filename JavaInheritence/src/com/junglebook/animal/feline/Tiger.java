package com.junglebook.animal.feline;

import com.junglebook.animal.Animal;

public class Tiger extends Animal {
	public Tiger(String name,String color) {
		super(name,color);
		
	}


	@Override
	public void makeNoise() {
		// TODO Auto-generated method stub
		System.out.println(this.name+"tiger is roaring");
		
	}

}
