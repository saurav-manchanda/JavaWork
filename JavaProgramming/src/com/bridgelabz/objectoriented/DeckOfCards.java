/********************************************************************************* *
 * Purpose: Write   a   Program     DeckOfCards.java  ,   to   initialize   deck   of   cards   having   suit   ("Clubs",  
"Diamonds",   "Hearts",   "Spades")   &   Rank   ("2",   "3",   "4",   "5",   "6",   "7",   "8",   "9",   "10",  
"Jack",   "Queen",   "King",   "Ace").   Shuffle   the   cards   using   Random   method   and   then  
distribute   9   Cards   to   4   Players   and   Print   the   Cards   the   received   by   the   4   Players  
using   2D   Array... 

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 8/06/2018
 *********************************************************************************/
package com.bridgelabz.objectoriented;

import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 *	Class to perform Card problem and shuffling and distributing cards
 */
public class DeckOfCards {
	static String[] suits = { "Clubs", "Diamond", "Heart", "Spades" };
	static String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

	public static void main(String[] args) {
		Utility utility = new Utility();
		String[][] deck = new String[suits.length][rank.length];
		for (int i = 0; i < suits.length; i++) {
			for (int j = 0; j < rank.length; j++) {
				deck[i][j] = rank[j] + " of " + suits[i];
			}
		}

		deck = utility.shuffleCards(deck, suits, rank);
		utility.distributingAndPrintingCards(deck);
	}

}
