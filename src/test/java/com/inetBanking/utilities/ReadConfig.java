package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
  Properties property;
  
  public ReadConfig()
  {
	 File src=new File("./Configuration/config.properties");
	 
	 try
	 {
		FileInputStream inputstream=new FileInputStream(src);
		property=new Properties();
		property.load(inputstream);
	 }
	 catch(Exception e)
	 {
		System.out.println("Unable to find property file in Configuration folder"); 
	 } 
  }
  
  //returns base url from this method
  public String getApplicationURL()
  {
	 String url=property.getProperty("baseURL");
	 return url;
  }
  
  //returns username from this method
  public String getUsername()
  {
	 String username=property.getProperty("username");
	 return username; 
  }
  
  //returns password from this method
  public String getPassword()
  {
	 String password=property.getProperty("password");
	 return password; 
  }
  
  //returns chrome path from this method
  public String getChromepath()
  {
	 String chromepath=property.getProperty("chromepath");
	 return chromepath;
  }
  
  //returns ie path from this method
  public String getIEpath()
  {
	 String iepath=property.getProperty("iepath");
	 return iepath; 
  }
  
  //returns firefox path from this method
  public String getFirefoxpath()
  {
	 String firefoxpath=property.getProperty("firefoxpath");
	 return firefoxpath; 
  }
}

