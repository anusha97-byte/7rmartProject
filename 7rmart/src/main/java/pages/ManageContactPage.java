package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageContactPage 
{
	WebDriver driver;
	public ManageContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//a[@class='small-box-footer'])[3]")WebElement moreinfo;
	@FindBy(xpath="//a[contains(@href,'edit_contact?edit=1')]")WebElement updateicon;
	@FindBy(xpath="//input[@id='phone']")WebElement phonenumber;
	@FindBy(xpath="//input[@id='email']")WebElement emailid;
	@FindBy(xpath="//textarea[@id='content' and @name='address']")WebElement address;
	@FindBy(xpath="//textarea[@id='content' and @name='del_time']")WebElement deliverytime;
	@FindBy(xpath="//input[@id='del_limit']")WebElement chargelimit;
	@FindBy(xpath="//button[@type='submit']")WebElement updatebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	public void clickMoreInfo()
	{
		moreinfo.click();
	}
	public void clickUpdateIcon()
	{
		updateicon.click();
	}
	public void enterPhoneNumber(String phone)
	{
		phonenumber.clear();
		phonenumber.sendKeys(phone);
	}
	public void enterEmailId(String email)
	{
		emailid.clear();
		emailid.sendKeys(email);
	}
	public void enterAddress(String address1)
	{
		address.clear();
		address.sendKeys(address1);
	}
	public void enterDeliveryTime(String dtime)
	{
		deliverytime.clear();
		deliverytime.sendKeys(dtime);
	}
	public void enterChargeLimit(String climit)
	{
		chargelimit.clear();
		chargelimit.sendKeys(climit);
	}
	public void clickUpdateButton()
	{
		//updatebutton.click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",updatebutton);
	}
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
}
