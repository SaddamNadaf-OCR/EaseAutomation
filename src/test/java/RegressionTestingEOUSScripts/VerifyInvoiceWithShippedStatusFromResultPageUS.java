package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.CreateInvoicePage;
import globalExportClasses.CreateNewShipmentPage;
import globalExportClasses.EditInvoiceOrderFormPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.InvoicePage;
import globalExportClasses.ResultInvoiceOrderPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class VerifyInvoiceWithShippedStatusFromResultPageUS extends SeleniumTestBase{
	

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ShippedInvoiceFromResultPage", excel);
	}

	@Test(dataProvider = "getData")
	public void VerifyShipedInvoiceFuncOnResultPage(String Testcase, String RunMode, String SBU, String InvoiceNo, String workStatus) {
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		InvoicePage Inv = new InvoicePage(driver, test);
		CreateInvoicePage Create_Inv = new CreateInvoicePage(driver, test);
		ResultInvoiceOrderPage ResultInv = new ResultInvoiceOrderPage(driver, test);
		CreateNewShipmentPage CreateNewShip = new CreateNewShipmentPage(driver, test);
		EditInvoiceOrderFormPage EditInvoiceOrder = new EditInvoiceOrderFormPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.OCR_HomePage_Invoice_Order();
					Inv.approvedInvoice(InvoiceNo, workStatus);
					Inv.click_SearchButton();
					ResultInv.ShipNoFromResultPage();
					CreateNewShip.verifyShipmentHeader();
					CreateNewShip.ShipPagecloseBtn();
					ResultInv.clickInvoiceNo();
					EditInvoiceOrder.select_LinkedShipmentDetails();
					CreateNewShip.verifyShipmentHeader();
					HGExport.return_ExportHome();
	}
			 else {
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
		HGExport.return_ExportHome();
		e.printStackTrace();
		Assert.assertTrue(false);
	}
}
			}
	
			
		
	

