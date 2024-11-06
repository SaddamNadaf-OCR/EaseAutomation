package regressionTestingGlobalAuthorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import authorizationManagementClasses.AddAuthorizationSelectSBUPage;
import authorizationManagementClasses.AuthorizationHeaderTemplatePage;
import authorizationManagementClasses.CreateNewAuthorisationPage;
import authorizationManagementClasses.CreateNewAuthorizationCountryPage;
import authorizationManagementClasses.CreateNewAuthorizationPortPage;
import authorizationManagementClasses.EditAuthorisationPage;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.SearchAuthorisationPage;
import authorizationManagementClasses.View_EditLicenseDetailsPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class AddViewEditAuthorizations extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("AddViewEditAuthorizations", excel);
	}
	
	@Test(dataProvider="getData")
	public void addvieweditAuthorization(String TestCases,String RunMode, String SBU, String autorizationType, String ActivityType, 
			String RequestID, String ReferenceID, String Status, String AuthorisationPurpose, String FolderId, String Summary, String Programme,
			String Segment, String Site, String Country, String SalesOrderNo, String ContractNo, String RequestorName, String OwnerName,
			String RequestorEmail, String OwnerEmail, String RequestorPhone, String OwnerPhone, String Agency, String dateinitiated, 
			String Signaturedate, String Submitdate, String CaseNo, String LicenseNo, String RelatedAuth, String Issuedate, String Expirydate, 
			String Closuredate, String TransactionType, String LicenseTolerance, String TECC, String Originator, String GovtPOC, String Returnabledate,
			String Returndate, String ApplicantPOC, String PortOfExit, String IssueTo, String PortOfEntry, String UnshippedBalance, String FirstExitdate,
			String IdenticalLicNo, String FinalEntryDate, String OtherIdentLicNo, String Commodity, String Applicant_Supplier, String Name, String Address,
			String Address1, String Address2, String City, String State, String Country1, String ZipCode, String Phone, String Port, String PortType, 
			String CountryCode, String CountryType, String ModifiedFlag) {
		
		HomePage_AMPage homePageAm=new HomePage_AMPage(driver, test);
		SearchAuthorisationPage searchAM=new SearchAuthorisationPage(driver, test);
		AddAuthorizationSelectSBUPage selectSBU=new AddAuthorizationSelectSBUPage(driver, test);
		AuthorizationHeaderTemplatePage template=new AuthorizationHeaderTemplatePage(driver, test);
		CreateNewAuthorisationPage create=new CreateNewAuthorisationPage(driver, test);
		EditAuthorisationPage edit = new EditAuthorisationPage(driver, test);
		View_EditLicenseDetailsPage viewEdit = new View_EditLicenseDetailsPage(driver, test);
		CreateNewAuthorizationPortPage portPage = new CreateNewAuthorizationPortPage(driver, test);
		CreateNewAuthorizationCountryPage countryPage =new CreateNewAuthorizationCountryPage(driver, test);
	
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePageAm.move_to_moduleSelection(SBU);
					Wait.waitfor(3);
					homePageAm.moduleSelection();
					homePageAm.clickonAddViewEdit();
					searchAM.addAuthorization();
					selectSBU.selectSBU(autorizationType);
					template.newTemplate();
					create.headerDetails(ActivityType, RequestID, ReferenceID, Status, AuthorisationPurpose, 
							FolderId, Summary, Programme, Segment, Site, Country, SalesOrderNo, ContractNo, RequestorName,
							OwnerName, RequestorEmail, OwnerEmail, RequestorPhone, OwnerPhone);
					create.agencyAuthorization(Agency, dateinitiated, Signaturedate, Submitdate, CaseNo, LicenseNo, 
							RelatedAuth, Issuedate, Expirydate, Closuredate);
					create.save();
					Wait.waitfor(5);
					edit.authorizationDetails();
					Wait.waitfor(3);
					viewEdit.authorizationDetails(TransactionType, LicenseTolerance, TECC, Originator, GovtPOC, Returnabledate,
							Returndate, ApplicantPOC, PortOfExit, IssueTo, PortOfEntry, UnshippedBalance, FirstExitdate, 
							IdenticalLicNo, FinalEntryDate, OtherIdentLicNo, Commodity);
					viewEdit.appicantDetails(Applicant_Supplier, Name, Address, Address1, Address2, City, State, Country1, ZipCode, Phone);
					viewEdit.port();
					portPage.port(Port, PortType);
					portPage.saveandreturn();
					viewEdit.country();
					countryPage.newAuthCountry(CountryCode, CountryType, ModifiedFlag);
					countryPage.saveandreturn();
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
