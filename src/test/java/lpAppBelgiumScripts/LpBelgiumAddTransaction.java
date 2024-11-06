package lpAppBelgiumScripts;

import java.util.ArrayList;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.relevantcodes.extentreports.LogStatus;
import initializer.SeleniumTestBase;
import lpAppBelgiumClasses.AdditionalInformationPage;
import lpAppBelgiumClasses.ApplicantStatementPage;
import lpAppBelgiumClasses.ApplicantsSignaturePage;
import lpAppBelgiumClasses.ApplicationReferencePage;
import lpAppBelgiumClasses.CompanyDetailsPage;
import lpAppBelgiumClasses.CountryDetailsPage;
import lpAppBelgiumClasses.CreateNewAuthorizationPage;
import lpAppBelgiumClasses.EndUseAndAdditionalInformationPage;
import lpAppBelgiumClasses.EndUseSpecificPurposePage;
import lpAppBelgiumClasses.ExporterDetailsPage;
import lpAppBelgiumClasses.ForeignPartyDetailsPage;
import lpAppBelgiumClasses.HomeLpPage;
import lpAppBelgiumClasses.ItemsPage;
import lpAppBelgiumClasses.SearchAuthorizationsPage;
import lpAppBelgiumClasses.SearchAuthorizationsResultsPage;
import utilities.GenericMethods;
import utilities.Utility;
import utilities.Wait;

