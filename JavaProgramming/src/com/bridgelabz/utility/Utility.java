/********************************************************************************* *
 * Purpose: Utility class which contains all logics 

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 17/05/2018
 *********************************************************************************/
package com.bridgelabz.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import com.bridgelabz.datastructures.LinkedDequeue;
import com.bridgelabz.datastructures.LinkedQueue;
import com.bridgelabz.datastructures.LinkedStack;
import com.bridgelabz.datastructures.MyLinkedList;

/**
 * @author Saurav: Class to define all logics via methods
 */
public class Utility {
	static Scanner scan = new Scanner(System.in);

	/**
	 * Function for checking Leap Year
	 * 
	 * @param num-the
	 *            number to check for leap year or not
	 */
	public static boolean leap(int num) {
		if (num % 400 == 0 || (num % 4 == 0 && num % 100 != 0))// condition for leap year
			return true;
		else
			return false;
	}

	/**
	 * Function for String Replace
	 * 
	 * @param string
	 *            string which needs to be replaced
	 * @return a replaced string
	 */
	public static String stringReplace(String string) {
		String tempString = "Hello username, How are you?";
		tempString = tempString.replaceAll("username", string);
		return tempString;
	}

	/**
	 * Function for Inputing a String
	 * 
	 * @return a string
	 */
	public String inputString() {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String string = scan.nextLine();
		return string;

	}

	/**
	 * Function for Inputing an Integer
	 * 
	 * @return an integer
	 */
	public int inputInt() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int integer = scan.nextInt();
		return integer;

	}

	/**
	 * Function for Inputing an double
	 * 
	 * @return a double
	 */
	public double inputDouble() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		double doub = scan.nextDouble();
		return doub;

	}

	/**
	 * Function for Inputing a boolean
	 * 
	 * @return a boolean
	 */
	public boolean inputBoolean() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		boolean bool = scan.nextBoolean();
		return bool;
	}

	/**
	 * @param choice-the
	 *            number which is the choice given by the user
	 * @param rows-the
	 *            number of rows
	 * @param col-the
	 *            number of colums
	 */
	public void makeArray(int choice, int rows, int col) {
		System.out.println("Enter the elements of array:");
		switch (choice) {
		case 1:Utility.createInt2DArray(rows,col);
			break;
		case 2:Utility.createDouble2DArray(rows,col);
			break;
		case 3:Utility.createBoolean2DArray(rows,col);
			break;
		default:
			System.out.println("wrong input");
			break;

		}
	}
/**
 * Method to create boolean 2D array
 * @param rows
 * @param col
 */
	private static void createBoolean2DArray(int rows, int col) {
		boolean[][] arrr = new boolean[rows][col];// for creating a boolean 2D array
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < col; j++) {
				arrr[i][j] = scan.nextBoolean();
			}
		}
		System.out.println("The elements are:");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < col; j++) {
				System.out.println(arrr[i][j]);
			}
		}
		
	}
/**
 * Mehtod to create double 2D array
 * @param rows
 * @param col
 */
	private static void createDouble2DArray(int rows, int col) {
		double[][] ar = new double[rows][col];// for creating a double 2D array
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < col; j++) {
				ar[i][j] = scan.nextDouble();
			}
		}
		System.out.println("The elements are:");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < col; j++) {
				System.out.println(ar[i][j]);
			}
		}
		
	}
