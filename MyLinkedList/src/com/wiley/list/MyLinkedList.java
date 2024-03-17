package com.wiley.list;

class Node{
	Node next;
	int data;
	
	public Node() {
	}
	
	public Node(int data) {
		this.data=data;
	}
	public Node(int data,Node next) {
		this.data=data;
		this.next=null;
	}
}

class MyList{
	Node head;
	Node tail;
	int size=0;
	
	public void insertFirst(int value){
		Node node=new Node(value);
		node.next=head;
		head=node;
		if(tail==null) {
			tail=head;
		}
		
		size++;
		
	}
	public void insertAtEnd(int value) {
		Node node=new Node(value);
		if(tail==null) {
			insertFirst(value);
		}
		tail.next=node;
		tail=node;
		size++;
	}
	
	public void insertAtIndex(int index,int value) {
		if(index==0) {
			insertFirst(value);
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
	
	public void deleteAtFirst() {
		head=head.next;
		if(head==null) {
			tail=null;
		}
		size--;
		
	}
	public void deleteAtLast() {
		if(size<=1) {
			deleteAtFirst();
		}
		Node node=head;
		for(int i=0;i<size-2;i++) {
			node=node.next;
		}
		tail=node;
		tail.next=null;
		size--;
		
		
	}
	
	public void deleteAtIndex(int index) {
		if(index==0) {
			deleteAtFirst();
		}
		if(index==size-1) {
			deleteAtLast();
		}
		Node temp=head;
		for(int i=0;i<index-1;i++) {
			temp=temp.next;
		}
		temp.next=temp.next.next;
		size--;
	}
	
	//inorder to delete particular value if it is present in the last
	public void deleteValue(int value) {
		Node temp=find(value);
		Node prev=head;
		if(temp==null) {
			return;
		}
		while(prev!=temp) {
		prev=prev.next;
		}
		prev.next=prev.next.next;
		size--;
	}
	
	public Node find(int value) {
		Node node=head;
		while(node!=null) {
			if(node.data==value) {
				return node;
			}
			node=node.next;
		}
		return null;
	}
	public void display() {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}
}

public class MyLinkedList {

	public static void main(String[] args) {
		MyList list=new MyList();
		list.insertFirst(3);
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		list.insertAtEnd(6);
		list.insertAtEnd(7);
		list.deleteValue(8);
		//list.deleteAtFirst();
		//list.deleteAtIndex(2);
		//list.deleteAtLast();
		list.display();
		

	}

}
