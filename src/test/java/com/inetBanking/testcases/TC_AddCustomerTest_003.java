package com.inetBanking.testcases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import com.inetBanking.pages.AddCustomerPage;
import com.inetBanking.pages.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{
	
    @Test
    public void addNewCustomer() throws InterruptedException, IOException
    {
    	LoginPage lp=new LoginPage(driver);
    	lp.setUsername(username); //get username from baseclass (config properties file)
    	logger.info("Username is provided");
    	lp.setPassword(password);
    	logger.info("Password is provided");
    	lp.clickSubmit();
    	logger.info("Login is successful");
    	//login process is done
    	Thread.sleep(1000);
    	
    	
    	AddCustomerPage addCust=new AddCustomerPage(driver);
    	addCust.clickCustomer();
    	logger.info("Clicked new customer link");
    	
    	logger.info("Adding customer details:");
    	addCust.setcname("Priya");
    	addCust.setGender("male");
    	
    	Thread.sleep(5000);
    	addCust.setdob("10","15","1985");
    	//addCust.custdob("10","15","1985");
    	
		Thread.sleep(8000); //wait for sometime bcoz value needs to be updated in date of birth field
    	
    	addCust.setAddress("Adukambarai");
    	addCust.setCity("Vellore");
    	addCust.setState("TN");
    	addCust.setPin(123456);
    	addCust.setMobno("8888899999");
    	
    	//addCust.setEmail("abc@g.com");  we cannot give email as paramaters bcoz user should have separate mail id
    	String mail=randomString()+"@gmail.com";
    	addCust.setEmail(mail);
    	
    	addCust.setPassword("pwd");
    	
    	Thread.sleep(1000);
    	
    	addCust.clickSubmit();
    	
    	Thread.sleep(3000);
    	
    	logger.info("validation begins...");
    	Alert alert=driver.switchTo().alert();
    	if(alert.getText().equals("Please fill all fields:"))
    	{
    		alert.dismiss();
    		System.out.println("Alert dismissed");
    	}
    	
    	
    	boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
    	
    	if(res==true)
    	{
    	  logger.info("test case passed");
    	  Assert.assertTrue(true);	
    	}
    	else
    	{
    	  captureScreenshot(driver,"addNewCustomer");
    	  logger.info("test case failed");
    	  Assert.assertTrue(false);
    	}
    }
   
}
