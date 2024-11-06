package globalExportClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;

public class DeclarationDetailsDocumentsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_Customs_DDDoc_AddDocument = "//button[@id='documentAttachId']";
	public static final String OCR_Customs_DDDoc_DocumentType = "//select[@id='requiredDocTypeId']";
	public static final String OCR_Customs_DDDoc_Description = "//textarea[@id='editDCSFileAttach_documentDetail_comments']";
	public static final String OCR_Customs_DDDoc_UploadFile = "//i[@class='fa fa-upload']";
	public static final String OCR_Customs_DDDoc_SaveBtn = "//button[@id='saveButton']";
	public static final String OCR_Customs_DDDoc_PopUpClose = "//div[@id='ocrModal']//button[@class='close']";
	public static final String OCR_Customs_DDDoc_CancleBtn = "(//button[@name='cancel'][contains(text(),'Cancel')])[1]";

	/* ******************************* Constructor ****************************** */

	public DeclarationDetailsDocumentsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	//Add Document
	public void add_Document(String DocumentType, String DocumentDescription, String UploadFile) {
		clickElement(driver, test, OCR_Customs_DDDoc_AddDocument, "Clicking on View/AddDocument Button");
		try {
			Wait.waitfor(3);
			selectByVisibleText(driver, test, OCR_Customs_DDDoc_DocumentType, "Enter Document Type : ", DocumentType);
			typeText(driver, test, OCR_Customs_DDDoc_Description, "Enter Description : ", DocumentDescription);
			clickElement(driver, test, OCR_Customs_DDDoc_UploadFile, "click on upload file");
			uploadFile(driver, test, UploadFile, "upload document");
			Wait.waitfor(3);
			clickElement(driver, test, OCR_Customs_DDDoc_SaveBtn, "Click on Save button");
			clickElement(driver, test, OCR_Customs_DDDoc_CancleBtn, "Click on Cancle button");
		} catch (Exception e) {
			clickElement(driver, test, OCR_Customs_DDDoc_PopUpClose, "click on cancel");
			test.log(LogStatus.FAIL, "Click on cancel");
		}
	}
	
}
