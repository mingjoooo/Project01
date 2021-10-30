package project2.ver05;

import java.util.Scanner;

public class accountOpenSql extends IConnectImpl{
	
	
	public accountOpenSql() {
		super(ORACLE_DRIVER, "kosmo", "1234");
	}
	@Override
	public void execute() {
		try {
			String query = "INSERT INTO banking_tb VALUES (?,  ?,  ?) ";
			
			psmt = con.prepareStatement(query);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("계좌번호: ");
			String accountID = sc.nextLine();
			System.out.println("고객이름: ");
			String customName = sc.nextLine();
			System.out.println("잔고: ");
			int accMoney = sc.nextInt();
			
			psmt.setString(1, accountID);
			psmt.setString(2, customName);
			psmt.setInt(3, accMoney);
			
			int affected = psmt.executeUpdate();
			System.out.println(affected +"행이 추가 되었습니다.");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
}
