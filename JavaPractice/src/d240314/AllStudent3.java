package d240314;

import java.util.*;

public class AllStudent3 {
	
	ArrayList<StudentArrayList> list;			// list라는 StudentData의 래퍼런스 제네릭생성 

	public AllStudent3() {
		list = new ArrayList<StudentArrayList>();
	}
	
	public static void main(String[] args) {
		
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
			case 4: stu.setDisp(); break;
			case 5: System.exit(0);; break;		// 무한루프 강제종료
			}
		
		} while(true); 

	}
	
	// 1. 학생정보입력
		private void setStudent() {
			
			StudentArrayList stu = new StudentArrayList(); // 학생객체생성
			Scanner sc = new Scanner(System.in);		
	
			System.out.println("학생이름 입력:"+"\t");
			stu.setName(sc.next());
			System.out.println("국어점수 입력:"+"\t");
			stu.setKor(sc.nextInt());
			System.out.println("영어점수 입력:"+"\t");
			stu.setEng(sc.nextInt());
			System.out.println("수학점수 입력:"+"\t");
			stu.setMat(sc.nextInt());
			stu.getTotal();
			stu.getAvg();
			
			list.add(stu);
			
	
//			this.stu[index++]=stu;  // 배열일 때는 이렇게 해서 넘겼었다.		
		}
		
	// 2. 학생정보수정
	private void setModify() {
		Scanner sc = new Scanner(System.in);
		System.out.println("누구의 점수를 수정할까요? ");
		String name = sc.next();
		
		int i=0;
		while(true) {
			if( name.equals(list.get(i).getName())) {
				System.out.println("찾았습니다. ");
				
				while(true) {
					System.out.println("1.국어점수수정");
					System.out.println("2.영어점수수정");
					System.out.println("3.수학점수수정");
					System.out.println("4.수정안함");
					
					int n = sc.nextInt();
					switch(n) {
					case 1: list.get(i).setKor(sc.nextInt()); break;
					case 2: list.get(i).setEng(sc.nextInt()); break;
					case 3: list.get(i).setMat(sc.nextInt()); break;
					
					}
					if(n == 4) break; 
				}
				break;
			}
			i++;
		}
		
	}
	
	// 3. 학생정보검색
	private void setSearch() {
		Scanner sc = new Scanner(System.in);
		System.out.println("누구 찾나요? ");
		String name = sc.next();
		
		int i=0;
		while(true) {
			if( name.equals(list.get(i).getName())) {
				System.out.println("찾았습니다. ");
				System.out.println("이름"+"\t"+"국어"+"\t"+"영어"+"\t"+"수학"+"\t"+"총점"+"\t"+"평균");
				System.out.println("=============================================");				
				System.out.print(list.get(i).getName()+"\t");
				System.out.print(list.get(i).getKor()+"\t");
				System.out.print(list.get(i).getEng()+"\t");
				System.out.print(list.get(i).getMat()+"\t");
				System.out.print(list.get(i).getTotal()+"\t");
				System.out.println(list.get(i).getAvg());
				
				break;
				
			}
			
			i++;
		}
		
	}
	
	// 4. 학생전체출력
	private void setDisp() {
			System.out.println("이름"+"\t"+"국어"+"\t"+"영어"+"\t"+"수학"+"\t"+"총점"+"\t"+"평균");
			System.out.println("=============================================");
		for(StudentArrayList s:list) {
			if(s == null) break;
			System.out.print(s.getName()+"\t");
			System.out.print(s.getKor()+"\t");
			System.out.print(s.getEng()+"\t");
			System.out.print(s.getMat()+"\t");
			System.out.print(s.getTotal()+"\t");
			System.out.println(s.getAvg());
		}
		
	}
	
	
	
	
}