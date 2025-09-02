package testDataPackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;

public class LogoutTest extends Base
{
	@Test(description="To logout the page")
	public void verify_UserIs_AbleTo_LogoutFromTheApplication() throws IOException
	{
		String user=ExcelUtility.getStringData(1,0,"LoginPage");
		String pass=ExcelUtility.getStringData(1,1,"LoginPage");
		LoginPage loginpage= new LoginPage(driver);
		loginpage.enterUsername(user);
		loginpage.enterPassword(pass);
		loginpage.clickSigninButton();
		LogoutPage logoutpage=new LogoutPage(driver);
		logoutpage.clickAdmin();
		logoutpage.clickLogoutButton();
		boolean displayloginpage=logoutpage.displayLoginPage();
		Assert.assertTrue(displayloginpage,"After logout loginpage is not displayed");
		
	}
}
