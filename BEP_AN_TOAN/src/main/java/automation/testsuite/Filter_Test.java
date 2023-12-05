package automation.testsuite;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.PageLocation.Filter_HomePage;
import automation.common.CommonBase;
import automation.constant.CT_Common;

public class Filter_Test extends CommonBase {
	@BeforeTest
	public void openChromeBrowser() 	{	
		initChromeDriver(CT_Common.webURL);
	}

	@Test
	public void filter() {
		Filter_HomePage filter_HomePage = new Filter_HomePage(driver);
		filter_HomePage.filter_HomePage();
	}
	
	@AfterTest
	public void closeChromeBrowser() {
		pause(3000);
//		quitDriver(driver);
	}
}
