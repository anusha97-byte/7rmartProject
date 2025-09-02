package testDataPackage;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base
{
	ManageNewsPage managenewspage;
	LogoutPage logoutpage;
	@Test(description="To add a new news ",groups = {"regression"})
	public void verify_UserIs_AbleTo_ManageTheNews() throws IOException
	{
		/*String news="New news is added";
		String user="admin";
		String pass="admin";*/
		String user=ExcelUtility.getStringData(1,0,"LoginPage");
		String pass=ExcelUtility.getStringData(1,1,"LoginPage");
		String news=ExcelUtility.getStringData(1,0,"ManageNews");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(user).enterPassword(pass);
		//loginpage.enterPassword(pass);
		logoutpage=loginpage.clickSigninButton();
		//ManageNewsPage managenews=new ManageNewsPage(driver);
		managenewspage=logoutpage.manageNewsMoreInfo();
		managenewspage.clickNewButton().enterTheNews(news).clickSaveButton();
		//managenewspage.enterTheNews(news);
		//managenews.clickSaveButton();
		boolean alertdisplayed=managenewspage.isAlertDisplayed();
		Assert.assertTrue(alertdisplayed,"After saving new news alert is not displayed");
	}
	@Test(description="To update a news")
	public void verify_UserIs_AbleTo_UpdateTheNews() throws IOException
	{
		/*String news="This is the updated news";
		String user="admin";
		String pass="admin";*/
		String user=ExcelUtility.getStringData(1,0,"LoginPage");
		String pass=ExcelUtility.getStringData(1,1,"LoginPage");
		String news=ExcelUtility.getStringData(1,1,"ManageNews");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(user).enterPassword(pass);
		//loginpage.enterPassword(pass);
		logoutpage=loginpage.clickSigninButton();
		//ManageNewsPage managenewspage=new ManageNewsPage(driver);
		managenewspage=logoutpage.manageNewsMoreInfo();
		managenewspage.clickUpdateButton().enterUpdatedNews(news).clickTheUpdateButton();
		//managenewspage.enterUpdatedNews(news);
		//managenewspage.clickTheUpdateButton();
		boolean alertdisplayed=managenewspage.isAlertDisplayed();
		Assert.assertTrue(alertdisplayed,"After updating news alert is not displayed");
	}
	
}
