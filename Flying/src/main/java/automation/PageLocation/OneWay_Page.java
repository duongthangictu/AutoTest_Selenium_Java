package automation.PageLocation;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.common.CommonBase;

public class OneWay_Page extends CommonBase {
	WebDriver driver;

	@FindBy(xpath = "(//label[normalize-space()='Flying from']//following::input[@placeholder='City or airport'])[1]")
	private WebElement flyingFrom;

	@FindBy(xpath = "(//label[normalize-space()='Flying to']//following::input[@placeholder='City or airport'])[1]")
	private WebElement flyingTo;

	@FindBy(xpath = "((//label[normalize-space()='Departing'])[1]//following::input)[1]")
	private WebElement departing;

	@FindBy(xpath = "((//label[normalize-space()='Passengers'])[position()=1]//following::a)[1]")
	private WebElement passengersDropdown;

	@FindBy(xpath = "(//i[@class='la la-plus'])[position()=3]")
	private WebElement adults_Add;

	@FindBy(xpath = "(//i[@class='la la-plus'])[position()=4]")
	private WebElement children_Add;

	@FindBy(xpath = "(//i[@class='la la-plus'])[position()=5]")
	private WebElement infants_Add;

	@FindBy(xpath = "(//div[normalize-space()='Economy'])[1]")
	private WebElement coachDropdow;

	@FindBy(xpath = "//span[normalize-space()='Business']")
	private WebElement business;

	@FindBy(xpath = "(//a[normalize-space()='Search Now'])[1]")
	private WebElement btnSearchNow;
	
	@FindBy(xpath = "//h2[normalize-space()='Flight Search Result']")
	private WebElement titleSearchResult_Success;
	

	public OneWay_Page(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(driver, this);
	}

	public void oneWay(String _flyingFrom, String _flyingTo, String _departing) {
		pause(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(flyingFrom));
		flyingFrom.sendKeys(_flyingFrom);
		flyingTo.sendKeys(_flyingTo);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('readonly','readonly')", departing);
		js.executeScript("arguments[0].click()", departing);
		departing.clear();
		departing.sendKeys(_departing);
		passengersDropdown.click();
		wait.until(ExpectedConditions.visibilityOf(adults_Add));
		adults_Add.click();
		children_Add.click();
		infants_Add.click();
		coachDropdow.click();
		business.click();
		btnSearchNow.click();
		pause(2000);
		assertTrue(titleSearchResult_Success.isDisplayed());
	}
}
