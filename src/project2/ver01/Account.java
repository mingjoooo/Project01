package project2.ver01;

import java.util.Scanner;

public class Account
{
	private String accountID;	//계좌번호
	private String customName;	//고객이름
	private int accMoney;	//잔고
	
	//생성자
	public Account(String accountID, String customName, int accMoney)
	{
		this.accountID = accountID;
		this.customName = customName;
		this.accMoney = accMoney;
	}
	
	//계좌정보출력
	public void showAccountInfo() {
		System.out.println("계좌번호:"+ accountID);
		System.out.println("예금주:"+ customName);
		System.out.println("잔고:"+ accMoney);
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
	
	public void deposit(int deposit) {}
	
	public int cnt =0;
	
	Account[] accountArray = new Account[50];
    Scanner scanner = new Scanner(System.in);
	
	public void makeAccount() {
		String accountID = null;
        String customName = null;
        int accMoney = 0;
        accountArray[cnt] = new Account(accountID, customName, accMoney);
        System.out.println("***신규계좌개설***");
        System.out.print("계좌번호 : ");
        accountID = scanner.nextLine();
        accountArray[cnt].setAccountID(accountID); 
        System.out.print("고객이름 : ");
        customName = scanner.nextLine();
        accountArray[cnt].setCustomName(customName);
        System.out.print("잔고 : ");
        accMoney = scanner.nextInt();
        accountArray[cnt].setAccMoney(accMoney);
        System.out.println("계좌계설이 완료되었습니다.");
 
        cnt++;
    }
	public void depositMoney() {
		System.out.println("***입   금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		
        System.out.print("계좌번호: ");
        String accountID = scanner.nextLine();
        System.out.print("입금액: ");
        int accMoney = scanner.nextInt();
        
        for(int i=0; i<cnt; i++) {
            if(accountID.equals(accountArray[i].getAccountID())) {
                accountArray[i].setAccMoney(accMoney);
                System.out.println("입금이 완료되었습니다.");
            }
            else System.out.println("입력하신 계좌번호가 존재하지 않습니다.");
        }
    }
	public void withdrawMoney() {
        System.out.println("***출   금***");
        System.out.println("계좌번호와 출금할 금액을 입력하세요");
        
        System.out.print("계좌번호: ");
        String accountID = scanner.nextLine();
        System.out.print("출금액: ");
        int accMoney = scanner.nextInt();
        
        for(int i=0; i<cnt; i++) {
            if(accountID.equals(accountArray[i].getAccountID())) {
                accountArray[i].setAccMoney(accMoney);
                System.out.println("출금이 완료되었습니다.");
            }
            else System.out.println("입력하신 계좌번호가 존재하지 않습니다.");
        }
	}
	public void showAccInfo() {
		System.out.println("***계좌정보출력***");
		System.out.println("------------------");
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] == null) {
				break;
			}
			System.out.println("계좌번호 :"+accountArray[i].getAccountID());
			System.out.println("고객이름 :"+accountArray[i].getCustomName()); 
			System.out.println("잔고 :"+accountArray[i].getAccMoney());
		}
		System.out.println("------------------");
		System.out.println("전체계좌정보 출력이 완료되었습니다.");
		
	}
	
}
