package com.book.utl;

public class Utility {
	
	public static Utility utility = new Utility();
	
	
	public String getSplitString(String splitString,String sytx)
	{
		System.out.println(" splitString" + splitString +" ="+sytx);
		String finalString = "";
		String[] tokens = splitString.split(sytx);
		
		finalString = tokens[tokens.length-1];
		
		return finalString;
	}
	
	public static Utility getparsingInstance()
	{
		if(utility !=null)
			return utility;
		else
			return new Utility();
	}

}
