package globalExportClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class OrderConsolidationPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_OrderConsolidationPage_BillToCodeLink = "//a[contains(text(),'Bill To Code')]";
	public static final String OCR_OrderConsolidationPage_ConsigneeCode = "//input[@id='searchForm_consignee_consigneeId']";
	public static final String OCR_OrderConsolidationPage_ConsigneeSearchBtn = "//button[@name='Search']";
	public static final String OCR_OrderConsolidationPage_ConsigneeSelectBtn = "(//button[@name='Ok'])[1]";
	public static final String OCR_OrderConsolidationPage_ConsigneeCloseBtn = "(//button[@class='btn-close'])[1]";
	public static final String OCR_OrderConsolidationPage_SearchBtn = "//button[@id='btnSearch']";
	public static final String OCR_OrderConsolidationPage_SelectAvailableInvoices = "//select[@id='multiselect']";
	public static final String OCR_OrderConsolidationPage_ClickArrow = "(//i[@class='fa fa-chevron-right'])[1]";
	public static final String OCR_OrderConsolidationPage_ClickArrowAllToRight = "(//button[@id='multiselect_rightAll'])[1]";
	public static final String OCR_OrderConsolidationPage_AddShipmentBtn = "//button[@id='btnAddShipment']";
	public static final String OCR_OrderConsolidationPage_InputShipmentNo = "//input[@id='searchShipment_shipment_shipmentNo']";
	public static final String OCR_OrderConsolidationPage_ShipToCodeLink = "//a[contains(text(),'Ship To Code')]";
	public static final String OCR_OrderConsolidationPage_ShipToCode = "//input[@id='searchForm_consignee_consigneeId']";
	public static final String OCR_OrderConsolidationPage_ShipToCodeSearchbtn = "//button[@name='Search']";

	/* ******************************* Constructor ****************************** */

	public OrderConsolidationPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	public void search_BillToCode(String billToLink) {
		try {
			if (billToLink.length() > 0) {
				Wait.waitfor(2);
				clickElement(driver, test, OCR_OrderConsolidationPage_BillToCodeLink, "Click on Bill To Code");
				typeText(driver, test, OCR_OrderConsolidationPage_ConsigneeCode, "Enter Consignee Code : ", billToLink);
				clickElement(driver, test, OCR_OrderConsolidationPage_ConsigneeSearchBtn, "Click on Search Button");
				clickElement(driver, test, "//td[contains(text(),'" + billToLink + "')]",
						"Click on Consignee : " + billToLink);
				clickElement(driver, test, OCR_OrderConsolidationPage_ConsigneeSelectBtn, "Click on Select button");

			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_OrderConsolidationPage_ConsigneeCloseBtn, "Click on Close popup icon");
		}

	}
	
	public void search_ShipToCode(String shipToLink) {
		try {
			if (shipToLink.length() > 0) {
				Wait.waitfor(2);
				clickElement(driver, test, OCR_OrderConsolidationPage_ShipToCodeLink, "Click on Ship To Code");
				typeText(driver, test, OCR_OrderConsolidationPage_ShipToCode, "Enter Consignee Code : ", shipToLink);
				clickElement(driver, test, OCR_OrderConsolidationPage_ShipToCodeSearchbtn, "Click on Search Button");
				clickElement(driver, test, "//td[contains(text(),'" + shipToLink + "')]",
						"Click on Consignee : " + shipToLink);
				clickElement(driver, test, OCR_OrderConsolidationPage_ConsigneeSelectBtn, "Click on Select button");

			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_OrderConsolidationPage_ConsigneeCloseBtn, "Click on Close popup icon");
		}

	}

	public void searchBtn() {
		clickElement(driver, test, OCR_OrderConsolidationPage_SearchBtn, "CLick on Search button");
	}

	public void selectInvoice(String SelectInv) {
		Wait.waitfor(5);
		new Select(driver.findElement(By.xpath(OCR_OrderConsolidationPage_SelectAvailableInvoices)))
				.selectByIndex((Integer.parseInt(SelectInv)));
				clickElement(driver, test, OCR_OrderConsolidationPage_ClickArrow,
				"Click on arrow to bring the selected invoices into Linked Invoices column");

	}
	
	public void selectMultiInvoice(String SelectInv) {
		Wait.waitfor(5);
				clickElement(driver, test, OCR_OrderConsolidationPage_ClickArrowAllToRight,
				"Click on arrow to bring the selected invoices into Linked Invoices column");

	}
	
	

	public void addShipment() {
		scrollToElement(driver, OCR_OrderConsolidationPage_AddShipmentBtn);
		clickElement(driver, test, OCR_OrderConsolidationPage_AddShipmentBtn, "Click on Add Shipment Button");

	}

	public void searchShipment(String ShipNo) {
		typeText(driver, test, OCR_OrderConsolidationPage_InputShipmentNo, "Enter Shipment Number : ", ShipNo);
	}

}
