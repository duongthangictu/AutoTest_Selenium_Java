package automation.testsuite;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.PageLocation.RoundTrip_Page;
import automation.common.CommonBase;
import automation.constant.CT_Common;

public class RoundTrip_Test extends CommonBase {
	@BeforeTest
	public void openChromeBrowser() {
		initChromeDriver(CT_Common.webURL);
	}

	@Test(priority = 2)
	public void roundTrip() {
		RoundTrip_Page roundTrip_Page = new RoundTrip_Page(driver);
		roundTrip_Page.roundTripPage("Ha Noi", "Da Nang", "01122024 - 05122024");

	}

	@AfterTest
	public void closeChromeBrowser() {
		pause(3000);
		driver.close();
	}
}
