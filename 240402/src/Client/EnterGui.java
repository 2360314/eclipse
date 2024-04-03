package Client;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Manager.MgrHome;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EnterGui extends JFrame {
    private JPanel enterPane; // 전체틀 생성
    private JTextField idField; // ID 읽어오는 텍스트 필드
    private JPasswordField passwordField;
    private JButton enterButton; // 로그인 버튼
    private JButton joinButton;  // 회원가입 버튼
    private JButton mgrButton;  // 회원가입 버튼
    private String name; // ID

    public EnterGui() {
    	new DbConnect();
        enterPanel(); // 전체틀 생성
        idLabel(); // ID 입력 라벨, 텍스트 필드 생성
        pwLabel(); // pw 입력 라벨, 텍스트 필드 생성
        enterButtonEvent(); // 로그인 버튼 생성 및 처리
        joinButtonEvent();	// 회원가입 버튼 표출
        
        mgrButtonEvent();
        
        setVisible(true); // Gui 켜기
    }

    public void enterPanel() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 종료시 프로세스 종료시키는 코드
        setBounds(100, 100, 450, 300); // 패널 사이즈 코드
        enterPane = new JPanel();
        enterPane.setBackground(new Color(255, 255, 255));
        setContentPane(enterPane);
        enterPane.setLayout(null);
    }

    public void idLabel() {
        JLabel id = new JLabel("ID 입력");
        id.setBounds(100, 30, 80, 15);
        enterPane.add(id);

        idField = new JTextField();
        idField.setBounds(200, 30, 115, 20);
        enterPane.add(idField);
        idField.setColumns(10); // 글자수 제한
    }
    public void pwLabel() {
        JLabel id = new JLabel("PW 입력");
        id.setBounds(100, 80, 80, 15);
        enterPane.add(id);

        passwordField = new JPasswordField();
        passwordField.setBounds(200, 80, 115, 20);
        enterPane.add(passwordField);
        passwordField.setColumns(10); // 글자수 제한
    }

    // 입력한 ID/PW String으로 가져오기
    String id = idField.getText();
    char[] password = passwordField.getPassword();
    String pw = new String(password);
    
    
	// 로그인 버튼
	public void enterButtonEvent() {
		enterButton = new JButton("로그인");
		enterButton.addActionListener(new ActionListener() {
		// 로그인 버튼 클릭시 이벤트 처리 - if-else (id-pw 일치여부 확인)

			public void actionPerformed(ActionEvent e) {
				sendToClientHome();
			}
		});
		enterButton.setBounds(100, 134, 97, 23);
		enterPane.add(enterButton);
	}
        
    // ClientHome으로 보내기
    public void sendToClientHome() {
    	setVisible(false); // EnterGui 창 끄기
        new ClientHome();
    }
        

     
    // 회원가입 버튼
    public void joinButtonEvent() {
    	joinButton = new JButton("회원가입");
    	joinButton.addActionListener(new ActionListener() {
            // 회원가입 버튼 클릭 시 회원가입 창 호출
            public void actionPerformed(ActionEvent e) {
                sendToJoinGui();
            }
        });
    	joinButton.setBounds(200, 134, 97, 23);
        enterPane.add(joinButton);

    }

    public void sendToJoinGui() {
        setVisible(false); // EnterGui 창 끄기
        new JoinGui(); 
        }
    
    
    //// 임시 - mgr 화면 이동 확인 ////
    
 // MGR 메인으로 이동
    public void mgrButtonEvent() {
        mgrButton = new JButton("MGR(임시)");
        mgrButton.addActionListener(new ActionListener() {
            // 로그인 버튼 클릭시 이벤트 처리
            public void actionPerformed(ActionEvent e) {
            	sendToMgrHome();
            }
        });
        mgrButton.setBounds(300, 134, 97, 23);
        enterPane.add(mgrButton);
    }
        
    // mgrHome으로 보내기
    public void sendToMgrHome() {
    	setVisible(false); // EnterGui 창 끄기
        new MgrHome();
    }

}