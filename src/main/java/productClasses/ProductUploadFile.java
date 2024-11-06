package productClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class ProductUploadFile extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_HomePage_ListScreening="//ul[@class='nav navbar-nav']/li[2]/a";
	public static final String OCR_ExportOPerationsHomePage = "(//a[contains(text(),'Export Operations')])[1]";
	public static final String OCR_SearchProduct_Files="//ul[@class='nav navbar-nav']/li[5]/a";
	public static final String OCR_SearchProduct_Product="(//a[contains(text(),'Products')])[1]";
	public static final String OCR_AddFromExcel="//button[contains(text(),'Add From Excel')]";
	public static final String OCR_AddFromExcel_UploadFile ="//button[@id='uploadButton']";
	public static final String OCR_AddFromExcel_ExcelUploadFile ="//span[@class='btn fileinput-button']";
	public static final String OCR_AddFromExcel_BacktoProductFile ="//button[contains(text(),'Back to Product File')]";
	public static final String OCR_AddFromExcel_AttachUploadFile ="//span[@class='btn fileinput-button']";
	public static final String OCR_AddFromExcel_CloseButton ="//button[@name='btn-sbmt']";
	public static final String OCR_SearchProduct_PartNo = "//input[@id='searchProduct_product_productCode']";
	public static final String OCR_ProductSearchButton="//button[contains(text(),'Search')]";
	public static final String OCR_ProductSearchPartNo="//a[@class='pName-tooltip']";
	public static final String FileSeearch="//button[contains(text(),'Search')]";
	
	
	/* ******************** Constructor ***************************** */
	public ProductUploadFile(WebDriver driver, ExtentTest test) { 
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
	
	public void excelUploadFile() throws InterruptedException, Exception {
		clickElement(driver, test, OCR_AddFromExcel_UploadFile, "Click Upload File Button");
		AlertPopUp(driver, test, "Are you uploading the file for ECR Update?");
		
	}
	
	public void attachFile() throws InterruptedException {
		Wait.waitfor(4);
		clickElement(driver, test, OCR_AddFromExcel_ExcelUploadFile, "Click Upload File Button");
		uploadFile(driver, test, "PRODUCT_UPLOAD.xlsx", "Uploading the excel : PRODUCT_UPLOAD.xlsx" );
		Wait.waitfor(20);
		clickElement(driver, test, OCR_AddFromExcel_CloseButton, "Click Close Button");
		Wait.waitfor(4);
		clickElement(driver, test, FileSeearch, "Click Close Button");
		Wait.waitfor(15);
		
	}
	
	public void validateUploadFile() throws InterruptedException, Exception {
		mouseOver(driver, test, OCR_SearchProduct_Files, "Click on Files");
		Wait.waitfor(4);
		clickElement(driver, test, OCR_SearchProduct_Product, "Click Products");
		typeText(driver, test, OCR_SearchProduct_PartNo, "Enter Part No ", "GSH00001");
		clickElement(driver, test, OCR_ProductSearchButton, "Click on Search Button");
		Wait.waitfor(4);
		clickElement(driver, test, OCR_ProductSearchPartNo, "Click on PartNo");
		Wait.waitfor(8);
	}
	
	public void click_close() {
		clickElement(driver, test,"(//button[@class='btn-close'])[1]","Close Dialog Box: Unable to Upload excel File");
	}

}
