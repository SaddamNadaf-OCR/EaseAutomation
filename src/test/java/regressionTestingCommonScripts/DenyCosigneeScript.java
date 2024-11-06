package regressionTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.EditConsigneePage;
import filesClasses.HomepageConsigneePage;
import filesClasses.Override_Deny_ConsigneePage;
import filesClasses.ResultConsigneeSearchPage;
import filesClasses.SearchConsigneePage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class DenyCosigneeScript extends SeleniumTestBase{
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("DenyCosigneeScript", excel);
	}
	
	@Test(dataProvider = "getData")
	public void denyconsigneescript(String testcases,String RunMode,String SBU, String SBUCode, 
			String ID, String Name, String Country, String ZIP, String Status, String Active,
			String MT, String NS, String CB, String Related, String FC, String NP, String RS, 
			String CC, String AT, String SalesPerson, String TypeOFConsignee,
			String FullyOrPartillyOwnedByGovt, String WillConsigneeInteractwdGovt,
			String PoOrSignedContract, String OrgContactForConsignee, String EstmSalesInUSD, 
			String STAletterObtained, String CreatedUserFname, String aviMilitaryEnduse, 
			String UpdatedBy, String OverriddenBy, String SortBy, String EndUserDateFrom, 
			String EndUserDateTo, String CreatedOnDateFrom, String UpdatedondateFrom, 
			String ScreenedonDateFrom, String Direction, String CreatedOnDateTo,
			String UpdatedOnDateTo, String data, String remark) {
		HomepageConsigneePage hp=new HomepageConsigneePage(driver,test);
		SearchConsigneePage sc=new SearchConsigneePage(driver,test);
		ResultConsigneeSearchPage rc=new ResultConsigneeSearchPage(driver,test);
		EditConsigneePage ec=new EditConsigneePage(driver,test);
		Override_Deny_ConsigneePage od=new Override_Deny_ConsigneePage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, testcases);
					hp.moveTo_SBUSelection(SBU);
					hp.movetoFiles();
					sc.SearchConsigneeDetails(SBUCode, ID, Name, Country, ZIP, Status, Active, MT, NS, CB, Related,
							FC, NP, RS, CC, AT, 
							SalesPerson, TypeOFConsignee, FullyOrPartillyOwnedByGovt, WillConsigneeInteractwdGovt, 
							PoOrSignedContract, OrgContactForConsignee, EstmSalesInUSD, STAletterObtained, CreatedUserFname,
							aviMilitaryEnduse, UpdatedBy, OverriddenBy, SortBy, EndUserDateFrom, EndUserDateTo, CreatedOnDateFrom, 
							UpdatedondateFrom, ScreenedonDateFrom, Direction, CreatedOnDateTo, UpdatedOnDateTo);
					sc.Click_Consigneesearch();
					rc.clickonId(data);
					ec.clickonDeny();
					od.editConsigneeCompliance();
					od.dataselect(remark);
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		} catch (SkipException s) {
			test.log(LogStatus.INFO, testcases);
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
}
