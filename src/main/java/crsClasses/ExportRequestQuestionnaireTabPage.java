package crsClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class ExportRequestQuestionnaireTabPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/********************** Loactors *******************************/
	public static final String OCR_ExportQuestionnaire_Q1_Y = "//input[@id='editExportRequest_exportQuestionnaireValue_haveConfPoOrLoiY']";
	public static final String OCR_ExportQuestionnaire_Q1_N = "//input[@id='editExportRequest_exportQuestionnaireValue_haveConfPoOrLoiN']";
	public static final String OCR_ExportQuestionnaire_Q1_DK = "//input[@id='editExportRequest_exportQuestionnaireValue_haveConfPoOrLoiD']";
	public static final String OCR_ExportQuestionnaire_Q2_Y = "//input[@id='editExportRequest_exportQuestionnaireValue_recEndUserStmtY']";
	public static final String OCR_ExportQuestionnaire_Q2_N = "//input[@id='editExportRequest_exportQuestionnaireValue_recEndUserStmtN']";
	public static final String OCR_ExportQuestionnaire_Q2_DK = "//input[@id='editExportRequest_exportQuestionnaireValue_recEndUserStmtD']";
	public static final String OCR_ExportQuestionnaire_Q3_Y = "//input[@id='editExportRequest_exportQuestionnaireValue_signedDsp83Y']";
	public static final String OCR_ExportQuestionnaire_Q3_N = "//input[@id='editExportRequest_exportQuestionnaireValue_signedDsp83N']";
	public static final String OCR_ExportQuestionnaire_Q3_DK = "//input[@id='editExportRequest_exportQuestionnaireValue_signedDsp83D']";
	public static final String OCR_ExportQuestionnaire_Q4_Y = "//input[@id='editExportRequest_exportQuestionnaireValue_loaFromPartyY']";
	public static final String OCR_ExportQuestionnaire_Q4_N = "//input[@id='editExportRequest_exportQuestionnaireValue_loaFromPartyN']";
	public static final String OCR_ExportQuestionnaire_Q4_DK = "//input[@id='editExportRequest_exportQuestionnaireValue_loaFromPartyD']";
	public static final String OCR_ExportQuestionnaire_Q5_Y = "//input[@id='editExportRequest_exportQuestionnaireValue_anyProdsContByUsAgenciesY']";
	public static final String OCR_ExportQuestionnaire_Q5_N = "//input[@id='editExportRequest_exportQuestionnaireValue_anyProdsContByUsAgenciesN']";
	public static final String OCR_ExportQuestionnaire_Q5_DK = "//input[@id='editExportRequest_exportQuestionnaireValue_anyProdsContByUsAgenciesD']";
	public static final String OCR_ExportQuestionnaire_Q6_Y = "//input[@id='editExportRequest_exportQuestionnaireValue_militaryEndUseCustomersY']";
	public static final String OCR_ExportQuestionnaire_Q6_N = "//input[@id='editExportRequest_exportQuestionnaireValue_militaryEndUseCustomersN']";
	public static final String OCR_ExportQuestionnaire_Q6_DK = "//input[@id='editExportRequest_exportQuestionnaireValue_militaryEndUseCustomersD']";
	public static final String OCR_ExportQuestionnaire_Q7_Y = "//input[@id='editExportRequest_exportQuestionnaireValue_usOriginY']";
	public static final String OCR_ExportQuestionnaire_Q7_N = "//input[@id='editExportRequest_exportQuestionnaireValue_usOriginN']";
	public static final String OCR_ExportQuestionnaire_Q7_DK = "//input[@id='editExportRequest_exportQuestionnaireValue_usOriginD']";
	public static final String OCR_ExportQuestionnaire_Q7_N_COO_ItemNO_TextBox = "//input[@id='editExportRequest_exportQuestionnaireValue_countryAndItemNo']";
	public static final String OCR_ExportQuestionnaire_Q8_Y = "//input[@id='editExportRequest_exportQuestionnaireValue_similarItemsExportedY']";
	public static final String OCR_ExportQuestionnaire_Q8_N = "//input[@id='editExportRequest_exportQuestionnaireValue_similarItemsExportedN']";
	public static final String OCR_ExportQuestionnaire_Q8_DK = "//input[@id='editExportRequest_exportQuestionnaireValue_similarItemsExportedD']";
	public static final String OCR_ExportQuestionnaire_Q8_Y_LicenseNo = "//input[@id='editExportRequest_exportQuestionnaireValue_precedentLicenseInfo']";
	public static final String OCR_ExportQuestionnaire_Q9_Y = "//input[@id='editExportRequest_exportQuestionnaireValue_expIntendedUsY']";
	public static final String OCR_ExportQuestionnaire_Q9_N = "//input[@id='editExportRequest_exportQuestionnaireValue_expIntendedUsN']";
	public static final String OCR_ExportQuestionnaire_Q9_DK = "//input[@id='editExportRequest_exportQuestionnaireValue_expIntendedUsD']";
	public static final String OCR_ExportQuestionnaire_Q10_Y = "//input[@id='editExportRequest_exportQuestionnaireValue_transferOfTechY']";
	public static final String OCR_ExportQuestionnaire_Q10_N = "//input[@id='editExportRequest_exportQuestionnaireValue_transferOfTechN']";
	public static final String OCR_ExportQuestionnaire_Q10_DK = "//input[@id='editExportRequest_exportQuestionnaireValue_transferOfTechD']";
	public static final String OCR_Questionnaire_Save = "//input[@name='saveQuestion']";
	public static final String OCR_Ques_NotApplicable = "//input[@name='notApplicableStdQues']";
	public static final String OCR_Ques_NotApplicable1 = "//input[@name='notApplicableStdQuestionnaire']";
	public static final String OCR_Button_ForwardNavigation = "(//button[@id='next-btn'])[11]";
	public static final String OCR_ContractQue_Save = "//input[@name='saveContracts']"; 
	public static final String OCR_AdditionalQues_Tab = "//span[contains(text(),'Additional Questions')]";

	/* ******************** Constructor ***************************** */

	public ExportRequestQuestionnaireTabPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/******************** Actions *************************************************/

	// Adding the Questionnaire
	public void addQuestionnaire(String Questionnaire, String QuestionnaireAnswer) {
		if (Questionnaire.equalsIgnoreCase("Q1")) {
			if (QuestionnaireAnswer.equalsIgnoreCase("Y")) {
				clickElement(driver, test, OCR_ExportQuestionnaire_Q1_Y, "Click on Q1 replacement With NoCharge : Yes");
			} else if (QuestionnaireAnswer.equalsIgnoreCase("N")) {
				clickElement(driver, test, OCR_ExportQuestionnaire_Q1_N, "Click on Q1 replacement With NoCharge : No");
			} else {
				clickElement(driver, test, OCR_ExportQuestionnaire_Q1_DK,
						"Click on Q1 replacement With NoCharge : Dont know");
			}
		}
		if (Questionnaire.equalsIgnoreCase("Q2")) {
			if (QuestionnaireAnswer.equalsIgnoreCase("Y")) {
				clickElement(driver, test, OCR_ExportQuestionnaire_Q2_Y, "Click on Q2 repair Under Warrenty : Yes");
			} else if (QuestionnaireAnswer.equalsIgnoreCase("N")) {
				clickElement(driver, test, OCR_ExportQuestionnaire_Q2_N, "Click on Q2 repair Under Warrenty : No");
			} else {
				clickElement(driver, test, OCR_ExportQuestionnaire_Q2_DK,
						"Click on Q2 repair Under Warrenty : Dont Know");
			}
		}
		if (Questionnaire.equalsIgnoreCase("Q3")) {
			if (QuestionnaireAnswer.equalsIgnoreCase("Y")) {
				clickElement(driver, test, OCR_ExportQuestionnaire_Q3_Y,
						"Click on Q3 items Controlled By USD Agency : Yes");
			} else if (QuestionnaireAnswer.equalsIgnoreCase("N")) {
				clickElement(driver, test, OCR_ExportQuestionnaire_Q3_N,
						"Click on Q3 items Controlled By USD Agency : No");
			} else {
				clickElement(driver, test, OCR_ExportQuestionnaire_Q3_DK,
						"Click on Q3 items Controlled By USD Agency : Dont Know");
			}
		}
		if (Questionnaire.equalsIgnoreCase("Q4")) {
			if (QuestionnaireAnswer.equalsIgnoreCase("Y")) {
				clickElement(driver, test, OCR_ExportQuestionnaire_Q4_Y,
						"Click on Q4 items Controlled By Foreign Agency : Yes");
			} else if (QuestionnaireAnswer.equalsIgnoreCase("N")) {
				clickElement(driver, test, OCR_ExportQuestionnaire_Q4_N,
						"Click on Q4 items Controlled By Foreign Agency : No");
			} else {
				clickElement(driver, test, OCR_ExportQuestionnaire_Q4_DK,
						"Click on Q4 items Controlled By Foreign Agency : Dont Know");
			}
		}
		if (Questionnaire.equalsIgnoreCase("Q5")) {
			if (QuestionnaireAnswer.equalsIgnoreCase("Y")) {
				clickElement(driver, test, OCR_ExportQuestionnaire_Q5_Y, "Click on Q5 marked As Restricted : Yes");
			} else if (QuestionnaireAnswer.equalsIgnoreCase("N")) {
				clickElement(driver, test, OCR_ExportQuestionnaire_Q5_N, "Click on Q5 marked As Restricted : No");
			} else {
				clickElement(driver, test, OCR_ExportQuestionnaire_Q5_DK,
						"Click on Q5 marked As Restricted : Dont Know");
			}
		}
		if (Questionnaire.equalsIgnoreCase("Q6")) {
			if (QuestionnaireAnswer.equalsIgnoreCase("Y")) {
				clickElement(driver, test, OCR_ExportQuestionnaire_Q6_Y, "Click on Q6 exported Under a License : Yes");
			} else if (QuestionnaireAnswer.equalsIgnoreCase("N")) {
				clickElement(driver, test, OCR_ExportQuestionnaire_Q6_N, "Click on Q6 exported Under a License : No");
			} else {
				clickElement(driver, test, OCR_ExportQuestionnaire_Q6_DK,
						"Click on Q6 exported Under a License : Dont Know");
			}
		}
		if (Questionnaire.equalsIgnoreCase("Q7")) {
			if (QuestionnaireAnswer.equalsIgnoreCase("Y")) {
				clickElement(driver, test, OCR_ExportQuestionnaire_Q7_Y,
						"Click on Q7 imports Cleared Under License : Yes");
			} else if (QuestionnaireAnswer.equalsIgnoreCase("N")) {
				clickElement(driver, test, OCR_ExportQuestionnaire_Q7_N,
						"Click on Q7 imports Cleared Under License : No");
			} else {
				clickElement(driver, test, OCR_ExportQuestionnaire_Q7_DK,
						"Click on Q7 imports Cleared Under License : Dont Know");
			}
		}
		if (Questionnaire.equalsIgnoreCase("Q8")) {
			if (QuestionnaireAnswer.equalsIgnoreCase("Y")) {
				clickElement(driver, test, OCR_ExportQuestionnaire_Q8_Y,
						"Click on Q8 items Come WithOut Intimation : Yes");
			} else if (QuestionnaireAnswer.equalsIgnoreCase("N")) {
				clickElement(driver, test, OCR_ExportQuestionnaire_Q8_N,
						"Click on Q8 items Come WithOut Intimation : No");
			} else {
				clickElement(driver, test, OCR_ExportQuestionnaire_Q8_DK,
						"Click on Q8 items Come WithOut Intimation : Dont Know");
			}
		}
		if (Questionnaire.equalsIgnoreCase("Q9")) {
			if (QuestionnaireAnswer.equalsIgnoreCase("Y")) {
				clickElement(driver, test, OCR_ExportQuestionnaire_Q9_Y, "Click on Q9 items Coming Under Build : Yes");
			} else if (QuestionnaireAnswer.equalsIgnoreCase("N")) {
				clickElement(driver, test, OCR_ExportQuestionnaire_Q9_N, "Click on Q9 items Coming Under Build : No");
			} else {
				clickElement(driver, test, OCR_ExportQuestionnaire_Q9_DK,
						"Click on Q9 items Coming Under Build : Dont Know");
			}
		}
		if (Questionnaire.equalsIgnoreCase("Q9")) {
			if (QuestionnaireAnswer.equalsIgnoreCase("Y")) {
				clickElement(driver, test, OCR_ExportQuestionnaire_Q10_Y, "Click on Q9 items Coming Under Build : Yes");
			} else if (QuestionnaireAnswer.equalsIgnoreCase("N")) {
				clickElement(driver, test, OCR_ExportQuestionnaire_Q10_N, "Click on Q9 items Coming Under Build : No");
			} else {
				scrollToBottom(driver);
				clickElement(driver, test, OCR_ExportQuestionnaire_Q10_DK,
						"Click on Q9 items Coming Under Build : Dont Know");
			}
		}
	}
	
	//Click on All Not Applicable checkbox
		public void notapplicable() {
			List<WebElement> na= driver.findElements(By.xpath(OCR_Ques_NotApplicable1));
			scrollToElement(driver, OCR_Ques_NotApplicable1);
			for(int i=0; i< na.size(); i++) {
				//System.out.println(na.size());
				WebElement nacheckbox=na.get(i);
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript ("arguments[0].click();" , nacheckbox);	
			}
			Wait.waitfor(3);
			//scrollToElement(driver, OCR_Ques_NotApplicable1);
		}	

	// Click on Questionnaire Save Button
	public void click_SaveQuestion() {
		scrollToElement(driver, OCR_Questionnaire_Save);
		clickElement(driver, test, OCR_Questionnaire_Save, "Click on Questionnaire Save");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ExportQuestionnaire_Q1_Y, "");
	}
	
	//Click on Forward Button
		public void moveForward() {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath(OCR_Button_ForwardNavigation)));
		} 
}
