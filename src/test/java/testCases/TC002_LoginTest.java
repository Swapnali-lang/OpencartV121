package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.Myaccoutpage;
import testBase.Baseclass;

public class TC002_LoginTest extends Baseclass {
	@Test(groups={"Sanity","Master"})
	public void verify_login() {
		logger.info("***Starting TC_002_LoginTest***");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.ClickLogin();
		
		Myaccoutpage macc=new Myaccoutpage(driver);
		boolean targetpage=macc.isMyaccoutpageExists();
		
		Assert.assertEquals(targetpage,true,"login failed");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***Finished TC_002_LoginTest***");

}
}
