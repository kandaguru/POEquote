package com.qa.poequote.page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.poeqoute.base.EquoteBase;

public class LastPage extends EquoteBase {
	
	WebDriverWait wait;

	public LastPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	By thankYouText=By.xpath("//h1[@class='text-center']");
	By errorText=By.xpath("//[text(),'Error']");

	public int isDisplayedThankyouText() {
		wait= new WebDriverWait(driver, 15);
		return driver.findElements(thankYouText).size();
		
	}
	
	public void navigateBack() {
		
		driver.navigate().back();
		
	}

}
