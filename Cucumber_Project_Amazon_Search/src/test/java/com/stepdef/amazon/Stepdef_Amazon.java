package com.stepdef.amazon;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import com.cucumber.runner.Cucumber_Amazon_Runner;
import com.pageobjectmanager.amazon.Page_Object_Manager_Amazon;
import com.utilityFiles.Utility_Files;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class Stepdef_Amazon extends Utility_Files {
	
	public static WebDriver driver = Cucumber_Amazon_Runner.driver;
	
	public static Logger log = Logger.getLogger(Stepdef_Amazon.class);
	
	public static Page_Object_Manager_Amazon manage = new Page_Object_Manager_Amazon(driver);
	
	@Before
	public void Logging()
	{
		PropertyConfigurator.configure("log4j.properties");
	}
	@Given("User Launch The Amazon Url")
	public void user_launch_the_amazon_url() {
		
		window_Commands("maximize");
		
		get_Url("https://www.amazon.in/");
		
		log.info("Home Page Opened");
	}
	
	// Search Functionality
	@When("User Click On Fashion Link")
	public void user_click_on_fashion_link() {
		
		click_On_Element(manage.getHomePage().getFashion_Lnk()); // Click on Fashion Link
	}
	@When("User Click On Sales & Deals Link")
	public void user_click_on_sales_deals_link() {
	    
		actions(manage.getFashionPage().getSalesn_Deals(), "movetoelement"); //Click on Sales & Deals Link 
	}
	@When("User Click on Sunglasses Picture Link")
	public void user_click_on_sunglasses_picture_link() {
	    
		actions(manage.getFashionPage().getSunglasses_Lnk(),"movetoelement"); //Click on Sunglass Image Icon Link
		actions(manage.getFashionPage().getSunglasses_Lnk(), "click");
		
		log.info("Clicked on sunglasses image");
	}
	@When("User Click On Colour Check Box")
	public void user_click_on_colour_check_box() {
	    
		javascript_Executor_Scroll_Or_Click("scroll",manage.getSunglassColourPage().getSunglass_Colour()); //Choose Sunglass Colour - Black
		javascript_Executor_Scroll_Or_Click("click", manage.getSunglassColourPage().getSunglass_Colour());
		
		log.info("Sunglass Colour selected");
	}
	@When("User Click on Sunglass Picture")
	public void user_click_on_sunglass_picture() throws InterruptedException {
	    
		javascript_Executor_Scroll_Or_Click("scroll", manage.getSunglassColourPage().getSunglass()); //Choose Sunglass
		javascript_Executor_Scroll_Or_Click("click", manage.getSunglassColourPage().getSunglass());
		
		sleep(5000);
		
		single_Window_Handling(); // single window handling 
	}
	
	@When("User Select Quantity {string} Of Sunglass")
	public void user_select_quantity_of_sunglass(String sunglass_Quantity) throws InterruptedException {
	   
		select_By_Value(manage.getSunglassOrder().getSunglass_Quantity(), sunglass_Quantity); //Change the sunglass Quantity - 2
	}
	@Then("User Click On Add To Cart Btn, It Navigates To {string}")
	public void user_click_on_add_to_cart_btn_it_navigates_to(String expected_Title) throws IOException, InterruptedException {
	   
		click_On_Element(manage.getSunglassOrder().getAdd_To_Cart_Btn());
		
		String actual_Title = driver.getTitle();
		
		sleep(3000);
		
		takes_Screenshot("C:\\Users\\Tharani\\eclipse-workspace\\eclipse-projects\\Cucumber_Project_Amazon_Search\\Screenshot\\SunglassPic.png"); //Screenshot of Add to cart Page
		
		System.out.println("Actual Title: " + actual_Title);
		
		Assert.assertEquals(expected_Title, actual_Title); // Validating the Page Title
		
		log.info("Sunglass added to cart");
	}
}