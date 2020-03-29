import java.math.BigDecimal;

public class SavingsAccount extends BankAccount{ // Extends mean Saving account is Banking account with some extension add on
	
	//Define bigDecimal as per assign from exercise. 
	BigDecimal under150 = new BigDecimal(150);
	
	@Override
	public BigDecimal withdraw(BigDecimal amountToWithdraw) {

		//if withdraw amount higher than balance. withdraw cancel return current balance
		if (getBalance().compareTo(amountToWithdraw) < 0) {
			return getBalance();
		} 
		
		//if current balance less than 150. process the withdraw with $2 additional charge.
		if (getBalance().compareTo(under150) < 0) {
			amountToWithdraw = amountToWithdraw.add(new BigDecimal(2));
			//then let withdraw method in BankAccount Class process other method in it
			super.withdraw(amountToWithdraw);
			}
			else {
			//if balance higher than $150 process withdrawal as normal.no fee charge.
			super.withdraw(amountToWithdraw);
		}
		return getBalance();
	}

}
