package part1file;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import part1filetesting.FileCreation;

public class Filetesting
{
	public static void main(String args[]) throws FileNotFoundException, UnsupportedEncodingException
	{
		FileCreation f =  new FileCreation();
		f.getfiledetails();		
	}
}

