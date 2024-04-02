package d240329;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class DbExam01 {
	Connection conn;
	PreparedStatement pstmt;

	public DbExam01() {
		this("jdbc:mysql://localhost:3306/mydb?severTimezone=UTC", "root", "qwe123!@#");
	}

	public DbExam01(String url, String user, String pw) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException {
		DbExam01 exam = new DbExam01();
		
		
//		exam.createDb();
//		exam.dbInput();
//		exam.dbInput2();
		
//		String[] str = {"AAA", "BBB", "CCC"};
//		exam.dbInput3(str);
		
//		exam.dbInput4();
		
//		exam.update("DDD");
		
//		exam.delete("DDD");
		exam.result();
		System.out.println("success");
	}

	private void createDb() {
		try {
			String s = "drop table if exists student3;";
			String sql = "create table student3(\r\n" + "id int,\r\n" + "username varchar(20),\r\n"
					+ "primary key(id)\r\n" + ")\r\n";
			pstmt = conn.prepareStatement(s);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void dbInput() {
		try {
			String sql = "insert into student3 values(7, 'superman')";
			// 여기에 values(?,?) 하면 나중에 입력하겠다는 뜻임.
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void dbInput2() {
		try {
			String sql = "insert into student3 values(?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, 8);				// 1번 컬럼에 8이라는 값을 넣음
			pstmt.setString(2, "superman");	// 2번 컬럼에 superman 이라는 값을 넣음
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void dbInput3(String str[]) {
		try {
			String sql = "insert into student3 values(?,?)";
			pstmt = conn.prepareStatement(sql);
			
			for(int i=0; i<3; i++) {
				pstmt.setInt(1, i);
				pstmt.setString(2, str[i]);
				pstmt.executeUpdate();
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void dbInput4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ID입력");
		int id = sc.nextInt();
		System.out.println("이름입력");
		String name = sc.next();
		
		try {		
			String sql = "insert into student3 values(?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.executeUpdate();
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void result() throws SQLException{
		String sql = "select * from student3";
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			
			int deptNo = rs.getInt(1);
			String deptName = rs.getString(2);
			
			System.out.println(deptNo+" "+deptName);
		}
	}
	
	public void update(String str) throws SQLException{
		String sql = "update student3 set username=? where id = 1";
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, str);
		pstmt.executeUpdate();
		
	}
	
	public void delete(String str) throws SQLException{
		String sql = "delete from student3  where username=?";
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, str);
		pstmt.executeUpdate();
		
	}
	
}
