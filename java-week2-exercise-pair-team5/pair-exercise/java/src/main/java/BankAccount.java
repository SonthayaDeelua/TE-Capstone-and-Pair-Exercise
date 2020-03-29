import java.math.BigDecimal;

public class BankAccount { //Create BankAccount Class
	
	//Set private to variable as per assigned from exercise
	private String accountNumber; 
	private BigDecimal balance;
	
	//Built constructor for BankAccount
	public BankAccount () {
		this.balance = new BigDecimal(0);
	}

	//getter setter for AccountNumber
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	//getter for balance
	public BigDecimal getBalance() {
		return balance;
	}
	
	
	//Building methods as per assigned from exercise
	// Deposit methods
	public BigDecimal deposit(BigDecimal amountToDeposit) {
		balance = balance.add(amountToDeposit);
		return balance;
	}
	
	//Withdraw methods
	public BigDecimal withdraw(BigDecimal amountToWithdraw) {
		balance = balance.subtract(amountToWithdraw);
		return balance;
		}
				
	//Transfer methods
	public void transfer(BankAccount destinationAccount, BigDecimal transferAmount) {
		//use withdraw method to withdraw from current account
		withdraw(transferAmount);
		//use deposit method to deposit to destinationAccount.
		destinationAccount.deposit(transferAmount);
	}


}
