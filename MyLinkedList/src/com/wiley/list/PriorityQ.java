/*package com.wiley.list;

import java.util.Comparator;
import java.util.Queue;

class MyComparator implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		// TODO Auto-generated method stub
		return -(s1.compareTo(s2));
	}
	
}

public class PriorityQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<String> pq=new PriorityQueue<>();
		//Queue<String> pq=new PriorityQueue<>(new MyComparator());
		pq.add("hello");
		pq.add("HackerRank");
		String s1=pq.poll();
		pq.remove();
		System.out.println(s1);
		String s2=pq.remove();
		System.out.println(s2);
		//The remove() and poll() methods differ only in their behavior when the queue is empty: 
		//the remove() method throws an exception, while the poll() method returns null.
		//The element() and peek() methods return, but do not remove, the head of the queue.
		//add() will throw an IllegalStateException if no space is currently available 
		//in the Queue, otherwise add method will return true. offer() method will 
		//return false if the element cannot be inserted due to capacity restrictions

	}

}*/
