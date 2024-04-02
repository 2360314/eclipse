package Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DbConnect {
	Connection conn;
	PreparedStatement pstmt;

	public DbConnect() {
		this("jdbc:mysql://localhost:3306/mydb?severTimezone=UTC", "root", "qwe123!@#");
	}

	public DbConnect(String url, String user, String pw) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

