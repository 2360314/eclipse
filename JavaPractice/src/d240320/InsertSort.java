//package d240320;
//
//public class InsertSort {
//
//	public static void main(String[] args) {
//		int[] data = new int[1000];
//		
//		for(int i=0; i<1000;i++) {
//			data[i] = (int)(Math.random()*1000);
//		}
//		
//		insertionSort(data);
//		
//		for(int i=0;i<=998;i++) {
//			if(data[i] > data[i+1]) {
//				System.out.print("error");
//			}
//			System.out.println(data[i]);
//		}
//	}
//
//	
//	public static void insertionSort(int[] a) {
//		int tmp = 0;
//		int countI = 0;
//		int countJ = 0;
//		
//		for(int i=0; i<a.length-1;i++) {
//			if(a[i] > a[i+1]) {
//				for(int j = i; j < 0 ; j--) {
//					if(a[j] < a[i]) {
//						tmp = a[i];
//						a[i] = a[j];
//						a[j] = tmp;
//					}
////					else {
////						tmp = a[j];
////						a[j] = a[0];
////						a[0] = a[j];
////					}
//					countJ++;
//				}
//				countI++;
//			}
//		}
//		System.out.println(countI+"회"+countJ+"회");
//	}
//}


package d240320;

import java.util.Random;

public class InsertSort {

    private int comparisonCnt;  // 비교 횟수

    public InsertSort() {
        comparisonCnt = 0;  // 비교 횟수 초기화
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();  // InsertSort 객체 생성
        int data[] = new int[1000];  // 크기가 50인 정수형 배열 생성
        Random random = new Random();  // 랜덤 값을 생성하기 위한 Random 객체 생성

        // 배열에 랜덤한 값을 채움
        for (int i = 0; i <= 998 ; i++) {
            data[i] = random.nextInt(1000);  // 0부터 999까지의 랜덤한 값을 배열에 저장
        }

        insertSort.insertSort(data);  // 삽입 정렬 메서드 호출

        // 정렬된 배열 출력
        for (int i : data) {
            System.out.println(i + ", ");  // 정렬된 배열 요소 출력
        }
        System.out.println();  // 줄 바꿈
        System.out.println("비교 횟수: " + insertSort.comparisonCnt);  // 비교 횟수 출력
    }

    // 삽입 정렬 메서드
    public void insertSort(int[] data) {

        // 배열의 길이만큼 반복
        for (int i = 1; i < data.length; i++) {

            // 현재 비교 대상의 값을 keyValue에 저장
            int keyValue = data[i];

            // 현재 위치(i)의 이전 요소부터 역순으로 keyValue와 비교
            int searchIndex = i - 1;

            // 삽입 정렬의 비교 및 삽입 과정
            // 1. 0부터 searchIndex까지의 요소들과 keyValue를 비교하여 삽입할 위치를 찾음
            // 2. keyValue보다 큰 값들은 오른쪽으로 한 칸씩 이동하여 공간을 만들고, 삽입할 위치를 찾으면 keyValue을 삽입
            while (0 <= searchIndex && data[searchIndex] > keyValue) {
                comparisonCnt++;  // 삽입정렬 횟수 Count
                data[searchIndex + 1] = data[searchIndex];  // 검색된 값보다 큰 값은 오른쪽으로 한 칸씩 이동
                searchIndex--;  // 검색 인덱스를 이전으로 이동하여 다음 요소와 비교
            }

            data[searchIndex + 1] = keyValue;  // 삽입할 위치에 keyValue 삽입
        }
    }
}
