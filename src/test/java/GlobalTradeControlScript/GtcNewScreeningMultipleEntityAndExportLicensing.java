package GlobalTradeControlScript;

import java.util.ArrayList;
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
import utilities.GenericMethods;
import utilities.Utility;
import utilities.Wait;

public class GtcNewScreeningMultipleEntityAndExportLicensing extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("GtcMultilpeEntityandExportLicns", excel);
	}

	@Test(dataProvider = "getData")
	public void createScreening(String Testcase, String RunMode, String ClientReferenceNo, String ExportCountry,
			String ImportCountry, String ExportControl, String SourceFile, String ConsigneeId, String EntityStatus,
			String EntityName, String EntityAddress1, String EntityAddress2, String EntityAddress3, String EntityRole,
			String EntityCity, String EntityState, String EntityCountry, String EntityZip, String PartNo,
			String ECCNumber, String ClassificationItem, String UnitPrice, String Quantity, String UOM, String Value,
			String AuthorizationType, String Currency, String CountryOfOrigin, String Enduse, String EndUserType,
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
					newscreen.headerDetails(ClientReferenceNo, ExportCountry, ImportCountry, "", ExportControl);
					ArrayList<String> sourceFile = GenericMethods.stringtoken(SourceFile);
					ArrayList<String> consigneeId = GenericMethods.stringtoken(ConsigneeId);
					ArrayList<String> entityStatus = GenericMethods.stringtoken(EntityStatus);
					ArrayList<String> entityName = GenericMethods.stringtoken(EntityName);
					ArrayList<String> entityRole = GenericMethods.stringtoken(EntityRole);
					for (int i = 0; i < sourceFile.size(); i++) {
						newscreen.entityDetails(sourceFile.get(i).trim(), consigneeId.get(i).trim(),
								entityName.get(i).trim(), EntityAddress1, EntityAddress2, EntityAddress3,
								entityRole.get(i).trim(), EntityCity, EntityState, EntityCountry, EntityZip,
								entityStatus.get(i).trim());
						Wait.waitfor(5);
					}
					ArrayList<String> partNo = GenericMethods.stringtoken(PartNo);
					ArrayList<String> eccNumber = GenericMethods.stringtoken(ECCNumber);
					ArrayList<String> classificationItem = GenericMethods.stringtoken(ClassificationItem);
					ArrayList<String> unitPrice = GenericMethods.stringtoken(UnitPrice);
					ArrayList<String> quantity = GenericMethods.stringtoken(Quantity);
					ArrayList<String> uom = GenericMethods.stringtoken(UOM);
					ArrayList<String> value = GenericMethods.stringtoken(Value);
					ArrayList<String> authorizationType = GenericMethods.stringtoken(AuthorizationType);
					ArrayList<String> currency = GenericMethods.stringtoken(Currency);
					ArrayList<String> countryOfOrigin = GenericMethods.stringtoken(CountryOfOrigin);
					ArrayList<String> enduse = GenericMethods.stringtoken(Enduse);
					ArrayList<String> endUserType = GenericMethods.stringtoken(EndUserType);

					for (int i = 0; i < partNo.size(); i++) {
						newscreen.itemDetails(partNo.get(i).trim(), eccNumber.get(i).trim(),
								classificationItem.get(i).trim(), unitPrice.get(i).trim(), quantity.get(i).trim(),
								uom.get(i).trim(), value.get(i).trim(), authorizationType.get(i).trim(),
								currency.get(i).trim(), countryOfOrigin.get(i).trim(), enduse.get(i).trim(),
								endUserType.get(i).trim());
						newscreen.click_addItembutton();
					}
					newscreen.click_screenbtn();
					// screen.click_GtcScreen();
					screen.click_GtcTradeControlDecision();
					screen.click_GtcEntityScreening();
					for (int i = 1; i <= sourceFile.size(); i++) {
						screen.click_GtcSelectEntity(i);
					}
					screen.click_GtcSaveEntity(EntityDecision, DispositionReason, Remarks);
					String ReferenceNo = screen.getReferenceNo();
					String Status = screen.getStatus();
					if (Status.equals(ControlDecision)) {
						test.log(LogStatus.PASS, "Expected ControlDecision : " + ControlDecision);
						softAssertion.assertTrue(true);
					} else {
						test.log(LogStatus.FAIL, "Expected ControlDecision : " + ControlDecision);
						testFail();
						softAssertion.assertTrue(false);
					}
					newscreen.click_licensescreeningbtn();

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
