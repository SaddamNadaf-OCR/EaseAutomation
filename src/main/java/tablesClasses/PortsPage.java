package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class PortsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

//---------------------------------Locators---------------------------------------------

	public static final String OCRsearchbtn = "(//button[@class='primary-btn'])[1]";
	public static final String OCRAddbtn = "(//button[@class='primary-btn'])[2]";
	public static final String OCRPortId="//input[@id='searchPorts_ports_portId']";
	public static final String OCRcustomCountry="//select[@id='searchPorts_ports_country']";
	public static final String OCRDescription="//textarea[@id='searchPorts_ports_description']";
	public static final String OCRportCode="//input[@id='searchPorts_ports_portCode']";
	public static final String OCRPortCountry="//select[@id='searchPorts_ports_portCountry']";
	public static final String OCRstatus="//select[@id='searchPorts_ports_status']";
	public static final String OCRsortby="//select[@name='sortBy']";
	public static final String OCRDirection="//select[@name='direction']";
	
	//-----------------------------Add Locator-----------------------------------------------
	public static final String OCRsavebtn="//button[@name='save']";
	public static final String OCRportId1="//input[@id='editPorts_ports_portId']";
	public static final String OCRportCode1="//input[@id='editPorts_ports_portCode']";
	public static final String OCRDescription1="//textarea[@id='editPorts_ports_description']";
	public static final String OCRcustomCountry1="//select[@name='ports.country']";
	public static final String OCRportcountry1="//select[@name='ports.portCountry']";
	public static final String OCRImportExport="//select[@id='editPorts_ports_importExport']";
	
	// --------------------Constructor------------------------------------
	

		public PortsPage(WebDriver driver, ExtentTest test) {
			this.driver = driver;
			this.test = test;

		}

		// ....................click on search button......................
		public void searchbutton() {
			clickElement(driver, test, OCRsearchbtn, "clicking on search button :");
		}

		public void addbutton() {
			clickElement(driver, test, OCRAddbtn, "clicking on Add button :");
		}

		public void savebtn() {
			clickElement(driver, test, OCRsavebtn, "clicking on save button :");
		}

		// .....................searchParameter...............................//

		public void searchbyParameters(String PortId, String CustomCountry, String Description, String PortCode, String PortCountry, String Status, String sortby, String direction) {

			typeText(driver, test, OCRPortId, "Entering port Id :", PortId);
			Wait.waitfor(2);	
			selectByVisibleText(driver, test, OCRcustomCountry, "selecting CustomCountry", CustomCountry);
			Wait.waitfor(2);
			typeText(driver, test, OCRDescription, "Entering description :", Description);
			Wait.waitfor(2);
			typeText(driver, test, OCRportCode, "Entering PortCode :", PortCode);
			Wait.waitfor(2);
			selectByVisibleText(driver, test, OCRPortCountry, "selecting Status by dropdown :", PortCountry);
			Wait.waitfor(2);
			selectByVisibleText(driver, test, OCRstatus, "selecting created by dropdown :", Status);
			Wait.waitfor(2);
			selectByVisibleText(driver, test, OCRsortby, "selecting sortby  dropdown :", sortby);
			Wait.waitfor(2);
			selectByVisibleText(driver, test, OCRDirection, "selecting direction by dropdown :", direction);
			Wait.waitfor(2);
		}
		// .....................addParameter...............................//

		public void addbyParameters(String PortCode, String Description, String CustomCountry, String PortCountry, String ImportExport) {

			typeText(driver, test, OCRportId1, "Entering hazmat ID:", randomnumbers());
			Wait.waitfor(2);	
			typeText(driver, test, OCRportCode1, "Entering country :", PortCode);
			Wait.waitfor(2);
			typeText(driver, test, OCRDescription1, "Entering Description :", Description);
			Wait.waitfor(2);	
			selectByVisibleText(driver, test, OCRcustomCountry1, "selecting ccustom country from dropdown :", CustomCountry);
			Wait.waitfor(2);
			selectByVisibleText(driver, test, OCRportcountry1, "selecting port country from  dropdown :", PortCountry);
			Wait.waitfor(2);
			selectByVisibleText(driver, test, OCRImportExport, "selecting export Import from dropdown :", ImportExport);
			Wait.waitfor(2);
		
			
		}
		public void scrolltosavebtn() {
			scrollToElement(driver, OCRsavebtn);
		}
	}
		
		

	
	
	