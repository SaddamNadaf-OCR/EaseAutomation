package regressionTestingComplianceRequestScripts;
/* 
 * Module : CRS
 * Author  : Saddam
 * created date : March 2024
 * Descriptions : Add Agreement Request Template
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import crsClasses.AgreementReqAmendmentMainPage;
import crsClasses.AgreementReqDocumentsOrNotesPage;
import crsClasses.AgreementReqExportsUnderAgreementPage;
import crsClasses.AgreementReqForeignPartiesPage;
import crsClasses.AgreementReqGeneralInfoPage;
import crsClasses.AgreementReqGeneralQuestionsPage;
import crsClasses.AgreementReqMLAPage;
import crsClasses.AgreementReqRebaselineAmendmentPage;
import crsClasses.AgreementReqSubmitPage;
import crsClasses.AgreementReqTypeOfExportPage;
import crsClasses.AgreementReqUSPartiesPage;
import crsClasses.AgreementReqValuationPage;
import crsClasses.HomePageCRs;
import crsClasses.SearchAgreementRequestTemplatePage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AddAgreementRequestTemplate extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddAGRTemplates", excel);
	}
	
	@Test(dataProvider ="getData")
	public void agreementRequestTemplate(String Testcase, String RunMode, String TemplateName, String BuisnessUnit, String RequiredByDate, 
			String RequestorName, 
			String RequestorEmail, String RequestorPhone, String RequestorEMPId, String SameAsRequestor, String AOName, String AOEmail, 
			String AOPhone, String AOEMPId, String AMName, String AMEmail, String AMPhone, String AMEMPId, String TAA, String MLA, 
			String AgreementNo,	String AgreementPurpose, String SummaryandPurposeofAgreement, String SiteId, String Segment,
			String Department, String ProductFamily, String Program, String ProductLine, String ContractNo,	String PurchaseOrderNo, 
			String FMSCaseNo, String AmendmentNo, String ScopeChange, String AdditionChangeInHardwareTechData, 
			String PartiesInvolvedAddDeletionofParties,	String EndUserEndUseChange, String ExtendTerm, String ComplianceIssuesDiscovered, 
			String Other, String USMLCategories, String Country, String ConsigneeId, String FPartyType, String ThirdCountry,
			String Code, String DocumentType, String DocumentDescription, String uploadfileName, String Note,
			String ReviewerName, String Status, String Determination, String Phone, String LicenseType, String SbuID) {
		
		HomePageCRs homepage = new HomePageCRs(driver, test);
		SearchAgreementRequestTemplatePage searchPage = new SearchAgreementRequestTemplatePage(driver, test);
		AgreementReqGeneralInfoPage generalinfo = new AgreementReqGeneralInfoPage(driver, test);
		AgreementReqTypeOfExportPage typeofexport = new AgreementReqTypeOfExportPage(driver, test);
		AgreementReqAmendmentMainPage amendmentmain = new AgreementReqAmendmentMainPage(driver, test);
		AgreementReqValuationPage value = new AgreementReqValuationPage(driver, test);
		AgreementReqForeignPartiesPage foreignparty = new AgreementReqForeignPartiesPage(driver, test);
		AgreementReqUSPartiesPage usparty = new AgreementReqUSPartiesPage(driver, test);
		AgreementReqDocumentsOrNotesPage doc = new AgreementReqDocumentsOrNotesPage(driver, test);
		AgreementReqSubmitPage submit = new AgreementReqSubmitPage(driver, test);
		AgreementReqGeneralQuestionsPage question = new AgreementReqGeneralQuestionsPage(driver, test);
		AgreementReqRebaselineAmendmentPage amendment = new AgreementReqRebaselineAmendmentPage(driver, test);
		AgreementReqExportsUnderAgreementPage export = new AgreementReqExportsUnderAgreementPage(driver, test);
		AgreementReqMLAPage mla = new AgreementReqMLAPage(driver, test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.AgrReqTemplate();
					searchPage.AddTemplateButton();
					generalinfo.templateName(TemplateName);
					generalinfo.select_BuisnessUnit(BuisnessUnit);
					Wait.waitfor(3);
					generalinfo.enter_RequiredByDate(RequiredByDate);
					Wait.waitfor(7);
					generalinfo.enter_RequestorDetails(RequestorName, RequestorEmail, RequestorPhone, RequestorEMPId);
					Wait.waitfor(5);
					if (SameAsRequestor.length() > 0) {
						generalinfo.select_AO_SameAsRequestor();
						generalinfo.select_AM_SameAsRequestor();
					} else {
						generalinfo.enter_AgreementOwnerDetails(AOName, AOEmail, AOPhone, AOEMPId);
						Wait.waitfor(5);
						generalinfo.enter_AgreementManagerrDetails(AMName, AMEmail, AMPhone, AMEMPId);
						Wait.waitfor(5);
					}
					if (MLA.length() > 0) {
						generalinfo.enter_AgreementType_MLA(MLA);

					} else if (TAA.length() > 0) {
						generalinfo.enter_AgreementType_TAA(TAA);
					} else {
						generalinfo.enter_AgreementType_WDA();
					}
					Wait.waitfor(3);
					if (AgreementPurpose.length() > 0) {
						generalinfo.enter_AgreementPurpose(AgreementPurpose);
					}
					generalinfo.enter_SummaryandPurposeofAgreement(SummaryandPurposeofAgreement);
					generalinfo.select_Site(SiteId);
					generalinfo.select_Segment(Segment);
					generalinfo.select_Department(Department);
					generalinfo.select_ProductFamily(ProductFamily);
					generalinfo.select_Program(Program);
					generalinfo.select_ProductLines(ProductLine);
					generalinfo.enter_BusinessDetails(ContractNo, PurchaseOrderNo, FMSCaseNo);
					Wait.waitfor(3);
					generalinfo.click_SaveButton();
					Wait.waitfor(3);
					String Templatename = generalinfo.get_TemplateName();
					generalinfo.moveForward();
					Wait.waitfor(3);
					typeofexport.moveForward();
					amendmentmain.amendmentpurpose();
					if (AmendmentNo.length() > 0) {
						amendmentmain.enter_amendmentno(AmendmentNo);
						amendmentmain.enter_scopechange(ScopeChange);
						amendmentmain.enter_AdditionChangeInHardwareTechData(AdditionChangeInHardwareTechData);
						amendmentmain.enter_PartiesInvolvedAddDeletionofParties(PartiesInvolvedAddDeletionofParties);
						amendmentmain.enter_EndUserEndUseChange(EndUserEndUseChange);
						amendmentmain.enter_ExtendTerm(ExtendTerm);
						amendmentmain.enter_ComplianceIssuesDiscovered(ComplianceIssuesDiscovered);
						amendmentmain.enter_Other(Other);
						amendmentmain.enter_USMLCategories(USMLCategories);
						amendmentmain.save();
					}
					Wait.waitfor(3);
					amendmentmain.save();
					Wait.waitfor(3);
					amendmentmain.moveForward();
					Wait.waitfor(3);
					value.moveForward();
					foreignparty.addForeignParty();
					Wait.waitfor(3);
					foreignparty.enter_ConsigneeCode(ConsigneeId);
					Wait.waitfor(3);
					foreignparty.saveandreturn();
					Wait.waitfor(3);
					foreignparty.foreignPartyGridisDisplayed();
					Wait.waitfor(3);
					foreignparty.addThirdParty();
					foreignparty.selectthirdcountry(FPartyType, ThirdCountry);
					Wait.waitfor(3);
					foreignparty.moveright();
					Wait.waitfor(3);
					foreignparty.saveandreturn();
					Wait.waitfor(7);
					foreignparty.thirdPartyGridisDisplayed();
					foreignparty.moveForward();
					Wait.waitfor(3);
					usparty.addParty();
					Wait.waitfor(3);
					usparty.selectUSParty(Code);
					Wait.waitfor(3);
					usparty.saveandreturn();
					Wait.waitfor(3);
					usparty.usPartyGridisDisplayed();
					Wait.waitfor(3);
					usparty.moveForward();
					Wait.waitfor(3);
					question.notapplicable();
					Wait.waitfor(10);
					question.save();
					Wait.waitfor(5);
					question.moveForward();
					Wait.waitfor(3);
					if (TAA.contains("Y") || MLA.contains("Y")) {
						amendment.notapplicable();
						Wait.waitfor(10);
						amendment.save();
						Wait.waitfor(5);
						amendment.moveForward();
					}
					export.notapplicable();
					Wait.waitfor(10);
					export.save();
					Wait.waitfor(5);
					export.moveForward();
					Wait.waitfor(5);
					mla.notapplicable();
					Wait.waitfor(10);
					mla.save();
					Wait.waitfor(3);
					mla.moveForward();
					Wait.waitfor(5);
					doc.movetoDocNotes();
					Wait.waitfor(3);
					doc.click_view_add_Document();
					Wait.waitfor(3);
					doc.uploadDoc(DocumentType, DocumentDescription, uploadfileName);
					Wait.waitfor(3);
					doc.click_addnote();
					Wait.waitfor(3);
					doc.addnote(Note);
					Wait.waitfor(3);
					doc.movetosubmit();
					Wait.waitfor(5);
					submit.addreviewer(ReviewerName);
					submit.save();
					homepage.returnToCRPage();
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		}catch(SkipException s) {
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			e.printStackTrace();
			testFail();
			Assert.assertTrue(false);
	}
}

}
