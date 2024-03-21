package d240314;
// 방법1. Thread 클래스 상속받아서 하는 법
//public class SingleThreadEx extends Thread{
//	private int[] temp;
//	public SingleThreadEx(String threadname) {
//		super(threadname);
//		temp = new int[10];
//		for(int start=0; start<temp.length;start++) {
//			temp[start] = start;
//		}
//	}
//	public void run() {
//		for(int start:temp) {
//			try {
//				Thread.sleep(1000);
//			} catch(InterruptedException ie){
//				ie.printStackTrace();
//			}
//			System.out.printf("현재 쓰레드 이름: %s, " ,currentThread().getName());
//			System.out.printf("Temp Value: %d %n", start);
//			
//		}
//	}
//	
//	public static void main(String[] args) {
//		SingleThreadEx st = new SingleThreadEx("Superman");
//		st.start();
//
//	}
//
//}

// 방법2. Runnable 인터페이스
public class SingleThreadEx implements Runnable {
	private int[] temp;

	public SingleThreadEx() {
//		super(threadname);								// 2. 오브젝트 안에 문자열을 받을 수가 없다. 그래서 이름을 줘야한다.
		temp = new int[10];
		for (int start = 0; start < temp.length; start++) {
			temp[start] = start;
		}
	}

	public void run() {		// 추상메서드 구체화
		for (int start : temp) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			System.out.printf("현재 쓰레드 이름: %s, ", Thread.currentThread().getName());
			System.out.printf("Temp Value: %d %n", start);

		}
	}

	public static void main(String[] args) {
		SingleThreadEx st = new SingleThreadEx();	// 1. superman 이라는건 내가 thread에 주고싶은 이름임.
		Thread th = new Thread(st);			// 3. 그래서 Thread 클래스에서 객체를 만들어가지고 String 이름을 넘기려함
		th.setName("superman");						// 4. setName 을 통해서 이름 받게 넘김
		
		//위의 2줄을 이렇게 만들수도 있다.
		Thread th2 = new Thread(st, "superman");
		
		th.start();
		th2.start();
	}

}
