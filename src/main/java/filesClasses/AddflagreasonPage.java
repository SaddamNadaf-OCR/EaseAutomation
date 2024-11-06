package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class AddflagreasonPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_Homepage_module = "//ul[@class='nav navbar-nav']/li[2]/a";
	public static final String OCR_AddOwnerButton = "//button[@name='Add']";
	public static final String OCR_Addflagbtn = "//button[@name='Add']";
	public static final String OCR_BtnSave = "//button[@name='save']";
	public static final String OCR_SbuCode = "//select[@id='sbuCode']";
	public static final String OCR_reasoncode = "//input[@id='editFlagReason_flagReason_reasonCode']";

	public static final String OCR_FlagIcon = "(//button[@class='btn btn-default dropdown-toggle'])[1]";
	public static final String OCR_FlagColor = "(//button[@class='btn btn-default dropdown-toggle'])[2]";
	public static final String OCR_Description = "//textarea[@id='editFlagReason_flagReason_desc']";
	public static final String OCR_ImportExport = "//select[@id='editFlagReason_flagReason_importOrExport']";
	public static final String OCR_SetId = "//select[@id='editFlagReason_flagReason_setId']";

	


	/*
	 * ****************************** Constructor *********************************
	 */
	public AddflagreasonPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

	}

	/* ******************************* Actions ********************************* */
	public void AddFlagReason(String SBUCode, String ReasonCode, String FlagIcon, String FlagColor, String Desciption,
			String ImportExport, String SetID) {

		clickElement(driver, test, OCR_Addflagbtn, "Click on add flag reason button");
		selectByVisibleText(driver, test, OCR_SbuCode, "Sbu code ", SBUCode);
		typeText(driver, test, OCR_reasoncode, "Enter reason code", ReasonCode);
		clickElement(driver, test, OCR_FlagIcon, "click on  flag icon");
		clickElement(driver, test, "(//a[contains(text(),'" + FlagIcon + "')])[2]",
				"select the flag icon : " + FlagIcon);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_FlagColor, "click on  flag color");
		clickElement(driver, test, "//a[contains(text(),'" + FlagColor + "')]", "select the flag color : " + FlagColor);
		Wait.waitfor(3);
		typeText(driver, test, OCR_Description, "enter description ", Desciption);
		selectByVisibleText(driver, test, OCR_ImportExport, "select import/Export ", ImportExport);
		selectByVisibleText(driver, test, OCR_SetId, "select SetId", SetID);
	}

	public void clickonSave() {
		clickElement(driver, test, OCR_BtnSave, "click on save");
	}

}