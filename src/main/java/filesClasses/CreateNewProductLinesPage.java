package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewProductLinesPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	// ---------------------------------------Locators-----------------------------------------//

	public static final String Create_ProductLineID = "//input[@name='dosProdLine.prodLineId']";
	public static final String Create_ProductFamilyID = "//textarea[@name='dosProdLine.prodFamilyId']";
	public static final String Create_ProductLineName = "//textarea[@name='dosProdLine.prodLineName']";
	public static final String Create_Category = "(//a[contains(text(),'Category')])[2]";
	public static final String Create_CategoryUSML = "//input[@Id='editDosProdLine_eccnUsmlNrcusml']";
	public static final String Create_CategoryECCN = "//input[@name='eccnUsmlNrc'][1]";
	public static final String Create_ECCN_USML = "//input[@name='productClazz.prodClassification']";
	public static final String Create_SearchPopup = "//button[@name='Search']";
	public static final String Create_SelectPopup = "//button[@name='Ok']";
	public static final String OCR_ClosePopup = "//i[@class='fa fa-times']";
	public static final String OCR_Save = "//button[@name='save']";
	public static final String OCR_SaveandReturn = "//button[@name='ok']";

	// -----------------------------Constructor---------------------------------------------//

	public CreateNewProductLinesPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// -----------------------------ProductLineID-------------------------------------------//

	public void enterProductLineID(String ProductLineID, String ProductFamilyID, String ProductLineName,
			String Category, String ECCN_USML) {

		typeText(driver, test, Create_ProductLineID, "Enter ProgramCode :", ProductLineID);
		Wait.waitfor(3);
		typeText(driver, test, Create_ProductFamilyID, "Enter Description :", ProductFamilyID);
		Wait.waitfor(3);
		typeText(driver, test, Create_ProductLineName, "Enter Description :", ProductLineName);
		Wait.waitfor(3);
		if (Category.equalsIgnoreCase("ECCN")) {
			clickElement(driver, test, Create_CategoryECCN, "Clicking on ECCN");
			if (Category.length() > 0) {
				clickElement(driver, test, Create_Category, "Clicking on Category");
				try {
					typeText(driver, test, Create_ECCN_USML, "Entering ECCN_USMLNo", ECCN_USML);
					clickElement(driver, test, Create_SearchPopup, "Clicking on Search Button");
					mouseOverAndClick(driver, test, "//td[contains(text(),'" + ECCN_USML + "')]", "Selecting ECCN No");
					clickElement(driver, test, Create_SelectPopup, "Clicking on Select Button");
				} catch (Exception e) {
					testFailSshot(driver, test);
					e.printStackTrace();
					clickElement(driver, test, OCR_ClosePopup, "Clicking on Close Button");

				}
			}
		}
		if (Category.equalsIgnoreCase("USML")) {
			clickElement(driver, test, Create_CategoryUSML, "Clicking on USML");
			if (Category.length() > 0) {
				clickElement(driver, test, Create_Category, "Clicking on Category");
				try {
					typeText(driver, test, Create_ECCN_USML, "Entering ECCN_USMLNo", ECCN_USML);
					clickElement(driver, test, Create_SearchPopup, "Clicking on Search Button");
					mouseOverAndClick(driver, test, "//td[contains(text(),'" + ECCN_USML + "')]", "Selecting ECCN No");
					clickElement(driver, test, Create_SelectPopup, "Clicking on Select Button");
				} catch (Exception e) {
					testFailSshot(driver, test);
					e.printStackTrace();
					clickElement(driver, test, OCR_ClosePopup, "Clicking on Close Button");

				}
			}
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
		clickElement(driver, test, OCR_SaveandReturn, "Click on Save & Return Button ");
	}

}
