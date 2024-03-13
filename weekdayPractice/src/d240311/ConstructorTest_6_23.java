package d240311;

class Data1{
	int value;
}

class Data2(int x){
	int value;
	
	Data2(int x){
		value = x;
		System.out.println(x);
	}
	Data2(){
		int value;
	}
}



public class ConstructorTest_6_23 {

	public static void main(String[] args) {
		Data1 d1 = new Data1();
		Data2 d2 = new Data2();

	}

}
