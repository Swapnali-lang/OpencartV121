package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.Baseclass;

 public class TC_AccountRegistrationTest extends Baseclass {
	
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() throws InterruptedException {
		
	logger.info("**** Staring TC_AccountRegistrationTest ****");//log statements
	try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My account link..");
		hp.clickRegister();
		logger.info("Clicked on Register link...");
		
		logger.info("Providing customer details..");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");
		regpage.setTelephone(randomeNumber());
		
		//String password=randomAlphaNumeric
		
		String password=randomeAlphaNumberic();
		
        regpage.setPassword(password);
        regpage.setConfirmPassword(password);
        
        regpage.setPrivacyPolicy();
        regpage.clickContinue();
       
        logger.info("Validating expected messge...");
        String confmsg=regpage.getConfirmationmsg();
        Assert.assertEquals(confmsg,"Your Account Has Been Created!");
		}
	
	catch (Exception e)
	{
		logger.error("Test Failed");
		//logger.debug("Debug logs..");
		//Assert.fail();
	}
	}
 }


