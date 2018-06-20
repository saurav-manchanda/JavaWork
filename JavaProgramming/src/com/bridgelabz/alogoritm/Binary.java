/********************************************************************************* *
 * Purpose: to   read   an   integer   as   an   Input,   convert   to   Binary   using   toBinary  
function   and   perform   the   following   functions. 
i.   Swap   nibbles   and   find   the   new   number. 
ii.   Find   the   resultant   number   is   the   number   is   a   power   of   2.

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 22/05/2018
 *********************************************************************************/
package com.bridgelabz.alogoritm;

import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 * Class Binary.java
 */
public class Binary {
	public static void main(String[] args) {
		Utility utility= new Utility();
	    System.out.println("Enter the integer to be converted into binary");
	    int number= utility.inputInt();
	    System.out.println("binary equivalent is");
	    String string=toBinary(number);
	    System.out.println(string);
	    swap(string);
	}

	/**
	 * Function to swap the nibbles
	 * @param string
	 */
	private static void swap(String string) {
	if(string.length()<8) {
	    while(string.length()<8)
	        string="0"+string;
	}
	char[] ch=string.toCharArray();
	for(int i=0;i<ch.length;i++)
	    System.out.print(ch[i]);
	System.out.println();
	for (int i=0;i<ch.length/2;i++) {
	    char ch1=ch[i];
	    ch[i]=ch[i+ch.length/2];
	    ch[i+ch.length/2]=ch1;
	}
	string=String.valueOf(ch);
	System.out.println("swapped digit"+" "+string);
	System.out.println("decimal value of swapped number is:");
	    int num=Integer.parseInt(string);
	    int digit=0;
	    int pow=0;
	    while(true) {
	        if(num==0)
	            break;
	        else {
	            int temp=num%10;
	            digit=(int) (digit+temp*(Math.pow(2,pow)));
	            num=num/10;
	            pow++;
	        }
	    }
	    System.out.println(digit);
	     while (digit%2==0){
	         digit /= 2;
	     }
	     if(digit==1)
	         System.out.println("number is power of 2");
	     else
	         System.out.println("number is not power of 2");
	}
	//toBinary method
	public static String toBinary(int number) {
	    String string="";
	int power=1;
	while(power<=number/2)
	    power*=2;
	    while(power>0) {
	        if(number<power)
	            string+=0;
	        else {
	            string+=1;
	            number-=power;
	        }
	        power/=2;
	        }
	return string;
	}
}
