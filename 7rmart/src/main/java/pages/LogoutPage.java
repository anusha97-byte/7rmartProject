package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage
{
	WebDriver driver;
	@FindBy(xpath="//a[@class='nav-link' and @data-toggle='dropdown']")WebElement adminbutton;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and @class='dropdown-item']")WebElement logoutbutton;
	@FindBy(xpath="//button[@type='submit']")WebElement loginpage;
	
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement adminmoreinfo;
	@FindBy(xpath="(//a[@class='small-box-footer'])[9]")WebElement managecategorymoreinfo;
	@FindBy(xpath="(//a[@class='small-box-footer'])[3]")WebElement managecontactmoreinfo;
	@FindBy(xpath="(//a[@class=\"small-box-footer\"])[8]")WebElement managefootermoreinfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")WebElement managenewsmoreinfo;
	public LogoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public AdminUserPage adminUserMoreInfo()
	{
		adminmoreinfo.click();
		return new AdminUserPage(driver);
	}
	public ManageCategoryPage manageCategoryMoreInfo()
	{
		managecategorymoreinfo.click();
		return new ManageCategoryPage(driver);
	}
	public ManageContactPage manageContactMoreInfo()
	{
		managecontactmoreinfo.click();
		return new ManageContactPage(driver);
	}
	public ManageFooterTextPage manageFooterMoreInfo()
	{
		managefootermoreinfo.click();
		return new ManageFooterTextPage(driver);
	}
	public ManageNewsPage manageNewsMoreInfo()
	{
		managenewsmoreinfo.click();
		return new ManageNewsPage(driver);
	}
	
	
	
	
	public void clickAdmin()
	{
		adminbutton.click();
	}
	public void clickLogoutButton()
	{
		logoutbutton.click();
	}
	public boolean displayLoginPage()
	{
		return loginpage.isDisplayed();
		
	}
}
