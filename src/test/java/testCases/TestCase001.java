package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TestCase001 extends BaseClass
{
@Test
void login_with_Invalid()
{
	logger.debug("Test001 STarted");
	logger.info("Opening Chrome and webpage");
	try
	{
		HomePage hp=new HomePage(driver);
		hp.enterUsername(rb.getString("username"));
		hp.enterPassword(rb.getString("password"));
		hp.clickLogin();
		Thread.sleep(5000);
		
	}
	catch(Exception e)
	{
		Assert.fail();
	}
	logger.info("Test Completed");
	
}
}
