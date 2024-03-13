package d240310;

public class TvExam4 {

	public static void main(String[] args) {
		Tv tv1 = new Tv();
		Tv tv2 = new Tv();
		Tv tv3 = new Tv();
		
		System.out.println(tv1.channel);
		System.out.println(tv2.channel);
		System.out.println(tv3.channel);

		tv2 = tv1;
		
		tv1.channel = 7;
		
		System.out.println(tv1.channel);
		System.out.println(tv2.channel);
		System.out.println(tv3.channel);
	}

}
