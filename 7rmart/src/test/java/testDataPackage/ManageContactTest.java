package testDataPackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageContactTest extends Base {
	ManageContactPage managecontactpage;
	LogoutPage logoutpage;

	@Test(description = "To update the contact")
	public void verify_UserIs_AbleTo_UpdateTheContact() throws IOException {
		String user = ExcelUtility.getStringData(1, 0, "LoginPage");
		String pass = ExcelUtility.getStringData(1, 1, "LoginPage");
		String phone = ExcelUtility.getIntergerData(1, 0, "ManageContact");
		// String email=ExcelUtility.getStringData(1, 1, "ManageContact");
		// String address1=ExcelUtility.getStringData(1, 2,"ManageContact");
		String dtime = ExcelUtility.getStringData(1, 3, "ManageContact");
		String climit = ExcelUtility.getIntergerData(1, 4, "ManageContact");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(user).enterPassword(pass);
		// loginpage.enterPassword(pass);
		logoutpage = loginpage.clickSigninButton();
		// ManageContactPage managecontactpage=new ManageContactPage(driver);
		managecontactpage = logoutpage.manageContactMoreInfo();

		FakerUtility fakerutility = new FakerUtility();
		String email = fakerutility.generateEmail();
		String address1 = fakerutility.generateAddress();
		managecontactpage.clickUpdateIcon().enterPhoneNumber(phone).enterEmailId(email).enterAddress(address1)
				.enterDeliveryTime(dtime).enterChargeLimit(climit).clickUpdateButton();

		boolean alertdisplayed = managecontactpage.isAlertDisplayed();
		Assert.assertTrue(alertdisplayed, Constant.UPDATECONTACT);
	}
}
