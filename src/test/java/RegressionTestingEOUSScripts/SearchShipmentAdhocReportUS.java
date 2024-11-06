package RegressionTestingEOUSScripts;
/* 
 * Module : Export Operation
 * Author  : 
 * created date : 
 * Descriptions : Search Shipment Adhoc Report Script
 * changed by : Saddam
 * changed date : 14/05/2024
 * Purpose of change : Added in Regression Testcases
 * Reviewed by : Nil 
 */
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultReportPage;
import globalExportClasses.SearchShipmentAdhocReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class SearchShipmentAdhocReportUS extends SeleniumTestBase{
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ShpAdhocReport", excel);
	}

	@Test(dataProvider = "getData")
	public void ShipAdhocReport(String Testcase, String RunMode, String SBU, String Country, String sbu, 
			String ReportType, String InvoiceNo, String ShpNo, String ITNNo, String WorkStatus, String ExporterCountry, 
			String CountryOfOrigin, String DestinationCountry, String USPPICode, String USPPIName, String USPPIEIN, 
			String Consignee, String FreightForwarder, String Carrier, String AirwaybillNo, String ShippingMethod, 
			String Region, String Site, String ShippingReviewer, String ExportReviewer, String TransportReviewer, 
			String ExportAuthority, String Activitytype, String AuthorizationType, String AuthorizationNo, String Transactiontype, 
			String Segment, String ProductFamily, String CostCenterNo, String CreatedOnFromDate, String CreatedOnToDate, 
			String DateOfExportFromDate, String DateOfExportToDate, String CreatedBy, String IssueFromDate, String IssueToDate ) {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchShipmentAdhocReportPage ShpAdhocReport = new SearchShipmentAdhocReportPage(driver, test);
		ResultReportPage result = new ResultReportPage(driver, test);
		
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.moveToReports();
					HGExport.ShipAdhocReport();
					ShpAdhocReport.searchByparameters(Country, sbu, ReportType, InvoiceNo, ShpNo, ITNNo, WorkStatus, 
							ExporterCountry, CountryOfOrigin, DestinationCountry, USPPICode, USPPIName, USPPIEIN, 
							Consignee, FreightForwarder, Carrier, AirwaybillNo, ShippingMethod, Region, Site, ShippingReviewer, 
							ExportReviewer, TransportReviewer, ExportAuthority, Activitytype, AuthorizationType, 
							AuthorizationNo, Transactiontype, Segment, ProductFamily, CostCenterNo, CreatedOnFromDate, 
							CreatedOnToDate, DateOfExportFromDate, DateOfExportToDate, CreatedBy, IssueFromDate, IssueToDate);
					ShpAdhocReport.SearchBtn();
					result.titleIsDisplayed();
				//	result.IconsDisplay();
					ShpAdhocReport.validateHeading();
				
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
			HGExport.return_ExportHome();
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}



}
