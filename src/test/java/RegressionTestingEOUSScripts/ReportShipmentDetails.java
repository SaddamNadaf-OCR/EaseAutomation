package RegressionTestingEOUSScripts;

/* 
 * Module : Export Operation
 * Author  : saddam
 * created date : May 2024
 * Descriptions : Report Shipment Details
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil
 * Reviewed by : Nil 
 */
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.ReportShipmentDetailsPage;
import globalExportClasses.ResultShipmentReportDetailsPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ReportShipmentDetails extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ReportShipmentDetails", excel);
	}

	@Test(dataProvider = "getData")
	public void reportShipmentDetails(String Testcase, String RunMode, String Country, String Sbu, String ShipmentNo,
			String ExporterCode, String EEINo, String ExporterCountry, String WorkStatus, String AESStatus,
			String Ult_ConsigneeName, String Inter_ConsigneeName, String UltDestination, String TransportRefNo,
			String ForwardingAgentName, String carrierName, String DateOfExportFrom, String DateOfExportTo,
			String SLIDateFrom, String SLIDateTo, String billOfLading, String bookingNo, String hazardous,
			String AESExemptionStatement, String reportMonth, String carnetNo, String mawbNo, String hawbNo,
			String aesOption, String awbNo, String prepaid, String collect, String Invoice_No, String glaCode,
			String sourceCode, String programCode, String fromOrderDate, String toOrderDate, String packingSheetNo,
			String AuthorizationNo, String DOS_DOC_Code, String grossWeights, String contractNo, String htsNo,
			String productClassification, String itarNo, String createdBy, String sortBy, String direction)
			throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ReportShipmentDetailsPage search = new ReportShipmentDetailsPage(driver, test);
		ResultShipmentReportDetailsPage result = new ResultShipmentReportDetailsPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					Wait.waitfor(2);
					HGExport.moduleselection();
					Wait.waitfor(2);
					HGExport.ReportShipment();
					Wait.waitfor(2);
					search.parameter(Country, Sbu, ShipmentNo, ExporterCode, EEINo, ExporterCountry, WorkStatus,
							AESStatus, Ult_ConsigneeName, Inter_ConsigneeName, UltDestination, TransportRefNo,
							ForwardingAgentName, carrierName, DateOfExportFrom, DateOfExportTo, SLIDateFrom, SLIDateTo,
							billOfLading, bookingNo, hazardous, AESExemptionStatement, reportMonth, carnetNo, mawbNo,
							hawbNo, aesOption, awbNo, prepaid, collect, Invoice_No, glaCode, sourceCode, programCode,
							fromOrderDate, toOrderDate, packingSheetNo, AuthorizationNo, DOS_DOC_Code, grossWeights,
							contractNo, htsNo, productClassification, itarNo, createdBy, sortBy, direction);
					Wait.waitfor(2);
					search.search();
					Wait.waitfor(2);
					result.titleIsDisplayed();
					Wait.waitfor(2);
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
