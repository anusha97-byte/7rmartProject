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
	public LogoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
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
