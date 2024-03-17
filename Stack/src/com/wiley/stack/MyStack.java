package com.wiley.stack;

public class MyStack<E> {
	E[] data;
	static final int default_size=10;
	
	int ptr=-1;
	
	public MyStack() {
		this.data=(E[]) new Object[default_size];
	}
	
	public MyStack(int size) {
		this.data=(E[])new Object[size];
	}
	
	public void push(E value) {
		if(ptr==data.length-1) {
			System.out.println("stack is full");
		}
		ptr++;
		data[ptr]=value;
	}
	public void pop() {
		if(ptr==-1) {
			System.out.println("stack is empty");
		}
		ptr--;
		
	}
	public E peek() {
		if(ptr==-1) {
			System.out.println("stack is empty");
		}
		return data[ptr];
	}
	public void display() {
		for(int i=0;i<=ptr;i++) {
			System.out.println(data[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack<Integer> stack=new MyStack<>();
		stack.push(10);
		stack.push(5);
		stack.push(15);
		stack.push(25);
		stack.push(30);
		stack.push(40);
		
		stack.peek();
		stack.pop();
		stack.display();
		
		
		

	}

}
