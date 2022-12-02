Feature: Amazon Search Functionality Fashion 

Background: Launch Url

Given User Launch The Amazon Url

@FashionLink
Scenario: Amazon Fashion Link

When User Click On Fashion Link 

And User Click On Sales & Deals Link 

And User Click on Sunglasses Picture Link

And User Click On Colour Check Box 

And User Click on Sunglass Picture

And User Select Quantity "3" Of Sunglass

Then User Click On Add To Cart Btn, It Navigates To "Amazon.in Shopping Cart" 