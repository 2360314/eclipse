package d240311;

import java.util.Scanner;
public class EmployeeSalary {
	
	EmployeeData[] ed = new EmployeeData[50];

	
	int index = 0;
	
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("급여관리 프로그램입니다.");
		
		int menu;
		do {
		System.out.println("---------------");
			
		EmployeeSalary es = new EmployeeSalary();

		System.out.println("메뉴를 선택하세요.");
		System.out.println("1. 직원등록  2. 직원수정  3. 직원검색  4. 직원출력  5. 종료");
		
		menu = sc.nextInt();
		
			switch(menu) {
				
				case 1 : es.regEmployee();							break;
				case 2 : es.modiEmployee();							break;
//				case 3 : searchEmployee();							break;
//				case 4 : printEmployee();							break;
				case 5 : System.out.println("프로그램을 종료합니다.");		
			}
			
		} while (menu <= 5);
		
	}
	
	
	// 1. 직원등록
	public void regEmployee() {
		Scanner sc = new Scanner(System.in);
		ed[index] = new EmployeeData();
		
		System.out.println("직원등록 메뉴입니다.");
		
		System.out.print("직원번호를 입력하세요: ");
		ed[index].setEmpno(sc.nextInt());
		
		System.out.print("직원이름을 입력하세요: ");
		ed[index].setName(sc.next());
		
		System.out.print("기본급을 입력하세요: ");
		ed[index].setSalBasic(sc.nextInt());
		
		System.out.print("부서를 입력하세요: ");
		ed[index].setDept(sc.next());
		
		System.out.print("입사일을 입력하세요(YYYYMMDD): ");
		ed[index].setJoinDate(sc.nextInt());
		
		System.out.print("고용형태를 입력하세요(1. 정규직 2. 비정규직): ");
		ed[index].setEmpType(sc.nextInt());
		
		
		// 정규직 / 비정규직 선택입력
		if(ed[index].getEmpType() == 1) {
			empPosotionEnroll();}
		
		
		else if (ed[index].getEmpType() == 2) { 
			empEndDateEnroll();}
		

		System.out.println("등록이 완료되었습니다.");
		System.out.print(ed[index].getEmpno()+"\t"+ed[index].getName()+"\t"+ed[index].getSalBasic()+"\t"+ed[index].getDept()+"\t"+ed[index].getJoinDate()+"\t"+ed[index].getEmpType());
		System.out.println(ed[index].getEmpType());
//		System.out.println(ed[index]);		//	ed[index] 을 한번에 보여주고싶은데 어떻게...?
		
		index++;
		
	}
	
	// 1-1. 정규직 직원 직급 입력
	public String empPosotionEnroll() {			
		System.out.print("직급을 입력하세요: "+"\t");
		
		Scanner sc = new Scanner(System.in);	
		RegularWorker[] rw = new RegularWorker[50];
	
		int index = 0;
		
		rw[index].getPosition(sc.next());
		
		return rw.position;
	}
	
	// 1-2. 비정규직 직원 계약종료일 입력
	public int empEndDateEnroll() {
		System.out.print("계약종료일을 입력하세요(YYYYMMDD): "+"\t");
		
		Scanner sc = new Scanner(System.in);
		PartTimer[] pt = new PartTimer[50];
		int index = 0;
		
		pt.endDate = sc.nextInt();
		
		return pt.endDate;
		
	}
	
	
	// 2. 직원수정
	public void modiEmployee() {
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 직원의 직원번호를 입력하세요:"+"\t");
			
		int modiEmpno = sc.nextInt();
		
		int i = 0;
		
		while(true) {
			if( modiEmpno == ed[i].getEmpno()) {
				System.out.println("찾았습니다. ");
				
				while(true) {
					System.out.println("1.직원이름수정");
					System.out.println("2.기본급수정");
					System.out.println("3.부서수정");
					System.out.println("4.직급수정");
					System.out.println("5.정규/비정규직 수정");
					
					int n = sc.nextInt();
					switch(n) {
					case 1: ed[i].setName(sc.next()); break;
					case 2: ed[i].setSalBasic(sc.nextInt()); break;
					case 3: ed[i].setDept(sc.next()); break;
					case 4: ed[i].setPosition(sc.next()); break;		// 다른 클래스에 있는데..?
					case 5: ed[i].setEmpType(sc.nextInt()); break;
					
					}
					if(n == 6) break; 
				}
				break;
			}
			i++;
		}
		
	}
	
	
	// 3. 직원검색
	
	
	

}
