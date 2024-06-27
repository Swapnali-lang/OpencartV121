package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	WebDriver driver;
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txttelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfirmpassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkPrivacy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btncontinue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setFirstName(String fname) {
	txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
		}
	
	public void setEmail(String email) {
		txtemail.sendKeys(email);
		}
	
	public void setTelephone(String tel) {
		txttelephone.sendKeys(tel);
		}
	
	public void setPassword(String pwd ) {
		txtpassword.sendKeys(pwd);
		}
	
	public void setConfirmPassword(String pwd ) {
		txtConfirmpassword.sendKeys(pwd);
		}
	
	public void setPrivacyPolicy() {
		chkPrivacy.click();
	}
		public void clickContinue() {
		btncontinue.click();
			//btncontinue.submit();
			//Actions act=new Actions(driver);
			
		}
		
		public String getConfirmationmsg( ) {
			try {
				return (msgConfirmation.getText());
			} catch (Exception e) {
				return (e.getMessage());

			}
		}
	}






