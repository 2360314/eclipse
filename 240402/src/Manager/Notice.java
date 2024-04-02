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

public class Notice extends JFrame {
	
    private JPanel noticePanel;
    private JTextField textMsg;
    private TextArea chatLog;
    private BufferedReader reader;
    public PrintWriter writer;

	// constructor
	public Notice() {
		NoticeGui();
		
	}
	
	// 전체 Panel 만들기
	public void NoticeGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		noticePanel = new JPanel();
		noticePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(noticePanel);
		noticePanel.setBackground(new Color(255, 255, 255));
		noticePanel.setLayout(null);
	}
}
