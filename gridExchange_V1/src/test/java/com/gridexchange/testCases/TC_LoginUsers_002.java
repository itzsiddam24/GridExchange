package com.gridexchange.testCases;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gridexchange.pageObjects.CCQuoteCreationPage;
import com.gridexchange.utilities.XLUtils;

@Test(dataProvider="TestData")

public class TC_LoginUsers_002 extends BaseClass{
	
	@Test(dataProvider ="TestData")
	public void loginUsers(String emailAddress, String password) throws InterruptedException, IOException
	{
		
		CCQuoteCreationPage clp = new CCQuoteCreationPage(driver);
		clp.clearAddressTxtBox();
		clp.enterEmailAddress(emailAddress);
		clp.clearPasswordTxtBox();
		clp.enterPassword(password);
		clp.clickSignBtn();
		
		Thread.sleep(3000);
		
		
		Assert.assertTrue(driver.getTitle().contains("GridExchange | Contract Counter Party"), "User is not able to login into the application");
		
		
		if (driver.getTitle().equals("GridExchange | Contract Counter Party")) {
			
			Assert.assertTrue(true);
			//logger.info("CC Login test passed");
		} else {
			
			captureScreen(driver, "TC_CCLogin_001");
			Assert.assertTrue(false);
			//logger.info("CC Login test failed");
		}
		
		
		
	}
	
	
	public boolean isErrorPresent()
	{
		
		try {
			driver.findElement((By) loginErrorTxt);
		}
		catch (NoAlertPresentException e){
			return false;
		}
		return false;
		
	}
	
	@DataProvider(name="TestData") 
	public Object[][] passData()
	{
		
		Object[][] data = new Object[3][2];
		 
		data[0][0] = "qa@chatsoft.com";
	    data[0][1] = "test1234";
	    
	    data[1][0] = "qa@chatsoft.com";
	    data[1][1] = "test123"	;
	    
	    data[2][0] = "qa@chatsoft.com";
	    data[2][1] = "test12"	;
		
		return data;
		
	}
	
	
	
	
	
	
	
	
	
	
	/*
	 * @DataProvider(name="AlectraTestData") String [][] getData() throws
	 * IOException {
	 * 
	 * //(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
	 * //String path = System.getProperty("user.dir") + "/gridexchange/" +
	 * "/testData/" + "/AlectraTestData.xlsx/";
	 * 
	 * String path = System.getProperty("user.dir")+
	 * "/src/test/java/com/gridexchange/testData/TestData.xlsx/"; int rownum =
	 * XLUtils.getrowCount(path, "Sheet1"); int colcount =
	 * XLUtils.getCellCount(path, "Sheet1", 1);
	 * 
	 * String logindata[][] = new String [rownum][colcount];
	 * 
	 * for (int i=1; i<rownum; i++) { for(int j=0; j<colcount; j++) {
	 * logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);//1 0 } }
	 * 
	 * return logindata;
	 * 
	 * 
	 * 
	 * }
	 */
	
	
	

}
