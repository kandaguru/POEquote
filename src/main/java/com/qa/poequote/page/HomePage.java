package com.qa.poequote.page;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.poeqoute.base.EquoteBase;
import com.qa.poequote.utilities.TestUtil;

public class HomePage extends EquoteBase {

	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//label[@for='uoa-form__onBehalf-0']")
	WebElement OnBehalfYesRdBtn;

	@FindBy(xpath = "//label[@for='uoa-form__onBehalf-1']")
	WebElement OnBehalfNoRdBtn;

	@FindBy(id = "uoa-form__fName")
	WebElement onBehalfFName;

	@FindBy(id = "uoa-form__lName")
	WebElement onBehalfLName;

	@FindBy(id = "uoa-form__requestorUpi")
	WebElement onBehalfUpi;

	@FindBy(id = "uoa-form__emailAddress")
	WebElement onBehalfEmail;

	@FindBy(xpath = "//label[@for='uoa-form__isStudent-0']")
	WebElement staffRequestorRdBtn;

	@FindBy(xpath = "//label[@for='uoa-form__isStudent-1']")
	WebElement studentRequestorRdBtn;

	@FindBy(xpath = "//label[@for='uoa-form__isStudent-2']")
	WebElement contractorRequestorRdBtn;

	@FindBy(id = "uoa-form__supervisorUPI")
	WebElement supervisorUpiTxtBox;

	@FindBy(id = "uoa-form__facultyServiceDiv")
	WebElement facultyServiceDrpDwn;

	@FindBy(xpath = "//label[@for='uoa-form__typeOfRequest-0']")
	WebElement BocYesRdBtn;

	@FindBy(xpath = "//label[@for='uoa-form__typeOfRequest-1']")
	WebElement BocNoRdBtn;

	@FindBy(id = "uoa-form__bocCustomerAccount")
	WebElement bocAccNoTxtBox;

	@FindBy(id = "uoa-form__supplierName")
	WebElement supplierNameTxtBox;

	@FindBy(id = "uoa-form__supplierNumber")
	WebElement supplierNumberTxtBox;

	@FindBy(id = "uoa-form__requestCurrency")
	WebElement currencyDrpDwn;

	@FindBy(xpath = "//label[@for='uoa-form__requestToBeChargedTo-0']")
	WebElement researchProjectRdBtn;

	@FindBy(xpath = "//label[@for='uoa-form__requestToBeChargedTo-1']")
	WebElement phdPressAccRdBtn;

	@FindBy(xpath = "//label[@for='uoa-form__requestToBeChargedTo-2']")
	WebElement deptServiceDivision;

	@FindBy(xpath = "//label[@for='uoa-form__costCentreSplit-0']")
	WebElement costCentreSplitYes;

	@FindBy(xpath = "//label[@for='uoa-form__costCentreSplit-1']")
	WebElement costCentreSplitNo;

	@FindBy(id = "uoa-form__ecartCostCentre")
	WebElement CcCodeTxtBox;

	@FindBy(xpath = "//label[contains(text(),'Project code')]/following-sibling::input")
	WebElement projectCodeTxtBox;

	@FindBy(id = "uoa-form__accountCode")
	WebElement accCodeTxtBox;

	@FindBy(id = "uoa-form__internalProductCode")
	WebElement productCodeTxtBox;

	@FindBy(xpath = "//label[@for='uoa-form__suppressPoAmount-0']")
	WebElement supressPOChkBox;

	@FindBy(id = "uoa-form__splitComments")
	WebElement splitDetailsTxtBox;

	@FindBy(id = "uoa-form__costCentreSPlitUpload")
	WebElement splitCCFileUpload;

	@FindBy(className = "uoa-form__date-day")
	WebElement dateField;

	@FindBy(className = "uoa-form__date-month")
	WebElement monthField;

	@FindBy(className = "uoa-form__date-year")
	WebElement yearField;

	@FindBy(id = "uoa-form__numberOfLineItems")
	WebElement noOfItemsDrpDwn;

