package userClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class ModifyUserSiteOrRegionPage extends GenericMethods{
	
	
	public WebDriver driver;
	public ExtentTest test;
	
	
	
	public static final String OCR_ModifyUsersite_title="//h3[contains(text(),'Modify User Site or Region')]";
	public static final String OCR_ModifyUsersite_Save="//button[@name='save']";
	public static final String OCR_ModifyUsersite_SaveReturn="//button[contains(text(),'Save & Return')]";
	public static final String OCR_ModifyUsersite_Cancel="//button[contains(text(),'Cancel')]";
	public static final String OCR_ModifyUsersite_Availablesitelist="//select[@id='createNewSiteOrRegion_totalUserSite']";
	public static final String OCR_ModifyUsersite_Selectedsitelist="//select[@id='createNewSiteOrRegion_selectedUserSite']";
	public static final String OCR_ModifyUsersite_Moveright="//button[@name='move-right-site']";
	public static final String OCR_ModifyUsersite_Moveleft="//button[@name='move-left-site']";
	
	public static final String OCR_ModifyUsersite_MoveAllright="//button[@name='move-all-right-site']";
	
	public static final String OCR_ModifyUsersite_MoveLeft="//button[@name='move-all-left-site']";
	
	
	
	

}
