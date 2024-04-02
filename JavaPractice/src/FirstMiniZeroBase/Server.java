package FirstMiniZeroBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Server {
	Connection conn;
	PreparedStatement pstmt;

	// constructor_1
	public Server() {
		this("jdbc:mysql://localhost:3306/mydb?severTimezone=UTC", "root", "qwe123!@#");
	}

	// constructor_2
	public Server(String url, String user, String pw) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Main
	public static void main(String[] args) {
		Server server = new Server();
		server.cDB();
		server.uDB();
		server.cTBL_user();
		server.cTBL_access();
		server.cTBL_chat();
		server.cTBL_loginlog();
		server.cTBL_fortune();
		server.cTBL_menu();
		
		System.out.println("success");

	}

	// 데이터베이스 만들기
	public void cDB() {
		try {
			String sql1 = "CREATE DATABASE mini";
			pstmt = conn.prepareStatement(sql1);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 데이터베이스 만들기
	public void uDB() {
		try {
			String sql2 = "USE mini";
			pstmt = conn.prepareStatement(sql2);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// 테이블 생성 start //
	// 테이블 생성 start //
	// 1. user - 회원정보
	public void cTBL_user() {
		try {
			String sql = "create table user(" 
					+ " name varchar(50) not null\r\n" 
					+ ",id_number int not null\r\n"
					+ ",id varchar(50) not null primary key\r\n" 
					+ ",pw int not null\r\n"
					+ ",manage boolean default false)";
			String sql2 = "insert into user values('관리자',2360314,'admin',1234,true)";

			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement(sql2);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 2. access - 현재접속정보
	public void cTBL_access() {
		try {
			String sql = "create table access(\r\n" 
					+ " date1 date not null\r\n" 
					+ ",id varchar(50)\r\n"
					+ ",primary key(date1,id)\r\n" 
					+ ",foreign key (id) REFERENCES user(id))";
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 3. chat - 채팅데이터
	public void cTBL_chat() {
		try {
			String sql = "create table chat(\r\n" 
					+ "datestamp date not null,\r\n" 
					+ "id varchar(50)not null,\r\n"
					+ "contents varchar(500),\r\n" 
					+ "primary key(id,datestamp),\r\n"
					+ "foreign key (id)REFERENCES user(id))";
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// 4. loginlog - 로그인기록
	public void cTBL_loginlog() {
		try {
			String sql = "create table loginlog(\r\n"
					+ "date2 date not null,\r\n"
					+ "id varchar(50),\r\n"
					+ "foreign key (id) REFERENCES user(id),\r\n"
					+ "primary key(id,date2))";
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 5. fortune = 포춘쿠키
	public void cTBL_fortune() {
		try {
			String sql1 = "CREATE TABLE fortune ("
					+ "index2 int AUTO_INCREMENT PRIMARY KEY, "
					+ "cookie varchar(100))";
			String sql2 = "INSERT INTO fortune value\r\n"
					+ " (null,'행운이찾아옴')\r\n"
					+ ",(NULL, '불행이찾아옴')\r\n"
					+ ",(NULL, '많이좋음')\r\n"
					+ ",(NULL, '조금좋음')\r\n"
					+ ",(NULL, '보통')\r\n"
					+ ",(NULL, '조금안좋음')\r\n"
					+ ",(NULL, '많이안좋음')";
			pstmt = conn.prepareStatement(sql1);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement(sql2);
			pstmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// 6. menu - 점심메뉴추천
	public void cTBL_menu() {
		try {
			String sql1 = "CREATE TABLE menu (\r\n"
					+ "index2 int AUTO_INCREMENT PRIMARY KEY, \r\n"
					+ "menu varchar(100))";
			String sql2 = "INSERT INTO menu value\r\n"
					+ " (null, '무아국수')\r\n"
					+ ",(NULL, '우육면')\r\n"
					+ ",(NULL, '삼성각')\r\n"
					+ ",(NULL, '도마3')\r\n"
					+ ",(NULL, '이태원천상')\r\n"
					+ ",(NULL, '조개칼국수')\r\n"
					+ ",(NULL, '파리바게뜨')";
			pstmt = conn.prepareStatement(sql1);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement(sql2);
			pstmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}




class ServerGui {
    private JFrame serverFrame;
    private TextArea chatTextArea;
    protected TextField chatTextField;
    private JList list;
    private DefaultListModel model;
    public ServerGui(){

        serverFrame = new JFrame();
        serverFrame.setDefaultCloseOperation(serverFrame.EXIT_ON_CLOSE);
        serverFrame.setBounds(100, 100, 825, 475);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        serverFrame.setContentPane(contentPane);
        contentPane.setLayout(null);

        chatTextArea = new TextArea();
        chatTextArea.setEditable(false);
        chatTextArea.setBounds(18,12,567,384);
        chatTextArea.setBackground(Color.WHITE);
        contentPane.add(chatTextArea);

        chatTextField = new TextField();
        chatTextField.setColumns(30);
        chatTextField.setBounds(17, 403, 572, 22);
        contentPane.add(chatTextField);

        Label userListLabel = new Label("CHAT USER ");
        userListLabel.setBounds(667, 16, 100, 16);
        contentPane.add(userListLabel);

        model = new DefaultListModel();

        list = new JList(model);
        list.setBounds(602, 41, 199, 373);
        list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        contentPane.add(list);

        serverFrame.setResizable(false);
        serverFrame.setTitle("채팅프로그램 서버");
        serverFrame.setVisible(true);
    }

    public void setFrameVisible(){
        serverFrame.setVisible(true);
    }

    public void setTextFieldBlank(){
        chatTextField.setText(null);
    }

    public void appendMessage(String message){
        chatTextArea.append(message + "\n");
    }
    public void appendUserList(String user){
        model.addElement(user);
    }
    public void removeUserList(String user){
        model.removeElement(user);
    }
    public String getChatMessage(){ return chatTextField.getText(); }
}