/**
 * Method to create Integer 2D array
 * @param rows
 * @param col
 */
	private static void createInt2DArray(int rows, int col) {
		int[][] arr = new int[rows][col];// for creating an integer 2D array
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < col; j++) {
				arr[i][j] = scan.nextInt();
			}
		}
		System.out.println("The elements are:");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < col; j++) {
				System.out.println(arr[i][j]);
			}
		}
		
	}

	/**
	 * @param n-the
	 *            number which is the choice given by the user
	 * @param arr-array
	 */
	public void threeSumCount(int n, int arr[]) {
		int count = 0;
		System.out.println("The triplets are:");
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					if (arr[i] + arr[j] + arr[k] == 0) {
						count++;
						System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);// printing the triplets
					}
				}
			}
		}
		System.out.println("The number of total triplets are:" + count);

	}

	/**
	 * Function For finding the Euclidean distance from the point (x, y) to the
	 * origin (0, 0)
	 * 
	 * @param x_coordinate-the
	 *            number which is x coordinate
	 * @param y_coordinate-the
	 *            number which is y coordinate
	 */
	public double distance(int x_coordinate, int y_coordinate) {
		double distance = Math.sqrt(x_coordinate * x_coordinate + y_coordinate * y_coordinate);
		return distance;
	}

	/**
	 * Function For Finding random coupon numbers and also distict coupon numbers
	 * @param n-the
	 *            number of coupons
	 * @param arr-the
	 *            array to store random numbers
	 */
	public void randomDistinct(int number, int arr[]) {
		Random random = new Random();// Random class of util package

		for (int i = 0; i < number; i++)// for creating n random numbers
		{
			arr[i] = random.nextInt(10000);
		}
		for (int j = 0; j < arr.length; j++)// for removing dublicates
		{
			for (int k = 0; k < arr.length; k++)
				if (arr[j] == arr[k]) {
					if (j != k) {
						arr[j] = random.nextInt(10000);
					}

				}

		}
		for (int i = 0; i < number; i++)// for printing coupon numbers
		{
			System.out.println(arr[i]);
		}

	}

	/**
	 * Function for calculation wind chill using formula
	 * 
	 * @return double the value of wind chill effective temperature
	 */
	public double windChillCalculation(double tempertature, double velocity) {
		if (tempertature <= 50 && velocity >= 3 && velocity <= 120) {
			double power = Math.pow(velocity, 0.16);
			double w = 35.74 + 0.6215 * tempertature + (0.4275 * tempertature - 35.75) * power;
			System.out.println("Temperature in Farheneit(T) = " + tempertature);
			System.out.println("Velocity of Wind(V) = " + velocity);
			return w;

		} else {
			System.out.println("you must put the values in these range :- t<=50 and 3<=v<=120 ");
			return 0.0;
		}
	}

	/**
	 * Function to tell whether the strings are Annagram or not
	 * 
	 * @param string1
	 *            first string
	 * @param string2
	 *            second string
	 * @return boolean isAnnagram or not
	 */
	public boolean isAnnagram(String string1, String string2) {
		string1 = removeSpaces(string1);
		string2 = removeSpaces(string2);
		if (string1.length() == string2.length()) {
			string1 = string1.toLowerCase();
			string2 = string2.toLowerCase();
			string1 = bubbleSort1(string1);
			string2 = bubbleSort1(string2);
			if (string1.equals(string2)) {
				return true;
			} else
				return false;
		} else
			return false;
	}

	/**
	 * Function to sort a string
	 * 
	 * @param string
	 *            the string whom to sort
	 * @return sorted string
	 */
	public String bubbleSort1(String string) {
		char[] arr = string.toCharArray();
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					char temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		String temporaryString = "";
		for (int i = 0; i < arr.length; i++) {
			temporaryString += arr[i];
		}
		return temporaryString;
	}

	/**
	 * Function for removing spaces from a string
	 * 
	 * @param string
	 *            in which we have to remove spaces
	 * @return string with removed spaces
	 */
	public String removeSpaces(String string) {
		String temporaryString = "";
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) != ' ') {
				temporaryString += string.charAt(i);
			}
		}
		return temporaryString;
	}

	/**
	 * Function to determine whether the strings are pallindrome or not!
	 * 
	 * @param string
	 *            whom to ckeck
	 * @return boolean
	 */
	public boolean isPallindrome(String string) {
		int flag = 0;
		for (int i = 0; i < string.length() / 2; i++) {
			if (string.charAt(i) != string.charAt(string.length() - i - 1)) {
				flag = 1;
			}
		}
		if (flag == 0)
			return true;
		else
			return false;
	}

	/**
	 * Function for checking a prime number or not
	 * 
	 * @param number
	 *            whom to check
	 * @return result
	 */
	public boolean isPrimeNumber(int number) {
		if(number==0||number==1)
		{
			return false;
		}
		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0)
				return false;

		}
		return true;
	}

	/**
	 * Funtion for doing Insertion sort of Integers
	 * 
	 * @param arrarray
	 *            for insertion sorting
	 * @return sorted array
	 */
	public int[] insertionSortInteger(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			for (int j = i - 1; j >= 0; j--) {
				if (key < arr[j]) {
					int temporary = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temporary;
				}
			}
		}
		return arr;
	}

	/**
	 * Funtion for doing Insertion sort of Strings
	 * 
	 * @param arr
	 *            array for insertion srting
	 * @return sorted array
	 */
	public String[] insertionSortString(String[] arr) {
		for (int i = 1; i < arr.length; i++) {
			String temporary = "";
			String key = arr[i];
			for (int j = i - 1; j >= 0; j--) {
				if (key.compareToIgnoreCase(arr[j]) < 0) {
					temporary = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temporary;
				}
			}
		}
		return arr;
	}

	/**
	 * Function to perform insertion sort using generics
	 * 
	 * @param arr
	 * @return
	 */
	public static <T extends Comparable<T>> T[] insertionSort(T[] arr) {
		for (int i = 1; i < arr.length; i++) {
			T temporary;
			T key = arr[i];
			for (int j = i - 1; j >= 0; j--) {
				if (key.compareTo(arr[j]) < 0) {
					temporary = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temporary;
				}
			}
		}
		return arr;
	}

	/**
	 * Funtion for doing Bubble sort of Integers
	 * 
	 * @param arr
	 *            array which needs to be sorted
	 * @return the sorted integer array
	 */
	public int[] bubbleSortIntegers(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}

	/**
	 * Funtion for doing bubble sort of Strings
	 * 
	 * @param arr
	 *            array for bubble sorting
	 * @return sorted array
	 */
	public String[] bubbleSortString(String[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			String temp = "";
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].compareToIgnoreCase(arr[j]) > 0) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}

	/**
	 * Function for Bubble sort using Generics
	 * 
	 * @param arr
	 * @return
	 */
	public static <T extends Comparable<T>> T[] bubbleSort(T[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			T temp;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].compareTo(arr[j]) > 0) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}

	/**
	 * Function for seaching an element in integer array
	 * 
	 * @param arr
	 *            the array in which we have to search
	 * @param element
	 *            the element to be searched
	 * @return the index at which the element is present
	 */
	public static int binarySearchIntegers(int[] arr, int element) {
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int middle = (start + end) / 2;
			if (arr[middle] == element)
				return middle;
			else if (arr[middle] < element) {
				start = middle + 1;
			} else if (arr[middle] > element) {
				end = middle - 1;
			}
		}
		return -1;

	}

	/**
	 * Function for searching an element in an String array
	 * 
	 * @param arr
	 *            the array in which we have to search
	 * @param element
	 *            the element to be searched
	 * @return the index at which the element is present
	 */
	public static void binarySearch1(String[] arr, String element) {
		{
			int first = 0;
			int last = arr.length - 1;
			while (first <= last) {
				int mid = (first + last) / 2;
				if (element.compareTo(arr[mid]) > 0) {
					first = mid + 1;
				} else if (element.compareTo(arr[mid]) < 0) {
					last = mid - 1;
				} else {
					System.out.println(element + " is at index " + mid);
					break;
				}
				if (first > last) {
					System.out.println(element + "is not found.");
				}
			}
		}
	}

	public static <T extends Comparable<T>> void binarySearch(T[] arr, T element) {
		{
			int first = 0;
			int last = arr.length - 1;
			while (first <= last) {
				int mid = (first + last) / 2;
				if (element.compareTo(arr[mid]) > 0) {
					first = mid + 1;
				} else if (element.compareTo(arr[mid]) < 0) {
					last = mid - 1;
				} else {
					System.out.println(element + " is at index " + mid);
					break;
				}
				if (first > last) {
					System.out.println(element + "is not found.");
				}
			}
		}
	}

	/**
	 * Function to permute the string
	 * 
	 * @param string
	 *            passing the string
	 * @param initialIndex
	 *            of string
	 * @param lastIndex
	 *            of string
	 */
	public void permute(String string, int initialIndex, int lastIndex) {
		if (initialIndex == lastIndex)
			System.out.println(string);
		else {
			for (int i = initialIndex; i <= lastIndex; i++) {
				string = swapping(string, initialIndex, i);
				permute(string, initialIndex + 1, lastIndex);
				string = swapping(string, initialIndex, i);
			}
		}
	}

	/**
	 * Function for swapping
	 * 
	 * @param string
	 * @param initialIndex
	 * @param i
	 * @return
	 */
	public String swapping(String string, int initialIndex, int i) {
		char temporary;
		char[] charArray = string.toCharArray();
		temporary = charArray[i];
		charArray[initialIndex] = charArray[i];
		charArray[i] = temporary;
		return String.valueOf(charArray);
	}

	/**
	 * Function to Find the number
	 * 
	 * @param low
	 * @param high
	 */
	public static void search(int low, int high) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		// if ((high - low) == 1) return low;
		int mid = low + (high - low) / 2;
		if (low < high) {
			System.out.println("Is your number in between " + low + " " + (mid));
			System.out.println("Press y for yes or n for no");
			if (scan.next().charAt(0) == 'y') {
				search(low, mid);
			} else {
				search(mid + 1, high);
			}
		} else {
			System.out.println("The number is " + low);
		}
	}

	/**
	 * Function to find the count of denominations possible
	 * 
	 * @param notes
	 * @param change
	 * @param length
	 * @return the count
	 */
	public int findCount(int notes[], int change, int length) {
		int count = 0;
		for (int i = length - 1; i >= 0; i--) {
			// Find denominations
			while (change >= notes[i]) {
				change -= notes[i];
				System.out.print(notes[i] + " ");
				count++;
			}
		}
		System.out.println();
		return count;
	}

	/**
	 * Funtion to find the day on the given date
	 * 
	 * @param month
	 * @param day
	 * @param year
	 * @return the day
	 */
	public int dayOfWeek(int month, int day, int year) {
		int year0 = year - (14 - month) / 12;
		int x = year0 + year0 / 4 - year0 / 100 + year0 / 400;
		int month0 = month + 12 * ((14 - month) / 12) - 2;
		int day0 = (day + x + 31 * month0 / 12) % 7;
		return day0;
	}

	/**
	 * @param p
	 * @param y
	 * @param r
	 *            Monthly Payment
	 */
	public static void monthlyPayment(double p, double y, double r) {
		double number = 12 * y;
		double rate = r / (12 * 100);
		double payment = (p * rate) / (1 - Math.pow(1 + rate, -number));
		System.out.println(payment);
	}

	/**
	 * @param c
	 * @param t
	 * @param e
	 * @return square root of number
	 */
	public static double sqrt(double c, double t, double e) {
		while (Math.abs(t - c / t) > e * t) {
			t = (c / t + t) / 2;
		}
		return t;
	}

	/**
	 * Function to convert Decimal to binary
	 * 
	 * @param str
	 * @param num
	 */
	public static String convertToBinary(int num) {
		String str = "";
		int pow = 1;

		while (pow <= num / 2) {
			pow *= 2;
		}
		while (pow > 0) {
			if (num < pow) {
				str += 0;
			} else {
				str += 1;
				num -= pow;
			}
			pow /= 2;
		}
		return str;
	}
	
	/**
	 * Function to write into a file
	 * 
	 * @param string
	 *            the path where file is present
	 * @throws IOException
	 */
	public static void fileWriter(String string) throws IOException {
		Utility utility = new Utility();
		FileWriter fileWriter = new FileWriter(string);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		System.out.println("Enter data you want to insert into a file:");
		String str = utility.inputString();
		bufferedWriter.write(str);
		bufferedWriter.close();
		System.out.println("The file is written successfuly");
	}
