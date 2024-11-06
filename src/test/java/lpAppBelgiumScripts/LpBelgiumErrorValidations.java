package lpAppBelgiumScripts;

import java.lang.reflect.Method;
import java.util.ArrayList;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.relevantcodes.extentreports.LogStatus;
import initializer.SeleniumTestBase;
import lpAppBelgiumClasses.ApplicantsSignaturePage;
import lpAppBelgiumClasses.CompanyDetailsPage;
import lpAppBelgiumClasses.CountryDetailsPage;
import lpAppBelgiumClasses.CreateNewAuthorizationPage;
import lpAppBelgiumClasses.EndUseAndAdditionalInformationPage;
import lpAppBelgiumClasses.ExporterDetailsPage;
import lpAppBelgiumClasses.ForeignPartyDetailsPage;
import lpAppBelgiumClasses.HomeLpPage;
import lpAppBelgiumClasses.ItemsPage;
import lpAppBelgiumClasses.SearchAuthorizationsPage;
import utilities.GenericMethods;
import utilities.Utility;
import utilities.Wait;

public class LpBelgiumErrorValidations extends SeleniumTestBase {

	// Error validations for create New Authorizations Header Details
	@Test(priority = 1)
	public void validateCreateNewAuthHeaderDetails(Method method) throws Exception {

		HomeLpPage homelp = new HomeLpPage(driver, test);
		SearchAuthorizationsPage searchAuth = new SearchAuthorizationsPage(driver, test);
		CreateNewAuthorizationPage createAuth = new CreateNewAuthorizationPage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homelp.moveTo_SBUSelection(propLP.getProperty("SBU"));
				searchAuth.click_AddAuthorization();
				createAuth.click_Save();
				createAuth.validateHeaderDetailsError();
				Wait.waitfor(4);
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

	// Error validations for exporter Details
	@Test(priority = 2)
	public void validateExporterDetailsError(Method method) throws Exception {

		HomeLpPage homelp = new HomeLpPage(driver, test);
		SearchAuthorizationsPage searchAuth = new SearchAuthorizationsPage(driver, test);
		CreateNewAuthorizationPage createAuth = new CreateNewAuthorizationPage(driver, test);
		ExporterDetailsPage exportDetails = new ExporterDetailsPage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homelp.moveTo_SBUSelection(propLP.getProperty("SBU"));
				searchAuth.click_AddAuthorization();
				createAuth.headerDetails(propLP.getProperty("AuthGrantByCountry"),
						propLP.getProperty("AuthorizationCode"), propLP.getProperty("RefrenceId"),
						propLP.getProperty("Program"), propLP.getProperty("Segment"));
				createAuth.click_Save();
				createAuth.click_ApplicationDetails();
				exportDetails.click_ExporterIcon();
				exportDetails.click_Exptsave();
				exportDetails.validateExportDetailsError();
				Wait.waitfor(4);
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

	// Error validations for Country Details
	@Test(priority = 3)
	public void validateCountryDetailsError(Method method) throws Exception {

		HomeLpPage homelp = new HomeLpPage(driver, test);
		SearchAuthorizationsPage searchAuth = new SearchAuthorizationsPage(driver, test);
		CreateNewAuthorizationPage createAuth = new CreateNewAuthorizationPage(driver, test);
		CountryDetailsPage countryDetails = new CountryDetailsPage(driver, test);
		CompanyDetailsPage company = new CompanyDetailsPage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homelp.moveTo_SBUSelection(propLP.getProperty("SBU"));
				searchAuth.click_AddAuthorization();
				createAuth.headerDetails(propLP.getProperty("AuthGrantByCountry"),
						propLP.getProperty("AuthorizationCode"), propLP.getProperty("RefrenceId"),
						propLP.getProperty("Program"), propLP.getProperty("Segment"));
				createAuth.click_Save();
				createAuth.click_ApplicationDetails();
				company.click_Countries();
				countryDetails.validateCountryDetails();
				Wait.waitfor(3);
				countryDetails.addCountry(propLP.getProperty("Country"), propLP.getProperty("CountryType"));
				Wait.waitfor(3);
				countryDetails.addCountry(propLP.getProperty("Country1"), propLP.getProperty("CountryType"));
				countryDetails.validateCountryDetlsofSameCountryType();
				Wait.waitfor(4);
				homelp.returnHomepageLP();
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

	// Error validations for Items Details
	@Test(priority = 4)
	public void validateItemsDetailsError(Method method) throws Exception {

		HomeLpPage homelp = new HomeLpPage(driver, test);
		SearchAuthorizationsPage searchAuth = new SearchAuthorizationsPage(driver, test);
		CreateNewAuthorizationPage createAuth = new CreateNewAuthorizationPage(driver, test);
		ExporterDetailsPage exportDetails = new ExporterDetailsPage(driver, test);
		ItemsPage item = new ItemsPage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homelp.moveTo_SBUSelection(propLP.getProperty("SBU"));
				searchAuth.click_AddAuthorization();
				createAuth.headerDetails(propLP.getProperty("AuthGrantByCountry"),
						propLP.getProperty("AuthorizationCode"), propLP.getProperty("RefrenceId"),
						propLP.getProperty("Program"), propLP.getProperty("Segment"));
				createAuth.click_Save();
				createAuth.click_ApplicationDetails();
				exportDetails.click_addItems();
				item.addItemButton();
				item.editItemSave();
				item.validateItemsDetails();
				Wait.waitfor(3);
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

	// Error validations for Foreign Party Details
	@Test(priority = 5)
	public void validateForeignPartyDetailsError(Method method) throws Exception {

		HomeLpPage homelp = new HomeLpPage(driver, test);
		SearchAuthorizationsPage searchAuth = new SearchAuthorizationsPage(driver, test);
		CreateNewAuthorizationPage createAuth = new CreateNewAuthorizationPage(driver, test);
		ExporterDetailsPage exportDetails = new ExporterDetailsPage(driver, test);
		ForeignPartyDetailsPage foreignParty = new ForeignPartyDetailsPage(driver, test);
		ItemsPage item = new ItemsPage(driver, test);
		SoftAssert softAssertion = new SoftAssert();

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homelp.moveTo_SBUSelection(propLP.getProperty("SBU"));
				searchAuth.click_AddAuthorization();
				createAuth.headerDetails(propLP.getProperty("AuthGrantByCountry"),
						propLP.getProperty("AuthorizationCode"), propLP.getProperty("RefrenceId"),
						propLP.getProperty("Program"), propLP.getProperty("Segment"));
				createAuth.click_Save();
				createAuth.click_ApplicationDetails();
				exportDetails.click_AddForeginParty();

				ArrayList<String> consigneeType = GenericMethods.stringtoken(propLP.getProperty("ConsigneeType"));

				foreignParty.addPartyBtn();
				foreignParty.validateForigenPartyDetailsError();
				for (int i = 0; i < consigneeType.size(); i++) {
					Wait.waitfor(3);
					foreignParty.addPartyBtn();
					try {
						foreignParty.createNewForeignParty();
						foreignParty.searchConsignee(propLP.getProperty("ConsigneeCode"));
						Wait.waitfor(5);
						foreignParty.saveForeignParty(consigneeType.get(i));
						Wait.waitfor(3);
						foreignParty.addPartyBtn();
						foreignParty.createNewForeignParty();
						foreignParty.searchConsignee(propLP.getProperty("ConsigneeCode"));
						Wait.waitfor(5);
						foreignParty.validateForigenPartyDetailsErrorofSameCType(consigneeType.get(i));
					} catch (Exception e) {
						testFail();
						item.closeBtn();
						softAssertion.assertTrue(false);
					}
				}
				softAssertion.assertAll();
				Wait.waitfor(3);
				homelp.returnHomepageLP();
				Wait.waitfor(3);
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

	/*
	 * // Error validations for Domestic party Details
	 * 
	 * @Test(priority = 6) public void domesticPartyDetailsError() throws Exception
	 * {
	 * 
	 * HomeLpPage homelp = new HomeLpPage(driver, test); SearchAuthorizationsPage
	 * searchAuth = new SearchAuthorizationsPage(driver, test);
	 * CreateNewAuthorizationPage createAuth = new
	 * CreateNewAuthorizationPage(driver, test); ExporterDetailsPage exportDetails =
	 * new ExporterDetailsPage(driver, test); DomesticPartyDetailsPage domesticParty
	 * = new DomesticPartyDetailsPage(driver, test);
	 * 
	 * try { if (!Utility.isExecutable(getClass().getSimpleName(), excel)) { throw
	 * new SkipException("Skipping the test"); } else {
	 * 
	 * homelp.moveTo_SBUSelection(propLP.getProperty("SBU"));
	 * searchAuth.click_AddAuthorization();
	 * createAuth.headerDetails(propLP.getProperty("AuthGrantByCountry"),
	 * propLP.getProperty("AuthorizationCode"), propLP.getProperty("RefrenceId"));
	 * createAuth.click_Save(); createAuth.click_ApplicationDetails();
	 * exportDetails.click_AddForeginParty();
	 * exportDetails.click_AddDomesticParty(); domesticParty.addParties();
	 * domesticParty.validateDomesticPartyDetailsError(); Wait.waitfor(3);
	 * domesticParty.addParties(); domesticParty.createNewDomesticParty();
	 * domesticParty.exporterCode(propLP.getProperty("ExporterCode"));
	 * domesticParty.editDomesticPartySave(); Wait.waitfor(3);
	 * domesticParty.addParties(); domesticParty.createNewDomesticParty();
	 * domesticParty.exporterCode(propLP.getProperty("ExporterCode"));
	 * Wait.waitfor(3); domesticParty.validateDomesticPrtyDetlswithSameAgent();
	 * Wait.waitfor(3); homelp.returnHomepageLP(); } } catch (SkipException s) { //
	 * s.printStackTrace(); test.log(LogStatus.SKIP, "Please check the run mode");
	 * throw s; } catch (Exception e) { testFail(); e.printStackTrace();
	 * homelp.returnHomepageLP(); Assert.assertTrue(false); } }
	 */

	// Error validations for End user & Add inforamtions & Applicant Statement
	@Test(priority = 6)
	public void validateEndUser_ApplicantSignatureError(Method method) throws Exception {

		HomeLpPage homelp = new HomeLpPage(driver, test);
		SearchAuthorizationsPage searchAuth = new SearchAuthorizationsPage(driver, test);
		CreateNewAuthorizationPage createAuth = new CreateNewAuthorizationPage(driver, test);
		ExporterDetailsPage exportDetails = new ExporterDetailsPage(driver, test);
		EndUseAndAdditionalInformationPage endUseSpecificPurpose = new EndUseAndAdditionalInformationPage(driver, test);
		ApplicantsSignaturePage applicantStatement = new ApplicantsSignaturePage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homelp.moveTo_SBUSelection(propLP.getProperty("SBU"));
				searchAuth.click_AddAuthorization();
				createAuth.headerDetails(propLP.getProperty("AuthGrantByCountry"),
						propLP.getProperty("AuthorizationCode"), propLP.getProperty("RefrenceId"),
						propLP.getProperty("Program"), propLP.getProperty("Segment"));
				createAuth.click_Save();
				createAuth.click_ApplicationDetails();
				exportDetails.click_EndUse();
				endUseSpecificPurpose.validateEndUserError();
				exportDetails.click_AppStatement();
				applicantStatement.applicantSignCertifactesaveBtn();
				applicantStatement.validateApplicantStatement();
				Wait.waitfor(3);
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

	// Error validations for Approved for Submission
	@Test(priority = 7)
	public void validateApprovedforSubmissionError(Method method) throws Exception {

		HomeLpPage homelp = new HomeLpPage(driver, test);
		SearchAuthorizationsPage searchAuth = new SearchAuthorizationsPage(driver, test);
		CreateNewAuthorizationPage createAuth = new CreateNewAuthorizationPage(driver, test);
		ExporterDetailsPage exportDetails = new ExporterDetailsPage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homelp.moveTo_SBUSelection(propLP.getProperty("SBU"));
				searchAuth.click_AddAuthorization();
				createAuth.headerDetails(propLP.getProperty("AuthGrantByCountry"),
						propLP.getProperty("AuthorizationCode"), propLP.getProperty("RefrenceId"),
						propLP.getProperty("Program"), propLP.getProperty("Segment"));
				createAuth.click_Save();
				createAuth.click_ApplicationDetails();
				exportDetails.exporterDetails(propLP.getProperty("Status"), propLP.getProperty("ExporterCode"));
				Wait.waitfor(3);
				exportDetails.click_Exptsave();
				exportDetails.click_BackToHeader();
				createAuth.select_status(propLP.getProperty("HDstatusPR"));
				createAuth.click_Save();
				createAuth.validateReviewerDetailsError();
				createAuth.click_reviewerlink(propLP.getProperty("ReviewerUserFirstName"));
				createAuth.click_Save();
				createAuth.select_status(propLP.getProperty("HDstatusApprovedSub"));
				createAuth.click_Save();
				createAuth.validateApprovedforSubmissionError();
				Wait.waitfor(3);
				homelp.returnHomepageLP();
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

	// Error validations for Approved for Agency Reviewer
	@Test(priority = 8)
	public void validateApprovedforAgencyReviewer(Method method) throws Exception {

		HomeLpPage homelp = new HomeLpPage(driver, test);
		SearchAuthorizationsPage searchAuth = new SearchAuthorizationsPage(driver, test);
		CreateNewAuthorizationPage createAuth = new CreateNewAuthorizationPage(driver, test);
		ExporterDetailsPage exportDetails = new ExporterDetailsPage(driver, test);
		CountryDetailsPage countryDetails = new CountryDetailsPage(driver, test);
		ItemsPage item = new ItemsPage(driver, test);
		ForeignPartyDetailsPage foreignParty = new ForeignPartyDetailsPage(driver, test);
		EndUseAndAdditionalInformationPage endUseSpecificPurpose = new EndUseAndAdditionalInformationPage(driver, test);
		ApplicantsSignaturePage applicantSignature = new ApplicantsSignaturePage(driver, test);
		SoftAssert softAssertion = new SoftAssert();

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homelp.moveTo_SBUSelection(propLP.getProperty("SBU"));
				searchAuth.click_AddAuthorization();
				createAuth.headerDetails(propLP.getProperty("AuthGrantByCountry"),
						propLP.getProperty("AuthorizationCode"), propLP.getProperty("RefrenceId"),
						propLP.getProperty("Program"), propLP.getProperty("Segment"));
				createAuth.click_Save();
				createAuth.click_ApplicationDetails();
				exportDetails.exporterDetails(propLP.getProperty("Status"), propLP.getProperty("ExporterCode"));
				Wait.waitfor(3);
				exportDetails.click_Exptsave();

				exportDetails.click_addCountry();
				ArrayList<String> country = GenericMethods.stringtoken(propLP.getProperty("MultipleCountrys"));
				ArrayList<String> countryType = GenericMethods.stringtoken(propLP.getProperty("MultipleCountryType"));
				for (int i = 0; i < countryType.size(); i++) {
					Wait.waitfor(5);
					countryDetails.addCountry(country.get(i), countryType.get(i));
				}
				Wait.waitfor(5);
				exportDetails.click_addItems();
				item.addItemButton();
				try {
					item.createNewItems(propLP.getProperty("PartNo"));
					item.searchProduct(propLP.getProperty("PartNo"));
					item.editItemSave();
					Wait.waitfor(4);
					item.cancleitems();
				} catch (Exception e) {
					testFail();
					item.closeBtn();
					softAssertion.assertTrue(false);
				}
				item.saveItems();
				Wait.waitfor(4);
				exportDetails.click_AddForeginParty();
				ArrayList<String> consigneeTy = GenericMethods.stringtoken(propLP.getProperty("ConsigneeType"));
				ArrayList<String> consigneeCo = GenericMethods.stringtoken(propLP.getProperty("Multipleconsigneecode"));

				for (int i = 0; i < consigneeTy.size(); i++) {
					foreignParty.addPartyBtn();
					try {
						foreignParty.createNewForeignParty();
						foreignParty.searchConsignee(consigneeCo.get(i));
						Wait.waitfor(5);
						foreignParty.saveForeignParty(consigneeTy.get(i));
						Wait.waitfor(3);
					} catch (Exception e) {
						testFail();
						item.closeBtn();
						softAssertion.assertTrue(false);
					}
				}
				Wait.waitfor(4);
				exportDetails.click_EndUse();
				endUseSpecificPurpose.endUseSpecificPurpose(propLP.getProperty("endUserspecific"));
				endUseSpecificPurpose.additionalInformationPage(propLP.getProperty("ContractDate"),
						propLP.getProperty("customsRegime"), propLP.getProperty("additionalInformation"));
				endUseSpecificPurpose.add_acknowledgement(propLP.getProperty("AcknowledgementChkBox"));
				endUseSpecificPurpose.click_EndUseAndAddInfoSaveBtn();
				exportDetails.click_AppStatement();
				applicantSignature.applicationSignature(propLP.getProperty("applicantDate"),
						propLP.getProperty("FirstAndLastName"));
				applicantSignature.applicantSignCertifactesaveBtn();
				exportDetails.click_BackToHeader();
				Wait.waitfor(4);
				createAuth.select_status(propLP.getProperty("HDstatusPR"));
				createAuth.click_Save();
				createAuth.click_reviewerlink(propLP.getProperty("ReviewerUserFirstName"));
				createAuth.click_Save();
				createAuth.select_status(propLP.getProperty("HDstatusApprovedSub"));
				createAuth.click_Save();
				createAuth.select_status(propLP.getProperty("HDstatusAgency"));
				createAuth.click_Save();
				createAuth.select_status(propLP.getProperty("HDstatusAgencyApproved"));
				createAuth.click_Save();
				createAuth.validateAgencyApprovedError();
				Wait.waitfor(3);
				softAssertion.assertAll();
				homelp.returnHomepageLP();
				Wait.waitfor(5);
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
