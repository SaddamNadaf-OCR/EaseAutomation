package crsClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class FTTravelInfoCompanyPage extends GenericMethods{

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_Button_AddCompany = "//button[@id='addCompanyId']";
	public static final String OCR_CompanyCode = "//a[contains(text(),'Company Code')]";
	public static final String OCR_VendorOrConsigneeId ="//input[@id='searchForm_userDTO_userCode']";
	public static final String OCR_Button_Search ="//button[contains(text(), 'Search')]";
	public static final String OCR_SearchRecord ="//table[@id='gridPopup']/tbody/tr[2]";
	public static final String OCR_Button_Select ="//button[contains(text(), 'Select')]";
	public static final String OCR_Button_SaveandReturn ="//button[contains(text(), 'Save & Return')]";
	public static final String OCR_Button_T_AddParty ="//button[@id='addPartyId2']";
	public static final String OCR_Select_ThirdCountry ="//select[@id='totalCountryList']";
	public static final String OCR_Button_MoveRight= "//button[@name='move-right']";
	public static final String OCR_ForeignPartyType ="//select[@id='editAgreementTcdn_agreementTcdnValue_foreignPartyType']";
	public static final String OCR_WLSStatus="//select[@id='editForeignTravelCompany_foreignTravelCompanyValue_dplStatus']";
	public static final String OCR_DetailHits ="//a[contains(text(),'Detail Hits')]";
	public static final String OCR_Button_Override ="//button[contains(text(),'Override')]";
	public static final String OCR_Button_Save ="//button[contains(text(),'Save')]";
	public static final String OCR_Button_DRMSave ="//body/div[4]/div[1]/form[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]";
	public static final String OCR_Button_ForwardNavigation = "//button[@id='next-btn']";
	
	/* ******************************** Constructor ******************************** */
		public FTTravelInfoCompanyPage(WebDriver driver, ExtentTest test) {
			// TODO Auto-generated constructor stub
			this.driver = driver;
			this.test = test;
		}
		//Click on Add Company Button:
		public void addcompany() {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath(OCR_Button_AddCompany)));
			//clickElement(driver, test, OCR_Button_AddCompany," Click on Add Company Button: ");
		}
		
		//Select Company from Company code
		public void enter_CompanyCode(String ConsigneeId) {
			clickElement(driver, test, OCR_CompanyCode, "Clicking on Company Code link: ");
			typeText(driver, test, OCR_VendorOrConsigneeId, "Entering Consignee Id: ", ConsigneeId);
			clickElement(driver, test, OCR_Button_Search, "Search record");
			Wait.waitfor(3);
			clickElement(driver, test, OCR_SearchRecord, "Select Searched record");
			clickElement(driver, test,  OCR_Button_Select, "Click on Select Button");
			Wait.waitfor(3);
			clickElement(driver, test, OCR_Button_SaveandReturn, "Clicking on Save Button");
			Wait.waitfor(3);		
			/*if(getSelectFirstText(driver, test, OCR_WLSStatus, "Getting the first selected value : ").contains("On Hold")) {
				overrideparty();
			}*/
		}
		
		//Override On Hold Parties
		public void overrideparty() {
			clickElement(driver, test, OCR_DetailHits, "Clicking on Detail Hits");
			Wait.waitfor(5);
			try {
				clickElement(driver, test, OCR_Button_Override,"Clicking on Override Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
			}

			Wait.waitfor(5);
			WebElement searched_record= driver.findElement(By.xpath("//div[@class='ocr-modal-base']//tr[4]//td[1]/input"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript ("arguments[0].click();" , searched_record);
			Wait.waitfor(7);
			clickElement(driver, test, OCR_Button_DRMSave,"Clicking on Save Button");
		}
		//Click on Save and Return Button
		public void saveandreturn() {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath( OCR_Button_SaveandReturn)));
			Wait.waitfor(3);
			clickElement(driver, test, OCR_Button_SaveandReturn,"Clicking on Save and Return Button");	
			Wait.waitfor(3);
		}
		//Click on Forward Button
		public void moveForward() {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath(OCR_Button_ForwardNavigation)));
		} 
		
		public void validateFTRCompanyError() {
			try {
				if (isDisplayed(driver,"//h4[contains(text(),'Error')]")) {				

					if (isDisplayed(driver,"//li[contains(text(),'Address is Required.')]")) {
						test.log(LogStatus.INFO, "Address is Required. ");
					}
					if (isDisplayed(driver,"//li[contains(text(),'City is Required.')]")) {
						test.log(LogStatus.INFO, "City is Required.");
					}
					if (isDisplayed(driver,"//li[contains(text(),'Country is Required.')]")) {
						test.log(LogStatus.INFO, "Country is Required.");
					}
					if (isDisplayed(driver,"//li[contains(text(),'Company Name is Required.')]")) {
						test.log(LogStatus.INFO, "Company Name is Required.");
					}
					
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Error Validation is not Displayed by clicking on SAVE button in Travel Info Company Page");					
			}
		}
		
		//Click on Status lable
		public void statusLabel() {
			clickElement(driver, test, "//span[@class='status']", "");
		}
}
