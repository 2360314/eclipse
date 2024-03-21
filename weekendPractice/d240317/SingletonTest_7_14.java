package d240317;
final class Singleton{
	private static Singleton s = new Singleton();
	private Singleton() {
		
	}
	public static Singleton getInstance() {
		if(s==null) 
			s = new Singleton();
		 return s;
	}

}
public class SingletonTest_7_14 {

	public static void main(String[] args) {
//		Singleton s = new Singleton();		// private 에 직접 접근 불가
		Singleton s = Singleton.getInstance();

	}

}