public class LpBelgiumAddTransaction extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("LpBelgiumTransactionAdding", excel);
	}

	@Test(dataProvider = "getData")
	public void AddLpBelgium(String Testcase, String RunMode, String SBU, String AuthGrantByCountry,
			String AuthorizationCode, String RefrenceId, String ProgramCode, String SegmentCode,
			String AuthPurposeStatus, String AuthorizationPurposeId, String Agency, String Status, String DocumentType,
			String UploadfileName, String DocumentLocationPath, String ExporterCode, String Country, String CountryType,
			String PartNo, String consigneeCode, String consigneeType, String exporterCode, String endUserspecific,
			String ContractDate, String customsRegime, String additionalInformation, String AcknowledgementChkBox,
			String applicantDate, String FirstAndLastName, String ProviosDescription, String Notes,
			String HDstatusReviewer, String ReviewerUserFirstName, String HDstatusApprovedForSub, String HDstatusAgency,
			String HDstatusAgencyApproved, String AgencyAuthorizationsNo, String AgencyIssueDate,
			String AgencyExpiryDate, String CheckSnapShot) throws Exception {

		HomeLpPage homelp = new HomeLpPage(driver, test);
		SearchAuthorizationsPage searchAuth = new SearchAuthorizationsPage(driver, test);
		CreateNewAuthorizationPage createAuth = new CreateNewAuthorizationPage(driver, test);
		ApplicationReferencePage applicationRef = new ApplicationReferencePage(driver, test);
		CompanyDetailsPage company = new CompanyDetailsPage(driver, test);
		ExporterDetailsPage exportDetails = new ExporterDetailsPage(driver, test);
		CountryDetailsPage countryDetails = new CountryDetailsPage(driver, test);
		ItemsPage item = new ItemsPage(driver, test);
		ForeignPartyDetailsPage foreignParty = new ForeignPartyDetailsPage(driver, test);
		EndUseAndAdditionalInformationPage endUseSpecificPurpose = new EndUseAndAdditionalInformationPage(driver, test);
		EndUseSpecificPurposePage enduser = new EndUseSpecificPurposePage(driver, test);
		AdditionalInformationPage addInfo = new AdditionalInformationPage(driver, test);
		ApplicantStatementPage applicantStatmt = new ApplicantStatementPage(driver, test);
		ApplicantsSignaturePage applicantSignature = new ApplicantsSignaturePage(driver, test);
		SearchAuthorizationsResultsPage searchAuthResults = new SearchAuthorizationsResultsPage(driver, test);
		SoftAssert softAssertion = new SoftAssert();

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homelp.moveTo_SBUSelection(SBU);
					searchAuth.click_AddAuthorization();
					createAuth.headerDetails(AuthGrantByCountry, AuthorizationCode, RefrenceId, ProgramCode,
							SegmentCode);
					createAuth.headerDetailsUnMandatory(AuthPurposeStatus, AuthorizationPurposeId);
					String wlsStatus = createAuth.wlsStatus();
					if (wlsStatus.equalsIgnoreCase("To Be Screened")) {
						test.log(LogStatus.PASS, "WLS Status : " + wlsStatus);
					} else {
						test.log(LogStatus.FAIL, "WLS Status : " + wlsStatus);
						testFail();
						softAssertion.assertTrue(false);
					}
					String Actual = createAuth.agencyAuthorization();
					if (Actual.equals(Agency)) {
						test.log(LogStatus.PASS, "Expected Agency : " + Agency);
					} else {
						test.log(LogStatus.FAIL, "Expected Agency : " + Agency);
						testFail();
						softAssertion.assertTrue(false);
					}
					createAuth.click_Save();
					Wait.waitfor(3);
					createAuth.pdfFile();
					createAuth.addDocument(DocumentType, UploadfileName, DocumentLocationPath);
					createAuth.add_ProviosConditions(ProviosDescription);
					createAuth.add_Note(Notes);
					createAuth.click_Save();
					createAuth.click_ApplicationDetails();
					String ReferenceID = exportDetails.ReferenceIDText();
					if (AuthorizationCode.equalsIgnoreCase("EXP-DL-IND")) {
						String YourReferenceID = applicationRef.get_yourRefID();
						applicationRef.licenceType(AuthorizationCode);
						String ReferenceIDs = exportDetails.ReferenceIDText();
						if (YourReferenceID.equalsIgnoreCase(ReferenceIDs)) {
							test.log(LogStatus.PASS, "Your Reference ID is equal to ReferenceID " + YourReferenceID);
						} else {
							test.log(LogStatus.FAIL,
									"Your Reference ID is not equal to ReferenceID " + YourReferenceID);
							testFail();
							softAssertion.assertTrue(false);
						}
						String StatusED = exportDetails.statusText();
						if (StatusED.equalsIgnoreCase("Status: In Progress")) {
							test.log(LogStatus.PASS, StatusED);
						} else {
							test.log(LogStatus.FAIL, StatusED);
							testFail();
							softAssertion.assertTrue(false);
						}
						exportDetails.exporterDetails(Status, ExporterCode);
						Wait.waitfor(3);
						exportDetails.click_Exptsave();
						exportDetails.click_addCountry();
					}
					if (AuthorizationCode.equalsIgnoreCase("EXP-DL-GL")) {
						company.add_Company(Status, ExporterCode);
						Wait.waitfor(3);
						company.click_Save();
						company.click_Countries();
					}
					ArrayList<String> country = GenericMethods.stringtoken(Country);
					ArrayList<String> countryType = GenericMethods.stringtoken(CountryType);
					for (int i = 0; i < countryType.size(); i++) {
						Wait.waitfor(5);
						countryDetails.addCountry(country.get(i), countryType.get(i));
						countryDetails.validate_addCountry(country.get(i));
					}
					Wait.waitfor(5);
					exportDetails.click_addItems();
					ArrayList<String> partNo = GenericMethods.stringtoken(PartNo);
					for (int i = 0; i < partNo.size(); i++) {
						item.addItemButton();
						try {
							item.createNewItems(partNo.get(i));
							item.searchProduct(partNo.get(i));
							if (AuthorizationCode.equalsIgnoreCase("EXP-DL-GL"))
								item.type_StatisticalCode();
							item.editItemSave();
							Wait.waitfor(5);
							item.cancleitems();
							item.validate_addItem(partNo.get(i));
						} catch (Exception e) {
							testFail();
							item.closeBtn();
							softAssertion.assertTrue(false);
						}
						item.saveItems();
						Wait.waitfor(4);
					}
					exportDetails.click_AddForeginParty();
					ArrayList<String> consigneeTy = GenericMethods.stringtoken(consigneeType);
					ArrayList<String> consigneeCo = GenericMethods.stringtoken(consigneeCode);
					for (int i = 0; i < consigneeTy.size(); i++) {
						foreignParty.addPartyBtn();
						try {
							foreignParty.createNewForeignParty();
							foreignParty.searchConsignee(consigneeCo.get(i));
							Wait.waitfor(5);
							foreignParty.saveForeignParty(consigneeTy.get(i));
							Wait.waitfor(3);
							foreignParty.validate_addParties(consigneeTy.get(i));
						} catch (Exception e) {
							testFail();
							item.closeBtn();
							softAssertion.assertTrue(false);
						}
					}
					Wait.waitfor(4);
					exportDetails.click_EndUse();
					if (AuthorizationCode.equalsIgnoreCase("EXP-DL-IND")) {
						endUseSpecificPurpose.endUseSpecificPurpose(endUserspecific);
						Wait.waitfor(3);
						endUseSpecificPurpose.additionalInformationPage(ContractDate, customsRegime,
								additionalInformation);
						endUseSpecificPurpose.add_acknowledgement(AcknowledgementChkBox);
						endUseSpecificPurpose.click_EndUseAndAddInfoSaveBtn();
					}
					if (AuthorizationCode.equalsIgnoreCase("EXP-DL-GL")) {
						enduser.endUseSpecificPurpose(endUserspecific);
						exportDetails.click_AdditionalInfo();
						addInfo.additionalInformationPage(ContractDate, customsRegime, additionalInformation);
					}
					exportDetails.click_AppStatement();
					if (AuthorizationCode.equalsIgnoreCase("EXP-DL-GL")) {
						applicantStatmt.applicationStatement(applicantDate, AcknowledgementChkBox);
						applicantStatmt.applicantStatmentsaveBtn();
					}
					if (AuthorizationCode.equalsIgnoreCase("EXP-DL-IND")) {
						applicantSignature.applicationSignature(applicantDate, FirstAndLastName);
						applicantSignature.applicantSignCertifactesaveBtn();
					}
					exportDetails.click_BackToHeader();
					Wait.waitfor(4);
					createAuth.select_status(HDstatusReviewer);
					createAuth.click_reviewerlink(ReviewerUserFirstName);
					createAuth.click_Save();
					createAuth.select_status(HDstatusApprovedForSub);
					createAuth.checkCircle();
					createAuth.click_Save();
					createAuth.select_status(HDstatusAgency);
					createAuth.click_Save();
					createAuth.select_status(HDstatusAgencyApproved);
					createAuth.click_Save();
					createAuth.agencyAuthoNo(AgencyAuthorizationsNo, AgencyIssueDate, AgencyExpiryDate);
					createAuth.click_Save();
					Wait.waitfor(4);
					if (CheckSnapShot.equalsIgnoreCase("Yes")) {
						createAuth.validateSnapshot(ReferenceID, AuthorizationCode, HDstatusAgencyApproved);
						Wait.waitfor(3);
					}
					homelp.moveTo_SBUSelection(SBU);
					searchAuth.referenceID(ReferenceID);
					searchAuth.click_SearchBtn();
					searchAuthResults.displayOfRefID(ReferenceID);
					softAssertion.assertAll();
					homelp.returnHomepageLP();
					Wait.waitfor(3);
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homelp.returnHomepageLP();
			Assert.assertTrue(false);
		}
	}

}
