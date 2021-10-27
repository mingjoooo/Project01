package project2.ver02;

import java.util.Scanner;

public class AccountManager{
	
	Scanner scanner = new Scanner(System.in);
	Account[] accountArray;
	String grade = null;
	int cnt;
	int accMoney;
	int rate;

    public AccountManager() {
    	accountArray = new Account[50];
    	cnt = 0;
	}
	
	public void makeAccount() {
		
		String accountID = null;
        String customName = null;
        int accMoney = 0;
        
        System.out.println("***신규계좌개설***");
        
        System.out.println("------계좌선택------");
        System.out.println("1.보통계좌");
        System.out.println("2.신용신뢰계좌");
        
        int inputNum = scanner.nextInt();
        if(inputNum==1) {
        	System.out.println("선택:" +inputNum);
        	scanner.nextLine();
        	
        	System.out.print("계좌번호: ");
            accountID = scanner.nextLine();
            
            System.out.print("고객이름 : ");
            customName = scanner.nextLine();
            
            System.out.print("잔고 : ");
            accMoney = scanner.nextInt();
           
            System.out.print("기본이자%(정수형태로입력): ");
        	rate = scanner.nextInt();
        	
        	accountArray[cnt++] = new NormalAccount(accountID, customName, accMoney, rate);
        	
        	System.out.println("계좌계설이 완료되었습니다.");
        }
        else if(inputNum==2) {
        	System.out.println("선택:" +inputNum);
        	scanner.nextLine();
        	
        	System.out.print("계좌번호: ");
            accountID = scanner.nextLine();
            
            System.out.print("고객이름 : ");
            customName = scanner.nextLine();
            
            System.out.print("잔고 : ");
            accMoney = scanner.nextInt();
           
            System.out.print("기본이자%(정수형태로입력): ");
        	rate = scanner.nextInt();
        	scanner.nextLine();
        	
        	System.out.print("신용등급(A,B,C등급): ");
        	grade = scanner.nextLine();
        	
        	accountArray[cnt++] = 
        			new HighCreditAccount(accountID, customName, accMoney, 
        					rate, grade);
        	
        	System.out.println("계좌계설이 완료되었습니다.");
        }
        else {
        	System.out.println("1~2사이의 숫자만 입력하세요.");
        	return;
        }
    }

	public void depositMoney() {
		System.out.println("***입   금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		
        System.out.print("계좌번호: ");
        String accountID = scanner.nextLine();
        
        for(int i=0; i<cnt; i++) {
        	scanner.nextLine();
            if(accountID.equals(accountArray[i].getAccountID())) {
            	System.out.print("입금액: ");
            	int accMoney = scanner.nextInt();
                if(accMoney<=0) {
                	System.out.println("뭐...뭐였더라..?");
                }else {
                	accountArray[i].accMoney += accMoney;
                	System.out.println("입금이 완료되었습니다.");
                }
            }
            else 
            	System.out.println("입력하신 계좌번호가 존재하지 않습니다.");
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
                if(accountArray[i].accMoney<=0) {
                	System.out.println("출금액보다 잔고가 부족합니다.");
                }else {
                	accountArray[i].accMoney -= accMoney;
                	System.out.println("출금이 완료되었습니다.");
                }
            }
            else System.out.println("입력하신 계좌번호가 존재하지 않습니다.");
        }
	}
	public void showAccInfo() {
		System.out.println("***계좌정보출력***");
		System.out.println("------------------");
		for (int i = 0; i < cnt; i++) {
			accountArray[i].showAccountInfo();
			System.out.println();
		}
		if (cnt == 0) {
			System.out.println("출력할 계좌정보가 없습니다.");
		}
		System.out.println("------------------");
		System.out.println("전체계좌정보 출력이 완료되었습니다.");
	}
}
	