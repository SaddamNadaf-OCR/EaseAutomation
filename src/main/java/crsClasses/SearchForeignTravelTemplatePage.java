package crsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class SearchForeignTravelTemplatePage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//.........................................Locators................................................//
	public static final String FTR_Template_SearchButton = "//button[contains(text(),'Search')]";
	public static final String FTR_Template_ResetButton = "//button[contains(text(),'Reset')]";
	public static final String FTR_Template_AddTemplate = "//button[contains(text(),' Add Template')]";
	public static final String FTR_Template_SBU = "//select[@name='foreignTravelGeneralInfoValue.sbuCode']";
	public static final String FTR_Template_TemplateName = "//input[@name='foreignTravelGeneralInfoValue.templateName']";
	public static final String FTR_Template_RequestDateFrom = "//input[@name='travelDateFrom']";
	public static final String FTR_Template_RequestDateTo = "//input[@name='travelDateTo']";
	public static final String FTR_Template_RequesterName = "//input[@name='foreignTravelGeneralInfoValue.requesterName']";
	public static final String FTR_Template_Program = "(//a[contains(text(),'Program')])[2]";
	public static final String FTR_Template_ProgramCode = "//input[@name='programTab.programCode']";
	public static final String FTR_Template_SearchPopup = "(//button[@name='Search'])[2]";
	public static final String FTR_Template_SelectPopup = "(//button[@name='Ok'])[1]";
	public static final String FTR_Template_ClosePopup = "//button[@class='btn-close']";
	public static final String FTR_Template_ProgramTextBox = "//textarea[@name='foreignTravelGeneralInfoValue.program']";
	public static final String FTR_Template_Segment = "(//a[contains(text(),'Segment')])[2]";
	public static final String FTR_Template_SegmenTextBox = "//textarea[@name='foreignTravelGeneralInfoValue.segment']";
	public static final String FTR_Template_Site = "(//a[contains(text(),'Site')])[2]";
	public static final String FTR_Template_SiteTextBox = "//textarea[@name='foreignTravelGeneralInfoValue.site']";
	public static final String FTR_Template_ProductLine = "(//a[contains(text(),'Product Line')])[2]";
	public static final String FTR_Template_ProductLineTextBox = "//textarea[@name='foreignTravelGeneralInfoValue.prodLine']";
	public static final String FTR_Template_ProductFamily = "(//a[contains(text(),'Product Family')])[2]";
	public static final String FTR_Template_ProductFamilyTextBox = "//textarea[@name='foreignTravelGeneralInfoValue.prodFamily']";
	public static final String FTR_Template_SortBy = "//select[@name='sortBy']";
	public static final String FTR_Template_Direction = "//select[@name='direction']";
	public static final String FTR_Template_ResultPage = "//h3[@class='page-heading']";
	public static final String FTR_Template_RequiredByDate_Today = "//button[contains(text(),'Today')]";
	//...........................................Constructor....................................................//
	public SearchForeignTravelTemplatePage(WebDriver driver,ExtentTest test) {
		this.driver=driver;
		this.test=test;
	}
	
	//...................................Click on Search Button.......................................//
	public void Search() {
		clickElement(driver, test, FTR_Template_SearchButton, "Clicking on Search Button :");
	}
	
	//...................................Click on Reset Button.......................................//
	public void Reset() {
		clickElement(driver, test, FTR_Template_ResetButton, "Clicking on Reset Button :");
	}
	
	//...................................Click on Add Template button.................................//
	public void AddTemplateButton() {
		clickElement(driver, test, FTR_Template_AddTemplate, "Clicking on Add Template button :");
	}
	
	//...................................Search By Template button.................................//
	public void SearchByTemplatename(String Templatename) {
		typeText(driver, test, FTR_Template_TemplateName, "Entering Template Name :", Templatename);
	}
	
	//.................................Search By Parameters..........................................//
	public void SearchByParameters(String SBU, String TemplateName, String RequestDateFrom, String RequestDateTo, 
			String RequesterName, String Program, String Segment, String Site, String ProductLine, String ProductFamily, 
			String SortBy, String Direction) {
		
		selectByVisibleText(driver, test, FTR_Template_SBU, "Selecting SBU :", SBU);
		typeText(driver, test, FTR_Template_TemplateName, "Entering Template Name :", TemplateName);
		if(RequestDateFrom.length() > 0) {
			clickElement(driver, test, FTR_Template_RequestDateFrom, "Clicking on Requestor Date From");
			if (RequestDateFrom.contains("Today")) {
				clickElement(driver, test, FTR_Template_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Requestor Date From : ", RequestDateFrom);
				}
		}
		if(RequestDateTo.length() > 0) {
			clickElement(driver, test, FTR_Template_RequestDateTo, "Clicking on Requestor Date To");
			if (RequestDateTo.contains("Today")) {
				clickElement(driver, test, FTR_Template_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Requestor Date From : ", RequestDateTo);
				}
		}
		typeText(driver, test, FTR_Template_RequesterName, "Entering Requester Name :", RequesterName);
		if(Program.length() > 0) {
			clickElement(driver, test, FTR_Template_Program, "Clicking on Program Link :");
			try {
				typeText(driver, test, FTR_Template_ProgramCode, "Entering Program Code :", Program);
				clickElement(driver, test, FTR_Template_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Program+"')]", "Select Program From Grid :");
				clickElement(driver, test, FTR_Template_SelectPopup, "Clicking on Select Button :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, FTR_Template_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}
		if(Segment.length() > 0) {
			clickElement(driver, test, FTR_Template_Segment, "Clicking on Segment Link :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Segment+"')]", "Selecting Segment :");
				clickElement(driver, test, FTR_Template_SelectPopup, "Clicking on Select Button :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, FTR_Template_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}
		if(Site.length() > 0) {
			clickElement(driver, test, FTR_Template_Site, "Clicking on Site Link :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Site+"')]", "Selecting Site :");
				clickElement(driver, test, FTR_Template_SelectPopup, "Clicking on Select Button :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, FTR_Template_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}
		if(ProductLine.length() > 0) {
			clickElement(driver, test, FTR_Template_ProductLine, "Clicking on Product Line Link :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ProductLine+"')]", "Selecting Product Line :");
				clickElement(driver, test, FTR_Template_SelectPopup, "Clicking on Select Button :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, FTR_Template_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}
		if(ProductFamily.length() > 0) {
			clickElement(driver, test, FTR_Template_ProductFamily, "Clicking on Product Family Link :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ProductFamily+"')]", "Selecting Product Family :");
				clickElement(driver, test, FTR_Template_SelectPopup, "Clicking on Select Button :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, FTR_Template_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}
		selectByVisibleText(driver, test, FTR_Template_SortBy, "Selecting Sort By :", SortBy);
		selectByVisibleText(driver, test, FTR_Template_Direction, "Selecting Direction :", Direction);
	}
	
	//................................Result Page Method............................................//
	public void TitleisDisplayed() {
		try {
            if(isDisplayed(driver, FTR_Template_ResultPage)) {
                test.log(LogStatus.PASS, "Title is Displayed : Foreign Travel Request Template Search Page :");
            }
        } catch (Exception e) {
            testFailSshot(driver, test);
            test.log(LogStatus.FAIL, "Title is not Displayed : Foreign Travel Request Template Search Page :");
        }
	}
}