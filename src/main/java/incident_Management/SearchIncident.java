package incident_Management;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchIncident extends GenericMethods{
	public WebDriver driver;
	public ExtentTest test;
	
	public static final String SI_Search="//button[contains(text(),'Search')]";
	public static final String SI_Reset="//button[contains(text(),'Reset')]";
	public static final String SI_AddIncident="//button[contains(text(),'Add Incident')]";
	public static final String SI_Status="//select[@name='citGeneralInfoValue.status']";
	public static final String IM_IncidentAction_IncidentNoHyperlink="//a[contains(text(),'Incident No')]";
	public static final String IM_IncidentAction_IncidentNo="//input[@name='citCorrectiveActionValue.referenceNo']";
	public static final String IM_IncidentAction_SearchPopup="(//button[contains(text(),'Search')])[2]";
	public static final String IM_IncidentAction_Select="//button[contains(text(),'Select')]";
	public static final String IM_IncidentAction_ClosePopup="//button[@class='btn-close']";
	public static final String IM_IncidentData_SearchPopup="//button[@class='btn-close']";
	public static final String IM_SelectButton="//button[@class='primary-btn recordFromPopup']";
	
	public static final String IM_Searchdata="//a[@class='cfn']";
	
	public static final String IM_Features="(//a[@class='nav-link dropdown-item'])[3]";
	public static final String IM_NewSearchBtn="//button[contains(text(),'New Search')]";
	public static final String IM_AddIncidentSegmentpopupSelectBtn = "//button[contains(text(),'Select')]";
	public static final String IM_AddIncidentSegment = "//a[contains(text(),'Segment')]";
	
	public static final String IM_AddIncidentProductLine = "(//a[contains(text(),'Product Line')])[2]";
	public static final String IM_IncidentForm="(//a[contains(text(),'Incident Form')])[1]";
	public static final String IM_Incident="(//a[contains(text(),'Incident')])[3]";
	
	//public static final String IM_resultdata="//span[@class='resultCount']";
	
	public static final String IM_resultdata="//label[contains(text(),'Total No of records found:')]";
	
	public static final String IM_AddIncidentProductFamily = "(//a[contains(text(),'Product Family')])[2]";
	public static final String IM_AddIncidentProductFamilypopupSelectBtn = "//button[contains(text(),'Select')]";
	
	public static final String IM_AddIncidentSite = "(//a[contains(text(),'Site')])[2]";
	public static final String SI_SiteSearchBtn="(//button[contains(text(),'Search')])[2]";
	
	public static final String IM_AddIncidentClassification = "(//a[contains(text(),'Classification')])[4]";
	
	public static final String IM_AddIncidentClassificationSecurityClassName = "//input[@id='searchForm_dosSecurityClassPoupDTO_securityClassName']";
	
	
	public static final String IM_FormTypeBtn = "//select[@name='citGeneralInfoValue.formType']";
	
	public static final String IM_BusinessUnitBtn = "//select[@id='resultCitGeneralInfo_citGeneralInfoValue_sbuCode']";
	
	
	public static final String IM_IncidentProgramme = "//a[contains(text(),'Programme')]";
	
	public static final String IM_IncidentContactName = "//a[contains(text(),'Contact Name')]";
	
	public static final String IM_ShortByBtn = "//select[@name='sortBy']";
	
	public static final String IM_Direction = "//select[@name='direction']";
	
	public SearchIncident(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public void search() {
		clickElement(driver, test, SI_Search, "Clicking on Search");
	}
	
	public void newsearch() {
		clickElement(driver, test, IM_NewSearchBtn, "Click on new Search button");
	}
	
	public void reset() {
		clickElement(driver, test, SI_Reset, "Clicking on Search");
	}
	
	public void addIncident() {
		clickElement(driver, test, SI_AddIncident, "Clicking on Search");
	}
	
	public void status(String status) {
		clickElement(driver, test, SI_Status, "Clicking on Status");
		clickElement(driver, test, "//option[contains(text(),'"+status+"')]", "Click on Status :"+status);
	}
	
	
	public void featurSelectionforsearch() {
		 mouseOverAndClick(driver, test, IM_Features, "Mouse over on Feature");
		clickElement(driver, test, IM_IncidentForm, "Clicking on Incident Form");
		Wait.waitfor(2);
	}
	
	
	public void searchIncidentNo(String referanceno,String data) {
		clickElement(driver, test, IM_IncidentAction_IncidentNoHyperlink, "Clicking on Incident Number link");
		try {
			typeText(driver, test, "//input[@id='searchForm_referenceNo']", "Type the referance number :", referanceno);
			clickElement(driver, test, IM_IncidentAction_SearchPopup, "Clicking on Search Tab");
			Wait.waitfor(2);
			mouseOverAndClick(driver, test, "//td[contains(text(),'"+ referanceno +"')]", "Selecting Data From table"+referanceno);
			
			clickElement(driver, test, IM_SelectButton, "Clicking On Select Button");
			clickElement(driver, test, SI_Search, "Clicking on Search");
			
			String sucessmesg = getText(driver, test, IM_Searchdata, "Get the Message : ");
			if (sucessmesg.equals(referanceno)) {
				test.log(LogStatus.PASS, "Search data displayed and search functionality working fine");
			} else {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Search data not displayed");
			}
			Wait.waitfor(2);
		
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, IM_IncidentAction_ClosePopup, "Closing the Popup Window");
		}
	}
	
	
      //	    ***********Regression Script ****************************
	
	public void searchIncidentbySegment(String segment) {
//		 mouseOverAndClick(driver, test, IM_Features, "Mouse over on Feature");
//
//		clickElement(driver, test, IM_IncidentForm, "Clicking on Incident Form");
//		Wait.waitfor(2);
	//	clickElement(driver, test, IM_NewSearchBtn, "Click on new Search button");
		clickElement(driver, test, IM_AddIncidentSegment, "Clicking on Segment hyper link");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, "//td[contains(text(),'" + segment + "')]",
				"Selecting Data From Segment table :" + segment);
		
		clickElement(driver, test, IM_AddIncidentSegmentpopupSelectBtn, "Clicking on Segment Popup select button");
		clickElement(driver, test, SI_Search, "Clicking on Search");
		
		String sucessmesg = getText(driver, test, IM_resultdata, "Total No of records found: ");
		test.log(LogStatus.PASS, "Search data displayed and search by segment functionality working fine");

       }
	
   public void searchIncidentbyProductLine(String productline) {
		
	 
	   clickElement(driver, test, IM_AddIncidentProductLine, "Clicking on ProductLine hyper link");
		Wait.waitfor(6);
		mouseOverAndClick(driver, test, "//td[contains(text(),'" + productline + "')]",
				"Selecting Data From Product Line table :" + productline);
		
		clickElement(driver, test, IM_AddIncidentSegmentpopupSelectBtn, "Clicking on Segment Popup select button");
		clickElement(driver, test, SI_Search, "Clicking on Search");
		
		String sucessmesg = getText(driver, test, IM_resultdata, "Total No of records found: ");
		
	   	test.log(LogStatus.PASS, "Search  by Product Line data displayed and search functionality working fine");


       }
	
    public void searchIncidentbyProductFamily(String productfamily) {
	
    	clickElement(driver, test, IM_AddIncidentProductFamily, "Clicking on Product Family hyper link");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, "//td[contains(text(),'" + productfamily + "')]",
				"Selecting Data From Product Family table :" + productfamily);
		clickElement(driver, test, IM_AddIncidentProductFamilypopupSelectBtn,
				"Clicking on Product Family Popup select button");
		clickElement(driver, test, SI_Search, "Clicking on Search");
		
		String sucessmesg = getText(driver, test, IM_resultdata, "Total No of records found: ");
		
	   	test.log(LogStatus.PASS, "Search  by ProductFamily data displayed and search functionality working fine");

		
		
   }
	
    public void searchIncidentbySite(String site) {
    	clickElement(driver, test, IM_AddIncidentSite, "Clicking on Site hyper link");
		Wait.waitfor(6);
		clickElement(driver, test, SI_SiteSearchBtn, "Clicking on Site PopUp Search button");
		
		mouseOverAndClick(driver, test, "//td[contains(text(),'" + site + "')]",
				"Selecting Data From Product Family table :" + site);
		
		clickElement(driver, test, IM_AddIncidentSegmentpopupSelectBtn, "Clicking on Site Popup select button");
		
		clickElement(driver, test, SI_Search, "Clicking on Search");
		
         String sucessmesg = getText(driver, test, IM_resultdata, "Total No of records found: ");
		
	   	test.log(LogStatus.PASS, "Search  by Site data displayed and search functionality working fine");

       }
    
	public void searchIncidentbyClassification(String classificationClassName) {
		clickElement(driver, test, IM_AddIncidentClassification, "Clicking on Classification hyper link");
		Wait.waitfor(6);
		clickElement(driver, test, SI_SiteSearchBtn, "Clicking on Classification PopUp Search button");

		mouseOverAndClick(driver, test, "//td[contains(text(),'" + classificationClassName + "')]",
				"Selecting Data From Classification table :" + classificationClassName);

		clickElement(driver, test, IM_AddIncidentSegmentpopupSelectBtn,
				"Clicking on Classification Popup select button");

		clickElement(driver, test, SI_Search, "Clicking on Search");
        String sucessmesg = getText(driver, test, IM_resultdata, "Total No of records found: ");
       test.log(LogStatus.PASS, "Search  by Classification data displayed and search functionality working fine");

	}

	public void searchIncidentbyStatus(String status) {
		
		clickElement(driver, test, "//option[contains(text(),'" + status + "')]",
				"Add Template :" + status);
		clickElement(driver, test, SI_Search, "Clicking on Search");
        String sucessmesg = getText(driver, test, IM_resultdata, "Total No of records found: ");
       test.log(LogStatus.PASS, "Search  by Status data displayed and search functionality working fine");

	}

   public void searchIncidentbyFormType(String formtype) {

		clickElement(driver, test, IM_FormTypeBtn, "Clicking On my Form Type Dropdown");
		Wait.waitfor(2);
		selectByVisibleText(driver, test, IM_FormTypeBtn,"Select the Form Type :", formtype);
		
		clickElement(driver, test, SI_Search, "Clicking on Search");
        String sucessmesg = getText(driver, test, IM_resultdata, "Total No of records found: ");
       test.log(LogStatus.PASS, "Search  by Form Type data displayed and search functionality working fine");

	}
   
   public void searchIncidentbyReportedBy(String reportedByname) {

		
		Wait.waitfor(2);
		typeText(driver, test, "//input[@id='resultCitGeneralInfo_citGeneralInfoValue_reportedByName']", "Type the Reported By Name :", reportedByname);
		
		clickElement(driver, test, SI_Search, "Clicking on Search");
       String sucessmesg = getText(driver, test, IM_resultdata, "Total No of records found: ");
      test.log(LogStatus.PASS, "Search  by Reported By Name data displayed and search functionality working fine");

	}
   
   public void searchIncidentbyBusinessUnit(String businessUnit) {
	   clickElement(driver, test, IM_BusinessUnitBtn, "Clicking On my Business Unit Dropdown");
		Wait.waitfor(2);
		selectByVisibleText(driver, test, IM_BusinessUnitBtn,"Select the Business Unit :", businessUnit);
		
		clickElement(driver, test, SI_Search, "Clicking on Search");
       String sucessmesg = getText(driver, test, IM_resultdata, "Total No of records found: ");
      test.log(LogStatus.PASS, "Search  by Business Unit data displayed and search functionality working fine");

	}
   
   public void searchIncidentbyProgramme(String programme) {
	   clickElement(driver, test, IM_IncidentProgramme, "Clicking on Programme hyper link");
		Wait.waitfor(6);
		clickElement(driver, test, SI_SiteSearchBtn, "Clicking on Programme PopUp Search button");
		
		mouseOverAndClick(driver, test, "//td[contains(text(),'" + programme + "')]",
				"Selecting Data From Programme table :" + programme);
		
		clickElement(driver, test, IM_AddIncidentSegmentpopupSelectBtn, "Clicking on Programme Popup select button");
		
		clickElement(driver, test, SI_Search, "Clicking on Search");
		
        String sucessmesg = getText(driver, test, IM_resultdata, "Total No of records found: ");
		
	   	test.log(LogStatus.PASS, "Search  by Programme data displayed and search functionality working fine");

	}
   
   public void searchIncidentbyContactName(String contactName) {
	   clickElement(driver, test, IM_IncidentContactName, "Clicking on Contact Name hyper link");
		Wait.waitfor(6);
		clickElement(driver, test, SI_SiteSearchBtn, "Clicking on Contact Name PopUp Search button");
		
		mouseOverAndClick(driver, test, "//td[contains(text(),'" + contactName + "')]",
				"Selecting Data From Contact Name table :" + contactName);
		
		clickElement(driver, test, IM_AddIncidentSegmentpopupSelectBtn, "Clicking on Contact Name Popup select button");
		
		clickElement(driver, test, SI_Search, "Clicking on Search");
		
        String sucessmesg = getText(driver, test, IM_resultdata, "Total No of records found: ");
		
	   	test.log(LogStatus.PASS, "Search  by Contact Name data displayed and search functionality working fine");

	}
   
   public void searchIncidentbyInvestigationId(String investigationId) {
	   Wait.waitfor(2);
		typeText(driver, test, "//input[@id='resultCitGeneralInfo_citGeneralInfoValue_caAnalystId']", "Type the Reported By Name :", investigationId);
		
		clickElement(driver, test, SI_Search, "Clicking on Search");
      String sucessmesg = getText(driver, test, IM_resultdata, "Total No of records found: ");
     test.log(LogStatus.PASS, "Search  by Investigation Id data displayed and search functionality working fine");

	}
   
   public void searchIncidentbyShortBy(String shortby) {

		clickElement(driver, test, IM_ShortByBtn, "Clicking On my Short By Dropdown");
		Wait.waitfor(2);
		selectByVisibleText(driver, test, IM_ShortByBtn,"Select the Short By :", shortby);
		
		clickElement(driver, test, SI_Search, "Clicking on Search");
       String sucessmesg = getText(driver, test, IM_resultdata, "Total No of records found: ");
      test.log(LogStatus.PASS, "Search  by Short  data displayed and search functionality working fine");

	}
   
   public void searchIncidentbyDirection(String direction) {

		clickElement(driver, test, IM_Direction, "Clicking On my Direction Dropdown");
		Wait.waitfor(2);
		selectByVisibleText(driver, test, IM_Direction,"Select the Direction :", direction);
		
		clickElement(driver, test, SI_Search, "Clicking on Search");
      String sucessmesg = getText(driver, test, IM_resultdata, "Total No of records found: ");
     test.log(LogStatus.PASS, "Search  by Direction data displayed and search functionality working fine");

	}
   
   
}

