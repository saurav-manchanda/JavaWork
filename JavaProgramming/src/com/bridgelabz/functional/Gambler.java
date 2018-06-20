/***********************************************************************
 * Purpose:Simulates a gambler who start with $stake and place fair $1 bets until
he/she goes broke (i.e. has no money) or reach $goal. Keeps track of the number of
times he/she wins and the number of bets he/she makes.
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 17/05/2018
 * 
 *********************************************************************** 
 */
package com.bridgelabz.functional;


/**
 * @author Saurav:
 * Class of Gambler
 */
public class Gambler {
	static int WINS=0;// variable to count the numberof wins
	static int LOSES=0;//variable tocount the number of loses
	public static void main(String[] args) {
		
		int stake = Integer.parseInt(args[0]);//parsing the first command line argument
        int goal = Integer.parseInt(args[1]);//parsing the second command line argument
        int trials = Integer.parseInt(args[2]);//parsing the third command line argument
		for(int i=0; i<trials;i++)//looping
		{
			int money=stake;
			while(money>0 && money<goal)
			{
				
				if(Math.random()<0.5)
					money++;
				else money--;
			}
			if(money==goal)
				WINS++;
			else
				LOSES++;
		}
		System.out.println("The number of wins are: "+ WINS);
		System.out.println("The number of loses are: "+ LOSES);
		System.out.println("The percentage of wins is:"+ (100*WINS)/trials +"%");
		System.out.println("The percentage of loses is:" +(100*LOSES)/trials+ "%");
		

	}

}
