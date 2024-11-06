package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class OffshoreProcurementReportsDSP_05Page extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//...................................Locators.......................................//
	public static final String DSP_5_Save="(//button[contains(text(),'Save')])[1]";
	public static final String DSP_5_SaveandReturn="(//button[contains(text(),'Save')])[2]";
	public static final String DSP_5_cancel="(//button[contains(text(),'Cancel')])[1]";
	public static final String DSP_5_USGOfficer="//input[@name='offshoreProcurementValue.usgOfficer']";
	public static final String DSP_5_USGTitle="//input[@name='offshoreProcurementValue.usgTitle']";
	public static final String DSP_5_empoweredOfficer="//input[@name='offshoreProcurementValue.empowOfficer']";
	public static final String DSP_5_title="//input[@name='offshoreProcurementValue.empowTitle']";
	public static final String DSP_5_Exporter="(//a[contains(text(),'Exporter')])[2]";
	public static final String DSP_5_expCode="//input[@name='exporter.expCode']";
	public static final String DSP_5_SearchPopup="//button[@name='Search']";
	public static final String DSP_5_SelectPopup="(//button[@name='Ok'])[3]";
	public static final String DSP_5_ClosePopup="(//button[@class='btn-close'])[1]";
	public static final String DSP_5_DDTCCode="//input[@name='offshoreProcurementValue.ddtcRegCode']";
	public static final String DSP_5_Consignee="//a[contains(text(),'Consignee Name')]";
	public static final String DSP_5_ConsigneeName="//input[@id='editOffshoreProcurement_offshoreProcurementValue_consigneeName']";
	public static final String DSP5__addlReportText="//textarea[@name='offshoreProcurementValue.addlReportText']";
	public static final String DSP_5_remarks="//textarea[@name='offshoreProcurementValue.remarks']";
	
	//.................................Constructor.....................................//
	public OffshoreProcurementReportsDSP_05Page(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;		
	}
	
	//...........................Click on Save Button...............................//
	public void save() {
		clickElement(driver, test, DSP_5_Save, "Clicking on Save Button");
	}
	
	//...........................Click on Save And return Button.........................//
	public void saveandreturn() {
		clickElement(driver, test, DSP_5_SaveandReturn, "Clicking on Save and Return Button");
	}
	
	//......................Click On Cancel button.................................//
	public void cancel() {
		clickElement(driver, test, DSP_5_cancel, "Clicking On Cancel Button");
	}
	
	//.........................Putting Data into Offsshore Report.......................//
	public void offshoredata(String usgOfficer,String usgTitle,String empoweredOfficer,String title,String Exporter,
			String ddtcCode,String consigneeName, String ReportText, String Remark) {
		
		typeText(driver, test, DSP_5_USGOfficer, "Entering USG Officer name", usgOfficer);
		typeText(driver, test, DSP_5_USGTitle, "Entering USG Title", usgTitle);
		typeText(driver, test, DSP_5_empoweredOfficer, "Entering Empowered Officer", empoweredOfficer);
		typeText(driver, test, DSP_5_title, "Entering Title", title);
		if(Exporter.length() > 0) {
			clickElement(driver, test, DSP_5_Exporter, "Clicking on Exporter :");
			try {
				typeText(driver, test, DSP_5_expCode, "Entering Exporter Code :", Exporter);
				clickElement(driver, test, DSP_5_SearchPopup, "Clicking on Search Poup :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Exporter+"')]", "Selecting Exporter Code :");
				clickElement(driver, test, DSP_5_SelectPopup, "Clicking on Select PopUp :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, DSP_5_ClosePopup, "Clicking on Close PopUp :");
			}
		}
		typeText(driver, test, DSP_5_DDTCCode, "Entering DDTC Code", ddtcCode);
		typeText(driver, test, DSP_5_ConsigneeName, "Entering Consignee Name", consigneeName);
		typeText(driver, test, DSP5__addlReportText, "Entering Additional Report Text :", ReportText);
		typeText(driver, test, DSP_5_remarks, "Entering Remark Text :", Remark);
		scrollToElement(driver, DSP_5_Save);
	}
}
