package Demo;

import java.text.DecimalFormat;

public class BankAccount {
	
	private static int count = 0;
	
	private int acctNumber;
	private double balance;
	private String name;
	
	//no-arg or default
	public BankAccount() {
		this.acctNumber = 9999;
		this.balance = 0.0;
		this.name = "";
		BankAccount.count++;
	}

	public BankAccount(int acctNo, double initBalance, String owner) {
		this.acctNumber = acctNo;
		this.balance = initBalance;
		this.name = owner;
		BankAccount.count++;
	}
	
	public void setAcctNumber(int acct) {
		acctNumber = acct;
	}
	public void setName(String owner) {
		
		name = owner;
	}
	
	public int getAcctNumber() {
		return acctNumber;
	}
	
	public double getBalance() { 
		return balance;
	}
	
	public String getName() {
		return name;
	}
	 public void deposit(double amount) {
		 balance += amount;
	 }
	 
	 public void withdraw(double amount) {
		 balance -= amount;
	 }
	 
	 public void withdraw(double amount, double fee) {
		 balance = balance - amount - fee;
	 }
	
	 public static int getCount() {
		 return BankAccount.count;
	 }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BankAccount [acctNumber=");
		builder.append(acctNumber);
		builder.append(", balance=");
		builder.append(balance);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}
	 
	
}
