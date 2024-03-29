package d240321;
import java.util.Scanner;

public class LinkedExam {

	static LinkNode head;
	static LinkNode cur;
	static LinkNode newNode;
	static LinkNode del;
	
	public static void main(String[] args) {
		head = cur = newNode = new LinkNode();
		newNode.next = null;
		
		newNode.setData(1);	// newNode에 1을 넣겠다.
		
		// 2번째 노드 만들기
		newNode.next = new LinkNode();	// 지금 만들었던 newNode의 next에 새로운 new를 하겠다.
		newNode.next.setData(2);		// 다시 두번째로 새로만든 노드에 2라는 값을 넣어라
		newNode.next.next = null;		// 두번째 노드의 next는 null을 만든다.
		
		// 3번째 노드 만들기
		newNode.next.next = new LinkNode();	// 지금 만들었던 newNode의 next에 새로운 new를 하겠다.
		newNode.next.next.setData(3);		// 다시 세번째로 새로만든 노드에 3이라는 값을 넣어라
		newNode.next.next.next = null;		// 세번째 노드의 next는 null을 만든다.
		
		// 4번째 노드 만들기
		newNode.next.next.next = new LinkNode();	// 지금 만들었던 newNode의 next에 새로운 new를 하겠다.
		newNode.next.next.next.setData(4);		// 다시 네번째로 새로만든 노드에 4이라는 값을 넣어라
		newNode.next.next.next.next = null;		// 네번째 노드의 next는 null을 만든다.
		
		// 첫번째에 노드 삽입하기
		newNode = new LinkNode();
		newNode.next = head;
		head =newNode;
		
		newNode.setData(5);
		
		cur = head;
		
		
		while(cur!= null) {
			System.out.print(cur.getData()+" ");
			cur = cur.next;
		}
		
		// 몇번째에 노드 삽입해서 할건지 물어보고 다시 출력하기
		// 데이터 삽입
		Scanner sc = new Scanner(System.in);
		System.out.println();	// 개행
		System.out.println("6을 몇 번째에 넣을가요?");
		int num = sc.nextInt();
		
		newNode = new LinkNode();
		newNode.setData(6);
		
		// 입력 -> 삽입
		if(num==1) {
			newNode.next = head;
			head = newNode;
		} else {
			cur = head;
			for(int i = 0; i < num-2; i++) {
				cur = cur.next;
			}
			newNode.next = cur.next;
			cur.next = newNode;
		}
		
		cur = head;
		
		// 출력		
		while(cur!= null) {
			System.out.print(cur.getData()+" ");
			cur = cur.next;
		}
		
		// 데이터 삭제	
		cur = head;
		System.out.println("몇 번째 삭제할가요?");
		int num2 = sc.nextInt();
		
		if(num2==1) {
			del = head;
			head = head.next;
//			head = cur.next;
//			cur = null;
		}
		else {
			for(int i = 0; i < num2-2; i++) {
				cur = cur.next;
			}
			del = cur.next;
			cur.next = del.next;
		}
		del.next = null;
		del = null;
		
		
		// 출력	
		cur = head;
		while(cur!= null) {
			System.out.print(cur.getData()+" ");
			cur = cur.next;
		}

	}

}
