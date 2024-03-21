package d240314;
import java.util.*;

public class AllStudentSet {

    private HashSet<StuArrayList> studentSet;

    public AllStudentSet() {
        studentSet = new HashSet<>();
    }

    public static void main(String[] args) {
        AllStudentSet stu = new AllStudentSet();
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("1. 학생정보입력");
            System.out.println("2. 학생정보수정");
            System.out.println("3. 학생정보검색");
            System.out.println("4. 학생전체출력");
            System.out.println("5. 종료");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    stu.setStudent(sc);
                    break;
                case 2:
                    stu.setModify(sc);
                    break;
                case 3:
                    stu.setSearch(sc);
                    break;
                case 4:
                    stu.setDisp();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }

        } while (true);
    }

    // 1. 입력
    private void setStudent(Scanner sc) {
        StuArrayList stu = new StuArrayList(); 
        sc.nextLine(); // 버퍼 비우기
        System.out.println("학생이름 입력:");
        String Name2 = sc.nextLine(); // next() 대신 nextLine() 사용
        System.out.println("국어점수 입력:");
        int kor = sc.nextInt();
        System.out.println("영어점수 입력:");
        int eng = sc.nextInt();
        System.out.println("수학점수 입력:");
        int mat = sc.nextInt();
        stu.setName2(Name2);
        stu.setKor(kor);
        stu.setEng(eng);
        stu.setMat(mat);
        stu.getTotal();
        stu.getAvg();
        studentSet.add(stu);
    }
    
    // 2. 수정
    private void setModify(Scanner sc) {
    	Iterator<StuArrayList> it = studentSet.iterator();
    	
        System.out.println("누구의 점수를 수정할까요? ");
        String Name2 = sc.next();
        for (StuArrayList student : studentSet) {
            if (Name2.equals(student.getName2())) {
                System.out.println("찾았습니다. ");
                System.out.println("1. 국어점수수정");
                System.out.println("2. 영어점수수정");
                System.out.println("3. 수학점수수정");
                System.out.println("4. 수정안함");

                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("국어점수 입력:");
                        student.setKor(sc.nextInt());
                        break;
                    case 2:
                        System.out.println("영어점수 입력:");
                        student.setEng(sc.nextInt());
                        break;
                    case 3:
                        System.out.println("수학점수 입력:");
                        student.setMat(sc.nextInt());
                        break;
                    case 4:
                        break;
                }
                break;
            }
        }
    }

    private void setSearch(Scanner sc) {
        System.out.println("누구 찾나요? ");
        String Name2 = sc.next();
        for (StuArrayList student : studentSet) {
            if (Name2.equals(student.getName2())) {
                System.out.println("찾았습니다. ");
                System.out.println(student.getName2() + "\t" + student.getKor() + "\t" + student.getEng() + "\t"
                        + student.getMat() + "\t" + student.getTotal() + "\t" + student.getAvg());
                break;
            }
        }
    }

    private void setDisp() {
        System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
        System.out.println("=============================================");
        for (StuArrayList student : studentSet) {
            System.out.println(student.getName2() + "\t" + student.getKor() + "\t" + student.getEng() + "\t"
                    + student.getMat() + "\t" + student.getTotal() + "\t" + student.getAvg());
        }
    }
}

class StuArrayList {

    Name2 Name2;
    Subject2 kor;
    Subject2 eng;
    Subject2 mat;
    int total;
    float avg;

    public StuArrayList() {
        Name2 = new Name2();
        kor = new Subject2();
        eng = new Subject2();
        mat = new Subject2();
    }

    public void setName2(String Name2) {
        this.Name2.setName2(Name2);
    }

    public void setKor(int kor) {
        this.kor.setSubject2(kor);
    }

    public void setEng(int eng) {
        this.eng.setSubject2(eng);
    }

    public void setMat(int mat) {
        this.mat.setSubject2(mat);
    }

    public String getName2() {
        return Name2.getName2();
    }

    public int getKor() {
        return kor.getSubject2();
    }

    public int getEng() {
        return eng.getSubject2();
    }

    public int getMat() {
        return mat.getSubject2();
    }

    public int getTotal() {
        return total = getKor() + getEng() + getMat();
    }

    public float getAvg() {
        return avg = (getKor() + getEng() + getMat()) / 3.f;
    }
}

class Name2 {

    private String Name2;

    public String getName2() {
        return Name2;
    }

    public void setName2(String Name2) {
        this.Name2 = Name2;
    }
}

class Subject2 {

    private int Subject2;

    public int getSubject2() {
        return Subject2;
    }

    public void setSubject2(int Subject2) {
        this.Subject2 = Subject2;
    }
}
