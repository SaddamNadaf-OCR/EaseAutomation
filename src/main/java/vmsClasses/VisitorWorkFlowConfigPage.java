package vmsClasses;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class VisitorWorkFlowConfigPage extends GenericMethods{
	public WebDriver driver;
	public ExtentTest test;
	
	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_VMCT_WorkFlow_SBUcode = "//select[@id='selSbuCode']";
	public static final String OCR_VMCT_WorkFlow_Search = "//input[@id='search']";
	public static final String OCR_VMCT_WorkFlow_Edit = "//i[@class='fa fa-edit']";
	public static final String OCR_VMCT_WorkFlow_Group = "//select[@id='group']";
	public static final String OCR_VMCT_WorkFlow_ScreenName = "//select[@id='screenNameList']";
	public static final String OCR_VMCT_WorkFlow_Block = "//select[@id='blockList']";
	
	/* ******************** Constructor ***************************** */
	
	public VisitorWorkFlowConfigPage (WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	/* ******************** Actions ********************************* */

	//Select SBU Code // Clicking on Search // Clicking on Edit // Select the Screen Name
	public void VmctCofigSelect(String VMCTSBU) {
		selectByVisibleText(driver, test, OCR_VMCT_WorkFlow_SBUcode, "Select SBU CODE : ", VMCTSBU);
		clickElement(driver, test, OCR_VMCT_WorkFlow_Search, "Clicking on VR Search");
		clickElement(driver, test, OCR_VMCT_WorkFlow_Edit, "Clicking on Edit Icon");	
			
	}
	//Select the Group name value Review Required - Data Elements
	public void selectGroupName(String WorkFlowGroupName, String ScreenName, String Block) {
		selectByVisibleText(driver, test, OCR_VMCT_WorkFlow_Group, "Select WorkFlowGroupName : ", WorkFlowGroupName);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_VMCT_WorkFlow_ScreenName, "Select ScreenName : ", ScreenName);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_VMCT_WorkFlow_Block, "Select Block : ", Block);
	}
	
	//getting the review required data elements block name in workflow configuration

		public void get_WorkFlowBlockdataelements(String BlockName) {
			Wait.waitfor(3);
			String text = getAttribute(driver, test, "//input[@id='blockRow7']", "value", "getting the Block name ");
			Wait.waitfor(4);
			if(text.equals(BlockName)) {
				test.log(LogStatus.PASS, " getting the Block name : " +text);
			}else {
				test.log(LogStatus.FAIL, " not getting the Block name : "+text);
				testFailSshot(driver, test);
			}

		}
		
		//getting the review required data elements field name in workflow configuration

				public void get_WorkFlowFielddataelements(String FieldName) {
					Wait.waitfor(3);
					String text = getAttribute(driver, test, "//input[@id='fieldRow7']", "value", "getting the Field name ");
					Wait.waitfor(4);
					if(text.equals(FieldName)) {
						test.log(LogStatus.PASS, " getting the Field name : " +text);
					}else {
						test.log(LogStatus.FAIL, " not getting the Field name : "+text);
						testFailSshot(driver, test);
					}

				}
	

}