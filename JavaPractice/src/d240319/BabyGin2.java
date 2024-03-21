import java.util.Scanner;

public class BabyGin2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println("6개의 숫자를 입력하세요: ");
            String userInput = scanner.next();
            
            BabyGin2 babygin2 = new BabyGin2();
            if (babygin2.isBabyGin2(userInput)) {
                System.out.println("\nbaby-gin입니다 !");
            } else {
                System.out.println("baby-gin이 아닙니다.");
            }
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다.");
        } finally {
            scanner.close();
        }
    }

    // Baby-gin 여부 확인하는 메서드
    public boolean isBabyGin2(String str) {
        int[] counts = new int[10]; // 각 숫자의 등장 횟수를 저장하는 배열

        // 각 숫자의 등장 횟수를 배열에 저장
        for (int i = 0; i < str.length(); i++) {
            int digit = Character.getNumericValue(str.charAt(i));
            counts[digit]++;
        }

        // Baby-gin 여부 확인
        if (isRun(counts) || isTriplet(counts)) {
            return true;
        } else {
            return false;
        }
    }

    // Run 여부 확인하는 메서드
    public boolean isRun(int[] counts) {
        for (int i = 0; i <= 7; i++) {
            // i, i+1, i+2가 모두 1 이상일 때 Run
            if (counts[i] > 0 && counts[i + 1] > 0 && counts[i + 2] > 0) {
                counts[i]--;
                counts[i + 1]--;
                counts[i + 2]--;
                return true;
            }
        }
        return false;
    }

    // Triplet 여부 확인하는 메서드
    public boolean isTriplet(int[] counts) {
        for (int i = 0; i < counts.length; i++) {
            // 해당 숫자가 3 이상일 때 Triplet
            if (counts[i] >= 3) {
                counts[i] -= 3;
                return true;
            }
        }
        return false;
    }
}
