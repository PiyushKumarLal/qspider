package com.ecom.spicejet.genericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
  
	 private FileInputStream fis;
	 
	 /**
	  * This method is used to fetch the value from Property Files
	  * @param filePath
	  * @param Key
	  * @return
	  */
	   public String getDataFromPropertyFile(String filePath,String Key)
	   {
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		  Properties p = new Properties();
		  try {
			p.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		  String value = p.getProperty(Key).trim();
		  return value;
	   }
	   
	   /**
	    * This method is used to Close the Property File
	    */
	     public void closePropertyFile()
	     {
	    	 try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	     }
	     
	     /**
	     * It is used to read the data from commonData.properties File based on Key which you pass as an 
	     argument
	     * @param key
	     * @throws Throwable 
	     */
	      public String getPropertyKeyValue(String key) throws Throwable {
	      FileInputStream fis = new FileInputStream("./src/test/resources/commondata2.properties");
	      Properties pobj = new Properties();
	      pobj.load(fis);
	      String value = pobj.getProperty(key);
	     return value;
	      
	      }
}
