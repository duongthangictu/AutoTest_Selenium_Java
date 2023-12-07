package automation.testsuite;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.PageLocation.OneWay_Page;
import automation.common.CommonBase;
import automation.constant.CT_Common;

public class OneWay_Test extends CommonBase {
	@BeforeTest
	public void openChromeBrowser() {
		initChromeDriver(CT_Common.webURL);
	}
	
	@Test(priority = 1)
	public void oneWay() {
		OneWay_Page oneWay_Page = new OneWay_Page(driver);
		oneWay_Page.oneWay("Ha Noi", "Nha Trang", "05052025");
	}
	
	@AfterTest
	public void closeChromeBrowser() {
		pause(3000);
		driver.close();
	}
}
