package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchSegmentPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	//------------------------------------------Constructor----------------------------//
	
	public static final String OCR_SearchPage_search = "(//button[@class='primary-btn'])[1]";
	public static final String OCR_SearchPage_reset = "//button[@type='reset']";
	public static final String OCR_HomePage_AddSegment = "//button[@name='Add']";
	public static final String OCR_HomePage_SBU = "//select[@name='lesSegment.sbuCode']";
	public static final String OCR_HomePageSegments = "//a[contains(text(),'Segments')]";
	public static final String OCR_HomePageSegmentCode = "//input[@name='lesSegment.segmentCode']";
	public static final String OCR_HomePage_Report = "(//a[@class='nav-link dropdown-item'])[3]";
	public static final String OCR_HomePage_ProductReport = "//a[contains(text(),'Product Report')]";
	public static final String OCR_HomePage_SegmentName="//input[@name='lesSegment.segmentName']";
	public static final String OCR_HomePage_Status="//select[@name='lesSegment.status']";
	public static final String OCR_HomePage_CreatedBy="//select[@name='lesSegment.createdBy']";
	public static final String OCR_HomePage_SortBy="//select[@name='sortBy']";
	public static final String OCR_HomePage_Direction="//select[@name='direction']";
	
	/* ******************** Constructor ***************************** */

	public SearchSegmentPage(WebDriver driver, ExtentTest test) {
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
			
			//....................click on AddSegment button......................//
			public void addProgram() {
				clickElement(driver, test, OCR_HomePage_AddSegment, "clicking on search button :");
			}
			
			//------------------------------Search Parameter----------------------------------//
			
			public void searchbyParameters(String sbu,String Status, String CreatedBy, String SortBy, String direction, String SegmentCode, String SegmentName) {
				selectByVisibleText(driver, test, OCR_HomePage_SBU, "selecting Sbu by dropdown :", sbu);
				typeText(driver, test, OCR_HomePageSegmentCode, "Entering Code :", SegmentCode);
				typeText(driver, test, OCR_HomePage_SegmentName, "Entering Code :", SegmentName);
				selectByVisibleText(driver, test, OCR_HomePage_Status, "selecting Status by dropdown :", Status );
				selectByVisibleText(driver, test, OCR_HomePage_CreatedBy, "selecting CreatedBy by dropdown :", CreatedBy );
				selectByVisibleText(driver, test, OCR_HomePage_SortBy, "selecting SortBy by dropdown :", SortBy );
				selectByVisibleText(driver, test, OCR_HomePage_Direction, "selecting Direction by dropdown :", direction );
				
				
			}
}
