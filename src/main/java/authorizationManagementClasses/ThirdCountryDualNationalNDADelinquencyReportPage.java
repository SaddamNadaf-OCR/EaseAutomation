package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ThirdCountryDualNationalNDADelinquencyReportPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String AuthMana_Report_ExporttoExcel="//img[@title='Export to Excel']";
	public static final String AuthMana_Report_Exporttopdf="//img[@title='Export to PDF']";
	public static final String AuthMana_Report_BacktoSearchPage="//img[@title='Back to Search Page']";
	public static final String AuthMana_Report_EnterPageNo="//input[@id='pageId']";
	public static final String AuthMana_Report_GoToPage="//img[@title='Go To Page']";
	public static final String AuthMana_Report_SearchCriteria="//span[@style='font-family: Arial; color: #000000; font-size: 14px; line-height: 1.4893799; font-weight: bold;']";
	public static final String ResultAuth_ResultAuthorization="//h3[@class='page-heading']";
	
	//..................................Constructors..................................//
	public ThirdCountryDualNationalNDADelinquencyReportPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//...................................DownLoad Excel Sheet ................................//
	public void downloadExcel() {
		clickElement(driver, test, AuthMana_Report_ExporttoExcel, "Clicking on Export To Excel");
	}
	
	//...................................DownLoad PDF Sheet ................................//
	public void downloadPdf() {
		clickElement(driver, test, AuthMana_Report_Exporttopdf, "Clicking on Export To PDF");
	}
	
	//...................................Click on Back To Search ................................//
	public void backToSearch() {
		clickElement(driver, test, AuthMana_Report_BacktoSearchPage, "Clicking on Back To Search");
	}
	
	//.....................................Get Text ........................................//
	public void getText() {
		String text=getText(driver, test, AuthMana_Report_SearchCriteria, "Getting text");
		System.out.println(text);
	}
	
	//..........................Title of the page is Displayed or not................................//
		public void titleIsDisplayed() {
			try {
				if(isDisplayed(driver, ResultAuth_ResultAuthorization)) {
					test.log(LogStatus.PASS, "Title is Displayed : Third Country Dual National NDA Delinquency Report Page ");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Title is not Displayed : Country List ");
			}
		} 
}
