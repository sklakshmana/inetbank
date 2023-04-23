package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		//log.info("User name is provided");
		
		Thread.sleep(2000);
		lp.setPassword(password);
		//log.info("Password is provided");
		
		lp.clickSubmit();
		System.out.println("444");
		
		Thread.sleep(3000);    	// 3 seconds
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		 
		addcust.clickAddNewCustomer();
		
		Thread.sleep(2000); 
		System.out.println("555");
		//log.info("Providing customer details.....");
		
		addcust.custName("TestUser");
		addcust.custgender("male");
		addcust.custdob("10", "15", "1995");
		Thread.sleep(5000);
		addcust.custaddress("India");
		addcust.custcity("Bangalore");
		addcust.custstate("KA");
		addcust.custpinno("560097");
		addcust.custtelephoneno("987890091");
		
		String email=randomstring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("Password1@");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		//log.info("validation started");
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		System.out.println("Response "+res);
		
		if(res==true)
		{
			
			Assert.assertTrue(true);
			//log.info("test case passed....");
		}
		else
		{
			//log.info("test case failded....");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
	}

}
