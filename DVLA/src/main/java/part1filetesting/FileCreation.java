/*Author-Divya Jagannatha Rao
 * Implementing a Class which has methods to set the file details and get file details
 */


package part1filetesting;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.activation.MimetypesFileTypeMap;

import org.junit.Before;

public class FileCreation
{
	 String fname;
	 String size;
	 String extension;
	 String mimetype;
	 ArrayList<String> file_details =new ArrayList<String>();  
     String filedetails;
     static String filepath;
     static String outfilepath;
     static String dir;
	
    
	//File details getter method
	public void getfiledetails()
	{	
		
		dir = System.getProperty("user.dir");
	    filepath = dir +"/src/test/java/TestData/";
		File folder = new File(filepath);
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++)
	{
		  if (listOfFiles[i].isFile()) 
	   {
		     this.fname = listOfFiles[i].getName();
		     filedetails = "File name -> "+ this.fname;
		    
		     int sizefile =   (int) listOfFiles[i].length();
		     
		     this.size = Integer.toString(sizefile);
		     filedetails = filedetails + "| File Size in bytes--> " +this.size;
		    
		    this.extension= this.fname.substring(this.fname.lastIndexOf("."));
		    filedetails= filedetails +"| File Extension "+ this.extension;
		  
		     MimetypesFileTypeMap map = new  MimetypesFileTypeMap();
		     	     
		     this.mimetype= map.getContentType(listOfFiles[i]);
		     
		     filedetails = filedetails + "| FileMimetype "+  this.mimetype;
		     
		     file_details.add(filedetails);
	 } 
	}
		
		
		//checking for .txt and removing from list 
		for (int i = 0; i < file_details.size(); i++) 
		{
			if(file_details.get(i).contains(".txt")||
			   file_details.get(i).contains(".pdf")||
			   file_details.get(i).contains(".doc")||
			   file_details.get(i).contains(".docx")||
			   file_details.get(i).contains(".rtf")||
			   file_details.get(i).contains(".jpeg")||
			   file_details.get(i).contains(".html")||
			   file_details.get(i).contains(".exe")||
			   file_details.get(i).contains(".htm")||
			   file_details.get(i).contains(".gif")||
			   file_details.get(i).contains(".jpg")||
			   file_details.get(i).contains(".mp3")||
			   file_details.get(i).contains(".exe"))
			   
			{
				file_details.remove(i);
				
			}
		}
		
		for (int i = 0; i < file_details.size(); i++) 
		{
			System.out.println((file_details.get(i)));
	    }
	}
		
	

}
