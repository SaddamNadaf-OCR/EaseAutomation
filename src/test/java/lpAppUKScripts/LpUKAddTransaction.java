package lpAppUKScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import lpAppBelgiumClasses.HomeLpPage;
import lpAppBelgiumClasses.SearchAuthorizationsResultsPage;
//import lpAppBelgiumClasses.SearchAuthorizationsPage;
import lpAppUKClasses.ApplicationReferenceUKPage;
import lpAppUKClasses.ContactSectionUKPage;
import lpAppUKClasses.CreateNewAuthorizationUKPage;
import lpAppUKClasses.DeclarationUKPage;
import lpAppUKClasses.EndUseDetailsUKPage;
import lpAppUKClasses.ExportGoodsListUKPage;
import lpAppUKClasses.FormValidationsUKPage;
import lpAppUKClasses.GoodsLocationUKPage;
import lpAppUKClasses.GoodsRecipientUKPage;
import lpAppUKClasses.NatureofGoodsUKPage;
import lpAppUKClasses.OtherThirdPartyDocumentsUKPage;
import lpAppUKClasses.ProposedLicensesUKPage;
import lpAppUKClasses.RouteOfGoodsUKPage;
import lpAppUKClasses.SearchAuthorizationsPageUK;
import lpAppUKClasses.SupportingDocumentsUKPage;
import lpAppUKClasses.UltimateEndUserUKPage;
import utilities.Utility;
import utilities.Wait;

public class LpUKAddTransaction extends SeleniumTestBase {

	@DataProvider

	public Object[][] getData() {
		return Utility.getData("LpUKTransactionAdding", excel);
	}

