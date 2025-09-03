package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageContactPage {
	WebDriver driver;

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// @FindBy(xpath="(//a[@class='small-box-footer'])[3]")WebElement moreinfo;
	@FindBy(xpath = "//a[contains(@href,'edit_contact?edit=1')]")
	WebElement updateicon;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phonenumber;
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailid;
	@FindBy(xpath = "//textarea[@id='content' and @name='address']")
	WebElement address;
	@FindBy(xpath = "//textarea[@id='content' and @name='del_time']")
	WebElement deliverytime;
	@FindBy(xpath = "//input[@id='del_limit']")
	WebElement chargelimit;
	@FindBy(xpath = "//button[@name='Update' and @ type='submit']")
	WebElement updatebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	/*
	 * public void manageContactMoreInfo() { moreinfo.click(); }
	 */
	public ManageContactPage clickUpdateIcon() {
		updateicon.click();
		return this;
	}

	public ManageContactPage enterPhoneNumber(String phone) {
		phonenumber.clear();
		phonenumber.sendKeys(phone);
		return this;
	}

	public ManageContactPage enterEmailId(String email) {
		emailid.clear();
		emailid.sendKeys(email);
		return this;
	}

	public ManageContactPage enterAddress(String address1) {
		address.clear();
		address.sendKeys(address1);
		return this;
	}

	public ManageContactPage enterDeliveryTime(String dtime) {
		deliverytime.clear();
		deliverytime.sendKeys(dtime);
		return this;
	}

	public ManageContactPage enterChargeLimit(String climit) {
		chargelimit.clear();
		chargelimit.sendKeys(climit);
		return this;
	}

	public ManageContactPage clickUpdateButton() {
		PageUtility pageutility = new PageUtility();
		pageutility.javaScriptScrollDown150(driver);
		pageutility.javaScriptClick(updatebutton, driver);
		return this;
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}
}
