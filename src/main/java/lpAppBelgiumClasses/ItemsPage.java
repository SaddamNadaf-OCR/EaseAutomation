package lpAppBelgiumClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ItemsPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	
	public static final String OCR_ItemPage_AddItemButton = "//input[@id='addFP']";
	public static final String OCR_ItemPage_NewItem_PartNoClick = "//a[contains(text(),'Part No.')]";
	public static final String OCR_ItemPage_NewItem_SearchPartNo = "//input[@id='searchForm_product_productCode']";
	public static final String OCR_ItemPage_NewItem_SearchBtn = "//div[@id='searchDIV']//button[2]";
	public static final String OCR_ItemPage_NewItem_SelectBtn ="//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_ItemPage_NewItem_SaveBtn ="//div[@class='ocr-modal-cont']//button[@id='save']";
	public static final String OCR_ItemPage_NewItem_ItemSaveBtn ="//input[@value='Save']";
	public static final String OCR_ItemsDetils_CountryCancel = "//div[@class='ocr-modal-cont']//button[@id='cancelPopup']";
	public static final String OCR_ItemsDetils_PopUpClose = "//button[@class='btn-close']";

	/* ******************************* Constructor ****************************** */

	public ItemsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// clicking on Add Item Button
	public void addItemButton() {
		clickElement(driver, test, OCR_ItemPage_AddItemButton, "Click on Item Button");
	}

	// click on part No. link and Enter the Part No.
	public void createNewItems(String PartNo) {
		clickElement(driver, test, OCR_ItemPage_NewItem_PartNoClick, "Click on Part No. Link");
		typeText(driver, test, OCR_ItemPage_NewItem_SearchPartNo, "Enter the Part No.: ", PartNo);
	}

	// Click on Search Product and select the item from the table
	public void searchProduct(String PartNo) {
		clickElement(driver, test, OCR_ItemPage_NewItem_SearchBtn, "click on Search Button");
		Wait.waitfor(3);
		String part= "//table[@id='gridPopup']/tbody//td[contains(text(),'"+ PartNo.trim() +"')]";
		clickElement(driver, test, part, "Selected Part No. : " + PartNo);
		clickElement(driver, test, OCR_ItemPage_NewItem_SelectBtn, "click on select button");
		Wait.waitfor(4);
		typeText(driver, test, "//input[@id='quantityId']", "Enter Quantity : ", "12");
		typeText(driver, test, "//input[@id='netWeightId']", "Enter Net Weight : ", "100");
		typeText(driver, test, "//input[@id='htsCode']", "Enter  H S Code : ", "0101210000");
		typeText(driver, test, "//input[@id='saveBEItem_authorisationItemValue_prodClassification']", "Enter Control List Number :", "1000");
	} 

	// Click on Save Button
	public void editItemSave() {
		clickElement(driver, test, OCR_ItemPage_NewItem_SaveBtn, "Click on Save Button");
	}

	//click on close button
	public void closeBtn() {
		clickElement(driver, test, OCR_ItemsDetils_PopUpClose , "click on closes button ");
	}

	// Click on Item Page Save button
	public void saveItems()	{
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ItemPage_NewItem_ItemSaveBtn, "Click on Item Page Save button");
	}

	//Click on cancle button
	public void cancleitems()	{
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ItemsDetils_CountryCancel, "Click on Item Page cancle button");
	}

	//validating the Add Item is Added or not in grid table
	public void validate_addItem(String PartNo) {
		try {
			String itemTable = "//table[@id='beItemTabel']//tr/td[contains(text(),'"+PartNo.trim()+"')]";
			if(isDisplayed(driver, itemTable)) {
			test.log(LogStatus.PASS, "Add Item is Added in result grid table : "+PartNo);
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add Item in result grid table : "+PartNo);
		}
	}

	//validate add Items details Errors
	public void validateItemsDetails() {
		try {
			if (isDisplayed(driver,"(//h4[contains(text(),'Error')])[2]")) {
				if (isDisplayed(driver,"//li[text()='Quantity is required and must be greater than Zero']")) {
					test.log(LogStatus.INFO, "Quantity is required and must be greater than Zero");
				}
				if (isDisplayed(driver,"//li[text()='Control List Number  is required.']")) {
					test.log(LogStatus.INFO, "Control List Number  is required.");
				}
				if (isDisplayed(driver,"//li[text()='Unit Value   is required.']")) {
					test.log(LogStatus.INFO, "Unit Value   is required.");
				}
				if (isDisplayed(driver,"//li[text()='Net Weight  is required.']")) {
					test.log(LogStatus.INFO, "Net Weight  is required.");
				}
				if (isDisplayed(driver,"//li[text()='HS Code  is required.']")) {
					test.log(LogStatus.INFO, "HS Code  is required.");
				}
				if (isDisplayed(driver,"//li[text()='Description is required.']")) {
					test.log(LogStatus.INFO, "Description is required.");
				}
				Wait.waitfor(3);
				cancleitems();	
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			cancleitems();
			test.log(LogStatus.FAIL, "Error Vaildation is not Displayed by clicking on items Details Button");					
		}
	}
	
	public void type_StatisticalCode() {
		typeText(driver, test, "//input[@id='statisticalCode']", "Enter the Statistical Code : ", "12235");
	}

}
