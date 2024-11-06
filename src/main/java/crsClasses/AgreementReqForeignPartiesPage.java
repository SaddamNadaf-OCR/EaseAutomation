package crsClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class AgreementReqForeignPartiesPage extends GenericMethods{

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_Button_ForwardNavigation = "//button[@id='next-btn']";
	public static final String OCR_Button_F_AddParty ="//button[@id='addPartyId']";
	public static final String OCR_ConsigneeCode ="//a[contains(text(), 'Consignee Code')]";
	public static final String OCR_VendorOrConsigneeId ="//input[@id='searchForm_userDTO_userCode']";
	public static final String OCR_Button_Search ="//button[contains(text(), 'Search')]";
	public static final String OCR_SearchRecord ="//table[@id='gridPopup']/tbody/tr[2]";
	public static final String OCR_Button_Select ="//button[contains(text(), 'Select')]";
	public static final String OCR_Button_SaveandReturn ="//button[contains(text(), 'Save & Return')]";
	public static final String OCR_Button_T_AddParty ="//button[@id='addPartyId2']";
	public static final String OCR_Select_ThirdCountry ="//select[@id='totalCountryList']";
	public static final String OCR_Button_MoveRight= "//button[@name='move-right']";
	public static final String OCR_ForeignPartyType ="//select[@id='editAgreementTcdn_agreementTcdnValue_foreignPartyType']";
	public static final String OCR_ScreeningStatus="//select[@name='dplStatus1']";
	public static final String OCR_DetailHits ="//a[contains(text(),'Detail Hits')]";
	public static final String OCR_Button_Override ="//button[contains(text(),'Override')]";
	public static final String OCR_Button_Save ="//button[contains(text(),'Save')]";
	public static final String OCR_Button_DRMSave ="//body/div[4]/div[1]/form[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]";
	public static final String OCR_ForeignPartyGrid = "//body/div[@id='content-cont']/form[@id='createUpdateExportRequestAgg']/div[3]/div[1]/div[6]/div[1]/fieldset[1]/div[2]/div[1]";
	public static final String OCR_ThirdPartyGrid = "//div[@id='gbox_grid']";

	public AgreementReqForeignPartiesPage(WebDriver driver, ExtentTest test) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.test = test;
	}
	//Add Foreign Party
	public void addForeignParty() {
		clickElement(driver, test, OCR_Button_F_AddParty, "Clicking on Add Party Button");
	}
	//Slect Consignee from Consignee code
	public void enter_ConsigneeCode(String ConsigneeId) {
		clickElement(driver, test, OCR_ConsigneeCode, "Clicking on Consignee Code link: ");
		typeText(driver, test, OCR_VendorOrConsigneeId, "Entering Consignee Id: ", ConsigneeId);
		clickElement(driver, test, OCR_Button_Search, "Search record");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_SearchRecord, "Select Searched record");
		clickElement(driver, test,  OCR_Button_Select, "Click on Select Button");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_Save, "Clicking on Save Button");
		Wait.waitfor(3);		
		System.out.println(getSelectFirstText(driver, test, OCR_ScreeningStatus, "Getting the first selected value"));
		if(getSelectFirstText(driver, test, OCR_ScreeningStatus, "Getting the first selected value").contains("On Hold")) {
			overrideparty();
		}
	}
	
	//Foreign Party is Displayed in Grid
	public void foreignPartyGridisDisplayed() {
		try {
			if(isDisplayed(driver, OCR_ForeignPartyGrid)) {
				test.log(LogStatus.PASS, "Added Foreign Party is Displaying in Grid :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Added Foreign Party is Not Displayed in Grid :");
		}
	}
	//Click on Save and Return Button
	public void saveandreturn() {
		clickElement(driver, test, OCR_Button_SaveandReturn,"Clicking on Save and Return Button");		
	}

	//Click on add Third Party Button
	public void addThirdParty() {
		clickElement(driver, test, OCR_Button_T_AddParty, "Clicking on Add Party Button");
	}

	//Select Third Country
	public void selectthirdcountry(String FPartyType, String ThirdCountry) {
		selectByVisibleText(driver, test, OCR_ForeignPartyType, "Selecting Foreign Party Type: ",FPartyType );
		Wait.waitfor(3);
		selectByVisibleText(driver, test,  OCR_Select_ThirdCountry,"Selecting Third Country/Dual National: ",ThirdCountry);
	}
	
	//Third Party is Displayed in Grid
	public void thirdPartyGridisDisplayed() {
		try {
			if(isDisplayed(driver, OCR_ThirdPartyGrid)) {
				test.log(LogStatus.PASS, "Added Third Party is Displaying in Grid :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Added Third Party is Not Displayed in Grid :");
		}
	}
	//Override On Hold Parties
	public void overrideparty() {
		clickElement(driver, test, OCR_DetailHits, "Clicking on Detail Hits");
		Wait.waitfor(5);
		try {
			clickElement(driver, test, OCR_Button_Override,"Clicking on Override Button");
		} catch (Exception e) {
			// TODO: handle exception
		}

		Wait.waitfor(5);
		WebElement searched_record= driver.findElement(By.xpath("//div[@class='ocr-modal-base']//tr[4]//td[1]/input"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript ("arguments[0].click();" , searched_record);
		Wait.waitfor(7);
		clickElement(driver, test, OCR_Button_DRMSave,"Clicking on Save Button");
	}
	//Validate Foreign Parties TaB
	public void validate_ForeignPartiesError(){
		try {
			if (isDisplayed(driver,"//h4[contains(text(),'Error')]")) {				

				if (isDisplayed(driver,"//li[contains(text(),'Please Enter Consignee Name')]")) {
					test.log(LogStatus.INFO, "Please Enter Consignee Name");
				}
				if (isDisplayed(driver,"//li[contains(text(),'Please Enter Consignee Address1')]")) {
					test.log(LogStatus.INFO, "Please Enter Consignee Address1");
				}
				if (isDisplayed(driver,"//li[contains(text(),'Please Enter Consignee City')]")) {
					test.log(LogStatus.INFO, "Please Enter Consignee City");
				}
				if (isDisplayed(driver,"//li[contains(text(),'Please Enter Consignee Country')]")) {
					test.log(LogStatus.INFO, "Please Enter Consignee Country ");
				}
			}
		}
		catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Vaildation is not Displayed by clicking on SAVE button in Foreign Parties Page");					
		}
	}	
	//Validate Third Country
	public void validate_thirdCountryError() {
		try {
			if (isDisplayed(driver,"//h4[contains(text(),'Error')]")) {				

				if (isDisplayed(driver,"//li[contains(text(),'Select a Foreign Party Type Before Save')]")) {
					test.log(LogStatus.INFO, "Select a Foreign Party Type Before Save ");
				}

			}
		}
		catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Vaildation is not Displayed by clicking on SAVE button in Add Third Country Page");					
		}
	}	


	//Click on Right Navigation Button
	public void moveright() {
		clickElement(driver, test, OCR_Button_MoveRight, "Clicking on Right Button: ");
	}
	//Click on Forward Button
	public void moveForward() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath(OCR_Button_ForwardNavigation)));
	} 
	//Click on Save Button
	public void save() {
		clickElement(driver, test, OCR_Button_Save,"Clicking on Save and Return Button");		
	}
}
