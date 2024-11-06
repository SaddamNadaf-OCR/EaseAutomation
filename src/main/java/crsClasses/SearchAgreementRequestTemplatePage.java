package crsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class SearchAgreementRequestTemplatePage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//.........................................Locators................................................//
	public static final String AGR_Template_SearchButton = "//button[contains(text(),'Search')]";
	public static final String AGR_Template_ResetButton = "//button[contains(text(),'Reset')]";
	public static final String AGR_Template_AddTemplate = "//button[contains(text(),' Add Template')]";
	public static final String AGR_Template_SBU = "//select[@name='exportRequestValue.sbuCode']";
	public static final String AGR_Template_TemplateName = "//input[@name='exportRequestValue.templateName']";
	public static final String AGR_Template_RequestDateFrom = "//input[@name='exportDateFrom']";
	public static final String AGR_Template_RequestDateTo = "//input[@name='exportDateTo']";
	public static final String AGR_Template_RequesterName = "//input[@name='exportRequestValue.nameOfRequestor']";
	public static final String AGR_Template_Program = "(//a[contains(text(),'Program')])[2]";
	public static final String AGR_Template_ProgramCode = "//input[@name='programTab.programCode']";
	public static final String AGR_Template_SearchPopup = "//button[@name='Search']";
	public static final String AGR_Template_SelectPopup = "(//button[@name='Ok'])[1]";
	public static final String AGR_Template_ClosePopup = "//button[@class='btn-close']";
	public static final String AGR_Template_ProgramTextBox = "//textarea[@name='exportRequestValue.program']";
	public static final String AGR_Template_Segment = "(//a[contains(text(),'Segment')])[2]";
	public static final String AGR_Template_SegmenTextBox = "//textarea[@name='exportRequestValue.segment']";
	public static final String AGR_Template_Site = "(//a[contains(text(),'Site')])[2]";
	public static final String AGR_Template_SiteTextBox = "//textarea[@name='exportRequestValue.site']";
	public static final String AGR_Template_ProductLine = "(//a[contains(text(),'Product Line')])[2]";
	public static final String AGR_Template_ProductLineTextBox = "//textarea[@name='exportRequestValue.prodLine']";
	public static final String AGR_Template_ProductFamily = "(//a[contains(text(),'Product Family')])[2]";
	public static final String AGR_Template_ProductFamilyTextBox = "//textarea[@name='exportRequestValue.prodFamily']";
	public static final String AGR_Template_SortBy = "//select[@name='sortBy']";
	public static final String AGR_Template_Direction = "//select[@name='direction']";
	public static final String AGR_Template_ResultPage = "//h3[@class='page-heading']";
	//...........................................Constructor....................................................//
	public SearchAgreementRequestTemplatePage(WebDriver driver,ExtentTest test) {
		this.driver=driver;
		this.test=test;
	}
	
	//...................................Click on Search Button.......................................//
	public void Search() {
		clickElement(driver, test, AGR_Template_SearchButton, "Clicking on Search Button :");
	}
	
	//...................................Click on Reset Button.......................................//
	public void Reset() {
		clickElement(driver, test, AGR_Template_ResetButton, "Clicking on Reset Button :");
	}
	
	//...................................Click on Add Template button.................................//
	public void AddTemplateButton() {
		clickElement(driver, test, AGR_Template_AddTemplate, "Clicking on Add Template button :");
	}
	
	//...................................Click on Add Template button.................................//
	public void SearchByTemplateName(String Template) {
		typeText(driver, test, AGR_Template_TemplateName, "Entering Template Name :", Template);
	}
	
	//...................................Search By Template button.................................//
	public void SearchByTemplatename(String Templatename) {
		typeText(driver, test, AGR_Template_TemplateName, "Entering Template Name :", Templatename);
	}
	
	//.................................Search By Parameters..........................................//
	public void SearchByParameters(String SBU, String TemplateName, String RequestDateFrom, String RequestDateTo, 
			String RequesterName, String Program, String Segment, String Site, String ProductLine, String ProductFamily, 
			String SortBy, String Direction) {
		
		selectByVisibleText(driver, test, AGR_Template_SBU, "Selecting SBU :", SBU);
		typeText(driver, test, AGR_Template_TemplateName, "Entering Template Name :", TemplateName);
		if(RequestDateFrom.length() > 0) {
			clickElement(driver, test, AGR_Template_RequestDateFrom, "Clicking on Request Date From :");
			dateOfMonthName(driver, test, "Selecting Request Date From :", RequestDateFrom);
		}
		if(RequestDateTo.length() > 0) {
			clickElement(driver, test, AGR_Template_RequestDateTo, "Clicking on Request Date to :");
			dateOfMonthName(driver, test, "Selecting Request Date To :", RequestDateTo);
		}
		typeText(driver, test, AGR_Template_RequesterName, "Entering Requester Name :", RequesterName);
		if(Program.length() > 0) {
			clickElement(driver, test, AGR_Template_Program, "Clicking on Program Link :");
			try {
				typeText(driver, test, AGR_Template_ProgramCode, "Entering Program Code :", Program);
				clickElement(driver, test, AGR_Template_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Program+"')]", "Select Program From Grid :");
				clickElement(driver, test, AGR_Template_SelectPopup, "Clicking on Select Button :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AGR_Template_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}
		if(Segment.length() > 0) {
			clickElement(driver, test, AGR_Template_Segment, "Clicking on Segment Link :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Segment+"')]", "Selecting Segment :");
				clickElement(driver, test, AGR_Template_SelectPopup, "Clicking on Select Button :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AGR_Template_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}
		if(Site.length() > 0) {
			clickElement(driver, test, AGR_Template_Site, "Clicking on Site Link :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Site+"')]", "Selecting Site :");
				clickElement(driver, test, AGR_Template_SelectPopup, "Clicking on Select Button :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AGR_Template_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}
		if(ProductLine.length() > 0) {
			clickElement(driver, test, AGR_Template_ProductLine, "Clicking on Product Line Link :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ProductLine+"')]", "Selecting Product Line :");
				clickElement(driver, test, AGR_Template_SelectPopup, "Clicking on Select Button :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AGR_Template_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}
		if(ProductFamily.length() > 0) {
			clickElement(driver, test, AGR_Template_ProductFamily, "Clicking on Product Family Link :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ProductFamily+"')]", "Selecting Product Family :");
				clickElement(driver, test, AGR_Template_SelectPopup, "Clicking on Select Button :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AGR_Template_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}
		selectByVisibleText(driver, test, AGR_Template_SortBy, "Selecting Sort By :", SortBy);
		selectByVisibleText(driver, test, AGR_Template_Direction, "Selecting Direction :", Direction);
	}
	
	//................................Result Page Method............................................//
	public void TitleisDisplayed() {
		try {
            if(isDisplayed(driver, AGR_Template_ResultPage)) {
                test.log(LogStatus.PASS, "Title is Displayed : Agreement Request Template Search Page :");
            }
        } catch (Exception e) {
            testFailSshot(driver, test);
            test.log(LogStatus.FAIL, "Title is not Displayed : Agreement Request Template Search Page :");
        }
	}
}
