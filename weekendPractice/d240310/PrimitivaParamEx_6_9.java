package d240310;

class Data{
	int x;
}

public class PrimitivaParamEx_6_9 {

	public static void main(String[] args) {
		Data d = new Data();
		d.x = 10;
		System.out.println("main(): x = "+d.x);
		
		change(d.x);
		System.out.println("After Change(d,x)");
		System.out.println("main(): x = "+d.x);

	}
	
	static void change(int x) {
		x = 1000;
		System.out.println("change(): x = "+x);
	}
	
	

}