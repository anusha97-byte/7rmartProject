package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;

public class ManageCategoryPage
{
	WebDriver driver;
	public ManageCategoryPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//a[@class='small-box-footer'])[9]")WebElement moreinfo;
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newbutton;
	@FindBy(xpath="//input[@id='category']")WebElement category;
	@FindBy(xpath="//input[@type='file']")WebElement choosefile;
	@FindBy(xpath="(//input[@type='radio'])[4]")WebElement radiono;
	@FindBy(xpath="//button[@type='submit']")WebElement save;
	@FindBy(xpath="//b[text()='Fatal error']")WebElement errorpage;
	@FindBy(xpath="//a[contains(@href,'edit=2833&page_ad=1')]")WebElement updateicon;
	@FindBy(xpath="//button[@name='update']")WebElement updatebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	
	public void clickMoreInfo()
	{
		moreinfo.click();
	}
	public void clickNewButton()
	{
		newbutton.click();
	}
	public void enterTheCategory(String category1)
	{
		category.clear();
		category.sendKeys(category1);
	}
	public void clickRadioButtonNo()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,150)");
		//radiono.click();
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();",radiono);
		//PageUtility pageutility=new PageUtility();
		//pageutility.click(driver, radiono);
	}
	public void clickSaveButton()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,150)");
		//save.click();
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();",save);
		//PageUtility pageutility=new PageUtility();
		//pageutility.click(driver,save);
	}
	public void chooseTheFile()
	{
		
		//choosefile.sendKeys("C:\\Users\\acer\\OneDrive\\Desktop\\pexels-valeriya-842571.jpg");
	FileUploadUtility fileuplaod=new FileUploadUtility();
	fileuplaod.fileUploadUsingSendkeys(choosefile,Constant.FOODIMAGEFILE);
	}
	public void clickUpdateIcon()
	{
		updateicon.click();
	}
	public void clickUpdateButton()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,150)");
		//updatebutton.click();
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();",updatebutton);
		//PageUtility pageutility=new PageUtility();
		//pageutility.click(driver,updatebutton);
	}
	public boolean isErrorPageDisplayed()
	{
		return errorpage.isDisplayed();
	}
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
}
