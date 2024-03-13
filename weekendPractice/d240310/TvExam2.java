package d240310;
// class TV 는 이미 TvExam1 에서 정의해두었다.


public class TvExam2 {
	public static void main(String[] args) {
	Tv t1 = new Tv();
	Tv t2 = new Tv();

	
	t2.channel = 7;
	
	System.out.println(t1.channel);
	System.out.println(t2.channel);
	
	t1.channel = 5;
	
	System.out.println(t1.channel);
	System.out.println(t2.channel);
	
	}
}
