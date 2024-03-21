package d240319;

import java.util.Random;
import java.util.Scanner;

public class BaseballGameFunc {

    private Random random; // 랜덤 객체
    private int[] com; // 컴퓨터가 생성한 랜덤 숫자
    private int[] p1; // 사용자가 입력한 숫자
    private int strike; // 스트라이크 수
    private int ball; // 볼 수
    private float total; // 총 시도 횟수
    private float count; // 총 시도 횟수
    private int set; // 게임 세트 수
    private Scanner sc; // 사용자 입력을 위한 Scanner 객체

    public BaseballGameFunc() {
        random = new Random();
        com = new int[3];
        p1 = new int[3];
        total = 0;
        set = 0;
        sc = new Scanner(System.in);
        count = 0;
    }

    public static void main(String[] args) {
        new BaseballGameFunc().runGame();
    }

    // 게임 실행 메서드
    public void runGame() {
        System.out.println("Game Start");

        char cont;
        do {
            ++set;
            com = generateRandomNumber();
//            컴퓨터 숫자 보여주기
//            printNumber();

            while (true) {
                p1 = getInputNumber();
                strike = countStrike();
                ball = countBall();
                printResult();
               
                count++;
                if (strike == 3) {
                    System.out.println("정답!");
                    total += count;
                    System.out.println("입력 횟수: " + count);
                    System.out.println("세트: " + set);
                    count = 0;
                    break;
                }
            }

            System.out.println("평균 " + total / set + " 회 만에 정답");
            System.out.println("계속하시겠습니까? (Y/N)");
            cont = sc.next().charAt(0);
        } while (cont == 'y' || cont == 'Y');

        System.out.println("게임 종료!");
    }

    // 랜덤 숫자 생성 메서드
    public int[] generateRandomNumber() {
        for (int i = 0; i < com.length; i++) {
            com[i] = random.nextInt(10);
            for (int j = 0; j < i; j++) {
                if (com[i] == com[j]) {
                    i--;
                    break;
                }
            }
        }
        return com;
    }

    // 컴퓨터 숫자 출력 메서드
    public void printNumber() {
        System.out.print("컴퓨터 숫자: ");
        for (int i = 0; i < com.length; i++) {
            System.out.print(com[i]);
        }
        System.out.println();
    }

    // 사용자 입력 받는 메서드
    public int[] getInputNumber() {
        System.out.println("세 자리 숫자를 입력하세요:");
        String tmp = sc.next();
        for (int i = 0; i < 3; i++) {
            p1[i] = tmp.charAt(i) - '0';
        }
        return p1;
    }

    // 스트라이크 개수 세는 메서드
    public int countStrike() {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (com[i] == p1[i]) {
                strike++;
            }
        }
        return strike;
    }

    // 볼 개수 세는 메서드
    public int countBall() {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (com[i] == p1[j] && i != j) {
                    ball++;
                }
            }
        }
        return ball;
    }

    // 결과 출력 메서드
    public void printResult() {
        if (strike == 0 && ball == 0) {
            System.out.println("아웃");
        } else {
            System.out.println(strike + " Strike\t" + ball + " Ball");
        }
    }
}
