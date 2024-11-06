package importOperationScript;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import importOperationClasses.HomePage;
import importOperationClasses.SearchCargoReleasePage;
import importOperationClasses.SearchCargoReleaseResultPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class SearchCR extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchCargoRelease", excel);
	}

	@Test(dataProvider = "getData")
	public void CargoReleaseStatus(String Testcase, String RunMode, String SBU, String SBUCode, String Status,
			String EntryNo, String CustomStatus, String IntRefNo, String Filer, String Action, String EntryType,
			String PortofEntry, String MOT, String Carrier, String BondType, String BondHolderID,
			String SuretyCompanyNo, String BondAccountNo, String EstShipmentfrom, String EstShipmentto,
			String ImportCoordReviewer, String CorpComplianceReviewer, String CreatedBy, String CraeteDateFrom,
			String CraeteDdateTo, String Direction, String SortBy, String PartyType, String PartyName,
			String PartyCountry, String PartyIdNumber, String BillNo, String ParentBillNo, String BillType,
			String PartNo, String PartDesc, String HtsNo, String CountryOfOrigin, String RelatedParty,
			String Manufacturer, String ValueBetweenfrom, String ValueBetweento, String OrderNo,
			String CommercialInvoiceNo) throws Exception {

		HomePage homeCR = new HomePage(driver, test);
		SearchCargoReleasePage searchCR = new SearchCargoReleasePage(driver, test);
		SearchCargoReleaseResultPage searchCRResult = new SearchCargoReleaseResultPage(driver, test);
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homeCR.moveTo_SBUSelection(SBU);
					homeCR.SelectFeatureAndEntry();
					searchCR.commonSearch(SBUCode, Status, EntryNo, CustomStatus, IntRefNo, Filer, Action, EntryType,
							PortofEntry, MOT, Carrier, BondType, BondHolderID, SuretyCompanyNo, BondAccountNo,
							EstShipmentfrom, EstShipmentto, ImportCoordReviewer, CorpComplianceReviewer, CreatedBy,
							CraeteDateFrom, CraeteDdateTo, Direction, SortBy);
					searchCR.partyDetailsSearch(PartyType, PartyName, PartyCountry, PartyIdNumber);
					searchCR.searchbyBillOfLadingDetails(BillNo, ParentBillNo, BillType);
					searchCR.SearchbyItemDetails(PartNo, PartDesc, HtsNo, CountryOfOrigin, RelatedParty, Manufacturer,
							ValueBetweenfrom, ValueBetweento, OrderNo, CommercialInvoiceNo);
					Wait.waitfor(3);
					searchCR.click_SearchBtn();
					searchCRResult.searchCargoReleaseDisplay();
					Wait.waitfor(4);
					homeCR.returnHomepageImport();
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
			homeCR.returnHomepageImport();
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
}
