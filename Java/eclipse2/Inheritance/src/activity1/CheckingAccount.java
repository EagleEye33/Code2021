package activity1;

public class CheckingAccount extends BankAccount{

	private double transactionFee;
	
	public CheckingAccount() {
		
	}
	
	public CheckingAccount(int acctNo, double initBalance, String owner, int fee) {
		super.acctNumber = acctNo;
		super.balance= initBalance;
		super.name = owner;
		this.setTransactionFee(fee);
	}

	public double getTransactionFee() {
		return transactionFee;
	}

	public void setTransactionFee(double transactionFee) {
		this.transactionFee = transactionFee;
	}
	
	
	public void deposit(double amount) {
		this.balance = this.balance + amount - this.transactionFee;
		
	}
	
	public void withdraw(double amount) {
		super.balance = super.balance - amount - this.transactionFee;
		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CheckingAccount [acctNumber=");
		builder.append(acctNumber);
		builder.append(", balance=");
		builder.append(balance);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}
}