	@FindBy(id = "uoa-form__deliveryBuildingNumber")
	WebElement buildingNumberTxtBox;

	@FindBy(id = "uoa-form__deliveryRoomNumber")
	WebElement roomNumberTxtBox;

	@FindBy(id = "uoa-form__deliveryAddress1")
	WebElement deliveryAddress1TxtBox;

	@FindBy(id = "uoa-form__deliveryAddress2")
	WebElement deliveryAddress2TxtBox;

	@FindBy(id = "uoa-form__deliveryCity")
	WebElement deliveryCityTxtBox;

	@FindBy(id = "uoa-form__deliveryPostCode")
	WebElement postCodeTxtBox;

	@FindBy(id = "uoa-form__Upload1")
	WebElement uploadAdditionalSupplierDoc;

	@FindBy(id = "uoa-form__upload2")
	WebElement uploadAdditionalDoc;

	@FindBy(id = "uoa-form__supplierNotes")
	WebElement supplierNotesTxtBox;

	@FindBy(xpath = "//label[@for='uoa-form__acknowledgement-0']")
	WebElement acknowledgeChkBox;

	@FindBy(name = "standardSubmit")
	WebElement submitBtn;

	@FindBy(id = "uoa-form__accountCode")
	WebElement accountCodePress;

	@FindBy(id = "uoa-form__moreThanSixFile")
	WebElement moreThanSixDoc;

	@FindBy(id = "uoa-form__supvApproval")
	WebElement supervisorDocUpload;

	@FindBy(id = "uoa-form__typeOfRequest")
	WebElement supplierDropDpwn;

	@FindBy(id = "uoa-form__equotetNumber")
	WebElement equoteNumberTxtBox;

	@FindBy(xpath = "//label[@for='uoa-form__cartNameOrReplenishmentNumber-0']")
	WebElement cartNameRdBtn;

	@FindBy(xpath = "//label[@for='uoa-form__cartNameOrReplenishmentNumber-1']")
	WebElement cartReplRdBtn;

	public void RadioBtn_click(String value) {

		switch (value) {

		case "Yes":
		case "yes":
			OnBehalfYesRdBtn.click();
			break;

		case "no":
		case "No":
			OnBehalfNoRdBtn.click();
			break;

		case "staff":
		case "Staff":
			staffRequestorRdBtn.click();
			break;

		case "student":
		case "Student":
			studentRequestorRdBtn.click();
			break;

		case "contractor":
		case "Contractor":
			contractorRequestorRdBtn.click();
			break;

		case "BocYes":
		case "Bocyes":
			BocYesRdBtn.click();
			break;

		case "BocNo":
		case "Bocno":
			BocNoRdBtn.click();
			break;

		case "Research Project":
			researchProjectRdBtn.click();
			break;

		case "PhD PReSS Account":
			phdPressAccRdBtn.click();
			break;

		case "Department/Service Division":
			deptServiceDivision.click();
			break;

		case "splitCCyes":
		case "splitCCYes":
			costCentreSplitYes.click();
			break;

		case "splitCCno":
		case "splitCCNo":
			costCentreSplitNo.click();
			break;

		case "CartName":
			cartNameRdBtn.click();
			break;

		case "CartReplenishment":
			cartReplRdBtn.click();
			break;

		default:
			System.err.println("Invalid value");

		}

	}

	public void enterOnBehalfDetails() {

		onBehalfFName.clear();
		onBehalfFName.sendKeys(prop.getProperty("onBehalfFName"));

		onBehalfLName.clear();
		onBehalfLName.sendKeys(prop.getProperty("onBehalfLname"));

		onBehalfUpi.clear();
		onBehalfUpi.sendKeys(prop.getProperty("onBehalfUpi"));

		onBehalfEmail.clear();
		onBehalfEmail.sendKeys(prop.getProperty("onBehalfEmail"));
	}

