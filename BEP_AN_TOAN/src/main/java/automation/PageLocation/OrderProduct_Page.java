package automation.PageLocation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.common.CommonBase;

public class OrderProduct_Page extends CommonBase {

	@FindBy(xpath = "//input[@placeholder='Nhập họ và tên']")
	private WebElement txtHoTen;

	@FindBy(xpath = "//input[@placeholder='Nhập số điện thoại']")
	private WebElement txtSDT;

	@FindBy(xpath = "//input[@placeholder='Nhập số nhà, tên đường, phường/ xã, quận/huyện, tỉnh/ thành phố']")
	private WebElement txtDiaChi;

	@FindBy(xpath = "//textarea[@placeholder='Nhập lưu ý']")
	private WebElement txtLoiNhanCanLuuYElement;

	@FindBy(xpath = "//span[normalize-space()='Thanh toán']")
	private WebElement btnThanhToan;
	
	@FindBy(xpath = "//h1[normalize-space()='Đặt Hàng Thành Công']")
	public WebElement titleOrderSuccess;
	
	@FindBy(xpath = "//small[normalize-space()='Họ và tên không hợp lệ']")
	public WebElement titleOrder_FAIL_HoVaTen;
	
	@FindBy(xpath = "//small[normalize-space()='Số điện thoại không hợp lệ']")
	public WebElement titleOrder_FAIL_SDT;
	
	@FindBy(xpath = "//small[normalize-space()='Địa chỉ không hợp lệ']")
	public WebElement titleOrder_FAIL_DiaChi;

	public OrderProduct_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void orderProductSuccess_Page(String _hoVaTen, String _SDT, String _diaChi, String _luuY) {
		txtHoTen.sendKeys(_hoVaTen);
		txtSDT.sendKeys(_SDT);
		txtDiaChi.sendKeys(_diaChi);
		txtLoiNhanCanLuuYElement.sendKeys(_luuY);
		btnThanhToan.click();
	}
}
