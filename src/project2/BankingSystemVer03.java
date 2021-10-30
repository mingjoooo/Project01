package project2;

import java.util.Scanner;

import project2.ver03.AccountManager;
import project2.ver03.MenuChoice;
import project2.ver03.MenuSelectException;

public class BankingSystemVer03 implements MenuChoice
{
    
    public static void main(String[] args) {
    	
    	AccountManager acMgr = new AccountManager();
		Scanner sc = new Scanner(System.in);
    	
    	boolean run = true;
    	while(run) {
			System.out.println("-----Menu------");
			System.out.println("1. 계좌계설");
			System.out.println("2. 입금");
			System.out.println("3. 출금");
			System.out.println("4. 전체계좌정보출력");
			System.out.println("5. 프로그램종료");
			
			int inputNum = sc.nextInt();
			
			
			if(inputNum==MAKE) {
				acMgr.makeAccount();
			}else if(inputNum==DEPOSIT) {
				acMgr.depositMoney();
			}else if(inputNum==WITHDRAW) {
				acMgr.withdrawMoney();
			}else if(inputNum==NQUIRE) {
				acMgr.showAccInfo();
			}else if(inputNum==EXIT) {
				System.exit(0);
			}else {
				System.out.println("1~5사이의 숫자만 입력하세요.");
			}
		}
    }
}
