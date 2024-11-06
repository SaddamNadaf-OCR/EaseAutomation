package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class ShipmentTemplatePage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_ShipmentTemplatePage_AddorderTemplateBtn  = "//button[@class='primary-btn ocr-cache-search-dynamic-class']";
	public static final String OCR_ShipmentTemplatePage_CopyIcon = "(//i[@class='fa fa-copy'])[1]";
	public static final String OCR_ShipmentTemplatePage_DeleteIcon = "(//i[@class='fa fa-trash-o'])[1]";
	
	/* ******************************* Constructor ****************************** */

	public ShipmentTemplatePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	
	public void addShipmentTemplateBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_ShipmentTemplatePage_AddorderTemplateBtn, "CLick on Add Shipment Template Button :");
	}
	
	public void copyTemplate() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_ShipmentTemplatePage_CopyIcon, "Click on Copy Template icon : ");
	}
	
//	public void copyAlertMsg() {
//		Wait.waitfor(2);
//		clickElement(driver, test, "//span[contains(text(),'Proceed to Copy without Invalid data')]", "Click on Proceed to copy without invalid data!");
//		
//	}
	
	public void deleteTemplate() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_ShipmentTemplatePage_DeleteIcon, "CLick on Delete icon to delete a template : ");
	}
	
	

}
