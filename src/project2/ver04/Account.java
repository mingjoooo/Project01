package project2.ver04;

import java.io.Serializable;
import java.util.Objects;

abstract class Account implements Serializable
{
	String accountID;
	String customName;	//고객이름
	int accMoney;		//잔고
	
	//생성자
	public Account(String accountID, String customName, int accMoney)
	{
		this.accountID = accountID;
		this.customName = customName;
		this.accMoney = accMoney;
	}
	
	@Override
	public int hashCode() {
		return accountID.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		Account other = (Account)obj;
		if(other.accountID.equals(this.accountID)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//계좌정보출력
	public void showAccountInfo() {
		System.out.println("계좌번호>"+ accountID);
		System.out.println("고객이름>"+ customName);
		System.out.println("잔고>"+ accMoney);
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getCustomName() {
		return customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public int getAccMoney() {
		return accMoney;
	}

	public void setAccMoney(int accMoney) {
		this.accMoney = accMoney;
		
	}
	
	@Override
	public String toString() {
		return "계좌번호>" + accountID + "\n고객이름>" + customName
				+ "\n잔고>" + accMoney + "\n";
	}
}