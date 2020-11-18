package com.gridexchange.testCases;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.gridexchange.utilities.ReadConfig;




public class BaseClass {

	ReadConfig readConfig = new ReadConfig();
	
	public String baseURL = readConfig.getApplicationURL();
	public String emailAddress = readConfig.getEmailAddress();
	public String password = readConfig.getPassword();
	public String ccMgEVCrName = readConfig.getCCManEVChName();
	public static WebDriver driver;
	
	@FindBy(xpath="//*[@class='error pageLevel']/p")
	@CacheLookup
	WebElement loginErrorTxt;
	
	//public static Logger logger;
	

	@Parameters("browser")
	@BeforeClass

	public void setup(String br) {
		//logger = Logger.getLogger("gridExchange");
		//PropertyConfigurator.configure("Log4j.properties");
		
		

		if (br.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
			driver = new ChromeDriver();

		}

		else if (br.equals("firefox"))

		{
			System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}

		else if (br.equals("ie"))

		{
			System.setProperty("webdriver.ie.driver", readConfig.getIEPath());
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(baseURL);

	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screen shot taken");

	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
