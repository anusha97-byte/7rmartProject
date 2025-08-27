package testDataPackage;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminUserPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;


public class AdminUserTest extends Base
{
	@Test(description="To create new Admin User Informations",retryAnalyzer =retry.Retry.class)
	public void addAdminUserInformations() throws IOException
	{
		String user=ExcelUtility.getStringData(1, 0,"LoginPage");
		String pass=ExcelUtility.getStringData(1,1,"LoginPage");
		//String username=ExcelUtility.getStringData(1, 0,"AdminUser");
		//String password=ExcelUtility.getStringData(1,1,"AdminUser");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(user);
		loginpage.enterPassword(pass);
		loginpage.clickSigninButton();
		AdminUserPage adminpage=new AdminUserPage(driver);
		adminpage.clickMoreInfo();
		adminpage.clickNewButton();
		FakerUtility fakerutility=new FakerUtility();
		String username=fakerutility.generateUsername();
		String password=fakerutility.generatePassword();
		adminpage.enterUsername(username);
		adminpage.enterPassword(password);
		adminpage.selectUserType();
		adminpage.clickSaveButton();
		boolean alertdisplayed=adminpage.isAlertDisplayed();
		Assert.assertTrue(alertdisplayed,"After saving new username and password alert is not displayed");
	}
	@Test(description="To Update the adminuser informations",groups = {"smoke"})
	public void updateAdminUserInformation() throws IOException
	{
		String user=ExcelUtility.getStringData(1, 0,"LoginPage");
		String pass=ExcelUtility.getStringData(1,1,"LoginPage");
		//String username=ExcelUtility.getStringData(2, 0,"AdminUser");
		//String password=ExcelUtility.getStringData(2,1,"AdminUser");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(user);
		loginpage.enterPassword(pass);
		loginpage.clickSigninButton();
		AdminUserPage adminpage=new AdminUserPage(driver);
		adminpage.clickMoreInfo();
		adminpage.clickUpdateIcon();
		FakerUtility fakerutility=new FakerUtility();
		String username=fakerutility.generateUsername();
		String password=fakerutility.generatePassword();
		adminpage.enterUsername(username);
		adminpage.enterPassword(password);
		adminpage.selectUserType();
		adminpage.clickUpdateButton();
		boolean alertdisplayed=adminpage.isAlertDisplayed();
		Assert.assertTrue(alertdisplayed,"After updating new username and password alert is not displayed");
	}
}
