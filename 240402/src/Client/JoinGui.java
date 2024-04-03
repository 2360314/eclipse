package Client;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JoinGui extends JFrame {

	private JPanel joinPanel; // 전체틀 생성
	private JTextField nameField; // 이름
	private JTextField empnoField;
	private JTextField idField;

	private JTextField textField; // 텍스트 필드
	private JPasswordField passwordField; // PW 필드
	private JPasswordField passwordCkField; // PW 필드

	private JButton enrollButton;
	private JButton homeButton;

//	Connection conn;
//	PreparedStatement pstmt;

	public JoinGui() {
		JoinGui();
		nameLabel();
		empnoLabel();
		idLabel();
		pwLabel();
		pwCheckLabel();
		enrollButtonEvent();
		homeButtonEvent();

		setVisible(true); // Gui 켜기
	}

	// 전체 Panel 만들기
	public void JoinGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		joinPanel = new JPanel();
		joinPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(joinPanel);
		joinPanel.setBackground(new Color(255, 255, 255));
		joinPanel.setLayout(null);

	}

	// 이름 입력받기
	public void nameLabel() {
		JLabel name = new JLabel("이름");
		name.setBounds(100, 30, 80, 15);
		joinPanel.add(name);
		nameField = new JTextField();
		nameField.setBounds(200, 30, 115, 20);
		joinPanel.add(nameField);
		nameField.setColumns(10); // 글자수 제한
	}

	// 주민번호(직원번호) 입력받기
	public void empnoLabel() {
		JLabel empno = new JLabel("직원번호");
		empno.setBounds(100, 80, 80, 15);
		joinPanel.add(empno);
		empnoField = new JTextField();
		empnoField.setBounds(200, 80, 115, 20);
		joinPanel.add(empnoField);
		empnoField.setColumns(10); // 글자수 제한
	}

	// ID 입력받기
	public void idLabel() {
		JLabel id = new JLabel("ID");
		id.setBounds(100, 130, 80, 15);
		joinPanel.add(id);
		idField = new JTextField();
		idField.setBounds(200, 130, 115, 20);
		joinPanel.add(idField);
		idField.setColumns(10); // 글자수 제한
	}

	// PW 입력받기
	public void pwLabel() {
		JLabel pw = new JLabel("PW");
		pw.setBounds(100, 180, 80, 15);
		joinPanel.add(pw);
		passwordField = new JPasswordField();
		passwordField.setBounds(200, 180, 115, 20);
		joinPanel.add(passwordField);
		passwordField.setColumns(10); // 글자수 제한
	}

	// PW 확인
	public void pwCheckLabel() {
		JLabel pwCheck = new JLabel("PW확인");
		pwCheck.setBounds(100, 230, 80, 15);
		joinPanel.add(pwCheck);
		passwordCkField = new JPasswordField();
		passwordCkField.setBounds(200, 230, 115, 20);
		joinPanel.add(passwordCkField);
		passwordCkField.setColumns(10); // 글자수 제한
	}

	// 등록 버튼
	public void enrollButtonEvent() {
		enrollButton = new JButton("등록");
		enrollButton.addActionListener(new ActionListener() {
			// DB에 저장
			public void actionPerformed(ActionEvent e) {
				sendToEnroll();
			}
		});
		enrollButton.setBounds(130, 300, 97, 23);
		joinPanel.add(enrollButton);

	}

	public void sendToEnroll() {
		setVisible(false); // JoinGui 창 끄기
		textField = new JTextField();

		String name = nameField.getText();
		String empno = empnoField.getText();
		String id = idField.getText();

		char[] password = passwordField.getPassword();
		String pw = new String(password);
		char[] passwordCk = passwordCkField.getPassword();

		if (password.length == 0 || passwordCk.length == 0) {
			System.out.println("PW가 입력되지않음");
		}

		else if (isEqual(password, passwordCk)) {
			// DB 등록 영역
			DbConnect db = new DbConnect();
			try {
				String sql = "insert into user values(?,?,?,?,?)";

				db.pstmt = db.conn.prepareStatement(sql);

				db.pstmt.setString(1, name);
				db.pstmt.setString(2, empno);
				db.pstmt.setString(3, id);
				db.pstmt.setString(4, pw);
				db.pstmt.setInt(5, 0);
				db.pstmt.executeUpdate();

				JOptionPane.showMessageDialog(null, "회원가입 완료");
				new EnterGui();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {
			JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
			nameField.setText(name);
			empnoField.setText(empno);
			idField.setText(id);
			passwordField.setText("");
			passwordCkField.setText("");
			new JoinGui();
		}
	}

	// PW 일치여부 확인
	private boolean isEqual(char[] password1, char[] password2) {
		if (password1.length != password2.length) {
			return false;
		}
		for (int i = 0; i < password1.length; i++) {
			if (password1[i] != password2[i]) {
				return false;
			}
		}
		return true;
	}

	// 홈으로 돌아가기 버튼
	public void homeButtonEvent() {
		homeButton = new JButton("홈으로");
		homeButton.addActionListener(new ActionListener() {
			// EnterGui 호출
			public void actionPerformed(ActionEvent e) {
				sendToHome();
			}
		});
		homeButton.setBounds(250, 300, 97, 23);
		joinPanel.add(homeButton);

	}

	public void sendToHome() {
		setVisible(false); // JoinGui 창 끄기
		new EnterGui(); // 다시 홈화면으로
	}

}
