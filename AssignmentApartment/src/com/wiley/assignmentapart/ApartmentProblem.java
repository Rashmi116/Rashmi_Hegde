package com.wiley.assignmentapart;
import java.util.Scanner;

class Node {
	int value;
	Node next;
	Node prev;

	public Node(int value) {
		this.value = value;
	}

	public Node(int value, Node next) {
		this.value = value;
		this.next = next;
	}

}
class CircularList{
	Node head;
	Node tail;
	int size=0;
	
	public void insertAtFirst(int value) {
		Node node=new Node(value);
		
		if(head==null) {
			head=node;
			tail=node;
		}
		node.next=head;
		head.prev=node;
		head=node;
		tail.next=node;
		node.prev=tail;
		
		size++;
	}
	public void insertAtEnd(int value) {
		Node node=new Node(value);
		if(tail==null) {
			insertAtFirst(value);
		}
		tail.next=node;
		node.prev=tail;
		node.next=head;
		head.prev=node;
		tail=node;
		
		size++;
	}
	public void insertAtIndex(int index,int value) {
		if(index==0) {
			insertAtFirst(value);
		}
		if(index==size) {
			insertAtEnd(value);
		}
		Node temp=head;
		for(int i=0;i<index-1;i++) {
			temp=temp.next;
		}
		Node node=new Node(value);
		node.next=temp.next;
		temp.next=node;
		
		size+=1;
		
	}
	public void display() {
		Node temp=head;
		if(head!=null) {
		do {
			
			System.out.print(temp.value+" ");
			temp=temp.next;
		}while(temp!=head);
		}
	}
	public void calculateSum() {
		Node temp=head;
		if(head!=null) {
			do {
				int value=temp.next.value+temp.prev.value;
				System.out.print(value+" ");
				temp=temp.next;
			}while(temp!=head);
		}
	}
}
public class ApartmentProblem{
	public static void main(String[] args) {
		CircularList list=new CircularList();
		list.insertAtFirst(30);
		list.insertAtFirst(20);
		list.insertAtFirst(10);
		list.calculateSum();
		
	}
}



