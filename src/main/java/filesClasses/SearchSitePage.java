package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchSitePage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
	//--------------------------------------Locators---------------------------------------------------//
	
	public static final String OCR_SearchPage_search = "//button[@type='submit']";
	public static final String OCR_SearchPage_reset = "//button[@type='reset']";
	public static final String OCR_HomePage_AddSite = "//button[@name='Add']";
	public static final String OCR_HomePage_SBU = "//select[@name='dosSite.sbuCode']";
	public static final String OCR_HomePageSite = "(//a[contains(text(),'Site')])[3]";
	public static final String OCR_HomePage_Report = "(//a[@class='nav-link dropdown-item'])[3]";
	public static final String OCR_HomePage_ProductReport = "//a[contains(text(),'Product Report')]";
	public static final String OCR_HomePage_SiteId="//input[@name='dosSite.siteId']";
	public static final String OCR_Homepage_SiteName="//input[@name='dosSite.siteName']";
	public static final String OCR_HomePage_Status="//select[@name='dosSite.status']";
	public static final String OCR_HomePage_CreatedBy="//select[@name='dosSite.createdBy']";
	public static final String OCR_HomePage_SortBy="//select[@name='sortBy']";
	public static final String OCR_HomePage_direction="//select[@name='direction']";
	
	/* ******************** Constructor ***************************** */

	public SearchSitePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	
	}
	
	//....................click on search button......................//
		public void searchbutton() {
			clickElement(driver, test, OCR_SearchPage_search, "clicking on search button :");
		}
		
	//....................click on reset button......................//
		public void resetbutton() {
			clickElement(driver, test, OCR_SearchPage_reset, "clicking on search button :");
		}
		
	//....................click on AddSite button......................//
		public void addSite() {
			clickElement(driver, test, OCR_HomePage_AddSite, "clicking on search button :");
		}
		
	//.....................searchParameter...............................//
		public void searchbyParameters(String sbu, String SiteId, String SiteName, String Status, String CreatedBy, String SortBy, String direction) {
			selectByVisibleText(driver, test, OCR_HomePage_SBU, "selecting Sbu by dropdown :", sbu);
			typeText(driver, test, OCR_HomePage_SiteId, "Entering Code :", SiteId);
			typeText(driver, test, OCR_Homepage_SiteName, "Entering Code :", SiteName);
			selectByVisibleText(driver, test, OCR_HomePage_Status, "selecting Status by dropdown :", Status );
			selectByVisibleText(driver, test, OCR_HomePage_CreatedBy, "selecting CreatedBy by dropdown :", CreatedBy );
			selectByVisibleText(driver, test, OCR_HomePage_SortBy, "selecting CreatedBy by dropdown :", SortBy );
			selectByVisibleText(driver, test, OCR_HomePage_direction, "selecting CreatedBy by dropdown :", direction );
							
							
				}

}
