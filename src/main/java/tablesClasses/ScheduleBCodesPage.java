package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class ScheduleBCodesPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

//---------------------------------Locators---------------------------------------------

	public static final String OCRsearchbtn = "(//button[@class='primary-btn'])[1]";
	public static final String OCRAddAgencybtn = "(//button[@class='primary-btn'])[2]";
	public static final String OCRScheduleB="//input[@id='searchSchB_schB_schbNo']";
	public static final String OCRDescriprion="//textarea[@id='searchSchB_schB_schbDesc']";
	public static final String OCRStatus="//select[@name='status']";
	public static final String OCRsortBy="//select[@name='sortBy']";
	public static final String OCRDirection="//select[@name='direction']";
	
	//-----------------------------Add Locator-----------------------------------------------
	public static final String OCRSchedulebNo="//input[@id='editSchB_schB_schbNo']";
	public static final String OCRScheduleBDesc="//textarea[@id='editSchB_schB_schbDesc']";
	public static final String OCRsavebtn="//button[@name='save']";
	public static final String OCRPrimaryUnit="//input[@id='editSchB_schB_primaryUnit']";
	
	
	// --------------------Constructor------------------------------------
	

	public ScheduleBCodesPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

	}

	// ....................click on search button......................
	public void searchbutton() {
		clickElement(driver, test, OCRsearchbtn, "clicking on search button :");
	}

	public void addbutton() {
		clickElement(driver, test, OCRAddAgencybtn, "clicking on Add button :");
	}

	public void savebtn() {
		clickElement(driver, test, OCRsavebtn, "clicking on save button :");
	}

	// .....................searchParameter...............................//

	public void searchbyParameters(String ScheduleBNo, String Description, String Status, String sortby, String direction) {

		typeText(driver, test, OCRScheduleB, "Entering schedule B No:", ScheduleBNo);
		Wait.waitfor(2);	
		typeText(driver, test, OCRDescriprion, "Entering description :", Description);
		Wait.waitfor(2);	
		
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCRStatus, "selecting Status from dropdown :", Status);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCRsortBy, "selecting sortby from dropdown :", sortby);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCRDirection, "selecting direction from dropdown :", direction);
		Wait.waitfor(2);
	}
	// .....................addParameter...............................//

	public void addbyParameters(String Description, String PrimaryUnit) {

		typeText(driver, test, OCRSchedulebNo, "Entering Schedule B No:", randomnumbers());
		Wait.waitfor(2);	
		typeText(driver, test, OCRScheduleBDesc, "Entering Description :", Description);
		Wait.waitfor(2);
		typeText(driver, test, OCRPrimaryUnit, "Entering Primary Unit:", PrimaryUnit);
		Wait.waitfor(2);	
		
	
	}
}
	
	
