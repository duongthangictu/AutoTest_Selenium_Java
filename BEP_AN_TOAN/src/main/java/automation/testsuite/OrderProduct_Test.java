package automation.testsuite;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.PageLocation.Filter_HomePage;
import automation.PageLocation.OrderProduct_Page;
import automation.common.CommonBase;
import automation.constant.CT_Common;

public class OrderProduct_Test extends CommonBase {

	@BeforeTest
	public void openChromeBrowser() {
		initChromeDriver(CT_Common.webURL);
	}

	@Test(priority = 1)
	public void orderProductSuccess() {
		Filter_HomePage filter_HomePage = new Filter_HomePage(driver);
		filter_HomePage.filter_HomePage();

		OrderProduct_Page order = new OrderProduct_Page(driver);
		order.orderProductSuccess_Page("TAO LA TAO", "0999999999", "HN", "OK Nhe!");
		order.titleOrderSuccess.isDisplayed();
	}

	@Test(priority = 2)
	public void orderProduc_Fail_BlankHoVaTen() {
		Filter_HomePage filter_HomePage = new Filter_HomePage(driver);
		filter_HomePage.filter_HomePage();

		OrderProduct_Page order = new OrderProduct_Page(driver);
		order.orderProductSuccess_Page("", "0999999999", "HN", "OK Nhe!");
		order.titleOrder_FAIL_HoVaTen.isDisplayed();
	}

	@Test(priority = 3)
	public void orderProduc_Fail_BlankSDT() {
		Filter_HomePage filter_HomePage = new Filter_HomePage(driver);
		filter_HomePage.filter_HomePage();

		OrderProduct_Page order = new OrderProduct_Page(driver);
		order.orderProductSuccess_Page("TAO LA TAO", "", "HN", "OK Nhe!");
		order.titleOrder_FAIL_SDT.isDisplayed();
	}

	@Test(priority = 4)
	public void orderProduc_Fail_SDT_Invalid() {
		Filter_HomePage filter_HomePage = new Filter_HomePage(driver);
		filter_HomePage.filter_HomePage();

		OrderProduct_Page order = new OrderProduct_Page(driver);
		order.orderProductSuccess_Page("TAO LA TAO", "abc", "HN", "OK Nhe!");
		order.titleOrder_FAIL_SDT.isDisplayed();
	}

	@Test(priority = 5)
	public void orderProduc_Fail_BlankDiaChi() {
		Filter_HomePage filter_HomePage = new Filter_HomePage(driver);
		filter_HomePage.filter_HomePage();

		OrderProduct_Page order = new OrderProduct_Page(driver);
		order.orderProductSuccess_Page("TAO LA TAO", "0999999999", "", "OK Nhe!");
		order.titleOrder_FAIL_DiaChi.isDisplayed();
	}

	@Test(priority = 6)
	public void orderProduc_Fail_BlankAll() {
		Filter_HomePage filter_HomePage = new Filter_HomePage(driver);
		filter_HomePage.filter_HomePage();

		OrderProduct_Page order = new OrderProduct_Page(driver);
		order.orderProductSuccess_Page("", "", "", "!");
		order.titleOrder_FAIL_DiaChi.isDisplayed();
	}

	@AfterTest
	public void closeChromeBrowser() {
		pause(3000);
		quitDriver(driver);
	}

}
