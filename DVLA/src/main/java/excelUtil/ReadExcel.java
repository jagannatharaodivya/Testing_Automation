/*Author-Divya Jagannatha Rao
 * Implementing Helper Class which has helper methods using apache POI Api
 * to read the files in the Test Data folder
 * Please Bear in mind that File_1.xlsx is the test data file for the PART 2 Scenario  
 */

package excelUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadExcel 
{
	static ArrayList<String> regnumdetails = new ArrayList<String>(); 
	static ArrayList<String> expectedcolourdetails = new ArrayList<String>();
	static String dir;
	static String filepath;
	static String filename;
	static File f ;
	static FileInputStream fis;
	static XSSFWorkbook workbook ;
	static XSSFSheet xs;
	static int rows;
	
	//File Path setup
	public void setExcel() 
	{
		dir = System.getProperty("user.dir");
		filepath = dir  + "/src/test/java/TestData/";
	    filename = "File_1.xlsx";
	}
	//checking the row count in the excel to verify file is empty or not
	public int is_file_empty() throws FileNotFoundException, IOException
	{
		f = new File(filepath+filename);
		fis = new FileInputStream(f);
		workbook = new XSSFWorkbook(fis);
		xs =  workbook.getSheetAt(0);
		 rows= xs.getPhysicalNumberOfRows();
		 
		return rows;
	  
	}
	
	//Reading Excel to fetch Registration number, that is the column 0, for all the rows in test data- File_1.xlsx
	public ArrayList<String> read_get_regnum() throws IOException
    {
	f = new File(filepath+filename);
	fis = new FileInputStream(f);
	workbook = new XSSFWorkbook(fis);
	xs =  workbook.getSheetAt(0);
	rows= xs.getPhysicalNumberOfRows();
    for (int i=0;i<rows;i++)
    {
    regnumdetails.add((xs.getRow(i).getCell(0).getStringCellValue()));    
    }
	return regnumdetails;		
    }
     
	//Reading Excel to fetch Colour , that is the column 2, for all the rows in test data- File_1.xlsx
	public ArrayList<String> read_get_expeccolour() throws IOException
	{
		rows= xs.getPhysicalNumberOfRows();
	    for (int i=0;i<rows;i++)
	    {
	    	expectedcolourdetails.add((xs.getRow(i).getCell(2).getStringCellValue()));    
	    }
		return expectedcolourdetails;		
    }
	}
               
  
	
 
