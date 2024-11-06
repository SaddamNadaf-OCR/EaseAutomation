package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewContractsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	// -----------------------------------Locator-------------------------------------------------//

	public static final String Create_ContractNo = "//input[@name='contract.contractNo']";
	public static final String Create_Part130RequiredYes = "//input[@name='contract.part130Reqd'][1]";
	public static final String Create_Part130RequiredNo = "//input[@name='contract.part130Reqd'][2]";
	public static final String OCR_Save = "//input[@name='save']";
	public static final String OCR_SaveandReturn = "//input[@name='ok']";

	// -----------------------------Constructor---------------------------------------------//

	public CreateNewContractsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// -----------------------------ProductFamilyID-------------------------------------------//

	public void enterContractNo(String ContractNo, String Part130Req) {

		typeText(driver, test, Create_ContractNo, "Enter ContractNo :", ContractNo);
		if (Part130Req.equalsIgnoreCase("Yes")) {
			clickElement(driver, test, Create_Part130RequiredYes, "Clicking on Yes");
		} else {
			clickElement(driver, test, Create_Part130RequiredNo, "Clicking on No");
		}
	}

	// -------------------------------Save-------------------------------------------------//
	public void save() {
		scrollToElement(driver, OCR_Save);
		Wait.waitfor(3);
		scrollToTop(driver);
		clickElement(driver, test, OCR_Save, "Click on Save Button ");
	}

	// --------------------------------Save&Return-------------------------------------------//
	public void saveandReturn() {
		scrollToElement(driver, OCR_SaveandReturn);
		Wait.waitfor(3);
		scrollToTop(driver);
		clickElement(driver, test, OCR_SaveandReturn, "Click on Save Button ");
	}

}
