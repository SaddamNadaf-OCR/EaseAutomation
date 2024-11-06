package authorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import authorizationManagementClasses.AnnualSalesReportSearchPage;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.USGASRTAASalesReportPage;
import authorizationManagementClasses.USGSelectAgreementNumberAnnualSalesRPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class AnnualSalesReports extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AnnualSalesReportsScripts", excel);
	}
	
	@Test(dataProvider="getData")
	public void annualSalesReports(String TestCases,String RunMode,String SBU,String agreementNo,String poc,String telephone, String email) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver,test);
		AnnualSalesReportSearchPage searchPage=new AnnualSalesReportSearchPage(driver,test);
		USGSelectAgreementNumberAnnualSalesRPage agreementno=new USGSelectAgreementNumberAnnualSalesRPage(driver,test);
		USGASRTAASalesReportPage salesReport=new USGASRTAASalesReportPage(driver,test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.clickOnAnnualSalesReport();
					searchPage.addSalesReports();
					agreementno.agreementNumberTAA(agreementNo);
					salesReport.salesReportData(poc, telephone, email);
					salesReport.save();
				}else {
					testFail();
				}
			}
	}catch(Exception e) {
		e.printStackTrace();
		testFail();
		}
	}
}
