package d240313;

public class InterExam01 implements CCC {

	public static void main(String[] args) {
		
		InterExam01 inter = new InterExam01();
		CCC inter2 = new InterExam01();
		
		inter.disp();
		inter.disp2();
		inter.disp3();		// 에러안남. 클래스의 객체를 만든거라서.
		
		
		inter2.disp();
		inter2.disp2();
//		inter2.disp3();		// 에러남. CCC는 disp3 를 모르니까.
	
	}

	@Override
	public void disp() {
		System.out.println("Disp");
	}

	@Override
	public void disp2() {
		System.out.println("Disp2");
		
	}
	
	public void disp3() {
		System.out.println("Disp3");
		
	}

}
