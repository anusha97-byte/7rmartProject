package testDataPackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base {
	ManageCategoryPage managecategorypage;
	LogoutPage logoutpage;

	@Test(description = "to add categories with photos")
	public void verify_UserIs_AbleTo_AddCategoryInManageCategory() throws IOException {
		String user = ExcelUtility.getStringData(1, 0, "LoginPage");
		String pass = ExcelUtility.getStringData(1, 1, "LoginPage");
		String category1 = ExcelUtility.getStringData(1, 0, "ManageCategory");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(user).enterPassword(pass);
		logoutpage = loginpage.clickSigninButton();
		managecategorypage = logoutpage.manageCategoryMoreInfo();
		managecategorypage.clickNewButton().enterTheCategory(category1).chooseTheFile().clickRadioButtonNo()
				.clickSaveButton();
		boolean errorpagedisplayed = managecategorypage.isErrorPageDisplayed();
		Assert.assertTrue(errorpagedisplayed, Constant.ADDCATEGORY);
	}

	@Test(description = "To update the category")
	public void verify_UserIs_AbleTo_UpdateCategoryInManageCategory() throws IOException {
		String user = ExcelUtility.getStringData(1, 0, "LoginPage");
		String pass = ExcelUtility.getStringData(1, 1, "LoginPage");
		String category1 = ExcelUtility.getStringData(1, 0, "ManageCategory");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(user).enterPassword(pass);
		logoutpage = loginpage.clickSigninButton();
		managecategorypage = logoutpage.manageCategoryMoreInfo();
		managecategorypage.clickUpdateIcon().enterTheCategory(category1).chooseTheFile().clickUpdateButton();
		boolean alertdisplyed = managecategorypage.isAlertDisplayed();
		Assert.assertTrue(alertdisplyed, Constant.UPDATECATEGORY);
	}
}
