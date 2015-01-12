package com.book;

import java.io.File;
import java.util.Scanner;

public class ProcessInput {
	private String authorString;
	private String bookName;
	private String publishedDate;
	private static ProcessInput processInputInstance = new ProcessInput();
	
	public String getAuthorString() {
		return authorString;
	}
	public void setAuthorString(String authorString) {
		this.authorString = authorString;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}
	
	public void intputProcess(String fileName) {
		// TODO Auto-generated method stub
		try {
			File file = new File (fileName);
			
			Scanner sc = new Scanner(file);
			
			while(sc.hasNextLine()){
				
				String line = sc.nextLine();
				//sSystem.out.println("line="+line);
				if(line.matches("(?i:.*author.*)"))
				{
					setAuthorString(line);
				}
				else if(line.matches("(?i:.*published date.*)"))
				{
					setPublishedDate(line);
				}
				else if(line.matches("(?i:.*name.*)"))
				{
					setBookName(line);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static ProcessInput getInstanceOfProcessInput()
	{
		if(processInputInstance!=null)
			return processInputInstance;
		else 
			return new ProcessInput();
	}
}
