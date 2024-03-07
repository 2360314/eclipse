/*
 * 3사람의 성적처리프로그램.
 * 입력 : 이름,국,영,수
 * 연산 : 총점,평균
 * 출력 : 이름,국,영,수,총,평
 */
import java.util.Scanner;
public class ArrayExam01 {

	public static void main(String[] args) {
	
		String []name=new String[3];  // 이름
		int [][]score = new int[3][4]; // 국,영,수,총
		float []avg=new float[3]; //평균 
		
		String []scoName = {"Name","Kor","Eng","Mat","Total","Avg"};
		
		Scanner sc = new Scanner(System.in);
		
		
		
		
		
				
		for(int j=0;j<3;j++) {
			// 입력 :이름,국,영,수
			//System.out.print(scoName[0]+"input: ");
			//name[j]= sc.next();
			 nameInput(scoName,name,sc,j); 
			
			for(int i=0;i<3;i++) {
				System.out.print(scoName[i+1]+" input: ");
				score[j][i] = sc.nextInt();
				
				score[j][3] += score[j][i];
			}
			avg[j] = score[j][3]/3.f; 
			// 연산 : 총,평
		}
		//출력 : 이름,국어,영어,수학,총점,평균
		
		for(int j=0;j<3;j++) {
			System.out.print(name[j]+"\t");
			for(int i=0;i<4;i++) {
				System.out.print(score[j][i]+"\t");
			}
			System.out.println(avg[j]);
		}
	}

	private static void nameInput(String[] scoName, String[] name, Scanner sc,int j) {
		
		System.out.print(scoName[0]+"input: ");
		name[j]= sc.next();
		
	}

}
