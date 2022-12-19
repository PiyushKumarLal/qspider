package com.ecom.spicejet.framework;

import org.openqa.selenium.WebDriver;

import com.ecom.spicejet.genericLibrary.FileUtility;
import com.ecom.spicejet.genericLibrary.IconstantPath;
import com.ecom.spicejet.genericLibrary.PropertyFileKeys;
import com.ecom.spicejet.genericLibrary.WebDriverUtility;
import com.ecom.spicejet.objectRepository.HomePage;

public class BookFlightTicket {

	public static void main(String[] args)  {
		
//		Object for Generic Utility 
		 FileUtility fLib=new  FileUtility();
		 WebDriverUtility wLib=new WebDriverUtility();

		//Fetch Data from property file
		 String browser = fLib.getDataFromPropertyFile(IconstantPath.Property_File_Path,PropertyFileKeys.BROWSER.convertToString());
		 String url = fLib.getDataFromPropertyFile(IconstantPath.Property_File_Path, PropertyFileKeys.URL.convertToString());
		 String t = fLib.getDataFromPropertyFile(IconstantPath.Property_File_Path,PropertyFileKeys.TIMEOUT.convertToString());
			long timeout=Long.parseLong(t);
			String limit = fLib.getDataFromPropertyFile(IconstantPath.Property_File_Path,PropertyFileKeys.LIMIT.convertToString());

			//Launch the Browser
			WebDriver driver = wLib.launchBrowser(browser,url );
			
			//Maximize the Browser
			wLib.settingUpBrowser(driver,timeout);
			
			//Created Object For POM classes
			HomePage hp=new HomePage(driver);
			
			

			//click On RoundTrip
			hp.roundTripRadioButton();
		 
	}
}
