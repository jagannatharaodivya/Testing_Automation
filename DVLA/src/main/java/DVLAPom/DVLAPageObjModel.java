
/*Author-Divya Jagannatha Rao
 * Implementing Page Object Model for DLVA website
 * Creating a Class which represents a page,  for all the necessary web elements and methods
 * Initializing the Web Elements using Page Factory when we use this Page object
 */

package DVLAPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import excelUtil.ReadExcel;

public class DVLAPageObjModel 

{
	
	static String url ;
	static WebDriver driver;
	static String chromedriverpath;
	static String dir;
	static ReadExcel rd ;
	
	@FindBy(how= How.LINK_TEXT,using="Start now")
	public WebElement Startnowbutton;
	
	@FindBy(how=How.ID,using="Vrm")
	public WebElement Regnumtextbox;
	
	
	@FindBy(how=How.NAME,using="Continue")
	public WebElement Continuebtn;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"pr3\"]/div/ul/li[3]/span[2]/strong")
	public WebElement Colour;
	
	@FindBy(how=How.LINK_TEXT,using="Back")
	public WebElement Backbutton;
	
	public void clickstartnow()
	{
		Startnowbutton.click();
	}
	
	public void clickcontinue()
	{
		Continuebtn.click();
	}
	public boolean isdisplayed()
	{
		return Colour.isDisplayed();
	}
	
	public String getcolour()
	{
		
		return Colour.getText().toString();
		
	}
	
	

}
