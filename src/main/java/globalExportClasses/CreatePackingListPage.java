package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class CreatePackingListPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_CreatePackingListPage_CreatePackingListBtn = "//button[contains(text(),'Create Packing List')]";
	
	
	
	/* ******************************* Constructor ****************************** */

	public CreatePackingListPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	
	public void create_packingList() {
		clickElement(driver, test, OCR_CreatePackingListPage_CreatePackingListBtn, "Click on Create Packing List Button");
	}

}
