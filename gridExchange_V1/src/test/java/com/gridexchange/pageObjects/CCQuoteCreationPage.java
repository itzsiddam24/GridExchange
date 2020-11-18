package com.gridexchange.pageObjects;

import java.time.Instant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CCQuoteCreationPage {
	
	WebDriver localdriver;
	
	public CCQuoteCreationPage(WebDriver remotedriver)
	{
		localdriver=remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	
	Instant instant = Instant.now();
	
	@FindBy(id="logonIdentifier")
	@CacheLookup
	WebElement emailAddressTxtBox;
	
	
	@FindBy(id="password")
	@CacheLookup
	WebElement passwordTxtBox;
	
	@FindBy(id="next")
	@CacheLookup
	WebElement signBtn;
	
	@FindBy(xpath="//*[text()='Outgoing Services']")
	@CacheLookup
	WebElement OutgoServiceLink;
	
	@FindBy(xpath="//*[text()='Outgoing")
	@CacheLookup
	WebElement OutgoMarketServiceText;
	
	@FindBy(xpath="//*[text()='Create New Quote']")
	@CacheLookup
	WebElement CreQuoteBtn;
	
	@FindBy(xpath="//div[@id='app-root']/div/div/div[2]/div[2]/div[2]/div/div/div/div/div")
	//div[@id='app-root']//*[ text()='Market Service']
	@CacheLookup
	WebElement MarSerDrpDwnBtn;
	
	@FindBy(xpath="//*[@class='mdc-list']/li[text()='Managed EV Charging']")
	@CacheLookup
	WebElement MgEVChOption;
	
	@FindBy(xpath="//*[@class='mdc-list']/li[text()='Demand Response']")
	@CacheLookup
	WebElement DeResOption;
	
	@FindBy(xpath="//*[@class='mdc-text-field']/*[@type='text']")
	@CacheLookup
	WebElement ccMgEvChNameTxtBox;
	
	@FindBy(xpath="//*[@class='col']//div[4]//input[@role='spinbutton']")
	@CacheLookup
	WebElement NetLocaOption;
	
	@FindBy(xpath="//*[@class='mdc-list']/li[text()='331-F1']")
	@CacheLookup
	WebElement NetLocaName;
	
	@FindBy(xpath="//*[@class='col']//*[@class='k-widget k-datetimepicker'][1]//input")
	@CacheLookup
	WebElement TenWindDate;
	
	
	
	
	
	
	
	public void enterEmailAddress(String email)
	{
		emailAddressTxtBox.sendKeys(email);
	}
	
	public void clearAddressTxtBox()
	{
		emailAddressTxtBox.clear();
	}
	
	public void clearPasswordTxtBox()
	{
		passwordTxtBox.clear();
	}
	
	
	public void enterPassword(String pwd)
	{
		passwordTxtBox.sendKeys(pwd);
	}
	
	public void clickSignBtn()
	{
		signBtn.click();
	}
	
	public void clickOutGoingServLink()
	{
		OutgoServiceLink.click();
	}
	
	public void outgoingMarServText()
	{
		OutgoMarketServiceText.isDisplayed();
	}
	
	public void clickCreQuoBtn()
	{
		CreQuoteBtn.click();
	}
	
	public void selectMgEvCrgOption()
	{
		MgEVChOption.click();
	}
	
	public void selectMgSerDrpDwnBtn()
	{
		
		MarSerDrpDwnBtn.click();
	}
	
	public void selectDmdRespOption()
	{
		DeResOption.click();
	}
	
	public void clearCCNameTxtBox()
	{
		ccMgEvChNameTxtBox.click();
		ccMgEvChNameTxtBox.clear();
	}
	
	public void enterCCEVName(String name)
	{
		ccMgEvChNameTxtBox.sendKeys(name + instant);
	}
	
	public void selectNetLocDrpDwnBtn()
	{
		NetLocaOption.click();
	}
	
	public void selectNetLocName()
	{
		NetLocaName.click();
	}
	
	public void clearTenWindDtTxtBx()
	{
		TenWindDate.click();
	}
	
}

