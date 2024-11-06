package productClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class ResultProductManufacturerPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_Button_AddProductManufacturer = "//button[@id='btnAddProdManufacturer']";
	
			
	/* ******************** Constructor ***************************** */
	public ResultProductManufacturerPage(WebDriver driver, ExtentTest test) { 
		this.driver = driver;
		this.test = test;
	}
	
	public void click_productmanufacturer() {
		clickElement(driver, test,OCR_Button_AddProductManufacturer,"Click on Add Product Manufacturer");
	}
	

	
	

}
