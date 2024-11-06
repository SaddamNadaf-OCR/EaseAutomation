package productClasses;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewHazmatPage extends GenericMethods{

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_Hazmat = "//input[@id='editProductHazmat_hazmatCheck']";
	public static final String OCR_OCRHazmatId = "//a[contains(text(), 'OCR Hazmat ID')]";
	public static final String OCR_Button_Search = "//button[contains(text(),'Search')]";
	public static final String OCR_Button_Select = "//button[contains(text(),'Select')]";
	public static final String OCR_FlashPointTemp = "//input[@id='editProductHazmat_productHazmat_flashPointTemperature']";
	public static final String OCR_ContactName = "//input[@id='editProductHazmat_productHazmat_hazmatContactName']";
	public static final String OCR_Phone ="//input[@id='editProductHazmat_productHazmat_hazmatContactPhone']";
	public static final String OCR_Save = "//button[@id='mybuttonsmall']";
	public static final String OCR_HazIdInput="//input[@id='editProductHazmat_productHazmat_hazmatCode']";
	public static final String OCR_IATApacking="//font [contains (text(),'IATA Packing Instructions')]";
	public static final String OCR_hazIDiata="//input[@id='editProductHazmat_prodIataHazmat_hazmatCode']";
public static final String OCR_IATAflashtemp="//input[@id='editProductHazmat_prodIataHazmat_flashPointTemperature']";
public static final String OCR_iATAcontactname="//input[@id='editProductHazmat_prodIataHazmat_hazmatContactName']";
public static final String OCR_iataContactphone="//input[@id='editProductHazmat_prodIataHazmat_hazmatContactPhone']";
	
	/* ******************** Constructor ***************************** */
	public CreateNewHazmatPage(WebDriver driver, ExtentTest test) { 
		this.driver = driver;
		this.test = test;
	}
	
	// Add Hazmat is Added to the Result grid or not
	public void addhazmatToResultsGrid(String HazmatId) {
		Wait.waitfor(3);
		try {
			search();
			String addhazmat = "//table[@id='gridPopup']/tbody/tr/td[1]";
			if (isDisplayed(driver, addhazmat)) {
				clickElement(driver, test, addhazmat, "Click on add hazardous material");
				test.log(LogStatus.PASS, "Add Hazmat in add to result grid table : " + HazmatId);
				select();
			}}

		 catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add Hazmat in result grid table : " +  HazmatId);
			clickElement(driver, test, "(//button[@class='btn-close'])[1]", "click on close button");
		}
	}
  
	public void enter_flashpointtemp(String FlashPointTemp) {
		typeText(driver, test, OCR_FlashPointTemp, "Enter Flash Point Temperature",FlashPointTemp);
	}
	
	public void enter_contactname(String HazContactName) {
		typeText(driver, test, OCR_ContactName, "Enter Contact Name", HazContactName);
	}
	
	public void enter_phone(String HazPhone) {
		typeText(driver, test, OCR_Phone, "Enter Phone No: ",HazPhone);
	}
	
	public void search() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_Search,"Clicking on Search button");
	}
	
	public void select() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_Select,"Clicking on Select button");
		Wait.waitfor(3);
	}
	
	public void click_hazmat() {
		clickElement(driver, test, OCR_Hazmat,"Clicking on hazardous material ");
	}
	
	public void click_ocrhazmatid() {
		clickElement(driver, test, OCR_OCRHazmatId,"Clicking on OCR Hazmat ID");
	}
	
	public void save() {
		Wait.waitfor(3);
		scrollToElement(driver, OCR_Save);
		scrollToTop(driver);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Save,"Clicking on Save Button");
	}
	
	public void movetodocumenttab(){
		clickElement(driver, test, "//a[@id='tab6']","Clicking on Document tab");
		
	}
	public void HazIdInput(String HazIdInput) {
		typeText(driver, test, OCR_HazIdInput, "add hazamat id ", HazIdInput);
	}
	public void scrolltoIATApacking(String IATAHazId, String IATAFlahTemp, String IATAContactname, String IATAcontactphone) {
		scrollToElement(driver, OCR_IATApacking);
		Wait.waitfor(2);
		typeText(driver, test, OCR_hazIDiata, "Enter IATA hazmat ID", IATAHazId);
		typeText(driver, test, OCR_IATAflashtemp, "enter flash point temperatre for IATA", IATAFlahTemp);
		typeText(driver, test, OCR_iATAcontactname, "enter contact name for IATA", IATAContactname);
		typeText(driver, test, OCR_iataContactphone, "enter contact phone fo IATA", IATAcontactphone);
		Wait.waitfor(2);
		scrollToTop(driver);
	}
}
