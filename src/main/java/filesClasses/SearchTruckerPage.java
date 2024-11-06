package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchTruckerPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	//------------------------------------Locators---------------------------------------//
	
	public static final String OCR_SearchPage_search = "//button[@class='primary-btn'][1]";
	public static final String OCR_SearchPage_reset = "//button[@type='reset']";
	public static final String OCR_HomePage_AddTrucker = "//button[@class='primary-btn'][2]";
	public static final String OCR_HomePage_SBU = "//select[@name='trucker.sbuCode']";
	public static final String HomePageTrucker = "(//a[contains(text(),'Truckers')])[4]";
	public static final String OCR_HomePage_Report = "(//a[@class='nav-link dropdown-item'])[4]";
	public static final String OCR_HomePage_ProductReport = "//a[contains(text(),'Product Report')]";
	public static final String OCR_HomePage_Id="//input[@name='trucker.truckerId']";
	public static final String OCR_Homepage_Name="//input[@name='trucker.truckerName']";
	public static final String OCR_HomePage_Status="//select[@name='trucker.status']";
	public static final String OCR_HomePage_SortBy="//select[@name='sortBy']";
	public static final String OCR_HomePage_CreatedBy="//select[@name='trucker.createdBy']";
	public static final String OCR_HomePage_Direction="//select[@name='direction']";
	
	//--------------------------------------Constructors-----------------------------------//
	
	public SearchTruckerPage(WebDriver driver, ExtentTest test) {
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
				
				//....................click on AddTruckers button......................//
			public void addShipper() {
					clickElement(driver, test, OCR_HomePage_AddTrucker, "clicking on AddTrucker button :");
				}
			
			//.....................searchParameter...............................//
			public void searchbyParameters(String sbu, String Name, String Id, String Status, String CreatedBy, String SortBy, String Direction ) {
					selectByVisibleText(driver, test, OCR_HomePage_SBU, "selecting Sbu by dropdown :", sbu);
					typeText(driver, test, OCR_Homepage_Name, "Entering Name :", Name);
					typeText(driver, test, OCR_HomePage_Id, "Entering Id :", Id);
					selectByVisibleText(driver, test, OCR_HomePage_Status, "selecting Status by dropdown :", Status );
					selectByVisibleText(driver, test, OCR_HomePage_SortBy, "selecting SortBy by dropdown :", SortBy );
					selectByVisibleText(driver, test, OCR_HomePage_Direction, "selecting Direction by dropdown :", Direction );
					selectByVisibleText(driver, test, OCR_HomePage_CreatedBy, "selecting CreatedBy by dropdown :", CreatedBy );
					
			}
	

}
