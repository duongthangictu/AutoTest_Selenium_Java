package automation.PageLocation;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.common.CommonBase;

public class Filter_HomePage extends CommonBase {
	@FindBy(xpath = "(//div[@class='container header__mega']//a[normalize-space()='Bếp Từ'])[2]")
	private WebElement bepTu;

	@FindBy(xpath = "(//div[@class='category-menus']/descendant::img)[1]")
	private WebElement hangSanXuat_Bosch;

	@FindBy(xpath = "//span[normalize-space()='> 15.000.000']")
	private WebElement mucGia;

	@FindBy(xpath = "(//div[@class='category-menus']//span[normalize-space()='Xem thêm'])[2]")
	private WebElement xemThem;

	@FindBy(xpath = "//span[normalize-space()='Germany']")
	private WebElement xuatXuValue;

	@FindBy(xpath = "//span[normalize-space()='3 bếp']")
	private WebElement soBep;

	@FindBy(xpath = "((//div[@class='relative'])[4]/descendant::img)[1]")
	private WebElement firstProduct;

	@FindBy(xpath = "//span[normalize-space()='tại sao mua hàng ở bếp an toàn']")
	private WebElement clickOuter;

	@FindBy(xpath = "(//span[normalize-space()='Mua ngay'])[1]")
	private WebElement muaNgay;

	public Filter_HomePage(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(driver, this);
	}

	public void filter_HomePage() {
		pause(2000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		bepTu.click();
		pause(500);
		hangSanXuat_Bosch.click();
		pause(500);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(0,400)");
		pause(500);
		mucGia.click();
		pause(500);
		xemThem.click();
		pause(500);
		xuatXuValue.click();
		pause(500);
		soBep.click();

		jsExecutor.executeScript("window.scrollTo(0,-300)");
		pause(2000);
		firstProduct.click();
		pause(2000);
		assertTrue(clickOuter.isDisplayed());
		clickOuter.click();
		pause(500);
		muaNgay.click();
		pause(500);
		
		
	}
}
