package RegressionTestingEOUSScripts;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : May 2024
 * Descriptions : Add, Search, Edit, Copy and Delete DCS Id 
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

import globalExportClasses.CreateNewDCSPage;
import globalExportClasses.CreateNewOceanContractHeaderPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ListDCSPage;
import globalExportClasses.ResultOceanContractPage;
import globalExportClasses.SearchDCSPage;
import globalExportClasses.SearchOceanContractPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class VerifyAddSearchEditCopyDeleteOfDCSID extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddEditDeleteDCSID", excel);
	}

	@Test(dataProvider = "getData")
	public void searchDCSID(String Testcase, String RunMode, String SBU, String SBUCode, String DCSID, 
			String ExportingCountry, String ImportingCountry)throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchDCSPage searchGC = new SearchDCSPage(driver, test);
		ListDCSPage resultGC = new ListDCSPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.dcs();
					searchGC.searchbyParameters(SBUCode, DCSID, ExportingCountry, ImportingCountry);
					searchGC.search();
					resultGC.titleisDisplayed();
					HGExport.return_ExportHome();
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		} catch (SkipException s) {
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			e.printStackTrace();
			testFail();
			HGExport.return_ExportHome();
			Assert.assertTrue(false);
		}
	}

	@Test(dataProvider = "getData")
	public void addDCSID(String Testcase, String RunMode, String SBU, String DSCID, String ExportingCountry, 
			String ImportingCountry, String Statement)
			throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchDCSPage searchGC = new SearchDCSPage(driver, test);
		ListDCSPage resultGC = new ListDCSPage(driver, test);
		CreateNewDCSPage createGC = new CreateNewDCSPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.dcs();
					searchGC.addDCSID();
					Wait.waitfor(2);
					createGC.titleisDisplayed();
					createGC.addParameters(DSCID, ExportingCountry, ImportingCountry, Statement);
					Wait.waitfor(2);
					String DscId = createGC.getDSCID();
					createGC.saveandReturn();
					Wait.waitfor(2);
					searchGC.DCSID(DscId);
					searchGC.search();
					resultGC.titleisDisplayed();
					HGExport.return_ExportHome();
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		} catch (SkipException s) {
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			e.printStackTrace();
			testFail();
			HGExport.return_ExportHome();
			Assert.assertTrue(false);
		}
	}

	@Test(dataProvider = "getData")
	public void editDCSID(String Testcase, String RunMode, String SBU, String DCSID)
			throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchDCSPage searchGC = new SearchDCSPage(driver, test);
		ListDCSPage resultGC = new ListDCSPage(driver, test);
		CreateNewDCSPage createGC = new CreateNewDCSPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.dcs();
					searchGC.DCSID(DCSID);
					searchGC.search();
					resultGC.clickDCSID(DCSID);
					createGC.DCSIDEdit(DCSID);
					createGC.saveandReturn();
					resultGC.titleisDisplayed();
					HGExport.return_ExportHome();
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		} catch (SkipException s) {
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			e.printStackTrace();
			testFail();
			HGExport.return_ExportHome();
			Assert.assertTrue(false);
		}
	}

	@Test(dataProvider = "getData")
	public void copyDCSID(String Testcase, String RunMode, String SBU, String DCSID)throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchDCSPage searchGC = new SearchDCSPage(driver, test);
		ListDCSPage resultGC = new ListDCSPage(driver, test);
		CreateNewDCSPage createGC = new CreateNewDCSPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.dcs();
					searchGC.DCSID(DCSID);
					searchGC.search();
					resultGC.copyIcon();
					createGC.DCSIDEdit(DCSID);
					createGC.saveandReturn();
					resultGC.newSearch();
					searchGC.DCSID(DCSID);
					resultGC.titleisDisplayed();
					HGExport.return_ExportHome();
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		} catch (SkipException s) {
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			e.printStackTrace();
			testFail();
			HGExport.return_ExportHome();
			Assert.assertTrue(false);
		}
	}

	@Test(dataProvider = "getData")
	public void deleteDCSID(String Testcase, String RunMode, String SBU, String DCSID)throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchDCSPage searchGC = new SearchDCSPage(driver, test);
		ListDCSPage resultGC = new ListDCSPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.dcs();
					searchGC.DCSID(DCSID);
					searchGC.search();
					resultGC.deleteIcon();
					HGExport.return_ExportHome();
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		} catch (SkipException s) {
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			e.printStackTrace();
			testFail();
			HGExport.return_ExportHome();
			Assert.assertTrue(false);
		}
	}

	@Test(dataProvider = "getData")
	public void validateErrorMsgDCSID(String Testcase, String RunMode, String SBU) throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchDCSPage searchGC = new SearchDCSPage(driver, test);
		CreateNewDCSPage createGC = new CreateNewDCSPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.dcs();
					searchGC.addDCSID();
					createGC.save();
					createGC.errorValidation();
					HGExport.return_ExportHome();
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		} catch (SkipException s) {
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			e.printStackTrace();
			testFail();
			HGExport.return_ExportHome();
			Assert.assertTrue(false);
		}
	}
}
