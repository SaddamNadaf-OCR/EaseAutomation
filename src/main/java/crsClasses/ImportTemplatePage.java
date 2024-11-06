package crsClasses;


import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class ImportTemplatePage extends GenericMethods{
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_Template_NewReqBtn = "//button[contains(text(),'New Request')]";
	public static final String OCR_Template_SelectTemplate = "//select[@name='templateName']";
	public static final String OCR_Template_SelectBtn = "//button[contains(text(),'Select')]";

	/* ******************** Constructor ***************************** */

	public ImportTemplatePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Click on new Request
	public void click_NewRequest(){
		Wait.waitfor(2);
		clickElement(driver, test, OCR_Template_NewReqBtn, "Clicking on New Request button");
	}

	//Select the Template
	public void select_template(String selectTemplate) {
		selectByVisibleText(driver, test, OCR_Template_SelectTemplate, "Select the Template : ", selectTemplate);
	}

	// Click on Select button
	public void click_SelectBtn(){		
		clickElement(driver, test, OCR_Template_SelectBtn, "Clicking on Select button");
	}

}
