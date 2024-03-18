package controlFlow;


public class ControlFlowDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=2;
		if(a==1) {
			System.out.println("Good morning");
		}
		else if(a==2) {
			System.out.println("Good afternoon");
		}
		else {
			System.out.println("Good evening");
		}
		
		switch(a) {
		case 1:{
			System.out.println("Good morning");
			break;
		}
		case 2:{
			System.out.println("Good afternoon");
			break;
		}
		case 3:{
			System.out.println("Good evening");
			break;
		}
		default:{
			System.out.println("Good night");
		}

	}
		System.out.println("======================================");
		int i=1;
		while(i<5) {
			System.out.println(i);
			i++;
		}
		System.out.println("===============================do-while==============");
		do {
			System.out.println(i);
			i++;
		}while(i<1);
	}

}
