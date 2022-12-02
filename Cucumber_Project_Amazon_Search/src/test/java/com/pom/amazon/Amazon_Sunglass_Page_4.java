package com.pom.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazon_Sunglass_Page_4 {
	
	public WebDriver driver;
	
	public Amazon_Sunglass_Page_4(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@id='quantity']") //Sunglass Quantity
	private WebElement sunglass_Quantity;
	
	@FindBy(xpath = "//input[@id='add-to-cart-button']") //Add to cart Button
	private WebElement add_To_Cart_Btn;

	public WebElement getSunglass_Quantity() {
		return sunglass_Quantity;
	}

	public WebElement getAdd_To_Cart_Btn() {
		return add_To_Cart_Btn;
	}
}
