package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class UploadBOMPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_HomePage_ListScreening="//ul[@class='nav navbar-nav']/li[2]/a";
	public static final String OCR_ExportOPerationsHomePage = "(//a[contains(text(),'Export Operations')])[1]";
	public static final String OCR_SearchProduct_Files="//ul[@class='nav navbar-nav']/li[5]/a";
	public static final String OCR_SearchProduct_Product="(//a[contains(text(),'Products')])[1]";
	public static final String OCR_AddFromExcel="//button[contains(text(),'Add From Excel')]";
	public static final String OCR_UploadBOMbtn="//button[@id='uploadButton']";
	public static final String OCR_Uploadfilebn="//span[@class='btn fileinput-button']";
	public static final String OCR_AddFromExcel_CloseButton ="//button[@name='btn-sbmt']";
	public static final String OCR_refNo="//input[@id='refNo']";
	public static final String OCR_BomDesc="//input[@id='bomDesc']";
	
	

	/* ******************** Constructor ***************************** */
	public UploadBOMPage(WebDriver driver, ExtentTest test) { 
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	
	
	public void BOMFileupld() throws InterruptedException, Exception {
		
		clickElement(driver, test, OCR_UploadBOMbtn, "Click Upload File Button");
	}
		public void BOMInput(String RefNo, String BOMDesc) {
		
		typeText(driver, test, OCR_refNo, "Add reference No", RefNo);
		typeText(driver, test, OCR_BomDesc, "add BOM description", BOMDesc);
		
	}
	
	public void attachFile() throws InterruptedException {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_Uploadfilebn, "Click Upload File Button");
		uploadFile(driver, test, "ProductUpload.xlsx", "Uploading the excel : ProductUpload.xlsx" );
		Wait.waitfor(20);
		clickElement(driver, test, OCR_AddFromExcel_CloseButton, "Click Close Button");
		Wait.waitfor(4);
		//clickElement(driver, test, FileSeearch, "Click Close Button");
	//	Wait.waitfor(8);
		
	}

	

	public void click_close() {
		clickElement(driver, test,"(//button[@class='close'])[1]","Close Dialog Box: Unable to Upload excel File");
	}

}
