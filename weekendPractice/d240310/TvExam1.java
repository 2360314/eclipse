package d240310;

class Tv {
	String color;
	boolean power;
	int channel;
	
	void power() {
		power =! power;
	}
	
	void channelUp() {
		++channel;
	}
	
	void channelDown() {
		--channel;
	}
}	
public class TvExam1{

	public static void main(String[] args) {
		Tv t = new Tv();
		t.channel = 7;
		t.channelDown();
		System.out.println(t.channel);

	}
}