	public void enterSupervisorUpi(String supervisorUpi) {

		supervisorUpiTxtBox.clear();
		supervisorUpiTxtBox.sendKeys(supervisorUpi);

	}

	public void enterBocAccNumber(String bocAccNumber) {

		bocAccNoTxtBox.clear();
		bocAccNoTxtBox.sendKeys(bocAccNumber);

	}

	public void enterSupplierDetails(String supplierName, String supplierNo) {

		supplierNameTxtBox.clear();
		supplierNameTxtBox.sendKeys(supplierName);

		supplierNumberTxtBox.clear();
		supplierNumberTxtBox.sendKeys(supplierNo);

	}

	public void selectDropDown(String type, String visibleTxt) {

		switch (type) {

		case "faculty service":

			Select selectFaculty = new Select(facultyServiceDrpDwn);
			selectFaculty.selectByVisibleText(visibleTxt);
			break;

		case "currency":

			Select selectCurrency = new Select(currencyDrpDwn);
			selectCurrency.selectByVisibleText(visibleTxt);
			break;

		case "item details":
			Select selectNoOfItems = new Select(noOfItemsDrpDwn);
			selectNoOfItems.selectByVisibleText(visibleTxt);
			break;

		case "account code PreSS":
			Select selectAccountCodePress = new Select(accountCodePress);
			selectAccountCodePress.selectByValue(visibleTxt);
			break;

		case "Supplier":
			Select supplier = new Select(supplierDropDpwn);
			supplier.selectByVisibleText(visibleTxt);
			break;

		default:
			System.err.println("Invalid  value");
			break;

		}

		/***
		 * uncomment the below code when there is a change in the case of the select
		 * Options
		 ***/

	}

	public void enterCostCentreDetails(String requestChargedTo, String ccCode, String projectcode, String accountCode,
			String productCode) {

		if (requestChargedTo.equalsIgnoreCase("PhD PReSS Account")) {

			CcCodeTxtBox.clear();
			CcCodeTxtBox.sendKeys(ccCode);

			projectCodeTxtBox.clear();
			projectCodeTxtBox.sendKeys(projectcode);

			selectDropDown("account code PreSS", accountCode);

//			productCodeTxtBox.clear();
//			productCodeTxtBox.sendKeys(productCode);

		} else {

			CcCodeTxtBox.clear();
			CcCodeTxtBox.sendKeys(ccCode);

			projectCodeTxtBox.clear();
			projectCodeTxtBox.sendKeys(projectcode);

//			accCodeTxtBox.clear();
//			accCodeTxtBox.sendKeys(accountCode);

			productCodeTxtBox.clear();
			productCodeTxtBox.sendKeys(productCode);

		}

	}

	public void enterSplitDetails(String splitComments, String splitDetailFile) {

		splitDetailsTxtBox.clear();
		splitDetailsTxtBox.sendKeys(splitComments);

		if (!(splitDetailFile.equalsIgnoreCase(""))) {

			splitCCFileUpload.sendKeys(splitDetailFile);
		}

	}

	public void enterdate(String dd, String mm, String yyyy) {

		dateField.clear();
		dateField.sendKeys(dd);

		monthField.clear();
		monthField.sendKeys(mm);

		yearField.clear();
		yearField.sendKeys(yyyy);

	}

	public void enterDeliveryAddress(String buildingNumber, String roomNumber, String deliveryAddress1,
			String deliveryAddress2, String deliveryCity, String postCode) {

		buildingNumberTxtBox.clear();
		buildingNumberTxtBox.sendKeys(buildingNumber);

		roomNumberTxtBox.clear();
		roomNumberTxtBox.sendKeys(roomNumber);

		deliveryAddress1TxtBox.clear();
		deliveryAddress1TxtBox.sendKeys(deliveryAddress1);

		deliveryAddress2TxtBox.clear();
		deliveryAddress2TxtBox.sendKeys(deliveryAddress2);

		deliveryCityTxtBox.clear();
		deliveryCityTxtBox.sendKeys(deliveryCity);

		postCodeTxtBox.clear();
		postCodeTxtBox.sendKeys(postCode);

	}

