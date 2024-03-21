package d240314;
class MyRunnableTwo implements Runnable{
	public void run() {
		System.out.println("run");
		first();
	}
	
	public void first() {
		System.out.println("first");
		second();
	}
	
	public void second() {
		System.out.println("second");
	}
}
public class JoinEx {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+" start");
		Runnable r = new MyRunnableTwo();	// Runnable 은 인터페이스라 마이러너블투 클래스를 받아서 객체 만든다.
		Thread myThread = new Thread(r);	// Runnable 에 접근하는 변수 r을 Thread 클래스에 적용시킴
		myThread.start();
		
		// join 을 활용해서 myThread.start() 메서드 끝날 때까지 main 쓰레드를 기다린다.
		try {
			myThread.join();
		}
		catch(InterruptedException ie){
			ie.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+" end");
	}

}
