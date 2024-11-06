package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class AddEmployeePage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_Homepage_module = "//ul[@class='nav navbar-nav']/li[2]/a";
	public static final String OCR_AddEmployeebtn = "//button[contains(text(),'Add Employee')]";
	public static final String OCR_BtnSave = "//button[@name='save']";
	public static final String OCR_EmpID = "//input[@id='editEmployeeScreening_employeeScreeningValue_employeeId']";
	public static final String OCR_EmpFname = "//input[@id='editEmployeeScreening_employeeScreeningValue_employeeFirstName']";
	public static final String OCR_EmpLasName = "//input[@id='editEmployeeScreening_employeeScreeningValue_employeeLastName']";

	/*
	 * ****************************** Constructor *********************************
	 */
	public AddEmployeePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

	}

	/* ******************************* Actions ********************************* */
	public void AddEmployee(String EmpId, String EmpFNmame, String EmpLastName) {

		clickElement(driver, test, OCR_AddEmployeebtn, "Click on add employee button");
		typeText(driver, test, OCR_EmpID, "Enter Employee Id ", EmpId);
		typeText(driver, test, OCR_EmpFname, "Employee Firstname ", EmpFNmame);
		typeText(driver, test, OCR_EmpLasName, "Employee LastName", EmpLastName);

	}

	public void clickonSave() {
		clickElement(driver, test, OCR_BtnSave, "click on save");
	}

}