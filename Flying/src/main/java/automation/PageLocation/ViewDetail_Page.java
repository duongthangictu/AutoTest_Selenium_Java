package automation.PageLocation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.common.CommonBase;

public class ViewDetail_Page extends CommonBase {
	WebDriver driver;
	
	@FindBy(xpath = "(//a[normalize-space()='View Details'])[1]")
	private WebElement btnViewDetail;

	public ViewDetail_Page(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(driver, this);
	}
	
	public void viewDetail()  {
		btnViewDetail.click();
	}

}
