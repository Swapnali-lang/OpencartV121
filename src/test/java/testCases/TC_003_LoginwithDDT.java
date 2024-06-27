package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.Myaccoutpage;
import testBase.Baseclass;
import utilities.DataProviders;

public class TC_003_LoginwithDDT extends Baseclass {
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="datadriven")//getting data provider from different package
	
   public void verify_loginDDDT(String email,String pwd,String exp)
{
		try
		{
       //Home page
	   HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.ClickLogin();
		
		Myaccoutpage macc=new Myaccoutpage(driver);
		boolean targetpage=macc.isMyaccoutpageExists();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetpage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetpage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
				}
			
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}

}
}