package productClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class ProductTemplatePage extends GenericMethods{


	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_SBUCode="//select[@id='searchProduct_product_sbuCode']";
	public static final String OCR_SourceSysPartNo ="//input[@id='searchProduct_product_sourceProductId']";
	public static final String OCR_Blank ="//button[contains(text(),'Blank')]";
	public static final String OCR_Select ="//button[contains(text(),'Select')]";
	public static final String OCR_Cancel ="//button[contains(text(),'Cancel')]";
	
	/* ******************** Constructor ***************************** */
	public ProductTemplatePage(WebDriver driver, ExtentTest test) { 
		this.driver = driver;
		this.test = test;
	}

	public void click_blank() {
		// TODO Auto-generated method stub
		clickElement(driver, test, OCR_Blank, "Click on Blank Button");
	}
	
	

}
