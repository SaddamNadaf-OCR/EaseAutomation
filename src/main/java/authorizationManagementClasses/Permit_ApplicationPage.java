package authorizationManagementClasses;


import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;


public class Permit_ApplicationPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	
	public static final String Auth_Mana_Heading="//h3[contains(text(),'Search Authorization')]";
	public static final String Auth_Mana_SearchTab="(//button[@name='Search'])[1]";
	public static final String Auth_Mana_Add_Authorization="(//button[@name='Add'])[1]";
	public static final String Auth_Mana_UploadExistingAuth="//button[contains(text(),'Upload Existing Authorizations')]";
	public static final String Auth_Mana_ExcelSheet="//body/div[@id='content-cont']/form[@id='searchAuthorisation']/div[2]/div[1]/div[2]/div[1]/a[1]/i[1]";
	public static final String Auth_Mana_Reset="(//button[@name='Reset'])[1]";
	public static final String Auth_Mana_AuthGrantedByCountry="(//input[@name='authGrantedByCountryName'])[1]";
	public static final String Auth_Mana_AuthrizationType="//a[@id='stdLicenseTypes-popup']";
	public static final String Auth_Mana_AuthorizationType1="(//input[@name='authorisationHeader.authorisationType'])[1]";
	public static final String Auth_Mana_Country="//select[@id='encryptedCountryCode']";
	public static final String Auth_Mana_SBUCODE="(//select[@name='authorisationHeader.sbuCode'])[1]";
	public static final String Auth_Mana_ReferanceID="//input[@name='authorisationHeader.referenceId']";
	public static final String Auth_Mana_FolderID="//a[contains(text(),'Folder ID')]";
	public static final String Auth_Mana_FolderID1="//body/div[@id='content-cont']/form[@id='searchAuthorisation']/div[2]/div[1]/div[6]/div[1]/fieldset[1]/div[5]/div[1]/div[1]/div[1]/input[1]";
	public static final String Auth_Mana_FolderID2="//body/div[@id='content-cont']/form[@id='searchAuthorisation']/div[2]/div[1]/div[6]/div[1]/fieldset[1]/div[5]/div[1]/div[1]/div[2]";
	public static final String Auth_Mana_Status="//select[@name='authorisationHeader.status']";
	public static final String Auth_Mana_WLS_Status="//select[@name='authorisationHeader.dplStatus']";
	public static final String Auth_Mana_AuthorizationPurpose="//a[@id='purposeId']";
	public static final String Auth_Mana_AuthorizationPurpose1="//input[@name='authorisationHeader.authorisationPurpose']";
	public static final String Auth_Mana_Program="//a[(contains(text(),'  Program'))]";
	public static final String Auth_Mana_Programe1="//textarea[@id='searchAuthorisation_authorisationHeader_programCode']";
	public static final String Auth_Mana_Segment="//a[(contains(text(),' Segment'))]";
	public static final String Auth_Mana_Segment1="//textarea[@id='searchAuthorisation_authorisationHeader_segmentCode']";
	public static final String Auth_Mana_CaseNo="//input[@name='authorisationHeader.caseNumber']";
	public static final String Auth_Mana_AuthorizationNumber="//a[@id='licenseNo-Popup']";
	public static final String Auth_Mana_AuthorizationNumber1="//input[@name='authorisationHeader.authorisationNumber']";
	public static final String Auth_Mana_RequesterName="//a[contains(text(),'Requestor Name')]";
	public static final String Auth_Mana_RequesterName1="//input[@name='authorisationHeader.requestorName']";
	public static final String Auth_Mana_ReviewName="//a[(contains(text(),'Reviewer Name'))]";
	public static final String Auth_Mana_reviewName1="//input[@name='authorisationHeader.reviewerName']";
	public static final String Auth_Mnan_SumittedReviewDateFrom="//input[@id='dp1674026698989']";
	public static final String Auth_Mnan_SubmittedRevievDateFrom1="//input[@id='dp1674026698990']";
	public static final String Auth_Mnan_ReviewCompleteDate="//input[@id='dp1674026698990']";
	public static final String Auth_Mnan_ReviewCompleteDate1="//input[@id='dp1674026698992']";
	public static final String Auth_Mnan_ApplicationSubmittedDate="//input[@id='dp1674026698993']";
	public static final String Auth_Mnan_ApplicationSubmittedDate1="//input[@id='dp1674026698994']";
	public static final String Auth_Mnan_IssueDate="//input[@id='dp1674026698994']";
	public static final String Auth_Mnan_IsssueDate1="//input[@id='dp1674026698996']";
	public static final String Auth_Mnan_ExpiryDate="//input[@id='dp1674026698997']";
	public static final String Auth_Mnan_ExpiryDate1="//input[@id='dp1674026698998']";
	public static final String Auth_Mnan_CreatedBy="//a[contains(text(),'Created By')]";
	public static final String Auth_Mnan_CreatedBy1="//input[@name='authorisationHeader.createdBy']";
	public static final String Auth_Mana_CreatedDate="//input[@id='dp1674026698999']";
	public static final String Auth_Mana_CreatedDate1="//input[@id='dp1674026699000']";
	public static final String Auth_Mana_ModifiedBy="//a[contains(text(),'Modified By')]";
	public static final String Auth_Mana_ModifiedBy1="//input[@name='authorisationHeader.modifiedBy']";
	public static final String Auth_Mana_Heading1="//legend[contains(text(),'Authorization Detail Search')]";
	public static final String Auth_Mana_Country1="//input[@name='authorisationCountryName']";
	public static final String Auth_Mana_Consignee="(//a[(contains(text(),'Consignee'))])[4]";
	public static final String Auth_Mana_Consignee1="//input[@name='authorisationConsignee.licConsName']";
	public static final String Auth_Mana_PartDescription="//input[@id='searchAuthorisation_authorisationItem_description']";
	public static final String Auth_Mana_Aplicant_Name="//input[@id='applicant_id']";
	public static final String Auth_Mana_NDA_Required="//input[@id='searchAuthorisation_licConsNDAReq-1']";
	public static final String Auth_Mana_NDA_Received="//input[@id='searchAuthorisation_licConsNDAReceived-1']";
	public static final String Auth_Mana_Search1="(//button[@name='Search'])[2]";
	public static final String Auth_Mana_AddAutorization1="(//button[@name='Add'])[2]";
	public static final String Auth_Mana_Reset1="(//button[@class='ocr-cache-search-dynamic-class'])[2]";
	public static final String Auth_Mana_Logo="(//img[@class='logo'])[1]";
	public static final String Auth_Mana_SmallLogo="(//img[@class='logo'])[2]";
	public static final String Auth_Mana_Text="//li[contains(text(),'OCR GLOBAL EASE(SQL Server 2019_UTF8) DEV SYSTEM V')]";
	public static final String Auth_Mana_Year="//li[contains(text(),'© 2023OCR Services Inc.')]";
	
	
	public Permit_ApplicationPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public void permit_application() {
		
	}
	
	//...............LOGO is Displayed OR not..............//
	public void isDisplayed_LOGO() {
		isDisplayed(driver, Auth_Mana_Logo);
		test.log(LogStatus.PASS, "The Logo Is Displayed");
	}
	
	
	//.........CheckBOX Selected OR Not..................//
	public void isSelected() {
		isSelected(driver, Auth_Mana_NDA_Required);
		test.log(LogStatus.PASS, "CheckBox is Selected");
	}
	
	public void isSelected1() {
		isSelected(driver, Auth_Mana_NDA_Received);
		test.log(LogStatus.PASS, "CheckBox is Selected");
	}

}
