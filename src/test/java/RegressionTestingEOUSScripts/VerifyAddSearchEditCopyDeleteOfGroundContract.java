package RegressionTestingEOUSScripts;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : May 2024
 * Descriptions : Add, Search, Edit, Copy and Delete Ground Contract 
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
import globalExportClasses.CreateNewGroundContractHeaderPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ListOfGroundContractHeaderPage;
import globalExportClasses.SearchGroundContractHeaderPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class VerifyAddSearchEditCopyDeleteOfGroundContract extends SeleniumTestBase{

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddEditDeleteGroundContract", excel);
	}

	@Test(dataProvider = "getData")
	public void searchGroundContract(String Testcase, String RunMode, String SBU, String SBUCode, String ContractCode, 
			String SubCode, String DepartureCode, String FreightForwarder, String CarrierCode, String CreatedBy, String SortBy, 
			String Direction, String CombineWeight)throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchGroundContractHeaderPage searchGC = new SearchGroundContractHeaderPage(driver, test);
		ListOfGroundContractHeaderPage resultGC = new ListOfGroundContractHeaderPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.groundContract();
					searchGC.searchbyParameters(SBUCode, ContractCode, DepartureCode, FreightForwarder, CarrierCode, CreatedBy, SortBy, Direction);
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
	public void addGroundContract(String Testcase, String RunMode, String SBU, String SBUCode, String ContractCode, 
			String SubCode, String DepartureCode, String FreightForwarder, String CarrierCode, String CreatedBy, String SortBy, 
			String Direction, String CombineWeight)throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchGroundContractHeaderPage searchGC = new SearchGroundContractHeaderPage(driver, test);
		ListOfGroundContractHeaderPage resultGC = new ListOfGroundContractHeaderPage(driver, test);
		CreateNewGroundContractHeaderPage createGC = new CreateNewGroundContractHeaderPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.groundContract();
					searchGC.addGroundContract();
					Wait.waitfor(2);
					createGC.titleisDisplayed();
					createGC.addParameters(ContractCode, SubCode, DepartureCode, FreightForwarder, CarrierCode, CombineWeight);
					Wait.waitfor(2);
					createGC.saveandReturn();
					searchGC.contractCode(ContractCode);
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
	public void editGroundContract(String Testcase, String RunMode, String SBU, String SBUCode, String ContractCode, 
			String SubCode, String DepartureCode, String FreightForwarder, String CarrierCode, String CreatedBy, String SortBy, 
			String Direction, String CombineWeight)throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchGroundContractHeaderPage searchGC = new SearchGroundContractHeaderPage(driver, test);
		ListOfGroundContractHeaderPage resultGC = new ListOfGroundContractHeaderPage(driver, test);
		CreateNewGroundContractHeaderPage createGC = new CreateNewGroundContractHeaderPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.groundContract();
					searchGC.contractCode(ContractCode);
					searchGC.search();
					resultGC.clickcontractCode(ContractCode);
					createGC.contractCodeEdit(ContractCode);
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
	public void copyGroundContract(String Testcase, String RunMode, String SBU, String SBUCode, String ContractCode, 
			String SubCode, String DepartureCode, String FreightForwarder, String CarrierCode, String CreatedBy, String SortBy, 
			String Direction, String CombineWeight)throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchGroundContractHeaderPage searchGC = new SearchGroundContractHeaderPage(driver, test);
		ListOfGroundContractHeaderPage resultGC = new ListOfGroundContractHeaderPage(driver, test);
		CreateNewGroundContractHeaderPage createGC = new CreateNewGroundContractHeaderPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.groundContract();
					searchGC.contractCode(ContractCode);
					searchGC.search();
					resultGC.copyIcon();
					createGC.contractCodeEdit(ContractCode);
					createGC.subcode(SubCode);
					createGC.saveandReturn();
					resultGC.newSearch();
					searchGC.contractCode(ContractCode);
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
	public void deleteGroundContract(String Testcase, String RunMode, String SBU, String SBUCode, String ContractCode, 
			String SubCode, String DepartureCode, String FreightForwarder, String CarrierCode, String CreatedBy, String SortBy, 
			String Direction, String CombineWeight)throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchGroundContractHeaderPage searchGC = new SearchGroundContractHeaderPage(driver, test);
		ListOfGroundContractHeaderPage resultGC = new ListOfGroundContractHeaderPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.groundContract();
					searchGC.contractCode(ContractCode);
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
	public void validateErrorMsgGroundContract(String Testcase, String RunMode, String SBU, String SBUCode, String ContractCode, 
			String SubCode, String DepartureCode, String FreightForwarder, String CarrierCode, String CreatedBy, String SortBy, 
			String Direction, String CombineWeight)throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchGroundContractHeaderPage searchGC = new SearchGroundContractHeaderPage(driver, test);
		CreateNewGroundContractHeaderPage createGC = new CreateNewGroundContractHeaderPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.groundContract();
					searchGC.addGroundContract();
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
