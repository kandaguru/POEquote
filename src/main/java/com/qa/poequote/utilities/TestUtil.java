package com.qa.poequote.utilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.qa.poequote.resources.Xls_Reader;



public class TestUtil {
	
	public TestUtil() throws IOException {
		super();

	}

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT_TIMEOUT = 20;
	public static Xls_Reader reader;

	public static String getTwoFA() {

		String otpKeyStr ="UKMKVCOZOELMD5XZO3V72ZHW2CHPECDU";

		Totp totp = new Totp(otpKeyStr);
		String twoFactorCode = totp.now(); // <- got 2FA coed at this time!

		System.out.println(twoFactorCode);
		

		return twoFactorCode.trim();

	}

	
	public static boolean isElementPresent(WebDriver driver, By by) {  
	    
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);  
	    try {  
	        driver.findElement(by);  
	        return true;  
	    } catch (NoSuchElementException e) {  
	        return false;  
	    } finally {  
	        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);  
	    }  
	}
	
	
	
}

