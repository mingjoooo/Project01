package project2.ver03;

public class HighCreditAccount extends Account{
	
	public int rate;
	public String grade;
	public HighCreditAccount(String accountID, String customName, int accMoney, int rate, String grade) {
		super(accountID, customName, accMoney);
		this.rate=rate;
		this.grade=grade;
	}
	
	public void deposit(int deposit) {
		if(grade.equals("A"))
			accMoney = accMoney + (accMoney*(rate+CustomSpecialRate.PRIDE_A)/100)+ deposit;
		else if(grade.equals("B"))
			accMoney = accMoney + (accMoney*(rate+CustomSpecialRate.PRIDE_B)/100)+ deposit;
		else if(grade.equals("C"))
			accMoney = accMoney + (accMoney*(rate+CustomSpecialRate.PRIDE_C)/100)+ deposit;
	}
	
	@Override
	public void showAccountInfo() {
		super.showAccountInfo();
		System.out.println("기본이자>" + rate+"%");
		System.out.println("신용등급>" + grade);
	}
}
