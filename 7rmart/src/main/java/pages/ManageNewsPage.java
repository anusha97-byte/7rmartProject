package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	// @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'
	// and @class='small-box-footer']")WebElement moreinfo;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newbutton;
	@FindBy(xpath = "//textarea[@placeholder='Enter the news']")
	WebElement newsText;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	@FindBy(xpath = "//a[contains(@href,'page_ad=1')]")
	WebElement update;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement updatednews;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement updatebutton;
	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * public void manageNewsMoreInfo() { moreinfo.click(); }
	 */
	public ManageNewsPage clickNewButton() {
		newbutton.click();
		return this;
	}

	public ManageNewsPage enterTheNews(String news) {
		newsText.sendKeys(news);
		return this;
	}

	public ManageNewsPage clickSaveButton() {
		savebutton.click();
		return this;
	}

	public ManageNewsPage clickUpdateButton() {
		update.click();
		return this;
	}

	public ManageNewsPage enterUpdatedNews(String news) {
		updatednews.clear();
		updatednews.sendKeys(news);
		return this;
	}

	public ManageNewsPage clickTheUpdateButton() {
		updatebutton.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}

}
