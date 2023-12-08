package automation.PageLocation;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.common.CommonBase;

public class Projects_Page extends CommonBase {
	@FindBy(xpath = "//span[normalize-space()='Projects']")
	private WebElement project_Link;

	@FindBy(xpath = "//a[normalize-space()='Add project']")
	private WebElement addProject_button;

	@FindBy(xpath = "//input[@id='title']")
	private WebElement title_input;

	@FindBy(xpath = "(//div[@id='s2id_project-type-dropdown']//span)[1]")
	private WebElement projectType_dropdown;

	@FindBy(xpath = "(//ul[@id='select2-results-9']/li)[2]")
	private WebElement projectTypeValue_dropdown;

	@FindBy(xpath = "(//div[@id='s2id_autogen6']//span)[1]")
	private WebElement client_dropdown;

	@FindBy(xpath = "//textarea[@id='description']")
	private WebElement description_textArea;

	@FindBy(xpath = "//input[@id='start_date']")
	private WebElement startDate;

	@FindBy(xpath = "//input[@id='deadline']")
	private WebElement deadline;

	@FindBy(xpath = "//input[@id='price']")
	private WebElement price_input;

	@FindBy(xpath = "//input[@id='s2id_autogen8']")
	private WebElement labels;

	@FindBy(xpath = "//label[normalize-space()='EKT Refference']/following::input")
	private WebElement EKT_Refference;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement save_button;

	@FindBy(xpath = "(//input[@placeholder='Search'])[2]")
	private WebElement inputSearch;

	@FindBy(xpath = "//td/a[normalize-space()='OK men'][1]")
	private WebElement resultSearch;

	// ｆｉｔｅｒ ｗｉｔｈ Ｌａｂｅｌ
	@FindBy(xpath = "(//div[@class='filter-item-box'])[2]")
	private WebElement filters_Dropdown;

	@FindBy(xpath = "(//input[@placeholder='Search'])[1]")
	private WebElement search_Filters;

	@FindBy(xpath = "//div[@id='project-table_wrapper']//a[normalize-space()='Clear']")
	private WebElement clear_Filters;

	// Find
	@FindBy(xpath = "(//table[@id='project-table']//tr/td)[2]/a")
	private WebElement findContendElement;

	// Edit function
	@FindBy(xpath = "((//div[@id='project-table_wrapper']//tr)[2]/td[last()]/a)[1]")
	private WebElement edit_Icon;

	public void addProject(String _title, String _description, String _startDate, String _deadline, String _price,
			String _labels, String _labels2, String _EKT_Refference) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(project_Link));
		project_Link.click();
		pause(1000);
		addProject_button.click();
		pause(2000);
		title_input.sendKeys(_title);
		projectType_dropdown.click();
		pause(1000);
		projectTypeValue_dropdown.click();
		description_textArea.sendKeys(_description);
		startDate.click();
		startDate.sendKeys(_startDate);
		startDate.sendKeys(Keys.TAB);
		deadline.sendKeys(_deadline);
		price_input.sendKeys(_price);
		labels.click();
		labels.sendKeys(_labels);
		labels.sendKeys(Keys.TAB);
		labels.click();
		labels.sendKeys(_labels2);
		labels.sendKeys(Keys.TAB);
//		EKT_Refference.click();
//		EKT_Refference.sendKeys(_EKT_Refference);
		save_button.click();
		pause(2000);
		inputSearch.click();
		inputSearch.sendKeys(_title);
		pause(2000);
		assertTrue(resultSearch.isDisplayed());
	}

	// function fiter with Label
	public void filter(String _keyword_Search) {
		pause(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(project_Link));
		project_Link.click();
		pause(1000);

		filters_Dropdown.click();
		search_Filters.click();
		search_Filters.sendKeys(_keyword_Search);
		search_Filters.sendKeys(Keys.ENTER);
	}

	// clear Filter
	public void clear_Filter() {
		pause(3000);
		filters_Dropdown.click();
		pause(1000);
		clear_Filters.click();
	}

	// Find with content (text)
	public void find(String _content_Find) {
		pause(3000);
		project_Link.click();
		pause(3000);
		inputSearch.click();
		inputSearch.sendKeys(_content_Find);
		pause(1000);
		findContendElement.click();
		pause(3000);
	}

	// Edit function
	public void edit(String _content_Find, String _price_input_Edit) {
		pause(3000);
		project_Link.click();
		pause(3000);
		inputSearch.click();
		inputSearch.sendKeys(_content_Find);
		pause(1000);
		edit_Icon.click();
		pause(1000);
		price_input.clear();
		price_input.sendKeys(_price_input_Edit);
		save_button.click();
		pause(3000);
	}

	public Projects_Page(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(driver, this);
	}

}
