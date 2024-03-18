package com.wiley.sort;

class QNode{
	int value;
	QNode next;
	
	public QNode(int value) {
		this.value=value;
	}
	
	public QNode(int value,QNode next) {
		this.value=value;
		this.next=null;
	}
}

class Queue{
	QNode front;
	QNode rear;
	final int maxSize=4;
	int size;
	
	public Queue() {
		front = rear = null;
        size = 0;
	}
	
}


public class QueueImpl {
	//66 44 99 11 33
	
	public static int[] selection(int[] arr) {
		int iter=0;
		for(int i=0;i<arr.length;i++) {
			int min=i;
			//System.out.println(i+"iteration no ");
		    for(int j=i+1;j<arr.length;j++) {
		    	if(arr[j]<arr[min]) {
		    		min=j;
		    	}//end of if
		    	
		    }//end of inner for
		    iter++;
		    if(iter==3) {
		    	break;
		    }
		    int temp=arr[min];
	    	arr[min]=arr[i];
	    	arr[i]=temp;
		}
		//for(int i=0;i<arr.length;i++) {
		//	System.out.println(arr[i]+" ");
		//}
		return arr;
	}
	
	public static void enqueue(Queue q,int value) {
		if(q.size==q.maxSize) {
			System.out.println("queue is full");
			return;
		}
		QNode node=new QNode(value);
		if(q.front==null) {
			q.rear=q.front=node;
		}
		else {
			q.rear.next=node;
		}
		q.rear=node;
		q.rear.next=q.front;
		q.size++;
		
	}
	public static void dequeue(Queue q) {
		if(q.front==null) {
			System.out.println("queue is empty");
		}
		if(q.front==q.rear) {             //only one element is present
			  q.front=null;
			  q.rear=null;  
		}
		else {
			q.front=q.front.next;
			q.rear=q.rear.next;
		}
		q.size--;
	}
	static void display(Queue q) {
		QNode temp=q.front;
		 
		if (q.front != null) {
			do {
				System.out.println(temp.value);
				temp = temp.next;
			} while (temp != q.front);
		}
		temp = temp.next;
			
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue q=new Queue();
		q.front=null;
		q.rear=null;
		int[] arr= {66,44,99,11,33};
		arr=selection(arr);
		
		for(int i=0;i<arr.length;i++) {
			enqueue(q,arr[i]);
		}
		display(q);
		dequeue(q);
		display(q);
		
		
	}

}
