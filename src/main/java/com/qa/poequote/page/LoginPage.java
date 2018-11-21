package com.qa.poequote.page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.poeqoute.base.EquoteBase;
import com.qa.poequote.utilities.TestUtil;


public class LoginPage extends EquoteBase {

	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	@CacheLookup
	WebElement userName;

	@FindBy(id = "password")
	@CacheLookup
	WebElement password;

	@FindBy(id = "_eventId_proceed")
	WebElement signIn;

	@FindBy(id = "token")
	WebElement enterTokenTxtBox;

//	@FindBy(xpath = "//p[contains(text(),'not correct')]")
//	WebElement MFAErrorMsg;

	By MFAErrorMsg=By.className("form-error");

	public void login() throws IOException {

		userName.clear();
		userName.sendKeys(prop.getProperty("username").trim());

		password.clear();
		password.sendKeys(prop.getProperty("password").trim());

		signIn.click();

	}

	public HomePage enter2FA() throws IOException {

		String token = TestUtil.getTwoFA();
		enterTokenTxtBox.sendKeys(token);
		signIn.click();

		return new HomePage();
	}

	public boolean returnErrorMsg() {

			return TestUtil.isElementPresent(driver, MFAErrorMsg);

	}

}
