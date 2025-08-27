package testDataPackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base
{
	@Test(description="to add categories with photos")
	public void addCategory() throws IOException
	{
		String user=ExcelUtility.getStringData(1,0,"LoginPage");
		String pass=ExcelUtility.getStringData(1,1,"LoginPage");
		String category1=ExcelUtility.getStringData(1, 0,"ManageCategory");
		LoginPage loginpage= new LoginPage(driver);
		loginpage.enterUsername(user);
		loginpage.enterPassword(pass);
		loginpage.clickSigninButton();
		ManageCategoryPage managecategorypage=new ManageCategoryPage(driver);
		managecategorypage.clickMoreInfo();
		managecategorypage.clickNewButton();
		managecategorypage.enterTheCategory(category1);
		managecategorypage.chooseTheFile();
		managecategorypage.clickRadioButtonNo();
		managecategorypage.clickSaveButton();
		boolean errorpagedisplayed=managecategorypage.isErrorPageDisplayed();
		Assert.assertTrue(errorpagedisplayed,"After uploading image error mesage is not displayed");
	}
	@Test(description="To update the category")
	public void updateCategory() throws IOException
	{
		String user=ExcelUtility.getStringData(1,0,"LoginPage");
		String pass=ExcelUtility.getStringData(1,1,"LoginPage");
		String category1=ExcelUtility.getStringData(1, 0,"ManageCategory");
		LoginPage loginpage= new LoginPage(driver);
		loginpage.enterUsername(user);
		loginpage.enterPassword(pass);
		loginpage.clickSigninButton();
		ManageCategoryPage managecategorypage=new ManageCategoryPage(driver);
		managecategorypage.clickMoreInfo();
		managecategorypage.clickUpdateIcon();
		managecategorypage.enterTheCategory(category1);
		managecategorypage.clickUpdateButton();
		boolean alertdisplyed=managecategorypage.isAlertDisplayed();
		Assert.assertTrue(alertdisplyed,"After update the category alert is not displayed");
	}
}
