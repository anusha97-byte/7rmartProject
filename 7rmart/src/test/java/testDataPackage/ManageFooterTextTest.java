package testDataPackage;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtility;

public class ManageFooterTextTest extends Base {
	ManageFooterTextPage managefootertextpage;
	LogoutPage logoutpage;

	@Test(description = "To update the Footer Text")
	public void verify_User_Is_Able_ToUpdate_TheManageFooterText() throws IOException {
		String user = ExcelUtility.getStringData(1, 0, "LoginPage");
		String pass = ExcelUtility.getStringData(1, 1, "LoginPage");
		String address = ExcelUtility.getStringData(1, 0, "FooterText");
		String email2 = ExcelUtility.getStringData(1, 1, "FooterText");
		String phone = ExcelUtility.getIntergerData(1, 2, "FooterText");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(user).enterPassword(pass);
		// loginpage.enterPassword(pass);
		logoutpage = loginpage.clickSigninButton();
		// ManageFooterTextPage managefootertextpage=new ManageFooterTextPage(driver);
		managefootertextpage = logoutpage.manageFooterMoreInfo();
		managefootertextpage.clickUpdateIcon().enterAddress(address).enterEmail(email2).enterPhonenumber(phone)
				.clickUpdateButton();
		boolean alertdisplayed = managefootertextpage.isAlertdisplayed();
		Assert.assertTrue(alertdisplayed, Constant.UPDATEFOOTER);
	}
}
