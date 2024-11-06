package vmsClasses;

import java.util.ArrayList;
import java.util.StringTokenizer;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;

public class DashBoardModePage extends GenericMethods{

	public WebDriver driver;
	public ExtentTest test;

	// ******************** LOCATORS ********************************

	public static final String OCR_DBFDMode_AnticipatedVisitorToday = "//a[@id='selAVPeriod']";
	//public static final String OCR_DBFDMode_AnticipatedVisitorLink = "//label[@class='col-xs-12 anticeptedCount countText']";
	public static final String OCR_DBFDMode_AnticipatedVisitorCount = "//label[@class='col-xs-12 anticeptedCount countText']";
	public static final String OCR_DBFDMode_CheckedInToday = "//a[@id='selCIPeriod']";
	//public static final String OCR_DBFDMode_CheckedInLink = "//label[@class= ' col-xs-12 checkedInCount countText']";
	public static final String OCR_DBFDMode_CheckedInCount = "//label[@class= ' col-xs-12 checkedInCount countText']";
	public static final String OCR_DBFDMode_CheckedOutToday = "//a[@id='selCOPeriod']";
	//public static final String OCR_DBFDMode_CheckedOutLink = "//label[@class= 'col-xs-12 checkedOutCount countText']";
	public static final String OCR_DBFDMode_CheckedOutCount = "//label[@class= ' col-xs-12 checkedOutCount countText']";
	public static final String OCR_DBFDMode_NoShowsToday = "//a[@id='selNSPeriod']";
	public static final String OCR_DBFDMode_NoShowsCount = "//label[@class= ' col-xs-12 noShowsCount countText']";
	public static final String OCR_FrontDesk_BackButton= "//button[@name='back']";
	public static final String OCR_DBFDMode_ScreeningAlertToday = "//a[@id='selSAPeriod']";
	public static final String OCR_DBFDMode_ScreeningAlertCount = "//label[@class= ' col-xs-12 screeningAlertCount countText']";
	public static final String OCR_DBFDMode_CheckedInExpiredToday = "//a[@id='selCIEPeriod']";
	public static final String OCR_DBFDMode_CheckedInExpiredCount = "//label[@class= 'col-xs-12 checkedInExpiredCount countText']";
	public static final String OCR_DBFMode_SiteDropdown = "//select[@id='userSite']";
	public static final String OCR_DBFMode_UncheckShortterm = "//i[@class='fa fa-check-square-o checkedShortTerm']";

	/* ******************** Constructor ***************************** */

	public DashBoardModePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	//******************** Actions *********************************

	//Get text of visitor Start time and end time
	public ArrayList<String> get_VisitorStartTimeEndTime(String VisitFrom) throws InterruptedException {
		String OCR_VMDashBoard_VisitorQueue = "//ul[@class='visitorQueueList list-class']/li/a[contains(text(),'"+VisitFrom+"')]";
		Wait.fluwait(driver, OCR_VMDashBoard_VisitorQueue);	
		Wait.waitfor(3);
		String ActualTime = getText(driver, test, OCR_VMDashBoard_VisitorQueue, "Visitor Start time & End Time : ");		
		if(ActualTime.length() == 15) {
			test.log(LogStatus.PASS, "Actual Time : " + ActualTime);
			String VisitorStartTimeEndTime = ActualTime.substring(0,15);			
			StringTokenizer DBTime = new StringTokenizer(VisitorStartTimeEndTime,"-");
			ArrayList<String> time=new ArrayList<String>();
			while(DBTime.hasMoreElements()) {
				time.add(DBTime.nextToken());
			}
			return time;
		}else if(ActualTime.length() == 16) {				
			test.log(LogStatus.PASS, "Actual Time : " + ActualTime);
			String VisitorStartTimeEndTime = ActualTime.substring(0,16);			
			StringTokenizer DBTime = new StringTokenizer(VisitorStartTimeEndTime,"-");
			ArrayList<String> time=new ArrayList<String>();
			while(DBTime.hasMoreElements()) {
				time.add(DBTime.nextToken());
			}
			return time;
		}else {
			test.log(LogStatus.PASS, "Actual Time : " + ActualTime);
			String VisitorStartTimeEndTime = ActualTime.substring(0,17);			
			StringTokenizer DBTime = new StringTokenizer(VisitorStartTimeEndTime,"-");
			ArrayList<String> time=new ArrayList<String>();
			while(DBTime.hasMoreElements()) {
				time.add(DBTime.nextToken());
			}
			return time;
		}
	}

	// click on AnticipatedToday & AnticipatedVisitorCount
	public String click_AnticipatedToday(String AnticipatedVisitors) {
		clickElement(driver, test, OCR_DBFDMode_AnticipatedVisitorToday,"Clicking on Anticipated Today button");
		String anticipate = "//ul[@id='avList']//a[contains(text(),'"+AnticipatedVisitors+"')]";
		clickElement(driver, test, anticipate,"Selecting Anticipated : "+AnticipatedVisitors);		
		String AnticipatedCount = getText(driver, test, OCR_DBFDMode_AnticipatedVisitorCount, "getting the count of anticipated visitor : ");
		System.out.println(AnticipatedCount);
		clickElement(driver, test, OCR_DBFDMode_AnticipatedVisitorCount,"Clicking on Anticipated Visitor Count");
		return AnticipatedCount;
	}

