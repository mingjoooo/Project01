package project2.ver02;

public class NormalAccount extends Account{
	
	public int rate;
	
//	public NormalAccount(String accountID, String customName, int accMoney) {
//		super(accountID,customName,accMoney);
//	}
	public NormalAccount(String accountID, String customName, int accMoney, int rate) {
		super(accountID,customName,accMoney);
		this.rate=rate;
	}
	@Override
	public void showAccountInfo() {
		super.showAccountInfo();
		System.out.println("기본이자>"+rate+"%");
	}
	public void deposit(int deposit) {
		accMoney = (int) (accMoney + (accMoney*rate/100) + deposit);
	}
}
