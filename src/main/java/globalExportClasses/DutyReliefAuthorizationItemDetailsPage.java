package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class DutyReliefAuthorizationItemDetailsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_DRAuthItemDetails_AddItemBtn = "//button[contains(@name,'addItem')]";
	public static final String OCR_DRAuthItemDetails_PartNoLink = "//a[@class='partNoLink']";
	public static final String OCR_DRAuthItemDetails_SearchBtn = "//button[@name='Search']";
	public static final String OCR_DRAuthItemDetails_SelectBtn = "(//button[@name='Ok'])[1]";
	public static final String OCR_DRAuthItemDetails_CloseBtn = "//button[@class='btn-close']";
	public static final String OCR_DRAuthItemDetails_Qty = "//input[@id='editDutyReliefItem_qty']";
	public static final String OCR_DRAuthItemDetails_UOM = "//input[@id='editDutyReliefItem_comDtyRlfAuthItemsValue_uom']";
	public static final String OCR_DRAuthItemDetails_SaveReturnBtn = "//button[contains(text(),'Save & Return')]";
	public static final String OCR_DRAuthItemDetails_PartNo = "//input[@id='searchForm_product_productCode']";
	public static final String OCR_DRAuthItemDetails_ActivityLog = "//a[contains(text(),'Activity Log')]";

	/* ******************************* Constructor ****************************** */

	public DutyReliefAuthorizationItemDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Click on Add Item button
	public void addItemBtn() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_DRAuthItemDetails_AddItemBtn, "Click on Add Item Button");
	}

	public void itemDetails(String PartNo, String Qty, String UOM) {
		try {
			if (PartNo.length() > 0) {
				Wait.waitfor(2);
				clickElement(driver, test, OCR_DRAuthItemDetails_PartNoLink, "Click on Part No link");
				typeText(driver, test, OCR_DRAuthItemDetails_PartNo, "Entr Part No : ", PartNo);
				clickElement(driver, test, OCR_DRAuthItemDetails_SearchBtn, "Click on Search Button");
				Wait.waitfor(2);
				clickElement(driver, test, "//td[contains(text(),'" + PartNo + "')]", "Click on Part No : " + PartNo);
				clickElement(driver, test, OCR_DRAuthItemDetails_SelectBtn, "Click on Select Button");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_DRAuthItemDetails_CloseBtn, "Click on Close popup icon");
		}

		typeText(driver, test, OCR_DRAuthItemDetails_Qty, "Enter Quantity : ", Qty);
		typeText(driver, test, OCR_DRAuthItemDetails_UOM, "Enter UOM : ", UOM);
	}

	public void saveReturnBtn() {
		clickElement(driver, test, OCR_DRAuthItemDetails_SaveReturnBtn, "Click on Save Button");
	}

	public void activityLog() {
		clickElement(driver, test, OCR_DRAuthItemDetails_ActivityLog, "Click on Activity Log tab");
	}

}