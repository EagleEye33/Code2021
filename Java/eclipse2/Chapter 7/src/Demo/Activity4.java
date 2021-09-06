package Demo;

public class Activity4 {

		public static void main(String[] args) {
			BankAccount[] accounts = new BankAccount[3];
			BankAccount myAccount = new BankAccount();
			accounts[0] = myAccount;
			accounts[1] = new BankAccount();
			accounts[2] = new BankAccount();
			
			// for-each loop
			for(BankAccount account : accounts) {
				System.out.println(account);
			}
		}
}
