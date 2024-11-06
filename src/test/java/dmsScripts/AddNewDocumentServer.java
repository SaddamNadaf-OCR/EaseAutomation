package dmsScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import dmsClasses.AddNewDocumentServerPage;
import dmsClasses.DMSHomePage;
import dmsClasses.DocumentServerConfigurationPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AddNewDocumentServer extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddNewDocumentServer", excel);
	}

	@Test(dataProvider = "getData")
	public void addNewDocumentServer(String Testcase, String RunMode, String SBU, String FTPId, String FTPType,
			String FTPURL, String Description, String Country, String UserId, String Password) throws Exception {

		DMSHomePage home = new DMSHomePage(driver, test);
		AddNewDocumentServerPage add = new AddNewDocumentServerPage(driver, test);
		DocumentServerConfigurationPage doc = new DocumentServerConfigurationPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					home.moveTo_SBUSelection(SBU);
					home.movetoTools();
					home.movetodocserverconfig();
					Wait.waitfor(3);
					doc.addnewdocserver();
					add.addnewdocserver(FTPId, FTPType, FTPURL, Description, Country, UserId, Password);
					add.savendreturn();
					Wait.waitfor(5);
					home.return_ExportHome();
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
			home.return_ExportHome();
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

}
