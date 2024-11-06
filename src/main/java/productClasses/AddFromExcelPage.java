package productClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;

public class AddFromExcelPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_HomePage_ListScreening = "//ul[@class='nav navbar-nav']/li[2]/a";
	public static final String OCR_ExportOPerationsHomePage = "(//a[contains(text(),'Export Operations')])[1]";
	public static final String OCR_SearchProduct_Files = "//ul[@class='nav navbar-nav']/li[5]/a";
	public static final String OCR_SearchProduct_Product = "(//a[contains(text(),'Products')])[1]";
	public static final String OCR_AddFromExcel = "//button[contains(text(),'Add From Excel')]";
	public static final String OCR_AddFromExcel_FileName = "//input[@id='resultProductExcelUpload_productExcelUploadAuditValue_fileName']";
	public static final String OCR_AddFromExcel_Status = "//select[@id='resultProductExcelUpload_productExcelUploadAuditValue_status']";
	public static final String OCR_AddFromExcel_SbuCode = "//select[@id='resultProductExcelUpload_productExcelUploadAuditValue_sbuCode']";
	public static final String OCR_AddFromExcel_UploadedBy = "//select[@id='resultProductExcelUpload_productExcelUploadAuditValue_uploadedBy']";
	public static final String OCR_AddFromExcel_UploadedDateFrom = "//input[@name='uploadStartDate']";
	public static final String OCR_AddFromExcel_UploadedDateTo = "//input[@name='uploadEndDate']";
	public static final String OCR_AddFromExcel_SortBy = "//select[@id='resultProductExcelUpload_sortBy']";
	public static final String OCR_AddFromExcel_Direction = "//select[@id='resultProductExcelUpload_direction']";
	public static final String OCR_AddFromExcel_Search = "//button[contains(text(),'Search')]";
	public static final String OCR_AddFromExcel_UploadFile = "//button[@id='uploadButton']";
	public static final String OCR_AddFromExcel_BacktoProductFile = "//button[contains(text(),'Back to Product File')]";
	public static final String OCR_AddFromExcel_AttachUploadFile = "//span[@class='btn fileinput-button']";

	/* ******************** Constructor ***************************** */
	public AddFromExcelPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	public void addFromExcel() throws InterruptedException {
		Wait.waitfor(5);
		mouseOver(driver, test, OCR_HomePage_ListScreening, "Mouse over on Watch List Screening");
		clickElement(driver, test, OCR_ExportOPerationsHomePage, "Clicking on Export Operations");
		Wait.waitfor(4);
		mouseOver(driver, test, OCR_SearchProduct_Files, "Click on Files");
		clickElement(driver, test, OCR_SearchProduct_Product, "Click Products");
		clickElement(driver, test, OCR_AddFromExcel, "Click Add From Excel");
	}

	// Enter Product Excel Upload
	public void searchProductDetails(String FileName, String Status, String SbuCode, String UploadedBy,
			String UploadedDateFrom, String UploadedDateTo, String SortBy, String Direction)
			throws InterruptedException {
		typeText(driver, test, OCR_AddFromExcel_FileName, "Enter File Name ", FileName);
		selectByVisibleText(driver, test, OCR_AddFromExcel_Status, "Select Status ", Status);
		selectByVisibleText(driver, test, OCR_AddFromExcel_SbuCode, "Select SbuCode ", SbuCode);
		selectByVisibleText(driver, test, OCR_AddFromExcel_UploadedBy, "Select UploadedBy ", UploadedBy);
		if (UploadedDateFrom.length() > 0) {
			Wait.waitfor(4);
			clickElement(driver, test, OCR_AddFromExcel_UploadedDateFrom, "Click on Uploaded Date From");
			date(driver, test, "Selected on Uploaded Date From : ", UploadedDateFrom);
			test.log(LogStatus.PASS, "Selected on Uploaded Date From : " + UploadedDateFrom);
			clickElement(driver, test, OCR_AddFromExcel_UploadedDateTo, "Click on Uploaded Date To");
			date(driver, test, "Selected on Uploaded Date To : ", UploadedDateTo);
			test.log(LogStatus.PASS, "Selected on Uploaded Date To : " + UploadedDateTo);
		}

		selectByVisibleText(driver, test, OCR_AddFromExcel_SortBy, "Select Sort By ", SortBy);
		selectByVisibleText(driver, test, OCR_AddFromExcel_Direction, "Select Direction ", Direction);

	}

	// Click on Search Button
	public void click_ProductSearch() throws InterruptedException {
		Wait.waitfor(5);
		clickElement(driver, test, OCR_AddFromExcel_Search, "Click on Product Search Button");
	}

}