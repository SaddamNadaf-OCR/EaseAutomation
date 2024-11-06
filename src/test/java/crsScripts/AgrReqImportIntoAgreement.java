package crsScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import crsClasses.AgrReqSelectToImportPage;
import crsClasses.AgreementReqAmendmentMainPage;
import crsClasses.AgreementReqDocumentsOrNotesPage;
import crsClasses.AgreementReqExportsUnderAgreementPage;
import crsClasses.AgreementReqForeignPartiesPage;
import crsClasses.AgreementReqGeneralInfoPage;
import crsClasses.AgreementReqGeneralQuestionsPage;
import crsClasses.AgreementReqImportIntoAgreementPage;
import crsClasses.AgreementReqMLAPage;
import crsClasses.AgreementReqPartiesQuestnPage;
import crsClasses.AgreementReqRebaselineAmendmentPage;
import crsClasses.AgreementReqReviewPage;
import crsClasses.AgreementReqSubmitPage;
import crsClasses.AgreementReqTypeOfExportPage;
import crsClasses.AgreementReqUSPartiesPage;
import crsClasses.AgreementReqValuationPage;
import crsClasses.AgreementSelectSBUPage;
import crsClasses.AgreementTemplatePage;
import crsClasses.DOSListAgreementPage;
import crsClasses.DOSSearchAgreementPage;
import crsClasses.HomePageCRs;
import crsClasses.SearchAgreementRequestPage;
import crsClasses.SearchDSP5Page;
import crsClasses.SearchExportRequestPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AgrReqImportIntoAgreement extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AgreementReq", excel);
	}

	@Test(dataProvider = "getData") 
	public void AgrImportIntoAgreement(String Testcase,String RunMode, String SBU, String BuisnessUnit, String RequiredByDate, String RequestorName, String RequestorEmail, String RequestorPhone,String RequestorEMPId,String SameAsRequestor,
			String AOName,String AOEmail,String AOPhone,String AOEMPId,String AMName,String AMEmail,String AMPhone,String AMEMPId,String TAA,String MLA,String AgreementNo,String AgreementPurpose,String SummaryandPurposeofAgreement,
			String Site, String Segment,String Department,String ProductFamily,String Program,String ProductLine,String ContractNo,String PurchaseOrderNo,String FMSCaseNo, String AmendmentNo, String ScopeChange,
			String AdditionChangeInHardwareTechData, String PartiesInvolvedAddDeletionofParties, String EndUserEndUseChange, String ExtendTerm,
			String ComplianceIssuesDiscovered, String Other, String USMLCategories,String Country, String ConsigneeId,String FPartyType, String ThirdCountry, String Code, String DocumentType, 
			String DocumentDescription, String uploadfileName, String Note, String ReviewerName,String Status, String Phoneno, String Determination, String LicenseType) throws Exception {

		// ******************************** Objects Creation *******************************************//

		HomePageCRs					           home			       = new HomePageCRs(driver, test);
		SearchExportRequestPage                searchER		       = new SearchExportRequestPage(driver, test);
		SearchAgreementRequestPage             searchAR   		   = new SearchAgreementRequestPage(driver, test);
		AgreementSelectSBUPage                 selectsbu           = new AgreementSelectSBUPage(driver, test);
		AgreementTemplatePage                  template            = new AgreementTemplatePage(driver, test);
		AgreementReqGeneralInfoPage            generalinfo         = new AgreementReqGeneralInfoPage(driver, test);
		AgreementReqTypeOfExportPage           typeofexport        = new AgreementReqTypeOfExportPage(driver, test);
		AgreementReqAmendmentMainPage          amendmentmain       = new AgreementReqAmendmentMainPage(driver, test);
		AgreementReqValuationPage              value               = new AgreementReqValuationPage(driver, test);
		AgreementReqForeignPartiesPage         foreignparty        = new AgreementReqForeignPartiesPage(driver,test);
		AgreementReqUSPartiesPage              usparty             = new AgreementReqUSPartiesPage(driver,test);
		AgreementReqDocumentsOrNotesPage       doc                 = new AgreementReqDocumentsOrNotesPage(driver, test); 
		AgreementReqSubmitPage                 submit              = new AgreementReqSubmitPage(driver,test);
		AgreementReqGeneralQuestionsPage       question            = new AgreementReqGeneralQuestionsPage(driver,test);
		AgreementReqRebaselineAmendmentPage    amendment           = new AgreementReqRebaselineAmendmentPage(driver,test);
		AgreementReqExportsUnderAgreementPage  export              = new AgreementReqExportsUnderAgreementPage(driver,test);
		AgreementReqMLAPage                    mla                 = new AgreementReqMLAPage(driver,test);
		AgreementReqReviewPage                 review              = new AgreementReqReviewPage(driver,test);
		AgreementReqPartiesQuestnPage          parties             = new AgreementReqPartiesQuestnPage(driver,test);
		AgreementReqImportIntoAgreementPage    importagr           = new AgreementReqImportIntoAgreementPage(driver,test);
		AgrReqSelectToImportPage               selecttoimport      = new AgrReqSelectToImportPage(driver,test);
		SearchDSP5Page                         searchdsp5          = new SearchDSP5Page(driver,test);
		DOSSearchAgreementPage                 searchagr           = new DOSSearchAgreementPage(driver,test);
		DOSListAgreementPage                   list                = new DOSListAgreementPage(driver,test);

		// ******************************************** Test steps execution ***************************
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel))
			{
				throw new SkipException("Skipping the test");
			}else {	
				if(RunMode.equalsIgnoreCase("y")) {

					test.log(LogStatus.INFO, Testcase);
					home.moveTo_ListScreening();
					home.click_ComplianceRequest();
					searchER.moveTo_Features();
					searchER.click_Requests();
					searchER.click_AgreementReq();
					searchAR.click_AddRequestBtn();
					if(SBU.length()>0) {
						selectsbu.SelectSBU(SBU);
						selectsbu.clickSelect();
					}
					Wait.waitfor(5);
					template.click_NewRequest();                  
					Wait.waitfor(7);
					generalinfo.select_BuisnessUnit(BuisnessUnit);
					Wait.waitfor(3);
					generalinfo.enter_RequiredByDate(RequiredByDate);
					Wait.waitfor(7);
					generalinfo.enter_RequestorDetails(RequestorName, RequestorEmail, RequestorPhone, RequestorEMPId);
					Wait.waitfor(5);
					if(SameAsRequestor.length()>0) {
						generalinfo.select_AO_SameAsRequestor();
						generalinfo.select_AM_SameAsRequestor();
					}
					else {
						generalinfo.enter_AgreementOwnerDetails(AOName, AOEmail, AOPhone, AOEMPId);
						Wait.waitfor(5);
						generalinfo.enter_AgreementManagerrDetails(AMName, AMEmail, AMPhone, AMEMPId);
						Wait.waitfor(5);
					}
					if(MLA.length()>0) {
						generalinfo.enter_AgreementType_MLA(MLA);
						//generalinfo.add_AgreementNo(AgreementNo);
					}
					else if(TAA.length()>0){
						generalinfo.enter_AgreementType_TAA(TAA);
						//						if(TAA.contains("Yes")) {
						//						generalinfo.add_AgreementNo(AgreementNo);
						//						}
					}
					else {
						generalinfo.enter_AgreementType_WDA(); 
					}
					Wait.waitfor(3);					
					generalinfo.enter_AgreementPurpose(AgreementPurpose);
					generalinfo.enter_SummaryandPurposeofAgreement(SummaryandPurposeofAgreement);
					generalinfo.enter_BusinessDetails(ContractNo, PurchaseOrderNo, FMSCaseNo);
					Wait.waitfor(3);
					generalinfo.click_SaveButton();
					Wait.waitfor(3);
					generalinfo.moveForward();
					Wait.waitfor(3);
					typeofexport.moveForward();
					Wait.waitfor(3);
					amendmentmain.amendmentpurpose();
					Wait.waitfor(3);
					if(AmendmentNo.length()>0) {
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
					amendmentmain.addCountryOfUltDestination(Country);
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
					foreignparty.addThirdParty();
					foreignparty.selectthirdcountry(FPartyType,ThirdCountry);
					Wait.waitfor(3);
					foreignparty.moveright();
					Wait.waitfor(3);
					foreignparty.saveandreturn();
					Wait.waitfor(5);
					foreignparty.moveForward();
					Wait.waitfor(3);
					usparty.addParty();
					Wait.waitfor(3);
					usparty.selectUSParty(Code);
					Wait.waitfor(3);
					usparty.saveandreturn();
					Wait.waitfor(3);
					usparty.moveForward();					
					Wait.waitfor(3);
					question.notapplicable();
					Wait.waitfor(10);
					question.save();
					Wait.waitfor(5);
					question.moveForward();
					Wait.waitfor(5);
					parties.moveForward();
					Wait.waitfor(3);
					if(TAA.contains("Y")||MLA.contains("Y")) {
						amendment.moveForward();
						Wait.waitfor(5);
					}					
					export.notapplicable();
					Wait.waitfor(5);
					export.save();
					Wait.waitfor(5);
					export.moveForward();
					Wait.waitfor(5);
					mla.notapplicable();
					mla.save();
					Wait.waitfor(3);
					mla.moveForward();
					Wait.waitfor(5);
					 doc.movetosubmit();
//						try {
//							doc.add_Document(DocumentType, DocumentDescription, uploadfileName);
//							//Wait.waitfor(5);
//						} catch (Exception e) {
//							// TODO: handle exception
//							doc.moveForward();
//						}
	//
//						Wait.waitfor(5);
//						try {
//							doc.addnote(Note);
//							doc.moveForward();
//						} catch (Exception e) {
//							// TODO: handle exception
//							doc.moveForward();
//						}
						Wait.waitfor(10);	
					//Wait.waitfor(10);
					submit.addreviewer(ReviewerName); 
					submit.save();
					submit.submitforreview();
					Wait.waitfor(3);
					submit.moveForward();
					Wait.waitfor(3);
					review.select_status(propCRs.getProperty("AgrStatus"));
					Wait.waitfor(3);
					review.enter_phoneno(propCRs.getProperty("AgrPhone"));
					Wait.waitfor(3);				
					review.select_determination(propCRs.getProperty("Determination"));
					review.add_agreementno();
					Wait.waitfor(3);
					review.save();
					Wait.waitfor(10);
					review.moveForward();
					Wait.waitfor(3);					
					importagr.select_licensetype(propCRs.getProperty("LicenseType"));
					Wait.waitfor(3);
					importagr.userequestid();
					Wait.waitfor(3);
					importagr.save();
					Wait.waitfor(3);
					String Transactionid =importagr.get_licensetransactionid();
					System.out.println("Transaction id: " +Transactionid);
					Wait.waitfor(3);
					importagr.importall();
					Wait.waitfor(3);
					selecttoimport.selectall();
					selecttoimport.click_import();
					Wait.waitfor(3);
					home.moveTo_ListScreening();
					Wait.waitfor(3);
					home.click_DOSLicensing();
					Wait.waitfor(3);
					searchdsp5.moveTo_Features();
					Wait.waitfor(3);
					searchdsp5.click_Agreements();
					Wait.waitfor(3);
					searchdsp5.click_Agreement();
					Wait.waitfor(3);
					searchagr.enter_transactionid(Transactionid); 
					Wait.waitfor(3);
					searchagr.click_serach();
					Wait.waitfor(3);
					list.get_transactionid();
					Wait.waitfor(3);
					if(list.get_transactionid().equals(Transactionid)) {
						System.out.println("Test Passed: " + "AGR Id is " + list.get_transactionid()  + " Transaction Id is "+  Transactionid );						
					}
					home.returnToCRPage();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			testFail();
			home.returnToCRPage();
			Assert.assertTrue(false);
		}

	}
}	


