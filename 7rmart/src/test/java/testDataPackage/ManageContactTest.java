package testDataPackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageContactTest extends Base
{ 
	@Test(description="To update the contact")
	public void updateContact() throws IOException
	{
		String user=ExcelUtility.getStringData(1,0,"LoginPage");
		String pass=ExcelUtility.getStringData(1,1,"LoginPage");
		String phone=ExcelUtility.getIntergerData(1, 0,"ManageContact");
		//String email=ExcelUtility.getStringData(1, 1, "ManageContact");
		//String address1=ExcelUtility.getStringData(1, 2,"ManageContact");
		String dtime=ExcelUtility.getStringData(1, 3,"ManageContact");
		String climit=ExcelUtility.getIntergerData(1, 4,"ManageContact");
		LoginPage loginpage= new LoginPage(driver);
		loginpage.enterUsername(user);
		loginpage.enterPassword(pass);
		loginpage.clickSigninButton();
		ManageContactPage managecontactpage=new ManageContactPage(driver);
		managecontactpage.clickMoreInfo();
		managecontactpage.clickUpdateIcon();
		managecontactpage.enterPhoneNumber(phone);
		FakerUtility fakerutility=new FakerUtility();
		String email=fakerutility.generateEmail();
		String address1=fakerutility.generateAddress();
		managecontactpage.enterEmailId(email);
		managecontactpage.enterAddress(address1);
		managecontactpage.enterDeliveryTime(dtime);
		managecontactpage.enterChargeLimit(climit);
		managecontactpage.clickUpdateButton();
		boolean alertdisplayed=managecontactpage.isAlertDisplayed();
		Assert.assertTrue(alertdisplayed,"After update contact alert is not displayed");
	}
}
