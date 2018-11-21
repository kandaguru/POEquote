package com.qa.poequote.testcase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.poeqoute.base.EquoteBase;
import com.qa.poequote.page.HomePage;
import com.qa.poequote.page.LoginPage;

public class EquoteFillForm extends EquoteBase {

	LoginPage loginPage;
	HomePage homePage;

	public EquoteFillForm() throws IOException {
		super();

	}

	@BeforeClass
	public void setUp() throws IOException {

		intialize();
		loginPage = new LoginPage();
		loginPage.login();
		homePage = loginPage.enter2FA();

		while (loginPage.returnErrorMsg()) {

			homePage = loginPage.enter2FA();

		}

	}

	@Test(dataProvider = "data")
	public void fill_Form(Map<Object, Object> map) {

		String onBehalfRdBtnValue = (String) map.get(
				"Are you making this request on behalf of someone else? e.g. someone else is the primary contact for this order.(onBehalf)");
		String requestorRdBtnValue = (String) map.get("The requestor is(isStudent)");
		String supervisorUpiValue = (String) map.get("Please provide your supervisor's UPI/Username(supervisorUPI)");
		String facultyServiceValue = (String) map
				.get("Select the department, faculty or service division this request is for:(departmentFaculty)");
		String supplierValue = (String) map.get("Select supplier(typeOfRequest)");
		String equoteNumberValue = (String) map.get("e-Quote Number(equotetNumber)");
		String departmentValue = (String) map.get("Is the request to be charged to a(requestToBeChargedTo)");

		String requestToBeChargedValue = (String) map.get("Is the request to be charged to a(requestToBeChargedTo)");

		String ccCodeValue = (String) map.get("Cost centre code(ecartCostCentre)");

		String phdProjectCodeValue = (String) map.get("Project code(PhdProjectCode)");
		String deptProjectCodeValue = (String) map.get("Project code(deptProjectCode)");
		String researchProjectcodeValue = (String) map.get("Project code(researchProjCode)");

		String phdaccCodeValue = (String) map.get("Account code(accountCodePress)");
		String accCodeValue = (String) map.get("Account code(accountCode)");

		String internalUoaProductCodeValue = (String) map.get("Internal UOA Product Code(internalProductCode)");

		String date = (String) map.get("Date goods/services are needed(dateNeeded)");

		String dd = null, mm = null, yyyy = null;

		if (!(date.equalsIgnoreCase(""))) {

			String datearr[] = date.split("/");

			dd = datearr[0];
			mm = datearr[1];
			yyyy = datearr[2];

		}

		String buildingNumberValue = (String) map.get("Delivery building number(deliveryBuildingNumber)");
		String roomNumberValue = (String) map.get("Delivery room number(deliveryRoomNumber)");
		String deliveryAddress1Value = (String) map.get("Delivery Address Line 1(deliveryAddress1)");

		String deliveryAddress2Value = (String) map.get("Delivery Address Line 2(deliveryAddress2)");
		String deliveryCityValue = (String) map.get("Delivery City(deliveryCity)");
		String deliveryPostCodeValue = (String) map.get("Delivery Post Code(deliveryPostCode)");
		String ErmCartName = (String) map.get("ERM cart name(sciquestErm)");
		String ErmReplenishmentNumber = (String) map.get("ERM replenishment request number(ermReplenish)");


		/***************************************************************
		 * Enter the on behalf Details * And branch based on the value *
		 ***************************************************************/

		homePage.RadioBtn_click(onBehalfRdBtnValue);

		if (onBehalfRdBtnValue.equalsIgnoreCase("yes")) {

			homePage.enterOnBehalfDetails(); // enter the on-behalf details upon selecting yes in the previous step

		}

		homePage.RadioBtn_click(requestorRdBtnValue);

		if (requestorRdBtnValue.equalsIgnoreCase("student")) {

			homePage.enterSupervisorUpi(supervisorUpiValue);

		}

		/*******************************
		 * Select the faculty services *
		 *******************************/

		homePage.selectDropDown("faculty service", facultyServiceValue);

		/************************************
		 * Select supplier from the drop-down
		 *************************************/
		homePage.selectDropDown("Supplier", supplierValue);

		if (!(supplierValue.equalsIgnoreCase("ERM (SciQuest)"))) {

			homePage.enterEquoteNumber(equoteNumberValue);
		}

		if ((supplierValue.equalsIgnoreCase("Printing.com")) || (supplierValue.equalsIgnoreCase("WINC"))
				|| (supplierValue.equalsIgnoreCase("Soar Print"))) {

			homePage.RadioBtn_click(departmentValue);

			switch (requestToBeChargedValue) {

			case "Research Project":
				homePage.enterCostCentreDetails(requestToBeChargedValue, ccCodeValue, researchProjectcodeValue,
						accCodeValue, internalUoaProductCodeValue);
				break;

			case "Department/Service Division":
				homePage.enterCostCentreDetails(requestToBeChargedValue, ccCodeValue, deptProjectCodeValue,
						accCodeValue, internalUoaProductCodeValue);
				break;

			case "PhD PReSS Account":

				homePage.enterCostCentreDetails(requestToBeChargedValue, ccCodeValue, phdProjectCodeValue,
						phdaccCodeValue + " ", internalUoaProductCodeValue);
				break;

			}

			homePage.enterdate(dd, mm, yyyy);
			homePage.enterDeliveryAddress(buildingNumberValue, roomNumberValue, deliveryAddress1Value,
					deliveryAddress2Value, deliveryCityValue, deliveryPostCodeValue);

		}

		else if ((supplierValue.equalsIgnoreCase("RS Components"))
				|| (supplierValue.equalsIgnoreCase("NZ SafetyBlackWoods"))
				|| (supplierValue.equalsIgnoreCase("element14"))) {

			homePage.enterdate(dd, mm, yyyy);
			homePage.enterDeliveryAddress(buildingNumberValue, roomNumberValue, deliveryAddress1Value,
					deliveryAddress2Value, deliveryCityValue, deliveryPostCodeValue);
		}

		else {

			if (!(ErmCartName.equalsIgnoreCase(""))) {

				homePage.RadioBtn_click("CartName");
				homePage.addCartDetails("CartName", ErmCartName);

			}

			if (!(ErmReplenishmentNumber.equalsIgnoreCase(""))) {
				homePage.RadioBtn_click("CartReplenishment");
				homePage.addCartDetails("CartReplenishment", ErmReplenishmentNumber);
			}

		}


	}

	@DataProvider
	public Object[][] data() throws IOException {

		String path = System.getProperty("user.dir");

		File file = new File(path + "\\src\\main\\java\\com\\qa\\poequote\\testdata\\ExcelData.xlsx");
		FileInputStream fis = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(prop.getProperty("sheetname"));
		wb.close();

		int lastRowNum = sheet.getLastRowNum();
		System.out.println("Total number of Rows in TestData File=====>" + lastRowNum);

		int lastCellNum = sheet.getRow(0).getLastCellNum();

		Object[][] obj = new Object[lastRowNum][1];

		for (int i = 0; i < lastRowNum; i++) {
			Map<Object, Object> datamap = new HashMap<Object, Object>();
			for (int j = 0; j < lastCellNum; j++) {

				datamap.put(sheet.getRow(0).getCell(j) + "".toString(), sheet.getRow(i + 1).getCell(j) + "".toString());
			}
			obj[i][0] = datamap;

		}
		return obj;
	}

}
