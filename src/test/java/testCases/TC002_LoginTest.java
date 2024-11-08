 package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass
{
	@Test(groups={"Sanity","Master"})
	public void verify_login()
	{
		logger.info("****Starting TC002 LoginPage****");
		logger.debug("Capturing application debug logs");
		try
		{
		//Home Page
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		logger.info("clicked on myaccount link on the home page..");
		hp.linkLogin();
		logger.info("clicked on login link under myaccount..");
		
	
		//LoginPage
		LoginPage lp =new LoginPage(driver);
		logger.info("Entering valid email and password..");
		lp.setEmail(p.getProperty("email"));
		
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		logger.info("clicked on login button..");
		
		//My account page
		MyAccountPage macc=new MyAccountPage(driver);
		
		boolean targetPage=macc.isMyAccountPageExists();
		Assert.assertEquals(targetPage, true,"Login Failed");
	}
		
		catch (Exception e)
		{
			Assert.fail();
		}
		logger.info("****Finished TC002 LoginPage****");
	}
		
	
}
