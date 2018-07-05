/********************************************************************************* *
 * Purpose: To make the Bank class having bankName and string the account.
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 5/07/2018
 *********************************************************************************/
package com.bridgelabz;

/**
 * @author Saurav:
 * Class Bank containing the fields Bank name and storing account details.
 */
public class Bank {
	String bankName;
	private Account account;
	public String getBankname() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	public void display() {
		System.out.println("The bank name is: "+bankName);
		this.account.display();
		
	}
	
}
