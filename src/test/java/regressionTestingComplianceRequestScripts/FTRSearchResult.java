/* 
 * Module : CRS
 * Author  : Nancy
 * created date : Oct 2019
 * Descriptions : Foreign Travel Search Result
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */

package regressionTestingComplianceRequestScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import crsClasses.HomePageCRs;
import crsClasses.ResultForeignTravelPage;
import crsClasses.SearchExportRequestPage;
import crsClasses.SearchForeignTravelPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class FTRSearchResult extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("FTRSearchResult", excel);
	}

	@Test(dataProvider = "getData")
	public void FTRSearchReq(String Testcase, String RunMode, String SBUCode, String ForeignTravelId,
			String RequesterName, String ExportReviewer, String SecurityReviewer, String ManagerReviewer,
			String DirectorReviewer, String TravelDeskName, String Status, String ManagerName, String TravelDateFrom,
			String TravelDateTo, String Country, String Company, String CitiesVisiting, String DepartureCity,
			String ActivityType, String AuthorizationType, String AuthorizationNo_AgrNo, String Trip,
			String InitiatedDateFrom, String InitiatedDateTo, String Segment, String Site, String ProductLine,
			String ProductFamily, String SortBy, String Program, String Direction, String PrimaryPurpose,
			String ReviewPending_ExpReview, String ReviewPending_SecReview, String ReviewPending_ManReview,
			String ReviewPending_DirReview) throws Exception {

		HomePageCRs home = new HomePageCRs(driver, test);
		SearchExportRequestPage searchER = new SearchExportRequestPage(driver, test);
		SearchForeignTravelPage searchFTR = new SearchForeignTravelPage(driver, test);
		ResultForeignTravelPage resultFTR = new ResultForeignTravelPage(driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					home.moveTo_ListScreening();
					home.click_ComplianceRequest();
					searchER.moveTo_Features();
					Wait.waitfor(3);
					searchER.click_Requests();
					Wait.waitfor(5);
					searchER.click_FTRReqlink();
					Wait.waitfor(7);
					searchFTR.searchParameters(SBUCode, ForeignTravelId, RequesterName, ExportReviewer,
							SecurityReviewer, ManagerReviewer, DirectorReviewer, TravelDeskName, Status, ManagerName,
							TravelDateFrom, TravelDateTo, Country, Company, CitiesVisiting, DepartureCity, ActivityType,
							AuthorizationType, AuthorizationNo_AgrNo, Trip, InitiatedDateFrom, InitiatedDateTo, Segment,
							Site, ProductLine, ProductFamily, SortBy, Program, Direction, PrimaryPurpose,
							ReviewPending_ExpReview, ReviewPending_SecReview, ReviewPending_ManReview,
							ReviewPending_DirReview);
					Wait.waitfor(3);
					searchFTR.click_SearchBtn();
					resultFTR.titleIsDisplayed();
					Wait.waitfor(3);
					home.returnToCRPage();
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
			home.returnToCRPage();
			Assert.assertTrue(false);
		}
	}

}
