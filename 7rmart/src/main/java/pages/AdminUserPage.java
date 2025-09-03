package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUserPage {
	WebDriver driver;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'
	// and @class='small-box-footer']")WebElement moreinfo;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newbutton;
	@FindBy(xpath = "//input[@id='username']")
	WebElement usernametext;
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordtext;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement usertypeselect;
	@FindBy(xpath = "//button[@type='submit' and @name='Create']")
	WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	@FindBy(xpath = "(//a[contains(@href,'page_ad=1')])[3]")
	WebElement updateicon;
	@FindBy(xpath = "//button[@name='Update' and @type='submit']")
	WebElement updatebutton;

	/*
	 * public void adminUserMoreInfo() { moreinfo.click(); }
	 */
	public AdminUserPage clickNewButton() {
		newbutton.click();
		return this;
	}

	public AdminUserPage enterUsername(String username) {
		usernametext.clear();
		usernametext.sendKeys(username);
		return this;
	}

	public AdminUserPage enterPassword(String password) {
		passwordtext.clear();
		passwordtext.sendKeys(password);
		return this;
	}

	public AdminUserPage selectUserType() {
		WaitUtility wait = new WaitUtility();
		wait.waitForElementToBeClickable(driver, usertypeselect);
		usertypeselect.click();
		PageUtility pageutility = new PageUtility();
		pageutility.selectByVisibleText(usertypeselect, "Admin");
		return this;

	}

	public AdminUserPage clickSaveButton() {
		savebutton.click();
		return this;
	}

	public AdminUserPage clickUpdateIcon() {
		WaitUtility wait = new WaitUtility();
		wait.waitForElementToBeClickable(driver, updateicon);
		PageUtility pageutility = new PageUtility();
		pageutility.javaScriptScrollDown150(driver);
		pageutility.javaScriptClick(updateicon, driver);
		return this;
	}

	public AdminUserPage clickUpdateButton() {
		WaitUtility wait = new WaitUtility();
		wait.waitForElementToBeClickable(driver, updatebutton);
		updatebutton.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}

}
