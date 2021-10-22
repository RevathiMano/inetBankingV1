package com.inetBanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pages.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{

	@Test
	public void loginTest() throws IOException, InterruptedException
	{
   
	 logger.info("URL is opened");
     LoginPage lp=new LoginPage(driver);
     
     lp.setUsername(username);
     logger.info("Username is entered");
     
     lp.setPassword(password);
     logger.info("Password is entered");
     
     lp.clickSubmit();
     Thread.sleep(3000);
     
     if(driver.getTitle().equals("Guru99 Bank Home Page"))
     {
    	Assert.assertTrue(true); 
    	logger.info("Login is passed");
     }
     else
     {
    	captureScreenshot(driver,"loginTest"); //takes screenshot when the tc is failed
    	Assert.assertTrue(false);
    	logger.info("Login is failed");
     }
    
	}
}  
