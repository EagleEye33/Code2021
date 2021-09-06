package chp5;

public class Bank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			BankAccount myAcct = new BankAccount();
			
		//create a BankAccount object called studentAcct
		BankAccount studentAcct = new BankAccount();
		
		//studentAcct should be owned by Sue Student
		studentAcct.setName("Sue Student");
		
		//studentAcct account number should be 1234
		studentAcct.setAcctNumber(1234);
		
		//display the state of object studentAcct
		System.out.println(studentAcct);
		
		//deposit 200.00 in studentAcct
		studentAcct.deposit(200.00);
		
		//withdraw 30.00 from studentAcct
		studentAcct.withdraw(30.00);
		
		//display the balance in studentAcct
		System.out.println(studentAcct.getBalance());
		

		//display the state of object myAcct
		System.out.println(myAcct);
		
		//display the state of object studentAcct
		System.out.println(studentAcct);
		
		// create a BankAccount object called teacherAcct. Use overloaded (new) constructor with
		// account number 4444, balance of 1500, and name James Gosling
		BankAccount teacherAcct = new BankAccount(4444, 1500, "James Gosling");
		
		// display the state of object teacherAcct
		System.out.println(teacherAcct);
		
		// withdraw 50.00 from teacherAcct with a 5.00 fee
		teacherAcct.withdraw(50.00,5.00);
		
		// display the state of object teacherAcct
		System.out.println(teacherAcct);
		
		// display the number of BankAccount objects created.
		System.out.println("Number of Bank Account objects created: " + BankAccount.getCount());
		
		myAcct.deposit(1000);
		myAcct.withdraw(5);
		
		System.out.println(myAcct);

	}


}
