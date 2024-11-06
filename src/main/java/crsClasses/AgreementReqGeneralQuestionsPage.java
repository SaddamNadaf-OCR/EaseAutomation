package crsClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class AgreementReqGeneralQuestionsPage extends GenericMethods{

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_Ques_NotApplicable="	//input[@name='notApplicableQues']"; 
	public static final String OCR_Button_Save="//button[contains(text(),'Save')]";
	public static final String OCR_Button_ForwardNavigation = "//button[@id='next-btn']";
	public static final String OCR_Questionnaire_Q1_Y = "//input[@id='createUpdateAggQues_responseObjective_0_Y']";
	public static final String OCR_Questionnaire_Q1_N = "//input[@id='editExportRequest_importQuestionnaireValue_replacementWithNoChargeN']";
	public static final String OCR_Questionnaire_Q1_DK = "//input[@id='editExportRequest_importQuestionnaireValue_replacementWithNoChargeD']";
	public static final String OCR_Questionnaire_Q2_Y = "//input[@id='editExportRequest_importQuestionnaireValue_repairUnderWarrentyY']";
	public static final String OCR_Questionnaire_Q2_N = "//input[@id='editExportRequest_importQuestionnaireValue_repairUnderWarrentyN']";
	public static final String OCR_Questionnaire_Q2_DK = "//input[@id='editExportRequest_importQuestionnaireValue_repairUnderWarrentyD']";
	public static final String OCR_Questionnaire_Q3_Y = "//input[@id='editExportRequest_importQuestionnaireValue_itemsControlledByUSY']";
	public static final String OCR_Questionnaire_Q3_N = "//input[@id='editExportRequest_importQuestionnaireValue_itemsControlledByUSN']";
	public static final String OCR_Questionnaire_Q3_DK = "//input[@id='editExportRequest_importQuestionnaireValue_itemsControlledByUSD']";
	public static final String OCR_Questionnaire_Q4_Y = "//input[@id='editExportRequest_importQuestionnaireValue_itemsControlledByForeignY']";
	public static final String OCR_Questionnaire_Q4_N = "//input[@id='editExportRequest_importQuestionnaireValue_itemsControlledByForeignN']";
	public static final String OCR_Questionnaire_Q4_DK = "//input[@id='editExportRequest_importQuestionnaireValue_itemsControlledByForeignD']";
	public static final String OCR_Questionnaire_Q5_Y = "//input[@id='editExportRequest_importQuestionnaireValue_markedAsRestrictedY']";
	public static final String OCR_Questionnaire_Q5_N = "//input[@id='editExportRequest_importQuestionnaireValue_markedAsRestrictedN']";
	public static final String OCR_Questionnaire_Q5_DK = "//input[@id='editExportRequest_importQuestionnaireValue_markedAsRestrictedD']";
	public static final String OCR_Questionnaire_Q6_Y = "//input[@id='editExportRequest_importQuestionnaireValue_exportedUnderLicenseY']";
	public static final String OCR_Questionnaire_Q6_N = "//input[@id='editExportRequest_importQuestionnaireValue_exportedUnderLicenseN']";
	public static final String OCR_Questionnaire_Q6_DK = "//input[@id='editExportRequest_importQuestionnaireValue_exportedUnderLicenseD']";
	public static final String OCR_Questionnaire_Q6_LicenseNo = "//input[@id='editExportRequest_importQuestionnaireValue_licenseNo']";	
	public static final String OCR_Questionnaire_Q7_Y = "//input[@id='editExportRequest_importQuestionnaireValue_importsClearedUnderLicenseY']";
	public static final String OCR_Questionnaire_Q7_N = "//input[@id='editExportRequest_importQuestionnaireValue_importsClearedUnderLicenseN']";
	public static final String OCR_Questionnaire_Q7_DK = "//input[@id='editExportRequest_importQuestionnaireValue_importsClearedUnderLicenseD']";
	public static final String OCR_Questionnaire_Q7_EntryNo = "//input[@id='editExportRequest_importQuestionnaireValue_entryNo']";	
	public static final String OCR_Questionnaire_Q8_Y = "//input[@id='editExportRequest_importQuestionnaireValue_itemsComeWithOutIntimationY']";
	public static final String OCR_Questionnaire_Q8_N = "//input[@id='editExportRequest_importQuestionnaireValue_itemsComeWithOutIntimationN']";
	public static final String OCR_Questionnaire_Q8_DK = "//input[@id='editExportRequest_importQuestionnaireValue_itemsComeWithOutIntimationD']";
	public static final String OCR_Questionnaire_Q9_Y = "//input[@id='editExportRequest_importQuestionnaireValue_itemsComingUnderBuildY']";
	public static final String OCR_Questionnaire_Q9_N = "//input[@id='editExportRequest_importQuestionnaireValue_itemsComingUnderBuildN']";
	public static final String OCR_Questionnaire_Q9_DK = "//input[@id='editExportRequest_importQuestionnaireValue_itemsComingUnderBuildD']";
	public static final String OCR_Questionnaire_Q9_PoNo = "//input[@id='editExportRequest_importQuestionnaireValue_poOrLicenseNo']";

	public AgreementReqGeneralQuestionsPage(WebDriver driver, ExtentTest test) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.test = test;
	}
	//Click on All Not Applicable checkbox
	public void notapplicable() {
		List<WebElement> na= driver.findElements(By.xpath(OCR_Ques_NotApplicable));

		for(int i=0; i< na.size(); i++) {
			WebElement nacheckbox=na.get(i);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript ("arguments[0].click();" , nacheckbox);
			//nacheckbox.click();		
		}
		Wait.waitfor(3);
	}	
    //Click on Save Button
	public void save() {
		clickElement(driver, test, OCR_Button_Save, "Clicking on Save Button: ");	
	}
    // Click on Forward Button
	public void moveForward() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath(OCR_Button_ForwardNavigation)));
	}
    
	//Validating General Questions Tab
	public void validate_GeneralQuestionsError() {
		try {
			if (isDisplayed(driver,"//h4[contains(text(),'Error')]")) {				

				test.log(LogStatus.PASS, "Error Vaildation is Displayed by clicking on SAVE button in General Questions Page");
				/*if (isDisplayed(driver,"//li[contains(text(),'General Questions Question:1 - Please select one of the options.')]")) {
					test.log(LogStatus.INFO, "Please Enter Party Name");
				}
				if (isDisplayed(driver,"//li[contains(text(),'31.3 group New Question:23 - Please select one of the options.')]")) {
					test.log(LogStatus.INFO, "31.3 group New Question:23 - Please select one of the options.");
				}
				if (isDisplayed(driver,"//li[contains(text(),'GroupDescription14 Question:26 - Please select one of the options.')]")) {
					test.log(LogStatus.INFO, "GroupDescription14 Question:26 - Please select one of the options.");
				}
				if (isDisplayed(driver,"//li[contains(text(),'new release test group Question:27 - Please select one of the options.')]")) {
					test.log(LogStatus.INFO, "new release test group Question:27 - Please select one of the options.");
				}*/
			}
		}
		catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Vaildation is not Displayed by clicking on SAVE button in General Questions Page");					
		}
	}	
    //Move to Export Under Agreement Tab
	public void moveto_ExportUnderAgreement() {
		clickElement(driver, test, "//span[contains(text(), 'Exports under Agreement')]", "Clicking on Exports under Agreement ");				
	}
	//Move to MLA Tab
	public void moveto_MLA() {
		clickElement(driver, test, "//span[contains(text(), 'MLA')]", "Clicking on MLA ");				
	}
    //Move to WDA Tab
	public void moveto_WDA() {
		clickElement(driver, test, "//span[contains(text(), 'WDA')]", "Clicking on WDA ");				
	}
	
	//Add Questionnaire based on requestor
	public void addQuestionnaire(String Questionnaire, String QuestionnaireAnswer) {

		if(Questionnaire.equalsIgnoreCase("Q1")) {
			if(QuestionnaireAnswer.equalsIgnoreCase("Y")) {
				clickElement(driver, test, OCR_Questionnaire_Q1_Y, "Click on Q1 replacement With NoCharge : Yes");
			}else if(QuestionnaireAnswer.equalsIgnoreCase("N")) {
				clickElement(driver, test, OCR_Questionnaire_Q1_N, "Click on Q1 replacement With NoCharge : No");
			}else {
				clickElement(driver, test, OCR_Questionnaire_Q1_DK, "Click on Q1 replacement With NoCharge : Dont know");
			}
		}
		if(Questionnaire.equalsIgnoreCase("Q2")) {
			if(QuestionnaireAnswer.equalsIgnoreCase("Y")) {
				clickElement(driver, test, OCR_Questionnaire_Q2_Y, "Click on Q2 repair Under Warrenty : Yes");
			}else if(QuestionnaireAnswer.equalsIgnoreCase("N")) {
				clickElement(driver, test, OCR_Questionnaire_Q2_N, "Click on Q2 repair Under Warrenty : No");
			}else {
				clickElement(driver, test, OCR_Questionnaire_Q2_DK, "Click on Q2 repair Under Warrenty : Dont Know");
			}
		}
		if(Questionnaire.equalsIgnoreCase("Q3")) {
			if(QuestionnaireAnswer.equalsIgnoreCase("Y")) {
				clickElement(driver, test, OCR_Questionnaire_Q3_Y, "Click on Q3 items Controlled By USD Agency : Yes");
			}else if(QuestionnaireAnswer.equalsIgnoreCase("N")) {
				clickElement(driver, test, OCR_Questionnaire_Q3_N, "Click on Q3 items Controlled By USD Agency : No");
			}else {
				clickElement(driver, test, OCR_Questionnaire_Q3_DK, "Click on Q3 items Controlled By USD Agency : Dont Know");
			}
		}
		if(Questionnaire.equalsIgnoreCase("Q4")) {
			if(QuestionnaireAnswer.equalsIgnoreCase("Y")) {
				clickElement(driver, test, OCR_Questionnaire_Q4_Y, "Click on Q4 items Controlled By Foreign Agency : Yes");
			}else if(QuestionnaireAnswer.equalsIgnoreCase("N")) {
				clickElement(driver, test, OCR_Questionnaire_Q4_N, "Click on Q4 items Controlled By Foreign Agency : No");
			}else {
				clickElement(driver, test, OCR_Questionnaire_Q4_DK, "Click on Q4 items Controlled By Foreign Agency : Dont Know");
			}
		}
		if(Questionnaire.equalsIgnoreCase("Q5")) {
			if(QuestionnaireAnswer.equalsIgnoreCase("Y")) {
				clickElement(driver, test, OCR_Questionnaire_Q5_Y, "Click on Q5 marked As Restricted : Yes");
			}else if(QuestionnaireAnswer.equalsIgnoreCase("N")) {
				clickElement(driver, test, OCR_Questionnaire_Q5_N, "Click on Q5 marked As Restricted : No");
			}else {			
				clickElement(driver, test, OCR_Questionnaire_Q5_DK, "Click on Q5 marked As Restricted : Dont Know");
			}
		}
		if(Questionnaire.equalsIgnoreCase("Q6")) {
			if(QuestionnaireAnswer.equalsIgnoreCase("Y")) {
				clickElement(driver, test, OCR_Questionnaire_Q6_Y, "Click on Q6 exported Under a License : Yes");
			}else if(QuestionnaireAnswer.equalsIgnoreCase("N")) {
				clickElement(driver, test, OCR_Questionnaire_Q6_N, "Click on Q6 exported Under a License : No");
			}else {
				clickElement(driver, test, OCR_Questionnaire_Q6_DK, "Click on Q6 exported Under a License : Dont Know");
			}
		}
		if(Questionnaire.equalsIgnoreCase("Q7")) {
			if(QuestionnaireAnswer.equalsIgnoreCase("Y")) {
				clickElement(driver, test, OCR_Questionnaire_Q7_Y, "Click on Q7 imports Cleared Under License : Yes");
			}else if(QuestionnaireAnswer.equalsIgnoreCase("N")) {
				clickElement(driver, test, OCR_Questionnaire_Q7_N, "Click on Q7 imports Cleared Under License : No");
			}else {
				clickElement(driver, test, OCR_Questionnaire_Q7_DK, "Click on Q7 imports Cleared Under License : Dont Know");
			}
		}
		if(Questionnaire.equalsIgnoreCase("Q8")) {
			if(QuestionnaireAnswer.equalsIgnoreCase("Y")) {
				clickElement(driver, test, OCR_Questionnaire_Q8_Y, "Click on Q8 items Come WithOut Intimation : Yes");
			}else if(QuestionnaireAnswer.equalsIgnoreCase("N")) {
				clickElement(driver, test, OCR_Questionnaire_Q8_N, "Click on Q8 items Come WithOut Intimation : No");
			}else {
				clickElement(driver, test, OCR_Questionnaire_Q8_DK, "Click on Q8 items Come WithOut Intimation : Dont Know");
			}
		}
		if(Questionnaire.equalsIgnoreCase("Q9")) {
			if(QuestionnaireAnswer.equalsIgnoreCase("Y")) {
				clickElement(driver, test, OCR_Questionnaire_Q9_Y, "Click on Q9 items Coming Under Build : Yes");
			}else if(QuestionnaireAnswer.equalsIgnoreCase("N")) {
				clickElement(driver, test, OCR_Questionnaire_Q9_N, "Click on Q9 items Coming Under Build : No");
			}else {
				clickElement(driver, test, OCR_Questionnaire_Q9_DK, "Click on Q9 items Coming Under Build : Dont Know");
			}
		}
	}


}

