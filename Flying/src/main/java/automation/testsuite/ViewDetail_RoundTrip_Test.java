package automation.testsuite;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.PageLocation.RoundTrip_Page;
import automation.PageLocation.ViewDetail_Page;
import automation.common.CommonBase;
import automation.constant.CT_Common;

public class ViewDetail_RoundTrip_Test extends CommonBase {

	@BeforeTest
	public void openChromeBrowser() {
		initChromeDriver(CT_Common.webURL);
	}

	@Test(priority = 1)
	public void roundTrip() {
		RoundTrip_Page roundTrip_Page = new RoundTrip_Page(driver);
		roundTrip_Page.roundTripPage("Ha Noi", "Da Nang", "01122024 - 05122024");
	}
	
	@Test(priority = 2)
	public void viewDetail() {
		ViewDetail_Page viewDetail_Page = new ViewDetail_Page(driver);
		viewDetail_Page.viewDetail();
	}

	@AfterTest
	public void closeChromeBrowser() {
		pause(3000);
		driver.close();
	}

}









// Cách 2
//public class ViewDetail_RoundTrip_Test extends RoundTrip_Test {
//	
//	@Test(priority = 2)
//	public void viewDetail() {
//		ViewDetail_Page viewDetail_Page = new ViewDetail_Page(driver);
//		viewDetail_Page.viewDetail();
//	}

//}
