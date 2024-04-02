package d240329StudentDB;

import java.sql.*;
import java.util.Scanner;

public class DoLinkedList {
	
	// constructor_1
	public DoLinkedList() {
		this("jdbc:mysql://localhost:3306/mydb?severTimezone=UTC", "root", "qwe123!@#");
	}
	// constructor_2
	public DoLinkedList(String url, String user, String pw) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static StudentData head;
	static StudentData cur;
	static StudentData newNode;
	static StudentData del; 		// 이 4개. 처음엔 null 이니까 굳이 뒤에 머 안쓴다.
	Connection conn;
	PreparedStatement pstmt;
	
	// 1. 학생정보입력
	public void add(StudentData stu) {
		
//		// insertSort 영역 시작
//		// 1. 전체 LinkedList 의 길이 구하기
//		int length = 0;
//		while(cur != null) {
//			length++;
//		}
//		
//		// 2. 길이만큼 반복처리
//		for (int i = 1; i < length; i++) {
//	            // 현재 비교 대상의 값을 keyValue에 저장
//	            int keyValue = cur;
//	
//	            // 현재 위치(i)의 이전 요소부터 역순으로 keyValue와 비교
//	            int searchIndex = i - 1;
//		}
		
		// head 여부 판단
		if (head == null) { // 첫 학생 입력할 때 Head를 지정해야되니까 따로 구분함.
			head = stu;
			stu.next = null;
			cur = head;

			
		} else {			// 첫번째 학생이 이미 있는경우 그 뒤에 붙임
			cur = head;
			while (cur.next != null) {
				cur = cur.next;
			}
			cur.next = stu;
			stu.next = null;
		}

	}

	// 2. 수정

	public void modify(StudentData stu) {
		Scanner sc = new Scanner(System.in);
		System.out.println("누구의 점수를 수정할까요? ");
		String name = sc.next();
		cur = head;
		while (cur != null) {
			if (cur.getName().equals(name)) {
				System.out.println("찾았습니다. ");
				while (true) {
					System.out.println("1.국어점수수정");
					System.out.println("2.영어점수수정");
					System.out.println("3.수학점수수정");
					System.out.println("4.수정안함");
					int n = sc.nextInt();
					switch (n) {
					case 1:	cur.setKor(sc.nextInt());	break;
					case 2:	cur.setEng(sc.nextInt());	break;
					case 3:	cur.setMat(sc.nextInt());	break;
					}
					if (n == 4)
						break;
				}
			}
			cur = cur.next;
		}
	}

	// 3. 검색

	public void search(StudentData stu) {
		Scanner sc = new Scanner(System.in);
		System.out.println("누구 찾나요? ");
		String name = sc.next();
		cur = head;
		// 커서돌리기
		while (cur != null) {
			if (name.equals(cur.getName())) {
				System.out.println("찾았습니다. ");
				System.out.println("이름" + "\t" + "국어" + "\t" + "영어" + "\t" + "수학" + "\t" + "총점" + "\t" + "평균");
				System.out.println("=============================================");

				System.out.print(cur.getName() + "\t");
				System.out.print(cur.getKor() + "\t");
				System.out.print(cur.getEng() + "\t");
				System.out.print(cur.getMat() + "\t");
				System.out.print(cur.getTotal() + "\t");
				System.out.println(cur.getAvg());

				break;

			}
			cur = cur.next;
		}

	}

	// 4. 전체출력
	public void print() {
		System.out.println("이름" + "\t" + "국어" + "\t" + "영어" + "\t" + "수학" + "\t" + "총점" + "\t" + "평균");
		System.out.println("=============================================");
		cur = head;

		while (cur != null) {
			System.out.print(cur.getName() + "\t");
			System.out.print(cur.getKor() + "\t");
			System.out.print(cur.getEng() + "\t");
			System.out.print(cur.getMat() + "\t");
			System.out.print(cur.getTotal() + "\t");
			System.out.println(cur.getAvg());
			cur = cur.next;
		}

	}

	// 5. 삭제

	public void delete(StudentData stu) {
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 학생을 입력하세요: ");
		String name = sc.next();
		cur = head;
		while (cur != null) {
			if (name.equals(cur.getName())) {		
				System.out.println("이름" + "\t" + "국어" + "\t" + "영어" + "\t" + "수학" + "\t" + "총점" + "\t" + "평균");
				System.out.println("=============================================");
				System.out.print(cur.getName() + "\t");
				System.out.print(cur.getKor() + "\t");
				System.out.print(cur.getEng() + "\t");
				System.out.print(cur.getMat() + "\t");
				System.out.print(cur.getTotal() + "\t");
				System.out.println(cur.getAvg());
				
				System.out.println("해당 학생을 삭제할까요?(1. 삭제  2. 취소) ");
				int delCheck = sc.nextInt();
				
				switch(delCheck) {
					case 1:	
						del = head;
						// 첫번째 학생 삭제하는경우
						if(cur == head) {		
							head = head.next;
						}
						// 두번째 이상
						else {
	                        while (del.next != cur) {
	                            del = del.next;
	                        }
	                        del.next = cur.next;
						}
						cur.next = null;
						cur = null;
							
					case 2:	break;
				}	
				break;
			}
			cur = cur.next;
		}
	}
	
	// 6. 테이블 저장
	public void dbInput(StudentData stu) {
//		try {
//			String s = "drop table if exists studentTBL;";
//			String sql = "CREATE TABLE studentTBL(\r\n"
//					+ " id int NOT NULL AUTO_INCREMENT PRIMARY key\r\n"
//					+ ",name varchar(100)\r\n"
//					+ ",kor int(10)\r\n"
//					+ ",eng int(10)\r\n"
//					+ ",mat int(10)\r\n"
//					+ ",total int(10)\r\n"
//					+ ",avg float(10))";
//			
//			pstmt = conn.prepareStatement(s);
//			pstmt.executeUpdate();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		System.out.println("==================");
//		System.out.println("테이블생성완료");
//		System.out.println("==================");
		
		try {
			cur = head;
			while (cur != null) {
				String sql = "insert into studentTBL values(?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, cur.getName());
				pstmt.setInt(2, cur.getKor());
				pstmt.setInt(3, cur.getEng());
				pstmt.setInt(4, cur.getMat());
				pstmt.setInt(5, cur.getTotal());
				pstmt.setFloat(6, cur.getAvg());
				pstmt.executeUpdate();
				
				cur = cur.next;
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		
		}	
	}
}
