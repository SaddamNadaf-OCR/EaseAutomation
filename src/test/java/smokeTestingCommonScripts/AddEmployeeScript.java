package smokeTestingCommonScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import filesClasses.AddEmployeePage;
import filesClasses.AddResultEmpPage;
import filesClasses.HomepageConsigneePage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AddEmployeeScript extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddEmployeeScript", excel);
	}

	@Test(dataProvider = "getData")
	public void AddEmployeePage(String testcases, String RunMode, String SBU, String EmpId, String EmpFNmame,
			String EmpLastName) {

		HomepageConsigneePage hpconsignee = new HomepageConsigneePage(driver, test);
		AddEmployeePage adEmp = new AddEmployeePage(driver, test);
		AddResultEmpPage adrsltemp = new AddResultEmpPage(driver, test);

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
					adEmp.AddEmployee(EmpId, EmpFNmame, EmpLastName);
					Wait.waitfor(2);
					adEmp.clickonSave();
					Wait.waitfor(2);
					adrsltemp.displayOfTitle();
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