	public void itemDetails(int count, Map<Object, Object> map1, String moreThanSix, String moreThanSixDocLoc) {

		if (count <= 6) {

			for (int i = 1; i <= count; i++) {

				if (i == 1) {

					driver.findElement(By.id("uoa-form__lineItemSupplierPartID"))
							.sendKeys((String) map1.get("Supplier product code(lineItemSupplierPartID)"));
					driver.findElement(By.id("uoa-form__lineItemDescription"))
							.sendKeys((String) map1.get("Description(lineItemDescription)"));

					driver.findElement(By.id("uoa-form__lineItemQuantity"))
							.sendKeys((String) map1.get("Quantity(lineItemQuantity)"));
					driver.findElement(By.id("uoa-form__lineItemUnitPrice"))
							.sendKeys((String) map1.get("Unit price (excl. GST)(lineItemUnitPrice)"));

				}

				else {

					driver.findElement(By.id("uoa-form__lineItemSupplierPartID" + i))
							.sendKeys((String) map1.get("Supplier product code(lineItemSupplierPartID" + i + ")"));
					driver.findElement(By.id("uoa-form__lineItemDescription" + i))
							.sendKeys((String) map1.get("Description(lineItemDescription" + i + ")"));

					driver.findElement(By.id("uoa-form__lineItemQuantity" + i))
							.sendKeys((String) map1.get("Quantity(lineItemQuantity" + i + ")"));
					driver.findElement(By.id("uoa-form__lineItemUnitPrice" + i))
							.sendKeys((String) map1.get("Unit price (excl. GST)(lineItemUnitPrice" + i + ")"));

				}
			}
		}

		else if (moreThanSix.contains("Please attach a supporting document if there are more than 6 items")) {

			moreThanSixDoc.clear();
			System.out.println("In the itemdetails() ====>" + moreThanSixDocLoc);
			moreThanSixDoc.sendKeys(moreThanSixDocLoc);
		}

		else {

			System.err.println("************ Invalid Test Data ************");
		}

	}

	public void addtionalDocUpload(String docLocation) {

		uploadAdditionalDoc.clear();
		uploadAdditionalDoc.sendKeys(docLocation);
	}

	public void additionalSupplierDocUpload(String supplierdocLocation) {

		uploadAdditionalSupplierDoc.clear();
		uploadAdditionalSupplierDoc.sendKeys(supplierdocLocation);

	}

	public void enterSupplierNotes(String supplierNotes) {

		supplierNotesTxtBox.clear();
		supplierNotesTxtBox.sendKeys(supplierNotes);
	}

	public void supervisorDocUpload(String supervisordoc) {

		supervisorDocUpload.clear();
		supervisorDocUpload.sendKeys(supervisordoc);

	}

	public void selectCheckBox() {

		supressPOChkBox.click();

	}

	public boolean isMissingFields() {

		return TestUtil.isElementPresent(driver, By.xpath("//div[@class='uoa-form__submit-alert']"));

	}

	public LastPage acknowledgeAndSubmit() throws IOException {

		acknowledgeChkBox.click();
		submitBtn.click();
		return new LastPage();

	}

	public void enterEquoteNumber(String equoteNumberValue) {

		equoteNumberTxtBox.clear();
		equoteNumberTxtBox.sendKeys(equoteNumberValue);

	}

	
	@FindBy (id="uoa-form__sciquestErm")
	WebElement cartNameTxtBox;
	
	@FindBy(id="uoa-form__ermReplenish")
	WebElement  cartReplenishTxtbox;
	
	public void addCartDetails(String type,String cartDetail) {
		
				switch(type) {
				
				case "CartName" :
					cartNameTxtBox.clear();
					cartNameTxtBox.sendKeys(cartDetail);
					
				case "CartReplenishment":
					cartReplenishTxtbox.clear();
					cartReplenishTxtbox.sendKeys(cartDetail);
				
				
				}
		

	}

}