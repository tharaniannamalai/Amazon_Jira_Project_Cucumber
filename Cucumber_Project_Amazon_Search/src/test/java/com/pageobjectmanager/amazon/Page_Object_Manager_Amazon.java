package com.pageobjectmanager.amazon;

import org.openqa.selenium.WebDriver;

import com.pom.amazon.Amazon_Fashion_Page_2;
import com.pom.amazon.Amazon_Home_Page_1;
import com.pom.amazon.Amazon_Sunglass_Colour_Page_3;
import com.pom.amazon.Amazon_Sunglass_Page_4;

public class Page_Object_Manager_Amazon {
	
	public WebDriver driver;
	
	private Amazon_Home_Page_1 homePage;
	
	private Amazon_Fashion_Page_2 fashionPage;
	
	private Amazon_Sunglass_Colour_Page_3 sunglassColourPage;
	
	private Amazon_Sunglass_Page_4 sunglassOrder;
	
	public Page_Object_Manager_Amazon(WebDriver driver)
	{
		this.driver = driver;
	}

	public Amazon_Home_Page_1 getHomePage() {
		
		if(homePage == null)
		{
			homePage = new Amazon_Home_Page_1(driver);
		}
		return homePage;
	}

	public Amazon_Fashion_Page_2 getFashionPage() {
		
		if(fashionPage == null)
		{
			fashionPage = new Amazon_Fashion_Page_2(driver);
		}
		return fashionPage;
	}
	
	public Amazon_Sunglass_Colour_Page_3 getSunglassColourPage() {
		
		if(sunglassColourPage == null)
		{
			sunglassColourPage = new Amazon_Sunglass_Colour_Page_3(driver);
		}
		return sunglassColourPage;
	}

	public Amazon_Sunglass_Page_4 getSunglassOrder() {

		if(sunglassOrder == null)
		{
			sunglassOrder = new Amazon_Sunglass_Page_4(driver);
		}
		return sunglassOrder;
	}
}
