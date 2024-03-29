package d240320;
import java.util.Random;

public class InsertSortAns {



    private int comparisonCnt;  //비교 횟수

    public InsertSortAns() {
        comparisonCnt = 0;
    }
    public static void main(String[] args) {
        InsertSortAns InsertSortAns = new InsertSortAns();
        int data [] = new int[50];
        Random random = new Random();

        for(int i = 0; i < 50; i++ ) {
            data[i] = random.nextInt(1000);
        }

        InsertSortAns.InsertSortAns(data);

        for(int i : data) {
            System.out.print(i +", ");
        }
        System.out.println();
        System.out.println("비교 횟수: "+InsertSortAns.comparisonCnt);
    }

    public void InsertSortAns(int[] data) {

        //배열의 길이만큼 반복
        for(int i=1; i < data.length; i++) {

            //첫 번째 for문의 i의 위치 => 인덱스, 비교 대상의 값을 선정
            int keyValue = data[i];
            //첫 번째 for문의 i의 위치부터 0번째 index까지 비교대상의 변수명
            // 현재 위치의 i는 비교할 필요가 없다. [ 초기 선언시, 자기 자신 이므로 ]
            int searchIndex = i - 1;

            //삽입 정렬의 비교 대상
            //1. 0 번째 인덱스까지 비교
            //2. 제일 앞은 최소값이므로, 자신보다 작은 index 나올때까지 찾기 위해 반복문
            while(0 <= searchIndex && data[searchIndex] > keyValue) {
                comparisonCnt++;            //삽입정렬 횟수 Count
                
                data[searchIndex+1] = data[searchIndex];    //첫 번째 조건의 값이 자기보다 크다면 index 한칸씩 뒤로 미루기.
                searchIndex--;                              //반복을 위한 증감값 설정 ( while 탈출 용)
            }

            data[searchIndex+1] = keyValue; //while이 끝날 경우, 해당 index에 값 생성, + 위에서 index가 --되었으므로 다시 +1 하기
        }
    }
}