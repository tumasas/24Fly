package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PagePassengerInformation extends BasePage {

	// Inputs
	@FindBy(id = "flights_order_persons_0_firstName")
	private WebElement inputFirstName;

	@FindBy(id = "flights_order_persons_0_lastName")
	private WebElement inputLastName;

	@FindBy(id = "flights_order_contactInfo_name")
	private WebElement inputName;

	@FindBy(id = "flights_order_contactInfo_email")
	private WebElement inputEmailAddress;

	@FindBy(id = "flights_order_contactInfo_phoneNumber")
	private WebElement inputPhoneNumber;

	@FindBy(id = "flights_order_persons_0_birthDate")
	private WebElement inputBirthDate;

	// Checkboxes
	@FindBy(xpath = "//input[@id = 'flights_order_agree']/preceding-sibling::i")
	private WebElement checkboxAcceptRules;

	// Dropdowns
	@FindBy(id = "flights_order_persons_0_gender")
	private WebElement dropdownTitle;

	// Buttons
	@FindBy(xpath = "//button[@type = 'submit']//i[@class = 'fa fa-chevron-right']")
	private WebElement buttonProceesToCheckout;

	@FindBy(xpath = "//div[@class = 'modal-content']//a[contains(@class, 'cancel')]")
	private WebElement buttonThanksButNo;

	@FindBy(xpath = "(//td[@data-handler= 'selectDay'])[1]")
	private WebElement buttonFirstDay;

	public PagePassengerInformation(WebDriver driver) {
		super(driver);
	}

	public void enterName(String name) {

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(inputName));

		inputName.sendKeys(name);

	}

	public void enterEmailAddress(String email) {

		inputEmailAddress.sendKeys(email);

	}

	public void enterPhoneNumber(String phone) {

		inputPhoneNumber.sendKeys(phone);

	}

	public void enterFirstName(String firstName) {

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(inputFirstName));

		inputFirstName.sendKeys(firstName);

	}

	public void enterLastName(String lastName) {

		inputLastName.sendKeys(lastName);

	}

	public void selectTitle(String title) {

		Select select = new Select(dropdownTitle);
		select.selectByValue(title);

	}

	public void clickAcceptRules() {

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

		checkboxAcceptRules.click();

	}

	public void clickProceedToCheckout() {

		buttonProceesToCheckout.click();

	}

	public void clickThanksButNo() {

		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOf(buttonThanksButNo));

		buttonThanksButNo.click();

	}

	public void selectBirthDate() {

		inputBirthDate.click();
		buttonFirstDay.click();

	}

}
