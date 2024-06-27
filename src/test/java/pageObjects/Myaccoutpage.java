package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myaccoutpage extends BasePage{

	public Myaccoutpage(WebDriver driver) {
		super(driver);
		
	}
	

	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msgHeading;
	
	@FindBy(linkText="Logout")
	WebElement btnlogout;
	
	public boolean isMyaccoutpageExists()
	{
		try
		{
		return(msgHeading.isDisplayed());
	}
	catch(Exception e)
	{
		return(false);
	}
}
	public  void clickLogout()
	{
		btnlogout.click();
	}
	
}
