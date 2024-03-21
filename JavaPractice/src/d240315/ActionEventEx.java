package d240315;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Exit extends WindowAdapter{
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
public class ActionEventEx extends Frame implements ActionListener, WindowListener {

	Panel p;
	Button input, exit;
	TextArea ta;

	public ActionEventEx() {
		super("ActionEvnet Test");
		
		// ActionListener - 버튼 누를 때
		p = new Panel();

		input = new Button("input");
		exit = new Button("exit");
		ta = new TextArea();

		input.addActionListener(this); // 이벤트소스와 핸들러 연결
		exit.addActionListener(this); // 이벤트소스와 핸들러 연결

		p.add(input);
		p.add(exit);
		add(p, BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);

		setBounds(300, 300, 300, 200);
		setVisible(true);
		
		
		// WindowListener - x 누를 때 프로그램 종료
		Label ex = new Label("프로그램 종료");
		add(ex);
		
		addWindowListener(this);
		// Exit 클래스를 따로 만들어줬기 때문에 Exit 클래스에 접근하는 객체를 만들어 이렇게 쓸수도 있다.
		// addWindowListener(new Exit());
	}

	public void actionPerformed(ActionEvent ae) {
		String name;
		name = ae.getActionCommand();

		if (name.equals("input"))
			ta.append("button input.\n");

		else {
			ta.append("exit\n");
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
			}

			System.exit(0);

		}
	}
	
	// WindowListener 구체화 시작
	
    public void windowOpened(WindowEvent e) {}

    public void windowClosing(WindowEvent e) { 
    	System.exit(0);
    	}

    public void windowClosed(WindowEvent e) { }

    public void windowIconified(WindowEvent e) {}

    public void windowDeiconified(WindowEvent e) {}

    public void windowActivated(WindowEvent e) {}

    public void windowDeactivated(WindowEvent e) {}

    // main 메서드 동작
	public static void main(String[] args) {
		new ActionEventEx();


	}
}

