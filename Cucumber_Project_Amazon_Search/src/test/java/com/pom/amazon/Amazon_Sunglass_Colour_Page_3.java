package com.pom.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazon_Sunglass_Colour_Page_3{
	
	public WebDriver driver;
	
	public Amazon_Sunglass_Colour_Page_3(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//div[@class='colorsprite aok-float-left'])[1]") // Sunglass Colour - Black
	private WebElement sunglass_Colour;
	
	@FindBy(xpath = "(//img[@class='s-image'])[6]") //Sunglass Picture to be order
	private WebElement sunglass;

	//Getters
	public WebElement getSunglass_Colour() {
		return sunglass_Colour;
	}

	public WebElement getSunglass() {
		return sunglass;
	}
}
