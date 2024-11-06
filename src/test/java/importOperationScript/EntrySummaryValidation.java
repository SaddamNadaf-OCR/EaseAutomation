package importOperationScript;

import java.lang.reflect.Method;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import importOperationClasses.EntryCreateNewEntrySummaryPage;
import importOperationClasses.EntrySummaryDetailsPage;
import importOperationClasses.EntrySummaryHomePage;
import importOperationClasses.EntrySummaryItemDetailsPage;
import importOperationClasses.EntrySummaryPartyDetails;
import importOperationClasses.EntrySummarySearchPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class EntrySummaryValidation extends SeleniumTestBase {

	// Error validations for  Entry Summary

	/*@Test(priority = 1)
	public void validateEntrySummaryHeaderDetails(Method method) throws Exception {
		EntrySummaryHomePage homeES = new EntrySummaryHomePage(driver, test);
		EntrySummarySearchPage searchES = new EntrySummarySearchPage(driver, test);
		EntryCreateNewEntrySummaryPage createES = new EntryCreateNewEntrySummaryPage(driver, test);
		EntrySummaryDetailsPage details = new EntrySummaryDetailsPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeES.moveTo_SBUSelection(propIO.getProperty("ESSBU"));
				homeES.SelectFeatureAndEntry();
				searchES.addEntrySummary();
				createES.clkGoBtn();
				details.clickSave();
				details.validationEntrySummaryDetails();
				details.headerDeatils(propIO.getProperty("ESTemplatesEN"), propIO.getProperty("ESTemplatesRefN"), "",
						"", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
				details.clickSave();
				Wait.waitfor(3);
				details.clickalertIcon();
				details.validationHeaderDetails();
				details.alertClose();
				Wait.waitfor(3);
			}
			Wait.waitfor(3);
			homeES.returnHomepageImport();
		} catch (SkipException s) { //
			s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			Assert.assertTrue(false);
			homeES.returnHomepageImport();
		}
	}
*/
	@Test(priority = 2)
	public void validateForEntrySummary(Method method) throws Exception {
		EntrySummaryHomePage homeES = new EntrySummaryHomePage(driver, test);
		EntrySummarySearchPage searchES = new EntrySummarySearchPage(driver, test);
		EntryCreateNewEntrySummaryPage createES = new EntryCreateNewEntrySummaryPage(driver, test);
		EntrySummaryDetailsPage details = new EntrySummaryDetailsPage(driver, test);
		EntrySummaryPartyDetails party = new EntrySummaryPartyDetails(driver, test);
		EntrySummaryItemDetailsPage item = new EntrySummaryItemDetailsPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				homeES.moveTo_SBUSelection(propIO.getProperty("ESSBU"));
				homeES.SelectFeatureAndEntry();
				searchES.addEntrySummary();
				createES.clkGoBtn();
				details.headerDeatils(propIO.getProperty("ESTemplatesEN"), propIO.getProperty("ESTemplatesRefN"),
						propIO.getProperty("ESSummaryDate"), propIO.getProperty("ESFilingMode"),
						propIO.getProperty("ESFilingSystem"), "", propIO.getProperty("ESEntryNumber"), "", "", "", "",
						"", "", "", "", "", "", propIO.getProperty("ESFiler"));

				details.clickSave();
				Wait.waitfor(3);

				details.clickalertIcon();
				party.validationSupplierParty();
				details.alertClose();
				Wait.waitfor(3);
				details.clickAddparty();
				party.addPartyDetails(propIO.getProperty("ESPartyType"), propIO.getProperty("ESSourceFile"),
						propIO.getProperty("ESPartyCode"), "", "", "", "", "", "", "", "", "", "", "", "");
				party.saveAndReturnPartyDetails();
				Wait.waitfor(3);
				details.clickSaveAndProceed();
				item.clickAddItem();
				item.clickGO();
				item.clickSave();
				item.validationHsNo();

				item.addtariffDetails("", "", propIO.getProperty("ESHSNO"), "", "");
				Wait.waitfor(3);
				item.clickSave();
				item.validationHsQty1();
				item.addtariffDetails("", "", "", propIO.getProperty("ESPrimaryQty1"), "");
				Wait.waitfor(3);
				item.clickSaveSaveAndReturn();
				Wait.waitfor(3);
				details.clickalertIcon();
				item.validationTotalValueDty();
				details.alertClose();

				item.clickItemNo(propIO.getProperty("ESCountryofOrigin"));
				Wait.waitfor(3);
				item.addtariffDetails("", "", "", "", propIO.getProperty("ESPrimaryValue"));
				item.clickSaveSaveAndReturn();
				Wait.waitfor(3);
				item.clickRefreshValue("");
				Wait.waitfor(3);
				details.clickalertIcon();
				details.validationAction();
				details.alertClose();
				item.clickEntrySummaryDetailTab();
				details.selectAction(propIO.getProperty("ESAction"));
				details.clickSave();
				Wait.waitfor(3);
				details.clickalertIcon();

				party.validationPartyDetails();
				details.alertClose();
				homeES.returnHomepageImport();
			}

		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();

			e.printStackTrace();
			Assert.assertTrue(false);
			homeES.returnHomepageImport();
		}
	}
}
