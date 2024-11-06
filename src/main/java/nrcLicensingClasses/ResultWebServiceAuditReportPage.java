package nrcLicensingClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultWebServiceAuditReportPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String NRC_Report_ExporttoExcel="//img[@title='Export to Excel']";
	public static final String NRC_Report_Exporttopdf="//img[@title='Export to PDF']";
	public static final String NRC_Report_BacktoSearchPage="//img[@title='Back to Search Page']";
	public static final String NRC_Report_SearchCriteria="//h3[contains(text(),'Annual Status Delinquency Report')]";
	public static final String NRC_Reports_Heading = "//h3[@class='page-heading']";
	
	//..................................Constructors..................................//
	public ResultWebServiceAuditReportPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//...................................DownLoad Excel Sheet ................................//
	public void downloadExcel() {
		clickElement(driver, test, NRC_Report_ExporttoExcel, "Clicking on Export To Excel");
	}
	
	//...................................DownLoad PDF Sheet ................................//
	public void downloadPdf() {
		clickElement(driver, test, NRC_Report_Exporttopdf, "Clicking on Export To PDF");
	}
	
	//...................................Click on Back To Search ................................//
	public void backToSearch() {
		clickElement(driver, test, NRC_Report_BacktoSearchPage, "Clicking on Back To Search");
	}
	
	//.....................................Get Text ........................................//
	public void getText() {
		String text=getText(driver, test, NRC_Report_SearchCriteria, "Getting text");
		System.out.println(text);
	}
	
	//..........................Title of the page is Displayed or not................................//
    public void titleIsDisplayed() {
        try {
            if(isDisplayed(driver, NRC_Reports_Heading)) {
                test.log(LogStatus.PASS, "Title is Displayed : Results WebService Audit Report");
            }
        } catch (Exception e) {
            testFailSshot(driver, test);
            test.log(LogStatus.FAIL, "Title is not Displayed : Results WebService Audit Report");
        }
    }

}
