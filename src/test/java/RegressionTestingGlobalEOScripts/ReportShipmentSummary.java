package RegressionTestingGlobalEOScripts;
/* 
 * Module : Export Operation
 * Author  : saddam
 * created date : May 2024
 * Descriptions : Search Shipment Summary Report
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

import globalExportClasses.ReportShipmentSummaryPage;

import globalExportClasses.ResultShipmentReportSummaryPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ReportShipmentSummary extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ReportShipmentSummary", excel);
	}

	@Test(dataProvider = "getData")
	public void reportShipmentSummary(String Testcase,String RunMode, String Country, String Sbu, String ShipmentNo, 
			String ExporterCode, String EEINo, String WorkStatus, String AESStatus, String Ult_ConsigneeName, 
			String Inter_ConsigneeName, String UltDestination, String ForwardingAgentName, String carrierName, 
			String DateOfExportFrom, String DateOfExportTo, String SLIDateFrom, String SLIDateTo, String billOfLading, 
			String bookingNo, String hazardous, String routingInfo, String reportMonth, String carnetNo, String mawbNo, 
			String hawbNo, String aesOption, String awbNo, String prepaid, String collect, String USPPIIDandType, 
			String USPPIIDandType1, String fromCreatedDate, String toCreatedDate, String createdBy, String Invoice_No, 
			String glaCode, String sourceCode, String programCode, String fromOrderDate, String toOrderDate, 
			String packingSheetNo, String AuthorizationNo, String DOS_DOC_Code, String grossWeights, String contractNo, 
			String htsNo, String productClassification, String itarNo, String sortBy, String direction) throws Exception {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ReportShipmentSummaryPage search = new ReportShipmentSummaryPage (driver, test);
		ResultShipmentReportSummaryPage result = new ResultShipmentReportSummaryPage (driver, test);
		
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
					HGExport.ReportShipmentSummary();
					Wait.waitfor(2);
					search.parameter(Country, Sbu, ShipmentNo, ExporterCode, EEINo, WorkStatus, AESStatus, 
							Ult_ConsigneeName, Inter_ConsigneeName, UltDestination, ForwardingAgentName, carrierName, 
							DateOfExportFrom, DateOfExportTo, SLIDateFrom, SLIDateTo, billOfLading, bookingNo, hazardous, 
							routingInfo, reportMonth, carnetNo, mawbNo, hawbNo, aesOption, awbNo, prepaid, collect, 
							USPPIIDandType, USPPIIDandType1, fromCreatedDate, toCreatedDate, createdBy, Invoice_No, 
							glaCode, sourceCode, programCode, fromOrderDate, toOrderDate, packingSheetNo, AuthorizationNo, 
							DOS_DOC_Code, grossWeights, contractNo, htsNo, productClassification, itarNo, sortBy, direction);
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


