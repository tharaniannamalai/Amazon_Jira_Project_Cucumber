package com.pom.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazon_Fashion_Page_2 {
	
	public WebDriver driver;
	
	public Amazon_Fashion_Page_2(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@aria-label = 'Sales & Deals']") //Sales & Deals Link
	private WebElement salesn_Deals;
	
	@FindBy(xpath = "(//a[@class='mm-merch-panel'])[20]") //Sunglasses Picture Link
	private WebElement sunglasses_Lnk;

	public WebElement getSalesn_Deals() {
		return salesn_Deals;
	}

	public WebElement getSunglasses_Lnk() {
		return sunglasses_Lnk;
	}
	
	
}
