package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchEmployeepage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_Homepage_module = "//ul[@class='nav navbar-nav']/li[2]/a";
	public static final String OCRSBU_Code = "//select[@id='resultEmployeeScreening_employeeScreeningValue_sbuId']";
	public static final String OCR_EmpID = "//input[@id='resultEmployeeScreening_employeeScreeningValue_employeeId']";
	public static final String OCR_EmpFname = "//input[@id='resultEmployeeScreening_employeeScreeningValue_employeeFirstName']";
	public static final String OCR_EmpLasName="//input[@id='resultEmployeeScreening_employeeScreeningValue_employeeLastName']" ;
	public static final String OCR_searchbtn="(//button[@type='submit'])[1]";

	
	/*******************************Constructor**********************************/

	public SearchEmployeepage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

	}

	/* ******************************* Actions ********************************* */
	public void SearchEmployee(String SBUCode, String EmpID, String EmpFname, String EmpLastName) {

		selectByVisibleText(driver, test, OCRSBU_Code, "Select SBU Code", SBUCode);
		Wait.waitfor(2);
		typeText(driver, test, OCR_EmpID, "enter Employee ID ", EmpID);
		Wait.waitfor(2);
		typeText(driver, test, OCR_EmpFname, "enter employee first name ", EmpFname);
		Wait.waitfor(2);
		typeText(driver, test, OCR_EmpLasName, "Enter employee last name ", EmpLastName);
		
	}

	public void clickonSearch() {
		clickElement(driver, test, OCR_searchbtn, "click on search");
	}

}
