package productClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class ResultProductImagePage extends GenericMethods{

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_Button_AddImage = "//button[contains(text(),'Add Image')]";


	/* ******************** Constructor ***************************** */
	public ResultProductImagePage(WebDriver driver, ExtentTest test) { 
		this.driver = driver;
		this.test = test;
	}

	public void addimage() {
		clickElement(driver, test, OCR_Button_AddImage, "Clicking on Add Image ");
	}
}
