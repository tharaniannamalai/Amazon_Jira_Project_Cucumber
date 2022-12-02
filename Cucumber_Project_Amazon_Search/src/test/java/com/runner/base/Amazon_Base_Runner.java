package com.runner.base;

import java.io.IOException;
import java.util.Set;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pageobjectmanager.amazon.Page_Object_Manager_Amazon;
import com.utilityFiles.Utility_Files;

public class Amazon_Base_Runner extends Utility_Files {
	
	public static WebDriver driver = browser_Config("chrome");
	
	public static Page_Object_Manager_Amazon manage = new Page_Object_Manager_Amazon(driver);
	
	public static Logger log = Logger.getLogger(Amazon_Base_Runner.class);
	
	//public static Page_Object_Manager_Amazon manage = new Page_Object_Manager_Amazon(driver);
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		BasicConfigurator.configure();
		
		window_Commands("maximize");
		
		get_Url("https://www.amazon.in/");
		
		implicit_Wait("seconds", 900);
		
		// Search Functionality
		
		log.info("Home Page Opened");
		
		WebElement fashion_Lnk = driver.findElement(By.xpath("//a[text() = 'Fashion']")); 
		click_On_Element(fashion_Lnk);
		
		WebElement  salesn_Deals= driver.findElement(By.xpath("//a[@aria-label = 'Sales & Deals']")); // CLick on Sales & Deals Link
		actions(salesn_Deals, "movetoelement");
		
		WebElement sunglasses_Lnk = driver.findElement(By.xpath("(//a[@class='mm-merch-panel'])[20]")); // Image Link
		//WebElement sunglasses = driver.findElement(By.xpath("//h3[text()='Sunglasses']"));
		actions(sunglasses_Lnk, "movetoelement");
		actions(sunglasses_Lnk, "click");
		
		log.info("Clicked on sunglasses image");
      	
		WebElement sunglass_Colour = driver.findElement(By.xpath("(//div[@class='colorsprite aok-float-left'])[1]"));
		javascript_Executor_Scroll_Or_Click("scroll", sunglass_Colour);
		javascript_Executor_Scroll_Or_Click("click", sunglass_Colour);
		
		log.info("Sunglass Colour selected");
		
		WebElement sunglass = driver.findElement(By.xpath("(//img[@class='s-image'])[6]"));
		javascript_Executor_Scroll_Or_Click("scroll", sunglass);
		javascript_Executor_Scroll_Or_Click("click", sunglass);
		
		single_Window_Handling(); // single window handling 
		
		WebElement sunglass_Quantity = driver.findElement(By.xpath("//select[@id='quantity']"));
	    Thread.sleep(1000);
		select_By_Value(sunglass_Quantity, "2");
		
		WebElement add_To_Cart_Btn = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
		click_On_Element(add_To_Cart_Btn);

		sleep(3000);
		
		takes_Screenshot("C:\\Users\\Tharani\\eclipse-workspace\\eclipse-projects\\Cucumber_Project_Amazon_Search\\Screenshot\\SunglassPic.png"); //Screenshot of Add to cart Page
		
		log.info("Sunglass added to cart");
	}
}
