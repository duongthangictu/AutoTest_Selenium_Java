package automation.PageLocation;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.common.CommonBase;

public class MultiCity_Page extends CommonBase {
	WebDriver driver;

	@FindBy(xpath = "//a[@id='multi-city-tab']")
	private WebElement checkboxMultiCity;

	@FindBy(xpath = "((//label[normalize-space()='Flying from'])[3]//following::input)[1]")
	private WebElement flyingFrom;

	@FindBy(xpath = "((//label[normalize-space()='Flying to'])[3]//following::input)[1]")
	private WebElement flyingTo;

	@FindBy(xpath = "((//label[normalize-space()='Departing'])[2]//following::input)[1]")
	private WebElement departing;

	@FindBy(xpath = "//button[normalize-space()='Add another flight']")
	private WebElement btnAddAnotherFlight;

	@FindBy(xpath = "((//label[normalize-space()='Flying from'])[3]//following::input)[4]")
	private WebElement flyingFrom_2;

	@FindBy(xpath = "((//label[normalize-space()='Flying to'])[3]//following::input)[4]")
	private WebElement flyingTo_2;

	@FindBy(xpath = "((//label[normalize-space()='Departing'])[2]//following::input)[4]")
	private WebElement departing_2;

	@FindBy(xpath = "((//label[normalize-space()='Passengers'])[position()=3]//following::a)[1]")
	private WebElement passengersDropdown;

	@FindBy(xpath = "(//i[@class='la la-plus'])[position()=9]")
	private WebElement adults_Add;

	@FindBy(xpath = "(//i[@class='la la-plus'])[position()=10]")
	private WebElement children_Add;

	@FindBy(xpath = "(//i[@class='la la-plus'])[position()=11]")
	private WebElement infants_Add;

	@FindBy(xpath = "(//div[normalize-space()='Economy'])[8]")
	private WebElement coachDropdow;

	@FindBy(xpath = "(//span[normalize-space()='Business'])")
	private WebElement business;

	@FindBy(xpath = "(//a[normalize-space()='Search Now'])[3]")
	private WebElement btnSearchNow;

	@FindBy(xpath = "//h2[normalize-space()='Flight Search Result']")
	private WebElement titleSearchResult_Success;
	
	public MultiCity_Page(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(driver, this);
	}

	public void multiCity(String _flyingFrom, String _flyingTo, String _departing, String _flyingFrom_2, String _flyingTo_2, String _departing_2) {
		pause(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(checkboxMultiCity));
		checkboxMultiCity.click();
		pause(1000);
		btnAddAnotherFlight.click();
		pause(1000);
		flyingFrom.sendKeys(_flyingFrom);
		pause(1000);
		flyingTo.sendKeys(_flyingTo);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('readonly','readonly')", departing);
		js.executeScript("arguments[0].click()", departing);
		departing.clear();
		departing.sendKeys(_departing);
		departing.sendKeys(Keys.TAB);

		// Another Flight
		pause(1000);
		flyingFrom_2.sendKeys(_flyingFrom_2);
		flyingTo_2.sendKeys(_flyingTo_2);
		js.executeScript("arguments[0].removeAttribute('readonly','readonly')", departing_2);
		js.executeScript("arguments[0].click()", departing_2);
		departing_2.clear();
		departing_2.sendKeys(_departing_2);
		departing_2.sendKeys(Keys.TAB);
		
		passengersDropdown.click();
		wait.until(ExpectedConditions.visibilityOf(adults_Add));
		adults_Add.click();
		children_Add.click();
		infants_Add.click();
//		infants_Add.sendKeys(Keys.TAB);
		coachDropdow.click();
		pause(500);
		business.click();
		btnSearchNow.click();
		pause(2000);
		assertTrue(titleSearchResult_Success.isDisplayed());

	}
}
