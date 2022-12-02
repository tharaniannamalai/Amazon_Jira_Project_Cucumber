package com.pom.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazon_Home_Page_1 {

	public WebDriver driver;
	
	public Amazon_Home_Page_1(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text() = 'Fashion']") //Fashion Link on HomePage
	private WebElement fashion_Lnk;

	public WebElement getFashion_Lnk() {
		return fashion_Lnk;
	}
}
