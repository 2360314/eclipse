import java.awt.*;
import java.awt.event.*;

public class AnonymousInnerPractice extends Frame {

    // 패널 선언
    Panel p1, p2, p3;
    // 텍스트필드, 텍스트영역, 버튼 선언
    TextField tf;
    TextArea ta;
    Button b1, b2;

    // 생성자
    public AnonymousInnerPractice() {
        // 프레임 제목 설정
        super("Adapter Exam");

        // 패널 생성
        p1 = new Panel();
        p2 = new Panel();
        p3 = new Panel();

        // 텍스트필드와 텍스트영역 생성
        tf = new TextField(35);
        ta = new TextArea(10, 35);

        // 버튼 생성
        b1 = new Button("Clear");
        b2 = new Button("Exit");

        // 각 패널에 컴포넌트 추가
        p1.add(tf);
        p2.add(ta);
        p3.add(b1);
        p3.add(b2);

        // 프레임에 패널 배치
        add("North", p1);
        add("Center", p2);
        add("South", p3);

        // 프레임 크기 설정 및 화면에 표시
        setBounds(300, 200, 300, 300);
        setVisible(true);

        // Clear 버튼에 대한 ActionListener 설정 (anonymous 클래스)
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 텍스트영역과 텍스트필드를 초기화하고, 텍스트필드에 포커스를 설정
                ta.setText("");
                tf.setText("");
                tf.requestFocus();
            }
        });

        // Exit 버튼에 대한 ActionListener 설정 (anonymous 클래스)
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 프로그램 종료
                System.exit(0);
            }
        });

        // 텍스트필드에 대한 KeyListener 설정 (anonymous 클래스)
        tf.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                // Enter 키가 입력되면 텍스트영역에 텍스트 추가하고, 텍스트필드를 초기화
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    ta.append(tf.getText() + "\n");
                    tf.setText("");
                }
            }
        });

        // 윈도우 닫기 이벤트에 대한 WindowListener 설정 (anonymous 클래스)
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                // 프로그램 종료
                System.exit(0);
            }
        });
    }

    // 메인 메소드
    public static void main(String[] args) {
        // anonymous 클래스로 구현된 프레임 생성
        new AnonymousInnerPractice();
    }
}
