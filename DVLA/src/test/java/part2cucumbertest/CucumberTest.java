package part2cucumbertest;

/*Author-Divya Jagannatha Rao
 * Implementing Java glue code for the feature file V.feature
 */

import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DVLAPom.DVLAPageObjModel;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import excelUtil.ReadExcel;

public class CucumberTest
{
	 ReadExcel rd = new ReadExcel();
	 ArrayList<String> expected_colour_details = new ArrayList<String>();
	 ArrayList<String> actualcolourdetails = new ArrayList<String>(); 
	 ArrayList<String> regnum_details = new ArrayList<String>();
	 WebDriver driver;
	 DVLAPageObjModel page ;
	 String chromedriverpath ;
	 String dir;
	 String url = "https://www.gov.uk/get-vehicle-information-from-dvla";
	 int rows;
	 PrintWriter writer;
	 
	 //Cucumber Hooks for setting up Test data File -File_1.xlsx.
	 @Before
	 public void driversetup() throws FileNotFoundException, UnsupportedEncodingException
	{
		    dir = System.getProperty("user.dir");
			String chromedriverpath = dir+"/src/test/java/Drivers/chromedriver";
			String filepath = dir+"/src/test/java/";
			System.setProperty("webdriver.chrome.driver", chromedriverpath);
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			writer= new PrintWriter(filepath+ "PART-2-OUTPUT", "UTF-8");
			writer.println("----------------------SETUP PROCESS-----------------------------");
			writer.println("Before Method Ran sucessfully");
			writer.println("Chrome Driver is setup");
			writer.println("---------------------------------------------------------");
	}
	@Given("^One single excel file having vehicle registration details considered as Test Data$")
	public void one_single_excel_file_having_vehicle_registration_details_considered_as_Test_Data() 
	{
		rd.setExcel();
		writer.println("----------------------STEP 1-----------------------------");
		writer.println("Test Data excel is setup and can be read");
		writer.println("---------------------------------------------------------");
		
	}

	@Given("^Check The excel file is not empty$")
	public void check_The_excel_file_is_not_empty() throws NullPointerException, FileNotFoundException, IOException
	{
		writer.println("----------------------STEP 2-----------------------------");
	   rows = rd.is_file_empty();
	   if(rows==0)
	   {
		  writer.println("Test Data Excel file is empty");
	   }
	   writer.println("Test Data Excel file is not empty");
	   writer.println("---------------------------------------------------------");
	}

	@Given("^I read the excel file line by line for data$")
	public void i_read_the_excel_file_line_by_line_for_data() throws IOException 
	{
		regnum_details = rd.read_get_regnum();
		writer.println("----------------------STEP 3-----------------------------");
		writer.println("Registration Details setup in Test data excel is");
		for(int i=0;i<regnum_details.size();i++)
		{
			writer.println("Actual Reg Num " + " " + i + " " + "->"+" "+regnum_details.get(i));
		}
		writer.println("---------------------------------------------------------");
		expected_colour_details = rd.read_get_expeccolour();
		for(int i=0;i<expected_colour_details.size();i++)
		{
			writer.println("Actual Vehicle Colour " + " " +i + " " +"->"+" "+expected_colour_details.get(i));
		}
		writer.println("---------------------------------------------------------");
		
	}

	@When("^I navigate to the DVLA website$")
	public void i_navigate_to_the_DVLA_website()
	{
		
		driver.get(url); 
		String currentWindow = driver.getWindowHandle();
        driver.switchTo().window(currentWindow);
        writer.println("----------------------STEP 4-----------------------------");
        writer.println("On DVLA Website");
        writer.println("---------------------------------------------------------");
	}

	@When("^I click on Start Now button$")
	public void i_click_on_Start_Now_button()
	{
		page = PageFactory.initElements(driver, DVLAPageObjModel.class);
		WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.gem-c-button.govuk-button.govuk-button--start")));
        page.clickstartnow();
        writer.println("----------------------STEP 5-----------------------------");
        writer.println("Clicked on Start Now button");
        writer.println("---------------------------------------------------------");
	}

	@When("^I enter Vehicle Regnumber in the text box followed by Clicking on Continue button$")
	public void i_enter_Vehicle_Regnumber_in_the_text_box_followed_by_Clicking_on_Continue_button() throws IOException
	{	
		writer.println("----------------------STEP 6 -----------------------------"); 
		for (int j = 0; j < regnum_details.size(); j++)				 
		 {
				 WebDriverWait wait = new WebDriverWait(driver, 10);
		         wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("Vrm"))));
				 page.Regnumtextbox.sendKeys(regnum_details.get(j));
				 
				 writer.println("Entering Reg data "+ regnum_details.get(j));
				 page.Continuebtn.click();
				 writer.println("Clicking Continue Button");
				 actualcolourdetails.add(page.getcolour());
				 page.Backbutton.click();
				 
		 }	 
		
	}

	

	@Then("^I validate the Vehicle information populated on the webpage against test data$")
	public void i_validate_the_Vehicle_information_populated_on_the_webpage_against_test_data()
	{
		writer.println("----------------------STEP 7 -----------------------------");
		Assert.assertEquals(expected_colour_details, actualcolourdetails);
	    writer.println("Asserted sucessfully that expected and actuals are same");
	    writer.println("Expected Information is like below");
	    writer.println("---------------------------------------------------------");
	    for(int i=0;i<expected_colour_details.size();i++)
	    {
	    	writer.println(expected_colour_details.get(i));
	    }
	    writer.println("---------------------------------------------------------");
	    writer.println("Actual Information is like below");
	    for(int i=0;i<expected_colour_details.size();i++)
	    {
	    	writer.println(actualcolourdetails.get(i));
	    }
	    writer.println("---------------------------------------------------------");
	}
//Tear down to close driver and printer object
@After
public void teardown()
{
	driver.quit();
	writer.close();
}
}
