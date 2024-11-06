package lpAppUKScripts;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import initializer.SeleniumTestBase;
import lpAppUKClasses.ApplicationReferenceUKPage;
import lpAppUKClasses.ContactSectionUKPage;
import lpAppUKClasses.CreateNewAuthorizationUKPage;
import lpAppUKClasses.DeclarationUKPage;
import lpAppUKClasses.ExportGoodsListUKPage;
import lpAppUKClasses.FormValidationsUKPage;
import lpAppUKClasses.GoodsLocationUKPage;
import lpAppUKClasses.GoodsRecipientUKPage;
import lpAppUKClasses.HomeLpUKPage;
import lpAppUKClasses.NatureofGoodsUKPage;
import lpAppUKClasses.OtherThirdPartyDocumentsUKPage;
import lpAppUKClasses.ProposedLicensesUKPage;
import lpAppUKClasses.RouteOfGoodsUKPage;
import lpAppUKClasses.SearchAuthorizationsPageUK;
import lpAppUKClasses.SupportingDocumentsUKPage;
import lpAppUKClasses.UltimateEndUserUKPage;
import utilities.Utility;
import utilities.Wait;

public class LPUKerrorValidation extends SeleniumTestBase {

	// Error validations for create New Authorizations Header Details

	@Test(priority = 1)
	public void CreateNewAuthHeaderDetailsvalidations(Method method) throws Exception {

		HomeLpUKPage homeuk = new HomeLpUKPage(driver, test);
		SearchAuthorizationsPageUK searchAuth = new SearchAuthorizationsPageUK(driver, test);
		CreateNewAuthorizationUKPage createAuth = new CreateNewAuthorizationUKPage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeuk.moveTo_SBUSelection(propLpUk.getProperty("SBU"));
				searchAuth.click_AddAuthorization();
				createAuth.click_Save();
				createAuth.validateHeaderDetailsError();
				Wait.waitfor(4);
				homeuk.returnHomepageLP();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homeuk.returnHomepageLP();
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 2)
	public void ApplicationReferencevalidations(Method method) throws Exception {

		HomeLpUKPage homeuk = new HomeLpUKPage(driver, test);
		SearchAuthorizationsPageUK searchAuth = new SearchAuthorizationsPageUK(driver, test);
		CreateNewAuthorizationUKPage createAuth = new CreateNewAuthorizationUKPage(driver, test);
		ApplicationReferenceUKPage appReference = new ApplicationReferenceUKPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeuk.moveTo_SBUSelection(propLpUk.getProperty("SBU"));
				searchAuth.click_AddAuthorization();
				createAuth.headerDetails(propLpUk.getProperty("AuthGrantByCountry"),
						propLpUk.getProperty("AuthorizationCode"), "");
				createAuth.click_Save();
				createAuth.authorizationDetailsButton();
				appReference.clickOnEnterPreviousApp();
				appReference.validateApplicationReferenceError();
				Wait.waitfor(4);
				homeuk.returnHomepageLP();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homeuk.returnHomepageLP();
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 3)
	public void ProposedLicenseeTypeIndividualvalidations(Method method) throws Exception {

		HomeLpUKPage homeuk = new HomeLpUKPage(driver, test);
		SearchAuthorizationsPageUK searchAuth = new SearchAuthorizationsPageUK(driver, test);
		CreateNewAuthorizationUKPage createAuth = new CreateNewAuthorizationUKPage(driver, test);
		ProposedLicensesUKPage proposedLicense = new ProposedLicensesUKPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeuk.moveTo_SBUSelection(propLpUk.getProperty("SBU"));
				searchAuth.click_AddAuthorization();
				createAuth.headerDetails(propLpUk.getProperty("AuthGrantByCountry"),
						propLpUk.getProperty("AuthorizationCode"), propLpUk.getProperty("ReferenceID"));
				createAuth.click_Save();
				createAuth.authorizationDetailsButton();
				proposedLicense.clickOnProposedLicenseeTab();
				proposedLicense.validateProposedLicenseeTypeIndividualError();
				Wait.waitfor(4);
				homeuk.returnHomepageLP();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homeuk.returnHomepageLP();
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 4)
	public void ProposedLicenseeTypeOrganizationvalidations(Method method) throws Exception {

		HomeLpUKPage homeuk = new HomeLpUKPage(driver, test);
		SearchAuthorizationsPageUK searchAuth = new SearchAuthorizationsPageUK(driver, test);
		CreateNewAuthorizationUKPage createAuth = new CreateNewAuthorizationUKPage(driver, test);
		ProposedLicensesUKPage proposedLicense = new ProposedLicensesUKPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeuk.moveTo_SBUSelection(propLpUk.getProperty("SBU"));
				searchAuth.click_AddAuthorization();
				createAuth.headerDetails(propLpUk.getProperty("AuthGrantByCountry"),
						propLpUk.getProperty("AuthorizationCode"), propLpUk.getProperty("ReferenceID"));
				createAuth.click_Save();
				createAuth.authorizationDetailsButton();
				proposedLicense.clickOnProposedLicenseeTab();
				proposedLicense.validateProposedLicenseeTypeOrganizationError();
				Wait.waitfor(4);
				homeuk.returnHomepageLP();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homeuk.returnHomepageLP();
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 5)
	public void ContactSectionTypeIndividualvalidations(Method method) throws Exception {

		HomeLpUKPage homeuk = new HomeLpUKPage(driver, test);
		SearchAuthorizationsPageUK searchAuth = new SearchAuthorizationsPageUK(driver, test);
		CreateNewAuthorizationUKPage createAuth = new CreateNewAuthorizationUKPage(driver, test);
		ContactSectionUKPage contactSection = new ContactSectionUKPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeuk.moveTo_SBUSelection(propLpUk.getProperty("SBU"));
				searchAuth.click_AddAuthorization();
				createAuth.headerDetails(propLpUk.getProperty("AuthGrantByCountry"),
						propLpUk.getProperty("AuthorizationCode"), propLpUk.getProperty("ReferenceID"));
				createAuth.click_Save();
				createAuth.authorizationDetailsButton();
				contactSection.clickOnContactSectionTab();
				contactSection.validateContactSectionTypeIndividualError();
				Wait.waitfor(4);
				homeuk.returnHomepageLP();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homeuk.returnHomepageLP();
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 6)
	public void ContactSectionTypeOrganizationvalidations(Method method) throws Exception {

		HomeLpUKPage homeuk = new HomeLpUKPage(driver, test);
		SearchAuthorizationsPageUK searchAuth = new SearchAuthorizationsPageUK(driver, test);
		CreateNewAuthorizationUKPage createAuth = new CreateNewAuthorizationUKPage(driver, test);
		ContactSectionUKPage contactSection = new ContactSectionUKPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeuk.moveTo_SBUSelection(propLpUk.getProperty("SBU"));
				searchAuth.click_AddAuthorization();
				createAuth.headerDetails(propLpUk.getProperty("AuthGrantByCountry"),
						propLpUk.getProperty("AuthorizationCode"), propLpUk.getProperty("ReferenceID"));
				createAuth.click_Save();
				createAuth.authorizationDetailsButton();
				contactSection.clickOnContactSectionTab();
				contactSection.validateContactSectionTypeOrganizationError();
				Wait.waitfor(4);
				homeuk.returnHomepageLP();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homeuk.returnHomepageLP();
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 7)
	public void ExportGoodsListvalidations(Method method) throws Exception {

		HomeLpUKPage homeuk = new HomeLpUKPage(driver, test);
		SearchAuthorizationsPageUK searchAuth = new SearchAuthorizationsPageUK(driver, test);
		CreateNewAuthorizationUKPage createAuth = new CreateNewAuthorizationUKPage(driver, test);
		ExportGoodsListUKPage exportList = new ExportGoodsListUKPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeuk.moveTo_SBUSelection(propLpUk.getProperty("SBU"));
				searchAuth.click_AddAuthorization();
				createAuth.headerDetails(propLpUk.getProperty("AuthGrantByCountry"),
						propLpUk.getProperty("AuthorizationCode"), propLpUk.getProperty("ReferenceID"));
				createAuth.click_Save();
				createAuth.authorizationDetailsButton();
				exportList.clickOnExportGoodsListTab();
				exportList.clickItemBtn();
				exportList.validateExportGoodsListError();
				Wait.waitfor(4);
				homeuk.returnHomepageLP();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homeuk.returnHomepageLP();
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 8)
	public void NatureOfGoodsvalidations(Method method) throws Exception {

		HomeLpUKPage homeuk = new HomeLpUKPage(driver, test);
		SearchAuthorizationsPageUK searchAuth = new SearchAuthorizationsPageUK(driver, test);
		CreateNewAuthorizationUKPage createAuth = new CreateNewAuthorizationUKPage(driver, test);
		NatureofGoodsUKPage natureGoods = new NatureofGoodsUKPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeuk.moveTo_SBUSelection(propLpUk.getProperty("SBU"));
				searchAuth.click_AddAuthorization();
				createAuth.headerDetails(propLpUk.getProperty("AuthGrantByCountry"),
						propLpUk.getProperty("AuthorizationCode"), propLpUk.getProperty("ReferenceID"));
				createAuth.click_Save();
				createAuth.authorizationDetailsButton();
				natureGoods.clickOnNatureOfGoodsTab();
				natureGoods.validateNatureofGoodsError();
				Wait.waitfor(4);
				homeuk.returnHomepageLP();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homeuk.returnHomepageLP();
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 9)
	public void GoodsLocationCountryvalidations(Method method) throws Exception {

		HomeLpUKPage homeuk = new HomeLpUKPage(driver, test);
		SearchAuthorizationsPageUK searchAuth = new SearchAuthorizationsPageUK(driver, test);
		CreateNewAuthorizationUKPage createAuth = new CreateNewAuthorizationUKPage(driver, test);
		GoodsLocationUKPage goodsLocation = new GoodsLocationUKPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeuk.moveTo_SBUSelection(propLpUk.getProperty("SBU"));
				searchAuth.click_AddAuthorization();
				createAuth.headerDetails(propLpUk.getProperty("AuthGrantByCountry"),
						propLpUk.getProperty("AuthorizationCode"), propLpUk.getProperty("ReferenceID"));
				createAuth.click_Save();
				createAuth.authorizationDetailsButton();
				goodsLocation.clickGoodsLocationTab();
				goodsLocation.validateGoodsLocationCountryError();
				Wait.waitfor(4);
				homeuk.returnHomepageLP();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homeuk.returnHomepageLP();
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 10)
	public void GoodsLocationTypevalidations(Method method) throws Exception {

		HomeLpUKPage homeuk = new HomeLpUKPage(driver, test);
		SearchAuthorizationsPageUK searchAuth = new SearchAuthorizationsPageUK(driver, test);
		CreateNewAuthorizationUKPage createAuth = new CreateNewAuthorizationUKPage(driver, test);
		GoodsLocationUKPage goodsLocation = new GoodsLocationUKPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeuk.moveTo_SBUSelection(propLpUk.getProperty("SBU"));
				searchAuth.click_AddAuthorization();
				createAuth.headerDetails(propLpUk.getProperty("AuthGrantByCountry"),
						propLpUk.getProperty("AuthorizationCode"), propLpUk.getProperty("ReferenceID"));
				createAuth.click_Save();
				createAuth.authorizationDetailsButton();
				goodsLocation.clickGoodsLocationTab();
				goodsLocation.validateGoodsLocationtTypeError();
				Wait.waitfor(4);
				homeuk.returnHomepageLP();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homeuk.returnHomepageLP();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 11)
	public void GoodsLocationTypeIndividualvalidations(Method method) throws Exception {

		HomeLpUKPage homeuk = new HomeLpUKPage(driver, test);
		SearchAuthorizationsPageUK searchAuth = new SearchAuthorizationsPageUK(driver, test);
		CreateNewAuthorizationUKPage createAuth = new CreateNewAuthorizationUKPage(driver, test);
		GoodsLocationUKPage goodsLocation = new GoodsLocationUKPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeuk.moveTo_SBUSelection(propLpUk.getProperty("SBU"));
				searchAuth.click_AddAuthorization();
				createAuth.headerDetails(propLpUk.getProperty("AuthGrantByCountry"),
						propLpUk.getProperty("AuthorizationCode"), propLpUk.getProperty("ReferenceID"));
				createAuth.click_Save();
				createAuth.authorizationDetailsButton();
				goodsLocation.clickGoodsLocationTab();
				goodsLocation.validateGoodsLocationTypeIndividualError();
				Wait.waitfor(4);
				homeuk.returnHomepageLP();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homeuk.returnHomepageLP();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 12)
	public void GoodsLocationTypeOrganizationvalidations(Method method) throws Exception {

		HomeLpUKPage homeuk = new HomeLpUKPage(driver, test);
		SearchAuthorizationsPageUK searchAuth = new SearchAuthorizationsPageUK(driver, test);
		CreateNewAuthorizationUKPage createAuth = new CreateNewAuthorizationUKPage(driver, test);
		GoodsLocationUKPage goodsLocation = new GoodsLocationUKPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeuk.moveTo_SBUSelection(propLpUk.getProperty("SBU"));
				searchAuth.click_AddAuthorization();
				createAuth.headerDetails(propLpUk.getProperty("AuthGrantByCountry"),
						propLpUk.getProperty("AuthorizationCode"), propLpUk.getProperty("ReferenceID"));
				createAuth.click_Save();
				createAuth.authorizationDetailsButton();
				goodsLocation.clickGoodsLocationTab();
				goodsLocation.validateGoodsLocationTypeOrganizationError();
				Wait.waitfor(4);
				homeuk.returnHomepageLP();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homeuk.returnHomepageLP();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 13)
	public void GoodsRecepientTypevalidations(Method method) throws Exception {

		HomeLpUKPage homeuk = new HomeLpUKPage(driver, test);
		SearchAuthorizationsPageUK searchAuth = new SearchAuthorizationsPageUK(driver, test);
		CreateNewAuthorizationUKPage createAuth = new CreateNewAuthorizationUKPage(driver, test);
		GoodsRecipientUKPage goodsrecipient = new GoodsRecipientUKPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeuk.moveTo_SBUSelection(propLpUk.getProperty("SBU"));
				searchAuth.click_AddAuthorization();
				createAuth.headerDetails(propLpUk.getProperty("AuthGrantByCountry"),
						propLpUk.getProperty("AuthorizationCode"), propLpUk.getProperty("ReferenceID"));
				createAuth.click_Save();
				createAuth.authorizationDetailsButton();
				goodsrecipient.clickOnGoodsRecipientTab();
				goodsrecipient.clickOnAddGoodsRecipient();
				goodsrecipient.clickOnSaveReturn();
				goodsrecipient.validateGoodsRecepientTypeError();
				Wait.waitfor(4);
				homeuk.returnHomepageLP();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homeuk.returnHomepageLP();
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 14)
	public void GoodsRecepientTypeIndividualvalidations(Method method) throws Exception {

		HomeLpUKPage homeuk = new HomeLpUKPage(driver, test);
		SearchAuthorizationsPageUK searchAuth = new SearchAuthorizationsPageUK(driver, test);
		CreateNewAuthorizationUKPage createAuth = new CreateNewAuthorizationUKPage(driver, test);
		GoodsRecipientUKPage goodsrecipient = new GoodsRecipientUKPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeuk.moveTo_SBUSelection(propLpUk.getProperty("SBU"));
				searchAuth.click_AddAuthorization();
				createAuth.headerDetails(propLpUk.getProperty("AuthGrantByCountry"),
						propLpUk.getProperty("AuthorizationCode"), propLpUk.getProperty("ReferenceID"));
				createAuth.click_Save();
				createAuth.authorizationDetailsButton();
				goodsrecipient.clickOnGoodsRecipientTab();
				goodsrecipient.clickOnAddGoodsRecipient();
				Wait.waitfor(3);
				goodsrecipient.validateGoodsRecepientTypeIndividualError();
				Wait.waitfor(4);
				homeuk.returnHomepageLP();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homeuk.returnHomepageLP();
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 15)
	public void GoodsRecepientTypeOrganizationvalidations(Method method) throws Exception {

		HomeLpUKPage homeuk = new HomeLpUKPage(driver, test);
		SearchAuthorizationsPageUK searchAuth = new SearchAuthorizationsPageUK(driver, test);
		CreateNewAuthorizationUKPage createAuth = new CreateNewAuthorizationUKPage(driver, test);
		GoodsRecipientUKPage goodsrecipient = new GoodsRecipientUKPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeuk.moveTo_SBUSelection(propLpUk.getProperty("SBU"));
				searchAuth.click_AddAuthorization();
				createAuth.headerDetails(propLpUk.getProperty("AuthGrantByCountry"),
						propLpUk.getProperty("AuthorizationCode"), propLpUk.getProperty("ReferenceID"));
				createAuth.click_Save();
				createAuth.authorizationDetailsButton();
				goodsrecipient.clickOnGoodsRecipientTab();
				goodsrecipient.clickOnAddGoodsRecipient();
				goodsrecipient.validateGoodsRecepientTypeOrganizationError();
				Wait.waitfor(4);
				homeuk.returnHomepageLP();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homeuk.returnHomepageLP();
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 16)
	public void UltimateEnduserTypevalidations(Method method) throws Exception {

		HomeLpUKPage homeuk = new HomeLpUKPage(driver, test);
		SearchAuthorizationsPageUK searchAuth = new SearchAuthorizationsPageUK(driver, test);
		CreateNewAuthorizationUKPage createAuth = new CreateNewAuthorizationUKPage(driver, test);
		UltimateEndUserUKPage ultimateenduser = new UltimateEndUserUKPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeuk.moveTo_SBUSelection(propLpUk.getProperty("SBU"));
				searchAuth.click_AddAuthorization();
				createAuth.headerDetails(propLpUk.getProperty("AuthGrantByCountry"),
						propLpUk.getProperty("AuthorizationCode"), propLpUk.getProperty("ReferenceID"));
				createAuth.click_Save();
				createAuth.authorizationDetailsButton();
				ultimateenduser.clickOnUltimateEndUsersTab();
				ultimateenduser.addUltimateEndUSer();
				ultimateenduser.clickOnSaveReturn();
				ultimateenduser.validateUltimateEndUsersTypeError();
				Wait.waitfor(4);
				homeuk.returnHomepageLP();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homeuk.returnHomepageLP();
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 17)
	public void UltimateEnduserTypeIndividualvalidations(Method method) throws Exception {

		HomeLpUKPage homeuk = new HomeLpUKPage(driver, test);
		SearchAuthorizationsPageUK searchAuth = new SearchAuthorizationsPageUK(driver, test);
		CreateNewAuthorizationUKPage createAuth = new CreateNewAuthorizationUKPage(driver, test);
		UltimateEndUserUKPage ultimateenduser = new UltimateEndUserUKPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeuk.moveTo_SBUSelection(propLpUk.getProperty("SBU"));
				searchAuth.click_AddAuthorization();
				createAuth.headerDetails(propLpUk.getProperty("AuthGrantByCountry"),
						propLpUk.getProperty("AuthorizationCode"), propLpUk.getProperty("ReferenceID"));
				createAuth.click_Save();
				createAuth.authorizationDetailsButton();
				ultimateenduser.clickOnUltimateEndUsersTab();
				ultimateenduser.addUltimateEndUSer();
				ultimateenduser.validateUltimateEndUsersIndividualError();
				Wait.waitfor(4);
				homeuk.returnHomepageLP();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homeuk.returnHomepageLP();
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 18)
	public void UltimateEnduserTypeOrganizationvalidations(Method method) throws Exception {

		HomeLpUKPage homeuk = new HomeLpUKPage(driver, test);
		SearchAuthorizationsPageUK searchAuth = new SearchAuthorizationsPageUK(driver, test);
		CreateNewAuthorizationUKPage createAuth = new CreateNewAuthorizationUKPage(driver, test);
		UltimateEndUserUKPage ultimateenduser = new UltimateEndUserUKPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeuk.moveTo_SBUSelection(propLpUk.getProperty("SBU"));
				searchAuth.click_AddAuthorization();
				createAuth.headerDetails(propLpUk.getProperty("AuthGrantByCountry"),
						propLpUk.getProperty("AuthorizationCode"), propLpUk.getProperty("ReferenceID"));
				createAuth.click_Save();
				createAuth.authorizationDetailsButton();
				ultimateenduser.clickOnUltimateEndUsersTab();
				ultimateenduser.addUltimateEndUSer();
				ultimateenduser.validateUltimateEndUsersOrganizationError();
				Wait.waitfor(4);
				homeuk.returnHomepageLP();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homeuk.returnHomepageLP();
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 19)
	public void RouteOfGoodsvalidations(Method method) throws Exception {

		HomeLpUKPage homeuk = new HomeLpUKPage(driver, test);
		SearchAuthorizationsPageUK searchAuth = new SearchAuthorizationsPageUK(driver, test);
		CreateNewAuthorizationUKPage createAuth = new CreateNewAuthorizationUKPage(driver, test);
		RouteOfGoodsUKPage routegoods = new RouteOfGoodsUKPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeuk.moveTo_SBUSelection(propLpUk.getProperty("SBU"));
				searchAuth.click_AddAuthorization();
				createAuth.headerDetails(propLpUk.getProperty("AuthGrantByCountry"),
						propLpUk.getProperty("AuthorizationCode"), propLpUk.getProperty("ReferenceID"));
				createAuth.click_Save();
				createAuth.authorizationDetailsButton();
				routegoods.clickOnRouteOfGoodsTab();
				routegoods.clicksavebtn();
				routegoods.validateRouteOfGoodsError();
				Wait.waitfor(4);
				homeuk.returnHomepageLP();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homeuk.returnHomepageLP();
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 20)
	public void OtherThirdPartyTypevalidations(Method method) throws Exception {

		HomeLpUKPage homeuk = new HomeLpUKPage(driver, test);
		SearchAuthorizationsPageUK searchAuth = new SearchAuthorizationsPageUK(driver, test);
		CreateNewAuthorizationUKPage createAuth = new CreateNewAuthorizationUKPage(driver, test);
		OtherThirdPartyDocumentsUKPage otherthirdparty = new OtherThirdPartyDocumentsUKPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeuk.moveTo_SBUSelection(propLpUk.getProperty("SBU"));
				searchAuth.click_AddAuthorization();
				createAuth.headerDetails(propLpUk.getProperty("AuthGrantByCountry"),
						propLpUk.getProperty("AuthorizationCode"), propLpUk.getProperty("ReferenceID"));
				createAuth.click_Save();
				createAuth.authorizationDetailsButton();
				otherthirdparty.clickOnOtherThirdPartyTab();
				otherthirdparty.clickonotherthirdparty();
				otherthirdparty.click_SaveAndReturn();
				otherthirdparty.validateOtherThirdPartyTypeError();
				Wait.waitfor(4);
				homeuk.returnHomepageLP();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homeuk.returnHomepageLP();
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 21)
	public void OtherThirdPartyTypeIndividualvalidations(Method method) throws Exception {

		HomeLpUKPage homeuk = new HomeLpUKPage(driver, test);
		SearchAuthorizationsPageUK searchAuth = new SearchAuthorizationsPageUK(driver, test);
		CreateNewAuthorizationUKPage createAuth = new CreateNewAuthorizationUKPage(driver, test);
		OtherThirdPartyDocumentsUKPage otherthirdparty = new OtherThirdPartyDocumentsUKPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeuk.moveTo_SBUSelection(propLpUk.getProperty("SBU"));
				searchAuth.click_AddAuthorization();
				createAuth.headerDetails(propLpUk.getProperty("AuthGrantByCountry"),
						propLpUk.getProperty("AuthorizationCode"), propLpUk.getProperty("ReferenceID"));
				createAuth.click_Save();
				createAuth.authorizationDetailsButton();
				otherthirdparty.clickOnOtherThirdPartyTab();
				otherthirdparty.clickonotherthirdparty();
				otherthirdparty.validateOtherThirdPartyIndividualError();
				Wait.waitfor(4);
				homeuk.returnHomepageLP();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homeuk.returnHomepageLP();
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 22)
	public void OtherThirdPartyTypeOrganizationvalidations(Method method) throws Exception {

		HomeLpUKPage homeuk = new HomeLpUKPage(driver, test);
		SearchAuthorizationsPageUK searchAuth = new SearchAuthorizationsPageUK(driver, test);
		CreateNewAuthorizationUKPage createAuth = new CreateNewAuthorizationUKPage(driver, test);
		OtherThirdPartyDocumentsUKPage otherthirdparty = new OtherThirdPartyDocumentsUKPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeuk.moveTo_SBUSelection(propLpUk.getProperty("SBU"));
				searchAuth.click_AddAuthorization();
				createAuth.headerDetails(propLpUk.getProperty("AuthGrantByCountry"),
						propLpUk.getProperty("AuthorizationCode"), propLpUk.getProperty("ReferenceID"));
				createAuth.click_Save();
				createAuth.authorizationDetailsButton();
				otherthirdparty.clickOnOtherThirdPartyTab();
				otherthirdparty.clickonotherthirdparty();
				otherthirdparty.validateOtherThirdPartyOrganizationError();
				Wait.waitfor(4);
				homeuk.returnHomepageLP();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homeuk.returnHomepageLP();
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 23)
	public void SupportingDocumentsvalidations(Method method) throws Exception {

		HomeLpUKPage homeuk = new HomeLpUKPage(driver, test);
		SearchAuthorizationsPageUK searchAuth = new SearchAuthorizationsPageUK(driver, test);
		CreateNewAuthorizationUKPage createAuth = new CreateNewAuthorizationUKPage(driver, test);
		SupportingDocumentsUKPage supportDoc = new SupportingDocumentsUKPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeuk.moveTo_SBUSelection(propLpUk.getProperty("SBU"));
				searchAuth.click_AddAuthorization();
				createAuth.headerDetails(propLpUk.getProperty("AuthGrantByCountry"),
						propLpUk.getProperty("AuthorizationCode"), propLpUk.getProperty("ReferenceID"));
				createAuth.click_Save();
				createAuth.authorizationDetailsButton();
				supportDoc.clickOnSupportingDocTab();
				supportDoc.validateSupportingDocumentsError();
				Wait.waitfor(4);
				homeuk.returnHomepageLP();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homeuk.returnHomepageLP();
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 24)
	public void SupportingDocCreateNewAttachmentvalidations(Method method) throws Exception {

		HomeLpUKPage homeuk = new HomeLpUKPage(driver, test);
		SearchAuthorizationsPageUK searchAuth = new SearchAuthorizationsPageUK(driver, test);
		CreateNewAuthorizationUKPage createAuth = new CreateNewAuthorizationUKPage(driver, test);
		SupportingDocumentsUKPage supportDoc = new SupportingDocumentsUKPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeuk.moveTo_SBUSelection(propLpUk.getProperty("SBU"));
				searchAuth.click_AddAuthorization();
				createAuth.headerDetails(propLpUk.getProperty("AuthGrantByCountry"),
						propLpUk.getProperty("AuthorizationCode"), propLpUk.getProperty("ReferenceID"));
				createAuth.click_Save();
				createAuth.authorizationDetailsButton();
				supportDoc.clickOnSupportingDocTab();
				supportDoc.addsupportingdocument();
				supportDoc.validateCreateNewAttachmentError();
				Wait.waitfor(4);
				homeuk.returnHomepageLP();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homeuk.returnHomepageLP();
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 25)
	public void Declarationvalidations(Method method) throws Exception {

		HomeLpUKPage homeuk = new HomeLpUKPage(driver, test);
		SearchAuthorizationsPageUK searchAuth = new SearchAuthorizationsPageUK(driver, test);
		CreateNewAuthorizationUKPage createAuth = new CreateNewAuthorizationUKPage(driver, test);
		DeclarationUKPage declaration = new DeclarationUKPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeuk.moveTo_SBUSelection(propLpUk.getProperty("SBU"));
				searchAuth.click_AddAuthorization();
				createAuth.headerDetails(propLpUk.getProperty("AuthGrantByCountry"),
						propLpUk.getProperty("AuthorizationCode"), propLpUk.getProperty("ReferenceID"));
				createAuth.click_Save();
				createAuth.authorizationDetailsButton();
				declaration.clickOnDeclarationTab();
				declaration.validateDeclarationError();
				Wait.waitfor(4);
				homeuk.returnHomepageLP();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homeuk.returnHomepageLP();
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 26)
	public void Formvalidations(Method method) throws Exception {

		HomeLpUKPage homeuk = new HomeLpUKPage(driver, test);
		SearchAuthorizationsPageUK searchAuth = new SearchAuthorizationsPageUK(driver, test);
		CreateNewAuthorizationUKPage createAuth = new CreateNewAuthorizationUKPage(driver, test);
		FormValidationsUKPage formValidation = new FormValidationsUKPage(driver, test);
		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeuk.moveTo_SBUSelection(propLpUk.getProperty("SBU"));
				searchAuth.click_AddAuthorization();
				createAuth.headerDetails(propLpUk.getProperty("AuthGrantByCountry"),
						propLpUk.getProperty("AuthorizationCode"), propLpUk.getProperty("ReferenceID"));
				createAuth.click_Save();
				createAuth.authorizationDetailsButton();
				formValidation.clickOnFormValidationsTab();
				formValidation.clickOnDescriptionLink();
				formValidation.validateFormValidationError();
				Wait.waitfor(4);
				homeuk.returnHomepageLP();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homeuk.returnHomepageLP();
			Assert.assertTrue(false);
		}

	}

}
