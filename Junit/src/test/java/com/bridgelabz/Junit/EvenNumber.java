/********************************************************************************* *
 * Purpose: Even Number 
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 5/07/2018
 *********************************************************************************/
package com.bridgelabz.Junit;

/**
 * @author Saurav:
 * Class EvenNumber that is having a method to check the number is even or not 
 */
public class EvenNumber {
	/**
	 * Method isEvenNumber taking the number parameter
	 * @param number
	 * @return
	 */
	public boolean isEvenNumber(int number){
        boolean result = false;
        if(number%2 == 0){
            result = true;
        }
        return result;
    }
}
