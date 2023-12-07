package automation.testsuite;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.PageLocation.LoginPage;
import automation.common.CommonBase;
import automation.constant.CT_Common;

public class LoginTest extends CommonBase {
	@BeforeTest
	public void openChromeBrowser() {
		initChromeDriver(CT_Common.webURL);
	}

	@Test
	public void login() {
		LoginPage login = new LoginPage(driver);
		login.loginPage("admin@demo.com", "riseDemo");
	}

	@AfterTest
	public void closeChromeBrowser() {
		pause(3000);
		driver.close();
	}
}
