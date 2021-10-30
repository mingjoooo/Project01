package project2.ver05;

import java.sql.SQLException;

public class showInfoAccSql extends ConnectDB{
	
	public showInfoAccSql() {
		super();
	}
	@Override
	public void execute() {
		try {
			stmt = con.createStatement();
			
			String query = " SELECT accountID, customName, accMoney "
					+ " FROM banking_tb ";
			
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				String accountID = rs.getString(1);
				String customName = rs.getString(2);
				String accMoney = rs.getString(3);
			
				System.out.printf("%s %s %s \n", 
					accountID, customName, accMoney);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
		
	}
	
	public static void main(String[] args) {
		showInfoAccSql showinfoacc = new showInfoAccSql();
		showinfoacc.execute();
	}
}
