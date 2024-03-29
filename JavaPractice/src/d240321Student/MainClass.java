package d240321Student;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {

		MainClass main = new MainClass();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1. 학생정보입력");
			System.out.println("2. 학생정보수정");
			System.out.println("3. 학생정보검색");
			System.out.println("4. 학생전체출력");
			System.out.println("5. 학생정보삭제");
			System.out.println("6. 종료");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				main.setStudent();
				break;
			case 2:
				main.setModify();
				break;
			case 3:
				main.setSearch();
				break;
			case 4:
				main.setDisp();
				break;
			case 5:
				main.setDelete();
				break;
			case 6:
				System.exit(0);
				break; // 무한루프 강제종료
			}

		} while (true);

	}

	// 1. 학생정보입력
	public void setStudent() {
		StudentData studentData = new StudentData();
		DoLinkedList dolink = new DoLinkedList();
		Scanner sc = new Scanner(System.in);

		System.out.println("학생이름 입력:" + "\t");
		studentData.setName(sc.next());
		System.out.println("국어점수 입력:" + "\t");
		studentData.setKor(sc.nextInt());
		System.out.println("영어점수 입력:" + "\t");
		studentData.setEng(sc.nextInt());
		System.out.println("수학점수 입력:" + "\t");
		studentData.setMat(sc.nextInt());
		studentData.getTotal();
		studentData.getAvg();

		dolink.add(studentData);
	}

	// 2. 학생정보수정
	public void setModify() {
		StudentData stu = new StudentData();
		DoLinkedList dolink = new DoLinkedList();
		dolink.modify(stu);
	}

	// 3. 학생정보검색
	public void setSearch() {
		
		StudentData stu = new StudentData();
		DoLinkedList dolink = new DoLinkedList();
		dolink.search(stu);
		
	}

	// 4. 학생전체출력
	public void setDisp() {
		DoLinkedList dolink = new DoLinkedList();
		dolink.print();

	}

	
	// 5. 학생 삭제
	public void setDelete() {
		StudentData stu = new StudentData();
		DoLinkedList dolink = new DoLinkedList();
		dolink.delete(stu);
	}
}