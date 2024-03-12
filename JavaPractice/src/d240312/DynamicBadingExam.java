package d240312;


class Halbe{
	public void disp() {
		System.out.println("Halbe");
	}
}

class Abe extends Halbe{
	public void disp() {
		System.out.println("Abe");
	}
	
	public void dispAbe() {
		System.out.println("DispMe");
	}
}


class Me extends Abe{
	public void disp() {
		System.out.println("Me");
	}
	
	public void dispMe() {
		System.out.println("dispMe");
	}
}

public class DynamicBadingExam {

	public static void main(String[] args) {
		Me me = new Me();
		
		me.disp();
		
		Abe abe = new Abe();
		abe.disp();
		
		Halbe halbe = new Halbe();
		halbe = abe;		// 동적바인딩
		halbe.disp();
		
		halbe = me;
		halbe.disp();
		
		halbe.dispMe();
	}

}
