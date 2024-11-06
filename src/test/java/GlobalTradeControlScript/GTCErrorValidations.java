package GlobalTradeControlScript;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import globalTradeControlClasses.GtcHomePage;
import globalTradeControlClasses.GtcNewScreeningPage;
import globalTradeControlClasses.ScreenPage;
import globalTradeControlClasses.SearchTradeControlScreeningPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class GTCErrorValidations extends SeleniumTestBase {

	// Error validations for create New GTC Header Details
	@Test(priority = 1)
	public void newTradeControlScreeningValidations(Method method) throws Exception {

		GtcNewScreeningPage newscreen = new GtcNewScreeningPage(driver, test);
		GtcHomePage gtchome = new GtcHomePage(driver, test);
		SearchTradeControlScreeningPage gtcsearch = new SearchTradeControlScreeningPage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				gtchome.moveTo_GtcListScreening();
				gtchome.clickTo_TradeControlsScreening();
				gtcsearch.click_GtcNewScreening();
				newscreen.saveNewScreening();
				newscreen.validateHeaderDetailsError();
				gtchome.GtcreturnPage();
				Wait.waitfor(4);
			}
		} catch (SkipException s) {
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			gtchome.GtcreturnPage();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 2)
	public void Entitydetailsvalidations(Method method) throws Exception {

		GtcNewScreeningPage newscreen = new GtcNewScreeningPage(driver, test);
		GtcHomePage gtchome = new GtcHomePage(driver, test);
		SearchTradeControlScreeningPage gtcsearch = new SearchTradeControlScreeningPage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				gtchome.moveTo_GtcListScreening();
				gtchome.clickTo_TradeControlsScreening();
				gtcsearch.click_GtcNewScreening();
				newscreen.headerDetails("", propGTC.getProperty("ExportCountry"), propGTC.getProperty("ImportCountry"),
						"Watch-List Screening","UNITED STATES");
				Wait.waitfor(3);
				newscreen.saveNewScreening();
				newscreen.entitydetailsvalidation();
				Wait.waitfor(3);
				gtchome.GtcreturnPage();
				Wait.waitfor(2);
			}
		} catch (SkipException s) {
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			gtchome.GtcreturnPage();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 3)
	public void EntitydetailsNamevalidations(Method method) throws Exception {

		GtcNewScreeningPage newscreen = new GtcNewScreeningPage(driver, test);
		GtcHomePage gtchome = new GtcHomePage(driver, test);
		SearchTradeControlScreeningPage gtcsearch = new SearchTradeControlScreeningPage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				gtchome.moveTo_GtcListScreening();
				gtchome.clickTo_TradeControlsScreening();
				gtcsearch.click_GtcNewScreening();
				newscreen.headerDetails("", propGTC.getProperty("ExportCountry"), propGTC.getProperty("ImportCountry"),
						"Watch-List Screening","UNITED STATES");
				newscreen.saveNewScreening();
				newscreen.entitydetailsvalidation();
				Wait.waitfor(3);
				newscreen.entityDetails("", "no", "", "", "", "", propGTC.getProperty("EntityRole"), "", "", "", "",
						"");
				newscreen.entitydetailsNamevalidation();
				gtchome.GtcreturnPage();
				Wait.waitfor(4);
			}
		} catch (SkipException s) {
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			gtchome.GtcreturnPage();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 4)
	public void EntitydetailsEntityRolevalidations(Method method) throws Exception {

		GtcNewScreeningPage newscreen = new GtcNewScreeningPage(driver, test);
		GtcHomePage gtchome = new GtcHomePage(driver, test);
		SearchTradeControlScreeningPage gtcsearch = new SearchTradeControlScreeningPage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				gtchome.moveTo_GtcListScreening();
				gtchome.clickTo_TradeControlsScreening();
				gtcsearch.click_GtcNewScreening();
				newscreen.headerDetails("", propGTC.getProperty("ExportCountry"), propGTC.getProperty("ImportCountry"),
						"Watch-List Screening","UNITED STATES");
				Wait.waitfor(3);
				newscreen.entityDetails(propGTC.getProperty("SourceFile"), propGTC.getProperty("ConsigneeId"), "", "",
						"", "", "", "", "", "", "", "");
				newscreen.entitydetailsEntityRolevalidation();
				Wait.waitfor(2);
				gtchome.GtcreturnPage();
				Wait.waitfor(4);
			}
		} catch (SkipException s) {
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			gtchome.GtcreturnPage();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 5)
	public void Itemdetailsvalidations(Method method) throws Exception {

		GtcNewScreeningPage newscreen = new GtcNewScreeningPage(driver, test);
		GtcHomePage gtchome = new GtcHomePage(driver, test);
		SearchTradeControlScreeningPage gtcsearch = new SearchTradeControlScreeningPage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				gtchome.moveTo_GtcListScreening();
				gtchome.clickTo_TradeControlsScreening();
				gtcsearch.click_GtcNewScreening();
				newscreen.headerDetails("", propGTC.getProperty("ExportCountry"), propGTC.getProperty("ImportCountry"),
						"Export License Screening","UNITED STATES");
				Wait.waitfor(3);
				newscreen.entityDetails(propGTC.getProperty("SourceFile"), propGTC.getProperty("ConsigneeId"),
						propGTC.getProperty("EntityName"), "", "", "", propGTC.getProperty("EntityRole"), "", "", "",
						"", propGTC.getProperty("EntityStatus"));
				Wait.waitfor(2);
				newscreen.click_screenbtn();
				newscreen.itemdetailsvalidation();
				gtchome.GtcreturnPage();
				Wait.waitfor(4);
			}
		} catch (SkipException s) {
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			gtchome.GtcreturnPage();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 6)
	public void Itemdetailsclassificationvalidations(Method method) throws Exception {

		GtcNewScreeningPage newscreen = new GtcNewScreeningPage(driver, test);
		GtcHomePage gtchome = new GtcHomePage(driver, test);
		SearchTradeControlScreeningPage gtcsearch = new SearchTradeControlScreeningPage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				gtchome.moveTo_GtcListScreening();
				gtchome.clickTo_TradeControlsScreening();
				gtcsearch.click_GtcNewScreening();
				newscreen.headerDetails("", propGTC.getProperty("ExportCountry"), propGTC.getProperty("ImportCountry"),
						"Export License Screening","UNITED STATES");
				Wait.waitfor(3);
				newscreen.entityDetails(propGTC.getProperty("SourceFile"), propGTC.getProperty("ConsigneeId"),
						propGTC.getProperty("EntityName"), "", "", "", propGTC.getProperty("EntityRole"), "", "", "",
						"", propGTC.getProperty("EntityStatus"));
				Wait.waitfor(3);
				newscreen.click_addItembutton();
				newscreen.itemclassificationvalidation();
				gtchome.GtcreturnPage();
				Wait.waitfor(4);
			}
		} catch (SkipException s) {
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			gtchome.GtcreturnPage();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 7)
	public void TakeOwnershipValidation(Method method) throws Exception {

		GtcNewScreeningPage newscreen = new GtcNewScreeningPage(driver, test);
		GtcHomePage gtchome = new GtcHomePage(driver, test);
		SearchTradeControlScreeningPage gtcsearch = new SearchTradeControlScreeningPage(driver, test);
		ScreenPage screen = new ScreenPage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				gtchome.moveTo_GtcListScreening();
				gtchome.clickTo_TradeControlsScreening();
				gtcsearch.click_GtcNewScreening();
				newscreen.headerDetails("", propGTC.getProperty("ExportCountry"), propGTC.getProperty("ImportCountry"),
						"Export License Screening","UNITED STATES");
				Wait.waitfor(3);
				newscreen.entityDetails(propGTC.getProperty("SourceFile"), propGTC.getProperty("ConsigneeId"),
						propGTC.getProperty("EntityName"), "", "", "", propGTC.getProperty("EntityRole"), "", "", "",
						"", propGTC.getProperty("EntityStatus"));
				Wait.waitfor(3);
				newscreen.itemDetails("", propGTC.getProperty("ECCNumber"), propGTC.getProperty("ClassificationItem"),
						"", "", "", "", "", "", "", "", "");
				newscreen.click_addItembutton();
				newscreen.click_screenbtn();
				Wait.waitfor(2);
				screen.takeOwnershipValidation();
				gtchome.GtcreturnPage();
				Wait.waitfor(4);
			}
		} catch (SkipException s) {
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			gtchome.GtcreturnPage();
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 8)
	public void EntityscreeningValidation(Method method) throws Exception {

		GtcNewScreeningPage newscreen = new GtcNewScreeningPage(driver, test);
		GtcHomePage gtchome = new GtcHomePage(driver, test);
		SearchTradeControlScreeningPage gtcsearch = new SearchTradeControlScreeningPage(driver, test);
		ScreenPage screen = new ScreenPage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				gtchome.moveTo_GtcListScreening();
				gtchome.clickTo_TradeControlsScreening();
				gtcsearch.click_GtcNewScreening();
				newscreen.headerDetails("", propGTC.getProperty("ExportCountry"), propGTC.getProperty("ImportCountry"),
						"Export License Screening","UNITED STATES");
				Wait.waitfor(3);
				newscreen.entityDetails(propGTC.getProperty("SourceFile"), propGTC.getProperty("ConsigneeId"),
						propGTC.getProperty("EntityName"), "", "", "", propGTC.getProperty("EntityRole"), "", "", "",
						"", propGTC.getProperty("EntityStatus"));
				Wait.waitfor(3);
				newscreen.itemDetails("", propGTC.getProperty("ECCNumber"), propGTC.getProperty("ClassificationItem"),
						"", "", "", "", "", "", "", "", "");
				newscreen.click_addItembutton();
				newscreen.click_screenbtn();
				screen.click_ReviewerComments();
				screen.click_GtcTradeControlDecision();
				screen.click_GtcEntityScreening();
				screen.click_OverrideButton();
				screen.entityscreeningValidation();
				gtchome.GtcreturnPage();
				Wait.waitfor(4);
			}
		} catch (SkipException s) {
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			gtchome.GtcreturnPage();
			Assert.assertTrue(false);
		}
	}

	/*
	 * @Test(priority = 9) public void ExportlicensescreeningValidation(Method
	 * method) throws Exception {
	 * 
	 * GtcNewScreeningPage newscreen = new GtcNewScreeningPage(driver, test);
	 * GtcHomePage gtchome = new GtcHomePage(driver, test);
	 * SearchTradeControlScreeningPage gtcsearch = new
	 * SearchTradeControlScreeningPage(driver, test); ScreenPage screen = new
	 * ScreenPage(driver, test);
	 * 
	 * try { if (!Utility.isExecutable(method.getName(), excel)) { throw new
	 * SkipException("Skipping the test"); } else {
	 * gtchome.moveTo_GtcListScreening(); gtchome.clickTo_TradeControlsScreening();
	 * gtcsearch.click_GtcNewScreening(); newscreen.headerDetails("",
	 * propGTC.getProperty("ExportCountry"), propGTC.getProperty("ImportCountry"),
	 * "Export License Screening"); Wait.waitfor(3);
	 * newscreen.entityDetails(propGTC.getProperty("SourceFile"),
	 * propGTC.getProperty("ConsigneeId"), propGTC.getProperty("EntityName"), "",
	 * "", "", propGTC.getProperty("EntityRole"), "", "", "", "", "");
	 * Wait.waitfor(3); newscreen.itemDetails("", propGTC.getProperty("ECCNumber"),
	 * propGTC.getProperty("ClassificationItem"), "", "", "", "", "", "", "", "",
	 * ""); newscreen.click_addItembutton(); newscreen.click_screenbtn();
	 * screen.click_ReviewerComments(); screen.click_GtcTradeControlDecision();
	 * screen.click_GtcExportLicenseScreening();
	 * screen.click_GtcExportLicenseScreeningSubmit();
	 * screen.exportlicensescreeningValidation(); gtchome.GtcreturnPage();
	 * Wait.waitfor(4); } } catch (SkipException s) { test.log(LogStatus.SKIP,
	 * "Please check the run mode"); throw s; } catch (Exception e) { testFail();
	 * e.printStackTrace(); gtchome.GtcreturnPage(); Assert.assertTrue(false); } }
	 */

	@Test(priority = 10)
	public void ImportlicensescreeningValidation(Method method) throws Exception {

		GtcNewScreeningPage newscreen = new GtcNewScreeningPage(driver, test);
		GtcHomePage gtchome = new GtcHomePage(driver, test);
		SearchTradeControlScreeningPage gtcsearch = new SearchTradeControlScreeningPage(driver, test);
		ScreenPage screen = new ScreenPage(driver, test);

		try {
			if (!Utility.isExecutable(method.getName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				gtchome.moveTo_GtcListScreening();
				gtchome.clickTo_TradeControlsScreening();
				gtcsearch.click_GtcNewScreening();
				newscreen.headerDetails("", propGTC.getProperty("ExportCountry"), propGTC.getProperty("ImportCountry"),
						"Export License Screening","UNITED STATES");
				Wait.waitfor(3);
				newscreen.entityDetails(propGTC.getProperty("SourceFile"), propGTC.getProperty("ConsigneeId"),
						propGTC.getProperty("EntityName"), "", "", "", propGTC.getProperty("EntityRole"), "", "", "",
						"", propGTC.getProperty("EntityStatus"));
				Wait.waitfor(3);
				newscreen.itemDetails("", propGTC.getProperty("ECCNumber"), propGTC.getProperty("ClassificationItem"),
						"", "", "", "", "", "", "", "", "");
				newscreen.click_addItembutton();
				newscreen.click_screenbtn();
				screen.click_ReviewerComments();
				screen.click_GtcTradeControlDecision();
				screen.click_GtcImportControlScreening();
				screen.click_GtcImportControlSave();
				screen.importlicensescreeningValidation();
				gtchome.GtcreturnPage();
				Wait.waitfor(4);
			}
		} catch (SkipException s) {
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			gtchome.GtcreturnPage();
			Assert.assertTrue(false);
		}
	}

}
