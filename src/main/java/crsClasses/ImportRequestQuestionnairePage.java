package crsClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class ImportRequestQuestionnairePage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_Questionnaire_Q1_Y = "//input[@id='editExportRequest_importQuestionnaireValue_replacementWithNoChargeY']";
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
	public static final String OCR_Questionnaire_Save = "//input[@name='saveQuestion']";

	public static final String OCR_ContrctOrAgreemt_Q1_y = "//input[@id='editExportRequest_importQuestionnaireValue_contractsOrAgreementsY']";
	public static final String OCR_ContrctOrAgreemt_Q1_N = "//input[@id='editExportRequest_importQuestionnaireValue_contractsOrAgreementsN']";
	public static final String OCR_ContrctOrAgreemt_Q1_DK = "//input[@id='editExportRequest_importQuestionnaireValue_contractsOrAgreementsD']";
	public static final String OCR_Contrct_FMS_Q2_y = "//input[@id='editExportRequest_importQuestionnaireValue_fmsOrFmfContractY']";
	public static final String OCR_Contrct_FMS_Q2_N = "//input[@id='editExportRequest_importQuestionnaireValue_fmsOrFmfContractN']";
	public static final String OCR_Contrct_FMS_Q2_DK = "//input[@id='editExportRequest_importQuestionnaireValue_fmsOrFmfContractD']";

	public static final String OCR_Contrct_Fees_Q1_Y = "//input[@id='editExportRequest_importQuestionnaireValue_commissionOrFeesPaidY']";
	public static final String OCR_Contrct_Fees_Q1_N = "//input[@id='editExportRequest_importQuestionnaireValue_commissionOrFeesPaidN']";
	public static final String OCR_Contrct_Fees_Q1_DK = "//input[@id='editExportRequest_importQuestionnaireValue_commissionOrFeesPaidD']";
	public static final String OCR_Contrct_Fees_Q2_Y = "//input[@id='editExportRequest_importQuestionnaireValue_unExplainedFeesFromBrokerY']";
	public static final String OCR_Contrct_Fees_Q2_N = "//input[@id='editExportRequest_importQuestionnaireValue_unExplainedFeesFromBrokerN']";
	public static final String OCR_Contrct_Fees_Q2_DK = "//input[@id='editExportRequest_importQuestionnaireValue_unExplainedFeesFromBrokerD']";
	public static final String OCR_Contrct_Save = "//input[@name='saveContracts']";

	/* ******************** Constructor ***************************** */

	public ImportRequestQuestionnairePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

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

	//Click on Questionnaire Save Button
	public void click_SaveQuestion() {
		clickElement(driver, test, OCR_Questionnaire_Save, "Click on Questionnaire Save");
	} 

	//Contracts or Agreements Questions
	public void contractsQuestions(String ContractQuestions, String ContractAnswer) {
		if(ContractQuestions.equalsIgnoreCase("Q1")) {
			if(ContractAnswer.equalsIgnoreCase("Y")) {
				clickElement(driver, test, OCR_ContrctOrAgreemt_Q1_y, "Click on Q1 Contract or Agreements : Yes");
			}else if (ContractAnswer.equalsIgnoreCase("N")) {
				clickElement(driver, test, OCR_ContrctOrAgreemt_Q1_N, "Click on Q1 Contract or Agreements : No");
			}else {
				clickElement(driver, test, OCR_ContrctOrAgreemt_Q1_DK, "Click on Q1 Contract or Agreements : Dont Know");
			}
		}
		if(ContractQuestions.equalsIgnoreCase("Q2")) {
			if(ContractAnswer.equalsIgnoreCase("Y")) {
				clickElement(driver, test, OCR_Contrct_FMS_Q2_y, "Click on Q2 FMS OR FMF contract : Yes");
			}else if (ContractAnswer.equalsIgnoreCase("N")) {
				clickElement(driver, test, OCR_Contrct_FMS_Q2_N, "Click on Q2 FMS OR FMF contract : No");
			}else {
				clickElement(driver, test, OCR_Contrct_FMS_Q2_DK, "Click on Q2 FMS OR FMF contract : Dont Know");
			}
		}
	}

	//Contracts Fees Questions
	public void feesQuestions(String FeesQuestions, String FeesAnswer) {
		if(FeesQuestions.equalsIgnoreCase("Q1")) {
			if(FeesAnswer.equalsIgnoreCase("Y")) {
				clickElement(driver, test, OCR_Contrct_Fees_Q1_Y, "Click on Q1 Fees paid in relation : Yes");
			}else if (FeesAnswer.equalsIgnoreCase("N")) {
				clickElement(driver, test, OCR_Contrct_Fees_Q1_N, "Click on Q1 Fees paid in relation : No");
			}else {
				clickElement(driver, test, OCR_Contrct_Fees_Q1_DK, "Click on Q1 Fees Paid in relation : DontKnow");
			}
		}
		if(FeesQuestions.equalsIgnoreCase("Q2")) {
			if(FeesAnswer.equalsIgnoreCase("Y")) {
				clickElement(driver, test, OCR_Contrct_Fees_Q2_Y, "Click on Q2 Customs Broker, FF : Yes");
			}else if (FeesAnswer.equalsIgnoreCase("N")) {
				clickElement(driver, test, OCR_Contrct_Fees_Q2_N, "Click on Q2 Customs Broker, FF : No");
			}else {
				clickElement(driver, test, OCR_Contrct_Fees_Q2_DK, "Click on Q2 Customs Broker, FF : Dont Know");
			}
		}
	}

	//Click on Contract Save Button
	public void click_SaveContract() {
		clickElement(driver, test, OCR_Contrct_Save, "Click on Contract Save");
	} 

}