/**
 * For writing integers to a file 
 * @param string
 * @return an integer array
 * @throws IOException
 */
	public static Integer[] fileWriterIntegers(String string) throws IOException {
		Utility utility = new Utility();
		FileWriter fileWriter = new FileWriter(string);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		System.out.println("Enter how many integers you want to insert into a file:");
		int size = utility.inputInt();
		Integer[] arr = new Integer[size];
		for (int i = 0; i < size; i++) {
			int number = utility.inputInt();
			arr[i] = number;
			bufferedWriter.write(number);
		}

		bufferedWriter.close();
		System.out.println("The file is written successfuly");
		return arr;
	}

	/**
	 * For reading a file and splitting it into String array
	 * @return
	 * @throws IOException
	 */
	public static String[] fileReaderAndSplitter() throws IOException {

		FileReader fileReader = new FileReader("/home/bridgelabz/Documents/file1");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String str = bufferedReader.readLine();
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ' && str.charAt(i + 1) != ' ' || str.charAt(i) == '.' && str.charAt(i + 1) != '.'
					|| str.charAt(i) == ',' && str.charAt(i + 1) != ',') {
				count++;
			}
		}
		String arr[] = new String[count + 1];
		int j = 0;
		String temp = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ') {
				temp += str.charAt(i);
			} else {
				arr[j] = temp;
				temp = "";
				j++;
			}
		}
		arr[j] = temp;
		bufferedReader.close();

		return arr;
	}
