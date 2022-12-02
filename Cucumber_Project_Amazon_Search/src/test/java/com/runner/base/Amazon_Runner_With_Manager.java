package com.runner.base;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pageobjectmanager.amazon.Page_Object_Manager_Amazon;
import com.utilityFiles.Utility_Files;

public class Amazon_Runner_With_Manager extends Utility_Files{
		
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
			
			click_On_Element(manage.getHomePage().getFashion_Lnk()); // Click on Fashion Link
			
			actions(manage.getFashionPage().getSalesn_Deals(), "movetoelement"); //Click on Sales & Deals Link 
			
			actions(manage.getFashionPage().getSunglasses_Lnk(),"movetoelement"); //Click on Sunglass Image Icon Link
			actions(manage.getFashionPage().getSunglasses_Lnk(), "click");
			
			log.info("Clicked on sunglasses image");
	      	
			javascript_Executor_Scroll_Or_Click("scroll",manage.getSunglassColourPage().getSunglass_Colour()); //Choose Sunglass Colour - Black
			javascript_Executor_Scroll_Or_Click("click", manage.getSunglassColourPage().getSunglass_Colour());
			
			log.info("Sunglass Colour selected");
			
			javascript_Executor_Scroll_Or_Click("scroll", manage.getSunglassColourPage().getSunglass()); //Choose Sunglass
			javascript_Executor_Scroll_Or_Click("click", manage.getSunglassColourPage().getSunglass());
			
			sleep(3000);
			
			single_Window_Handling(); // single window handling 
			
			select_By_Value(manage.getSunglassOrder().getSunglass_Quantity(),"2"); //Change the sunglass Quantity - 2
			
		    click_On_Element(manage.getSunglassOrder().getAdd_To_Cart_Btn());
		
			sleep(3000);
			
			takes_Screenshot("C:\\Users\\Tharani\\eclipse-workspace\\eclipse-projects\\Cucumber_Project_Amazon_Search\\Screenshot\\SunglassPic.png"); //Screenshot of Add to cart Page
			
			log.info("Sunglass added to cart");
		}
	}