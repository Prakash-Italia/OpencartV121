package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() throws InterruptedException
	{
		
		logger.info("****Starting TC001_AccountRegistrationPage****");
		
		
		HomePage hp =new HomePage(driver);
		
		hp.clickMyaccount();
		logger.info("Clicked on my account");
		hp.clickRegister();
		logger.info("Clicked on my Register link");
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		logger.info("Providing customer details");
		regpage.setFirstname(randomString().toUpperCase());
		regpage.setLastname(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomNumber());
		
		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		//Thread.sleep(5000);
		regpage.clickContinue();
		Thread.sleep(5000);
		
		logger.info("Getting confirmation message");
		
		String confmsg=regpage.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
			System.out.println("Test Passed.."+confmsg);
		}
		else
		{
			logger.error("Test Failes..");
			logger.debug("Debug Logs..");
			Assert.assertTrue(false);
		}
		
			
		}
		
		//Assert.assertEquals("Your Account Has Been Created!", confmsg);
}
	

