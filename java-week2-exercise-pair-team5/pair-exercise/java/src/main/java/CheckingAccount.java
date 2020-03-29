import java.math.BigDecimal;

public class CheckingAccount extends BankAccount { // Checking Account IS A BankAccount but have some restriction add on
													// it

	BigDecimal overdrawn = new BigDecimal(100); // Set up overdrawn at maximum value 100

	// Override mean bring method from method in BankAccount but add more
	// restriction into in
	@Override
	public BigDecimal withdraw(BigDecimal amountToWithdraw) { // pull withdraw method from BankAccount Class
		
		//use if Statement and keep and eyes on get/set
		//condition if withdrawn amount - balance then over overdrawn (max at 100)
		if ((amountToWithdraw.subtract(getBalance())).compareTo(overdrawn) > 0) {
			//will reject withdraw and keep balance same as before
			return getBalance();
		}

		//check if balance less than withdrawn amount
		if (getBalance().compareTo(amountToWithdraw) < 0) {
			//allow for withdraw but 10$ will be add up
			amountToWithdraw = amountToWithdraw.add(new BigDecimal(10));
			//with super below it should mean then process others as per withdraw method state in BankAccount Class.
			super.withdraw(amountToWithdraw);
			} else {
			//If withdraw amount less than balance . Just process as per withdraw method in bankAccount Class.
			super.withdraw(amountToWithdraw);
		}
		// When return here need to return getBalance not only balance
		return getBalance();
	}

}
