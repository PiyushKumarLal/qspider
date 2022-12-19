package com.ecom.spicejet.genericLibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility {
 
	/**
	 * This method is used to launch based on browser key
	 * @param browser
	 * @return
	 */
	public WebDriver launchBrowser(String browser,String url)
	{
		WebDriver driver=null;	
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(); 
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver(); 
		}
		else if(browser.equals("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver(); 
		}
		else {
			System.out.println("Please enter valid browser name");
		}
		driver.get(url);
		return driver;
	}
	
	/**
	 * This method is used to maximize the browser
	 * @param driver
	 * @param timeout
	 */
	public void settingUpBrowser(WebDriver driver,long timeout)
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeout,TimeUnit.SECONDS);

	}
	
	/**
	 * Wait for page to load before identifying any synchronized element in DOM [HTML-Document]
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/**
	 * Used to select the value from the dropDown based on index
	 * @param driver
	 * @param index
	 */
	public void select(WebElement element , int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * This method is Used to select the value from the dropDown based on value / option available in GUI
	 * @param element
	 * @param value
	 */
	public void select(WebElement element , String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
}
