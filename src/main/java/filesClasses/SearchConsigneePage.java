package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchConsigneePage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;
	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_Homepage_module = "//ul[@class='nav navbar-nav']/li[2]/a";
	public static final String OCR_WatchlistScreening_module = "//a[contains (text(),'Watch List Screening')][1]";
	public static final String OCR_SearchFiles = "//ul[@class='nav navbar-nav']/li[5]/a";
	public static final String OCR_searchFiles_consingee = "//a[@class='dropdown-item'][@data-ocr-role='menu-link'][@xpath='1']";
	public static final String OCR_SearchConsignee_SBUCode = "//select[@id='searchConsignee_consignee_sbuCode']";
	public static final String OCR_SearchConsgnees_militiaryGoods = "//input[@id='searchConsignee_useForDos']";
	public static final String OCR_SearchConsignees_dualUse = "//input[@id='searchConsignee_useForDoc']";
	public static final String OCR_SearhConsigness_AES = "//input[@id='searchConsignee_useForDoc']";
	public static final String OCR_SearchConsignees_ID = "//input[@id='searchConsignee_consignee_consigneeId']";
	public static final String OCR_SearchConsignees_Name = "//input[@id='searchConsignee_consignee_consigneeName']";
	public static final String OCR_SearchConsignees_Country = "//input[@id='searchConsignee_countryName']";
	public static final String OCR_Searchconsignees_Status = "//select[@id='searchConsignee_consignee_status']";
	public static final String OCR_SearchConsignees_Zip = "//input[@id='searchConsignee_consignee_zip']";
	public static final String OCR_SearchConsignees_Active = "//select[@id='searchConsignee_consignee_active']";
	public static final String OCR_SearchConsignees_MT = "//select[@id='searchConsignee_consignee_mt']";
	public static final String OCR_SearchConsignees_CB = "//select[@id='searchConsignee_consignee_cb']";
	public static final String OCR_SearchConsignees_NS = "//select[@id='searchConsignee_consignee_ns']";
	public static final String OCR_SearchConsigneesFC = "//select[@id='searchConsignee_consignee_fc']";
	public static final String OCR_SearchConsignees_Related = "//select[@id='searchConsignee_consignee_related']";
	public static final String OCR_SearchConsignees_NP = "//select[@id='searchConsignee_consignee_np']";
	public static final String OCR_SearchConsignees_RS = "//select[@id='searchConsignee_consignee_rs']";
	public static final String OCR_SearchConsignees_CC = "//select[@id='searchConsignee_consignee_cc']";
	public static final String OCR_SearchConsignees_AT = "//select[@id='searchConsignee_consignee_at']";
	public static final String OCR_SearchConsignees_salesPerson = "//input[@id='searchConsignee_consignee_salesPerson']";
	public static final String OCR_SearchConsignees_typeOfConsignee = "//select[@id='searchConsignee_consignee_typeOfConsignee']";
	public static final String OCR_SearchConsignees_FullyorpartiallyOwnedBYGov = "//select[@id='searchConsignee_consignee_ownedByGovt']";
	public static final String OCR_SearchConsignees_WilConsgneInteractWdGOVt1 = "//select[@id='searchConsignee_consignee_interactWithGovt']";
	public static final String OCR_SearchConsignees_avi_military_endUse = "//select[@id='searchConsignee_consignee_aviationMilNucEndUse']";
	public static final String OCR_SearchConsignees_OrgContactForConsinee = "//input[@id='searchConsignee_consignee_contact']";
	public static final String OCR_SearchConsignees_POorSignedContract = "//select[@id='searchConsignee_consignee_signedContract']";
	public static final String OCR_SearchConsignees_EstMSalesOrSpendUSD = "//input[@id='searchConsignee_consignee_estimatedSalesSpendsUSD']";
	public static final String OCR_SearchConsignees_STAletterRequired = "//input[@id='searchConsignee_staLetterRequired']";
	public static final String OCR_SearchConsignees_STAletterObtained = "//select[@id='searchConsignee_consignee_staLetterObtained']";
	public static final String OCR_SearchConsignees_CreatedBy = "//a[contains(text(),'Created By')]";
	public static final String OCR_SearchConsignees_UserFname = "//input[@id='searchForm_userProfile_userFirstname']";
	public static final String OCR_SearchConsignees_UpdatedBy = "//a[contains(text(),'Updated By')]";
	public static final String OCR_SearchConsignees_OverriddenBy = "//a[contains(text(),'Overridden By')]";
	public static final String OCR_SearchConsignee_Select = "(//button[@class='primary-btn recordFromPopup'])[1]";
	public static final String OCR_SearchConsignee_SearchButton = "//button[@name='Search']";
	public static final String OCR_SearchConsignee_popupClose = "(//button[@class='btn-close'])[1]";
	public static final String OCR_SearchConsignees_SortBy = "//select[@id='consigneeSortBy']";
	public static final String OCR_SearchConsignees_Direction = "//select[@id='consigneeDirection']";
	public static final String OCR_SearchConsignees_EnduserStartDate = "//input[@id='searchConsignee_fromUserReviewDate']";
	public static final String OCR_SearchConsignees_EndUserEndDate = "//input[@id='searchConsignee_toUserReviewDate']";
	public static final String OCR_SearchConsignees_createdonStartDate = "//input[@id='searchConsignee_fromCreationDate']";
	public static final String OCR_SearchConsignees_CreatedOnEndDate = "//input[@id='searchConsignee_toCreationDate']";
	public static final String OCR_SearchConsignees_updatedonstartDate = "//input[@id='searchConsignee_fromModifiedOn']";
	public static final String OCR_SearchConsignees_updatedonEnddate = "//input[@id='searchConsignee_toModifiedOn']";
	public static final String OCR_SearchConsignees_screeneddonStartDate = "//input[@id='searchConsignee_fromScreenedOn']";
	public static final String OCR_SearchConsignees_screenedonEndDate = "//input[@id='searchConsignee_toScreenedOn']";
	public static final String OCR_SearchConsignees_MainSearch = "//button[contains(text(),'Search')]";
	public static final String OCR_SearchConsignees_AddConsignee = "//button[contains(text(),'Add Consignee')]";

	/*
	 * ****************************** Constructor *********************************
	 */
	public SearchConsigneePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

	}
	/* ******************************* Actions ********************************* */
	// Enter Search Products

	public void SearchConsigneeDetails(String SBUCode, String ID, String Name, String Country, String ZIP,
			String Status, String Active, String MT, String NS, String CB, String Related, String FC, String NP,
			String RS, String CC, String AT, String SalesPerson, String TypeOFConsignee,
			String FullyOrPartillyOwnedByGovt, String WillConsigneeInteractwdGovt, String PoOrSignedContract,
			String OrgContactForConsignee, String EstmSalesInUSD, String STAletterObtained, String CreatedUserFname,
			String aviMilitaryEnduse, String UpdatedBy, String OverriddenBy, String SortBy,
			String EndUserDateFrom, String EndUserDateTo, String CreatedOnDateFrom, String UpdatedondateFrom,
			String ScreenedonDateFrom, String Direction, String CreatedOnDateTo, String UpdatedOnDateTo) {

		selectByVisibleText(driver, test, OCR_SearchConsignee_SBUCode, "Select SBU Code", SBUCode);

		Wait.waitfor(3);
		typeText(driver, test, OCR_SearchConsignees_ID, "enter ID", ID);
		typeText(driver, test, OCR_SearchConsignees_Name, "Enter Name", Name);
		typeText(driver, test, OCR_SearchConsignees_Country, "Enter Country", Country);
		typeText(driver, test, OCR_SearchConsignees_Zip, "Enter Zip", ZIP);
		selectByVisibleText(driver, test, OCR_Searchconsignees_Status, "Select Status", Status);
		selectByVisibleText(driver, test, OCR_SearchConsignees_Active, "Select Value", Active);
		selectByVisibleText(driver, test, OCR_SearchConsignees_MT, "Select Value", MT);
		selectByVisibleText(driver, test, OCR_SearchConsignees_CB, "Select Value", CB);
		selectByVisibleText(driver, test, OCR_SearchConsignees_NS, "Select Value", NS);
		selectByVisibleText(driver, test, OCR_SearchConsigneesFC, "Select Value", FC);
		selectByVisibleText(driver, test, OCR_SearchConsignees_Related, "Select Value", Related);
		selectByVisibleText(driver, test, OCR_SearchConsignees_NP, "Select Value", NP);
		selectByVisibleText(driver, test, OCR_SearchConsignees_RS, "Select Value", RS);
		selectByVisibleText(driver, test, OCR_SearchConsignees_CC, "Select Value", CC);
		selectByVisibleText(driver, test, OCR_SearchConsignees_AT, "Select Value", AT);
		typeText(driver, test, OCR_SearchConsignees_salesPerson, "Enter sales person", SalesPerson);
		selectByVisibleText(driver, test, OCR_SearchConsignees_typeOfConsignee, "Select type of consignee",
				TypeOFConsignee);
		selectByVisibleText(driver, test, OCR_SearchConsignees_FullyorpartiallyOwnedBYGov,
				"Select FulloR Partially owenedBy Govt", FullyOrPartillyOwnedByGovt);
		selectByVisibleText(driver, test, OCR_SearchConsignees_WilConsgneInteractWdGOVt1,
				"Select will ConsgneeinteractWdGovt", WillConsigneeInteractwdGovt);
		selectByVisibleText(driver, test, OCR_SearchConsignees_avi_military_endUse, "Select Avi Military EndUse",
				aviMilitaryEnduse);
		//scrollToBottom(driver);
		Wait.waitfor(2);
		typeText(driver, test, OCR_SearchConsignees_OrgContactForConsinee, "Enter Org ContactForConsignee",
				OrgContactForConsignee);
		selectByVisibleText(driver, test, OCR_SearchConsignees_POorSignedContract, "Select PoOrSigned Contract",
				PoOrSignedContract);
		typeText(driver, test, OCR_SearchConsignees_EstMSalesOrSpendUSD, "Enter Estimated sales in USD",
				EstmSalesInUSD);
		selectByVisibleText(driver, test, OCR_SearchConsignees_STAletterObtained, "Select STA letter Obtained",
				STAletterObtained);
		//scrollToBottom(driver); Wait.waitfor(2);
		if (CreatedUserFname.length() > 0) {

			Wait.waitfor(3);
			clickElement(driver, test, OCR_SearchConsignees_CreatedBy, "click on Created By");
			try {
				typeText(driver, test, OCR_SearchConsignees_UserFname, "Enter user : ", CreatedUserFname);
				clickElement(driver, test, OCR_SearchConsignee_SearchButton, "Click on search button");
				Wait.waitfor(3);
			String User1 = "//td[contains(text(),'" + CreatedUserFname + "')]";
			System.out.println(User1);
				clickElement(driver, test, User1, "Click User :" +CreatedUserFname );
				clickElement(driver, test, OCR_SearchConsignee_Select, "Click on search user Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Created By ");
				clickElement(driver, test, OCR_SearchConsignee_popupClose, "Close the popup");
			}
		}
		if (UpdatedBy.length() > 0) {

			Wait.waitfor(3);
			clickElement(driver, test, OCR_SearchConsignees_UpdatedBy, "click on Updated By");
			try {
				typeText(driver, test, OCR_SearchConsignees_UserFname, "Enter user", CreatedUserFname);
				clickElement(driver, test, OCR_SearchConsignee_SearchButton, "Click on search button");
				String User1 = "//td[contains(text(),'" + CreatedUserFname + "')]";
				clickElement(driver, test, User1, "Click User :" + CreatedUserFname);
				clickElement(driver, test, OCR_SearchConsignee_Select, "Click on search user Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Updated By ");
				clickElement(driver, test, OCR_SearchConsignee_popupClose, "Close the popup");
			}
		}
		if (OverriddenBy.length() > 0) {

			Wait.waitfor(3);
			clickElement(driver, test, OCR_SearchConsignees_OverriddenBy, "click on Overridden By");
			try {
				typeText(driver, test, CreatedUserFname, "Enter user", CreatedUserFname);
				clickElement(driver, test, OCR_SearchConsignee_SearchButton, "Click on search button");
				String User1 = "//td[contains(text(),'" + CreatedUserFname + "')]";
				clickElement(driver, test, User1, "Click User :" + CreatedUserFname);
				clickElement(driver, test, OCR_SearchConsignee_Select, "Click on search user Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Overridden By ");
				clickElement(driver, test, OCR_SearchConsignee_popupClose, "Close the popup");
			}
		}
		selectByVisibleText(driver, test, OCR_SearchConsignees_SortBy, "Select Sort By", SortBy);

		if (EndUserDateFrom.length() > 0) {
			clickElement(driver, test, OCR_SearchConsignees_EnduserStartDate, "Click on End User Date From");
			date(driver, test, "Selected on EndUser Date From : ", EndUserDateFrom);
			test.log(LogStatus.PASS, "Selected on EndUser Date From : " + EndUserDateFrom);
			clickElement(driver, test, OCR_SearchConsignees_EndUserEndDate, "Click on EndUser Date To");
			date(driver, test, "Selected on Enduser Date To : ", EndUserDateTo);
			test.log(LogStatus.PASS, "Selected on EndUser Date To : " + EndUserDateTo);
		}
		if (CreatedOnDateFrom.length() > 0) {
			clickElement(driver, test, OCR_SearchConsignees_createdonStartDate, "Click on CreatedOn Date From");
			date(driver, test, "Selected on CreatedOn Date From : ", CreatedOnDateFrom);
			test.log(LogStatus.PASS, "Selected on CreatedOn Date From : " + CreatedOnDateFrom);
			clickElement(driver, test, OCR_SearchConsignees_CreatedOnEndDate, "Click on CreatedOn  Date To");
			date(driver, test, "Selected on CreatedOn Date To : ", CreatedOnDateTo);
			test.log(LogStatus.PASS, "Selected on Createdon Date To : " + CreatedOnDateTo);
		}
		if (UpdatedondateFrom.length() > 0) {
			clickElement(driver, test, OCR_SearchConsignees_updatedonstartDate, "Click on UpdatedOn Date From");
			date(driver, test, "Selected on UpdatedOn Date From : ", UpdatedondateFrom);
			test.log(LogStatus.PASS, "Selected on UpdatedOn Date From : " + UpdatedondateFrom);
			clickElement(driver, test, OCR_SearchConsignees_updatedonEnddate, "Click on UpdatedOn  Date To");
			date(driver, test, "Selected on UpdatedOn Date To : ", UpdatedOnDateTo);
			test.log(LogStatus.PASS, "Selected on Updated Date To : " + UpdatedOnDateTo);
		}

		selectByVisibleText(driver, test, OCR_SearchConsignees_Direction, "Select Direction", Direction);
	}

	/*
	scrollToTop(driver); Wait.waitfor(2);
	 */
	// Click on Search Button
	public void Click_Consigneesearch() {
		//Wait.waitfor(3);
		//scrollToElement(driver, OCR_SearchConsignees_MainSearch);
	//Wait.waitfor(3);
		clickElement(driver, test, OCR_SearchConsignees_MainSearch, "Click on Search Button");

	}

	public void click_AddConsingee() {
		clickElement(driver, test, OCR_SearchConsignees_AddConsignee, "Click on add consignee");
	}

	public void SearchThroughId(String ConsigneeID) {
		typeText(driver, test, OCR_SearchConsignees_ID, "Enter consignee ID", ConsigneeID);

	}

}
