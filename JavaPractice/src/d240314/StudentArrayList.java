package d240314;

import java.util.*;

class StudentArrayList {
	
	// 이름은 Name Clss 에서
	// 과목은 Subject Class 에서
	// 총점, 평균은 여기에서
	Name name;		// Name 클래스를 갖다 쓸것이고, 그 변수 이름은 name으로 한다.
	Subject kor;	// Subject 클래스를 갖다 쓸것이고, 그 변수 이름은 kor으로 한다.
	Subject eng;
	Subject mat;
	int total;
	float avg;
	
	public StudentArrayList() {		// 생성자1.
		name = new Name();
		kor = new Subject();
		eng = new Subject();
		mat = new Subject();
	}
	public StudentArrayList(Name name, Subject kor, Subject eng, Subject mat) {		// 외부주입 기능 오버로딩
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	
	public void setName(String name) {
		this.name.setName(name);
	}
	
	public void setKor(int kor) {
		this.kor.setSubject(kor);
	}
	public void setEng(int eng) {
		this.eng.setSubject(eng);
	}
	public void setMat(int mat) {
		this.mat.setSubject(mat);
	}
	

	
	public String getName() {
		return name.getName();
	}
	
	public int getKor() {
		return kor.getSubject();
	}
	public int getEng() {
		return eng.getSubject();
	}
	public int getMat() {
		return mat.getSubject();
	}
	public int getTotal() {
		return total = getKor()+getEng()+getMat();
	}
	public float getAvg() {
		return avg = (getKor()+getEng()+getMat())/3.f;
	}
	


}

class Name {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

class Subject {
	private int subject;

	public int getSubject() {
		return subject;
	}

	public void setSubject(int subject) {
		this.subject = subject;
	}
	
}

//class StudentArrayList{
//	
//	StudentData studata;
//		
//	public StudentArrayList(){
//		list = new ArrayList<StudentData>();
//		Scanner sc = new Scanner(System.in);
//	}
//	
//}

