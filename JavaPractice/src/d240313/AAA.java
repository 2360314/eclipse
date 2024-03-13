package d240313;

public interface AAA {
	int A = 10;		// 상수임. interface는 변수 앞에 "final static" 생략되어있음
	
	void disp();	// "abstract" void disp() 가 앞에 생략되어있다. 인터페이스는 추상메서드만 만드니까
}
