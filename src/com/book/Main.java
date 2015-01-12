package com.book;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.book.utl.Utility;

public class Main {
	public String auhtorString;
	public String publisherDateSTring;
	public String bookName;
	public static void main(String[] args) {
		String fileName = "";
		String converterType = "";
		if(args.length > 0 && args.length == 2) {
			fileName = args[0];
			converterType = args[1];
		}
		
		if(converterType.equals("xml"))
		{
			ProcessInput processInput = ProcessInput.getInstanceOfProcessInput();
			processInput.intputProcess(fileName);
			
			parsingData(processInput);
		}
		else
		{
			System.out.println("this is type is not allow");
		}
		
		
		
//		try {
//
//            File file = new File("C:\\Users\\A.K.MFakhruddin\\Desktop\\New folder\\book.xml");
//            JAXBContext jaxbContext = JAXBContext.newInstance(BookType.class);
//
//            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//            BookType booktype = (BookType) jaxbUnmarshaller.unmarshal(file);
//            System.out.println(booktype.getAuthors().author);
//
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
	}

	private static void parsingData(ProcessInput pI) {
		// TODO Auto-generated method stub
		Utility utility = Utility.getparsingInstance();
		
		String author = utility.getSplitString(pI.getAuthorString(), ":");
		String bookName = utility.getSplitString(pI.getBookName(), ":");
		String publishedDate = utility.getSplitString(pI.getPublishedDate(), ":");
		
		List<String> authorList = new ArrayList<String>();
		String[] tokens = author.split(",");
		for (int i = 0; i < tokens.length; i++)
		{
			String temp = tokens[i].trim();
			authorList.add(temp);
		}
		
		AuthorsType authorType = new AuthorsType();
		
		authorType.setAuthorList(authorList);
		
		BookType bookType = new BookType();
		bookType.setAuthors(authorType);
		bookType.setName(bookName.trim());
		bookType.setPublisheddate(publishedDate.trim());
		
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance( BookType.class );
			
			
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
			jaxbMarshaller.marshal( bookType, new File( "simple.xml" ) );
			jaxbMarshaller.marshal( bookType, System.out );
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//System.out.println("author ="+author + "bookName ="+bookName + "PublishedDate ="+publishedDate);
		
		
	}
}
	
