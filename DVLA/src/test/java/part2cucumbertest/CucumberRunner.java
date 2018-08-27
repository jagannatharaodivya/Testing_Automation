//Cucumber Runner class to Run

package part2cucumbertest;


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

	
	 
	@RunWith(Cucumber.class)
	@CucumberOptions(
			features="src/test/java/Features/V.feature",
			glue="",plugin="html:target|selenium-reports")
	public class CucumberRunner 
	{
}
