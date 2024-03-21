package d240314;
import java.util.*;

public class AllStudentMap {
	private int i;
    private HashMap<Integer, StudentArrayList> studentMap;

    public AllStudentMap() {
        studentMap = new HashMap<>();
    }

    public static void main(String[] args) {
        AllStudentMap stu = new AllStudentMap();
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
        String Name3 = sc.nextLine(); // next() 대신 nextLine() 사용
        System.out.println("국어점수 입력:");
        int kor = sc.nextInt();
        System.out.println("영어점수 입력:");
        int eng = sc.nextInt();
        System.out.println("수학점수 입력:");
        int mat = sc.nextInt();
        stu.setName3(Name3);
        stu.setKor(kor);
        stu.setEng(eng);
        stu.setMat(mat);
        stu.getTotal();
        stu.getAvg();
        this.studentMap.put(i, stu);
    }
    
    // 2. 수정
    private void setModify(Scanner sc) {
    	
        System.out.println("누구의 점수를 수정할까요? ");
        String Name3 = sc.next();
        int i = 0;
        while(true) {
        	if(name3.equals(studentMap.get(i).getName())) {
        		System.out.println("찾았습니다.");
      
                System.out.println("1. 국어점수수정");
                System.out.println("2. 영어점수수정");
                System.out.println("3. 수학점수수정");
                System.out.println("4. 수정안함");

                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("국어점수 입력:");
                        studentMap.setKor(sc.nextInt());
                        break;
                    case 2:
                        System.out.println("영어점수 입력:");
                        studentMap.setEng(sc.nextInt());
                        break;
                    case 3:
                        System.out.println("수학점수 입력:");
                        studentMap.setMat(sc.nextInt());
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
        String Name3 = sc.next();
        int i = 0;
        
        while(true) {
        	if(Name3.equals(studentMap.getName3()))
        }
        for (StuArrayList student : studentMap) {
            if () {
                System.out.println("찾았습니다. ");
                System.out.println(student.getName3() + "\t" + student.getKor() + "\t" + student.getEng() + "\t"
                        + student.getMat() + "\t" + student.getTotal() + "\t" + student.getAvg());
                break;
            }
        }
    }

    private void setDisp() {
        System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
        System.out.println("=============================================");
        for (StuArrayList student : studentMap) {
            System.out.println(student.getName3() + "\t" + student.getKor() + "\t" + student.getEng() + "\t"
                    + student.getMat() + "\t" + student.getTotal() + "\t" + student.getAvg());
        }
    }
}

class StuArrayList {

    Name3 Name3;
    Subject3 kor;
    Subject3 eng;
    Subject3 mat;
    int total;
    float avg;

    public StuArrayList() {
        Name3 = new Name3();
        kor = new Subject3();
        eng = new Subject3();
        mat = new Subject3();
    }

    public void setName3(String Name3) {
        this.Name3.setName3(Name3);
    }

    public void setKor(int kor) {
        this.kor.setSubject3(kor);
    }

    public void setEng(int eng) {
        this.eng.setSubject3(eng);
    }

    public void setMat(int mat) {
        this.mat.setSubject3(mat);
    }

    public String getName3() {
        return Name3.getName3();
    }

    public int getKor() {
        return kor.getSubject3();
    }

    public int getEng() {
        return eng.getSubject3();
    }

    public int getMat() {
        return mat.getSubject3();
    }

    public int getTotal() {
        return total = getKor() + getEng() + getMat();
    }

    public float getAvg() {
        return avg = (getKor() + getEng() + getMat()) / 3.f;
    }
}

class Name3 {

    private String Name3;

    public String getName3() {
        return Name3;
    }

    public void setName3(String Name3) {
        this.Name3 = Name3;
    }
}

class Subject3 {

    private int Subject3;

    public int getSubject3() {
        return Subject3;
    }

    public void setSubject3(int Subject3) {
        this.Subject3 = Subject3;
    }
}
