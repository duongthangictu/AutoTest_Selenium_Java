package automation.testsuite;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.PageLocation.MultiCity_Page;
import automation.common.CommonBase;
import automation.constant.CT_Common;

public class MultiCity_Test extends CommonBase {
	@BeforeTest
	public void openChromeBrowser() {
		initChromeDriver(CT_Common.webURL);
	}

	@Test(priority = 3)
	public void multiCity() {
		MultiCity_Page multiCity_Page = new MultiCity_Page(driver);
		multiCity_Page.multiCity("Ha Noi", "Da Nang", "01122024", "Thai Nguyen ", "Ca Mau", "05122024");
	}

	@AfterTest
	public void closeChromeBrowser() {
		pause(3000);
		driver.close();
	}
}
