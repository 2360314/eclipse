package d240320;

public class QueueExamAns {

	int[] data;
	int front;
	int rear;

	public QueueExamAns() {
		data = new int[5];
		front = rear = 0;
	}

	public void enqueue(int num) {
		if (front != 0 && rear == 5) {
			shift();
		}
			
		data[rear++] = num;

	}

	public void dequeue() {
		data[front++] = 0;
	}
	
	public void shift() {
		int count = 0;
		for(int i = 0; i<data.length; i++) {
			if(data[i] != 0 ) {
				data[i-count] = data[i];
				data[i] = 0;
//				
			}
			else {		
				count++;
			}
		}	
		front = 0;
		rear = rear-count;
		
//		shift 메서드 강사 정답
//		int i;
//		int num = rear-front;
//		for(i = 0; i<num;i++) {
//			data[i] = data[front];
//			data[front++] = 0;
//		}
//		front = 0;
//		rear = i;
		
	}
	
	public void disp() {
		for(int i=0;i<data.length;i++) {
			System.out.print(data[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		QueueExamAns qe = new QueueExamAns();
		qe.enqueue(1); System.out.print("rear = "+qe.rear+"  front = "+qe.front+"  ");	qe.disp();
		qe.enqueue(2); System.out.print("rear = "+qe.rear+"  front = "+qe.front+"  ");	qe.disp();
		qe.enqueue(3); System.out.print("rear = "+qe.rear+"  front = "+qe.front+"  ");	qe.disp();
		qe.enqueue(4); System.out.print("rear = "+qe.rear+"  front = "+qe.front+"  ");	qe.disp();
		qe.dequeue();  System.out.print("rear = "+qe.rear+"  front = "+qe.front+"  ");	qe.disp();
		qe.dequeue();  System.out.print("rear = "+qe.rear+"  front = "+qe.front+"  ");	qe.disp();
		qe.enqueue(5); System.out.print("rear = "+qe.rear+"  front = "+qe.front+"  ");	qe.disp();
		qe.enqueue(6); System.out.print("rear = "+qe.rear+"  front = "+qe.front+"  ");	qe.disp();
		qe.enqueue(7); System.out.print("rear = "+qe.rear+"  front = "+qe.front+"  ");	qe.disp();
		qe.dequeue();  System.out.print("rear = "+qe.rear+"  front = "+qe.front+"  ");	qe.disp();
		qe.dequeue();  System.out.print("rear = "+qe.rear+"  front = "+qe.front+"  ");	qe.disp();
		qe.dequeue();  System.out.print("rear = "+qe.rear+"  front = "+qe.front+"  ");	qe.disp();
		qe.enqueue(8); System.out.print("rear = "+qe.rear+"  front = "+qe.front+"  ");	qe.disp();
		qe.enqueue(9); System.out.print("rear = "+qe.rear+"  front = "+qe.front+"  ");	qe.disp();
	}
}