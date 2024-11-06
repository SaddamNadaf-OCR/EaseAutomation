package RegressionTestingEOUSScripts;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : May 2024
 * Descriptions : Add, Search, Edit, Copy and Delete FTA Attribute 
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
import globalExportClasses.CreateNewFTAAttributePage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.SearchFTAAttributePage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class VerifyAddEditCopyDeleteOfFTAAttributes extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddEditDeleteFTAAttributes", excel);
	}

	@Test(dataProvider = "getData")
	public void addFTAAttribute(String Testcase, String RunMode, String SBU, String SBUCode, String sbuCode, String FTAType, 
			String PreferanceCriteria, String Producer, String RegionalValueContent, String FTAtype, String SortBy, 
			String Direction)throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchFTAAttributePage searchFTA = new SearchFTAAttributePage(driver, test);
		CreateNewFTAAttributePage createFTA = new CreateNewFTAAttributePage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.fTAAttributes();
					searchFTA.addAttribute();
					createFTA.addParameters(SBUCode, FTAType, PreferanceCriteria, Producer, RegionalValueContent);
					createFTA.saveandReturn();
					HGExport.return_ExportHome();
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
			e.printStackTrace();
			testFail();
			HGExport.return_ExportHome();
			Assert.assertTrue(false);
		}
	}
	
	@Test(dataProvider = "getData")
	public void searchFTAAttibutes(String Testcase, String RunMode, String SBU, String SBUCode, String sbuCode, String FTAType, 
			String PreferanceCriteria, String Producer, String RegionalValueContent, String FTAtype, String SortBy, 
			String Direction)throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchFTAAttributePage searchFTA = new SearchFTAAttributePage(driver, test);
		CreateNewFTAAttributePage createFTA = new CreateNewFTAAttributePage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.fTAAttributes();
					searchFTA.searchbyParameters(sbuCode, FTAType, SortBy, Direction);
					searchFTA.search();
					createFTA.titleisDisplayed();
					HGExport.return_ExportHome();
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
			e.printStackTrace();
			testFail();
			HGExport.return_ExportHome();
			Assert.assertTrue(false);
		}
	}
	
	@Test(dataProvider = "getData")
	public void editFTAAttibutes(String Testcase, String RunMode, String SBU, String SBUCode, String sbuCode, String FTAType, 
			String PreferanceCriteria, String Producer, String RegionalValueContent, String FTAtype, String SortBy, 
			String Direction)throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchFTAAttributePage searchFTA = new SearchFTAAttributePage(driver, test);
		CreateNewFTAAttributePage createFTA = new CreateNewFTAAttributePage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.fTAAttributes();
					searchFTA.selectSBU(sbuCode);
					searchFTA.search();
					createFTA.open_FTAAttribute();
					createFTA.edit(SBUCode, FTAType);
					createFTA.saveandReturn();
					HGExport.return_ExportHome();
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
			e.printStackTrace();
			testFail();
			HGExport.return_ExportHome();
			Assert.assertTrue(false);
		}
	}
	
	@Test(dataProvider = "getData")
	public void copyFTAAttibutes(String Testcase, String RunMode, String SBU, String SBUCode, String sbuCode, String FTAType, 
			String PreferanceCriteria, String Producer, String RegionalValueContent, String FTAtype, 
			String SortBy, String Direction)throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchFTAAttributePage searchFTA = new SearchFTAAttributePage(driver, test);
		CreateNewFTAAttributePage createFTA = new CreateNewFTAAttributePage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.fTAAttributes();
					searchFTA.selectSBU(sbuCode);
					searchFTA.search();
					searchFTA.copyIcon();
					createFTA.saveandReturn();
					HGExport.return_ExportHome();
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
			e.printStackTrace();
			testFail();
			HGExport.return_ExportHome();
			Assert.assertTrue(false);
		}
	}
	
	@Test(dataProvider = "getData")
	public void deleteFTAAttibutes(String Testcase, String RunMode, String SBU, String SBUCode, String sbuCode, String FTAType, 
			String PreferanceCriteria, String Producer, String RegionalValueContent, String FTAtype, 
			String SortBy, String Direction)throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchFTAAttributePage searchFTA = new SearchFTAAttributePage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.fTAAttributes();
					searchFTA.selectSBU(sbuCode);
					searchFTA.search();
					searchFTA.deleteIcon();
					HGExport.return_ExportHome();
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
			e.printStackTrace();
			testFail();
			HGExport.return_ExportHome();
			Assert.assertTrue(false);
		}
	}
	
	@Test(dataProvider = "getData")
	public void validateErrorMsgFTAAttribute(String Testcase, String RunMode, String SBU, String SBUCode, String sbuCode, String FTAType, 
			String PreferanceCriteria, String Producer, String RegionalValueContent, String FTAtype, String SortBy, 
			String Direction)throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchFTAAttributePage searchFTA = new SearchFTAAttributePage(driver, test);
		CreateNewFTAAttributePage createFTA = new CreateNewFTAAttributePage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.fTAAttributes();
					searchFTA.addAttribute();
					createFTA.save();
					createFTA.eerorValidation();
					HGExport.return_ExportHome();
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
			e.printStackTrace();
			testFail();
			HGExport.return_ExportHome();
			Assert.assertTrue(false);
		}
	}
}