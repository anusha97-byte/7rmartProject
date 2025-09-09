package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;

public class ManageCategoryPage {
	WebDriver driver;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// @FindBy(xpath="(//a[@class='small-box-footer'])[9]")WebElement moreinfo;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newbutton;
	@FindBy(xpath = "//input[@id='category']")
	WebElement category;
	@FindBy(xpath = "//input[@type='file']")
	WebElement choosefile;
	@FindBy(xpath = "(//input[@type='radio'])[4]")
	WebElement radiono;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement save;
	@FindBy(xpath = "//b[text()='Fatal error']")
	WebElement errorpage;
	@FindBy(xpath = "(//a[contains(@href,'&page_ad=1')])[2]")
	WebElement updateicon;
	@FindBy(xpath = "//button[@name='update']")
	WebElement updatebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	/*
	 * public void manageCategoryMoreInfo() { moreinfo.click(); }
	 */
	public ManageCategoryPage clickNewButton() {
		newbutton.click();
		return this;
	}

	public ManageCategoryPage enterTheCategory(String category1) {
		category.clear();
		category.sendKeys(category1);
		return this;
	}

	public ManageCategoryPage clickRadioButtonNo() {
		PageUtility pageutility = new PageUtility();
		pageutility.javaScriptScrollDown150(driver);
		pageutility.javaScriptClick(radiono, driver);
		return this;
	}

	public ManageCategoryPage clickSaveButton() {
		PageUtility pageutility = new PageUtility();
		pageutility.javaScriptScrollDown150(driver);
		pageutility.javaScriptClick(save, driver);
		return this;
	}

	public ManageCategoryPage chooseTheFile() {
		FileUploadUtility fileuplaod = new FileUploadUtility();
		fileuplaod.fileUploadUsingSendkeys(choosefile, Constant.FOODIMAGEFILE);
		return this;
	}

	public ManageCategoryPage clickUpdateIcon() {
		PageUtility pageutility = new PageUtility();
		pageutility.javaScriptScrollDown150(driver);
		pageutility.javaScriptClick(updateicon, driver);
		return this;
	}

	public ManageCategoryPage clickUpdateButton() {
		PageUtility pageutility = new PageUtility();
		pageutility.javaScriptScrollDown150(driver);
		pageutility.javaScriptClick(updatebutton, driver);
		return this;
	}

	public boolean isErrorPageDisplayed() {
		return errorpage.isDisplayed();
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}
}
