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
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


public class ClientHome extends JFrame  {
	
	private JLabel mainImg;
	private JPanel clientHomePanel; // 전체틀 생성
	private JButton chatButton;  	// 채팅방입장 버튼
	private JButton fortuneButton;  // 포춘쿠키 버튼
	private JButton menuButton; 	// 점메추 버튼
	private JButton logoutButton; 	// 점메추 버튼
	private String id;
	
	public ClientHome() {
		new DbConnect();
		clientHomeGui();
		chatButtonEvent();
		fortuneButtonEvent();
		menuButtonEvent();
		
		logoutButtonEvent();
		setVisible(true); // Gui 켜기
	}
	
	
	// 홈화면 구성
	public void clientHomeGui() {  	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		clientHomePanel = new JPanel();
		clientHomePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(clientHomePanel);
		clientHomePanel.setBackground(new Color(255, 255, 255));
		clientHomePanel.setLayout(null);
		img();
	}
	
	// 이미지 추가
	public void img() {	
		try {	
			mainImg = new JLabel(new ImageIcon("image/newProfile.jpg"));
	    	clientHomePanel.add(mainImg);

		}
		catch(Exception e) {
			e.printStackTrace();
		}
//		try {	
//	        mainImg = new JLabel(new ImageIcon("image/newProfile.jpg"));
//	        clientHomePanel.add(mainImg);
//	    } catch(IOException e) {
//	        e.printStackTrace();
//	    }
//		
//		File file = new File("C:\\javatest2\\eclipse\\240402\\image\\newProfile.jpg");
//		BufferedImage bufferedImage = ImageIO.read(file);
//		ImageIcon imageIcon = new ImageIcon(bufferedImage);
//		
//		mainImg.setIcon(imageIcon);
//		clientHomePanel.add(mainImg);		
	}

	// 채팅방입장
	public void chatButtonEvent() {
		chatButton = new JButton("채팅방입장");
		chatButton.addActionListener(new ActionListener() {
			// EnterGui 호출
			public void actionPerformed(ActionEvent e) {
				sendToChatGui();
			}
		});
		chatButton.setBounds(300, 50, 130, 40);
		clientHomePanel.add(chatButton);

	}

	public void sendToChatGui() {
		EnterGui eg = new EnterGui();
		
		id = eg.getEnteredID(); 
        setVisible(false); 
        new ChatGui(id);
	}
		
	
	// 포춘쿠키
	public void fortuneButtonEvent() {
		fortuneButton = new JButton("포춘쿠키");
		fortuneButton.addActionListener(new ActionListener() {
			// EnterGui 호출
			public void actionPerformed(ActionEvent e) {
				sendToFortuneGui();
			}
		});
		fortuneButton.setBounds(300, 130, 130, 40);
		clientHomePanel.add(fortuneButton);

	}

	public void sendToFortuneGui() {
		setVisible(false); // EnterGui 창 끄기
        new Fortune(); // ChatGui에 ID name 값 전달
	}
	
	
	// 점메추
	public void menuButtonEvent() {
		menuButton = new JButton("점심메뉴추천");
		menuButton.addActionListener(new ActionListener() {
			// EnterGui 호출
			public void actionPerformed(ActionEvent e) {
				sendToMenuGui();
			}
		});
		menuButton.setBounds(300, 210, 130, 40);
		clientHomePanel.add(menuButton);

	}

	public void sendToMenuGui() {
		setVisible(false); // EnterGui 창 끄기
        new Menu(); // ChatGui에 ID name 값 전달
	}
	
	
	// 홈으로 돌아가기 버튼
	public void logoutButtonEvent() {
		logoutButton = new JButton("로그아웃");
		logoutButton.addActionListener(new ActionListener() {
			// EnterGui 호출
			public void actionPerformed(ActionEvent e) {
				sendToHome();
			}
		});
		logoutButton.setBounds(250, 300, 97, 23);
		clientHomePanel.add(logoutButton);

	}

	public void sendToHome() {
		setVisible(false); // JoinGui 창 끄기
		new EnterGui(); // 다시 홈화면으로
	}

}
