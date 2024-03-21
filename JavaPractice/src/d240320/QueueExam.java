package d240320;

import java.util.Scanner;

public class QueueExam {
	private int[] queue;
	private int enNum;
	private int deNum;

	public QueueExam() {
		queue = new int[5];
		enNum = 0;
		deNum = 0;
	}

	public static void main(String[] args) {
		QueueExam qe = new QueueExam();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. enQueue   2. deQueue  3. print");
		int choice = sc.nextInt();
		switch(choice) {
			case '1': 
				System.out.println("Enqueue Num?");
				qe.enNum = sc.nextInt();
				qe.enQueue(enNum); break;
			case '2': qe.deQueue(deNum); break;
			case '3': shift();
				for(int i=0;i<queue.length;i++) {
					queue[i];
				}
		}

		
	}

	public void enQueue(int a) {
		queue[enNum++] = a;
	}

	public void deQueue(int b) {
		queue[deNum++] = 0;
	}
}
