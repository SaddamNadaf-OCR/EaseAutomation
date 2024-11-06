package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class SearchClassifiedLicenseReportPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//...................................Locators.......................................//
	public static final String CR_Search="//button[contains(text(),'Search')]";
	public static final String CR_AddClassifiedLiecanceReport="//button[contains(text(),'Add Classified License Report')]";
	public static final String CR_Reset="//button[contains(text(),'Reset')]";
	public static final String CR_SBU="//select[@name='dosGeneralInfo.sbuCode']";
	public static final String CR_Type="//select[@name='dosGeneralInfo.applFormType']";
	public static final String CR_transactionId="//input[@name='dosGeneralInfo.transactionId']";
	public static final String CR_Program="(//a[contains(text(),'Program')])[3]";
	public static final String CR_Status="//select[@name='dosGeneralInfo.status']";
	public static final String CR_licenseNo="//input[@name='dosGeneralInfo.licenseNo']";
	public static final String CR_SearchPopup="(//button[@name='Search'])[2]";
	public static final String CR_SelectPopup="//button[contains(text(),'Select')]";
	public static final String CR_programCode="//input[@name='programTab.programCode']";
	public static final String CR_programTab="//textarea[@name='dosGeneralInfo.programTab']";
	public static final String CR_userFirstname="//input[@name='userProfile.userFirstname']";
	public static final String CR_Segment="(//a[contains(text(),'Segment')])[2]";
	public static final String CR_segmentCode="//textarea[@name='dosGeneralInfo.segmentCode']";
	public static final String CR_ProductLine="(//a[contains(text(),'Product Line')])";
	public static final String CR_prodLineTextBox="//textarea[@name='dosGeneralInfo.prodLine']";
	public static final String CR_ProductFamily="(//a[contains(text(),'Product Family')])";
	public static final String CR_prodFamilyTextBox="//textarea[@name='dosGeneralInfo.prodFamily']";
	public static final String CR_reportDateFrom="//input[@name='reportDateFrom']";
	public static final String CR_reportDateTo="//input[@name='reportDateTo']";
	public static final String CR_ClassificationLevel="//a[contains(text(),'Classification Level')]";
	public static final String CR_securityClassId="//input[@name='dosSecurityClassPoupDTO.securityClassId']";
	public static final String CR_classificationLevelTextBox="//input[@name='licenseReviewValue.classificationLevel']";
	public static final String CR_sortBy="//select[@name='sortBy']";
	public static final String CR_direction="//select[@name='direction']";
	public static final String USGAR_ClosePopUp="//button[@class='btn-close']";
	
	//.................................Constructor.....................................//
	public SearchClassifiedLicenseReportPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;		
	}

	//.............................Click on Search Tab...................................//
	public void search() {
		clickElement(driver, test, CR_Search, "Clicking on Search Tab");
	}
	
	//...........................Click on Add Classified Licance .....................//
	public void addclassifiedliecance() {
		clickElement(driver, test, CR_AddClassifiedLiecanceReport, "Clicking on Add Classified Button");
	}
	
	//............................Click on Reset Button................................//
	public void reset() {
		clickElement(driver, test, CR_Reset, "Clicking on Reset Tab");
	}
	
	//............................Search By Parameters..................................//
	public void searchByParameters(String sbu, String Type, String TransactionID, String LicenseNO, String Status, String Segment, 
			String Program, String ProductLine, String ProductFamily, String ReportDateFrom, String ReportDateTo, String ClassificationLevel, String SortBy, String Direction) {
		
		selectByVisibleText(driver, test, CR_SBU, "Selecting SBU", sbu);
		selectByVisibleText(driver, test, CR_Type, "Selecting Type :", Type);
		typeText(driver, test, CR_transactionId, "Entering Transaction ID :", TransactionID);
		typeText(driver, test, CR_licenseNo, "Entering License No :", LicenseNO);
		selectByVisibleText(driver, test, CR_Status, "Selecting Status :", Status);
		if(Segment.length() > 0) {
			clickElement(driver, test, CR_Segment, "Clicking on Segment :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Segment+"')]", "Selecting Segment :"+Segment);
				clickElement(driver, test, CR_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, USGAR_ClosePopUp, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, CR_segmentCode, "Entering Segment :", Segment);
		}
		if(Program.length() > 0) {
			clickElement(driver, test, CR_Program, "Clicking on Program :");
			try {
				typeText(driver, test, CR_programCode, "Entering Program :", Program);
				clickElement(driver, test, CR_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Program+"')]", "Selecting Program :"+Program);
				clickElement(driver, test, CR_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, USGAR_ClosePopUp, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, CR_programTab, "Entering Program :", Program);
		}
		if(ProductLine.length() > 0) {
			clickElement(driver, test, CR_ProductLine, "Clicking on ProductLine :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ProductLine+"')]", "Selecting ProductLine :"+ProductLine);
				clickElement(driver, test, CR_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, USGAR_ClosePopUp, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, CR_prodLineTextBox, "Entering ProductLine :", ProductLine);
		}
		if(ProductFamily.length() > 0) {
			clickElement(driver, test, CR_ProductFamily, "Clicking on ProductFamily :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ProductFamily+"')]", "Selecting ProductFamily :"+ProductFamily);
				clickElement(driver, test, CR_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, USGAR_ClosePopUp, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, CR_prodFamilyTextBox, "Entering ProductFamily :", ProductFamily);
		}
		if(ReportDateFrom.length() > 0) {
			clickElement(driver, test, CR_reportDateFrom, "Clicking on Report Date From :");
			dateOfMonthName(driver, test, "Selecting Report Date From :", ReportDateFrom);
		}
		if(ReportDateTo.length() > 0) {
			clickElement(driver, test, CR_reportDateTo, "Clicking on Report Date To :");
			dateOfMonthName(driver, test, "Selecting Report Date To :", ReportDateTo);
		}
		
		if(ClassificationLevel.length() > 0) {
			clickElement(driver, test, CR_ClassificationLevel, "Clicking on Classification Level :");
			try {
				typeText(driver, test, CR_securityClassId, "Entering Classification Level :", ClassificationLevel);
				clickElement(driver, test, CR_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ClassificationLevel+"')]", "Selecting Classification Level :"+ClassificationLevel);
				clickElement(driver, test, CR_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, USGAR_ClosePopUp, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, CR_classificationLevelTextBox, "Entering Classification Level :", ClassificationLevel);
		}
		selectByVisibleText(driver, test, CR_sortBy, "Selecting Sort By :", SortBy);
		selectByVisibleText(driver, test, CR_direction, "Selecting Direction :", Direction);

	}

}
