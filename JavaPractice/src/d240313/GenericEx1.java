package d240313;


public class GenericEx1<T> {		// 객체타입에만 T를 쓸 수 있다.
	T[] v;
	
	public void set(T[] n) {
		v = n;
	}
	
	public void print() {
		for(T s:v) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
//		GenericEx1<String> t = new GenericEx1<String>();
//		
//		String[] ss = {"애", "아", "서"};
//				t.set(ss);
//				t.print();
		
		
		GenericEx1<Integer> t = new GenericEx1<Integer>();
		
		Integer[] ii = {1, 2, 3};
		t.set(ii);
		t.print();
	}

}


