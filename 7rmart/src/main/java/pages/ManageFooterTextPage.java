package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterTextPage
{
	//@FindBy(xpath="(//a[@class=\"small-box-footer\"])[8]")WebElement moreinfo;
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
	/*public void manageFooterMoreInfo()
	{
		moreinfo.click();
	}*/
	public ManageFooterTextPage clickUpdateIcon()
	{
		updateicon.click();
		return this;
	}
	public ManageFooterTextPage enterAddress(String address2)
	{
		address.clear();
		address.sendKeys(address2);
		return this;
	}
	public ManageFooterTextPage enterEmail(String email2)
	{
		email.clear();
		email.sendKeys(email2);
		return this;
	}
	public ManageFooterTextPage enterPhonenumber(String phone)
	{
		phonenumber.clear();
		phonenumber.sendKeys(phone);
		return this;
	}
	public ManageFooterTextPage clickUpdateButton()
	{
		updatebutton.click();
		return this;
	}
	public boolean isAlertdisplayed()
	{
		return alert.isDisplayed();
	}
}
