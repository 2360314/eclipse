package d240315;

import java.awt.*;
import java.awt.event.*;

public class EventPractive extends Frame implements ActionListener {

	Panel p1, p2, p3;

	TextField tf; // 입력 받는 텍스트 필드
	TextArea ta; // 출력되는 텍스트 에어리어

	Button b1, b2; // Clear와 Exit 버튼

	// EventPractive 생성자
	public EventPractive() {

		super("Adapter Exam");

		p1 = new Panel(); // 패널 생성
		p2 = new Panel(); // 패널 생성
		p3 = new Panel(); // 패널 생성

		tf = new TextField(35); // 35개의 문자를 입력할 수 있는 텍스트 필드 생성
		ta = new TextArea(10, 35); // 10행 35열의 텍스트 에어리어 생성

		b1 = new Button("Clear"); // Clear 버튼 생성
		b2 = new Button("Exit"); // Exit 버튼 생성

		p1.add(tf); // 텍스트 필드를 p1 패널에 추가
		p2.add(ta); // 텍스트 에어리어를 p2 패널에 추가
		p3.add(b1); // Clear 버튼을 p3 패널에 추가
		p3.add(b2); // Exit 버튼을 p3 패널에 추가

		add("North", p1); // p1 패널을 Frame의 상단에 추가
		add("Center", p2); // p2 패널을 Frame의 가운데에 추가
		add("South", p3); // p3 패널을 Frame의 하단에 추가

		setBounds(300, 200, 300, 300); // Frame의 크기와 위치 설정
		setVisible(true); // Frame을 화면에 표시

		b1.addActionListener(this); // Clear 버튼에 ActionListener 등록
		b2.addActionListener(this); // Exit 버튼에 ActionListener 등록

		tf.addKeyListener(new KeyEventHandler(tf, ta)); // 텍스트 필드에 KeyEventHandler 등록

		addWindowListener(new WindowEventHandler()); // Frame에 WindowEventHandler 등록
	}

	// ActionListener의 actionPerformed 메소드 구현
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand(); // 이벤트에서 명령어 추출
		if (str.equals("Clear")) { // Clear 버튼이 눌렸을 때
			ta.setText(""); // 텍스트 에어리어 내용 지우기
			tf.setText(""); // 텍스트 필드 내용 지우기
			tf.requestFocus(); // 텍스트 필드에 포커스 설정
		} else if (str.equals("Exit")) { // Exit 버튼이 눌렸을 때
			System.exit(0); // 프로그램 종료
		}
	}

	// KeyAdapter를 상속한 KeyEventHandler 클래스
	class KeyEventHandler extends KeyAdapter {
		TextField tf;
		TextArea ta;

		public KeyEventHandler(TextField tf, TextArea ta) {
			this.tf = tf;
			this.ta = ta;
		}

		// KeyTyped 이벤트 처리
		public void keyTyped(KeyEvent e) {
			if (e.getKeyChar() == KeyEvent.VK_ENTER) { // Enter 키가 입력되었을 때
				ta.append(tf.getText() + "\n"); // 텍스트 에어리어에 텍스트 필드의 내용 추가
				tf.setText(""); // 텍스트 필드의 내용 지우기
			}
		}
	}

	// WindowAdapter를 상속한 WindowEventHandler 클래스
	class WindowEventHandler extends WindowAdapter {
		// WindowClosing 이벤트 처리
		public void windowClosing(WindowEvent e) {
			System.exit(0); // 프로그램 종료
		}
	}

	// main 메소드
	public static void main(String[] args) {
		new EventPractive(); // EventPractive 객체 생성
	}
}
