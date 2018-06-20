/********************************************************************************* *
 * Purpose: Create   a   Program   which   creates   Banking   Cash   Counter   where   people 
come   in   to   deposit   Cash   and   withdraw   Cash.   Have   an   input   panel   to   add   people 
to   Queue   to   either   deposit   or   withdraw   money   and   dequeue   the   people.   Maintain 
the   Cash   Balance.
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 25/05/2018
 *********************************************************************************/
package com.bridgelabz.datastructures;

import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 * Class to perform Cash Counter of bank using queue
 */
public class BankingCashCounter {

	static double bankCash;
/**
 * withdraw method
 * @param queue
 * @param money
 */
	public static void withdraw(Queue<Integer> queue, double money) {
		if (bankCash > 0) {
			bankCash = bankCash - money;
			if (bankCash > 0) {
				System.out.println("Total amount in bank" + bankCash);
				queue.dequeue();
			}
			else 
				System.out.println("Sorry bank has less money");
		}
	}
/**
 * Deposit method
 * @param queue
 * @param money
 */
	public static void deposit(Queue<Integer> queue, double money) {
		bankCash = bankCash + money;
		System.out.println("Total amount in bank" + bankCash);
		queue.dequeue();
	}

	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("Enter the initial amount in the bank:");
		bankCash=utility.inputDouble();
		System.out.println("Enter the number of peple in the queue");
		Integer size = utility.inputInt();
		if (size > 0) {
			Queue<Integer> queue = new Queue<Integer>(size);
			for (int i = 1; i <= size; i++) {
				queue.enqueue(i);
			}
			for (int i = 0; i < queue.size(); i++) {
				System.out.println("WELCOME TO MY BANK!!");
				System.out.println("What action do you want to perform??");
				System.out.println("1.Deposit money???");
				System.out.println("2.Withdraw money??");
				int choice = utility.inputInt();

				switch (choice) {
				case 1:
					System.out.println("Enter the amount to deposit");
					double money = utility.inputDouble();
					System.out.println("Depositing your money");
					if (money > 0) {
						deposit(queue, money);
					}
					break;
				case 2:
					System.out.println("Enter the amount to deposit");
					double money1 = utility.inputDouble();
					System.out.println("Adding your money to your account.");
					withdraw(queue, money1);
					break;

				default:System.out.println("Wrong choice");
					break;
				}
			}
		}
	}
	

}
