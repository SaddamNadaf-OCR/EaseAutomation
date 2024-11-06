package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class HomePage_AMPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//...................................Locators.......................................//
	public static final String AM_DemoSBU="(//a[@class='nav-link dropdown-item'])[1]";
	public static final String AM_ModuleSelection="(//a[@class='nav-link dropdown-item'])[2]";
	public static final String AM_AuthorizationMana="(//a[contains(text(),'Authorization Management')])[1]";
	public static final String AM_AuthorizationMana2="(//a[contains(text(),'Authorization Management')])[2]";
	
	public static final String AM_Features = "(//a[@class='nav-link dropdown-item'])[3]";
	public static final String AM_Authorizations= "(//a[contains(text(),'Authorizations')])[1]";
	public static final String AM_Add_View_Edit= "//a[contains(text(),'Add/View/Edit Authorizations')]";
	public static final String AM_AuthorizationActivity="(//a[contains(text(),'Authorization Activity')])[1]";
	public static final String AM_AuthorizationCloseOut="//a[contains(text(),'Authorization Close-Out')]";
	public static final String AM_AuthorizationReview="(//a[contains(text(),'Authorization Review')])[1]";
	public static final String AM_AuthorizationStore="//a[contains(text(),'Authorization Store')]";
	public static final String AM_Carnet="//a[contains(text(),'Carnet')]";
	public static final String AM_TIB="//a[contains(text(),'TIB')]";
	public static final String AM_TempAuthoCloseOut="//a[contains(text(),'Temp Authorization Close-out')]";
	
	public static final String AM_USGReports="//a[contains(text(),'USG Reports')]";
	public static final String AM_AgrimentReport="(//a[contains(text(),'Agreement Reports')])[1]";
	public static final String AM_AnnualSalesReport="(//a[contains(text(),'Annual Sales Report')])[1]";
	public static final String AM_ClassifiedReports="//a[contains(text(),'Classified Reports')]";
	public static final String AM_DS4071Reports="//a[contains(text(),'DS 4071 Report')]";
	public static final String AM_DSP5Reports="//a[contains(text(),'DSP-5 Offshore Procurements Report')]";
	public static final String AM_Part130Reports="(//a[contains(text(),'Part 130 Report')])[1]";
	
	public static final String AM_Compliance="(//a[contains(text(),'Compliance')])[2]";
	public static final String AM_ComplianceNotes="(//a[contains(text(),'Compliance Notes')])[1]";
	public static final String AM_CongNotification="//a[contains(text(),'Cong. Notification')]";
	
	//.................................Reports TAB........................................//
	public static final String AM_Reports="(//a[@class='nav-link dropdown-item'])[4]";
	public static final String AM_AgreementReports="(//a[contains(text(),'Agreement Reports')])[2]";
	public static final String AM_3rdCountryDualNationalNDAReports="//a[contains(text(),'3rd Country Dual National NDA Delinquency Report')]";
	public static final String AM_3rdCountryDualNationalSummaryReports="//a[contains(text(),'3rd Country Dual National Summary Report')]";
	public static final String AM_AgreementValuationSummaryReports="//a[contains(text(),'Agreement Valuation Summary Report')]";
	public static final String AM_AnnualStatusDelinquencyReports="//a[contains(text(),'Annual Status Delinquency Report')]";
	public static final String AM_AnnualStatusSummaryReport="//a[contains(text(),'Annual Status Summary Report')]";
	public static final String AM_ConcludedAgreementSummaryReports="//a[contains(text(),'Concluded Agreement Summary')]";
	public static final String AM_HardwareInFurtheranceOfAgreementReports="//a[contains(text(),'Hardware In Furtherance Of Agreement Report')]";
	public static final String AM_AuthorizationAgainstAgreementReports="//a[contains(text(),'Authorization against Agreement Report')]";
	public static final String AM_NonConcludedAgreementsReports="//a[contains(text(),'Non-Concluded Agreements')]";
	public static final String AM_SublicenceeNDADelinquencyReports="//a[contains(text(),'Sublicensee NDA Delinquency Report')]";
	public static final String AM_SublicenceeSummaryReports="//a[contains(text(),'Sublicensee Summary Report')]";
	
	public static final String AM_AnnualSalesReports="//a[contains(text(),'Annual Sales Reports')]";
	public static final String AM_SalesReportDelinquencyReports="//a[contains(text(),'Sales Report Delinquency Report')]";
	public static final String AM_SalesReportDetailReports="//a[contains(text(),'Sales Report Detail Report')]";
	public static final String AM_SalesReportSummaryReports="//a[contains(text(),'Sales Report Summary Report')]";
	
	public static final String AM_AuthorizationReports="//a[contains(text(),'Authorization Reports')]";
	public static final String AM_AUTHBalance_PendingTransactionReports="//a[contains(text(),'AUTH. Balance & Pending Transaction Summary')]";
	public static final String AM_AuthorizationActivityReports="(//a[contains(text(),'Authorization Activity')])[2]";
	public static final String AM_AuthorizationBalanceSummaryReports="//a[contains(text(),'Authorization Balance Summary')]";
	public static final String AM_AuthorizationExpiryReports="//a[contains(text(),'Authorization Expiry')]";
	public static final String AM_AuthorizationInformationReports="//a[contains(text(),'Authorization Information')]";
	public static final String AM_AuthorizationOwnerDiscrepancyReports="//a[contains(text(),'Authorization Owner Discrepancy')]";
	public static final String AM_AuthorizationOwnerSummaryReports="//a[contains(text(),'Authorization Owner Summary')]";
	public static final String AM_AuthorizationsReports="(//a[contains(text(),'Authorizations')])[3]";
	
	public static final String AM_AuthorizationReviewReports="//a[contains(text(),'Authorization Review Reports')]";
	public static final String AM_DelinquencyReports="(//a[contains(text(),'Delinquency Report')])[5]";
	public static final String AM_PendingActionReports="//a[contains(text(),'Pending Action Report')]";
	public static final String AM_ProvisoActionRequiredReports="//a[contains(text(),'Proviso Action Required Report')]";
	public static final String AM_ControlPlanReports="//a[contains(text(),'Control Plan Report')]";
	
	public static final String AM_CountryReports="//a[contains(text(),'Country Reports')]";
	public static final String AM_CountriesReports="(//a[contains(text(),'Countries')])[1]";
	public static final String AM_ExportConsigneebyCountryReports="//a[contains(text(),'Export Consignee by Country')]";
	
	public static final String AM_DOCReports="//a[contains(text(),'DOC Reports')]";
	public static final String AM_DOCProvisoAcknowledgmentReports="//a[contains(text(),'DOC Proviso Acknowledgment Report')]";
	public static final String AM_LOADiscrepancyReports="//a[contains(text(),'LOA Discrepancy Report')]";
	public static final String AM_SemiAnnualDelinquencyReports="//a[contains(text(),'Semi-Annual Delinquency Report')]";
	public static final String AM_SemiAnnualSummaryReports="//a[contains(text(),'Semi-Annual Summary Report')]";
	
	public static final String AM_DSSReports="//a[contains(text(),'DSS Reports')]";
	public static final String AM_DSSClassifiedLicenceSummaryReports="//a[contains(text(),'DSS Classified Licence Summary Report')]";
	public static final String AM_DSSReportDelinquencyReports="//a[contains(text(),'DSS Report Delinquency Report')]";
	
	public static final String AM_Exemption_ExceptionReports="//a[contains(text(),'Exemption/Exception Reports')]";
	public static final String AM_DOCExceptionReports="//a[contains(text(),'DOC Exception Report')]";
	public static final String AM_DOSExemptionReports="//a[contains(text(),'DOS Exemption Report')]";
	public static final String AM_FR_ModeledeReporting="//a[contains(text(),'FR - Modele de Reporting')]";
	
	public static final String AM_ITARExemptionReports="//a[contains(text(),'ITAR Exemption Reports')]";
	public static final String AM_CanadianExemptionSummaryReports="//a[contains(text(),'Canadian Exemption Summary Report')]";
	public static final String AM_DetailsReports="//a[contains(text(),'Details')]";
	public static final String AM_ExportsnotReexportedReports="//a[contains(text(),'Exports not Reexported')]";
	public static final String AM_SummaryReports="(//a[contains(text(),'Summary')])[13]";
	
	public static final String AM_AuthorizationExceptionReports="//a[contains(text(),'Authorization Exception Reports')]";
	public static final String AM_ENCExceptionReports="//a[contains(text(),'ENC Exception')]";
	public static final String AM_LVSExceptionReports="//a[contains(text(),'LVS Exception Report')]";
	public static final String AM_AESummaryReports="(//a[contains(text(),'Summary Report')])[9]";
	public static final String AM_WassenaarReports="//a[contains(text(),'Wassenaar')]";
	
	public static final String AM_OffshoreProcurementReports="(//a[contains(text(),'Offshore Procurement')])[2]";
	public static final String AM_OffshoreProcurementDelinquencyReports="//a[contains(text(),'Offshore Procurement Delinquency Report')]";
	public static final String AM_OffshoreProcurementSummaryReports="//a[contains(text(),'Offshore Procurement Summary Report')]";
	public static final String AM_OpenlicenceReturnReports="//a[contains(text(),'Open licence Return Report')]";
	public static final String AM_Part126_13Reports="//a[contains(text(),'Part 126.13 Report')]";
	
	public static final String AM_Part_130Reports="//a[contains(text(),'Part 130 Reports')]";
	public static final String AM_Part130AuditReports="//a[contains(text(),'Part 130 Audit Report')]";
	public static final String AM_Part130DetailedReports="//a[contains(text(),'Part 130 Detailed Report')]";
	public static final String AM_Part130PaymentDetailsReports="//a[contains(text(),'Part 130 Payment Details')]";
	public static final String AM_Part130SummaryReports="//a[contains(text(),'Part 130 Summary Report')]";
	public static final String AM_Part130SupplementalReports="//a[contains(text(),'Part 130 Supplemental Report')]";
	public static final String AM_TransactionsMeetingPart130Reports="//a[contains(text(),'Transactions Meeting Part 130')]";
	public static final String AM_ProductReports="//a[contains(text(),'Product Report')]";
	public static final String AM_ShipmentActivityReports="//a[contains(text(),'Shipment Activity')]";
	
	public static final String AM_Temp_AuthorizationTrackingReports="//a[contains(text(),'Temp. Authorization Tracking')]";
	public static final String AM_Authorization_Activity="//a[contains(text(),'Authorization Activity Report')]";
	public static final String AM_AuthorizationOutstanding="//a[contains(text(),'Authorization Outstanding Report')]";
	public static final String AM_WebServiceAudit="//a[contains(text(),'Web Service Audit Report')]";

	public static final String AM_LogOut="//i[@class='fa fa-sign-out']";
	
	//.................................Constructor.....................................//
	public HomePage_AMPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;		
	}
	//................................SBU Selection...................................//
	public void move_to_moduleSelection(String SBU) {
		mouseOver(driver, test, AM_DemoSBU, "Mouse Over On SBU Selection :");
		//System.out.println("//label[contains(text(),'" + SBU + "')]");
		Wait.waitfor(3);
		clickElement(driver, test, "//label[contains(text(),'" + SBU + "')]", "Click on SBU : " + SBU);
		Wait.waitfor(3);
	}
	//.................................Module Selection................................//
	public void moduleSelection() {
		mouseOverAndClick(driver, test, AM_ModuleSelection, "Mouse over on Authorization Management :");
		Wait.waitfor(6);
		mouseOverAndClick(driver, test, AM_AuthorizationMana, "Clicking on Authorization Management :");
	}
	public void returnTomoduleSelection() {
		mouseOver(driver, test, AM_ModuleSelection, "Mouse over on Authorization Management :");
		Wait.waitfor(3);
		clickElement(driver, test, AM_AuthorizationMana2, "Clicking on Authorization Management :");
		Wait.waitfor(3);
	}
	//..............................For Add/View/Edit Page..............................//
	public void clickonAddViewEdit() {
		clickElement(driver, test, AM_Features, "Mouse over on Features :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_Authorizations, "Clicking on Authorization :");
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, AM_Add_View_Edit, "Clicking on Add/View/Edit :");
	}
	//.........................For Authorization Activity Page............................//
	public void AuthorizationActivity() {
		clickElement(driver, test, AM_Features, "Mouse over on Features :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_Authorizations, "Clicking on Authorization :");
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, AM_AuthorizationActivity, "Clicking on Authorization Activity :");
	}
	//.........................For Authorization CloseOut Page........................//
	public void click_on_AutorizationCloseOut() {
		clickElement(driver, test, AM_Features, "Mouse over on Features :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_Authorizations, "Clicking on Authorization :");
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, AM_AuthorizationCloseOut, "Clicking on Authorization CloseOut :");
	}
	//..............................For Authorization Review Page..............................//
	public void click_on_AutorizationReview() {
		clickElement(driver, test, AM_Features, "Mouse over on Features");
		Wait.waitfor(2);
		clickElement(driver, test, AM_Authorizations, "Clicking on Authorization :");
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, AM_AuthorizationReview, "Clicking on Authorization Review :");
	}
	//..............................For AM_Authorization Store Page..............................//
	public void click_on_AuthorizationStore() {
		clickElement(driver, test, AM_Features, "Mouse over on Features :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_Authorizations, "Clicking on Authorization :");
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, AM_AuthorizationStore, "Clicking on Authorization Store :");
	}
	//................................For Carnet Page................................//
	public void click_on_Carnet() {
		clickElement(driver, test, AM_Features, "Mouse over on Features :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_Authorizations, "Clicking on Authorization :");
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, AM_Carnet, "Clicking on Carnet :");
	}
	//.................................For TIB Page.................................//
	public void click_on_TIB() {
		clickElement(driver, test, AM_Features, "Mouse over on Features :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_Authorizations, "Clicking on Authorization :");
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, AM_TIB, "Clicking on TIB :");
	}
	//.......................For Temp Authorization CloseOut Page..............................//
	public void click_on_TempAuthoCloseOut() {
		clickElement(driver, test, AM_Features, "Mouse over on Features :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_Authorizations, "Clicking on Authorization :");
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, AM_TempAuthoCloseOut, "Clicking on Temp Authorization CloseOut :");
	}
	//..............................For AgreementReport Page..............................//
	public void clickOnAgreementReport() {
		clickElement(driver, test, AM_Features, "Mouse over on Features :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_USGReports, "Clicking on USGReports :");
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, AM_AgrimentReport, "Clicking on Agreement Report :");
	}
	//..............................For Annual Sales Report Page..............................//
	public void clickOnAnnualSalesReport() {
		clickElement(driver, test, AM_Features, "Mouse over on Features :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_USGReports, "Clicking on USGReports :");
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, AM_AnnualSalesReport, "Clicking on Annual Sales Report :");
	}
	//..............................For Classified Reports Page..............................//
	public void clickOnClassifiedReports() {
		clickElement(driver, test, AM_Features, "Mouse over on Features :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_USGReports, "Clicking on USGReports :");
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, AM_ClassifiedReports, "Clicking on Classified Reports :");
	}
	//..............................For DS 4071 Reports Page..............................//
	public void clickonDS4071Reports() {
		clickElement(driver, test, AM_Features, "Mouse over on Features :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_USGReports, "Clicking on USGReports :");
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, AM_DS4071Reports, "Clicking on DS 4071 Reports :");
	}
	//....................For DSP-5 Offshore Procurement Reports Page.........................//
	public void clickonDSP5Reports() {
		clickElement(driver, test, AM_Features, "Mouse over on Features :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_USGReports, "Clicking on USGReports :");
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, AM_DSP5Reports, "Clicking on DSP-5 Reports :");
	}
	//.............................For Part 130 Reports Page..............................//
	public void clickonPart130Reports() {
		clickElement(driver, test, AM_Features, "Mouse over on Features :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_USGReports, "Clicking on USGReports :");
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, AM_Part130Reports, "Clicking on Part 130 Reports :");
	}
	//..............................For Compliance Notes Page..............................//
	public void clickonComplianceNotes() {
		clickElement(driver, test, AM_Features, "Mouse over on Features :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_Compliance, "Clicking on Compliance :");
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, AM_ComplianceNotes, "Clicking on Compliance Notes :");
	}
	//..............................For Cong. Notification Page..............................//
	public void clickonCongNotification() {
		clickElement(driver, test, AM_Features, "Mouse over on Features :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_Compliance, "Clicking on Compliance :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_CongNotification, "Clicking on Cong. Notification :");
	}
	//..............................For Agreement Report Page..............................//
	
	//.......................Clicking on 3rd Country Dual National NDA Report..................//
	public void click_3rdCountryDualNationalNDA() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_AgreementReports, "Clicking on Agreement Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_3rdCountryDualNationalNDAReports, "Clicking on 3rd Country Dual National NDA Report :");
	}
	
	//.......................Clicking on 3rd Country Dual National Summary Report..................//
	public void click_3rdCountryDualNationalSummary() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_AgreementReports, "Clicking on Agreement Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_3rdCountryDualNationalSummaryReports, "Clicking on 3rd Country Dual National Summary Report :");
	}
	
	//.......................Clicking on Agreement Valuation Summary Reports ........................//
	public void click_AgreementValuationSummaryReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_AgreementReports, "Clicking on Agreement Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_AgreementValuationSummaryReports, "Clicking on Agreement Valuation Summary Report :");
	}
	
	//.......................Clicking on Annual Status Delinquency Reports ........................//
	public void click_AnnualStatusDelinquencyReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_AgreementReports, "Clicking on Agreement Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_AnnualStatusDelinquencyReports, "Clicking on Annual Status Delinquency Reports :");
	}
	
	//.......................Clicking on Annual Status Summary Report ........................//
	public void click_AnnualStatusSummaryReport() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_AgreementReports, "Clicking on Agreement Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_AnnualStatusSummaryReport, "Clicking on Annual Status Summary Report :");
	}
	
	//.......................Clicking on Concluded Agreement Summary Reports ........................//
	public void click_ConcludedAgreementSummaryReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_AgreementReports, "Clicking on Agreement Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_ConcludedAgreementSummaryReports, "Clicking on Concluded Agreement Summary Reports :");
	}
	
	//.......................Clicking on Hardware In Furtherance Of Agreement Reports ........................//
	public void click_HardwareInFurtheranceOfAgreementReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_AgreementReports, "Clicking on Agreement Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_HardwareInFurtheranceOfAgreementReports, "Clicking on Hardware In Furtherance Of Agreement Reports :");
	}
	
	//.......................Clicking on Authorization Against Agreement Reports ........................//
	public void click_AuthorizationAgainstAgreementReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_AgreementReports, "Clicking on Agreement Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_AuthorizationAgainstAgreementReports, "Clicking on Authorization Against Agreement Reports :");
	}
	
	//.......................Clicking on Non Concluded Agreements Reports ........................//
	public void click_NonConcludedAgreementsReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_AgreementReports, "Clicking on Agreement Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_NonConcludedAgreementsReports, "Clicking on Non Concluded Agreements Reports :");
	}
	
	//.......................Clicking on Sub licencee NDA Delinquency Reports ........................//
	public void click_SublicenceeNDADelinquencyReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_AgreementReports, "Clicking on Agreement Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_SublicenceeNDADelinquencyReports, "Clicking on Sub licencee NDA Delinquency Reports :");
	}
	
	//.......................Clicking on Sub licencee Summary Reports ........................//
	public void click_SublicenceeSummaryReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_AgreementReports, "Clicking on Agreement Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_SublicenceeSummaryReports, "Clicking on Sub licencee Summary Reports :");
	}
	
	//.......................Clicking on Annual Sales Report...................................//
	//.......................Clicking on Sales Report Delinquency Reports ........................//
	public void click_SalesReportDelinquencyReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_AnnualSalesReports, "Clicking on Annual Sales Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_SalesReportDelinquencyReports, "Clicking on Sales Report Delinquency Reports :");
	}
	
	//.......................Clicking on Sales Report Detail Reports ........................//
	public void click_SalesReportDetailReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_AnnualSalesReports, "Clicking on Annual Sales Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_SalesReportDetailReports, "Clicking on Sales Report Detail Reports :");
	}
	
	//.......................Clicking on Sales Report Summary Reports ........................//
	public void click_SalesReportSummaryReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_AnnualSalesReports, "Clicking on Annual Sales Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_SalesReportSummaryReports, "Clicking on Sales Report Summary Reports :");
	}
	
	//.......................Clicking on Authorization Reports................................//
	//.......................Clicking on AUTH Balance_Pending Transaction Reports........................//
	public void click_AUTHBalance_PendingTransactionReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_AuthorizationReports, "Clicking on Authorization Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_AUTHBalance_PendingTransactionReports, "Clicking on AUTH Balance_Pending Transaction Reports :");
	}
	
	//.......................Clicking on Authorization Activity Reports........................//
	public void click_AuthorizationActivityReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_AuthorizationReports, "Clicking on Authorization Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_AuthorizationActivityReports, "Clicking on Authorization Activity Reports :");
	}
	
	//.......................Clicking on Authorization Balance Summary Reports........................//
	public void click_AuthorizationBalanceSummaryReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_AuthorizationReports, "Clicking on Authorization Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_AuthorizationBalanceSummaryReports, "Clicking on Authorization Balance Summary Reports :");
	}
	
	//.......................Clicking on Authorization Expiry Reports........................//
	public void click_AuthorizationExpiryReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_AuthorizationReports, "Clicking on Authorization Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_AuthorizationExpiryReports, "Clicking on Authorization Expiry Reports :");
	}
	
	//.......................Clicking on Authorization Information Reports........................//
	public void click_AuthorizationInformationReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_AuthorizationReports, "Clicking on Authorization Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_AuthorizationInformationReports, "Clicking on Authorization Information Reports :");
	}
	
	//.......................Clicking on Authorization Owner Discrepancy Reports........................//
	public void click_AuthorizationOwnerDiscrepancyReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_AuthorizationReports, "Clicking on Authorization Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_AuthorizationOwnerDiscrepancyReports, "Clicking on Authorization Owner Discrepancy Reports :");
	}
	
	//.......................Clicking on Authorization Owner Summary Reports........................//
	public void click_AuthorizationOwnerSummaryReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_AuthorizationReports, "Clicking on Authorization Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_AuthorizationOwnerSummaryReports, "Clicking on Authorization Owner Summary Reports :");
	}
	
	//.......................Clicking on Authorizations Reports........................//
	public void click_AuthorizationsReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_AuthorizationReports, "Clicking on Authorization Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_AuthorizationsReports, "Clicking on Authorizations Reports :");
	}
	
	//.......................Authorization Review Reports..............................//
	//.......................Clicking on Delinquency Reports........................//
	public void click_DelinquencyReports() {
		mouseOverAndClick(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(3);
		clickElement(driver, test, AM_AuthorizationReviewReports, "Clicking on Authorization Review Reports :");
		Wait.waitfor(4);
		clickElement(driver, test, AM_DelinquencyReports, "Clicking on Delinquency Reports :");
	}
	
	//.......................Clicking on Pending Action Reports........................//
	public void click_PendingActionReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_AuthorizationReviewReports, "Clicking on Authorization Review Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_PendingActionReports, "Clicking on Pending Action Reports :");
	}
	
	//.......................Clicking on Proviso Action Required Reports........................//
	public void click_ProvisoActionRequiredReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_AuthorizationReviewReports, "Clicking on Authorization Review Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_ProvisoActionRequiredReports, "Clicking on Proviso Action Required Reports :");
	}
	
	//.......................Clicking on Control Plan Reports........................//
	public void click_ControlPlanReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		//clickElement(driver, test, AM_AuthorizationReviewReports, "Clicking on Authorization Review Reports");
		//Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_ControlPlanReports, "Clicking on Control Plan Reports :");
	}
	
	//.......................Clicking Country Reports................................//
	//.......................Clicking on Control Plan Reports........................//
	public void click_CountriesReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_CountryReports, "Clicking on Country Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_CountriesReports, "Clicking on Countries Reports :");
	}
	
	//.......................Clicking on Export Consignee by Country Reports........................//
	public void click_ExportConsigneebyCountryReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_CountryReports, "Clicking on Country Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_ExportConsigneebyCountryReports, "Clicking on Export Consignee by Country Reports :");
	}
	
	//.......................Clicking on DOC Reports......................................//
	//.......................Clicking on DOC Proviso Acknowledgment Reports........................//
	public void click_DOCProvisoAcknowledgmentReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_DOCReports, "Clicking on DOC Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_DOCProvisoAcknowledgmentReports, "Clicking on DOC Proviso Acknowledgment Reports :");
	}
	
	//.......................Clicking on LOA Discrepancy Reports........................//
	public void click_LOADiscrepancyReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_DOCReports, "Clicking on DOC Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_LOADiscrepancyReports, "Clicking on LOA Discrepancy Reports :");
	}
	
	//.......................Clicking on Semi-Annual Delinquency Reports........................//
	public void click_SemiAnnualDelinquencyReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_DOCReports, "Clicking on DOC Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_SemiAnnualDelinquencyReports, "Clicking on Semi Annual Delinquency Reports :");
	}
	
	//.......................Clicking on Semi-Annual Summary Reports........................//
	public void click_SemiAnnualSummaryReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_DOCReports, "Clicking on DOC Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_SemiAnnualSummaryReports, "Clicking on Semi Annual Summary Reports :");
	}
	
	//.......................Clicking on DSS Reports..................................//
	//.......................Clicking on DSS Classified Licence Summary Reports........................//
	public void click_DSSClassifiedLicenceSummaryReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_DSSReports, "Clicking on DSS Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_DSSClassifiedLicenceSummaryReports, "Clicking on DSS Classified Licence Summary Reports :");
	}
	
	//.......................Clicking on DSS Report Delinquency Reports........................//
	public void click_DSSReportDelinquencyReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_DSSReports, "Clicking on DSS Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_DSSReportDelinquencyReports, "Clicking on DSS Report Delinquency Reports :");
	}
	
	//.......................Clicking on Exemption_Exception Reports...........................//
	//.......................Clicking on DOC Exception Reports........................//
	public void click_DOCExceptionReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_Exemption_ExceptionReports, "Clicking on Exemption_Exception Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_DOCExceptionReports, "Clicking on DOC Exception Reports :");
	}
	
	//.......................Clicking on DOS Exemption Reports........................//
	public void click_DOSExemptionReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_Exemption_ExceptionReports, "Clicking on Exemption_Exception Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_DOSExemptionReports, "Clicking on DOS Exemption Reports :");
	}
	
	//.......................Clicking on FR_ModeledeReporting........................//
	public void click_FR_ModeledeReporting() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		//clickElement(driver, test, AM_Exemption_ExceptionReports, "Clicking on Exemption_Exception Reports :");
		//Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_FR_ModeledeReporting, "Clicking on FR_ModeledeReporting :");
	}
	
	//.......................Clicking on ITAR Exemption Reports.......................//
	//.......................Clicking on Canadian Exemption Summary Reports........................//
	public void click_CanadianExemptionSummaryReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_ITARExemptionReports, "Clicking on ITAR Exemption Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_CanadianExemptionSummaryReports, "Clicking on Canadian Exemption Summary Reports :");
	}
	
	//.......................Clicking on Details Reports........................//
	public void click_DetailsReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_ITARExemptionReports, "Clicking on ITAR Exemption Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_DetailsReports, "Clicking on Details Reports :");
	}
	
	//.......................Clicking on Exports not Reexported Reports........................//
	public void click_ExportsnotReexportedReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_ITARExemptionReports, "Clicking on ITAR Exemption Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_ExportsnotReexportedReports, "Clicking on Exports not Reexported Reports :");
	}
	
	//.......................Clicking on Summary Reports........................//
	public void click_SummaryReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_ITARExemptionReports, "Clicking on ITAR Exemption Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_SummaryReports, "Clicking on Summary Reports :");
	}
	
	//.......................Clicking on Authorization Exception Reports.....................//
	//.......................Clicking on ENC Exception Reports........................//
	public void click_ENCExceptionReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_AuthorizationExceptionReports, "Clicking on Authorization Exception Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_ENCExceptionReports, "Clicking on ENC Exception Reports :");
	}
	
	//.......................Clicking on LVS Exception Reports........................//
	public void click_LVSExceptionReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_AuthorizationExceptionReports, "Clicking on Authorization Exception Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_LVSExceptionReports, "Clicking on LVS Exception Reports :");
	}
	
	//.......................Clicking on AE Summary Reports........................//
	public void click_AESummaryReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_AuthorizationExceptionReports, "Clicking on Authorization Exception Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_AESummaryReports, "Clicking on AE Summary Reports :");
	}
	
	//.......................Clicking on Wassenaar Reports........................//
	public void click_WassenaarReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_AuthorizationExceptionReports, "Clicking on Authorization Exception Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_WassenaarReports, "Clicking on Wassenaar Reports :");
	}
	
	//.......................Clicking on Off shore Procurement Reports.........................//
	//.......................Clicking on Off shore Procurement Delinquency Reports........................//
	public void click_OffshoreProcurementDelinquencyReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_OffshoreProcurementReports, "Clicking on Off shore Procurement Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_OffshoreProcurementDelinquencyReports, "Clicking on Off shore Procurement Delinquency Reports :");
	}
	
	//.......................Clicking on Off shore Procurement Summary Reports........................//
	public void click_OffshoreProcurementSummaryReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_OffshoreProcurementReports, "Clicking on Off shore Procurement Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_OffshoreProcurementSummaryReports, "Clicking on Off shore Procurement Summary Reports :");
	}
	
	//.......................Clicking on Open licence Return Reports........................//
	public void click_OpenlicenceReturnReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, AM_OpenlicenceReturnReports, "Clicking on Open licence Return Reports :");
	}
	
	//.......................Clicking on Part 126_13 Reports........................//
	public void click_Part126_13Reports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, AM_Part126_13Reports, "Clicking on Part 126_13 Reports :");
	}
	
	//.......................Clicking on Part_130 Reports............................//
	//.......................Clicking on Part 130 Audit Reports........................//
	public void click_Part_130Reports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_Part_130Reports, "Clicking on Part_130 Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_Part130AuditReports, "Clicking on Part 130 Audit Reports :");
	}
	
	//.......................Clicking on Part 130 Detailed Reports........................//
	public void click_Part130DetailedReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_Part_130Reports, "Clicking on Part_130 Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_Part130DetailedReports, "Clicking on Part 130 Detailed Reports :");
	}
	
	//.......................Clicking on Part 130 Payment Details Reports........................//
	public void click_Part130PaymentDetailsReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_Part_130Reports, "Clicking on Part_130 Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_Part130PaymentDetailsReports, "Clicking on Part 130 Payment Details Reports :");
	}
	
	//.......................Clicking on Part 130 Summary Reports........................//
	public void click_Part130SummaryReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_Part_130Reports, "Clicking on Part_130 Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_Part130SummaryReports, "Clicking on Part 130 Summary Reports :");
	}
	
	//.......................Clicking on Part 130 Supplemental Reports........................//
	public void click_Part130SupplementalReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_Part_130Reports, "Clicking on Part_130 Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_Part130SupplementalReports, "Clicking on Part 130 Supplemental Reports :");
	}
	
	//.......................Clicking on Transactions Meeting Part 130 Reports........................//
	public void click_TransactionsMeetingPart130Reports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_Part_130Reports, "Clicking on Part_130 Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_TransactionsMeetingPart130Reports, "Clicking on Transactions Meeting Part 130 Reports :");
	}
	
	//.......................Clicking on Product Reports........................//
	public void click_ProductReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, AM_ProductReports, "Clicking on Product Reports :");
	}
	
	//.......................Clicking on Shipment Activity Reports........................//
	public void click_ShipmentActivityReports() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, AM_ShipmentActivityReports, "Clicking on Shipment Activity Reports :");
	}
	
	//.......................Clicking on Temp_Authorization Tracking Reports...............................//
	//.......................Clicking on Authorization Activity........................//
	public void click_Authorization_Activity() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_Temp_AuthorizationTrackingReports, "Clicking on Temp_Authorization Tracking Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_Authorization_Activity, "Clicking on Authorization_Activity :");
	}
	
	//.......................Clicking on Authorization Outstanding........................//
	public void click_AuthorizationOutstanding() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		clickElement(driver, test, AM_Temp_AuthorizationTrackingReports, "Clicking on Temp_Authorization Tracking Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, AM_AuthorizationOutstanding, "Clicking on Authorization Outstanding :");
	}
	
	//.......................Clicking on Web Service Audit Report........................//
	public void click_WebServiceAudit() {
		clickElement(driver, test, AM_Reports, "Mouse over on Reports :");
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, AM_WebServiceAudit, "Clicking on Web Service Audit Report :");
	}

	//...................................LogOut......................................//
	public void logOut() {
		clickElement(driver, test, AM_LogOut, "Clicking on LogOut Button :");
	}
}
