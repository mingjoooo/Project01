package project2.ver05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class ConnectDB {
	
	protected Connection con;
	protected Statement stmt;
	protected ResultSet rs;
	
	public ConnectDB(){
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "kosmo", "1234");
			System.out.println("Oracle 연결성공");
		}
		catch(ClassNotFoundException e) {
			System.out.println("오라클 드라이버 로딩 실패");
			e.printStackTrace();
		}
		catch(SQLException e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		}
		catch(Exception e) {
			System.out.println("알수 없는 예외발생");
		}
	}
	public ConnectDB(String id, String pw) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", id, pw);
			System.out.println("Oracle 연결성공");
		}
		catch(ClassNotFoundException e) {
			System.out.println("오라클 드라이버 로딩 실패");
			e.printStackTrace();
		}
		catch(SQLException e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		}
		catch(Exception e) {
			System.out.println("알수 없는 예외발생");
		}
	}
	
	public void close() {
		try {
			if(con!=null) con.close();
			if(stmt!=null) stmt.close();
			if(rs!=null) rs.close();
			System.out.println("DB자원반납완료");
		}
		catch(SQLException e) {
			System.out.println("자원반납시 오류가 발생하였습니다.\"");
		}
	}
	abstract void execute();
}
