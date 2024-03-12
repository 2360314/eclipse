package d240311;

public class EmployeeData {
	
	// field
	private int empno;		// 직원번호
	private String name;
	private int salBasic;	// 기본급
//	int salAdd;		// 추가수당
	private String dept;	// 소속부점
	private int joinDate;	// 입사일
	private int empType;	// 고용형태. 1=정규직, 2=비정규직
	
	//constructor
	public EmployeeData() {
		
	}
	public EmployeeData(int empno, 	String name, int salBasic, int salAdd, String dept, int joinDate, int empType){
		this.empno    = empno;
		this.name     = name;
		this.salBasic = salBasic;	
//		this.salAdd   = salAdd;		
		this.dept     = dept;	
		this.joinDate = joinDate;
		this.empType  = empType;
		
	}
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalBasic() {
		return salBasic;
	}
	public void setSalBasic(int salBasic) {
		this.salBasic = salBasic;
	}
//	public int getSalAdd() {
//		return salAdd;
//	}
//	public void setSalAdd(int salAdd) {
//		this.salAdd = salAdd;
//	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(int joinDate) {
		this.joinDate = joinDate;
	}

	public int getEmpType() {
		return empType;
	}

	public void setEmpType(int empType) {
		this.empType = empType;
	}


}


// 정규직 직급관리
class RegularWorker{
	String position;	// 직급

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	
}

// 비정규직 계약종료일 관리
class PartTimer{
	int endDate;	// 계약종료일

	public int getEndDate() {
		return endDate;
	}

	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}
	
	
}