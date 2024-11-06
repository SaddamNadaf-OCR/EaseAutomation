package globalExportClasses;
/* 
 * Module : Export Operation
 * Author  : saddam
 * created date : May 2024
 * Descriptions : Result Report Page
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil
 * Reviewed by : Nil 
 */
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;

public class ResultReportPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String CRS_Report_ExporttoExcel="//img[@title='Export to Excel']";
	public static final String CRS_Report_Exporttopdf="//img[@title='Export to PDF']";
	public static final String CRS_Report_BacktoSearchPage="//img[@title='Back to Search Page']";
	public static final String CRS_Report_SearchCriteria="//h3[contains(text(),'Annual Status Delinquency Report')]";
	public static final String CRS_Reports_Heading = "//h3[@class='page-heading']";
	
	//..................................Constructors..................................//
	public ResultReportPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//..........................Excel & PDF Icon is Displayed..................................//
	public void IconsDisplay() {
		try {
			if(isDisplayed(driver, CRS_Report_ExporttoExcel)) {
				test.log(LogStatus.PASS, "Export to Excel Icon is Displayed :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Export To Excel Icon is Not Displayed :");
		}
		
		try {
			if(isDisplayed(driver, CRS_Report_Exporttopdf)) {
				test.log(LogStatus.PASS, "Export to PDF Icon is Displayed :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Export To PDF Icon is Not Displayed :");
		}
	}
	
	//...................................DownLoad Excel Sheet ................................//
	public void downloadExcel() {
		clickElement(driver, test, CRS_Report_ExporttoExcel, "Clicking on Export To Excel :");
		
	}
	
	//...................................DownLoad PDF Sheet ................................//
	public void downloadPdf() {
		clickElement(driver, test, CRS_Report_Exporttopdf, "Clicking on Export To PDF :");
	}
	
	//...................................Click on Back To Search ................................//
	public void backToSearch() {
		clickElement(driver, test, CRS_Report_BacktoSearchPage, "Clicking on Back To Search");
	}
	
	//.....................................Get Text ........................................//
	public void getText() {
		String text=getText(driver, test, CRS_Report_SearchCriteria, "Getting text");
		System.out.println(text);
	}
	
	//..........................Title of the page is Displayed or not................................//
    public void titleIsDisplayed() {
        try {
            if(isDisplayed(driver, CRS_Reports_Heading)) {
                test.log(LogStatus.PASS, "Title is Displayed : Results Compliance Request Metrics Report ");
            }
        } catch (Exception e) {
            testFailSshot(driver, test);
            test.log(LogStatus.FAIL, "Title is not Displayed : Results Compliance Request Metrics Report");
        }
    }

}
