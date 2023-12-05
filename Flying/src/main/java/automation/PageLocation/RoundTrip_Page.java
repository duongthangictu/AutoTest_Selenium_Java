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

public class RoundTrip_Page extends CommonBase {
	WebDriver driver;

	@FindBy(xpath = "//a[@id='round-trip-tab']")
	private WebElement roundTrip_CheckBox;

	@FindBy(xpath = "(//label[normalize-space()='Flying from']//following::input[@placeholder='City or airport'])[3]")
	private WebElement flyingFrom;

	@FindBy(xpath = "(//label[normalize-space()='Flying to']//following::input[@placeholder='City or airport'])[3]")
	private WebElement flyingTo;
	
	@FindBy(xpath = "((//label[normalize-space()='Departing - Returning'])[1]//following::input)[1]")
	private WebElement departingReturning;

	@FindBy(xpath = "(//button[normalize-space()='Apply'])[1]")
	private WebElement btnApply;
	
	@FindBy(xpath = "((//label[normalize-space()='Passengers'])[position()=2]//following::a)[1]")
	private WebElement passengersDropdown;
	
	@FindBy(xpath = "(//i[@class='la la-plus'])[position()=6]")
	private WebElement adults_Add;
	
	@FindBy(xpath = "(//i[@class='la la-plus'])[position()=7]")
	private WebElement children_Add;
	
	@FindBy(xpath = "(//i[@class='la la-plus'])[position()=8]")
	private WebElement infants_Add;

	@FindBy(xpath = "(//div[normalize-space()='Economy'])[4]")
	private WebElement coachDropdow;
	
	@FindBy(xpath = "//span[normalize-space()='Business']")
	private WebElement business;
	
	
	@FindBy(xpath = "(//a[normalize-space()='Search Now'])[2]")
	private WebElement btnSearchNow;
	
	@FindBy(xpath = "//h2[normalize-space()='Flight Search Result']")
	private WebElement titleSearchResult_Success;
	
	
//	private WebElement titleSearchResult_Success = driver.findElement(By.xpath("//h2[normalize-space()='Flight Search Result']"));
	
	public RoundTrip_Page(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(driver, this);
	}

	public void roundTripPage(String _flyingFrom, String _flyingTo, String _departingReturning) {
		pause(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", roundTrip_CheckBox);
//
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(flyingFrom));
		flyingFrom.sendKeys(_flyingFrom);
		pause(1000);
		flyingTo.sendKeys(_flyingTo);
		pause(500);
		
		js.executeScript("window.scrollTo(0,200)");
		js.executeScript("arguments[0].removeAttribute('readonly','readonly')", departingReturning);
		departingReturning.click();
		departingReturning.clear();
		departingReturning.sendKeys(_departingReturning);
		pause(500);
		btnApply.click();
		pause(500);
		js.executeScript("arguments[0].click()", passengersDropdown);
		wait.until(ExpectedConditions.visibilityOf(adults_Add));
		adults_Add.click();
		children_Add.click();
		infants_Add.click();
		js.executeScript("arguments[0].click()", passengersDropdown); // close dropdown of Passengers
		pause(500);
		coachDropdow.click();
		business.click();
		btnSearchNow.click();
		pause(2000);
		assertTrue(titleSearchResult_Success.isDisplayed());
	}
}
