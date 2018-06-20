package com.bridgelabz.alogoritm;

import com.bridgelabz.utility.Utility;

public class Test {

	public static void main(String[] args) {
		Utility utility = new Utility();
		int x=utility.inputInt();
		int y=utility.inputInt();
		int z=utility.inputInt();
		String x1=utility.inputString();
		String y2=utility.inputString();
		String z3=utility.inputString();
		 int r= Test.max(x, y, z);
		 System.out.println(r);
	}
	public static int max(Integer x,Integer y,Integer z)
	{
		int result=x>y&&x>z?x:y>x&&y>z?y:z;
		 return result;
	}
	public static String max(String x,String y,String z)
	{
		String result=x.compareTo(y)>0&&x.compareTo(z)>0?x:y.compareTo(x)>0&& y.compareTo(z)>0?y:z;
		 return result;
	}
	public static <T extends Comparable<T>> T max(T x,T y,T z)
	{
		T t;
		  t=x.compareTo(y)>0&&x.compareTo(z)>0?x:y.compareTo(x)>0&& y.compareTo(z)>0?y:z;
		return t;
	}

	
}
