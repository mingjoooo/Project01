package project2.ver04;

public class AutoSaverT extends Thread{
	AccountManager acc;
	
	public AutoSaverT(AccountManager amr) {
		this.acc = amr;
	}
	@Override
	public void run() {
		while(true) {
			try {
				acc.objectOutput();
				acc.saveText();
				sleep(5000);
			}
			catch(InterruptedException e) {
				System.out.println("자동저장시 오류발생");
				break;
			}
		}
	}
}