	// click on CheckedIn Today & Checked In Count
	public String click_CheckedInToday(String CheckedIn) {
		clickElement(driver, test, OCR_DBFDMode_CheckedInToday,"Clicking on Dash Board checked in Today button");
		String FDCheckedIn = "//ul[@id='ciList']//a[contains(text(),'"+CheckedIn+"')]";
		System.out.println(FDCheckedIn);
		clickElement(driver, test, FDCheckedIn,"Selecting Dash Board checked in drop down : "+CheckedIn);		
		String Checkedincount = getText(driver, test, OCR_DBFDMode_CheckedInCount, "getting the count of Dash Board checked in visitor : ");
		System.out.println(Checkedincount);
		clickElement(driver, test, OCR_DBFDMode_CheckedInCount,"Clicking on Dash Board checked in Visitor Count");
		return Checkedincount;

	}

	// click on CheckedOut Today & Checked out Count
	public String click_CheckedOutToday(String CheckedOut) {
		clickElement(driver, test, OCR_DBFDMode_CheckedOutToday,"Clicking on Dash Board checked out Today button");
		String DBCheckedOut = "//ul[@id='coList']//a[contains(text(),'"+CheckedOut+"')]";
		System.out.println(DBCheckedOut);
		clickElement(driver, test, DBCheckedOut,"Selecting Dash Board checked Out drop down : "+CheckedOut);		
		String DBCheckedOutcount = getText(driver, test, OCR_DBFDMode_CheckedOutCount, "getting the count of Dash Board checked out visitor : ");
		System.out.println(DBCheckedOutcount);
		clickElement(driver, test, OCR_DBFDMode_CheckedOutCount,"Clicking on DashBoard checked out Visitor Count");
		return DBCheckedOutcount;
	}

	// click on No Shows Today & Checked out Count
	public String click_NoShowsToday(String NoShows) {
		clickElement(driver, test, OCR_DBFDMode_NoShowsToday,"Clicking on Dash Board No Shows Today button");
		String DBNoShows = "//ul[@id='nsList']//a[contains(text(),'"+NoShows+"')]";
		System.out.println(DBNoShows);
		clickElement(driver, test, DBNoShows,"Selecting Dash Board No Shows dropdown : "+NoShows);		
		String DBNoShowscount = getText(driver, test, OCR_DBFDMode_NoShowsCount, "getting the count of Dash Board No Shows visitor : ");
		System.out.println(DBNoShowscount);
		clickElement(driver, test, OCR_DBFDMode_NoShowsCount,"Clicking on Dash Board No Shows Visitor Count");
		return DBNoShowscount;
	}

	// click on Screening Alert Today & Checked out Count
	public String click_ScreeningAlertToday(String ScreeningAlert) {
		clickElement(driver, test, OCR_DBFDMode_ScreeningAlertToday,"Clicking on Dash Board Screening Alert Today button");
		String DBScreeningAlert = "//ul[@id='saList']//a[contains(text(),'"+ScreeningAlert+"')]";
		System.out.println(DBScreeningAlert);
		clickElement(driver, test, DBScreeningAlert,"Selecting Dash Board Screening Alert dropdown : "+ScreeningAlert);		
		String DBScreeningAlertcount = getText(driver, test, OCR_DBFDMode_ScreeningAlertCount, "getting the count of Dash Board No Shows visitor : ");
		System.out.println(DBScreeningAlertcount);
		clickElement(driver, test, OCR_DBFDMode_ScreeningAlertCount,"Clicking on Dash Board Screening Alert Visitor Count");
		return DBScreeningAlertcount;
	}

	// click on Checked in Expired Today & Checked out Count
	public String click_CheckedInExpiredToday(String CheckedInExpired) {
		clickElement(driver, test, OCR_DBFDMode_CheckedInExpiredToday,"Clicking on Dash Board Checked in Expired Today button");
		String DBCheckedInExpired = "//ul[@id='cieList']//a[contains(text(),'"+CheckedInExpired+"')]";
		System.out.println(DBCheckedInExpired);
		clickElement(driver, test, DBCheckedInExpired,"Selecting Dash Board Checked in Expired dropdown : "+DBCheckedInExpired);		
		String DBCheckedInExpiredcount = getText(driver, test, OCR_DBFDMode_CheckedInExpiredCount, "getting the count of Dash Board Checked in Expired visitor : ");
		System.out.println(DBCheckedInExpiredcount);
		clickElement(driver, test, OCR_DBFDMode_ScreeningAlertCount,"Clicking on Dash Board Checked in Expired Visitor Count");
		return DBCheckedInExpiredcount;
	}	
	// Select site in site drop down
	public void select_Site(String DashBoardSite) {				
			clickElement(driver, test, OCR_DBFMode_SiteDropdown, "click on Site arrow");		
			String site = "//div[contains(text(),'" + DashBoardSite.trim() + "')]";		
			clickElement(driver, test, site,  "Select the site : " + DashBoardSite);	  	
		}
	// Uncheck short term and long term check boxes
	public void Uncheck_Shortterm () {				
		clickElement(driver, test, OCR_DBFMode_UncheckShortterm, "Uncheck short term and long term check boxes");		
		Wait.waitfor(3);	  	
	}
		
}

	
	
