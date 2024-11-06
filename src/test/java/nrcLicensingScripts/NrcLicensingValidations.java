package nrcLicensingScripts;

import java.lang.reflect.Method;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import initializer.SeleniumTestBase;
import nrcLicensingClasses.CreateForm7GeneralInformationPage;
import nrcLicensingClasses.EditForm7DetailsPage;
import nrcLicensingClasses.HomePageNrcLicense;
import nrcLicensingClasses.ResultExportSupplierPage;
import nrcLicensingClasses.ResultIntermediateForeignConsigneePage;
import nrcLicensingClasses.ResultUltimateForeignConsigneePage;
import utilities.Utility;
import utilities.Wait;

public class NrcLicensingValidations extends SeleniumTestBase {

	// Error validations for create New NRC from7 General Information

	@Test(priority = 1)
	public void validateGeneralInfo(Method method) throws Exception {

		// ***********Objects Creation ********************

		HomePageNrcLicense nrchome = new HomePageNrcLicense(driver, test);
		CreateForm7GeneralInformationPage generalInfo = new CreateForm7GeneralInformationPage(driver, test);

		// ******************** Test steps execution *************

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				nrchome.moveTo_SBUSelection(propNRC.getProperty("SBU"));
				nrchome.click_AddApplication();
				nrchome.clickNew();
				generalInfo.clickSave();
				generalInfo.validateGeneralInfo();
				nrchome.NrcreturnPage();
				Wait.waitfor(3);
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			nrchome.NrcreturnPage();
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 2)
	public void validateAddNote(Method method) throws Exception {

		// ***********Objects Creation ********************

		HomePageNrcLicense nrchome = new HomePageNrcLicense(driver, test);
		CreateForm7GeneralInformationPage generalInfo = new CreateForm7GeneralInformationPage(driver, test);
		EditForm7DetailsPage form7Details = new EditForm7DetailsPage(driver, test);

		// ******************** Test steps execution ************

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				nrchome.moveTo_SBUSelection(propNRC.getProperty("SBU"));
				Wait.waitfor(3);
				nrchome.moveToFeature();
				nrchome.click_AddApplication();
				nrchome.clickNew();
				generalInfo.addFormDetails(propNRC.getProperty("TransactionId"), "", "",
						propNRC.getProperty("TypeofAction"), "", "", "", "", "", "", "");
				Wait.waitfor(3);
				generalInfo.clickSave();
				generalInfo.clickForm7Details();
				form7Details.addNote("");
				form7Details.validateAddNote();
				Wait.waitfor(3);
				nrchome.NrcreturnPage();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			nrchome.NrcreturnPage();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 3)
	public void validateAddAttachments(Method method) throws Exception {

		// ***********Objects Creation ********************

		HomePageNrcLicense nrchome = new HomePageNrcLicense(driver, test);
		CreateForm7GeneralInformationPage generalInfo = new CreateForm7GeneralInformationPage(driver, test);
		EditForm7DetailsPage form7Details = new EditForm7DetailsPage(driver, test);

		// ******************** Test steps execution *************

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				nrchome.moveTo_SBUSelection(propNRC.getProperty("SBU"));
				Wait.waitfor(3);
				nrchome.moveToFeature();
				nrchome.click_AddApplication();
				nrchome.clickNew();
				generalInfo.addFormDetails(propNRC.getProperty("TransactionId"), "", "",
						propNRC.getProperty("TypeofAction"), "", "", "", "", "", "", "");
				Wait.waitfor(3);
				generalInfo.clickSave();
				generalInfo.clickForm7Details();
				form7Details.addAttachments(propNRC.getProperty("Attachments"), "", "");
				form7Details.validateAddAttachment();
				Wait.waitfor(3);
				nrchome.NrcreturnPage();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			nrchome.NrcreturnPage();
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 4)
	public void validatePartyDetails(Method method) throws Exception {

		// ***********Objects Creation ********************

		HomePageNrcLicense nrchome = new HomePageNrcLicense(driver, test);
		CreateForm7GeneralInformationPage generalInfo = new CreateForm7GeneralInformationPage(driver, test);
		EditForm7DetailsPage form7Details = new EditForm7DetailsPage(driver, test);
		ResultExportSupplierPage exportSup = new ResultExportSupplierPage(driver, test);

		// ******************** Test steps execution *************

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				nrchome.moveTo_SBUSelection(propNRC.getProperty("SBU"));
				Wait.waitfor(3);
				nrchome.moveToFeature();
				nrchome.click_AddApplication();
				nrchome.clickNew();
				generalInfo.addFormDetails(propNRC.getProperty("TransactionId"), "", "",
						propNRC.getProperty("TypeofAction"), "", "", "", "", "", "", "");
				Wait.waitfor(3);
				generalInfo.clickSave();
				generalInfo.clickForm7Details();

				form7Details.clickAddParty();
				exportSup.clickAddSupplier();
				exportSup.validatePartyDetailsError();
				Wait.waitfor(3);
				nrchome.NrcreturnPage();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			nrchome.NrcreturnPage();
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 5)
	public void validateIntermediateForeignConsignee(Method method) throws Exception {

		// ***********Objects Creation ********************

		HomePageNrcLicense nrchome = new HomePageNrcLicense(driver, test);
		CreateForm7GeneralInformationPage generalInfo = new CreateForm7GeneralInformationPage(driver, test);
		EditForm7DetailsPage form7Details = new EditForm7DetailsPage(driver, test);
		ResultIntermediateForeignConsigneePage ifc = new ResultIntermediateForeignConsigneePage(driver, test);

		// ******************** Test steps execution *************

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				nrchome.moveTo_SBUSelection(propNRC.getProperty("SBU"));
				Wait.waitfor(3);
				nrchome.moveToFeature();
				nrchome.click_AddApplication();
				nrchome.clickNew();
				generalInfo.addFormDetails(propNRC.getProperty("TransactionId"), "", "",
						propNRC.getProperty("TypeofAction"), "", "", "", "", "", "", "");
				Wait.waitfor(3);
				generalInfo.clickSave();
				generalInfo.clickForm7Details();

				form7Details.clickInterAddConsignee();
				ifc.clickAddInterConsignee();
				ifc.validateIntermediateConsigneeDetailsError();
				Wait.waitfor(3);
				nrchome.NrcreturnPage();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			nrchome.NrcreturnPage();
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 6)
	public void validateUltimateForeignConsignee(Method method) throws Exception {

		// ***********Objects Creation ********************

		HomePageNrcLicense nrchome = new HomePageNrcLicense(driver, test);
		CreateForm7GeneralInformationPage generalInfo = new CreateForm7GeneralInformationPage(driver, test);
		EditForm7DetailsPage form7Details = new EditForm7DetailsPage(driver, test);
		ResultUltimateForeignConsigneePage ufc = new ResultUltimateForeignConsigneePage(driver, test);

		// ******************** Test steps execution *************

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				nrchome.moveTo_SBUSelection(propNRC.getProperty("SBU"));
				Wait.waitfor(3);
				nrchome.moveToFeature();
				nrchome.click_AddApplication();
				nrchome.clickNew();
				generalInfo.addFormDetails(propNRC.getProperty("TransactionId"), "", "",
						propNRC.getProperty("TypeofAction"), "", "", "", "", "", "", "");
				Wait.waitfor(3);
				generalInfo.clickSave();
				generalInfo.clickForm7Details();

				form7Details.clickInterAddConsignee();
				ufc.clickAddUFC();
				ufc.validateUltimateConsigneeDetailsError();
				Wait.waitfor(3);
				nrchome.NrcreturnPage();
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			nrchome.NrcreturnPage();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 7)
	public void validateEditFormComplete(Method method) throws Exception {

		// ***********Objects Creation ********************

		HomePageNrcLicense nrchome = new HomePageNrcLicense(driver, test);
		CreateForm7GeneralInformationPage generalInfo = new CreateForm7GeneralInformationPage(driver, test);
		EditForm7DetailsPage form7Details = new EditForm7DetailsPage(driver, test);

		// ******************** Test steps execution *************

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				nrchome.moveTo_SBUSelection(propNRC.getProperty("SBU"));
				Wait.waitfor(3);
				nrchome.moveToFeature();
				nrchome.click_AddApplication();
				nrchome.clickNew();
				generalInfo.addFormDetails(propNRC.getProperty("TransactionId"), "", "",
						propNRC.getProperty("TypeofAction"), "", "", "", "", "", "", "");
				Wait.waitfor(3);
				generalInfo.clickSave();
				generalInfo.clickForm7Details();
				form7Details.clickComplete();
				form7Details.clickSave();
				form7Details.validateForm7DetailsError();
				nrchome.NrcreturnPage();
				Wait.waitfor(3);
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			nrchome.NrcreturnPage();
			Assert.assertTrue(false);
		}

	}

}