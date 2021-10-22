package com.inetBanking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage 
{
   WebDriver ldriver;
   
   public AddCustomerPage(WebDriver rdriver)
   {
	 ldriver=rdriver;
	 PageFactory.initElements(rdriver,this);
   }
   
   /*
	@FindBy(how = How.XPATH, using ="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement lnkAddNewCustomer;

	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement txtCustomerName;
	*/
   
   @FindBy(linkText="New Customer")
   @CacheLookup
   WebElement NewCustomerLink;
   
   @FindBy(name="name")
   @CacheLookup
   WebElement customername;
   
   @FindBy(name="rad1")
   @CacheLookup
   WebElement gender;
   
   @FindBy(name="dob")
   @CacheLookup
   WebElement dob;
   
   @CacheLookup
	@FindBy(how = How.ID_OR_NAME, using = "dob")
	WebElement txtdob;
   
   @FindBy(name="addr")
   @CacheLookup
   WebElement address;
   
   @FindBy(name="city")
   @CacheLookup
   WebElement city;
   
   @FindBy(name="state")
   @CacheLookup
   WebElement state;
   
   @FindBy(name="pinno")
   @CacheLookup
   WebElement pin;
   
   @FindBy(name="telephoneno")
   @CacheLookup
   WebElement telephone;
   
   @FindBy(name="emailid")
   @CacheLookup
   WebElement email;
   
   @FindBy(name="password")
   @CacheLookup
   WebElement password;
   
   @FindBy(name="sub")
   @CacheLookup
   WebElement submitbtn;
   
   @FindBy(name="res")
   @CacheLookup
   WebElement resetbtn;
   
   public void clickCustomer()
   {
	  NewCustomerLink.click(); 
   }
   
   public void setcname(String cname)
   {
	 customername.sendKeys(cname);   
   }
   
   public void setGender(String cgender)
   {
	  gender.click(); 
   }
   
   public void setdob(String dd, String mm, String year)
   {
	 dob.sendKeys(dd);
	 dob.sendKeys(mm);
	 dob.sendKeys(year);
   }
   
   public void custdob(String dd, String mm, String year) 
   {
		txtdob.sendKeys(dd);
		txtdob.sendKeys(mm);
		txtdob.sendKeys(year);
		
	}
   
   public void setAddress(String caddress)
   {
	 address.sendKeys(caddress);   
   }
   
   public void setCity(String ccity)
   {
	 city.sendKeys(ccity);   
   }
   
   public void setState(String cstate)
   {
	 state.sendKeys(cstate);   
   }
   
   public void setPin(int cpin)  //sendkeys will accept only string so convert int to string
   {
	 pin.sendKeys(String.valueOf(cpin));   
   }
   
   public void setMobno(String mobno)
   {
	 telephone.sendKeys(mobno);   
   }
   
   public void setEmail(String mail)
   {
	 email.sendKeys(mail);   
   }
   
   public void setPassword(String pwd)
   {
	 password.sendKeys(pwd);   
   }
   
   public void clickSubmit()
   {
	 submitbtn.click();
   }
}
