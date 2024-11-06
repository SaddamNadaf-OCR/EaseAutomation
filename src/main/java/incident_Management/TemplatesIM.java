package incident_Management;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class TemplatesIM extends GenericMethods{
	public WebDriver driver;
	public ExtentTest test;
	
	public static final String Temp_Search="//button[contains(text(),'Select')]";
	public static final String Temp_Add="//button[contains(text(),'New')]";
	public static final String Temp_Cancel="//button[contains(text(),'Cancel')]";
	
	public TemplatesIM(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public void searchTemplate() {
		clickElement(driver, test, Temp_Search, "Clicking on Search Tab");
	}
	
	public void addTemplate() {
		clickElement(driver, test, Temp_Add, "Clicking on Add Template Tab");
	}
	
	public void cancelTemplate() {
		clickElement(driver, test, Temp_Cancel, "Clicking on Cancel Tab");
	}
	public void template(String templateName) {
		clickElement(driver, test, "//option[contains(text(),'"+templateName+"')]", "Add Template :"+templateName);
	}

}

