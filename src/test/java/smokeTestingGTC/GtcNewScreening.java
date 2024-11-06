package smokeTestingGTC;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.relevantcodes.extentreports.LogStatus;

import globalTradeControlClasses.GtcHomePage;
import globalTradeControlClasses.GtcNewScreeningPage;
import globalTradeControlClasses.ResultTradeCotrolPage;
import globalTradeControlClasses.ScreenPage;
import globalTradeControlClasses.SearchTradeControlScreeningPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class GtcNewScreening extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("CreatingNewScreening", excel);
	}

	@Test(dataProvider = "getData")

	public void createScreening(String Testcase, String RunMode, String ClientReferenceNo, String ExportCountry,
			String ImportCountry, String ScreeningType, String ExportControl, String SourceFile, String ConsigneeId,
			String EntityStatus, String EntityName, String EntityAddress1, String EntityAddress2, String EntityAddress3,
			String EntityRole, String EntityCity, String EntityState, String EntityCountry, String EntityZip,
			String EntityDecision, String DispositionReason, String Remarks, String ControlDecision) throws Exception {

		// **************** Objects Creation *******************************************

		GtcNewScreeningPage newscreen = new GtcNewScreeningPage(driver, test);
		ScreenPage screen = new ScreenPage(driver, test);
		GtcHomePage gtchome = new GtcHomePage(driver, test);
		SearchTradeControlScreeningPage gtcsearch = new SearchTradeControlScreeningPage(driver, test);
		ResultTradeCotrolPage resulttraderef = new ResultTradeCotrolPage(driver, test);
		SoftAssert softAssertion = new SoftAssert();

		// **********Test steps execution ***************************

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					gtchome.moveTo_GtcListScreening();
					gtchome.clickTo_TradeControlsScreening();
					gtcsearch.click_GtcNewScreening();
					newscreen.headerDetails(ClientReferenceNo, ExportCountry, ImportCountry, ScreeningType,
							ExportControl);
					newscreen.entityDetails(SourceFile, ConsigneeId, EntityName, EntityAddress1, EntityAddress2,
							EntityAddress3, EntityRole, EntityCity, EntityState, EntityCountry, EntityZip,
							EntityStatus);
					Wait.waitfor(5);
					if (EntityName.length() > 0 && EntityRole.length() > 0)
						newscreen.saveNewScreening();
					screen.click_GtcScreen();
					String StatusApproved = screen.getStatus();
					if (StatusApproved.equals("Approved")) {
						screen.takeOwnershipValidation();
					} else {
						screen.click_GtcTradeControlDecision();
						screen.click_GtcEntityScreening();
						screen.click_GtcSelectEntity(1);
						screen.click_GtcSaveEntity(EntityDecision, DispositionReason, Remarks);
						screen.click_GtcSubmitTradeControlScreening(ControlDecision);
					}
					String ReferenceNo = screen.getReferenceNo();
					String Status = screen.getStatus();
					if (Status.equals(ControlDecision)) {
						test.log(LogStatus.PASS, "Expected ControlDecision : " + ControlDecision);
					} else {
						test.log(LogStatus.FAIL, "Expected ControlDecision : " + ControlDecision);
						testFail();
						softAssertion.assertTrue(false);
					}
					gtchome.GtcreturnPage();
					gtcsearch.enter_ClientReferenceNo(ReferenceNo, ClientReferenceNo);
					gtcsearch.click_GtcSearch();
					resulttraderef.click_ResultSearchReferenceNo();
					gtchome.GtcreturnPage();
					softAssertion.assertAll();
					Wait.waitfor(3);
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		} catch (SkipException s) {
			test.log(LogStatus.INFO, Testcase);
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
