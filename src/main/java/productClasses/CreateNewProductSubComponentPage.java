package productClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewProductSubComponentPage extends GenericMethods{

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_Button_SubCompPartNo = "//a[contains(text(),'Sub-Component Part No')]";
	public static final String OCR_Button_Search = "//button[contains(text(),'Search')]";
	public static final String OCR_Button_Select = "//button[contains(text(),'Select')]";
	public static final String OCR_QuantCalcMethod ="//select[@id='editProductSubComponent_productSubComponent_quantityCalcMetod']";
	public static final String OCR_QuantUsed = "//input[@id='editProductSubComponent_productSubComponent_quantityUsed']" ;
	public static final String OCR_QuantApp = "//input[@id='editProductSubComponent_productSubComponent_quantityAppearing']";
	public static final String OCR_WasteQuant = "//input[@id='editProductSubComponent_productSubComponent_quantityWaste']";
	public static final String OCR_QuantPerItem = "//input[@id='editProductSubComponent_quantity']";
	public static final String OCR_Button_Save = "//button[@name='save.x']";
	public static final String OCR_Button_SavendReturn = "//button[contains(text(),'Save & Return')]";
	public static final String OCR_SubcompPartNo="//a[contains(text(),'Sub-Component Part No')]";

	/* ******************** Constructor ***************************** */
	public CreateNewProductSubComponentPage(WebDriver driver, ExtentTest test) { 
		this.driver = driver;
		this.test = test;
	} 

	public void click_subcomppartno() {	
		clickElement(driver, test, "//button[contains(text(),'Add Product Sub Component')]", "click on add part no");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_SubCompPartNo ,"Click on Sub Component Part No");	
	}

	public void search() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_Search,"Click on Search Button: ");	
	}

	public void select() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_Select,"Click on Search Button: ");	
		Wait.waitfor(3);
	}

	// Add Subcomponent Part No is Added to the Result grid or not
	public void addsubcomppartnoToResultsGrid(String SubCompPartNo) {
		Wait.waitfor(3);
		String addspartno = "//table[@id='gridPopup']/tbody/tr/td[contains(text(),'" +SubCompPartNo + "')]";
		try {
			typeText(driver, test, "//input[@id='searchForm_product_productCode']", "Enter the Sub Comp Part No : ", SubCompPartNo);
			search();
			if (isDisplayed(driver, addspartno)) {
				clickElement(driver, test, addspartno, "Click on search record");
				test.log(LogStatus.PASS, "Add Sub Component Part No in add to result grid table : " + SubCompPartNo);
				select();
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add FlagReason in result grid table : " +  SubCompPartNo);
		}
	}

	public void select_quantitycalcmethod(String QuantCalcMethod) {
		selectByVisibleText(driver, test, OCR_QuantCalcMethod,"Select Quantity Calculated Method", QuantCalcMethod);
	}
	
	public void enter_quantused(String QuantityUsed) {
		typeText(driver, test,OCR_QuantUsed,"Quantity Used", QuantityUsed);
	}

	public void enter_quantapp(String QuantityAppearing) {
		typeText(driver, test,OCR_QuantApp,"Quantity Used", QuantityAppearing);
	}

	public void save() {
		clickElement(driver, test, OCR_Button_Save,"Click on Save Button: ");	
		Wait.waitfor(3);
	}

	public void savendreturn() {
		clickElement(driver, test, OCR_Button_SavendReturn,"Click on Save and Return Button: ");	
		Wait.waitfor(3);
	}

	public void validate_subcomperror() {
		try {
			if (isDisplayed(driver,"//h4[contains(text(),'Error')]")) {				

				if (isDisplayed(driver,"//li[contains(text(),'Please select a Product  for Subcomponent')]")) {
					test.log(LogStatus.INFO, "Please select a Product  for Subcomponent");
				}
				if (isDisplayed(driver,"//li[contains(text(),'Please select Quantity Calc Method')]")) {
					test.log(LogStatus.INFO, "Please select Quantity Calc Method");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Validation is not Displayed by clicking on SAVE button in Sub - Component Page");					
		}
	}
	
	public void click_partno() {
		clickElement(driver, test, OCR_SubcompPartNo,"Click on Part No Link: ");
	}
		
	}

