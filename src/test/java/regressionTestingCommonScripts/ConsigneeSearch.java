package regressionTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.HomepageConsigneePage;
import filesClasses.ResultConsigneeSearchPage;
import filesClasses.SearchConsigneePage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ConsigneeSearch extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ConsigneeSearch", excel);
	}

	@Test(dataProvider = "getData")
	public void searchPage(String testcases, String RunMode, String SBU, String SBUCode, String ID, String Name,
			String Country, String ZIP, String Status, String Active, String MT, String NS, String CB, String Related,
			String FC, String SalesPerson, String TypeOFConsignee, String FullyOrPartillyOwnedByGovt,
			String WillConsigneeInteractwdGovt, String aviMilitaryEnduse, String PoOrSignedContract,
			String OrgContactForConsignee, String EstmSalesInUSD, String STAletterObtained, String CreatedUserFname,
			 String UpdatedBy, String OverriddenBy, String SortBy, String EndUserDateFrom,
			String EndUserDateTo, String CreatedOnDateFrom, String UpdatedondateFrom, String ScreenedonDateFrom,
			String Direction, String CreatedOnDateTo, String UpdatedOnDateTo, String NP, String RS, String CC,
			String AT) {

		HomepageConsigneePage hpConsignee = new HomepageConsigneePage(driver, test);
		SearchConsigneePage srchconsignee = new SearchConsigneePage(driver, test);
		ResultConsigneeSearchPage rsltconsignee = new ResultConsigneeSearchPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, testcases);
					//hpConsignee.alertHandle();
					hpConsignee.moveTo_SBUSelection(SBU);
					Wait.waitfor(3);
					hpConsignee.movetoFiles();
					Wait.waitfor(3);
					srchconsignee.SearchConsigneeDetails(SBUCode, ID, Name, Country, ZIP, Status, Active, MT, NS, CB,
							Related, FC, NP, RS, CC, AT, SalesPerson, TypeOFConsignee, FullyOrPartillyOwnedByGovt,
							WillConsigneeInteractwdGovt, PoOrSignedContract, OrgContactForConsignee, EstmSalesInUSD,
							STAletterObtained, CreatedUserFname, aviMilitaryEnduse, UpdatedBy, OverriddenBy, SortBy,
							EndUserDateFrom, EndUserDateTo, CreatedOnDateFrom, UpdatedondateFrom, ScreenedonDateFrom,
							Direction, CreatedOnDateTo, UpdatedOnDateTo);
					Wait.waitfor(3);
					srchconsignee.Click_Consigneesearch();
					rsltconsignee.displayOfTitle();
			rsltconsignee.EditConsignee();
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
			rsltconsignee.EditConsignee();
			Assert.assertTrue(false);
		}

	}
}
