package testDataPackage;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUserPage;
import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUserTest extends Base {
	AdminUserPage adminuserpage;
	LogoutPage logoutpage;

	@Test(description = "To create new Admin User Informations", retryAnalyzer = retry.Retry.class)
	public void verify_User_IsAbleTo_AddAdminUserInformations() throws IOException {
		String user = ExcelUtility.getStringData(1, 0, "LoginPage");
		String pass = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(user).enterPassword(pass);
		logoutpage = loginpage.clickSigninButton();
		adminuserpage = logoutpage.adminUserMoreInfo();
		FakerUtility fakerutility = new FakerUtility();
		String username = fakerutility.generateUsername();
		String password = fakerutility.generatePassword();
		adminuserpage.clickNewButton().enterUsername(username).enterPassword(password).selectUserType()
				.clickSaveButton();
		boolean alertdisplayed = adminuserpage.isAlertDisplayed();
		Assert.assertTrue(alertdisplayed, Constant.ADDADMININFORMATION);
	}

	@Test(description = "To Update the adminuser informations", groups = { "smoke" })
	public void verify_UserIs_AbleTo_UpdateAdminUserInformation() throws IOException {
		String user = ExcelUtility.getStringData(1, 0, "LoginPage");
		String pass = ExcelUtility.getStringData(1, 1, "LoginPage");
		// String username=ExcelUtility.getStringData(2, 0,"AdminUser");
		// String password=ExcelUtility.getStringData(2,1,"AdminUser");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(user).enterPassword(pass);
		// loginpage.enterPassword(pass);
		logoutpage = loginpage.clickSigninButton();
		// AdminUserPage adminpage=new AdminUserPage(driver);
		adminuserpage = logoutpage.adminUserMoreInfo();
		// adminpage.clickUpdateIcon();
		FakerUtility fakerutility = new FakerUtility();
		String username = fakerutility.generateUsername();
		String password = fakerutility.generatePassword();
		adminuserpage.clickUpdateIcon().enterUsername(username).enterPassword(password).selectUserType()
				.clickUpdateButton();
		/*
		 * adminpage.enterUsername(username); adminpage.enterPassword(password);
		 * adminpage.selectUserType(); adminpage.clickUpdateButton();
		 */
		boolean alertdisplayed = adminuserpage.isAlertDisplayed();
		Assert.assertTrue(alertdisplayed, Constant.UPDATEADMININFORMATION);
	}
}
