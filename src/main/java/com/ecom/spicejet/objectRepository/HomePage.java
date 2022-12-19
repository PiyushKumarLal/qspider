package com.ecom.spicejet.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
  @FindBy(xpath="//div[text()='Flights']") private WebElement flightIcon;
  
  @FindBy(xpath="//div[@data-testid='round-trip-radio-button']/div/*[name()='svg']") private WebElement roundTripRadioButton;

  @FindBy(xpath="//div[@data-testid='to-testID-origin']/descendant::div[text()='From']") private WebElement fromDropDown;
 
  @FindBy(xpath="//div[@data-testid='to-testID-destination']/div/div/descendant::input[@autocapitalize='sentences']") private WebElement toDropDown;
  
  @FindBy(xpath="//div[text()='Departure Date']/ancestor::div[@data-testid='departure-date-dropdown-label-test-id']") private WebElement departureDate;
  
  @FindBy(xpath="//div[text()='Return Date']/ancestor::div[@data-testid='return-date-dropdown-label-test-id']") private WebElement returnDate;
  
  @FindBy(xpath="//div[text()='Passengers']/ancestor::div[@data-testid='home-page-travellers']") private WebElement passenger;
 
  @FindBy(xpath="//div[text()='Search Flight']") private WebElement searchButton;
  public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
  
  
  // Business Library
  
   public void clickIcon() {
	   flightIcon.click();
   }
   
   public void roundTripRadioButton()
   {
	   roundTripRadioButton.click();
	   
   }
   
   public void clickOnFrom(String city) {
	   fromDropDown.sendKeys();
   }
   
   public void clickOnTo(String city) {
	   toDropDown.sendKeys(city);;
   }
   
   public void clickOnDepartureDate() {
	   departureDate.click();
   }
   
   public void clickOnReturnDate() {  
	   returnDate.click();
   }
   
   public void clickOnPassenger() {
	   passenger.click();
   }
   
   public void clickOnSearchButton() {
	   searchButton.click();
	   
   }
   }


