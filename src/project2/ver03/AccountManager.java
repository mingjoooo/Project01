package project2.ver03;

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
		
		scanner.nextLine();
		boolean isFind = false;
		System.out.println("***입   금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		
        System.out.print("계좌번호: ");
        String accountID = scanner.nextLine();
        
        try {
	    	for(int j=0; j<cnt; j++) {
	            if(accountID.equals(accountArray[j].getAccountID())) {
	            	isFind=true;
	            	System.out.print("입금액: ");
	            	int accMoney = scanner.nextInt();
	                if(accMoney%500!=0) {
	                 	System.out.println("500원 단위로만 입금이 가능합니다.");
	                 	
	                 	MenuSelectException mse = new MenuSelectException();
	                 	throw mse;
	                }
	                else{
	                	accountArray[j].accMoney += accMoney;
	                	System.out.println("입금이 완료되었습니다.");
	                }
	            }
	        }
	    	scanner.nextLine();
	    	if(isFind==false)
	    		System.out.println("입력하신 계좌번호가 존재하지 않습니다.");
        }
        catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }
	
	public void withdrawMoney() {
		
		scanner.nextLine();
		boolean isFind = false;
		System.out.println("***출   금***");
        System.out.println("계좌번호와 출금할 금액을 입력하세요");
        
        System.out.print("계좌번호: ");
        String accountID = scanner.nextLine();
       try {
		    for(int i=0; i<cnt; i++) {
		        if(accountID.equals(accountArray[i].getAccountID())) {
		        	isFind = true;
		        	System.out.print("출금액: ");
		        	int accMoney = scanner.nextInt();
		        	
		        	
		        	if(accMoney%1000!=0) {
		        		System.out.println("출금은 1000원 단위로만 출금이 가능합니다.");
		        		return;
		        	}
		        	else {
		        		accountArray[i].accMoney -= accMoney;
		        		System.out.println("출금이 완료되었습니다.");
		        	}
		        	
		        	
		            if(accountArray[i].accMoney<0) {
		            	System.out.println("출금액보다 잔고가 부족합니다.");
		            	
		            	MenuSelectException mse = new MenuSelectException();
		             	throw mse;		            	
		            }
		            else if(accountArray[i].accMoney<accMoney){
		            	scanner.nextLine();
		            	System.out.println("■ 잔고가 부족합니다. 금액전체를 출금할까요?");
		            	System.out.println("YES : 금액전체 출금처리");
		            	System.out.println("NO : 출금요청취소");
		            	String menu =  scanner.nextLine();
		            	if(menu.equalsIgnoreCase("YES")) {
		            		accMoney = 0;
		            		System.out.println("전체금액이 출금되었습니다.");
		            	}
		            }
		            else {
		            	accountArray[i].accMoney -= accMoney;
		            	System.out.println("출금이 완료되었습니다.");
		            }
		        }
		    }
       	}
       	catch (Exception e) {
    	   System.out.println(e.getMessage());
       	}
       if(isFind==false)
    	   System.out.println("입력하신 계좌번호가 존재하지 않습니다.");
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
	