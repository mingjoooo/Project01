package project2.ver05;

import java.sql.SQLException;

public class withDrawSql extends IConnectImpl{
	
	public withDrawSql() {
		super("kosmo","1234");
	}
	@Override
	public void execute() {
		String sql = " UPDATE banking_tb "
				+ " SET accMoney=accMoney - ? "
				+ " WHERE accountID=? ";
		try {
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, scanValue(" 출금할 금액 "));
			psmt.setString(2, scanValue(" 계좌번호를 입력하세요 :"));
			
			int affected = psmt.executeUpdate();
			System.out.println(affected+"행이 업데이트 되었습니다.");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	public static void main(String[] args) {
		new withDrawSql().execute();
	}
}
