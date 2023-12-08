package automation.testsuite;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.PageLocation.LoginPage;
import automation.PageLocation.Projects_Page;
import automation.common.CommonBase;
import automation.constant.CT_Common;

public class Projects_Test extends CommonBase {
	@BeforeTest
	public void openChromeBrowser() {
		initChromeDriver(CT_Common.webURL);
	}

	@Test(priority = 1)
	public void login() {
		LoginPage login = new LoginPage(driver);
		login.loginPage("admin@demo.com", "riseDemo");
	}

	@Test(priority = 2)
	public void addProject() {
		Projects_Page projects = new Projects_Page(driver);
		projects.addProject("OK men", "Hello ME", "02-05-2024", "05-05-2024", "10", "Upcoming", "On Track", "EKT New");
	}

	@Test(priority = 3)
	public void filter() {
		Projects_Page projects = new Projects_Page(driver);
		projects.filter("Upcoming");
	}

	@Test(priority = 4)
	public void clear_Filter() {
		Projects_Page projects = new Projects_Page(driver);
		projects.clear_Filter();
	}

	@Test(priority = 5)
	public void findData() {
		Projects_Page projects = new Projects_Page(driver);
		projects.find("online course");
	}

	@Test(priority = 6)
	public void editData() {
		Projects_Page projects = new Projects_Page(driver);
		projects.edit("OK men", "15");
	}

	@AfterTest
	public void closeChromeBrowser() {
		pause(3000);
		driver.close();
	}
}