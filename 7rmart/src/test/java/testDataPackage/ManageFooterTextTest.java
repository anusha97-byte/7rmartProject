package testDataPackage;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtility;

public class ManageFooterTextTest extends Base
{
	@Test(description="To update the Footer Text")
	public void footerTextUpdate() throws IOException
	{
		String user=ExcelUtility.getStringData(1,0,"LoginPage");
		String pass=ExcelUtility.getStringData(1,1,"LoginPage");
		String address=ExcelUtility.getStringData(1, 0,"FooterText");
		String email2=ExcelUtility.getStringData(1,1,"FooterText");
		String phone=ExcelUtility.getIntergerData(1,2,"FooterText");
		LoginPage loginpage= new LoginPage(driver);
		loginpage.enterUsername(user);
		loginpage.enterPassword(pass);
		loginpage.clickSigninButton();
		ManageFooterTextPage managefootertextpage=new ManageFooterTextPage(driver);
		managefootertextpage.clickMoreInfo();
		managefootertextpage.clickUpdateIcon();
		managefootertextpage.enterAddress(address);
		managefootertextpage.enterEmail(email2);
		managefootertextpage.enterPhonenumber(phone);
		managefootertextpage.clickUpdateButton();
		boolean alertdisplayed=managefootertextpage.isAlertdisplayed();
		Assert.assertTrue(alertdisplayed,"After update the footer text alert is not displayed");
	}
}
