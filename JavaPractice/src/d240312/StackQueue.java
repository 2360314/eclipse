package d240312;
import java.util.Scanner;

// 이거 다하고 정적바인딩 / 동적바인딩 비교해서 한번 짜봐라.

abstract class Memory{
	private int[] arr;		// 1. MyStack과 MyQueue에 공통으로 필요한 2개를 만든다.
	private int top;
	
	public Memory(){
		arr = new int[5];
		top = 0;			// 시작점
	}

	public void push(int data){
		arr[top++] = data;		// push 할때마다 arr[0], arr[1],...arr[4] 까지 넣음
	}
	
	
	public abstract int pop();
}



class MyStack extends Memory{
	
	@Override
	public int pop() {
		
		return arr[--top];		// top 의 자리 앞에서 꺼내라. 선감소
	}
	
}

class MyQueue extends Memory{
	
	int front;
	
	@Override
	public int pop() {
		return arr[front++];
	}
	
}


public class StackQueue {

	public static void main(String[] args) {

		MyStack ms = new MyStack();
		MyQueue mq = new MyQueue();

		Scanner sc = new Scanner(System.in);

		do {
			System.out.print("1.Stack 2.Queue 3.exit");
			int num = sc.nextInt();

			if (num == 1) {

				while (true) {
					System.out.print("1.push 2.pop 3.back");

					int n = sc.nextInt();

					if (n == 1) {
						ms.push(sc.nextInt());

					} else if (n == 2) {
						System.out.println(ms.pop());
					} else
						break;
				}
			} else if (num == 2) {

				while (true) {
					System.out.print("1.push 2.pop 3.back");

					int n = sc.nextInt();

					if (n == 1) {
						mq.push(sc.nextInt());

					} else if (n == 2) {
						System.out.println(mq.pop());
					} else
						break;
				}
			} else
				System.exit(0);

		} while (true);
	}
}
