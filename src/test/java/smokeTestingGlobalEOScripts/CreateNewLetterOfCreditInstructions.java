package smokeTestingGlobalEOScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import globalExportClasses.CreateLetterOfCreditInstructionsPage;
import globalExportClasses.CreateNewLetterOfCreditInstructionsPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.LetterOfCreditInstructionsPage;
import globalExportClasses.ResultLetterOfCreditInstructionsPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class CreateNewLetterOfCreditInstructions extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("CreateNewLCI", excel);
	}

	@Test(dataProvider = "getData")
	public void createNewLCI(String Testcase, String RunMode, String SBU, String LCIID, String InvoiceNo,
			String InvoiceDate, String ExporterCode, String ConsigneeCode, String AdvisingBankID,
			String ConfirmingBankID, String DrawingBankID, String Beneficiary, String CreditCurrency,
			String MaximumCreditType, String Amount, String DraftsAt, String ChargesExpenseBearer,
			String ApplyCICountryToApplicant, String AllowPartialShipments, String AllowedDays,
			String LetterCredittransferrable, String AllowTramsshipments, String CommercialInvoice,
			String InsuranceCertificate, String AllowforNVOCCbillsoflading, String Markbillofladingonboard,
			String AWBConsignedTo, String PackingList, String PAmount, String AllowConsolidatedAirwaybill,
			String MarkDocumentFreightPrepaid, String InlandBOLConsignedTo, String ShippingOrigin, String OtherReqDocs,
			String ShowForwarderAs, String ShowCarrierAs, String SpecialInstructions, String ShippingDestination)
			throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		LetterOfCreditInstructionsPage LCI = new LetterOfCreditInstructionsPage(driver, test);
		CreateLetterOfCreditInstructionsPage CLCI = new CreateLetterOfCreditInstructionsPage(driver, test);
		CreateNewLetterOfCreditInstructionsPage createLCI = new CreateNewLetterOfCreditInstructionsPage(driver, test);
		ResultLetterOfCreditInstructionsPage resultLIC = new ResultLetterOfCreditInstructionsPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.featuresOrdersDeliveries();
					HGExport.clickLetterOfCredit();
					LCI.ClickLCI();
					CLCI.clickCLCI();
					createLCI.addHeaderLCI(LCIID, InvoiceNo, InvoiceDate);
					createLCI.clickSave();
					String ResultLCI = createLCI.getValueLCI();
					Wait.waitfor(3);
					createLCI.addExporter(ExporterCode);
					createLCI.addConsignee(ConsigneeCode);
					createLCI.addBankDetails(AdvisingBankID, ConfirmingBankID, DrawingBankID, Beneficiary,
							CreditCurrency, MaximumCreditType, Amount, DraftsAt, ChargesExpenseBearer,
							ApplyCICountryToApplicant, AllowPartialShipments, AllowedDays, LetterCredittransferrable,
							AllowTramsshipments);

					createLCI.addRequiredDoc(CommercialInvoice, InsuranceCertificate, AllowforNVOCCbillsoflading,
							Markbillofladingonboard, AWBConsignedTo, PackingList, PAmount, AllowConsolidatedAirwaybill,
							MarkDocumentFreightPrepaid, InlandBOLConsignedTo, ShippingOrigin, OtherReqDocs,
							ShowForwarderAs, ShowCarrierAs, SpecialInstructions, ShippingDestination);
					Wait.waitfor(3);
					createLCI.clickSaveAndReturn();
					Wait.waitfor(3);
//					LCI.typeLCIID(ResultLCI);
					LCI.clickSearchBtn();
					resultLIC.isDisplayResultLCI(ResultLCI);
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
