package Manager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Client.DbConnect;
import Client.EnterGui;
import Client.Fortune;
import Client.Menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.net.Socket;

public class MgrHome extends JFrame {

	private JPanel mgrHomePanel; // 전체틀 생성
	private JButton noticeButton;
	private JButton chatLogButton; 
	private JButton empButton;
	private JButton connectedMemButton;
	private JButton memberDelButton;
	private JButton homeButton; 

	private JTextField textField; // 텍스트 필드

	public MgrHome() {
		
		new DbConnect();
		mgrHomeGui();
		noticeButtonEvent();
		chatLogButtonEvent();
		empButtonEvent();
		connectedMemButtonEvent();
		memberDelButtonEvent();
		
		
		homeButtonEvent();
		setVisible(true); // Gui 켜기
	}

	// 홈화면 구성
	public void mgrHomeGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		mgrHomePanel = new JPanel();
		mgrHomePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mgrHomePanel);
		mgrHomePanel.setBackground(new Color(255, 255, 255));
		mgrHomePanel.setLayout(null);
	}

	// 공지사항등록
	public void noticeButtonEvent() {
		noticeButton = new JButton("공지사항등록");
		noticeButton.addActionListener(new ActionListener() {
			// EnterGui 호출
			public void actionPerformed(ActionEvent e) {
				sendToNotice();
			}
		});
		noticeButton.setBounds(180, 50, 130, 40);
		mgrHomePanel.add(noticeButton);

	}

	public void sendToNotice() {
		setVisible(false); // EnterGui 창 끄기
		new Notice(); // ChatGui에 ID name 값 전달
	}

	// 채팅조회
	public void chatLogButtonEvent() {
		chatLogButton = new JButton("채팅조회");
		chatLogButton.addActionListener(new ActionListener() {
			// EnterGui 호출
			public void actionPerformed(ActionEvent e) {
				sendToChatLog();
			}
		});
		chatLogButton.setBounds(180, 130, 130, 40);
		mgrHomePanel.add(chatLogButton);

	}

	public void sendToChatLog() {
		setVisible(false); // EnterGui 창 끄기
		new ChatLog(); // ChatGui에 ID name 값 전달
	}

	// 직원정보조회 (select * from emp 로 전부 보여주기)
	public void empButtonEvent() {
		empButton = new JButton("가입자정보조회");
		empButton.addActionListener(new ActionListener() {
			// EnterGui 호출
			public void actionPerformed(ActionEvent e) {
				sendToEmp();
			}
		});
		empButton.setBounds(180, 210, 130, 40);
		mgrHomePanel.add(empButton);

	}

	public void sendToEmp() {
		setVisible(false); // EnterGui 창 끄기
		new EmpInfo(); // ChatGui에 ID name 값 전달
	}
	
	// 로그인정보 보기 - 현재 접속중인 사용자 정보 조회하는 기능
	public void connectedMemButtonEvent() {
		connectedMemButton = new JButton("접속자정보조회");
		connectedMemButton.addActionListener(new ActionListener() {
			// EnterGui 호출
			public void actionPerformed(ActionEvent e) {
				sendToSeeMem();
			}
		});
		connectedMemButton.setBounds(180, 290, 130, 40);
		mgrHomePanel.add(connectedMemButton);

	}

	public void sendToSeeMem() {
		setVisible(false); // EnterGui 창 끄기
		new ConnectedMem(); // ChatGui에 ID name 값 전달
	}
	
	
	// 회원 삭제
	public void memberDelButtonEvent() {
		memberDelButton = new JButton("회원삭제");
		memberDelButton.addActionListener(new ActionListener() {
			// EnterGui 호출
			public void actionPerformed(ActionEvent e) {
				sendToMemDel();
			}
		});
		memberDelButton.setBounds(180, 370, 130, 40);
		mgrHomePanel.add(memberDelButton);

	}

	public void sendToMemDel() {
		setVisible(false); // EnterGui 창 끄기
		new DeleteMember(); // ChatGui에 ID name 값 전달
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
		homeButton.setBounds(350, 430, 97, 23);
		mgrHomePanel.add(homeButton);

	}

	public void sendToHome() {
		setVisible(false); // JoinGui 창 끄기
		new EnterGui(); // 다시 홈화면으로
	}

}