	@Test(dataProvider = "getData")
	public void addLPUK(String Testcase, String RunMode, String SBU, String AuthGrantByCountry,
			String AuthorizationCode, String RefrenceId, String ProgramCode, String SegmentCode,
			String AuthPurposeStatus, String AuthorizationPurposeId, String DocumentType, String UploadfileName,
			String DocumentLocationPath, String ProviosDescription, String Notes, String AuthorizationNo,
			String Comments, String SelectType, String IndividualExporterCode, String IndividualStatus,
			String IndivTitle, String IndivMidIntials, String IndivSurName, String EmailAddress,
			String IndividualotherInfo, String OrganizationExporterCode, String OrganizationStatus, String RegNo,
			String VATNo, String NatureOfBusines, String WebAdd, String OverseaRegNo, String EORINUmber,
			String SiteName, String SiteAddress, String SiteEORI, String SiteCity, String SiteState, String SiteCountry,
			String SiteZIPCode, String OrganizationotherInfo, String YesNoParent, String ParentCmpExporterCode,
			String ParentNatureOfBusiness, String ParentOtherDetails, String ContactSelectType,
			String ContactIndivStatus, String ContactIndivExporterCode, String ContactIndivTitle,
			String ContactIndivMidIntials, String ContactIndivSurName, String ContactIndivEmailAddress,
			String ContactIndivTelephone, String ContactIndivotherInfo, String ContactOrganisationStatus,
			String ContactOrganisationExporterCode, String ContactNatureOfBusines, String ContactWebAddress,
			String PersonalOrganisationContact, String ContactOrganisationTitle, String ContactOrganisationAddress,
			String ContactOrganisationJobTitle, String ContactOrganisationEmailId, String ContactOrganisationCountry,
			String ContactOrganisationTelephone, String ContactOrganisationotherInfo, String ExportPartNo,
			String ExportQuantyMeasure, String ExportGoodsQuantity, String ExportGoodsValue, String ExportItems,
			String ExportDescBox, String Questionnaire1, String Questionnaire2, String Questionnaire3,
			String Questionnaire4, String Questionnaire5, String Questionnaire6, String Questionnaire7,
			String SelectPromotionAns, String F680Reference, String SelectWMDAnsw1, String ECOReference1,
			String SelectWMDAnsw2, String ECOReference2, String SelectMilitaryAnsw, String MilitaryReference,
			String SelectEuropeanMilAnsw, String EuropeanMilExplain, String IntendDescription,
			String SelectIntendedEndUseAnsw, String IntendPropDescription, String EndUseOtherInfo,
			String GoodsLocationCountryName, String GoodsLocationSelectType, String GoodsLocIndConsigneeCode,
			String GoodsLocIndStatus, String GoodsLocTitle,String GoodsForeName, String GoodsLocSurname, String GoodsLocEmail,
			String GoodsLocTelephone, String GoodsLocIndivotherInfo, String GoodsLocOrgConsigneeCode,
			String GoodsLocOrgStatus, String GoodsLocNatureofBusiness, String GoodsLocWebAddress,
			String GoodsLocOrgotherInfo, String GoodsRecipientSelectType, String GoodsRecIndConsigneeCode,
			String GoodsRecIndStatus, String GoodsRecTitle, String GoodsRecSurname, String GoodsRecEmail,
			String GoodsRecTelephone, String GoodsRecOrgConsigneeCode, String GoodsRecOrgStatus,
			String GoodsRecWebAddress, String GoodsRecipientType, String GoodsRecipientEndUserType,
			String GoodsRecipientOtherInfo, String UltimateUserSelectType, String UltimateIndConsigneeCode,
			String UltimateIndStatus, String UltimateUserTitle, String UltimateUserSurname, String UltimateUserEmailId,
			String UltimateUserTelephoneNo, String UltimateOrgConsigneeCode, String UltimateOrgStatus,
			String UltimateUserNatureBusiness, String UltimateUserWebAddress, String UltimateUserOtherInfo, String BOL,
			String OtherPartySelectType, String OtherPartyIndivConsigneeCode, String OtherPartyTitle,
			String OtherPartySurname, String OtherPartyEmail, String OtherPartyTelephone,
			String OtherPartyOrgConsigneeCode, String NatureofBusiness, String OtherPartyDescriptionOfRole,
			String OtherPartyOtherInfo, String SupportingDocumentType, String SupportingDocUploadfileName,
			String SupportingDocumentLocationPath, String TechnicalSpecification, String TechnicalSpecificationReason,
			String EndUserDocumentation, String EndUserDocumentationReason, String DeclarentName,
			String DeclarentRelationship, String DeclarantSelectType, String HarmfulInfo, String DecIAGREE,
			String ReviewerFirstName, String ReviewerNotes, String AuthHeaderStatus,
			String AuthHeaderStatusApprovedForSub, String AuthHeaderStatusAgency, String AuthHeaderStatusAgencyApproved,
			String AgencyAuthorizationsNo, String AgencyIssueDate, String AgencyExpiryDate) {

		HomeLpPage homelp = new HomeLpPage(driver, test);
		SearchAuthorizationsPageUK searchAuthUK = new SearchAuthorizationsPageUK(driver, test);
		CreateNewAuthorizationUKPage createAuthUK = new CreateNewAuthorizationUKPage(driver, test);
		ApplicationReferenceUKPage applicationRefUK = new ApplicationReferenceUKPage(driver, test);
		ProposedLicensesUKPage proposedLicUK = new ProposedLicensesUKPage(driver, test);
		ContactSectionUKPage contactSecUK = new ContactSectionUKPage(driver, test);
		ExportGoodsListUKPage exportGoodsUK = new ExportGoodsListUKPage(driver, test);
		NatureofGoodsUKPage natureOfGoodsUK = new NatureofGoodsUKPage(driver, test);
		EndUseDetailsUKPage endUseDetailsUK = new EndUseDetailsUKPage(driver, test);
		GoodsLocationUKPage goodsLocationUK = new GoodsLocationUKPage(driver, test);
		GoodsRecipientUKPage goodsRecepientnUK = new GoodsRecipientUKPage(driver, test);
		UltimateEndUserUKPage ultimateEnduserUK = new UltimateEndUserUKPage(driver, test);
		RouteOfGoodsUKPage routeOfGoodsUK = new RouteOfGoodsUKPage(driver, test);
		OtherThirdPartyDocumentsUKPage otherThirdPartyUK = new OtherThirdPartyDocumentsUKPage(driver, test);
		SupportingDocumentsUKPage supportingDocUK = new SupportingDocumentsUKPage(driver, test);
		DeclarationUKPage declarationUK = new DeclarationUKPage(driver, test);
		FormValidationsUKPage formValidationUK = new FormValidationsUKPage(driver, test);
		SearchAuthorizationsResultsPage searchAuthResults = new SearchAuthorizationsResultsPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					Wait.waitfor(3);
					homelp.moveTo_SBUSelection(SBU);
					searchAuthUK.click_AddAuthorization();
					Wait.waitfor(3);
					createAuthUK.headerDetails(AuthGrantByCountry, AuthorizationCode, RefrenceId);
					Wait.waitfor(3);
					createAuthUK.headerDetailsUnMandatory(ProgramCode, SegmentCode, AuthPurposeStatus,
							AuthorizationPurposeId);
					createAuthUK.click_Save();
					createAuthUK.addDocument(DocumentType, UploadfileName, DocumentLocationPath);
					createAuthUK.add_ProviosConditions(ProviosDescription);
					createAuthUK.add_Note(Notes);
					createAuthUK.click_Save();
					createAuthUK.click_ApplicationDetails();
					String RefId = applicationRefUK.ReferenceIDText();
					applicationRefUK.clickOnEnterPreviousApp();
					applicationRefUK.addPreviousAppPopUp(AuthorizationNo, Comments);
					applicationRefUK.clickonSaveBtn();
					proposedLicUK.clickOnProposedLicenseeTab();
					proposedLicUK.personalDetails(SelectType, IndividualExporterCode, IndividualStatus, IndivTitle,
							IndivMidIntials, IndivSurName, EmailAddress, IndividualotherInfo, OrganizationExporterCode,
							OrganizationStatus, RegNo, VATNo, NatureOfBusines, WebAdd, OverseaRegNo, EORINUmber,
							SiteName, SiteAddress, SiteEORI, SiteCity, SiteState, SiteCountry, SiteZIPCode,
							OrganizationotherInfo, YesNoParent, ParentCmpExporterCode, ParentNatureOfBusiness,
							ParentOtherDetails);
					proposedLicUK.saveProposedLicense();
					contactSecUK.clickOnContactSectionTab();
					contactSecUK.selectContactType(ContactSelectType, ContactIndivStatus, ContactIndivExporterCode,
							ContactIndivTitle, ContactIndivMidIntials, ContactIndivSurName, ContactIndivEmailAddress,
							ContactIndivTelephone, ContactIndivotherInfo, ContactOrganisationStatus,
							ContactOrganisationExporterCode, ContactNatureOfBusines, ContactWebAddress,
							PersonalOrganisationContact, ContactOrganisationTitle, ContactOrganisationAddress,
							ContactOrganisationJobTitle, ContactOrganisationEmailId, ContactOrganisationCountry,
							ContactOrganisationTelephone, ContactOrganisationotherInfo);
					contactSecUK.saveContactSection();
					exportGoodsUK.clickOnExportGoodsListTab();
					exportGoodsUK.clickItemBtn();
					exportGoodsUK.addItem(ExportPartNo, ExportQuantyMeasure, ExportGoodsQuantity, ExportGoodsValue,
							ExportItems);
					exportGoodsUK.addGeneralDescBox(ExportDescBox);
					exportGoodsUK.saveExportsGoodList();
					natureOfGoodsUK.clickOnNatureOfGoodsTab();
					natureOfGoodsUK.addNatureOfGoods(Questionnaire1, Questionnaire2, Questionnaire3, Questionnaire4,
							Questionnaire5, Questionnaire6, Questionnaire7);
					natureOfGoodsUK.clickOnSave();
					endUseDetailsUK.clickOnEndUseDetailsTab();
					endUseDetailsUK.addpromotionalApprovals(SelectPromotionAns, F680Reference);
					endUseDetailsUK.addWMDEndUseControl(SelectWMDAnsw1, ECOReference1, SelectWMDAnsw2, ECOReference2);
					endUseDetailsUK.addMilitaryEndUSeControl(SelectMilitaryAnsw, MilitaryReference);
					endUseDetailsUK.addEuropeanMilitaryItems(SelectEuropeanMilAnsw, EuropeanMilExplain);
					endUseDetailsUK.addIntendedEndUse(IntendDescription, SelectIntendedEndUseAnsw,
							IntendPropDescription);
					endUseDetailsUK.addOtherInfo(EndUseOtherInfo);
					endUseDetailsUK.saveEndUseDetails();
					goodsLocationUK.clickGoodsLocationTab();
					goodsLocationUK.clickOnAddCountry();
					goodsLocationUK.addCountry(GoodsLocationCountryName);
					goodsLocationUK.clickOnAddIndvidualOrganisation();
					goodsLocationUK.selectType(GoodsLocationSelectType, GoodsLocIndConsigneeCode, GoodsLocIndStatus,
							GoodsLocTitle, GoodsForeName, GoodsLocSurname, GoodsLocEmail, GoodsLocTelephone,
							GoodsLocIndivotherInfo, GoodsLocOrgConsigneeCode, GoodsLocOrgStatus,
							GoodsLocNatureofBusiness, GoodsLocWebAddress, GoodsLocOrgotherInfo);
					goodsLocationUK.clickOnsaveReturnButton();
					goodsRecepientnUK.clickOnGoodsRecipientTab();
					goodsRecepientnUK.clickOnAddGoodsRecipient();
					goodsRecepientnUK.selectType(GoodsRecipientSelectType, GoodsRecIndConsigneeCode, GoodsRecIndStatus,
							GoodsRecTitle, GoodsRecSurname, GoodsRecEmail, GoodsRecTelephone, GoodsRecOrgConsigneeCode,
							GoodsRecOrgStatus, GoodsRecWebAddress, GoodsRecipientType, GoodsRecipientEndUserType,
							GoodsRecipientOtherInfo);
					goodsRecepientnUK.clickOnSaveReturn();
					ultimateEnduserUK.clickOnUltimateEndUsersTab();
					ultimateEnduserUK.addUltimateEndUSer();
					ultimateEnduserUK.addNewUltimateEndUSer(UltimateUserSelectType, UltimateIndConsigneeCode,
							UltimateIndStatus, UltimateUserTitle, UltimateUserSurname, UltimateUserEmailId,
							UltimateUserTelephoneNo, UltimateOrgConsigneeCode, UltimateOrgStatus,
							UltimateUserNatureBusiness, UltimateUserWebAddress, UltimateUserOtherInfo);
					ultimateEnduserUK.clickOnSaveReturn();
					routeOfGoodsUK.clickOnRouteOfGoodsTab();
					routeOfGoodsUK.billoflading(BOL);
					routeOfGoodsUK.clicksavebtn();
					otherThirdPartyUK.clickOnOtherThirdPartyTab();
					otherThirdPartyUK.clickonotherthirdparty();
					otherThirdPartyUK.selectIndividual(OtherPartySelectType, OtherPartyIndivConsigneeCode,
							OtherPartyTitle, OtherPartySurname, OtherPartyEmail, OtherPartyTelephone,
							OtherPartyOrgConsigneeCode, NatureofBusiness, OtherPartyDescriptionOfRole,
							OtherPartyOtherInfo);
					otherThirdPartyUK.click_SaveAndReturn();
					supportingDocUK.clickOnSupportingDocTab();
					supportingDocUK.addsupportingdocument();
					supportingDocUK.uploaddocument(SupportingDocumentType, SupportingDocUploadfileName,
							SupportingDocumentLocationPath);
					supportingDocUK.technicalSpecification(TechnicalSpecification, TechnicalSpecificationReason);
					supportingDocUK.endUserDocuments(EndUserDocumentation, EndUserDocumentationReason);
					supportingDocUK.clicksavebtn();
					declarationUK.clickOnDeclarationTab();
					declarationUK.addRelationship(DeclarentName, DeclarentRelationship, DeclarantSelectType,
							HarmfulInfo, DecIAGREE);
					formValidationUK.clickOnFormValidationsTab();
					createAuthUK.click_reviewerlink(ReviewerFirstName, ReviewerNotes);
					createAuthUK.select_status(AuthHeaderStatus);
					createAuthUK.saveBtn();
					createAuthUK.select_status(AuthHeaderStatusApprovedForSub);
					createAuthUK.saveBtn();
					createAuthUK.select_status(AuthHeaderStatusAgency);
					createAuthUK.saveBtn();
					createAuthUK.select_status(AuthHeaderStatusAgencyApproved);
					createAuthUK.agencyAuthoNo(AgencyAuthorizationsNo, AgencyIssueDate, AgencyExpiryDate);
					createAuthUK.saveBtn();
					homelp.moveTo_SBUSelection(SBU);
					searchAuthUK.referenceID(RefId);
					searchAuthUK.click_SearchBtn();
					searchAuthResults.displayOfRefID(RefId);
					homelp.returnHomepageLP();
					Wait.waitfor(3);
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homelp.returnHomepageLP();
			Assert.assertTrue(false);
		}
	}

}