/**
 * For checking the valid expression 
 * @param str
 * @return
 */
	public static boolean checkValidExpression(String str) {
		int count = 0;
		LinkedStack<Character> stack = new LinkedStack<Character>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				stack.push(str.charAt(i));
				count++;
			}

			if (str.charAt(i) == ')') {
				if (stack.isEmpty()) {
					count--;
				} else {
					stack.pop();
					count--;
				}
			}
		}
		if (stack.isEmpty() && count == 0) {
			return true;
		}
		else {
			return false;
		}
	}
/**
 * Method to check whether the passed string is pallindrome or not
 * @param queue
 * @param string
 * @return 
 */
public boolean pallindromeChecker(LinkedDequeue<Character> queue,String string) {
	for(int i=0;i<string.length();i++)
	{
		queue.addLast(string.charAt(i));
	}
	queue.display();
	int length=queue.size()/2;
	for(int i=0;i<length;i++)
	{
		if(!queue.removeFront().equals(queue.removeRear()))
		{
			return false;
		}
		
	}
	return true;
	
}
/**
 * Method to shuffle the deck of cards
 * @param deck
 * @param suits
 * @param rank
 * @return
 */
public String[][] shuffleCards(String[][] deck,String[] suits,String[] rank) {
	for(int i=0;i<suits.length;i++)
	{
		for(int j=0;j<rank.length;j++) {
		int rndm=(int)(Math.random()*suits.length);
		int rndm1=(int)(Math.random()*rank.length);
		String temp = deck[rndm][rndm1];
	      deck[rndm][rndm1] = deck[i][j]; 
	      deck[i][j] = temp;
	}
	}
	return deck;
}
/**
 * Method to Distribute the cards to 4 players and printing their cards
 * @param deck
 */
public void distributingAndPrintingCards(String[][] deck) {
	for(int i=0;i<4;i++) {
		System.out.println("The cards of player "+(i+1)+" are:");
		for(int j=0;j<9;j++) {
			System.out.println(deck[i][j]);
		}
	}
	
}



}
