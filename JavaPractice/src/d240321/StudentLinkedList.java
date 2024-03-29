package d240321;

import java.util.Scanner;
import d240314.*;


public class StudentLinkedList {
	static LinkNode head;
	static LinkNode cur;
	static LinkNode newNode;
	static LinkNode del;
	
	
	public static void main(String[] args) {
		head = cur = newNode = new LinkNode();
		newNode.next = null;
		
		
		AllStudent3 stu = new AllStudent3();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1. 학생정보입력");
			System.out.println("2. 학생정보수정");
			System.out.println("3. 학생정보검색");
			System.out.println("4. 학생전체출력");
			System.out.println("5.  종료");
			
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1: stu.setStudent(); break;
			case 2: stu.setModify(); break;
			case 3: stu.setSearch(); break;
			case 4: stu.setDisp();   break;
			case 5: System.exit(0);; break;		// 무한루프 강제종료
			}
		} while(true);
	}
	
	
}

