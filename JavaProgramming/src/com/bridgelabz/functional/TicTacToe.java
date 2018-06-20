/*********************************************************************************
 * 
 * Purpose: Program to   play   a   Cross   Game   or   Tic­Tac­Toe   Game.   Player   1   is 
the   Computer   and   the   Player   2   is   the   user.   Player   1   take   Random   Cell   that   is   the 
Column   and   Row.  

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 18/05/2018
 *********************************************************************************/
package com.bridgelabz.functional;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Saurav:
 * Class to play   a   Cross   Game   or   Tic­Tac­Toe   Game
 */
public class TicTacToe
{
    String[][] board; 
    static String PLAYER1 = "X";
    static String PLAYER2 = "O";    
  
    /**
     * Default Constructor to make 3 by 3 board
     */
    public TicTacToe()
    {
       board = new String[3][3]; 
    }
    
    public static void main(String[] args) 
    {
        
        TicTacToe tictac = new TicTacToe();            // allocating a board
        Scanner scanner = new Scanner(System.in);    
        int moves = 0;
        System.out.println("Begin X start first.");
        tictac.printBoard();
        while (moves < 9) 
        {
        	// for X player
            tictac.makeMove(scanner, PLAYER1);
            moves++;
            if (moves > 4) 
            {
                if (tictac.checkWinner(PLAYER1)) 
                {
                   System.out.println(PLAYER1 + " You Win!!!");
                   break;
                }
            }
            tictac.printBoard();
            // 0 Player
            tictac.makeMove(scanner, PLAYER2);
            moves++;
            if (moves > 4) 
            {
                if (tictac.checkWinner(PLAYER2)) 
                {
                   System.out.println(PLAYER2 + " You Win!!!");
                   break;
                }
            }
            tictac.printBoard();
        }
    }
    /**
     * Function to print the board
     */
    public void printBoard()
    {
        System.out.println();
        for (int i = 0; i < board.length; i++) 
        {
            for (int j = 0; j < board[i].length; j++) 
            {
                if (board[i][j] == null) 
                {
                    System.out.print("_");
                } 
                else 
                {
                    System.out.print(board[i][j]);
                }
                if (j < 2) 
                {
                    System.out.print("|");
                } else 
                {
                    System.out.println();
                } 
             }
         }
         System.out.println();
    }
    /**
     * 
     * @param play the turn of player X 
     * @return boolean whether you have win or lose
     */
    public Boolean checkWinner(String play) 
    {
        int playInRow = 0;
        int playD1 = 0;
        int playD2 = 0;
        int[] playInColumn = new int[board[0].length];
        for (int i = 0; i < board.length; i++) 
        {
            playInRow = 0;
            for (int j = 0; j < board[i].length; j++) 
            {
                if (null == board[i][j]) 
                {
                    continue;
                }
                if (board[i][j].equals(play)) 
                {
                    playInRow++;
                    playInColumn[j]++;
                    if (i == j) 
                    {
                        playD1++;
                    } 
                    else if (i+j ==2) 
                    {
                        playD2++;
                    }
                }
                
            }
            if (playInRow == 3) 
            {
                return true;
            }
        }
        if (3 == playD1 || 3 == playD2) 
        {
            return true;
        }
        for (int i = 0; i < playInColumn.length; i++) 
        {
            if (playInColumn[i] == 3) 
            {
                return true;
            }
        }
        return false;    
    }
  
/**
 * Function for making a move
 * @param s
 * @param play
 */
    public void makeMove(Scanner scanner, String play) 
    {
    	Random random = new Random();
        int row=0;
        int column=0;
        Boolean done = false;
        while(!done) 
        {
            
            if(play.equals("O"))
        	{
            	row = random.nextInt(3);
            	column = random.nextInt(3);
            	board[row][column] = play;
                return;
        	}
            else
            {
            	System.out.println ("Enter coordinates to play your " + play);
            	if (scanner.hasNextInt()) 
            	{  
            		row = scanner.nextInt();
            	}
            	if (scanner.hasNextInt()) 
            	{
            		column = scanner.nextInt();
            	}
            	else 
            	{
            		scanner.nextLine();     
            		System.out.println("Not a valid int token");
            		continue;
            	}
            	
            	if ((row < 0) || (row > 2) || (column < 0) || (column > 2)) 
            	{
            		System.out.println("Both inputs must be integers between 0 and 2.");
            		continue;                
            	} 
            
            else if (board[row][column] != null )
            {  
            		System.out.println("That location is occupied");
            		continue; 
            }
            else 
            {
                board[row][column] = play;
                return;
            }
        }
    }
    }
    
}