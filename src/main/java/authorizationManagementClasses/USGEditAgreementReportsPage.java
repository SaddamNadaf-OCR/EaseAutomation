package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class USGEditAgreementReportsPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//...................................Locators.......................................//
	public static final String USGAR_Save="(//button[contains(text(),'Save')])[1]";
	public static final String USGAR_SaveAndReturn="(//button[contains(text(),'Save')])[2]";
	public static final String USGAR_Cancel="(//button[@name='Cancel'])[1]";
	public static final String USGAR_GenerateReport="(//button[contains(text(),'Generate Report')])[1]";
	public static final String USGAR_ViewAddDocuments="(//button[contains(text(),'View/Add Documents')])[1]";
	public static final String USGAR_AddNotes="(//button[contains(text(),'Add Notes')])[1]";
	public static final String USGAR_USGOfficer="//input[@name='agreementReports.usgOfficer']";
	public static final String USGAR_USGTitle="//input[@name='agreementReports.usgTitle']";
	public static final String USGAR_EmpoweredOfficial="//input[@name='agreementReports.empoweredOfficial']";
	public static final String USGAR_Title="//input[@name='agreementReports.title']";
	public static final String USGAR_Phone="//input[@name='agreementReports.phone']";
	public static final String USGAR_Email="//input[@name='agreementReports.email']";
	public static final String USGAR_ExporterCode="//input[@name='agreementReports.exporterCode']";
	public static final String USGAR_Exporter="//input[@name='exporter.expCode']";
	public static final String USGAR_DDTCRegiNo="//input[@name='agreementReports.ddtcNo']";
	public static final String USGAR_Reportyear="//input[@name='agreementReports.reportingYear']";
	public static final String USGAR_USGReportDate="//input[@name='usgReportDate']";
	public static final String USGAR_referenceNo="//input[@name='agreementReports.referenceNo']";
	public static final String USGAR_ExporterCodePopUp="//a[contains(text(),'Exporter Code')]";
	public static final String USGAR_SearchPopUp="(//button[contains(text(),'Search')])[1]";
	public static final String USGAR_SelectPopUp="//button[contains(text(),'Select')]";
	public static final String USGAR_ClosePopUp="//button[@class='btn-close']";
	public static final String USGAR_ExportTextbox="//input[@name='agreementReports.exporterCode']";
	public static final String USGAR_UseAnnualStatusReport="(//input[@name='agreementReports.annualStatusReport'])[1]";
	public static final String USGAR_UseNon_ConcludedText="(//input[@name='agreementReports.annualStatusReport'])[2]";
	public static final String USGAR_UseTAAConformedText="(//input[@name='agreementReports.annualStatusReport'])[3]";
	public static final String USGAR_UseMLAConformedText="(//input[@name='agreementReports.annualStatusReport'])[4]";
	public static final String USGAR_UseAmendmentConformedText="(//input[@name='agreementReports.annualStatusReport'])[5]";
	public static final String USGAR_UseAgreementTerminationText="(//input[@name='agreementReports.annualStatusReport'])[6]";
	public static final String USGAR_MarkStatusReportCompleted="//input[@name='msr']";
	public static final String USGAR_MarkNon_ConcludedReportCompleted="//input[@name='mncr']";
	public static final String USGAR_ConformedReportCompleted="//input[@name='cr']";
	public static final String USGAR_MLAConformedReportCompleted="//input[@name='mcr']";
	public static final String USGAR_UseSignatureImage="//input[@name='si']";
	public static final String USGAR_amendmentNo="//input[@name='agreementReports.amendmentNo']";
	public static final String USGAR_AmendmentReportComplete="//input[@name='ar']";
	public static final String USGAR_terminationDate="//input[@name='terminationDate']";
	public static final String USGAR_AgreementTerminationComplete="//input[@name='atc']";
	public static final String USGAR_AdditionalReportText="//textarea[@name='additionalReportTxt']";
	public static final String USGAR_remarks="//textarea[@name='remarks']";
	
	//.................................Constructor.....................................//
	public USGEditAgreementReportsPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;		
	}
	//............................Adding Data Into Agreement Report.....................//
	public void agreementReport(String usgOfficer,String usgTitle,
			String empoweredOfficial,String title,String phone,String email,String exportor,String ddtcNumber,
			String reportYear,String reportDate,String referenceNo,String amendmentNo,String terminationdate,
			String AdditionalReportText,String remarks) {
		
		clickElement(driver, test, "(//a[@class='btn-close'])[1]", "Closing Alert Msg :");
		typeText(driver, test, USGAR_USGOfficer, "Typing USG Officer :", usgOfficer);
		typeText(driver, test, USGAR_USGTitle, "Typing USG Title :", usgTitle);
		typeText(driver, test, USGAR_Title, "Entering Title Name :", title);
		typeText(driver, test, USGAR_EmpoweredOfficial, "Typing Empowered Officail :", empoweredOfficial);
		typeText(driver, test, USGAR_Phone, "Enter Phone Number :", phone);
		typeText(driver, test, USGAR_Email, "Enter E-mail Address :", email);
		if(exportor.length() > 0) {
			clickElement(driver, test, USGAR_ExporterCodePopUp, "Click on Exportor Link :");
			try {
				typeText(driver, test, USGAR_Exporter, "Entering Exporter Code :", exportor);
				clickElement(driver, test, USGAR_SearchPopUp, "Click on Search Button :");
				Wait.waitfor(2);
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ exportor +"')]", "Select Data From Table : "+exportor);
				Wait.waitfor(2);
				clickElement(driver, test, USGAR_SelectPopUp, "Clicking on Select PopUp :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, USGAR_ClosePopUp, "Click on ClosePopUp :");
			}
		}else {
			typeText(driver, test, USGAR_ExporterCode, "Entering Exportor Code :", exportor);
		}
		typeText(driver, test, USGAR_DDTCRegiNo, "Enter DDTC Register Number :", ddtcNumber);
		typeText(driver, test, USGAR_Reportyear, "Enter Report Year :", reportYear);
		typeText(driver, test, USGAR_USGReportDate, "Enter USG Report Date :", reportDate);
		typeText(driver, test, USGAR_referenceNo, "Entering Referance Number :", referenceNo);
		typeText(driver, test, USGAR_amendmentNo, "Entering Amendment No :", amendmentNo);
		scrollToBottom(driver);
		clickElement(driver, test, USGAR_AmendmentReportComplete, "Clicking on Amendment Report Complete :");
		clickElement(driver, test, USGAR_UseSignatureImage, "Clicking on Use Signature Image :");
		if(terminationdate.length() > 0) {
			clickElement(driver, test, USGAR_terminationDate, "Clicking on Termination Date :");
			dateOfMonthName(driver, test, "Selecting Termination Date :" , terminationdate);
		}
		clickElement(driver, test, USGAR_AgreementTerminationComplete, "Clicking on Agreement Termination Complete :");
		typeText(driver, test, USGAR_AdditionalReportText, "Entering Additional Report Text :", AdditionalReportText);
		typeText(driver, test, USGAR_remarks, "Entering remarks :", remarks);
		scrollToElement(driver, USGAR_Save);
	}
	
	//...........................Click on Save Button.............................//
	public void save() {
		clickElement(driver, test, USGAR_Save, "Click on Save Button :");
	}
	//..........................Click on Save And Return Button...........................//
	public void saveAndreturn() {
		clickElement(driver, test, USGAR_SaveAndReturn, "Click in Save And Return Button :");
	}
	//.........................Click on Cancel Button...............................//
	public void cancel() {
		clickElement(driver, test, USGAR_Cancel, "Click on Cancel Button :");
	}
	//........................Click on Generate Report .............................//
	public void generateReport() {
		clickElement(driver, test, USGAR_GenerateReport, "CLicking on Generate Reports :");
	}
	//........................Click on View Add Documents .........................//
	public void viewAddDocuments() {
		clickElement(driver, test, USGAR_ViewAddDocuments, "Clicking on View Add Documents :");
	}
}
