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

public class FTAdditionalInfoQuestionnairePage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_NotApplicable = "//input[@id='editForeignTravelGeneralInfo_quesNotApplicable']";
	public static final String OCR_Button_Save = "//button[@name='saveGenInfo']";
	public static final String OCR_Button_ForwardNavigation = "//button[@id='next-btn']";
	public static final String OCR_NotApplicable1 ="//input[@name='notApplicable']";
	public static final String OCR_ExportQuestionnaire_Q1_Y = "//input[@id='editForeignTravelGeneralInfo_foreignTravelQuestionnaireValue_exportTrainingY']";
	public static final String OCR_ExportQuestionnaire_Q1_N = "//input[@id='editForeignTravelGeneralInfo_foreignTravelQuestionnaireValue_exportTrainingN']";
	public static final String OCR_ExportQuestionnaire_Q2_Y = "//input[@id='editForeignTravelGeneralInfo_foreignTravelQuestionnaireValue_validLicenseY']";
	public static final String OCR_ExportQuestionnaire_Q2_N = "//input[@id='editForeignTravelGeneralInfo_foreignTravelQuestionnaireValue_validLicenseN']";
	public static final String OCR_ExportQuestionnaire_Q2_TextBox = "//input[@id='editForeignTravelGeneralInfo_foreignTravelQuestionnaireValue_licenseNo']";
	public static final String OCR_ExportQuestionnaire_Q3_Y = "//input[@id='editForeignTravelGeneralInfo_foreignTravelQuestionnaireValue_classifiedY']";
	public static final String OCR_ExportQuestionnaire_Q3_N = "//input[@id='editForeignTravelGeneralInfo_foreignTravelQuestionnaireValue_classifiedN']";
	public static final String OCR_ExportQuestionnaire_Q4_Y = "//input[@id='editForeignTravelGeneralInfo_foreignTravelQuestionnaireValue_exportCtrlInfoY']";
	public static final String OCR_ExportQuestionnaire_Q4_N = "//input[@id='editForeignTravelGeneralInfo_foreignTravelQuestionnaireValue_exportCtrlInfoN']";
	public static final String OCR_ExportQuestionnaire_Q5_Y = "//input[@id='editForeignTravelGeneralInfo_foreignTravelQuestionnaireValue_techDataDemoY']";
	public static final String OCR_ExportQuestionnaire_Q5_N = "//input[@id='editForeignTravelGeneralInfo_foreignTravelQuestionnaireValue_techDataDemoN']";
	public static final String OCR_ExportQuestionnaire_Q5_Textbox = "//textarea[@id='editForeignTravelGeneralInfo_foreignTravelQuestionnaireValue_techData']";
	public static final String OCR_ExportQuestionnaire_Q5_Textbox1 = "//input[@id='editForeignTravelGeneralInfo_foreignTravelQuestionnaireValue_contractNo']";
	public static final String OCR_ExportQuestionnaire_Q6_USPerson = "//input[@id='editForeignTravelGeneralInfo_usPersons-1']";
	public static final String OCR_ExportQuestionnaire_Q6_ForeignPerson = "//input[@id='editForeignTravelGeneralInfo_foreignPersons-1']";
	public static final String OCR_ExportQuestionnaire_Q6_USCitizen = "//input[@id='editForeignTravelGeneralInfo_usCitizens-1']";
	public static final String OCR_ExportQuestionnaire_Q6_USGov_DOD = "//input[@id='editForeignTravelGeneralInfo_usg-1']";
	public static final String OCR_ExportQuestionnaire_Q6_a_SoftInstallation = "//input[@id='editForeignTravelGeneralInfo_installations-1']";
	public static final String OCR_ExportQuestionnaire_Q6_a_Maintenance = "//input[@id='editForeignTravelGeneralInfo_maintenance-1']";
	public static final String OCR_ExportQuestionnaire_Q6_a_Test = "//input[@id='editForeignTravelGeneralInfo_test-1']";
	public static final String OCR_ExportQuestionnaire_Q6_a_Repair = "//input[@id='editForeignTravelGeneralInfo_repair-1']";
	public static final String OCR_ExportQuestionnaire_Q6_a_MilitaryTraining = "//input[@id='editForeignTravelGeneralInfo_militaryTraining-1']";
	public static final String OCR_ExportQuestionnaire_Q6_a_Other = "//input[@id='editForeignTravelGeneralInfo_other-1']";
	public static final String OCR_ExportQuestionnaire_Q6_a_Textbox = "//textarea[@id='editForeignTravelGeneralInfo_foreignTravelQuestionnaireValue_others']";
	public static final String OCR_ExportQuestionnaire_Q6_b_Y = "//input[@id='editForeignTravelGeneralInfo_foreignTravelQuestionnaireValue_militarySaleY']";
	public static final String OCR_ExportQuestionnaire_Q6_b_N = "//input[@id='editForeignTravelGeneralInfo_foreignTravelQuestionnaireValue_militarySaleN']";
	public static final String OCR_ExportQuestionnaire_Q6_b_Textbox = "//input[@id='editForeignTravelGeneralInfo_foreignTravelQuestionnaireValue_fmsFmfCaseNo']";
	public static final String OCR_ExportQuestionnaire_Q7_Y = "//input[@id='editForeignTravelGeneralInfo_foreignTravelQuestionnaireValue_bodyArmourY']";
	public static final String OCR_ExportQuestionnaire_Q7_N ="//input[@id='editForeignTravelGeneralInfo_foreignTravelQuestionnaireValue_bodyArmourN']";
	public static final String OCR_ExportQuestionnaire_Q7_a_Textbox = "//textarea[@id='editForeignTravelGeneralInfo_foreignTravelQuestionnaireValue_armourDescription']";
	public static final String OCR_ExportQuestionnaire_Q7_b_Y = "//input[@id='editForeignTravelGeneralInfo_foreignTravelQuestionnaireValue_companyArmourY']";
	public static final String OCR_ExportQuestionnaire_Q7_b_N = "//input[@id='editForeignTravelGeneralInfo_foreignTravelQuestionnaireValue_companyArmourN']";
	public static final String OCR_ExportQuestionnaire_Q8_Y = "//input[@id='editForeignTravelGeneralInfo_foreignTravelQuestionnaireValue_firearmsY']";
	public static final String OCR_ExportQuestionnaire_Q8_N = "//input[@id='editForeignTravelGeneralInfo_foreignTravelQuestionnaireValue_firearmsN']";
	public static final String OCR_ExportQuestionnaire_Q8_Textbox = "//textarea[@id='editForeignTravelGeneralInfo_foreignTravelQuestionnaireValue_firearmDescription']";
	public static final String OCR_ExportQuestionnaire_Q8_b_Y = "//input[@id='editForeignTravelGeneralInfo_foreignTravelQuestionnaireValue_firearmLicenseY']";
	public static final String OCR_ExportQuestionnaire_Q8_b_N = "//input[@id='editForeignTravelGeneralInfo_foreignTravelQuestionnaireValue_firearmLicenseN']";
	public static final String OCR_ExportQuestionnaire_Q9_Y = "//input[@id='editForeignTravelGeneralInfo_foreignTravelQuestionnaireValue_techDataDeliveryY']";
	public static final String OCR_ExportQuestionnaire_Q9_N = "//input[@id='editForeignTravelGeneralInfo_foreignTravelQuestionnaireValue_techDataDeliveryN']";
	public static final String OCR_ExportQuestionnaire_Q9_a_Textbox = "//textarea[@id='editForeignTravelGeneralInfo_foreignTravelQuestionnaireValue_techDataDescription']";
	public static final String OCR_ExportQuestionnaire_Q9_b_Textbox = "//textarea[@id='editForeignTravelGeneralInfo_foreignTravelQuestionnaireValue_deliverTo']";

	/* ******************************** Constructor ******************************** */
	public FTAdditionalInfoQuestionnairePage(WebDriver driver, ExtentTest test) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.test = test;
	}
	//Click on Not Applicable CheckBox
	public void click_notapplicable(){		
		clickElement(driver, test, "//input[@id='editForeignTravelGeneralInfo_foreignTravelQuestionnaireValue_licenseNo']", "");
		Wait.waitfor(3);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath("//span[contains(text(),'Questionnaire')]")));
		Wait.waitfor(3);
		clickElement(driver, test, OCR_NotApplicable,"Click on Not Applicable CheckBox :");	
		scrollToBottom(driver);
	}
	
	// Adding the Questionnaire
		public void addQuestionnaire(String Questionnaire, String QuestionnaireAnswer) {
			//clickElement(driver, test, OCR_ExportQuestionnaire_Q1_N, "");
			Wait.waitfor(3);
			if (Questionnaire.equalsIgnoreCase("Q1")) {
				if (QuestionnaireAnswer.equalsIgnoreCase("Y")) {
					clickElement(driver, test, OCR_ExportQuestionnaire_Q1_Y, "Have you completed Trade Compliance training within the last 12 months? : Yes");
				} else if (QuestionnaireAnswer.equalsIgnoreCase("N")) {
					clickElement(driver, test, OCR_ExportQuestionnaire_Q1_N, "Have you completed Trade Compliance training within the last 12 months? : No");
				}
			}
			if (Questionnaire.equalsIgnoreCase("Q2")) {
				if (QuestionnaireAnswer.equalsIgnoreCase("Y")) {
					clickElement(driver, test, OCR_ExportQuestionnaire_Q2_Y, "Is your trip related to a valid export authorization (license or agreement)? : Yes");
				} else if (QuestionnaireAnswer.equalsIgnoreCase("N")) {
					clickElement(driver, test, OCR_ExportQuestionnaire_Q2_N, "Is your trip related to a valid export authorization (license or agreement)? : No");
				}
			}
			if (Questionnaire.equalsIgnoreCase("Q3")) {
				if (QuestionnaireAnswer.equalsIgnoreCase("Y")) {
					clickElement(driver, test, OCR_ExportQuestionnaire_Q3_Y, "Is the information pertaining to your trip classified/restricted? : Yes");
				} else if (QuestionnaireAnswer.equalsIgnoreCase("N")) {
					clickElement(driver, test, OCR_ExportQuestionnaire_Q3_N, "Is the information pertaining to your trip classified/restricted? : No");
				}
			}
			if (Questionnaire.equalsIgnoreCase("Q4")) {
				if (QuestionnaireAnswer.equalsIgnoreCase("Y")) {
					clickElement(driver, test, OCR_ExportQuestionnaire_Q4_Y, "Are you personally hand carrying any Export Controlled or Government-owned equipment, software or information? : Yes");
				} else if (QuestionnaireAnswer.equalsIgnoreCase("N")) {
					clickElement(driver, test, OCR_ExportQuestionnaire_Q4_N, "Are you personally hand carrying any Export Controlled or Government-owned equipment, software or information? : No");
				}
			}
			if (Questionnaire.equalsIgnoreCase("Q5")) {
				if (QuestionnaireAnswer.equalsIgnoreCase("Y")) {
					clickElement(driver, test, OCR_ExportQuestionnaire_Q5_Y, "Do you plan to demonstrate, disclose or otherwise export a defense article or technical data to foreign persons? : Yes");
				} else if (QuestionnaireAnswer.equalsIgnoreCase("N")) {
					clickElement(driver, test, OCR_ExportQuestionnaire_Q5_N, "Do you plan to demonstrate, disclose or otherwise export a defense article or technical data to foreign persons? : No");
				}
			}
			if (Questionnaire.equalsIgnoreCase("Q6")) {
				if (QuestionnaireAnswer.equalsIgnoreCase("US Person")) {
					clickElement(driver, test, OCR_ExportQuestionnaire_Q6_USPerson, "If you are traveling abroad to perform a defense service (i.e., technical assistance), will this be for : US Person");
				} else if (QuestionnaireAnswer.equalsIgnoreCase("Foreign Person")) {
					clickElement(driver, test, OCR_ExportQuestionnaire_Q6_ForeignPerson, "If you are traveling abroad to perform a defense service (i.e., technical assistance), will this be for : Foreign Person");
				} else if (QuestionnaireAnswer.equalsIgnoreCase("US Citizens")){
					clickElement(driver, test, OCR_ExportQuestionnaire_Q6_USCitizen, "If you are traveling abroad to perform a defense service (i.e., technical assistance), will this be for : US Citizen");
				} else if (QuestionnaireAnswer.equalsIgnoreCase("US Gov_DOD")){
					clickElement(driver, test, OCR_ExportQuestionnaire_Q6_USGov_DOD, "If you are traveling abroad to perform a defense service (i.e., technical assistance), will this be for : US Gov/DOD");
				} else {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Plz Select One Option :");
				}
			}
			if (Questionnaire.equalsIgnoreCase("Q7")) {
				if (QuestionnaireAnswer.equalsIgnoreCase("Y")) {
					clickElement(driver, test, OCR_ExportQuestionnaire_Q7_Y, "Are you taking any personal Protective Equipment/ Body Armour during the visit? : Yes");
				} else if (QuestionnaireAnswer.equalsIgnoreCase("N")) {
					clickElement(driver, test, OCR_ExportQuestionnaire_Q7_N, "Are you taking any personal Protective Equipment/ Body Armour during the visit? : No");
				}
			}
			if (Questionnaire.equalsIgnoreCase("Q8")) {
				if (QuestionnaireAnswer.equalsIgnoreCase("Y")) {
					clickElement(driver, test, OCR_ExportQuestionnaire_Q8_Y, "Are you carrying any Personal Firearms/ Assault Weapons? : Yes");
				} else if (QuestionnaireAnswer.equalsIgnoreCase("N")) {
					clickElement(driver, test, OCR_ExportQuestionnaire_Q8_N, "Are you carrying any Personal Firearms/ Assault Weapons? : No");
				}
			}
			if (Questionnaire.equalsIgnoreCase("Q9")) {
				if (QuestionnaireAnswer.equalsIgnoreCase("Y")) {
					clickElement(driver, test, OCR_ExportQuestionnaire_Q9_Y, "Will you be carrying any technical data (including on your hard drive, removable memory storage device, hard copy, etc.) for delivery to or discussion with any other person (U.S. or foreign) while abroad? : Yes");
				} else if (QuestionnaireAnswer.equalsIgnoreCase("N")) {
					clickElement(driver, test, OCR_ExportQuestionnaire_Q9_N, "Will you be carrying any technical data (including on your hard drive, removable memory storage device, hard copy, etc.) for delivery to or discussion with any other person (U.S. or foreign) while abroad? : No");
				}
			}
		}
	
	// Click on all not applicable checkbox
		public void notapplicable1() {
			scrollToElement(driver, OCR_NotApplicable1);
			List<WebElement> notapplicable = driver.findElements(By.xpath(OCR_NotApplicable1));
			for (int i = 1; i <= notapplicable.size(); i++) {
				Wait.waitfor(3);
				scrollToElement(driver, "(//input[@name='notApplicable'])" + "[" + i + "]");
				Wait.waitfor(3);
				clickElement(driver, test, "(//input[@name='notApplicable'])" + "[" + i + "]", "Click on Not Applicable :");
			}
			scrollToTop(driver);
		}

	//Click on Save Button
	public void save() {
		scrollToElement(driver, OCR_Button_Save);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_Save,"Clicking on Save Button :");		
	}
	//Click on Forward Button
	public void moveForward() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath(OCR_Button_ForwardNavigation)));
	} 
	
	//Move to Additional Info Page
	public void movetoadditionalinfo() {
		clickElement(driver, test, "//a[contains(text(),'Additional Info')]", "Clicking on Additional info Tab :");
	} 

	//Move to Additional Questionnaire Page
	public void movetoadditionalquestn() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath("//span[contains(text(),'Additional Questions')]")));
	} 

	
	public void movetoSubmittab() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath("//a[contains(text(),'Submit Request')]")));
		
	}
	//Move to Document Page
	public void movetodocument() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath("//span[contains(text(),'Documents')]")));
	} 
	
	//Click on Label
	public void clicklable() {
		clickElement(driver, test, OCR_ExportQuestionnaire_Q1_N, "");
	}
}
