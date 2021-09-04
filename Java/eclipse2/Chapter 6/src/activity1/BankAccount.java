package activity1;

/* Class Name: The BankAccount class - Updated use in GUI Assignment
   Author:  P Baker
	
	Brief Description:

    Add 2 new instance variables - acctNumber and name

    Modify constructor methods accordingly

    Accessor and Mutator methods for all instance variables

    Add static variable acctCount to count the number of objects created

    Add static method getacctCount to return the acctCount
 */



class BankAccount 
{

    private int acctNumber;
    private double balance;
    private String name;

    private static int acctCount= 0;  //not an instance variable, but a class variable (static)

    /** constructs a bank account with zero balance, zero account number
        and name set to Unknown

     */

    public BankAccount() {
		 acctNumber = 0;
		 balance = 0.0;
		 name = "Unknown";

		 acctCount++;
 	}

 	/*
 	  constructs a bank account with an account number, an  initial balance, and
 	  an owner!
 	 */

 	public BankAccount(int acctNo, double initBalance, String owner) {
		acctNumber = acctNo;
		balance = initBalance;
		name = owner;

		acctCount++;
 	}


    //all of the mutator methods - set

    public void setAcctNumber(int acct)
	 {
		    acctNumber = acct;
    }

   public void setBalance(double amount)
	 {
	    balance = amount;
    }
   
    public void setName(String someName)
	 {
		name = someName;
    }

	//all of the accessor methods - get
   
	public int getAcctNumber()
	{
	    return acctNumber;
    }

    public double getBalance()
	 {
        return balance;
    }

    public String getName()
	 {
	    return name;
    }

   
    public void deposit(double amount)
   {
        balance = balance + amount;
    }

    public void withdraw(double amount) {
        balance = balance - amount;
    }
	 
	 //overloaded method.  charges a fee!
	 public void withdraw(double amount, double fee)
	 {
	 		balance = balance - amount - fee;
	 }

    public String toString()
    {
			return ("BankAccount : acctNumber "  + acctNumber +  " balance : " + balance 
			   + " name : " + name  );
	}

	//Class method to display our private static variable
	public static int getAcctCount()
	{
		return ( acctCount );
	}
	
}// end of class definition