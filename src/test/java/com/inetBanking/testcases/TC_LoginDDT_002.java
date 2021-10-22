package com.inetBanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pages.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{

	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException, IOException
	{
	  LoginPage lp=new LoginPage(driver);
	  lp.setUsername(user);
	  logger.info("username provided");
	  lp.setPassword(pwd);
	  logger.info("password provided");
	  lp.clickSubmit();
	  
	  //captureScreenshot(driver,"loginDDT");
	  
	  Thread.sleep(3000);
	  
	  if(IsAlertPresent()==true)
	  {
		  driver.switchTo().alert().accept(); //close alert
		  driver.switchTo().defaultContent(); //go to main login page
		  Thread.sleep(3000);
		  Assert.assertTrue(false);
		  logger.warn("Login failed");
		  
	  }
	  else
	  {
		  Thread.sleep(3000);
		  Assert.assertTrue(true);
		  logger.warn("Login passed");
		  lp.clickLogout();
		  
		  Thread.sleep(3000);
		  
		  driver.switchTo().alert().accept(); //close logout alert
		  driver.switchTo().defaultContent();
	  }
	}
	
	public boolean IsAlertPresent() //user defined method to check whether alert is present or not
	{
	   try
	   {
		   driver.switchTo().alert();
		   return true;
	   }
	   catch(Exception e)
	   {
		   return false;
	   }
	   
	}
	
	//Data provider method
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
	  //get details from excel and store in two dimensional array
	  String xlpath=System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/LoginData.xlsx";
	  
	  int rowcount=XLUtils.getRowCount(xlpath,"Sheet1");  //returns row count with the help of excel path and sheet name
	  int colcount=XLUtils.getCellCount(xlpath, "Sheet1", 1); //returns col count with the help of excel path, sheet name and 1st row
		
	  String logindata[][]=new String[rowcount][colcount];
	  
	  for(int i=1;i<=rowcount;i++)
	  {
		 for(int j=0;j<colcount;j++)
		  {
			 // 0 0 in 2d array but 1 0 from the excel sheet
			 logindata[i-1][j]=XLUtils.getCellData(xlpath,"Sheet1", i, j); // 1 0 
		 }
	  }
	 return logindata;
	}
}
