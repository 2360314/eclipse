package Client;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class Menu extends JFrame{
	
	private JPanel menuHomePanel;	// 전체틀 생성
	private JButton rollButton;  		// 돌리기
	private JButton clientHomeButton; 	// 점메추 버튼
	private JButton homeButton; 		// 로그아웃버튼
	
	public Menu() {
		new DbConnect();
		menuHomeGui();
		menuResult();
		
		clientHomeButtonEvent();
		homeButtonEvent();
		setVisible(true); // Gui 켜기
	}
	
	
	// 홈화면 구성
	public void menuHomeGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		menuHomePanel = new JPanel();
		menuHomePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(menuHomePanel);
		menuHomePanel.setBackground(new Color(255, 255, 255));
		menuHomePanel.setLayout(null);
	}
	
	// 점심메뉴 구현 영역
	public void menuResult() {
		
		JLabel menu = new JLabel("여기에 DB에서 읽어와서 뿌릴 것");
		menu.setHorizontalAlignment(JLabel.CENTER);
		menu.setBounds(150, 70, 200, 50);
		menuHomePanel.add(menu);
		
		
		rollButton = new JButton("다른메뉴");
		rollButton.addActionListener(new ActionListener() {
			// EnterGui 호출
			public void actionPerformed(ActionEvent e) {
				sendToClientHome();	// 다른메뉴로 바꾸는 함수 구현필요
			}
		});
		rollButton.setBounds(200, 200, 130, 40);
		menuHomePanel.add(rollButton);
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
		menuHomePanel.add(clientHomeButton);

	}
	
	public void sendToClientHome() {
		setVisible(false); // 창 끄기
		new ClientHome();  // clientHome화면으로
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
		menuHomePanel.add(homeButton);

	}
	
	public void sendToHome() {
		setVisible(false); // JoinGui 창 끄기
		new EnterGui(); // 다시 홈화면으로
	}
}