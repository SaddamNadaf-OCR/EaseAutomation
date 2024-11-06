package crsClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class AgreementReqUSPartiesPage extends GenericMethods{

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_Button_ForwardNavigation = "//button[@id='next-btn']";
	public static final String OCR_Button_U_AddParty = "//button[@id='addPartyId']";
	public static final String OCR_USPartyCode = "//a[@id='usPartyCodeHREFId']";
	public static final String OCR_Code ="//input[@name='userDTO.userCode']";
	public static final String OCR_Button_Search ="//button[contains(text(),'Search')]";
	public static final String OCR_SearchRecord ="//table[@id='gridPopup']/tbody/tr[2]";
	public static final String OCR_Button_Select ="//button[contains(text(),'Select')]";
	public static final String OCR_Button_SaveandReturn ="//button[contains(text(),'Save & Return')]";
	public static final String OCR_ScreeningStatus="//select[@name='dplStatus1']";
	public static final String OCR_DetailHits ="//a[contains(text(),'Detail Hits')]";
	public static final String OCR_Button_Override ="//button[contains(text(),'Override')]";
	public static final String OCR_Button_Save ="//button[contains(text(),'Save')]";
	public static final String OCR_Button_DRMSave ="(//button[contains(text(),'Save')])[3]";
	public static final String OCR_DocumentTab ="//a[contains(text(), 'Documents/Notes')]";
	public static final String OCR_USpartyGrid = "(//tr[@id='1'])[1]";
	
  
	
	public AgreementReqUSPartiesPage(WebDriver driver, ExtentTest test) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.test = test;
	}
	
	//Add Party
	public void addParty() {		
	clickElement(driver, test, OCR_Button_U_AddParty,"Clicking on Add Party Button: ");	
	}
	
	// Click on Add Party Button and Add US Party
	public void selectUSParty(String Code) {
		clickElement(driver, test, OCR_USPartyCode, "Clicking on US Party Code link: ");
		Wait.waitfor(3);
		typeText(driver, test, OCR_Code,"Enter Code: ", Code);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_Search, "Clicking on Search Button: ");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_SearchRecord,"Selecting searched record: ");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_Select, "Clicking on Search Record: ");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_Save, "Clicking on Save Button");
		Wait.waitfor(3);
		
        System.out.println(getSelectFirstText(driver, test, OCR_ScreeningStatus, "Getting the first selected value"));
	
		if(getSelectFirstText(driver, test, OCR_ScreeningStatus, "Getting the first selected value").contains("On Hold")) {
			overrideparty();
		}
	}
	
	//Click on Save and Return Button
	public void saveandreturn() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_SaveandReturn, "Clicking on Save and Return Button: ");
	}
	
	//US Party Grid is Displayed
	public void usPartyGridisDisplayed() {
		try {
			if(isDisplayed(driver, OCR_USpartyGrid)) {
				test.log(LogStatus.PASS, "US Party is Displayed in Grid :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "US Party is Not Displayed in Grid :");
		}
	}
	
	//Overriding On Hold Parties
	public void overrideparty() {
	clickElement(driver, test, OCR_DetailHits, "Clicking on Detail Hits :");
	Wait.waitfor(7);
	clickElement(driver, test, OCR_Button_Override,"Clicking on Override Button :");
	Wait.waitfor(5);
	WebElement searched_record= driver.findElement(By.xpath("//div[@class='ocr-modal-base']//tr[4]//td[1]/input"));
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	executor.executeScript ("arguments[0].click();" , searched_record);
	Wait.waitfor(7);
	clickElement(driver, test, OCR_Button_DRMSave,"Clicking on Save Button :");

	}
	
	//Click on Forward Button
	public void moveForward() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath(OCR_Button_ForwardNavigation)));
	} 
   
	//Click on Save Button
   public void save() {
		
		clickElement(driver, test, OCR_Button_Save, "Clicking on Save Button: ");
	}
	
   //Click on Document Tab
	public void movetoDocumentTab() {
		clickElement(driver, test, OCR_DocumentTab, "Move to Document Tab: ");
		
	}
	
	//Validating US Parties error
	public void validate_USPartiesError() {
		try {
			if (isDisplayed(driver,"//h4[contains(text(),'Error')]")) {				

				if (isDisplayed(driver,"//li[contains(text(),'Please Enter Party Name ')]")) {
					test.log(LogStatus.INFO, "Please Enter Party Name");
				}

				if (isDisplayed(driver,"//li[contains(text(),'Please Enter Address')]")) {
					test.log(LogStatus.INFO, "Please Enter Address");
				}
				if (isDisplayed(driver,"//li[contains(text(),'Please Enter City')]")) {
					test.log(LogStatus.INFO, "Please Enter City");
				}
				if (isDisplayed(driver,"//li[contains(text(),'Please Enter Country')]")) {
					test.log(LogStatus.INFO, "Please Enter Country");
				}
			}
		}
			 catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Error Vaildation is not Displayed by clicking on SAVE button in US Parties Page");					
			}
		}	
			
		
	}

