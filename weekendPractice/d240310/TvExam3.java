package d240310;
// 마찬가지로 class TV 는 TvExam1 Class에 이미 선언되어있으마ㅐ	8
public class TvExam3 {

	public static void main(String[] args) {
		Tv[] tvArr = new Tv[5];
		
		for (int i = 0; i<5; i++) {
			tvArr[i] = new Tv();
			
			tvArr[i].channel = 10*(i+1);
		
			System.out.println("TV"+i+1+"의 채널은 "+tvArr[i].channel);
		}
			

	}

}
