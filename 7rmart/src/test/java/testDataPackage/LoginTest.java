package testDataPackage;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	LogoutPage logoutpage;
	@Test(priority = 1, description = "Login with Valid username and password")
	public void verify_UserIs_AbleTo_LoginWithValidCredentials() throws IOException {
		String user = ExcelUtility.getStringData(1, 0, "LoginPage");
		String pass = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(user).enterPassword(pass);
		//loginpage.enterPassword(pass);
		logoutpage=loginpage.clickSigninButton();
		boolean isdashboarddisplayed = loginpage.isHomePageLoaded();
		Assert.assertTrue(isdashboarddisplayed, Constant.CORRECTUSERNAMEANDPASSWORD);
	}

	@Test(priority = 2, description = "Login with invalid credentials")
	public void verify_UserIs_AbleTo_LoginWithInvalidCredentials() throws IOException {

		String user = ExcelUtility.getStringData(2, 0, "LoginPage");
		String pass = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(user).enterPassword(pass);
		logoutpage=loginpage.clickSigninButton();
		boolean isAlertMessageDisplayed = loginpage.isAlertDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed, Constant.INCORRECTUSERNAMEANDPASSWORD);
	}

	@Test(priority = 3, description = "Login with Valid username and invalid password")
	public void verify_UserIs_AbleTo_loginWithUsernameValidAndPasswordInvalid() throws IOException {

		String user = ExcelUtility.getStringData(3, 0, "LoginPage");
		String pass = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(user).enterPassword(pass);
		logoutpage=loginpage.clickSigninButton();
		boolean isAlertMessageDisplayed = loginpage.isAlertDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed, Constant.CORRECTUSERNAMEANDINCORRECTPASSWORD);
	}

	@Test(priority = 4, description = "Login with valid password and invalid username", dataProvider = "LoginProvider")
	public void verify_UserIs_AbleTo_LoginWithPasswordValidAndUsernameInvalid(String user, String pass)
			throws IOException {

		// String user=ExcelUtility.getStringData(4,0,"LoginPage");
		// String pass=ExcelUtility.getStringData(4,1,"LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(user).enterPassword(pass);
		logoutpage=loginpage.clickSigninButton();
		boolean isAlertMessageDisplayed = loginpage.isAlertDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed, Constant.INCORRECTUSERNAMEANDCORRECTPASSWORD);
	}

	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() throws IOException {
		return new Object[][] {
				{ ExcelUtility.getStringData(4, 0, "loginpage"), ExcelUtility.getStringData(4, 1, "loginpage") } };
	}
}
