package smokeTestingCommonScripts;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import filesClasses.HomepageConsigneePage;
import filesClasses.SearchEmployeepage;
import filesClasses.SearchResltemplyeePage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class EmployeeSearchScript extends SeleniumTestBase {

	

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("EmployeeSearchScript", excel);
	}

	@Test(dataProvider = "getData")
	public void searchPage(String testcases, String RunMode, String SBU, String SBUCode, String EmpID, String EmpFname, String EmpLastName) {

		HomepageConsigneePage hpconsignee= new HomepageConsigneePage(driver, test);
		SearchEmployeepage srchemp= new SearchEmployeepage(driver, test);
		SearchResltemplyeePage rsltemplerch= new SearchResltemplyeePage(driver, test);
		
	
	
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, testcases);
					hpconsignee.moveTo_SBUSelection(SBU);
					Wait.waitfor(2);
					hpconsignee.movetoFilesEmployee();
					Wait.waitfor(2);
		srchemp.SearchEmployee(SBUCode, EmpID, EmpFname, EmpLastName);
					Wait.waitfor(2);
					srchemp.clickonSearch();
					Wait.waitfor(2);
					rsltemplerch.displayOfTitle();
					Wait.waitfor(2);
				
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		
		} catch (SkipException s) {
			test.log(LogStatus.INFO, testcases);
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			hpconsignee.logout();

		}
	}
}
