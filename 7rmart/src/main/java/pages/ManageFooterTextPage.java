package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterTextPage
{
	@FindBy(xpath="(//a[@class=\"small-box-footer\"])[8]")WebElement moreinfo;
	@FindBy(xpath="//a[contains(@href,'Footertext/edit?edit=1')]")WebElement updateicon;
	@FindBy(xpath="//textarea[@id='content']")WebElement address;
	@FindBy(xpath="//input[@id='email']")WebElement email;
	@FindBy(xpath="//input[@id='phone']")WebElement phonenumber;
	@FindBy(xpath="//button[@name='Update']")WebElement updatebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	WebDriver driver;
	public ManageFooterTextPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void clickMoreInfo()
	{
		moreinfo.click();
	}
	public void clickUpdateIcon()
	{
		updateicon.click();
	}
	public void enterAddress(String address2)
	{
		address.clear();
		address.sendKeys(address2);
	}
	public void enterEmail(String email2)
	{
		email.clear();
		email.sendKeys(email2);
	}
	public void enterPhonenumber(String phone)
	{
		phonenumber.clear();
		phonenumber.sendKeys(phone);
	}
	public void clickUpdateButton()
	{
		updatebutton.click();
	}
	public boolean isAlertdisplayed()
	{
		return alert.isDisplayed();
	}
}
