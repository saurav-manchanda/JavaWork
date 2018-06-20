/********************************************************************************* *
 * Purpose: Extend   the   DeckOfCards   program   to   create   a   Player   Object   having   Deck   of   Cards,   and  
having   ability   to   Sort   by   Rank   and   maintain   the   cards   in   a   Queue   implemented   using  
Linked   List.   Do   not   use   any   Collection   Library.   Further   the   Player   are   also   arranged  
in   Queue.   Finally   Print   the   Player   and   the   Cards   received   by   each   Player. 

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 8/06/2018
 *********************************************************************************/
package com.bridgelabz.objectoriented;

import com.bridgelabz.datastructures.LinkedQueue;
import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 * Class to perform Deck of cards via queue
 */
public class DeckOfCardsQueue {
	static String[] suits = { "Clubs", "Diamond", "Heart", "Spades" };
	static String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
	static String[][] deck = new String[suits.length][rank.length];
	static String[] array1 = new String[9];
	static String[] array2 = new String[9];
	static String[] array3 = new String[9];
	static String[] array4 = new String[9];

	public static void distrubutingCards(LinkedQueue<String> queueAll, String[][] deck) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 9; j++) {
				if (i == 0) {
					array1[j] = deck[i][j];
					queueAll.dequeue();
				} else if (i == 1) {
					array2[j] = deck[i][j];
					queueAll.dequeue();
				} else if (i == 2) {
					array3[j] = deck[i][j];
					queueAll.dequeue();
				} else {
					array4[j] = deck[i][j];
					queueAll.dequeue();
				}
			}
		}
	}

	public static void main(String[] args) {
		Utility utility = new Utility();
		LinkedQueue<String> queue1 = new LinkedQueue<>();
		LinkedQueue<String> queue2 = new LinkedQueue<>();
		LinkedQueue<String> queue3 = new LinkedQueue<>();
		LinkedQueue<String> queue4 = new LinkedQueue<>();
		LinkedQueue<String> queueAll = new LinkedQueue<>();
		for (int i = 0; i < suits.length; i++) {
			for (int j = 0; j < rank.length; j++) {
				deck[i][j] = rank[j] + " of " + suits[i];
			}
		}
		deck = utility.shuffleCards(deck, suits, rank);
		for (int initial = 0; initial < suits.length; initial++) {
			for (int j = 0; j < rank.length; j++) {
				queueAll.enqueue(deck[initial][j]);
			}
		}
			distrubutingCards(queueAll, deck);
			array1 = sortCards(array1);
			array2 = sortCards(array2);
			array3 = sortCards(array3);
			array4 = sortCards(array4);
			
			
			queue1 = insertIntoQueue(queue1, array1);
			queue2 = insertIntoQueue(queue2, array2);
			queue3 = insertIntoQueue(queue3, array3);
			queue4 = insertIntoQueue(queue4, array4);

			System.out.println("The cards of player 1:");
			queue1.display();
			System.out.println("\n\n\n");
		
			System.out.println("The cards of player 2:");
			queue2.display();
			System.out.println("\n\n\n");
			
			System.out.println("The cards of player 3:");
			queue3.display();
			System.out.println("\n\n\n");
			
			System.out.println("The cards of player 4:");
			queue4.display();
			System.out.println("\n\n\n");

		}

	public static String[] sortCards(String[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i].compareTo(array[j]) > 0) {
					String temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}

	public static LinkedQueue<String> insertIntoQueue(LinkedQueue<String> queue, String[] array) {
		for (int i = 0; i < array.length; i++) {
			queue.enqueue(array[i]);
		}
		return queue;
	}
}
