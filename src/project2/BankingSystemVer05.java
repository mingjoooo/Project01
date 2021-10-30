package project2;

import java.util.Scanner;

import project2.ver05.Account;
import project2.ver05.MenuChoice;
import project2.ver05.accountOpenSql;
import project2.ver05.depositSql;
import project2.ver05.showInfoAccSql;
import project2.ver05.withDrawSql;

public class BankingSystemVer05 implements MenuChoice
{
	
	static Account acc = new Account(null, null, MAKE);
    static Scanner scanner = new Scanner(System.in);
    
    public static void showMenu(){
		boolean run = true;
		while(run) {
			System.out.println("------Menu------");
			System.out.println("1. 계좌계설");
			System.out.println("2. 입금");
			System.out.println("3. 출금");
			System.out.println("4. 전체계좌정보출력");
			System.out.println("5. 프로그램종료");
			
			int inputNum = scanner.nextInt();
			
			if(inputNum==MAKE) {
//				acc.makeAccount();
				new accountOpenSql().execute();
			}else if(inputNum==DEPOSIT) {
//				acc.depositMoney();
				new depositSql().execute();
			}else if(inputNum==WITHDRAW) {
//				acc.withdrawMoney();
				new withDrawSql().execute();
			}else if(inputNum==NQUIRE) {
//				acc.showAccInfo();
				new showInfoAccSql().execute();
			}else if(inputNum==EXIT) {
				System.exit(0);
			}else {
				System.out.println("1~5사이의 숫자만 입력하세요.");
			}
		}
	}
	
	public static void main(String[] args)
	{
		showMenu();	
	}
}
