package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchOrderCategoryPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
	//-------------------------------------Locators--------------------------------------//
	
	public static final String OCR_SearchPage_search = "//button[@type='submit']";
	public static final String OCR_SearchPage_reset = "//button[@type='reset']";
	public static final String OCR_HomePage_AddOrderCategory = "//button[@name='Add']";
	public static final String OCR_HomePage_SBU = "//select[@name='orderCategory.sbuCode']";
	public static final String OCR_HomePageOrderCategory = "//a[contains(text(),'Order Category')]";
	public static final String OCR_HomePage_Report = "(//a[@class='nav-link dropdown-item'])[3]";
	public static final String OCR_HomePage_ProductReport = "//a[contains(text(),'Product Report')]";
	public static final String OCR_HomePage_OrderCategoryType="//input[@name='orderCategory.orderCategoryType']";
	public static final String OCR_Homepage_OrderCategoryName="//input[@name='orderCategory.orderCategoryName']";
	public static final String OCR_HomePage_Status="//select[@name='orderCategory.status']";
	public static final String OCR_HomePage_CreatedBy="//select[@name='orderCategory.createdBy']";
	public static final String OCR_HomePage_SortBy="//select[@name='sortBy']";
	public static final String OCR_HomePage_direction="//select[@name='direction']";
	
	/* ******************** Constructor ***************************** */

	public SearchOrderCategoryPage(WebDriver driver, ExtentTest test) {
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
		
	//....................click on AddOrderCategory button......................//
	public void addOrderCategoryType() {
		clickElement(driver, test, OCR_HomePage_AddOrderCategory, "clicking on search button :");
	}
				
	//.....................searchParameter...............................//
	public void searchbyParameters(String sbu, String OrderCategoryType, String OrderCategoryName, String Status, String CreatedBy, String SortBy, String direction) {
		selectByVisibleText(driver, test, OCR_HomePage_SBU, "selecting Sbu by dropdown :", sbu);
		typeText(driver, test, OCR_HomePage_OrderCategoryType, "Entering Code :", OrderCategoryType);
		typeText(driver, test, OCR_Homepage_OrderCategoryName, "Entering Code :", OrderCategoryName);
		selectByVisibleText(driver, test, OCR_HomePage_Status, "selecting Status by dropdown :", Status );
		selectByVisibleText(driver, test, OCR_HomePage_CreatedBy, "selecting CreatedBy by dropdown :", CreatedBy );
		selectByVisibleText(driver, test, OCR_HomePage_SortBy, "selecting CreatedBy by dropdown :", SortBy );
		selectByVisibleText(driver, test, OCR_HomePage_direction, "selecting CreatedBy by dropdown :", direction );
	}


}
