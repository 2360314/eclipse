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
import java.sql.ResultSet;
import java.sql.SQLException;

public class Fortune extends JFrame {

	private JPanel fortuneHomePanel; // 전체틀 생성
	private JButton rollButton; // 채팅방입장 버튼
	private JButton clientHomeButton; // 점메추 버튼
	private JButton homeButton; // 로그아웃버튼

	public Fortune() {
		new DbConnect();
		fortuneHomeGui();
		fortuneResult();

		clientHomeButtonEvent();
		homeButtonEvent();
		setVisible(true); // Gui 켜기
	}

	// 홈화면 구성
	public void fortuneHomeGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		fortuneHomePanel = new JPanel();
		fortuneHomePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(fortuneHomePanel);
		fortuneHomePanel.setBackground(new Color(255, 255, 255));
		fortuneHomePanel.setLayout(null);
	}

	// 포춘쿠키 구현 영역
		public void fortuneResult() {

		JLabel fortune = new JLabel("Fortune Cookie");
		
		try {
			result();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		fortune.setHorizontalAlignment(JLabel.CENTER);
		fortune.setBounds(150, 70, 200, 50);
		fortuneHomePanel.add(fortune);

		rollButton = new JButton("다시하기");
		rollButton.addActionListener(new ActionListener() {
			// EnterGui 호출
			public void actionPerformed(ActionEvent e) {
				new Fortune();
			}
		});
		rollButton.setBounds(200, 200, 130, 40);
		fortuneHomePanel.add(rollButton);

	}

	public void result() throws SQLException {

		DbConnect db = new DbConnect();
		String sql = "select * from fortune where index2 = ?";
		db.pstmt = db.conn.prepareStatement(sql);

		int randomValue = (int) (Math.random() * 7) + 1;	// 7개까지 insert돼있음

		db.pstmt.setInt(1, randomValue);
		
		ResultSet rs = db.pstmt.executeQuery();

		while (rs.next()) {
			String fortuneTxt = rs.getString("cookie");
			JLabel fortuneText = new JLabel(fortuneTxt);
			fortuneText.setBounds(200, 100, 200, 50);
			fortuneHomePanel.add(fortuneText);
		}
	}

	// Client 홈으로 돌아가기 버튼
	public void clientHomeButtonEvent() {
		clientHomeButton = new JButton("뒤로");
		clientHomeButton.addActionListener(new ActionListener() {
			// EnterGui 호출
			public void actionPerformed(ActionEvent e) {
				sendToClientHome();
			}
		});
		clientHomeButton.setBounds(130, 300, 97, 23);
		fortuneHomePanel.add(clientHomeButton);

	}

	public void sendToClientHome() {
		setVisible(false); // 창 끄기
		new ClientHome(); // clientHome화면으로
	}

	// 홈으로 돌아가기 버튼
	public void homeButtonEvent() {
		homeButton = new JButton("로그아웃");
		homeButton.addActionListener(new ActionListener() {
			// EnterGui 호출
			public void actionPerformed(ActionEvent e) {
				sendToHome();
			}
		});
		homeButton.setBounds(300, 300, 97, 23);
		fortuneHomePanel.add(homeButton);

	}

	public void sendToHome() {
		setVisible(false); // 창 끄기
		new EnterGui(); // 다시 홈화면으로
	}
}
