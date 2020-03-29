import java.math.BigDecimal;

public class BankTeller  {
	
	public static void main(String[] args) {
		
		BankAccount checkingAccount = new CheckingAccount();
		BankAccount savingsAccount = new SavingsAccount();
		BankAccount savingsAccount2 = new SavingsAccount();
		//create new customer
		BankCustomer jayGatsby = new BankCustomer();
		
		//create new customer variable and set name into it as BankCustomer set method
		jayGatsby.setName("Jay Gatsby");
		//add new account into Bank account by choose checking or saving account
		jayGatsby.addAccount(checkingAccount);
		//After above 2 process. we can set new Checking account for Jay Gatsby. can print and check.
		System.out.println(String.format("Should be 1 account: Jay Gatsby has %s accounts.", 
				jayGatsby.getAccounts().size()));
		
		//add one saving for Jay Gatsby also as below
		jayGatsby.addAccount(savingsAccount);
		//now Jay Gatsby should have 1 saving account 1 checking account
		System.out.println(String.format("Should be 2 accounts: Jay Gatsby has %s accounts.", 
				jayGatsby.getAccounts().size())); // Jay Gatsby has 2 accounts.
		
		//Test to ensure if Saving Account work properly
		System.out.println("");	// just keep space when print out on screen
		BankAccount testSavings = new SavingsAccount(); 
		testSavings.deposit(new BigDecimal (200)); 
		System.out.println("Test savings deposit; Should be 200: " + testSavings.getBalance()); 
		testSavings.withdraw(new BigDecimal(60)); 
		System.out.println("Test standard withdraw; Should be 140: " + testSavings.getBalance()); 
		testSavings.withdraw(new BigDecimal(38)); 
		System.out.println("Test withdraw (less than $150, $2 penalty); Should be 100: " + testSavings.getBalance());
		testSavings.withdraw(new BigDecimal(110)); 
		System.out.println("Test withdraw (more than balance); Should stay 100: " + testSavings.getBalance());
		
		System.out.println("");	
		
		BankAccount testChecking = new CheckingAccount(); 
		testChecking.deposit(new BigDecimal (140)); 
		System.out.println("Test checking deposit; Should be 140: " + testChecking.getBalance()); 
		testChecking.withdraw(new BigDecimal (20)); 
		System.out.println("Test standard withdraw; Should be 120: " + testChecking.getBalance()); 
		testChecking.withdraw(new BigDecimal(130)); 
		System.out.println("Test withdraw ($10 penalty); Should be -20: " + testChecking.getBalance());
		testChecking.withdraw(new BigDecimal(110)); 
		System.out.println("Test withdraw (will be more than $100 overdrawn); Should stay -20: " + testChecking.getBalance());
		
		System.out.println("");	
		
		testChecking.deposit(new BigDecimal (120)); 
		testChecking.transfer(testSavings, new BigDecimal(20));
		System.out.println("Test transfer for savings; Should be 120: " + testSavings.getBalance());
		System.out.println("Test transfer for checking; Should be 80: " + testChecking.getBalance());
		
		System.out.println("");	
		
		jayGatsby.addAccount(savingsAccount2);
		savingsAccount.deposit(new BigDecimal(8000));
		savingsAccount2.deposit(new BigDecimal(8000));
		checkingAccount.deposit(new BigDecimal(9000));
		System.out.println("Test for VIP customer; Should return VIP:");
		if (jayGatsby.isVip()) {
		System.out.println(jayGatsby.getName() + " is a VIP customer!");
		}
		else {
			System.out.println(jayGatsby.getName() + " is NOT a VIP customer.");
		}
		
		
		savingsAccount.withdraw(new BigDecimal(5000));
		System.out.println("Test for VIP customer after withdrawal brings total balance below limit; Should return NOT a VIP:");
		if (jayGatsby.isVip()) {
		System.out.println(jayGatsby.getName() + " is a VIP customer!");
		}
		else {
			System.out.println(jayGatsby.getName() + " is NOT a VIP customer.");
		}
	}

}

