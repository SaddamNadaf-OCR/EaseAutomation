package productClasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ImportClassificationPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_RegionalHSCode = "//input[@id='regionalClassificationId']";
	public static final String OCR_HSCode = "//input[@id='importClassificationId']";
	public static final String OCR_NewHSCode = "//input[@id='editProductCustomsClass_productCustomsClazz_newHtsClassification']";
	public static final String OCR_DateOfApplicability = "//input[@id='editProductCustomsClass_newAppDt']";
	public static final String OCR_DateRevised = "//input[@id='editProductExportClass_revisedDt']";
	public static final String OCR_ConfidenceLevel = "//select[@id='editProductCustomsClass_productCustomsClazz_levelCode']";
	public static final String OCR_Comments = "//textarea[@id='editProductCustomsClass_productCustomsClazz_remarks']";
	public static final String OCR_Button_AddPGADetails = "//button[@id='addPgaItem']";
	public static final String OCR_SchBClassification = "//label//a[contains(text(),'Statistical Classification')]";
	public static final String OCR_NReptClassification = "//input[@id='editProductCustomsClass_productCustomsClazz_newSchb']";
	public static final String OCR_Rationale = "//textarea[@id='editProductCustomsClass_productCustomsClazz_usmilRational']";
	public static final String OCR_GRI = "//textarea[@id='editProductCustomsClass_productCustomsClazz_gri']";
	public static final String OCR_ChaptersECnOTES = "//textarea[@id='editProductCustomsClass_productCustomsClazz_chapterNotes']";
	public static final String OCR_ExpNotes = "//textarea[@id='editProductCustomsClass_productCustomsClazz_explNotes']";
	public static final String OCR_Remarks = "//textarea[@id='editProductCustomsClass_productCustomsClazz_authRemarks']";
	public static final String OCR_Button_AddRulDet = "//button[@name='subInfo']";
	public static final String OCR_Button_Save = "//button[@id='mybuttonsmall']";
	public static final String OCR_Button_SavendReturn = "//button[contains(text(),'Save & Return')]";
	public static final String OCR_Button_Cancel = "//button[contains(text(),'Cancel')]";
	public static final String OCR_ExpClassification = "//a[contains(text(),'Export Classification')]";
	public static final String OCR_SchBClassDate = "//input[@id='schbDateId']";
	public static final String OCR_Button_Search = "//button[contains(text(),'Search')]";
	public static final String OCR_Button_Select = "//button[contains(text(),'Select')]";
	public static final String OCR_PopupClose="(//button[@class='btn-close'])[1]";
	public static final String OCR_statclassidetailheader="//label[contains(text(),'Statistical Classification Details')]";
	public static final String OCR_USMILclassdetailHeader="//label[contains(text(),'USMIL Classification Details')]";
	public static final String OCR_USMILclassification="(//a[contains(text(),'USMIL Classification')])[1]";
	public static final String OCR_USMILclassinput="//input[@id='searchForm_comMunitionsImportListValue_categoryNo']";
	public static final String OCR_SearchButton="(//button[@class='primary-btn popupSearchButton'])[1]";
	public static final String OCR_Select="(//button[@class='primary-btn recordFromPopup'])[1]";
	public static final String OCR_methodofdetImport="//textarea[@id='editProductCustomsClass_productCustomsClazz_impDeterMethod']";
	public static final String OCR_rationaleclassImport="//textarea[@id='editProductCustomsClass_productCustomsClazz_rationaleForClass']";
	/* ******************** Constructor ***************************** */
	public ImportClassificationPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public void enter_HSCode(String HSCode) {
		typeText(driver, test, OCR_HSCode, "Enter the HS Code : ", HSCode);
	}

	public void click_schBClassifdet() {
		scrollToElement(driver, OCR_statclassidetailheader);
		clickElement(driver, test, OCR_statclassidetailheader, "click on statistical classification header");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_SchBClassification, "Click on Statistical Classifcation");
	}

	// Add Statistical Classification is Added to the Result grid or not
	public void addschedulebToResultsGrid(String SchBClassification) {
		Wait.waitfor(15);
		try {
			typeText(driver, test, "//div[@id='content-cont']//input[@id='searchForm_schbhtsNo']",
					"Enter the HTS / Schedule B No : ", SchBClassification);
			search();
			String addSB = "//table[@id='gridPopup']/tbody/tr/td[contains(text(),'" + SchBClassification + "')]";
			if (isDisplayed(driver, addSB)) {
				clickElement(driver, test, addSB, "Click on search record");
				test.log(LogStatus.PASS, "Add SchB Classification in add to result grid table : " + SchBClassification);
				select();
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add SchB Classification in result grid table : " + SchBClassification);
			clickElement(driver, test, OCR_PopupClose, "Click on POP up close Icon");
		}

	//	typeText(driver, test, "//textarea[@id='editProductCustomsClass_productCustomsClazz_impDeterMethod']",
			//	"Enter the Method Of Determination (Import) : ", MethodOfDeterminationImport);
	}

	public void enter_schbclassdate(String SbClassificationDate) {
		scrollToElement(driver, "//label[contains(text(),'Schedule B Classification Details')]");
		// clickElement(driver, test, "//label[contains(text(),'Schedule B
		// Classification Details')]","Clicking on SAchedule B section");
		Wait.waitfor(3);
		clearText(driver, test, OCR_SchBClassDate, "Clear date");
		typeText(driver, test, OCR_SchBClassDate, "Enter Classification Date", SbClassificationDate);
	}
public void USMILClassDetail() {
	scrollToElement(driver, OCR_USMILclassdetailHeader);
	clickElement(driver, test, OCR_USMILclassdetailHeader, "click on USMIL classification header");
	Wait.waitfor(3);
	
}
public void USMILClassAdd(String USMILClass ) {
	if (USMILClass.length() > 0) {

			Wait.waitfor(3);
			clickElement(driver, test, OCR_USMILclassification, "click on USMIL classification");
			Wait.waitfor(3);
			try {
				typeText(driver, test, OCR_USMILclassinput, "Enter  ECCN USMIL no.", USMILClass);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_SearchButton, "Click on search button");
				Wait.waitfor(3);
				String ECCNO = "//td[contains(text(),'" + USMILClass + "')]";
				Wait.waitfor(3);
				clickElement(driver, test, ECCNO, "Click User :" + USMILClass);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_Select, "Click on search Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add UMIL classification ");
				clickElement(driver, test, OCR_PopupClose, "Close the popup");
			}}}

	public void enter_rationale(String Rationale) {
		scrollToElement(driver, "//label[contains(text(),'Customs Classification Authorization')]");
		//typeText(driver, test, "//textarea[@id='editProductCustomsClass_productCustomsClazz_schbDeterMethod']",
		//		"Enter the Import Method Of Determination (Statistical) : ", ImportSMethodOfDetermination);
		//typeText(driver, test, "//textarea[@id='editProductCustomsClass_productCustomsClazz_schbRationaleClassfn']",
			//	"Enter the  Import Rationale for Classification (Statistical) : ", ImportSRationaleforClassification);
		Wait.waitfor(3);
		clickElement(driver, test, "//label[contains(text(),'Customs Classification Authorization')]",
				"Clicking on Customs Classification Authorization");
		typeText(driver, test, OCR_Rationale, "Enter Rationale : ", Rationale);
	}

	public void enter_gri(String GRI) {
		typeText(driver, test, OCR_GRI, "Enter GRI : ", GRI);
	}

	public void enter_chaptersecnotes(String ChapterSectionNotes) {
		typeText(driver, test, OCR_ChaptersECnOTES, "Enter chapter notes : ", ChapterSectionNotes);
	}

	public void enter_expnotes(String ExplanatoryNotes) {
		typeText(driver, test, OCR_ExpNotes, "Enter explanatory notes : ", ExplanatoryNotes);
	}

	public void enter_remarks(String Remarks) {
		typeText(driver, test, OCR_Remarks, "Enter remarks : ", Remarks);
	}

	public void click_addrulingdetails() {
		clickElement(driver, test, OCR_Button_AddRulDet, "Click on Ruling Details");
	}

	public void save() {
		clickElement(driver, test, OCR_Button_Save, "Clicking on Save Button");
		Wait.waitfor(3);
	}

	public void savendreturn() {
		scrollToElement(driver, OCR_Button_SavendReturn);
		
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_SavendReturn, "Clicking on Save and Return Button");
		Wait.waitfor(5);
		driver.switchTo().alert().accept();
		Wait.waitfor(5);
	driver.switchTo().alert().accept();
		Wait.waitfor(5);
	//	driver.switchTo().alert().accept();
	//	Wait.waitfor(3);
	
		

	}

	public void search() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_Search, "Clicking on Search Button");
	}

	public void select() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_Select, "Clicking on Select Button");
		Wait.waitfor(3);
	}

	public void validate_ImpClassifError() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {

				if (isDisplayed(driver,
						"//li[contains(text(),'Import  Classification Or  Statistical Reporting Classification or USMIL Classification is required to save.')]")) {
					test.log(LogStatus.INFO,
							"Import  Classification Or  Statistical Reporting Classification or USMIL Classification is required to save.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Either HS Code or Schedule B or USMIL Classification is required.')]")) {
					test.log(LogStatus.INFO, "Either HS Code or Schedule B or USMIL Classification is required.");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Validation is not Displayed by clicking on SAVE button in Import Classification Details Page");
		}
	}

	public void validate_ImpScheduleBError() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {

				if (isDisplayed(driver,
						"//li[contains(text(),'Import  Classification Or Statistical Reporting Classification  is required to save.')]")) {
					test.log(LogStatus.INFO,
							"Import  Classification Or  Statistical Reporting Classification  is required to save.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Either HS Code or Schedule B is required.')]")) {
					test.log(LogStatus.INFO, "Either HS Code or Schedule B is required.");
				}

			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Validation is not Displayed by clicking on SAVE button in Import Classification Details Page");
		}}
	
		public void methodDEtImport(String methodDETIpmort) {
			typeText(driver, test, OCR_methodofdetImport, "enter method of determination for import", methodDETIpmort);
	}
public void rationlforclassimp(String RationaleclassImport)
{
	typeText(driver, test, OCR_rationaleclassImport, "Rationale for classificaton import", RationaleclassImport);
}
}
