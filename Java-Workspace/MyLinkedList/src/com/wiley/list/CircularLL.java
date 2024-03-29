package com.wiley.list;

class CNode{
	CNode next;
	int value;
	public CNode(int value){
		this.value=value;
	}
}

class CircularList{
	CNode head;
	CNode tail;
	int size=0;
	
	public void insertAtFirst(int value) {
		CNode node=new CNode(value);
		
		if(head==null) {
			head=node;
			tail=node;
		}
		node.next=head;
		tail.next=node;
		head=node;
		size++;
	}
	public void insertAtEnd(int value) {
		CNode node=new CNode(value);
		if(tail==null) {
			insertAtFirst(value);
		}
		tail.next=node;
		node.next=head;
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
		CNode temp=head;
		for(int i=0;i<index-1;i++) {
			temp=temp.next;
		}
		CNode node=new CNode(value);
		node.next=temp.next;
		temp.next=node;
		
		size+=1;
		
	}
	public void deleteAtFirst() {
		head=head.next;
		tail.next=head;
		if(head==null) {
			tail=null;
		}
		size--;
		
	}
	public void deleteAtLast() {
		if(size<=1) {
			deleteAtFirst();
		}
		CNode node=head;
		for(int i=0;i<size-2;i++) {
			node=node.next;
		}
		tail=node;
		node.next=head;
		
		size--;
		
		
	}
	
	public void deleteAtIndex(int index) {
		if(index==0) {
			deleteAtFirst();
		}
		if(index==size-1) {
			deleteAtLast();
		}
		CNode temp=head;
		for(int i=0;i<index-1;i++) {
			temp=temp.next;
		}
		temp.next=temp.next.next;
		size--;
	}
	public void display() {
		CNode temp=head;
		if(head!=null) {
		do {
			
			System.out.print(temp.value+" ");
			temp=temp.next;
		}while(temp!=head);
		}
		
	}
	
}

public class CircularLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularList list=new CircularList();
		list.insertAtFirst(5);
		list.insertAtFirst(6);
		list.insertAtFirst(8);
		list.insertAtEnd(9);
		list.insertAtEnd(10);
		list.insertAtIndex(2,7);
		//list.deleteAtFirst();
		//list.deleteAtLast();
		list.deleteAtIndex(3);
		

		list.display();

	}

}
