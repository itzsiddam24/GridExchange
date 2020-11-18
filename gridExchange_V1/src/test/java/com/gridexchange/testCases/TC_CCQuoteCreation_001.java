	package com.gridexchange.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.gridexchange.pageObjects.CCQuoteCreationPage;

import jdk.internal.org.jline.utils.Log;

public class TC_CCQuoteCreation_001 extends BaseClass {
	Logger log = Logger.getLogger(TC_CCQuoteCreation_001.class);
	@Test
	public void ccQCTest() throws InterruptedException, IOException {
		driver.manage().window().maximize();
		driver.get(baseURL);
		log.info("URL is opened");
		Thread.sleep(300);
		

		CCQuoteCreationPage ccP = new CCQuoteCreationPage(driver);

		Thread.sleep(3000);
		
		ccP.enterEmailAddress(emailAddress);
		log.info("Entered the valid email");
		Thread.sleep(3000);
		ccP.enterPassword(password);
		
		log.info("Entered the valid password");
		Thread.sleep(3000);

		ccP.clickSignBtn();
		log.info("Selected the Sign IN button");
		Thread.sleep(5000);

		if (driver.getTitle().equals("GridExchange | Contract Counter Party")) {
			
			Assert.assertTrue(true);
			//logger.info("CC Login test passed");
		} else {
			
			captureScreen(driver, "TC_CCQuoteCreation_001");
			Assert.assertTrue(false);
			log.info("CC Login test failed");
		}
		
		Thread.sleep(5000);
		
		ccP.clickOutGoingServLink();
		log.info("Selected the Outsoing services link displayed on the page");
		Thread.sleep(5000);
		
		
		if(driver.findElement(By.xpath("//*[text()='Outgoing']")).isDisplayed()) {
			Thread.sleep(5000);
			ccP.clickCreQuoBtn();
			log.info("Selected the Create Quote button displayed on the page");
			Thread.sleep(5000);
		}else {
			captureScreen(driver, "TC_CCQuoteCreation_001");
			Assert.assertTrue(false);
			log.error("The Create Quote button is not getting displayed on the page");
		}
		
		Thread.sleep(5000);
		
		if(driver.findElement(By.xpath("//*[text()='New']")).isDisplayed()) {
			Thread.sleep(1000);
			ccP.selectMgSerDrpDwnBtn();
			log.info("Selecting the Market Service drop down button.");
			ccP.selectMgEvCrgOption();
			Thread.sleep(3000);
			log.info("Selected the Managed EV Charging option from the  drop down list.");
			ccP.clearCCNameTxtBox();
			Thread.sleep(2000);
			ccP.enterCCEVName(ccMgEVCrName);
			Thread.sleep(5000);
			ccP.selectNetLocDrpDwnBtn();
			Thread.sleep(5000);
			ccP.selectNetLocName();
			Thread.sleep(2000);
			ccP.clearTenWindDtTxtBx();
			Thread.sleep(2000);
			
			
		}else {
			captureScreen(driver, "TC_CCQuoteCreation_001");
			Assert.assertTrue(false);
			log.error("Not able to select the drop down button to select the services.");
		}
		
		
		 	
		

	}

}
