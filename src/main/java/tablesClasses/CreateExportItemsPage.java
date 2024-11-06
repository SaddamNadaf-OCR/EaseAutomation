package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateExportItemsPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//------------------------------------------Locators-----------------------------------------------------------------//
	
	public static final String OCR_ControllingAgency = "(//a[contains(text(),'Controlling Agency')])[3]";
	public static final String OCR_ECCN = "//input[@name='productClazz.prodClassification']";
	public static final String OCR_Descriptions = "//textarea[@name='productClazz.description']";
	public static final String OCR_Save = "//button[@name='save']";
	public static final String OCR_SaveandReturn = "//button[@name='ok']";
	public static final String OCR_SelectBtn = "//button[@name='Ok']";
	public static final String OCR_CloseBtn="(//button[@class='btn-close'])[1]";
		
// -------------------------------------------Constructor-----------------------------------------//

	public CreateExportItemsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

//--------------------------Code------------------------------------------------//
	public void enter_ExportItemsCode(String ECCN, String Descriptions) {
		
		
		typeText(driver, test, OCR_ECCN, "enter ECCN", ECCN);
		typeText(driver, test, OCR_Descriptions, "enter Descriptions", Descriptions);

		}
	public void Add_ControllingAgencyButton() {
	clickElement(driver, test, OCR_ControllingAgency, "click on add ControllingAgency button");
	Wait.waitfor(3);
	}
	public void Add_ControllingAgency(String ControllingAgency) {
		clickElement(driver, test, OCR_ControllingAgency, "click on add ControllingAgency button");
		Wait.waitfor(3);
		String addCA = "//table[@id='gridPopup']/tbody/tr/td[contains(text(),'" + ControllingAgency + "')]";
		try {
			if (isDisplayed(driver, addCA)) {
				clickElement(driver, test, addCA, "Click on search record");
				test.log(LogStatus.PASS, "Add country grp code in add to result grid table : " + ControllingAgency);
				select();
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add country grp code in result grid table : " + ControllingAgency);
			clickElement(driver, test, OCR_CloseBtn, "Click on POP up close Icon");
		}}
	public void select() {
		// TODO Auto-generated method stub
		clickElement(driver, test, OCR_SelectBtn, "Clicking on Select Button");
	}

// --------------------------------Save--------------------------------------------//

		public void save() {
			scrollToElement(driver, OCR_Save);
			Wait.waitfor(3);
			scrollToTop(driver);
			clickElement(driver, test, OCR_Save, "Click on Save Button ");
		}
	// -------------------------------------SaveandReturn---------------------//

		public void saveandReturn() {
			scrollToElement(driver, OCR_SaveandReturn);
			Wait.waitfor(3);
			scrollToTop(driver);
			clickElement(driver, test, OCR_SaveandReturn, "Click on Save Button ");
		}



}
