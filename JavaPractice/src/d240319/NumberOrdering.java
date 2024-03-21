package d240319;

import java.util.Scanner;

public class NumberOrdering {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력
        System.out.print("첫 번째 수를 입력하세요: ");
        int num1 = scanner.nextInt();
        System.out.print("두 번째 수를 입력하세요: ");
        int num2 = scanner.nextInt();

        // 출력
        System.out.println(num1 + "과 " + num2 + " 사이의 정돈된 수:");
        printNumberOrdering(num1, num2);
    }

    // 출력함수
    private static void printNumberOrdering(int num1, int num2) {
       
        for (int i = num1 + 1; i < num2; i++) {
            if (isOrderedNumber(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // 검증함수
    private static boolean isOrderedNumber(int num) {
    	
        String strNum = String.valueOf(num);
        // 각 자리 숫자가 왼쪽부터 차례대로 증가하는지 확인하고 맞으면 true, 틀리면 false
        for (int i = 0; i < strNum.length() - 1; i++) {
            if (strNum.charAt(i) >= strNum.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
    
  
}
