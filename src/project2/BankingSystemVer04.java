package project2;

import java.util.Scanner;

import project2.ver04.AccountManager;
import project2.ver04.AutoSaverT;
import project2.ver04.MenuChoice;
import project2.ver04.MenuSelectException;

public class BankingSystemVer04 implements MenuChoice
{
    
    public static void main(String[] args) {
    	
    	AccountManager acMgr = new AccountManager();
		Scanner sc = new Scanner(System.in);
		AutoSaverT as = new AutoSaverT(acMgr);
    	
    	boolean run = true;
    	while(run) {
			System.out.println("-----Menu------");
			System.out.println("1. 계좌계설");
			System.out.println("2. 입금");
			System.out.println("3. 출금");
			System.out.println("4. 전체계좌정보출력");
			System.out.println("5. 저장옵션출력");
			System.out.println("6. 프로그램종료");
			
			int inputNum = sc.nextInt();
			
			
			if(inputNum==MAKE) {
				acMgr.makeAccount();
			}
			else if(inputNum==DEPOSIT) {
				acMgr.depositMoney();
			}
			else if(inputNum==WITHDRAW) {
				acMgr.withdrawMoney();
			}
			else if(inputNum==NQUIRE) {
				acMgr.showAccInfo();
			}
			else if(inputNum==SAVE) {
				if (!as.isAlive()) {
					as = new AutoSaverT(acMgr);
					acMgr.saveChoice(as);
				}
				else {
					acMgr.saveChoice(as);
				}
			}
			else if(inputNum==EXIT) {
				acMgr.objectOutput();
				System.exit(0);
			}
			else {
				System.out.println("1~5사이의 숫자만 입력하세요.");
			}
		}
    }
}
