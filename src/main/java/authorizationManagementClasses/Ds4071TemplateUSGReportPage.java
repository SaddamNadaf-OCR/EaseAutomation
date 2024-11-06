package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class Ds4071TemplateUSGReportPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//...................................Locators.......................................//
	public static final String DS4071Temp_Submit="//button[contains(text(),'Submit')]";
	public static final String DS4071Temp_New="//button[contains(text(),'New')]";
	public static final String DS4071Temp_Cancel="//button[contains(text(),'Cancel')]";
	public static final String DS4071Temp_SelectTemplate="//select[@id='createNewDs4071_templateId']";
	
	//.................................Constructor.....................................//
	public Ds4071TemplateUSGReportPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;		
	}
	
	//.......................Click on Submit Button.............................//
	public void search(String template) {
		selectByVisibleText(driver, test, DS4071Temp_SelectTemplate, "Selecting Template from Dropdown", template);
		Wait.waitfor(3);
		clickElement(driver, test, DS4071Temp_Submit, "Clicking on Search Tab");
	}
	
	//..........................Click on New Template............................//
	public void newTemp() {
		clickElement(driver, test, DS4071Temp_New, "Clicking on New Template");
	}
	
	//........................Click on cancel Button............................//
	public void cancel() {
		clickElement(driver, test, DS4071Temp_Cancel, "Clicking on Cancel Button");
	}
}
