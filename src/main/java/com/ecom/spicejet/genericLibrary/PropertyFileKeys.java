package com.ecom.spicejet.genericLibrary;

public enum PropertyFileKeys {
	BROWSER("browser"), URL("url"),TIMEOUT("timeout"),LIMIT("limit");
	
	private String keys;
	
	//Setter
	private PropertyFileKeys(String keys)
	{
		this.keys=keys;
	}
	
	//Getter
	public String convertToString()
	{
		return keys.toString();
	}
}
