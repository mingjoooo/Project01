package project2.ver04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class AccountManager{
	
	Scanner scanner = new Scanner(System.in);
	HashSet<Account> set;
	String grade = null;
	int accMoney;
	int rate;

    public AccountManager() {
    	set = new HashSet<Account>();
    	objectInput();
	}
	
	public void makeAccount() {
		
		String accountID = null;
        String customName = null;
        int accMoney = 0;
        Account equals;
        
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
        	
        	equals = new NormalAccount(accountID, customName, accMoney, rate);
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
        	
        	equals = new HighCreditAccount(accountID, customName, accMoney, 
					rate, grade);
        }
        else {
        	System.out.println("1~2사이의 숫자만 입력하세요.");
        	return;
        }
        
        boolean check = set.add(equals);
        
        if (check) {
        	System.out.println("계좌계설이 완료되었습니다.");
        }
        else {
        	System.out.println("이미 등록된 계좌입니다");
        	System.out.println("덮어 쓰시겠습니까? Y(y) / N(n)");
        	System.out.print("선택 : ");
        	char answer = scanner.next().charAt(0);
        	
        	if (answer == 'y' || answer == 'Y') {
        		set.remove(equals);
        		set.add(equals);
        		System.out.println("덮어쓰기 완료");
        	}
        	else {
        		System.out.println("기존 정보가 유지됩니다");
        	}
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
        	for (Account ac : set) {
        		if (accountID.equals(ac.getAccountID())) {
        			isFind = true;
        			System.out.println("입금액: ");
        			int accMoney = scanner.nextInt();
        			if(accMoney%500!=0) {
	                 	System.out.println("500원 단위로만 입금이 가능합니다.");
	                 	
	                 	MenuSelectException mse = new MenuSelectException();
	                 	throw mse;
	                }
	                else{
	                	ac.accMoney += accMoney;
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
		    for(Account ac : set) {
		        if(accountID.equals(ac.getAccountID())) {
		        	isFind = true;
		        	System.out.print("출금액: ");
		        	int accMoney = scanner.nextInt();
		        	
		        	
		        	if(accMoney%1000!=0) {
		        		System.out.println("출금은 1000원 단위로만 출금이 가능합니다.");
		        		return;
		        	}
		        	else {
		        		ac.accMoney -= accMoney;
		        		System.out.println("출금이 완료되었습니다.");
		        	}
		        	
		        	
		            if(ac.accMoney<0) {
		            	System.out.println("출금액보다 잔고가 부족합니다.");
		            	
		            	MenuSelectException mse = new MenuSelectException();
		             	throw mse;		            	
		            }
		            else if(ac.accMoney<accMoney){
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
		            	ac.accMoney -= accMoney;
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
		for (Account ac : set) {
			ac.showAccountInfo();
			System.out.println();
		}
		if (set.size() == 0) {
			System.out.println("출력할 계좌정보가 없습니다.");
		}
		System.out.println("------------------");
		System.out.println("전체계좌정보 출력이 완료되었습니다.");
	}
	public void saveChoice(AutoSaverT save) {
		
		System.out.println("1.자동저장On, 2.자동저장Off");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		
		if(choice==1) {
			if(!(save.isAlive())) {
				save.setDaemon(true);
				save.start();
			}
			else {
				System.out.println("이미 자동저장이 실행중입니다.");
				return;
			}
		}
		else if(choice==2) {
			System.out.println("자동저장이 종료되었습니다.");
			if(save.isAlive())
					save.interrupt();
		}
	}
	public void objectOutput() {
		
		try {
			ObjectOutputStream out = new ObjectOutputStream
					(new FileOutputStream("src/project2/ver04/AccountInfo.obj"));
			
			Iterator<Account> itr = set.iterator(); 
			while(itr.hasNext()) { 
				Account acc = (Account)itr.next(); 
				out.writeObject(acc);
			}
			out.close();
		}
		catch(Exception e) {
			System.out.println("계좌 정보 직렬화시 예외발생");
			e.printStackTrace();
		}
	}

	public void objectInput() {
		try {
			ObjectInputStream in = 
					new ObjectInputStream(
							new FileInputStream("src/project2/ver04/AccountInfo.obj"));
			
			while(true) {
				Account account = (Account)in.readObject();
				set.add(account);
				if(account==null) break;
			}
			in.close();
		}
		catch (Exception e) {
			System.out.println("더 이상 읽을 정보가 없습니다.");
		}
	}
	
	public void saveText() {
		System.out.println("5초마다 자동저장");
		
		try {
			PrintWriter out = new PrintWriter(
					new FileWriter("src/project2/ver04/AutoSaveAccount.txt"));
			
			
			for (Account acc : set) {
				out.println(acc.toString());
			}
			out.close();
		}
		catch (IOException e) {
			System.out.println("입출력 예외 발생");
		}
		catch (Exception e) {
			System.out.println("예외발생");
		}
	}
}
	