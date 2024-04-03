package Client;

import javax.swing.*;
import java.awt.Color;
import Manager.MgrHome;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;

public class EnterGui extends JFrame {
	private JPanel enterPane; // 전체틀 생성
	private JTextField idField; // ID 읽어오는 텍스트 필드
	private JPasswordField passwordField;
	private JButton enterButton; // 로그인 버튼
	private JButton joinButton; // 회원가입 버튼
	private JButton mgrButton; // 회원가입 버튼
	private String name; // ID
	private String enteredID;
	private String enteredPW;
	

	public EnterGui() {
		new DbConnect();
		enterPanel(); // 전체틀 생성
		idLabel(); // ID 입력 라벨, 텍스트 필드 생성
		pwLabel(); // pw 입력 라벨, 텍스트 필드 생성
		enterButtonEvent(); // 로그인 버튼 생성 및 처리
		joinButtonEvent(); // 회원가입 버튼 표출

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

	// 로그인 버튼
	public void enterButtonEvent() {
		enterButton = new JButton("로그인");
		enterButton.addActionListener(new ActionListener() {
			// 로그인 버튼 클릭시 이벤트 처리 - if-else (id-pw 일치여부 확인)
			public void actionPerformed(ActionEvent e) {

				// 입력한 ID/PW String으로 가져오기
				enteredID = idField.getText();
				char[] password = passwordField.getPassword();
				enteredPW = new String(password);
				
				
				// DB에서 사용자 정보 조회하여 일치하는지 확인
				try {
					boolean isUserValid = checkUserValidity(enteredID, enteredPW);
					if (isUserValid) {
	                    sendToClientHome(); // 사용자가 유효한 경우에만 다음 화면으로 이동
	                } else {
	                    JOptionPane.showMessageDialog(null, "ID 또는 PW가 잘못되었습니다."); // 사용자가 유효하지 않은 경우에는 메시지 표시
	                }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "DB 조회 중 오류가 발생했습니다.");
				}
			}

			// 사용자 정보 일치 여부 확인 메소드
			private boolean checkUserValidity(String enteredID, String enteredPW) throws SQLException {
				try {
					DbConnect db = new DbConnect();
					String sql = "select * from user where id = ? and pw = ?";
					db.pstmt = db.conn.prepareStatement(sql);

					db.pstmt.setString(1, enteredID);
					db.pstmt.setString(2, enteredPW);

					ResultSet rs = db.pstmt.executeQuery();
					if (rs.next()) {
						return true;
					} else {
						return false;
					}
				} catch (SQLException e) {
					// 예외 처리
					e.printStackTrace();
					return false; // 예외 발생 시 일치하지 않는 것으로 처리
				}
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
	
	// 채팅방 입장 시 ID 보내주는 메소드
	public String getEnteredID() {
        return enteredID;
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