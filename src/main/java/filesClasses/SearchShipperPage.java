package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchShipperPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;

	//--------------------------------------Locator-----------------------------------//
	
	public static final String OCR_SearchPage_search = "//button[@class='primary-btn'][1]";
	public static final String OCR_SearchPage_reset = "//button[@type='reset']";
	public static final String OCR_HomePage_AddShipper = "//button[@class='primary-btn'][2]";
	public static final String OCR_HomePage_SBU = "//select[@name='shipperData.sbuCode']";
	public static final String OCR_HomePageShipper = "(//a[contains(text(),'Shippers')])[4]";
	public static final String OCR_HomePage_Report = "(//a[@class='nav-link dropdown-item'])[4]";
	public static final String OCR_HomePage_ProductReport = "//a[contains(text(),'Product Report')]";
	public static final String OCR_HomePage_Name="//input[@name='shipperData.shipperName']";
	public static final String OCR_Homepage_Country="//input[@name='shipperCountryName']";
	public static final String OCR_HomePage_ManufacturerID="//input[@name='shipperData.manufacturerId']";
	public static final String OCR_HomePage_Status="//select[@name='shipperData.status']";
	public static final String OCR_HomePage_SortBy="//select[@name='sortBy']";
	public static final String OCR_HomePage_Code="//input[@name='shipperData.shipperCode']";
	public static final String OCR_HomePage_Zip="//input[@name='shipperData.shipperZip']";
	public static final String OCR_HomePage_CreatedBy="//select[@name='shipperData.createdBy']";
	public static final String OCR_HomePage_Direction="//select[@name='direction']";
	
	//-----------------------------------Constructor----------------------------------------//
	
	public SearchShipperPage(WebDriver driver, ExtentTest test) {
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
			
			//....................click on AddShipper button......................//
		public void addShipper() {
				clickElement(driver, test, OCR_HomePage_AddShipper, "clicking on AddShipper button :");
			}
		
		//.....................searchParameter...............................//
		public void searchbyParameters(String sbu, String Name, String Country, String ManufacturerID, String Status, String SortBy, String Direction, String CreatedBy, String Code, String Zip ) {
				selectByVisibleText(driver, test, OCR_HomePage_SBU, "selecting Sbu by dropdown :", sbu);
				typeText(driver, test, OCR_HomePage_Name, "Entering Name :", Name);
				typeText(driver, test, OCR_Homepage_Country, "Entering Country :", Country);
				typeText(driver, test, OCR_HomePage_ManufacturerID, "Entering ManufacturerId :", ManufacturerID );
				typeText(driver, test, OCR_HomePage_Code, "Entering Code :", Code);
				typeText(driver, test, OCR_HomePage_Zip, "Entering Zip :", Zip);
				selectByVisibleText(driver, test, OCR_HomePage_Status, "selecting Status by dropdown :", Status );
				selectByVisibleText(driver, test, OCR_HomePage_SortBy, "selecting SortBy by dropdown :", SortBy );
				selectByVisibleText(driver, test, OCR_HomePage_Direction, "selecting Direction by dropdown :", Direction );
				selectByVisibleText(driver, test, OCR_HomePage_CreatedBy, "selecting CreatedBy by dropdown :", CreatedBy );
				
		}
			

}
