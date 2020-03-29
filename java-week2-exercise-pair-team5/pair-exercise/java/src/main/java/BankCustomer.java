import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankCustomer extends BankAccount { // Bank Customer is also BankAccount

	private String name;
	private String address;
	private String phoneNumber;
	private List<BankAccount> accounts = new ArrayList<>();

	// getter setter as per recommended from exercise
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<BankAccount> getAccounts() {
		return accounts;
	}

	// add addAccount Method as recommended by exercise
	public void addAccount(BankAccount newAccount) {
		// ArrayList account will add new account into ArrayList
		accounts.add(newAccount);
	}

	// add isVip method as recommended by exercise
	public boolean isVip() {
		// construct new variable as totalBalance set it at 0
		BigDecimal totalBalance = new BigDecimal(0);
		// construct new variable for vip and set at 25000
		BigDecimal vipLimit = new BigDecimal(25000);

		// use for each loop to check every account in arrayList accounts
		for (BankAccount account : accounts) {

			totalBalance = totalBalance.add(account.getBalance());
		}

		if (totalBalance.compareTo(vipLimit) >= 0) {
			return true;
		}
		return false;
	}

}
