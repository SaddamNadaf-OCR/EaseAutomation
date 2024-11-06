package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class EditDeliveryOrderItemsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_EditDO_AddItem = "//button[contains(text(),'Add Item')]";

	/* ******************************* Constructor ****************************** */

	public EditDeliveryOrderItemsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	//click on Add Item
	public void clickAddItem() {
		clickElement(driver, test, OCR_EditDO_AddItem, "Click on Add Item");
	}

}
