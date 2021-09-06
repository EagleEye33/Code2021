package activity1;

//Program Name: Bank.java - Creates BankAccount objects and CheckingAccount objects 
//Use in Inheritance discussion
//Author:  Patricia Baker
//

//Brief Description:  Tests the BankAccount and CheckingAccount classes.

public class Bank
{
	public static void main( String [ ] args)
	{
		System.out.println("Welcome to our Bank\n");
		
		//create BankAccount object
		BankAccount myAcct = new BankAccount();
		//System.out.println(" " + myAcct.getClass() );
		System.out.println("Status of myAcct: " + myAcct.toString( ) );
		
		myAcct.deposit(100);		
		myAcct.withdraw(25);
		
		System.out.println("The balance of myAcct is : " + myAcct.getBalance( ) );
		
		
		System.out.println("\nA Checking Account");
		
		//create a CheckingAccount object called studentAcct
		BankAccount studentAcct = new CheckingAccount();
		//display the state of object studentAcct
		System.out.println(studentAcct);
		//deposit 50.00 in studentAcct
		studentAcct.deposit(50);
		//display the state of object studentAcct
		System.out.println(studentAcct);
		//set studentAcct’s transaction fee to 5.00
		((CheckingAccount) studentAcct).setTransactionFee(5);
		//deposit 15.00 in studentAcct
		studentAcct.deposit(15);
		//display the state of object studentAcct
		System.out.println(studentAcct);
		//display the number of BankAccount objects created
		System.out.println(BankAccount.getAcctCount());
	 	
		CheckingAccount[] checkingAccountArray = new CheckingAccount[10];
				for(int x = 0; x < checkingAccountArray.length; x++) {
					checkingAccountArray[x] = new CheckingAccount();
					System.out.print("\n" + checkingAccountArray[x]);
				}
		checkingAccountArray[9].deposit(100);		
		System.out.println("\n" + checkingAccountArray[9]);
	}


}//end of Bank
